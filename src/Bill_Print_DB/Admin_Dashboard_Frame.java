package Bill_Print_DB;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

public class Admin_Dashboard_Frame extends JFrame implements ActionListener {

    JButton addProductBtn;
    JButton viewProductBtn;
    JButton billingBtn;
    JButton inventoryBtn;
    JButton reportsBtn;
    JButton logoutBtn;

    JPanel contentPanel;

    public Admin_Dashboard_Frame() {

        setTitle("Admin Dashboard");
        setSize(1400,750);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        getContentPane().setBackground(ThemeUtil.BG);

        // ================= SIDEBAR =================
        JPanel sidebar = new JPanel();
        sidebar.setBounds(0,0,300,750);
        sidebar.setBackground(ThemeUtil.PRIMARY);
        sidebar.setLayout(null);
        add(sidebar);

        JLabel logo = new JLabel("SAS POS");
        logo.setBounds(60,40,250,50);
        logo.setForeground(Color.WHITE);
        logo.setFont(new Font("Segoe UI",Font.BOLD,34));
        sidebar.add(logo);

        JLabel role = new JLabel("Administrator");
        role.setBounds(70,90,180,30);
        role.setForeground(Color.WHITE);
        role.setFont(new Font("Segoe UI",Font.PLAIN,20));
        sidebar.add(role);

        addProductBtn = createMenuButton("ADD PRODUCT",150);
        viewProductBtn = createMenuButton("VIEW PRODUCTS",230);
        billingBtn = createMenuButton("BILLING",310);
        inventoryBtn = createMenuButton("INVENTORY",390);
        reportsBtn = createMenuButton("REPORTS",470);
        logoutBtn = createLogoutButton("LOGOUT",570);

        sidebar.add(addProductBtn);
        sidebar.add(viewProductBtn);
        sidebar.add(billingBtn);
        sidebar.add(inventoryBtn);
        sidebar.add(reportsBtn);
        sidebar.add(logoutBtn);

        // ================= TOP BAR =================
        JPanel topbar = new JPanel();
        topbar.setBounds(300,0,1100,90);
        topbar.setBackground(Color.WHITE);
        topbar.setLayout(null);
        topbar.setBorder(new MatteBorder(0,0,1,0,new Color(220,220,220)));
        add(topbar);

        JLabel heading = new JLabel("SUPERMARKET DASHBOARD");
        heading.setBounds(40,25,500,40);
        heading.setFont(new Font("Segoe UI",Font.BOLD,30));
        heading.setForeground(ThemeUtil.PRIMARY);
        topbar.add(heading);

        // ================= MAIN CONTENT =================
        contentPanel = new JPanel();
        contentPanel.setBounds(330,120,1030,560);
        contentPanel.setBackground(ThemeUtil.BG);
        contentPanel.setLayout(null);
        add(contentPanel);

        // CARDS
        addDashboardCard("Total Products","150+",50,50);
        addDashboardCard("Today's Sales","₹ 45,000",380,50);
        addDashboardCard("Total Bills","520",710,50);

        addDashboardCard("Inventory Stock","1200",50,280);
        addDashboardCard("Employees","15",380,280);
        addDashboardCard("Customers","340",710,280);

        // ACTIONS
        addProductBtn.addActionListener(this);
        viewProductBtn.addActionListener(this);
        billingBtn.addActionListener(this);
        inventoryBtn.addActionListener(this);
        reportsBtn.addActionListener(this);
        logoutBtn.addActionListener(this);

        setVisible(true);
    }

    // ================= MENU BUTTON =================
    JButton createMenuButton(String text,int y){

        JButton btn = new JButton(text);

        btn.setBounds(30,y,240,55);

        btn.setBackground(Color.WHITE);
        btn.setForeground(ThemeUtil.PRIMARY);

        btn.setFont(new Font("Segoe UI",Font.BOLD,16));

        btn.setFocusPainted(false);

        btn.setBorder(new LineBorder(Color.WHITE,2,true));

        btn.setCursor(new Cursor(Cursor.HAND_CURSOR));

        return btn;
    }

    // ================= LOGOUT BUTTON =================
    JButton createLogoutButton(String text,int y){

        JButton btn = new JButton(text);

        btn.setBounds(30,y,240,55);

        btn.setBackground(ThemeUtil.SECONDARY);
        btn.setForeground(Color.WHITE);

        btn.setFont(new Font("Segoe UI",Font.BOLD,16));

        btn.setFocusPainted(false);

        btn.setBorderPainted(false);

        return btn;
    }

    // ================= DASHBOARD CARDS =================
    void addDashboardCard(String title,String value,int x,int y){

        JPanel card = new JPanel();

        card.setBounds(x,y,280,180);

        card.setLayout(null);

        card.setBackground(Color.WHITE);

        card.setBorder(new LineBorder(new Color(220,220,220),2,true));

        contentPanel.add(card);

        JLabel t = new JLabel(title);
        t.setBounds(30,35,220,30);

        t.setForeground(Color.GRAY);

        t.setFont(new Font("Segoe UI",Font.BOLD,20));

        card.add(t);

        JLabel v = new JLabel(value);
        v.setBounds(30,85,220,45);

        v.setForeground(ThemeUtil.PRIMARY);

        v.setFont(new Font("Segoe UI",Font.BOLD,36));

        card.add(v);
    }

    // ================= ACTIONS =================
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==addProductBtn){

            new Add_Product_Frame();
        }

        if(e.getSource()==viewProductBtn){

            new View_Product_Frame();
        }

        if(e.getSource()==billingBtn){

            new POS_Billing_Frame();
        }

        if(e.getSource()==inventoryBtn){

            new Inventory_Frame();
        }

        if(e.getSource()==reportsBtn){

            new Reports_Frame();
        }

        if(e.getSource()==logoutBtn){

            new Mainapp();

            dispose();
        }
    }
}