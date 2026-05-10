package Bill_Print_DB;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Receipt_Print_Frame extends JFrame implements ActionListener {

    JTextArea receiptArea;

    JButton btnPrint;
    JButton btnClose;

    double total;

    public Receipt_Print_Frame(double grandTotal) {

        this.total = grandTotal;

        setTitle("Print Receipt");
        setSize(1400,750);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        getContentPane().setBackground(ThemeUtil.BG);

        // ================= TOP PANEL =================
        JPanel top = new JPanel();
        top.setBounds(0,0,1400,90);
        top.setBackground(ThemeUtil.PRIMARY);
        top.setLayout(null);
        add(top);

        JLabel heading = new JLabel("CUSTOMER RECEIPT");
        heading.setBounds(470,25,500,40);
        heading.setForeground(Color.WHITE);
        heading.setFont(new Font("Segoe UI",Font.BOLD,34));
        top.add(heading);

        // ================= RECEIPT PANEL =================
        JPanel panel = new JPanel();
        panel.setBounds(370,120,650,500);
        panel.setLayout(new BorderLayout());
        panel.setBackground(Color.WHITE);
        panel.setBorder(new LineBorder(new Color(220,220,220),2,true));
        add(panel);

        receiptArea = new JTextArea();

        receiptArea.setFont(new Font("Monospaced",Font.PLAIN,18));

        receiptArea.setEditable(false);

        generateReceipt();

        JScrollPane sp = new JScrollPane(receiptArea);

        panel.add(sp);

        // ================= BUTTONS =================
        btnPrint = ThemeUtil.createButton("PRINT");
        btnPrint.setBounds(470,650,170,45);
        add(btnPrint);

        btnClose = ThemeUtil.createOrangeButton("CLOSE");
        btnClose.setBounds(740,650,170,45);
        add(btnClose);

        btnPrint.addActionListener(this);
        btnClose.addActionListener(this);

        setVisible(true);
    }

    // ================= RECEIPT CONTENT =================
    void generateReceipt() {

        SimpleDateFormat sdf =
                new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

        Date d = new Date();

        receiptArea.append("\n");
        receiptArea.append("====================================\n");
        receiptArea.append("        SAS SUPERMARKET POS         \n");
        receiptArea.append("====================================\n\n");

        receiptArea.append("Date : " + sdf.format(d) + "\n\n");

        receiptArea.append("------------------------------------\n");

        receiptArea.append("Thank You For Shopping!\n");

        receiptArea.append("------------------------------------\n\n");

        receiptArea.append("Grand Total : ₹ " + total + "\n\n");

        receiptArea.append("GST Included\n\n");

        receiptArea.append("Visit Again!\n\n");

        receiptArea.append("====================================\n");
    }

    // ================= ACTIONS =================
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==btnPrint){

            JOptionPane.showMessageDialog(this,
                    "Receipt Printed Successfully");
        }

        if(e.getSource()==btnClose){

            dispose();
        }
    }
}