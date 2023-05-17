import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuiAmountAsker {
    private JFrame frame;
    private JComboBox<String> dropdownMenu1;
    private JComboBox<String> dropdownMenu2;
    private JLabel selectionLabel1;
    private JLabel selectionLabel2;
    private JButton okButton;
    private String[] selectedEntries;

    public void DropdownMenuExample() {
        createGUI();
    }

    public void createGUI() {
        // Create the frame
        frame = new JFrame("Dropdown Menu Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);

        // Create the dropdown menus
        String[] menuItems = {"EUR", "USD", "GBP"};
        dropdownMenu1 = new JComboBox<>(menuItems);
        dropdownMenu1.setSelectedIndex(0); // Set the default selection

        dropdownMenu2 = new JComboBox<>(menuItems);
        dropdownMenu2.setSelectedIndex(0); // Set the default selection

        // Create the labels to display the selected items
        selectionLabel1 = new JLabel("Selected Item 1: " + dropdownMenu1.getSelectedItem());
        selectionLabel2 = new JLabel("Selected Item 2: " + dropdownMenu2.getSelectedItem());

        // Create the OK button
        okButton = new JButton("OK");
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get the selected entries and store them
                String selectedEntry1 = (String) dropdownMenu1.getSelectedItem();
                String selectedEntry2 = (String) dropdownMenu2.getSelectedItem();
                selectedEntries = new String[]{selectedEntry1, selectedEntry2};

                // Close the frame
                frame.dispose();
            }
        });

        // Create a panel and add the dropdown menus, labels, and OK button to it
        JPanel panel = new JPanel();
        panel.add(dropdownMenu1);
        panel.add(selectionLabel1);
        panel.add(dropdownMenu2);
        panel.add(selectionLabel2);
        panel.add(okButton);

        // Add the panel to the frame
        frame.add(panel);
    }

    public String[] showGUIAndWait() {
        SwingUtilities.invokeLater(() -> {
            frame.setVisible(true);
        });

        // Wait for the user to press the OK button
        synchronized (this) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Return the selected entries
        return selectedEntries;
    }

}
