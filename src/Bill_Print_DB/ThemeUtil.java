package Bill_Print_DB;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.JTableHeader;
import java.awt.*;

public class ThemeUtil {

    public static Color PRIMARY = new Color(34, 139, 34);
    public static Color SECONDARY = new Color(255, 153, 0);
    public static Color BG = new Color(245, 250, 245);
    public static Color DARK = new Color(40, 40, 40);

    // ================= BUTTON =================
    public static JButton createButton(String text) {

        JButton b = new JButton(text);

        b.setBackground(PRIMARY);
        b.setForeground(Color.WHITE);

        b.setFont(new Font("Segoe UI", Font.BOLD, 16));

        b.setFocusPainted(false);
        b.setBorderPainted(false);

        b.setCursor(new Cursor(Cursor.HAND_CURSOR));

        return b;
    }

    // ================= ORANGE BUTTON =================
    public static JButton createOrangeButton(String text) {

        JButton b = new JButton(text);

        b.setBackground(SECONDARY);
        b.setForeground(Color.WHITE);

        b.setFont(new Font("Segoe UI", Font.BOLD, 16));

        b.setFocusPainted(false);
        b.setBorderPainted(false);

        b.setCursor(new Cursor(Cursor.HAND_CURSOR));

        return b;
    }

    // ================= TEXTFIELD =================
    public static JTextField createField() {

        JTextField t = new JTextField();

        t.setFont(new Font("Segoe UI", Font.PLAIN, 16));

        t.setBorder(BorderFactory.createCompoundBorder(
                new LineBorder(new Color(220,220,220),1,true),
                new EmptyBorder(10,10,10,10)));

        return t;
    }

    // ================= TABLE =================
    public static void styleTable(JTable table) {

        table.setRowHeight(30);

        table.setFont(new Font("Segoe UI", Font.PLAIN, 15));

        JTableHeader header = table.getTableHeader();

        header.setBackground(PRIMARY);
        header.setForeground(Color.WHITE);

        header.setFont(new Font("Segoe UI", Font.BOLD, 16));
    }

    // ================= TITLE =================
    public static JLabel createTitle(String text) {

        JLabel lbl = new JLabel(text);

        lbl.setForeground(PRIMARY);

        lbl.setFont(new Font("Segoe UI", Font.BOLD, 30));

        return lbl;
    }
}