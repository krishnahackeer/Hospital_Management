package Hospital;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class patientinfo extends JFrame {
    patientinfo(){


        JPanel p = new JPanel();
        p.setBounds(5,5,1500,490);
        p.setLayout(null);
        p.setBackground(new Color(235, 248, 218));
        add(p);

        // Table
        JTable t = new JTable();
        t.setBounds(0,40,1500,400);
        t.setBackground(new Color(235, 248, 218));
        t.setForeground(Color.BLACK);
        t.setFont(new Font("Tahoma", Font.BOLD,14));
        t.setBorder(new LineBorder(Color.BLACK,2));




        // Set the preferred width for specific columns

//        t.setBorder((Border) Color.BLACK);
        p.add(t);


        try{
            conn c = new conn();
            String q = "select * from form";
            ResultSet result = c.statementl.executeQuery(q);
            t.setModel(DbUtils.resultSetToTableModel(result));
        }catch (Exception e){
            e.printStackTrace();
        }
        SwingUtilities.invokeLater(() -> {
            TableColumn column = t.getColumnModel().getColumn(0); // First column
            column.setPreferredWidth(10); // Set preferred width to 100 pixels

            // setting the column width
            column = t.getColumnModel().getColumn(1); // Second column
            column.setPreferredWidth(10); // Set preferred width to 150 pixels

            column = t.getColumnModel().getColumn(2); // Third column
            column.setPreferredWidth(10);
            column = t.getColumnModel().getColumn(3); // Third column
            column.setPreferredWidth(10);
            column = t.getColumnModel().getColumn(4); // Third column
            column.setPreferredWidth(10);
            column = t.getColumnModel().getColumn(5); // Third column
            column.setPreferredWidth(10);
            column = t.getColumnModel().getColumn(6); // Third column
            column.setPreferredWidth(100);
            column = t.getColumnModel().getColumn(7); // Third column
            column.setPreferredWidth(10);

        });

        // ID is coded
        JLabel l1 = new JLabel("ID");
        l1.setBounds(50,20,100,20);
        l1.setBackground(new Color(90,156,163));
        l1.setForeground(Color.BLACK);
        l1.setFont(new Font("Tahoma", Font.BOLD,14));
        p.add(l1);
        // Customer ID is coded
        JLabel l2 = new JLabel("Customer ID");
        l2.setBounds(200,20,150,20);
        l2.setBackground(new Color(90,156,163));
        l2.setForeground(Color.BLACK);
        l2.setFont(new Font("Tahoma", Font.BOLD,14));
        p.add(l2);
        // Name is coded
            JLabel l3 = new JLabel("Name");
        l3.setBounds(430,20,150,20);
        l3.setBackground(new Color(90,156,163));
        l3.setForeground(Color.BLACK);
        l3.setFont(new Font("Tahoma", Font.BOLD,14));
        p.add(l3);
        // Gender is coded
        JLabel l8= new JLabel("Gender");
        l8.setBounds(600,20,150,20);
        l8.setBackground(new Color(90,156,163));
        l8.setForeground(Color.BLACK);
        l8.setFont(new Font("Tahoma", Font.BOLD,14));
        p.add(l8);
        // Patient Disease
        JLabel l4= new JLabel("Patient Disease");
        l4.setBounds(740,20,150,20);
        l4.setBackground(new Color(90,156,163));
        l4.setForeground(Color.BLACK);
        l4.setFont(new Font("Tahoma", Font.BOLD,14));
        p.add(l4);
        // Room No.
        JLabel l5 = new JLabel("Room No.");
        l5.setBounds(940,20,150,20);
        l5.setBackground(new Color(90,156,163));
        l5.setForeground(Color.BLACK);
        l5.setFont(new Font("Tahoma", Font.BOLD,14));
        p.add(l5);
        // IN Time is coded
        JLabel l6 = new JLabel("IN Time");
        l6.setBounds(1150,20,150,20);
        l6.setBackground(new Color(90,156,163));
        l6.setForeground(Color.BLACK);
        l6.setFont(new Font("Tahoma", Font.BOLD,14));
        p.add(l6);
        // Deposit is coded
        JLabel l7 = new JLabel("Deposit");
        l7.setBounds(1380,20,150,20);
        l7.setBackground(new Color(90,156,163));
        l7.setForeground(Color.BLACK);
        l7.setFont(new Font("Tahoma", Font.BOLD,14));
        p.add(l7);

        // Button BACK is coded
        JButton b2;
        b2 = new JButton("BACK");
        b2.setBounds(400, 410,130,30);
        b2.setFont(new Font("Tahuma",Font.CENTER_BASELINE, 14));
        b2.setBackground(Color.WHITE);
        b2.setForeground(Color.BLACK);
        p.add(b2);
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();

            }
        });




        setTitle("Thakur healthcare - Patient Details");
        setSize(1500,500);
        setLayout(null);
        setLocation(0,250);
        setVisible(true);
    }

    public static void main(String[] args) {
        new patientinfo();
    }
}
