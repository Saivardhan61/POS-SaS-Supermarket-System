package Bill_Print_DB;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

public class Add_Product_Frame extends JFrame implements ActionListener {

    JTextField txtId;
    JTextField txtName;
    JTextField txtPrice;
    JTextField txtQty;

    JComboBox<String> cmbCategory;

    JButton btnAdd;
    JButton btnClear;
    JButton btnBack;

    public Add_Product_Frame() {

        setTitle("Add Product");
        setSize(1400,750);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        getContentPane().setBackground(ThemeUtil.BG);

        // TOP PANEL
        JPanel top = new JPanel();
        top.setBounds(0,0,1400,90);
        top.setBackground(ThemeUtil.PRIMARY);
        top.setLayout(null);
        add(top);

        JLabel heading = new JLabel("ADD PRODUCT");
        heading.setBounds(530,25,400,40);
        heading.setForeground(Color.WHITE);
        heading.setFont(new Font("Segoe UI",Font.BOLD,34));
        top.add(heading);

        // FORM CARD
        JPanel card = new JPanel();
        card.setBounds(400,130,600,500);
        card.setBackground(Color.WHITE);
        card.setLayout(null);
        card.setBorder(new LineBorder(new Color(220,220,220),2,true));
        add(card);

        // PRODUCT ID
        JLabel l1 = new JLabel("Product ID");
        l1.setBounds(60,50,150,30);
        l1.setFont(new Font("Segoe UI",Font.BOLD,18));
        card.add(l1);

        txtId = ThemeUtil.createField();
        txtId.setBounds(240,50,280,45);
        card.add(txtId);

        // PRODUCT NAME
        JLabel l2 = new JLabel("Product Name");
        l2.setBounds(60,120,150,30);
        l2.setFont(new Font("Segoe UI",Font.BOLD,18));
        card.add(l2);

        txtName = ThemeUtil.createField();
        txtName.setBounds(240,120,280,45);
        card.add(txtName);

        // CATEGORY
        JLabel l3 = new JLabel("Category");
        l3.setBounds(60,190,150,30);
        l3.setFont(new Font("Segoe UI",Font.BOLD,18));
        card.add(l3);

        cmbCategory = new JComboBox<>(new String[]{
                "Groceries",
                "Snacks",
                "Beverages",
                "Vegetables",
                "Dairy Products"
        });

        cmbCategory.setBounds(240,190,280,45);
        cmbCategory.setFont(new Font("Segoe UI",Font.PLAIN,16));

        card.add(cmbCategory);

        // PRICE
        JLabel l4 = new JLabel("Price");
        l4.setBounds(60,260,150,30);
        l4.setFont(new Font("Segoe UI",Font.BOLD,18));
        card.add(l4);

        txtPrice = ThemeUtil.createField();
        txtPrice.setBounds(240,260,280,45);
        card.add(txtPrice);

        // QUANTITY
        JLabel l5 = new JLabel("Quantity");
        l5.setBounds(60,330,150,30);
        l5.setFont(new Font("Segoe UI",Font.BOLD,18));
        card.add(l5);

        txtQty = ThemeUtil.createField();
        txtQty.setBounds(240,330,280,45);
        card.add(txtQty);

        // BUTTONS
        btnAdd = ThemeUtil.createButton("ADD PRODUCT");
        btnAdd.setBounds(60,420,150,45);
        card.add(btnAdd);

        btnClear = ThemeUtil.createOrangeButton("CLEAR");
        btnClear.setBounds(230,420,130,45);
        card.add(btnClear);

        btnBack = ThemeUtil.createOrangeButton("BACK");
        btnBack.setBounds(390,420,130,45);
        card.add(btnBack);

        btnAdd.addActionListener(this);
        btnClear.addActionListener(this);
        btnBack.addActionListener(this);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==btnAdd){

            JOptionPane.showMessageDialog(this,
                    "Product Added Successfully");
        }

        if(e.getSource()==btnClear){

            txtId.setText("");
            txtName.setText("");
            txtPrice.setText("");
            txtQty.setText("");
        }

        if(e.getSource()==btnBack){

            new Admin_Dashboard_Frame();

            dispose();
        }
    }
}