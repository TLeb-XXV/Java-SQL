package TaliaLebano_COMP228TestSummer26;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
public class Main extends JFrame {
	private static final String URL = "jdbc:oracle:thin:@oracle1.centennialcollege.ca:1521:SQLD";
   private static final String USERNAME = "COMP228_M26_sy_21";
   private static final String PASSWORD = "password";
   private JTextField cityTextField;
   private JButton searchButton;
   private JTextArea resultTextArea;
   public Main() {
       setTitle("Student Search");
       setSize(700, 500);
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       setLocationRelativeTo(null);
       setLayout(new BorderLayout());
       JPanel topPanel = new JPanel(new FlowLayout());
       JLabel cityLabel = new JLabel("Enter City:");
       cityTextField = new JTextField(20);
       searchButton = new JButton("Search");
       topPanel.add(cityLabel);
       topPanel.add(cityTextField);
       topPanel.add(searchButton);
       add(topPanel, BorderLayout.NORTH);
      
       resultTextArea = new JTextArea();
       resultTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(resultTextArea);
       add(scrollPane, BorderLayout.CENTER);
       searchButton.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
           	searchStudents();
           }
       });
   }
   private void searchStudents() {
       String city = cityTextField.getText().trim();
       if (city.isEmpty()) {
           resultTextArea.setText("Please enter a city.");
           return;
       }
       String sql =
               "SELECT studentID, firstName, lastName, address, "
               + "city, province, postalCode "
               + "FROM StudentsInformation "
               + "WHERE UPPER(city) = UPPER(?) "
               + "ORDER BY lastName, firstName";
       resultTextArea.setText("");
       try (
           Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
           PreparedStatement statement = connection.prepareStatement(sql))
       {
           statement.setString(1, city);
           ResultSet resultSet = statement.executeQuery();
           resultTextArea.append(
                   "Student ID\tFirst Name\tLast Name\tAddress\t"
                   + "City\tProvince\tPostal Code\n");
           resultTextArea.append(
                   "---------\t----------\t---------\t-------\t"
                   + "----\t--------\t-----------\n");
           boolean found = false;
           while (resultSet.next()) {
               found = true;
               String studentID = resultSet.getString("studentID").trim();
               String firstName = resultSet.getString("firstName");
               String lastName = resultSet.getString("lastName");
               String address = resultSet.getString("address");
               String studentCity = resultSet.getString("city");
               String province = resultSet.getString("province").trim();
               String postalCode = resultSet.getString("postalCode").trim();
               resultTextArea.append(
                       studentID + "\t"
                       + firstName + "\t"
                       + lastName + "\t"
                       + address + "\t"
                       + studentCity + "\t"
                       + province + "\t"
                       + postalCode + "\n"
               );
           }
           if (!found) {
           	resultTextArea.setText("No students were found in " + city + ".");
           }
       } catch (SQLException ex) {
           resultTextArea.setText("Database error:\n" + ex.getMessage());
           ex.printStackTrace();
       }
   }
   public static void main(String[] args) {
       SwingUtilities.invokeLater(new Runnable() {
           @Override
           public void run() {
               Main application = new Main();
               application.setVisible(true);
           }
       });
   }
