package Hospital;


import com.mysql.cj.protocol.Resultset;
import net.proteanit.sql.DbUtils;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Room extends JFrame {
    Room(){





        // Image add
        ImageIcon image = new ImageIcon(ClassLoader.getSystemResource("Hospital/hospitalroom.png"));
        Image i1 = image.getImage().getScaledInstance(350, 200, Image.SCALE_DEFAULT);
        ImageIcon image1 = new ImageIcon(i1);
        JLabel label = new JLabel(image1);
        label.setBounds(522, 120, 350, 200);
        add(label);

        JTable t = new JTable();
        t.setBounds(10,40,500,400);
        t.setForeground(Color.BLACK);
        t.setFont(new Font("Tahoma",Font.BOLD, 14));
        t.setBackground(new Color(235, 248, 218));

        t.setAutoResizeMode(5);
        t.setAutoCreateRowSorter(true);
       t.setEditingRow(50);


        t.setRowHeight(30);
        t.setBorder(new LineBorder(Color.BLACK ,2));
        add(t);


            try{
                conn c2 = new conn();
                String q = "select * from room";
               Resultset result = (Resultset) c2.statementl.executeQuery(q);
               t.setModel(DbUtils.resultSetToTableModel((ResultSet) result));



            }catch (Exception e){
                e.printStackTrace();
            }

        // adding the labels
        JLabel l1 = new JLabel("Room No.");
            l1.setBounds(12,15,80,15);
            l1.setForeground(Color.BLACK);
            l1.setFont(new Font("Thaoma", Font.BOLD,14));
            add(l1);

        JLabel l2 = new JLabel("Available");
        l2.setBounds(135,15,80,15);
        l2.setForeground(Color.BLACK);
        l2.setFont(new Font("Thaoma", Font.BOLD,14));
        add(l2);

        JLabel l3 = new JLabel("Price");
        l3.setBounds(260,15,80,15);
        l3.setForeground(Color.BLACK);
        l3.setFont(new Font("Thaoma", Font.BOLD,14));
        add(l3);

        JLabel l4= new JLabel("Bed Type");
        l4.setBounds(385,15,80,15);
        l4.setForeground(Color.BLACK);
        l4.setFont(new Font("Thaoma", Font.BOLD,14));
        add(l4);
        JButton b1;
        b1 = new JButton("Back");
        b1.setBounds(200, 500,120,30);
        b1.setFont(new Font("Tahuma", Font.PLAIN, 20));
        b1.setForeground(Color.BLACK);
        add(b1);
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();

            }
        });







        setTitle("Thakur healthcare - Room Info");
        setSize(900,600);
        setLayout(
                null
        );
        getContentPane().setBackground(new Color(235, 248, 218));
        setLocation(300,170);
     setVisible(true);
    }

    public static void main(String[] args) {
        new Room();
    }
}
