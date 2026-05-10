package Bill_Print_DB;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

public class Agent_Login_Frame extends JFrame implements ActionListener {

    JTextField txtUser;
    JPasswordField txtPass;

    JComboBox<String> cmbRole;

    JButton btnLogin, btnBack;

    public Agent_Login_Frame() {

        setTitle("User Login");
        setSize(1400,750);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        getContentPane().setBackground(ThemeUtil.BG);

        // LEFT
        JPanel left = new JPanel();
        left.setBounds(0,0,650,750);
        left.setBackground(ThemeUtil.SECONDARY);
        left.setLayout(null);
        add(left);

        JLabel titleLeft = new JLabel("USER LOGIN");
        titleLeft.setBounds(140,180,400,60);
        titleLeft.setForeground(Color.WHITE);
        titleLeft.setFont(new Font("Segoe UI",Font.BOLD,55));
        left.add(titleLeft);

        JLabel sub = new JLabel("Cashier & Billing Access");
        sub.setBounds(150,260,400,40);
        sub.setForeground(Color.WHITE);
        sub.setFont(new Font("Segoe UI",Font.PLAIN,28));
        left.add(sub);

        // RIGHT CARD
        JPanel card = new JPanel();
        card.setBounds(780,120,450,470);
        card.setBackground(Color.WHITE);
        card.setLayout(null);
        card.setBorder(new LineBorder(new Color(220,220,220),2,true));
        add(card);

        JLabel title = ThemeUtil.createTitle("Login");
        title.setBounds(160,40,200,40);
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

        txtPass.setFont(new Font("Segoe UI",Font.PLAIN,16));

        txtPass.setBorder(BorderFactory.createCompoundBorder(
                new LineBorder(new Color(220,220,220),1,true),
                new EmptyBorder(10,10,10,10)));

        card.add(txtPass);

        JLabel l3 = new JLabel("Select Role");
        l3.setBounds(50,320,120,30);
        l3.setFont(new Font("Segoe UI",Font.BOLD,16));
        card.add(l3);

        cmbRole = new JComboBox<>(new String[]{
                "Cashier",
                "Billing Executive",
                "Stock Manager"
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

            JOptionPane.showMessageDialog(this,
                    "User Login Successful");

            new POS_Billing_Frame();

            dispose();
        }

        if(e.getSource()==btnBack){

            new Mainapp();

            dispose();
        }
    }
}