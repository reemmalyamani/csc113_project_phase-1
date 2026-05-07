import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.LinkedList;

public class BakeryOrderGUI extends JFrame implements ActionListener {

    private JTextField customerField;
    private JTextField cakeField;
    private JTextField sizeField;

    private JTextArea orderArea;

    private JButton addButton;
    private JButton finishButton;
    private JButton clearButton;

    private LinkedList<String> orderList;

    private double total;

    public BakeryOrderGUI() {

        total = 0;

        orderList = new LinkedList<String>();

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

        JLabel sizeLabel = new JLabel("Cake Size:");

        contentPane.add(sizeLabel);

        sizeField = new JTextField();

        sizeField.setColumns(20);

        contentPane.add(sizeField);

        addButton = new JButton("ADD CAKE");

        finishButton = new JButton("FINISH ORDER");

        clearButton = new JButton("CLEAR");

        contentPane.add(addButton);

        contentPane.add(finishButton);

        contentPane.add(clearButton);

        orderArea = new JTextArea();

        orderArea.setRows(8);

        orderArea.setColumns(30);

        orderArea.setEditable(false);

        contentPane.add(orderArea);

        addButton.addActionListener(this);

        finishButton.addActionListener(this);

        clearButton.addActionListener(this);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent event) {

        if(event.getSource() == addButton) {

            addCake();
        }

        else if(event.getSource() == finishButton) {

            finishOrder();
        }

        else if(event.getSource() == clearButton) {

            clearFields();
        }
    }

    private void addCake() {

        String cakeName = cakeField.getText();

        String size = sizeField.getText();

        if(cakeName.equals("") || size.equals("")) {

            JOptionPane.showMessageDialog(null,
                    "Please enter cake type and size.");

            return;
        }

        double price = 0;

        if(cakeName.equalsIgnoreCase("Chocolate")) {

            if(size.equalsIgnoreCase("Small"))

                price = 25;

            else if(size.equalsIgnoreCase("Medium"))

                price = 35;

            else if(size.equalsIgnoreCase("Large"))

                price = 45;
        }

        else if(cakeName.equalsIgnoreCase("Vanilla")) {

            if(size.equalsIgnoreCase("Small"))

                price = 20;

            else if(size.equalsIgnoreCase("Medium"))

                price = 30;

            else if(size.equalsIgnoreCase("Large"))

                price = 40;
        }

        else if(cakeName.equalsIgnoreCase("Redvelvet")) {

            if(size.equalsIgnoreCase("Small"))

                price = 35;

            else if(size.equalsIgnoreCase("Medium"))

                price = 45;

            else if(size.equalsIgnoreCase("Large"))

                price = 55;
        }

        else {

            JOptionPane.showMessageDialog(null,
                    "Invalid cake type.");

            return;
        }

        if(price == 0) {

            JOptionPane.showMessageDialog(null,
                    "Invalid size.");

            return;
        }

        String cakeInfo = cakeName + " "
                + size + " - "
                + price + " SAR";

        orderList.add(cakeInfo);

        total += price;

        orderArea.append(cakeInfo + "\n");

        cakeField.setText("");

        sizeField.setText("");
    }

    private void finishOrder() {

        String customerName = customerField.getText();

        if(customerName.equals("")) {

            JOptionPane.showMessageDialog(null,
                    "Please enter customer name.");

            return;
        }

        if(orderList.isEmpty()) {

            JOptionPane.showMessageDialog(null,
                    "Please add at least one cake.");

            return;
        }

        ResultFrame resultFrame =
                new ResultFrame(customerName,
                        orderList,
                        total);

        resultFrame.setVisible(true);
    }

    private void clearFields() {

        customerField.setText("");

        cakeField.setText("");

        sizeField.setText("");

        orderArea.setText("");

        orderList.clear();

        total = 0;
    }

    public static void main(String[] args) {

        new BakeryOrderGUI();
    }
}
