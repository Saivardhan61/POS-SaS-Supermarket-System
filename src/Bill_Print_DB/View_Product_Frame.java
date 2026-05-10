package Bill_Print_DB;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;

public class View_Product_Frame extends JFrame implements ActionListener {

    JTable table;

    DefaultTableModel model;

    JTextField txtSearch;

    JButton btnSearch, btnRefresh, btnBack;

    public View_Product_Frame() {

        setTitle("View Products");
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

        JLabel heading = new JLabel("VIEW PRODUCTS");
        heading.setBounds(500,25,400,40);
        heading.setForeground(Color.WHITE);
        heading.setFont(new Font("Segoe UI",Font.BOLD,34));
        top.add(heading);

        // ================= SEARCH PANEL =================
        JPanel searchPanel = new JPanel();
        searchPanel.setBounds(50,120,1300,80);
        searchPanel.setBackground(Color.WHITE);
        searchPanel.setLayout(null);
        searchPanel.setBorder(new LineBorder(new Color(220,220,220),2,true));
        add(searchPanel);

        JLabel lblSearch = new JLabel("Search Product");
        lblSearch.setBounds(30,25,160,30);
        lblSearch.setFont(new Font("Segoe UI",Font.BOLD,18));
        searchPanel.add(lblSearch);

        txtSearch = ThemeUtil.createField();
        txtSearch.setBounds(190,20,350,40);
        searchPanel.add(txtSearch);

        btnSearch = ThemeUtil.createButton("SEARCH");
        btnSearch.setBounds(580,20,130,40);
        searchPanel.add(btnSearch);

        btnRefresh = ThemeUtil.createOrangeButton("REFRESH");
        btnRefresh.setBounds(740,20,130,40);
        searchPanel.add(btnRefresh);

        btnBack = ThemeUtil.createOrangeButton("BACK");
        btnBack.setBounds(900,20,130,40);
        searchPanel.add(btnBack);

        // ================= TABLE PANEL =================
        JPanel tablePanel = new JPanel();
        tablePanel.setBounds(50,230,1300,450);
        tablePanel.setLayout(new BorderLayout());
        tablePanel.setBackground(Color.WHITE);
        tablePanel.setBorder(new LineBorder(new Color(220,220,220),2,true));
        add(tablePanel);

        // TABLE MODEL
        model = new DefaultTableModel();

        model.addColumn("Product ID");
        model.addColumn("Product Name");
        model.addColumn("Category");
        model.addColumn("Price");
        model.addColumn("Quantity");

        // SAMPLE DATA
        model.addRow(new Object[]{"101","Rice","Groceries","50","120"});
        model.addRow(new Object[]{"102","Coke","Beverages","40","60"});
        model.addRow(new Object[]{"103","Milk","Dairy","30","90"});
        model.addRow(new Object[]{"104","Chips","Snacks","20","150"});
        model.addRow(new Object[]{"105","Tomato","Vegetables","25","80"});

        table = new JTable(model);

        ThemeUtil.styleTable(table);

        JScrollPane sp = new JScrollPane(table);

        tablePanel.add(sp);

        // ACTIONS
        btnSearch.addActionListener(this);
        btnRefresh.addActionListener(this);
        btnBack.addActionListener(this);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==btnSearch){

            String search = txtSearch.getText();

            JOptionPane.showMessageDialog(this,
                    "Searching : " + search);
        }

        if(e.getSource()==btnRefresh){

            txtSearch.setText("");

            JOptionPane.showMessageDialog(this,
                    "Table Refreshed");
        }

        if(e.getSource()==btnBack){

            new Admin_Dashboard_Frame();

            dispose();
        }
    }
}