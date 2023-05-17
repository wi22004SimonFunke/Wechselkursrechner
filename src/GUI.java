import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame {
    private JComboBox<String> baseCurrencyComboBox;
    private JComboBox<String> quoteCurrencyComboBox;
    private JTextField amountTextField;
    private String baseCurrency;
    private String quoteCurrency;
    private double amount;

    public GUI() {
        setTitle("Currency Converter");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // Create and populate the currency dropdown menus
        String[] currencies = {"EUR", "USD", "GBP"};
        baseCurrencyComboBox = new JComboBox<>(currencies);
        quoteCurrencyComboBox = new JComboBox<>(currencies);

        // Create the amount text field
        amountTextField = new JTextField(10);

        // Create the OK button
        JButton okButton = new JButton("OK");
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                baseCurrency = (String) baseCurrencyComboBox.getSelectedItem();
                quoteCurrency = (String) quoteCurrencyComboBox.getSelectedItem();
                amount = Double.parseDouble(amountTextField.getText());

                // Close the window
                dispose();

            }
        });

        // Add components to the frame
        add(new JLabel("Base currency:"));
        add(baseCurrencyComboBox);
        add(new JLabel("Quote currency:"));
        add(quoteCurrencyComboBox);
        add(new JLabel("Amount:"));
        add(amountTextField);
        add(okButton);

        pack();
        setVisible(true);
    }

    public String getBaseCurrency() {

        return baseCurrency;
    }

    public String getQuoteCurrency() {
        return quoteCurrency;
    }

    public double getAmount() {
        return amount;
    }

    RatesFetcher RatesFetcher1 = new RatesFetcher();
    }
