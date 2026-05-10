package Bill_Print_DB;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Employee_Dashboard_Frame extends JFrame
        implements ActionListener {

    JButton btnBilling;
    JButton btnInventory;
    JButton btnLogout;

    String username;

    Color primary = new Color(34, 139, 34);

    public Employee_Dashboard_Frame(String username) {

        this.username = username;

        setTitle("Employee Dashboard");

        setSize(1400, 800);

        setLocationRelativeTo(null);

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setLayout(null);

        getContentPane().setBackground(
                new Color(245, 250, 245));

        // ================= TITLE =================

        JLabel title = new JLabel(
                "Welcome " + username);

        title.setFont(new Font("Poppins",
                Font.BOLD, 34));

        title.setBounds(50, 40, 500, 40);

        add(title);

        JLabel sub = new JLabel(
                "SAS Supermarket Employee Dashboard");

        sub.setFont(new Font("Segoe UI",
                Font.PLAIN, 18));

        sub.setBounds(50, 90, 500, 30);

        add(sub);

        // ================= BUTTONS =================

        btnBilling = createButton("OPEN POS BILLING");

        btnBilling.setBounds(120, 220, 320, 120);

        add(btnBilling);

        btnInventory = createButton("VIEW INVENTORY");

        btnInventory.setBounds(520, 220, 320, 120);

        add(btnInventory);

        btnLogout = createButton("LOGOUT");

        btnLogout.setBounds(920, 220, 320, 120);

        add(btnLogout);

        btnBilling.addActionListener(this);

        btnInventory.addActionListener(this);

        btnLogout.addActionListener(this);
    }

    // ================= BUTTON =================

    private JButton createButton(String text) {

        JButton btn = new JButton(text);

        btn.setBackground(primary);

        btn.setForeground(Color.WHITE);

        btn.setFont(new Font("Poppins",
                Font.BOLD, 20));

        btn.setFocusPainted(false);

        btn.setCursor(
                Cursor.getPredefinedCursor(
                        Cursor.HAND_CURSOR));

        return btn;
    }

 // ================= ACTIONS =================

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == btnBilling) {

            new POS_Billing_Frame().setVisible(true);
        }

        if (e.getSource() == btnInventory) {

            new Inventory_Frame().setVisible(true);
        }

        if (e.getSource() == btnLogout) {

            new Mainapp().setVisible(true);

            dispose();
        }
    }
    }