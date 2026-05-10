package Bill_Print_DB;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;

public class Inventory_Frame extends JFrame implements ActionListener {

    JTable table;

    DefaultTableModel model;

    JButton btnUpdate;
    JButton btnLowStock;
    JButton btnBack;

    public Inventory_Frame() {

        setTitle("Inventory Management");
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

        JLabel heading = new JLabel("INVENTORY MANAGEMENT");
        heading.setBounds(420,25,600,40);
        heading.setForeground(Color.WHITE);
        heading.setFont(new Font("Segoe UI",Font.BOLD,34));
        top.add(heading);

        // ================= TABLE PANEL =================
        JPanel panel = new JPanel();
        panel.setBounds(50,120,1300,480);
        panel.setLayout(new BorderLayout());
        panel.setBackground(Color.WHITE);
        panel.setBorder(new LineBorder(new Color(220,220,220),2,true));
        add(panel);

        model = new DefaultTableModel();

        model.addColumn("Product ID");
        model.addColumn("Product Name");
        model.addColumn("Stock");
        model.addColumn("Status");

        model.addRow(new Object[]{"101","Rice","120","Available"});
        model.addRow(new Object[]{"102","Milk","10","Low Stock"});
        model.addRow(new Object[]{"103","Coke","75","Available"});
        model.addRow(new Object[]{"104","Bread","5","Low Stock"});
        model.addRow(new Object[]{"105","Soap","90","Available"});

        table = new JTable(model);

        ThemeUtil.styleTable(table);

        JScrollPane sp = new JScrollPane(table);

        panel.add(sp);

        // ================= BUTTONS =================
        btnUpdate = ThemeUtil.createButton("UPDATE STOCK");
        btnUpdate.setBounds(350,640,200,45);
        add(btnUpdate);

        btnLowStock = ThemeUtil.createOrangeButton("LOW STOCK");
        btnLowStock.setBounds(620,640,200,45);
        add(btnLowStock);

        btnBack = ThemeUtil.createOrangeButton("BACK");
        btnBack.setBounds(890,640,200,45);
        add(btnBack);

        // ACTIONS
        btnUpdate.addActionListener(this);
        btnLowStock.addActionListener(this);
        btnBack.addActionListener(this);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==btnUpdate){

            JOptionPane.showMessageDialog(this,
                    "Stock Updated Successfully");
        }

        if(e.getSource()==btnLowStock){

            JOptionPane.showMessageDialog(this,
                    "Displaying Low Stock Products");
        }

        if(e.getSource()==btnBack){

            new Admin_Dashboard_Frame();

            dispose();
        }
    }
}