package Bill_Print_DB;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

public class Reports_Frame extends JFrame implements ActionListener {

    JButton btnSales;
    JButton btnProfit;
    JButton btnStock;
    JButton btnBack;

    JTextArea reportArea;

    public Reports_Frame() {

        setTitle("Reports");
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

        JLabel heading = new JLabel("REPORTS & ANALYTICS");
        heading.setBounds(450,25,500,40);
        heading.setForeground(Color.WHITE);
        heading.setFont(new Font("Segoe UI",Font.BOLD,34));
        top.add(heading);

        // ================= LEFT PANEL =================
        JPanel left = new JPanel();
        left.setBounds(40,130,300,520);
        left.setBackground(Color.WHITE);
        left.setLayout(null);
        left.setBorder(new LineBorder(new Color(220,220,220),2,true));
        add(left);

        JLabel menu = new JLabel("Reports Menu");
        menu.setBounds(60,40,200,40);
        menu.setFont(new Font("Segoe UI",Font.BOLD,28));
        menu.setForeground(ThemeUtil.PRIMARY);
        left.add(menu);

        btnSales = ThemeUtil.createButton("SALES REPORT");
        btnSales.setBounds(40,120,210,45);
        left.add(btnSales);

        btnProfit = ThemeUtil.createButton("PROFIT REPORT");
        btnProfit.setBounds(40,200,210,45);
        left.add(btnProfit);

        btnStock = ThemeUtil.createOrangeButton("STOCK REPORT");
        btnStock.setBounds(40,280,210,45);
        left.add(btnStock);

        btnBack = ThemeUtil.createOrangeButton("BACK");
        btnBack.setBounds(40,380,210,45);
        left.add(btnBack);

        // ================= REPORT AREA =================
        JPanel right = new JPanel();
        right.setBounds(390,130,940,520);
        right.setBackground(Color.WHITE);
        right.setLayout(new BorderLayout());
        right.setBorder(new LineBorder(new Color(220,220,220),2,true));
        add(right);

        reportArea = new JTextArea();

        reportArea.setFont(new Font("Monospaced",Font.PLAIN,18));

        reportArea.setEditable(false);

        JScrollPane sp = new JScrollPane(reportArea);

        right.add(sp);

        // ACTIONS
        btnSales.addActionListener(this);
        btnProfit.addActionListener(this);
        btnStock.addActionListener(this);
        btnBack.addActionListener(this);

        setVisible(true);
    }

    // ================= ACTIONS =================
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==btnSales){

            reportArea.setText("");

            reportArea.append("\n========== SALES REPORT ==========\n\n");

            reportArea.append("Today's Sales      : ₹ 45,000\n");
            reportArea.append("Weekly Sales       : ₹ 2,80,000\n");
            reportArea.append("Monthly Sales      : ₹ 9,50,000\n");

            reportArea.append("\n==================================\n");
        }

        if(e.getSource()==btnProfit){

            reportArea.setText("");

            reportArea.append("\n========== PROFIT REPORT ==========\n\n");

            reportArea.append("Today's Profit     : ₹ 8,000\n");
            reportArea.append("Weekly Profit      : ₹ 48,000\n");
            reportArea.append("Monthly Profit     : ₹ 1,90,000\n");

            reportArea.append("\n===================================\n");
        }

        if(e.getSource()==btnStock){

            reportArea.setText("");

            reportArea.append("\n========== STOCK REPORT ==========\n\n");

            reportArea.append("Available Products : 1200\n");
            reportArea.append("Low Stock Items    : 18\n");
            reportArea.append("Out of Stock       : 4\n");

            reportArea.append("\n==================================\n");
        }

        if(e.getSource()==btnBack){

            new Admin_Dashboard_Frame();

            dispose();
        }
    }
}