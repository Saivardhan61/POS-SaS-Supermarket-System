package Bill_Print_DB;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;

public class POS_Billing_Frame extends JFrame implements ActionListener {

    JTextField txtProduct;
    JTextField txtPrice;
    JTextField txtQty;

    JLabel lblTotal;

    JTable table;

    DefaultTableModel model;

    JButton btnAdd;
    JButton btnRemove;
    JButton btnPrint;
    JButton btnBack;

    double grandTotal = 0;

    public POS_Billing_Frame() {

        setTitle("Billing System");
        setSize(1400,750);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        getContentPane().setBackground(ThemeUtil.BG);

        // ================= TOP =================
        JPanel top = new JPanel();
        top.setBounds(0,0,1400,90);
        top.setBackground(ThemeUtil.PRIMARY);
        top.setLayout(null);
        add(top);

        JLabel heading = new JLabel("SUPERMARKET BILLING");
        heading.setBounds(430,25,500,40);
        heading.setForeground(Color.WHITE);
        heading.setFont(new Font("Segoe UI",Font.BOLD,34));
        top.add(heading);

        // ================= LEFT FORM =================
        JPanel form = new JPanel();
        form.setBounds(40,130,350,520);
        form.setBackground(Color.WHITE);
        form.setLayout(null);
        form.setBorder(new LineBorder(new Color(220,220,220),2,true));
        add(form);

        JLabel l1 = new JLabel("Product Name");
        l1.setBounds(30,40,150,30);
        l1.setFont(new Font("Segoe UI",Font.BOLD,18));
        form.add(l1);

        txtProduct = ThemeUtil.createField();
        txtProduct.setBounds(30,75,270,40);
        form.add(txtProduct);

        JLabel l2 = new JLabel("Price");
        l2.setBounds(30,140,150,30);
        l2.setFont(new Font("Segoe UI",Font.BOLD,18));
        form.add(l2);

        txtPrice = ThemeUtil.createField();
        txtPrice.setBounds(30,175,270,40);
        form.add(txtPrice);

        JLabel l3 = new JLabel("Quantity");
        l3.setBounds(30,240,150,30);
        l3.setFont(new Font("Segoe UI",Font.BOLD,18));
        form.add(l3);

        txtQty = ThemeUtil.createField();
        txtQty.setBounds(30,275,270,40);
        form.add(txtQty);

        btnAdd = ThemeUtil.createButton("ADD TO CART");
        btnAdd.setBounds(30,360,270,45);
        form.add(btnAdd);

        btnRemove = ThemeUtil.createOrangeButton("REMOVE ITEM");
        btnRemove.setBounds(30,425,270,45);
        form.add(btnRemove);

        // ================= TABLE =================
        JPanel tablePanel = new JPanel();
        tablePanel.setBounds(430,130,900,420);
        tablePanel.setBackground(Color.WHITE);
        tablePanel.setLayout(new BorderLayout());
        tablePanel.setBorder(new LineBorder(new Color(220,220,220),2,true));
        add(tablePanel);

        model = new DefaultTableModel();

        model.addColumn("Product");
        model.addColumn("Price");
        model.addColumn("Quantity");
        model.addColumn("Total");

        table = new JTable(model);

        ThemeUtil.styleTable(table);

        JScrollPane sp = new JScrollPane(table);

        tablePanel.add(sp);

        // ================= BOTTOM BILL PANEL =================
        JPanel bottom = new JPanel();
        bottom.setBounds(430,580,900,90);
        bottom.setBackground(Color.WHITE);
        bottom.setLayout(null);
        bottom.setBorder(new LineBorder(new Color(220,220,220),2,true));
        add(bottom);

        JLabel totalText = new JLabel("Grand Total : ");
        totalText.setBounds(40,25,220,40);
        totalText.setFont(new Font("Segoe UI",Font.BOLD,28));
        totalText.setForeground(ThemeUtil.PRIMARY);
        bottom.add(totalText);

        lblTotal = new JLabel("₹ 0");
        lblTotal.setBounds(270,25,220,40);
        lblTotal.setFont(new Font("Segoe UI",Font.BOLD,30));
        lblTotal.setForeground(ThemeUtil.SECONDARY);
        bottom.add(lblTotal);

        btnPrint = ThemeUtil.createButton("PRINT BILL");
        btnPrint.setBounds(560,22,140,45);
        bottom.add(btnPrint);

        btnBack = ThemeUtil.createOrangeButton("BACK");
        btnBack.setBounds(740,22,120,45);
        bottom.add(btnBack);

        // ACTIONS
        btnAdd.addActionListener(this);
        btnRemove.addActionListener(this);
        btnPrint.addActionListener(this);
        btnBack.addActionListener(this);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==btnAdd){

            String product = txtProduct.getText();

            double price = Double.parseDouble(txtPrice.getText());

            int qty = Integer.parseInt(txtQty.getText());

            double total = price * qty;

            grandTotal += total;

            model.addRow(new Object[]{
                    product,
                    price,
                    qty,
                    total
            });

            lblTotal.setText("₹ " + grandTotal);

            txtProduct.setText("");
            txtPrice.setText("");
            txtQty.setText("");
        }

        if(e.getSource()==btnRemove){

            int row = table.getSelectedRow();

            if(row >= 0){

                double total = Double.parseDouble(
                        model.getValueAt(row,3).toString());

                grandTotal -= total;

                lblTotal.setText("₹ " + grandTotal);

                model.removeRow(row);
            }
        }

        if(e.getSource()==btnPrint){

            new Receipt_Print_Frame(grandTotal);
        }

        if(e.getSource()==btnBack){

            new Admin_Dashboard_Frame();

            dispose();
        }
    }
}