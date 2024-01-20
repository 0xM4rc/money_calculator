package software.ulpgc.moneycalculator.swing;

import software.ulpgc.moneycalculator.CurrencyDialog;
import software.ulpgc.moneycalculator.MoneyDialog;
import software.ulpgc.moneycalculator.MoneyDisplay;
import software.ulpgc.moneycalculator.control.Command;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class MainFrame extends JFrame {

    private MoneyDialog moneyDialog;
    private CurrencyDialog currencyDialog;
    private MoneyDisplay moneyDisplay;
    private Map<String, Command> commands = new HashMap<>();

    public MainFrame() throws HeadlessException {
        this.setTitle("Money Calculator");
        this.setSize(600, 400);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(4, 1, 10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        mainPanel.add(createMoneyDialogPanel());
        mainPanel.add(createCurrencyDialogPanel());
        mainPanel.add(createMoneyDisplayPanel());

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(createCalculateButton());

        this.add(mainPanel, BorderLayout.CENTER);
        this.add(buttonPanel, BorderLayout.SOUTH);
    }

    private JPanel createMoneyDialogPanel() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel.add(new JLabel("Amount: "));
        panel.add(createMoneyDialog());
        return panel;
    }

    private JPanel createCurrencyDialogPanel() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel.add(new JLabel("Currency: "));
        panel.add(createCurrencyDialog());
        return panel;
    }

    private JPanel createMoneyDisplayPanel() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel.add(new JLabel("Result: "));
        panel.add(createMoneyDisplay());
        return panel;
    }

    private Component createCalculateButton() {
        JButton button = new JButton("Exchange");
        customButton(button);
        button.addActionListener(e -> commands.get("exchange").execute());
        return button;
    }

    private void customButton(JButton button) {
        button.setBackground(new Color(50, 120, 220));
        button.setForeground(Color.WHITE);
        button.setFont(new Font("Arial", Font.PLAIN, 14));
        button.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
    }

    private Component createMoneyDisplay() {
        SwingMoneyDisplay display = new SwingMoneyDisplay();
        this.moneyDisplay = display;
        return display;
    }

    private Component createCurrencyDialog() {
        SwingCurrencyDialog dialog = new SwingCurrencyDialog();
        this.currencyDialog = dialog;
        return dialog;
    }

    private Component createMoneyDialog() {
        SwingMoneyDialog dialog = new SwingMoneyDialog();
        this.moneyDialog = dialog;
        return dialog;
    }

    public MoneyDialog getMoneyDialog() {
        return moneyDialog;
    }

    public CurrencyDialog getCurrencyDialog() {
        return currencyDialog;
    }

    public MoneyDisplay getMoneyDisplay() {
        return moneyDisplay;
    }

    public void add(String name, Command command) {
        commands.put(name, command);
    }
}

