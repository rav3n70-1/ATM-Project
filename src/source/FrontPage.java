package source;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FrontPage extends JFrame implements ActionListener {
    private JButton loginButton, signupButton;
    private JLabel lblNewLabel;

    public FrontPage() {
    	setResizable(false);
    	setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\DCL\\Downloads\\—Pngtree—skull funky style vector illustration_5538823.png"));
        setTitle("Front Page");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(new BorderLayout());

        JPanel centerPanel = new JPanel();
        centerPanel.setBackground(new Color(255, 255, 255));
        getContentPane().add(centerPanel, BorderLayout.CENTER);

        loginButton = new JButton("Login");
        loginButton.setBounds(245, 142, 91, 32);
        loginButton.setForeground(new Color(0, 0, 0));
        loginButton.setBackground(new Color(255, 255, 255));
        loginButton.addActionListener(this);
        centerPanel.setLayout(null);
        centerPanel.add(loginButton);
        
        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 235, 261);
        panel.setBackground(Color.LIGHT_GRAY);
        centerPanel.add(panel);
        panel.setLayout(null);
        
        JLabel lblNewLabel_1 = new JLabel("ATM System by Rav3n");
        lblNewLabel_1.setFont(new Font("Viner Hand ITC", Font.PLAIN, 10));
        lblNewLabel_1.setBounds(0, 247, 117, 14);
        panel.add(lblNewLabel_1);
        
        JLabel lblNewLabel_3 = new JLabel("It's your money.");
        lblNewLabel_3.setBounds(69, 114, 102, 14);
        panel.add(lblNewLabel_3);
        
        JLabel lblNewLabel_4 = new JLabel("Rav3n Bank");
        lblNewLabel_4.setBounds(69, 30, 87, 14);
        panel.add(lblNewLabel_4);
        
        JPanel panel_1 = new JPanel();
        panel_1.setBackground(new Color(128, 128, 255));
        panel_1.setBounds(234, 0, 250, 261);
        centerPanel.add(panel_1);
        panel_1.setLayout(null);
        
        lblNewLabel = new JLabel("Welcome");
        lblNewLabel.setBounds(46, 25, 146, 22);
        panel_1.add(lblNewLabel);
        lblNewLabel.setForeground(new Color(64, 0, 64));
        lblNewLabel.setFont(new Font("Engravers MT", Font.BOLD | Font.ITALIC, 20));
        
                signupButton = new JButton("Signup");
                signupButton.setBounds(149, 141, 91, 32);
                panel_1.add(signupButton);
                signupButton.setBackground(new Color(255, 255, 255));
                
                JLabel lblNewLabel_2 = new JLabel("ATM");
                lblNewLabel_2.setBounds(96, 67, 64, 37);
                panel_1.add(lblNewLabel_2);
                lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 30));
                signupButton.addActionListener(this);

        setVisible(true);
    }

    
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton) {
            dispose(); 
            new LoginPage();
        } else if (e.getSource() == signupButton) {
            dispose(); 
            new SignupPage();
        }
    }

    public static void main(String[] args) {
        new FrontPage();
    }
}
