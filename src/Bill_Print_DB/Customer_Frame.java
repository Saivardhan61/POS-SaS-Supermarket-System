package Bill_Print_DB;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Customer_Frame extends JFrame implements ActionListener {

    JTextField txtName, txtPhone, txtEmail;

    JButton btnSave, btnDelete, btnRefresh;

    JTable table;
    DefaultTableModel model;

    Color primary = new Color(34, 139, 34);

    public Customer_Frame() {

        setTitle("Customer Management");

        setSize(1500, 850);

        setLocationRelativeTo(null);

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        setLayout(null);

        getContentPane().setBackground(
                new Color(245, 250, 245));

        // ================= TITLE =================

        JLabel title = new JLabel(
                "Customer Management");

        title.setFont(new Font(
                "Poppins",
                Font.BOLD,
                32));

        title.setBounds(50, 20, 500, 40);

        add(title);

        // ================= INPUT FIELDS =================

        txtName = createField(
                "Customer Name",
                100);

        txtPhone = createField(
                "Phone Number",
                200);

        txtEmail = createField(
                "Email Address",
                300);

        // ================= BUTTONS =================

        btnSave = createButton(
                "SAVE CUSTOMER");

        btnSave.setBounds(
                50,
                430,
                320,
                50);

        add(btnSave);

        btnDelete = createButton(
                "DELETE CUSTOMER");

        btnDelete.setBounds(
                50,
                510,
                320,
                50);

        add(btnDelete);

        btnRefresh = createButton(
                "REFRESH TABLE");

        btnRefresh.setBounds(
                50,
                590,
                320,
                50);

        add(btnRefresh);

        // ================= TABLE =================

        model = new DefaultTableModel(
                new String[]{
                        "ID",
                        "NAME",
                        "PHONE",
                        "EMAIL",
                        "POINTS"
                }, 0);

        table = new JTable(model);

        table.setRowHeight(35);

        table.setFont(
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        15));

        table.getTableHeader().setFont(
                new Font(
                        "Poppins",
                        Font.BOLD,
                        15));

        table.getTableHeader().setBackground(primary);

        table.getTableHeader().setForeground(
                Color.WHITE);

        JScrollPane sp = new JScrollPane(table);

        sp.setBounds(
                450,
                100,
                980,
                620);

        add(sp);

        // ================= ACTIONS =================

        btnSave.addActionListener(this);

        btnDelete.addActionListener(this);

        btnRefresh.addActionListener(this);

        // ================= LOAD DATA =================

        loadCustomers();
    }

    // ================= CREATE FIELD =================

    private JTextField createField(
            String label,
            int y) {

        JLabel lbl = new JLabel(label);

        lbl.setFont(
                new Font(
                        "Poppins",
                        Font.BOLD,
                        16));

        lbl.setBounds(50, y, 250, 30);

        add(lbl);

        JTextField tf = new JTextField();

        tf.setFont(
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        17));

        tf.setBounds(
                50,
                y + 35,
                320,
                45);

        tf.setBorder(new CompoundBorder(
                new LineBorder(
                        new Color(220, 220, 220),
                        2,
                        true),
                new EmptyBorder(
                        5,
                        10,
                        5,
                        10)));

        add(tf);

        return tf;
    }

    // ================= CREATE BUTTON =================

    private JButton createButton(String text) {

        JButton btn = new JButton(text);

        btn.setBackground(primary);

        btn.setForeground(Color.WHITE);

        btn.setFont(
                new Font(
                        "Poppins",
                        Font.BOLD,
                        16));

        btn.setFocusPainted(false);

        btn.setCursor(
                Cursor.getPredefinedCursor(
                        Cursor.HAND_CURSOR));

        return btn;
    }

    // ================= SAVE CUSTOMER =================

    private void saveCustomer() {

        if (txtName.getText().trim().isEmpty()
                || txtPhone.getText().trim().isEmpty()
                || txtEmail.getText().trim().isEmpty()) {

            JOptionPane.showMessageDialog(
                    this,
                    "Please fill all fields");

            return;
        }

        try (
                Connection con = DBUtil.getConnection();

                PreparedStatement ps =
                        con.prepareStatement(
                                "INSERT INTO CUSTOMERS(NAME,PHONE,EMAIL,LOYALTY_POINTS) VALUES(?,?,?,0)")
        ) {

            ps.setString(1, txtName.getText());

            ps.setString(2, txtPhone.getText());

            ps.setString(3, txtEmail.getText());

            ps.executeUpdate();

            JOptionPane.showMessageDialog(
                    this,
                    "Customer Saved Successfully");

            clearFields();

            loadCustomers();

        } catch (Exception ex) {

            ex.printStackTrace();

            JOptionPane.showMessageDialog(
                    this,
                    "Error : " + ex.getMessage());
        }
    }

    // ================= LOAD CUSTOMERS =================

    private void loadCustomers() {

        model.setRowCount(0);

        try (
                Connection con = DBUtil.getConnection();

                PreparedStatement ps =
                        con.prepareStatement(
                                "SELECT * FROM CUSTOMERS");

                ResultSet rs = ps.executeQuery()
        ) {

            while (rs.next()) {

                model.addRow(new Object[]{

                        rs.getInt(1),

                        rs.getString(2),

                        rs.getString(3),

                        rs.getString(4),

                        rs.getInt(5)
                });
            }

        } catch (Exception ex) {

            ex.printStackTrace();
        }
    }

    // ================= DELETE CUSTOMER =================

    private void deleteCustomer() {

        int row = table.getSelectedRow();

        if (row < 0) {

            JOptionPane.showMessageDialog(
                    this,
                    "Please select customer");

            return;
        }

        int id = Integer.parseInt(
                model.getValueAt(row, 0).toString());

        try (
                Connection con = DBUtil.getConnection();

                PreparedStatement ps =
                        con.prepareStatement(
                                "DELETE FROM CUSTOMERS WHERE ID=?")
        ) {

            ps.setInt(1, id);

            ps.executeUpdate();

            JOptionPane.showMessageDialog(
                    this,
                    "Customer Deleted");

            loadCustomers();

        } catch (Exception ex) {

            ex.printStackTrace();
        }
    }

    // ================= CLEAR FIELDS =================

    private void clearFields() {

        txtName.setText("");

        txtPhone.setText("");

        txtEmail.setText("");
    }

    // ================= ACTION EVENTS =================

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == btnSave) {

            saveCustomer();
        }

        if (e.getSource() == btnDelete) {

            deleteCustomer();
        }

        if (e.getSource() == btnRefresh) {

            loadCustomers();
        }
    }
}