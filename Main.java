//Task 3 Atm Withdrawal
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
class Account {
    private double balance;
    public Account(double initialBalance) {
        this.balance = initialBalance;
    }
    public double getBalance() {
        return balance;
    }
    public void deposit(double amount) {
        balance += amount;
    }
    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true;
        }
        return false;
    }
}
class ATMGUI extends JFrame {
    private Account account;
    private JTextField amountField;
    private JTextArea resultArea;

    public ATMGUI(Account account) {
        this.account = account;
        initialize();
    }
    private void initialize() {
        setTitle("ATM");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        add(panel);
        placeComponents(panel);

        setVisible(true);
    }
    private void placeComponents(JPanel panel) {
        panel.setLayout(null);

        JLabel label = new JLabel("Amount:");
        label.setBounds(10, 20, 80, 25);
        panel.add(label);

        amountField = new JTextField(20);
        amountField.setBounds(100, 20, 165, 25);
        panel.add(amountField);

        JButton checkButton = new JButton("Check");
        checkButton.setBounds(10, 60, 150, 25);
        panel.add(checkButton);

        JButton depositButton = new JButton("Deposit");
        depositButton.setBounds(10, 90, 150, 25);
        panel.add(depositButton);

        JButton withdrawButton = new JButton("Withdraw");
        withdrawButton.setBounds(10, 120, 150, 25);
        panel.add(withdrawButton);
        resultArea = new JTextArea();
        resultArea.setBounds(10, 160, 300, 80);
        resultArea.setEditable(false);
        panel.add(resultArea);
        checkButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                check();
            }
        });
        depositButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                deposit();
            }
        });
        withdrawButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                withdraw();
            }
        });
    }
    private void check() {
        double balance = account.getBalance();
        resultArea.setText("Balance: $" + balance);
    }
    private void deposit() {
        try {
            double amount = Double.parseDouble(amountField.getText());
            account.deposit(amount);
            resultArea.setText("Deposit successful. New balance: $" + account.getBalance());
        } catch (NumberFormatException ex) {
            resultArea.setText("Invalid amount. Enter a valid number.");
        }
    }
    private void withdraw() {
        try {
            double amount = Double.parseDouble(amountField.getText());
            if (account.withdraw(amount)) {
                resultArea.setText("Withdrawal successful. New balance: $" + account.getBalance());
            } else {
                resultArea.setText("Insufficient funds or invalid amount. Try again.");
            }
        } catch (NumberFormatException ex) {
            resultArea.setText("Invalid amount. Enter a valid number.");
        }
    }
}
public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Account account = new Account(1000);
            new ATMGUI(account);
        });
    }
}
