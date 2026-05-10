package Bill_Print_DB;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

public class Agent_Register_Frame extends JFrame implements ActionListener {

    JTextField txtName, txtEmail, txtPhone;

    JPasswordField txtPass;

    JComboBox<String> cmbRole;

    JButton btnRegister, btnBack;

    public Agent_Register_Frame() {

        setTitle("User Registration");
        setSize(1400,750);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        getContentPane().setBackground(ThemeUtil.BG);

        // LEFT
        JPanel left = new JPanel();
        left.setBounds(0,0,650,750);
        left.setBackground(ThemeUtil.PRIMARY);
        left.setLayout(null);
        add(left);

        JLabel titleLeft = new JLabel("REGISTER");
        titleLeft.setBounds(150,160,400,60);
        titleLeft.setForeground(Color.WHITE);
        titleLeft.setFont(new Font("Segoe UI",Font.BOLD,58));
        left.add(titleLeft);

        JLabel sub = new JLabel("Create Supermarket Account");
        sub.setBounds(120,250,420,40);
        sub.setForeground(Color.WHITE);
        sub.setFont(new Font("Segoe UI",Font.PLAIN,28));
        left.add(sub);

        // RIGHT CARD
        JPanel card = new JPanel();
        card.setBounds(760,70,500,580);
        card.setLayout(null);
        card.setBackground(Color.WHITE);
        card.setBorder(new LineBorder(new Color(220,220,220),2,true));
        add(card);

        JLabel title = ThemeUtil.createTitle("User Registration");
        title.setBounds(100,30,350,40);
        card.add(title);

        JLabel l1 = new JLabel("Full Name");
        l1.setBounds(50,100,150,30);
        l1.setFont(new Font("Segoe UI",Font.BOLD,16));
        card.add(l1);

        txtName = ThemeUtil.createField();
        txtName.setBounds(50,135,360,45);
        card.add(txtName);

        JLabel l2 = new JLabel("Email");
        l2.setBounds(50,190,150,30);
        l2.setFont(new Font("Segoe UI",Font.BOLD,16));
        card.add(l2);

        txtEmail = ThemeUtil.createField();
        txtEmail.setBounds(50,225,360,45);
        card.add(txtEmail);

        JLabel l3 = new JLabel("Phone");
        l3.setBounds(50,280,150,30);
        l3.setFont(new Font("Segoe UI",Font.BOLD,16));
        card.add(l3);

        txtPhone = ThemeUtil.createField();
        txtPhone.setBounds(50,315,360,45);
        card.add(txtPhone);

        JLabel l4 = new JLabel("Password");
        l4.setBounds(50,370,150,30);
        l4.setFont(new Font("Segoe UI",Font.BOLD,16));
        card.add(l4);

        txtPass = new JPasswordField();
        txtPass.setBounds(50,405,360,45);

        txtPass.setBorder(BorderFactory.createCompoundBorder(
                new LineBorder(new Color(220,220,220),1,true),
                new EmptyBorder(10,10,10,10)));

        txtPass.setFont(new Font("Segoe UI",Font.PLAIN,16));

        card.add(txtPass);

        JLabel l5 = new JLabel("Role");
        l5.setBounds(50,460,150,30);
        l5.setFont(new Font("Segoe UI",Font.BOLD,16));
        card.add(l5);

        cmbRole = new JComboBox<>(new String[]{
                "Cashier",
                "Billing Executive",
                "Stock Manager"
        });

        cmbRole.setBounds(50,495,360,45);
        cmbRole.setFont(new Font("Segoe UI",Font.PLAIN,16));

        card.add(cmbRole);

        btnRegister = ThemeUtil.createButton("REGISTER");
        btnRegister.setBounds(50,545,150,45);
        card.add(btnRegister);

        btnBack = ThemeUtil.createOrangeButton("BACK");
        btnBack.setBounds(260,545,150,45);
        card.add(btnBack);

        btnRegister.addActionListener(this);
        btnBack.addActionListener(this);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==btnRegister){

            JOptionPane.showMessageDialog(this,
                    "Registration Successful");
        }

        if(e.getSource()==btnBack){

            new Mainapp();

            dispose();
        }
    }
}