package Bill_Print_DB;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class Mainapp extends JFrame implements ActionListener {

    JButton b1, b2, b3, b4;
    JLabel logoLabel, titleLabel, subtitleLabel;

    Color primaryGreen = new Color(34, 139, 34);
    Color orange = new Color(255, 140, 0);
    Color darkText = new Color(40, 40, 40);

    public Mainapp() {

        setTitle("SAS Supermarket POS");
        setSize(1400, 750);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setContentPane(new WatermarkPanel());
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.insets = new Insets(10, 0, 10, 0);

        // ================= MAIN CARD =================

        JPanel card = new JPanel();
        card.setPreferredSize(new Dimension(520, 580));
        card.setBackground(Color.WHITE);
        card.setLayout(null);

        card.setBorder(new CompoundBorder(
                new LineBorder(new Color(220,220,220),2,true),
                new EmptyBorder(20,20,20,20)));

        // ================= LOGO =================

        ImageIcon logoIcon = new ImageIcon(
                "C:\\Eclicps\\AdvanceJava\\SuperMarket_checkout_system\\assets\\Sas_market.png");

        Image scaledLogo = logoIcon.getImage()
                .getScaledInstance(230, 120, Image.SCALE_SMOOTH);

        logoLabel = new JLabel(new ImageIcon(scaledLogo));
        logoLabel.setBounds(140, 20, 230, 120);

        card.add(logoLabel);

        // ================= TITLE =================

        titleLabel = new JLabel("SAS SUPERMARKET POS");
        titleLabel.setBounds(70, 150, 400, 40);
        titleLabel.setForeground(primaryGreen);
        titleLabel.setFont(new Font("Poppins", Font.BOLD, 28));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);

        card.add(titleLabel);

        // ================= SUBTITLE =================

        subtitleLabel = new JLabel("Smart Billing & Inventory System");
        subtitleLabel.setBounds(70, 190, 400, 30);
        subtitleLabel.setForeground(new Color(120,120,120));
        subtitleLabel.setFont(new Font("Segoe UI", Font.PLAIN, 17));
        subtitleLabel.setHorizontalAlignment(SwingConstants.CENTER);

        card.add(subtitleLabel);

        // ================= BUTTONS =================

        b1 = createMainButton("LOGIN AS USER", primaryGreen);
        b1.setBounds(110, 270, 300, 50);
        card.add(b1);

        b2 = createMainButton("LOGIN AS ADMIN", orange);
        b2.setBounds(110, 350, 300, 50);
        card.add(b2);

        b3 = createOutlineButton("REGISTER AS USER");
        b3.setBounds(110, 430, 300, 50);
        card.add(b3);

        b4 = createExitButton("EXIT");
        b4.setBounds(110, 510, 300, 50);
        card.add(b4);

        gbc.gridy = 0;
        add(card, gbc);

        // ================= ACTIONS =================

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);

        setVisible(true);
    }

    // ================= GREEN / ORANGE BUTTON =================

    private JButton createMainButton(String text, Color bg) {

        JButton b = new JButton(text);

        b.setFont(new Font("Poppins", Font.BOLD, 17));
        b.setBackground(bg);
        b.setForeground(Color.WHITE);

        b.setFocusPainted(false);
        b.setBorderPainted(false);

        b.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        b.addMouseListener(new MouseAdapter() {

            public void mouseEntered(MouseEvent e) {
                b.setBackground(bg.darker());
            }

            public void mouseExited(MouseEvent e) {
                b.setBackground(bg);
            }
        });

        return b;
    }

    // ================= OUTLINE BUTTON =================

    private JButton createOutlineButton(String text) {

        JButton b = new JButton(text);

        b.setFont(new Font("Poppins", Font.BOLD, 17));

        b.setBackground(Color.WHITE);
        b.setForeground(primaryGreen);

        b.setFocusPainted(false);

        b.setBorder(new LineBorder(primaryGreen, 2, true));

        b.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        b.addMouseListener(new MouseAdapter() {

            public void mouseEntered(MouseEvent e) {
                b.setBackground(new Color(240,255,240));
            }

            public void mouseExited(MouseEvent e) {
                b.setBackground(Color.WHITE);
            }
        });

        return b;
    }

    // ================= EXIT BUTTON =================

    private JButton createExitButton(String text) {

        JButton b = new JButton(text);

        b.setFont(new Font("Poppins", Font.BOLD, 17));

        b.setBackground(new Color(220,53,69));
        b.setForeground(Color.WHITE);

        b.setFocusPainted(false);
        b.setBorderPainted(false);

        b.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        b.addMouseListener(new MouseAdapter() {

            public void mouseEntered(MouseEvent e) {
                b.setBackground(new Color(180,40,55));
            }

            public void mouseExited(MouseEvent e) {
                b.setBackground(new Color(220,53,69));
            }
        });

        return b;
    }

    // ================= WATERMARK BACKGROUND =================

    private static class WatermarkPanel extends JPanel {

        @Override
        protected void paintComponent(Graphics g) {

            super.paintComponent(g);

            Graphics2D g2 = (Graphics2D) g.create();

            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);

            GradientPaint gp = new GradientPaint(
                    0, 0,
                    new Color(240,255,240),
                    getWidth(), getHeight(),
                    new Color(255,248,235));

            g2.setPaint(gp);
            g2.fillRect(0,0,getWidth(),getHeight());

            String watermark = "SAS SUPERMARKET";

            g2.setFont(new Font("Arial", Font.BOLD, 18));
            g2.setColor(new Color(0,0,0,20));

            for (int y = 60; y < getHeight(); y += 140) {

                for (int x = 40; x < getWidth(); x += 300) {

                    g2.drawString(watermark, x, y);
                }
            }

            // Decorative circles
            g2.setColor(new Color(34,139,34,40));
            g2.fillOval(-100, -100, 300, 300);

            g2.setColor(new Color(255,140,0,40));
            g2.fillOval(getWidth()-250, getHeight()-250, 300, 300);

            g2.dispose();
        }
    }

    // ================= ACTIONS =================

    @Override
    public void actionPerformed(ActionEvent e) {

        Object src = e.getSource();

        if (src == b1) {

            new Agent_Login_Frame().setVisible(true);
            dispose();
        }

        else if (src == b2) {

            new Admin_Login_Frame().setVisible(true);
            dispose();
        }

        else if (src == b3) {

            new Agent_Register_Frame().setVisible(true);
            dispose();
        }

        else if (src == b4) {

            System.exit(0);
        }
    }

    // ================= MAIN =================

    public static void main(String[] args) {

        try {

            UIManager.setLookAndFeel(
                    UIManager.getSystemLookAndFeelClassName());

        } catch (Exception e) {
            e.printStackTrace();
        }

        new Mainapp();
    }
}
