import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.LinkedList;

public class BakeryOrderGUI extends JFrame implements ActionListener { // input frame: lets user enter the order details

    private JTextField customerField; // user entries
    private JTextField cakeField;
    private JTextField priceField;

    private JTextArea orderArea; //  displays cakes already added
    // BUTTONS HERE:
    private JButton addButton; 
    private JButton finishButton; // opens results frame
    private JButton clearButton; 

    // LINKED LIST SHOULD GO HERE !!!!!!!!!!!!!!!!!!!!
    private double total;

    public BakeryOrderGUI() {
        // use new and create linked list inside the constructor
        total = 0;

        Container contentPane = getContentPane();
        contentPane.setLayout(new FlowLayout());

        setTitle("Bakery Order Input");
        setSize(400, 350);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JLabel customerLabel = new JLabel("Customer Name:");
        contentPane.add(customerLabel);

        customerField = new JTextField();
        customerField.setColumns(20);
        contentPane.add(customerField);

        JLabel cakeLabel = new JLabel("Cake Type:");
        contentPane.add(cakeLabel);

        cakeField = new JTextField();
        cakeField.setColumns(20);
        contentPane.add(cakeField);

        JLabel priceLabel = new JLabel("Cake Price:");
        contentPane.add(priceLabel);
        // price label and field
        priceField = new JTextField();
        priceField.setColumns(20);
        contentPane.add(priceField);
        //buttons here
      
        addButton = new JButton("ADD CAKE");
        finishButton = new JButton("FINISH ORDER");
        clearButton = new JButton("CLEAR");

        contentPane.add(addButton);
        contentPane.add(finishButton);
        contentPane.add(clearButton);
        // create display box
        orderArea = new JTextArea();
        orderArea.setRows(8);
        orderArea.setColumns(30);
        orderArea.setEditable(false);
        contentPane.add(orderArea);
      // IMPORTANT: register event listeners
        addButton.addActionListener(this);
        finishButton.addActionListener(this);
        clearButton.addActionListener(this);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent event) { // action performed method
        if (event.getSource() == addButton) {
            addCake();
        } else if (event.getSource() == finishButton) {
            finishOrder();
        } else if (event.getSource() == clearButton) {
            clearFields();
        }
    }

    private void addCake() {
        try {
            String cakeName = cakeField.getText();
            double price = Double.parseDouble(priceField.getText());

            if (cakeName.equals("")) {
                JOptionPane.showMessageDialog(null, "Please enter cake type.");
                return;
            }

            if (price < 0) {
                throw new IllegalArgumentException("Price cannot be negative.");
            }

            String cakeInfo = cakeName + " - " + price + " SAR";

            orderList.add(cakeInfo);
            total = total + price;

            orderArea.append(cakeInfo + "\n");

            cakeField.setText("");
            priceField.setText("");
// validate user input
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Please enter a valid number for price.");
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    private void finishOrder() {
        String customerName = customerField.getText();

        if (customerName.equals("")) {
            JOptionPane.showMessageDialog(null, "Please enter customer name.");
            return;
        }

        if (orderList.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please add at least one cake.");
            return;
        }

        ResultFrame resultFrame = new ResultFrame(customerName, orderList, total);
        resultFrame.setVisible(true);
    }

    private void clearFields() {
        customerField.setText("");
        cakeField.setText("");
        priceField.setText("");
        orderArea.setText("");
        orderList.clear();
        total = 0;
    }

    public static void main(String[] args) {
        new BakeryOrderGUI();
    }
}
