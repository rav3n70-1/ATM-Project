package source;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

@SuppressWarnings("serial")
public class atm_info extends JFrame {

    private JLabel welcomeLabel;
    private JLabel balanceLabel;
    private JTextField amountField;
    private JButton withdrawBtn;
    private JButton depositBtn;
    private JButton checkBalanceBtn;
    private JButton fastCashBtn;
    private JButton miniStatementBtn;

    private double balance;
    private ArrayList<String> transactions;

    public atm_info() {
    	setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\DCL\\Downloads\\—Pngtree—skull funky style vector illustration_5538823.png"));
    	setBackground(new Color(131, 142, 131));
    	setResizable(false);
        setTitle("ATM System by Rav3n");
        setSize(396, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        balance = 50000.0;
        transactions = new ArrayList<>();

        JPanel panel = new JPanel();
        panel.setBackground(new Color(255, 255, 255));
                panel.setLayout(null);
                welcomeLabel = new JLabel("Welcome to the ATM");
                welcomeLabel.setBounds(111, 25, 166, 22);
                welcomeLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
                panel.add(welcomeLabel);
        balanceLabel = new JLabel("Current balance:         Tk. 50000.0");
        balanceLabel.setBounds(104, 85, 208, 14);
        balanceLabel.setFont(new Font("Microsoft YaHei", Font.BOLD, 11));
        balanceLabel.setForeground(new Color(0, 0, 0));
        panel.add(balanceLabel);
        amountField = new JTextField(10);
        amountField.setBounds(150, 121, 162, 20);
        amountField.setBackground(new Color(255, 255, 255));
        panel.add(amountField);
        withdrawBtn = new JButton("Withdraw");
        withdrawBtn.setForeground(Color.BLACK);
        withdrawBtn.setBounds(82, 152, 101, 23);
        withdrawBtn.setBackground(Color.MAGENTA);
        withdrawBtn.addActionListener(new ActionListener() {
            
			public void actionPerformed(ActionEvent e) {
                String amountStr = amountField.getText();
                if (amountStr.isEmpty()) {
                    JOptionPane.showMessageDialog(atm_info.this, "Please enter an amount", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                double amount = Double.parseDouble(amountStr);
                if (amount > balance) {
                    JOptionPane.showMessageDialog(atm_info.this, "Insufficient funds", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    balance -= amount;
                    transactions.add("Withdrawal of Tk." + amount);
                    updateBalanceLabel();
                }
            }
        });
        panel.add(withdrawBtn);
        depositBtn = new JButton("Deposit");
        depositBtn.setBounds(238, 152, 101, 23);
        depositBtn.setBackground(new Color(128, 128, 192));
        depositBtn.addActionListener(new ActionListener() {
            
			public void actionPerformed(ActionEvent e) {
                String amountStr = amountField.getText();
                if (amountStr.isEmpty()) {
                    JOptionPane.showMessageDialog(atm_info.this, "Please enter an amount", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                double amount = Double.parseDouble(amountStr);
                balance += amount;
                transactions.add("Deposit of Tk." + amount);
                updateBalanceLabel();
            }
        });
        panel.add(depositBtn);
        checkBalanceBtn = new JButton("Check Balance");
        checkBalanceBtn.setBounds(68, 186, 126, 23);
        checkBalanceBtn.setBackground(new Color(255, 255, 255));
        checkBalanceBtn.addActionListener(new ActionListener() {
            
			public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(atm_info.this, "Current balance: Tk. " + balance);
            }
        });
        panel.add(checkBalanceBtn);
        fastCashBtn = new JButton("Fast Cash");
        fastCashBtn.setBounds(236, 186, 103, 23);
        fastCashBtn.setBackground(new Color(255, 255, 255));
        fastCashBtn.addActionListener(new ActionListener() {
            
			public void actionPerformed(ActionEvent e) {
                Object[] options = {"Tk. 500", "Tk. 1000", "Tk. 5000", "Cancel"};
                int choice = JOptionPane.showOptionDialog(atm_info.this, "Select an amount", "Fast Cash",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
                        null, options, options[3]);
                switch (choice) {
                    case 0:
                        withdraw(500);
                        break;
                    case 1:
                    	withdraw(1000);
                        break;
                    case 2:
                        withdraw(5000);
                        break;
                    default:
                        
                }
            }
        });
        panel.add(fastCashBtn);
        miniStatementBtn = new JButton("Mini Statement");
        miniStatementBtn.setBounds(140, 212, 137, 23);
        miniStatementBtn.setBackground(new Color(255, 255, 255));
        miniStatementBtn.addActionListener(new ActionListener() {
            
			public void actionPerformed(ActionEvent e) {
                StringBuilder sb = new StringBuilder();
                for (String transaction : transactions) {
                    sb.append(transaction).append("\n");
                }
                JOptionPane.showMessageDialog(atm_info.this, sb.toString(), "Mini Statement", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        panel.add(miniStatementBtn);

        setContentPane(panel);

        JLabel lblNewLabel = new JLabel("Enter the amount");
        lblNewLabel.setBounds(25, 121, 115, 14);
        lblNewLabel.setForeground(Color.BLACK);
        panel.add(lblNewLabel);
        
        JPanel panel_1 = new JPanel();
        panel_1.setBounds(0, 0, 208, 141);
        panel_1.setBackground(new Color(128, 128, 192));
        panel.add(panel_1);
        panel_1.setLayout(null);
        
        JPanel panel_1_1 = new JPanel();
        panel_1_1.setLayout(null);
        panel_1_1.setBackground(new Color(0, 255, 255));
        panel_1_1.setBounds(172, 121, 208, 141);
        panel.add(panel_1_1);
        
        JPanel panel_2 = new JPanel();
        panel_2.setBackground(new Color(128, 128, 255));
        panel_2.setBounds(0, 141, 172, 121);
        panel.add(panel_2);
        
        JPanel panel_2_1 = new JPanel();
        panel_2_1.setBackground(Color.MAGENTA);
        panel_2_1.setBounds(208, 0, 172, 121);
        panel.add(panel_2_1);
    }

    private void withdraw(double amount) {
        if (amount > balance) {
            JOptionPane.showMessageDialog(this, "Insufficient funds", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            balance -= amount;
            transactions.add("Withdrawal of Tk." + amount);
            updateBalanceLabel();
        }
    }

    private void updateBalanceLabel() {
        balanceLabel.setText("Current balance: Tk." + balance);
    }

    public static void main(String[] args) {
        atm_info frontPage = new atm_info();
        frontPage.setVisible(true);
    }
	public JLabel getBalanceLabel() {
		return balanceLabel;
	}
    }
