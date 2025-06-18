package source;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class LoginPage extends JFrame implements ActionListener {

    private JLabel usernameLabel, passwordLabel;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;

    public LoginPage() {
    	setResizable(false);
    	getContentPane().setBackground(new Color(255, 255, 255));
        setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\DCL\\Downloads\\—Pngtree—skull funky style vector illustration_5538823.png"));
        setTitle("Login Page");
        setSize(500, 300);//Doya kore keu copy korben na....
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        usernameLabel = new JLabel("Username:");
        usernameLabel.setBounds(38, 63, 95, 27);
        getContentPane().add(usernameLabel);

        usernameField = new JTextField();
        usernameField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        usernameField.setBounds(173, 63, 171, 27);
        getContentPane().add(usernameField);

        passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(38, 116, 105, 27);
        getContentPane().add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(173, 116, 171, 27);
        getContentPane().add(passwordField);//221-15-5910

        loginButton = new JButton("Login");
        loginButton.setBounds(183, 175, 128, 54);
        loginButton.addActionListener(this);
        getContentPane().add(loginButton);
        
        JLabel lblNewLabel = new JLabel("Please   Login");
        lblNewLabel.setFont(new Font("Arial", lblNewLabel.getFont().getStyle() | Font.BOLD, lblNewLabel.getFont().getSize() + 8));
        lblNewLabel.setBounds(173, 11, 138, 27);
        getContentPane().add(lblNewLabel);
        
        JPanel panel = new JPanel();
        panel.setBackground(new Color(0, 128, 192));
        panel.setBounds(0, 0, 246, 261);
        getContentPane().add(panel);
        
        JPanel panel_1 = new JPanel();
        panel_1.setBackground(new Color(128, 0, 255));
        panel_1.setBounds(245, 0, 239, 261);
        getContentPane().add(panel_1);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());

        try {

            Connection cn = sqlConnection.ConnectorDb();

            PreparedStatement stmt = cn.prepareStatement(
                "SELECT * FROM users WHERE username = ? AND password = ?"
            );
            stmt.setString(1, username);
            stmt.setString(2, password);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                JOptionPane.showMessageDialog(
                    this,
                    "Login Successful!",
                    "Success",
                    JOptionPane.INFORMATION_MESSAGE
                );

                dispose(); 
                new atm_info().setVisible(true);
            } else {
                JOptionPane.showMessageDialog(
                    this,
                    "Invalid Username or Password",
                    "Error",
                    JOptionPane.ERROR_MESSAGE
                );
            }

            rs.close();
            stmt.close();
            cn.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(
                this,
                "Error connecting to database",
                "Error",
                JOptionPane.ERROR_MESSAGE
            );
        }
    }
}
