package Bill_Print_DB;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Payment_Frame extends JFrame implements ActionListener {

    JTextField txtTotal;
    JTextField txtPaid;

    JLabel lblBalance;

    JButton btnCalculate;

    Color primary = new Color(34, 139, 34);

    public Payment_Frame() {

        setTitle("Payment");

        setSize(700, 500);

        setLocationRelativeTo(null);

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        setLayout(null);

        getContentPane().setBackground(new Color(245, 250, 245));

        // ================= TITLE =================

        JLabel title = new JLabel("Payment Gateway");

        title.setFont(new Font("Poppins", Font.BOLD, 30));

        title.setBounds(190, 30, 400, 40);

        add(title);

        // ================= TOTAL =================

        JLabel lbl1 = new JLabel("Bill Amount");

        lbl1.setFont(new Font("Poppins", Font.BOLD, 16));

        lbl1.setBounds(100, 120, 200, 30);

        add(lbl1);

        txtTotal = new JTextField();

        txtTotal.setBounds(100, 155, 450, 45);

        txtTotal.setFont(new Font("Segoe UI", Font.PLAIN, 18));

        add(txtTotal);

        // ================= PAID =================

        JLabel lbl2 = new JLabel("Paid Amount");

        lbl2.setFont(new Font("Poppins", Font.BOLD, 16));

        lbl2.setBounds(100, 240, 200, 30);

        add(lbl2);

        txtPaid = new JTextField();

        txtPaid.setBounds(100, 275, 450, 45);

        txtPaid.setFont(new Font("Segoe UI", Font.PLAIN, 18));

        add(txtPaid);

        // ================= BUTTON =================

        btnCalculate = new JButton("CALCULATE CHANGE");

        btnCalculate.setBounds(170, 360, 320, 50);

        btnCalculate.setBackground(primary);

        btnCalculate.setForeground(Color.WHITE);

        btnCalculate.setFont(new Font("Poppins", Font.BOLD, 18));

        btnCalculate.setFocusPainted(false);

        add(btnCalculate);

        // ================= RESULT =================

        lblBalance = new JLabel("Balance : ₹0");

        lblBalance.setFont(new Font("Poppins", Font.BOLD, 26));

        lblBalance.setBounds(220, 425, 300, 35);

        add(lblBalance);

        btnCalculate.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        try {

            double total =
                    Double.parseDouble(txtTotal.getText());

            double paid =
                    Double.parseDouble(txtPaid.getText());

            double balance = paid - total;

            lblBalance.setText(
                    "Balance : ₹" + balance);

            JOptionPane.showMessageDialog(this,
                    "Payment Successful");

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(this,
                    "Enter valid amount");
        }
    }
}