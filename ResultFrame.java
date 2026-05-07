import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.LinkedList;

public class ResultFrame extends JFrame implements ActionListener {

    private JTextArea resultArea;
    private JButton closeButton;

    
     public ResultFrame(String customerName, LinkedList<String> orderList, double total) {
        Container contentPane = getContentPane();
        contentPane.setLayout(new FlowLayout());
        // Frame settings
        setTitle("Order Result");
        setSize(350, 350);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE); // when user closes this frame, ony this pne closes  and the input frame stays open

        resultArea = new JTextArea();
        resultArea.setRows(12);
        resultArea.setColumns(28);
        resultArea.setEditable(false); // this means the user cannot type inside the recipt area

        String receipt = "Customer: " + customerName + "\n"; // recipt 
        receipt = receipt + "------------------------\n";

       for(int i = 0; i < orderList.size(); i++) {

    receipt = receipt + orderList.get(i) + "\n";
}

        receipt = receipt + "------------------------\n";
        receipt = receipt + "Total: " + total + " SAR\n"; // calculate total

        resultArea.setText(receipt);

        contentPane.add(resultArea);

        closeButton = new JButton("CLOSE");
        contentPane.add(closeButton);

        closeButton.addActionListener(this);
    }

    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == closeButton) {
            dispose();
        }
    }
}
