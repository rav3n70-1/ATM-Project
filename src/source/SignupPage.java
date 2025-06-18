package source;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;

@SuppressWarnings("serial")
public class SignupPage extends JFrame implements ActionListener {
    private JLabel nameLabel, phoneLabel, usernameLabel, emailLabel, passwordLabel, retypePasswordLabel;
    private JTextField txtname, txtnumber, txtusername, txtemail;
    private JPasswordField txtpassword, retypePasswordField;
    private JButton signupButton;
    Connection cn = null;
    java.sql.PreparedStatement ps = null;
    public SignupPage() {
    	getContentPane().setBackground(new Color(255, 255, 255));
    	cn = sqlConnection.ConnectorDb();
    	setResizable(false);
    	setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\DCL\\Downloads\\—Pngtree—skull funky style vector illustration_5538823.png"));
        setTitle("Signup Page");
        setSize(500, 319);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        nameLabel = new JLabel("Name:");
        nameLabel.setBounds(10, 17, 142, 26);
        nameLabel.setForeground(new Color(0, 0, 0));
        getContentPane().add(nameLabel);

        txtname = new JTextField();
        txtname.setBounds(162, 17, 195, 26);
        getContentPane().add(txtname);

        phoneLabel = new JLabel("Phone Number:");
        phoneLabel.setBounds(10, 54, 142, 26);
        getContentPane().add(phoneLabel);

        txtnumber = new JTextField();
        txtnumber.setBounds(162, 54, 195, 26);
        getContentPane().add(txtnumber);
        
        usernameLabel = new JLabel("Username");
        usernameLabel.setBounds(10, 91, 142, 26);
        getContentPane().add(usernameLabel);

        txtusername = new JTextField();
        txtusername.setBounds(162, 91, 195, 26);
        getContentPane().add(txtusername);

        emailLabel = new JLabel("Email:");
        emailLabel.setBounds(10, 128, 142, 26);
        getContentPane().add(emailLabel);

        txtemail = new JTextField();
        txtemail.setBounds(162, 128, 195, 26);
        getContentPane().add(txtemail); //221-15-5910

        passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(10, 165, 142, 26);
        getContentPane().add(passwordLabel);

        txtpassword = new JPasswordField();
        txtpassword.setBounds(162, 165, 195, 26);
        getContentPane().add(txtpassword);

        retypePasswordLabel = new JLabel("Retype Password:");
        retypePasswordLabel.setBounds(10, 202, 142, 26);
        getContentPane().add(retypePasswordLabel);

        retypePasswordField = new JPasswordField();
        retypePasswordField.setBounds(162, 202, 195, 26);
        getContentPane().add(retypePasswordField);

        signupButton = new JButton("Signup");
        signupButton.setBounds(150, 239, 142, 26);
        signupButton.addActionListener(this);//Doya kore keu copy korben na....
        getContentPane().add(signupButton);
        
        JButton btnNewButton = new JButton("Login");
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		 new LoginPage().setVisible(true);
        		
        	}
        });
        btnNewButton.setBounds(385, 241, 89, 23);
        getContentPane().add(btnNewButton);
        
        JPanel panel = new JPanel();
        panel.setBackground(Color.CYAN);
        panel.setBounds(0, 0, 484, 280);
        getContentPane().add(panel);

        setVisible(true);
    }
    public void actionPerformed(ActionEvent e) {
        String name = txtname.getText();
        String phone = txtnumber.getText();
        String username = txtusername.getText();
        String email = txtemail.getText();
        String password = new String(txtpassword.getPassword());
        @SuppressWarnings("unused")
		String retypePassword = new String(retypePasswordField.getPassword());
        
        String sql = "INSERT INTO singup (Name, Phone, Username, Email, Password) VALUES ( ?, ?, ?, ?, ?)";
        
try {
            
           ps = cn.prepareStatement(sql);
            ps.setString(1,name);
            ps.setString(2,phone);
            ps.setString(3,username);
            ps.setString(4,email);
            ps.setString(5,password);
            ps.execute();
            System.out.println("Data insert successfull");
            JOptionPane.showMessageDialog(
                    this,
                    "Singup Successful!",
                    "Success",
                    JOptionPane.INFORMATION_MESSAGE);
        }
        
catch (Exception e1) {
	
	System.out.println("Data not inserted");
}
        
//        System.out.println("Name = " +name);
//        System.out.println("Phone = " +phone);
//        System.out.println("Username = " +username);
//        System.out.println("Email = " +email);
//        System.out.println("Password = " +password);
        

    }
    }