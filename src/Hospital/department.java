package Hospital;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class department extends JFrame {
    public department() {

        //Sheet
        JPanel p = new JPanel();
        p.setBounds(5,5,690,490);
        p.setLayout(null);
        p.setBackground(new Color(222,224,224));
        add(p);

        // Table
        JTable t = new JTable();
        t.setBounds(0,40,700,350);
        t.setBackground(new Color(222,224,224));
        t.setForeground(Color.BLACK);
        t.setFont(new Font("Tahoma", Font.BOLD,14));

        p.add(t);

        try{
            conn c = new conn();
            String q = "select * from contact";
            ResultSet result = c.statementl.executeQuery(q);
            t.setModel(DbUtils.resultSetToTableModel(result));
        }catch (Exception e){
            e.printStackTrace();
        }
        JLabel l1 = new JLabel("Department");
        l1.setBounds(100,20,100,20);
        l1.setBackground(new Color(90,156,163));
        l1.setForeground(Color.BLACK);
        l1.setFont(new Font("Tahoma", Font.BOLD,14));
        p.add(l1);

        JLabel l2 = new JLabel("Phone Number");
        l2.setBounds(400,20,150,20);
        l2.setBackground(new Color(90,156,163));
        l2.setForeground(Color.BLACK);
        l2.setFont(new Font("Tahoma", Font.BOLD,14));
        p.add(l2);

        JButton b2;
        b2 = new JButton("BACK");
        b2.setBounds(400, 410,130,30);
        b2.setFont(new Font("Tahuma",Font.CENTER_BASELINE, 14));
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        p.add(b2);
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();

            }
        });




        setTitle("Thakur healthcare - Department");
        setSize(700,500);
        setLayout(null);
        setLocation(350,250);
        setVisible(true);
    }

    public static void main(String[] args) {
        new department();
    }
}
