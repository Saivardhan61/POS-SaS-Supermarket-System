package Bill_Print_DB;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

public class Admin_Login_Frame extends JFrame implements ActionListener {

    JTextField txtUser;
    JPasswordField txtPass;

    JComboBox<String> cmbRole;

    JButton btnLogin, btnBack;

    public Admin_Login_Frame() {

        setTitle("Admin Login");
        setSize(1400,750);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        getContentPane().setBackground(ThemeUtil.BG);

        // LEFT PANEL
        JPanel left = new JPanel();
        left.setBounds(0,0,650,750);
        left.setBackground(ThemeUtil.PRIMARY);
        left.setLayout(null);
        add(left);

        JLabel logo = new JLabel("ADMIN");
        logo.setBounds(180,180,400,70);
        logo.setForeground(Color.WHITE);
        logo.setFont(new Font("Segoe UI",Font.BOLD,55));
        left.add(logo);

        JLabel sub = new JLabel("Supermarket Management");
        sub.setBounds(150,270,400,40);
        sub.setForeground(Color.WHITE);
        sub.setFont(new Font("Segoe UI",Font.PLAIN,28));
        left.add(sub);

        // RIGHT PANEL
        JPanel card = new JPanel();
        card.setBounds(780,120,450,470);
        card.setLayout(null);
        card.setBackground(Color.WHITE);
        card.setBorder(new LineBorder(new Color(220,220,220),2,true));
        add(card);

        JLabel title = ThemeUtil.createTitle("Admin Login");
        title.setBounds(120,40,250,40);
        card.add(title);

        JLabel l1 = new JLabel("Username");
        l1.setBounds(50,120,120,30);
        l1.setFont(new Font("Segoe UI",Font.BOLD,16));
        card.add(l1);

        txtUser = ThemeUtil.createField();
        txtUser.setBounds(50,155,330,45);
        card.add(txtUser);

        JLabel l2 = new JLabel("Password");
        l2.setBounds(50,220,120,30);
        l2.setFont(new Font("Segoe UI",Font.BOLD,16));
        card.add(l2);

        txtPass = new JPasswordField();
        txtPass.setBounds(50,255,330,45);

        txtPass.setBorder(BorderFactory.createCompoundBorder(
                new LineBorder(new Color(220,220,220),1,true),
                new EmptyBorder(10,10,10,10)));

        txtPass.setFont(new Font("Segoe UI",Font.PLAIN,16));

        card.add(txtPass);

        JLabel l3 = new JLabel("Role");
        l3.setBounds(50,320,120,30);
        l3.setFont(new Font("Segoe UI",Font.BOLD,16));
        card.add(l3);

        cmbRole = new JComboBox<>(new String[]{
                "Admin",
                "Manager",
                "Supervisor"
        });

        cmbRole.setBounds(50,355,330,45);
        cmbRole.setFont(new Font("Segoe UI",Font.PLAIN,16));
        card.add(cmbRole);

        btnLogin = ThemeUtil.createButton("LOGIN");
        btnLogin.setBounds(50,420,150,45);
        card.add(btnLogin);

        btnBack = ThemeUtil.createOrangeButton("BACK");
        btnBack.setBounds(230,420,150,45);
        card.add(btnBack);

        btnLogin.addActionListener(this);
        btnBack.addActionListener(this);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==btnLogin){

            String u = txtUser.getText();
            String p = txtPass.getText();

            if(u.equals("admin") && p.equals("admin")){

                JOptionPane.showMessageDialog(this,
                        "Login Successful");

                new Admin_Dashboard_Frame();

                dispose();

            } else {

                JOptionPane.showMessageDialog(this,
                        "Invalid Username or Password");
            }
        }

        if(e.getSource()==btnBack){

            new Mainapp();

            dispose();
        }
    }
}