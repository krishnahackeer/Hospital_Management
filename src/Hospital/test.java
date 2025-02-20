package Hospital;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class test extends JFrame {
    JPanel p, n;

    public test() {
        // Upper Sheet Panel
        p = new JPanel();
        p.setBounds(5, 160, 1525, 670);
        p.setBackground(new Color(248, 239, 218));
        p.setLayout(null); // Set layout to null for absolute positioning
        add(p);

        // Below Sheet panel
        n = new JPanel();
        n.setBounds(5, 5, 1525, 150);
        n.setBackground(new Color(207, 245, 236));
        n.setLayout(null); // Set layout to null for absolute positioning
        add(n);

        // Image addition
        ImageIcon image = new ImageIcon(ClassLoader.getSystemResource("Hospital/drr.png"));
        Image i1 = image.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon image1 = new ImageIcon(i1);
        JLabel label = new JLabel(image1);
        label.setBounds(1325, 0, 200, 200); // Adjust bounds to position the label at the right corner
        n.add(label);

        // Image generated of ambulance
        ImageIcon imag = new ImageIcon(ClassLoader.getSystemResource("Hospital/ambulance.png"));
        Image i2 = imag.getImage().getScaledInstance(300, 200, Image.SCALE_DEFAULT);
        ImageIcon image2 = new ImageIcon(i2);
        JLabel labe = new JLabel(image2);
        labe.setBounds(1200, 0, 300, 200); // Adjust bounds to position the label at the right corner
        n.add(labe);

        // Addition of reception list Add new patient
        JButton n1 = new JButton("Add new patient");
        n1.setBounds(30, 15, 200, 30);
        n1.setBackground(new Color(246, 215, 118));
        n.add(n1);
        n1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new newpatient();
            }
        });

        // Addition of reception list Room
        JButton n2 = new JButton("Room");
        n2.setBounds(30, 58, 200, 30);
        n2.setBackground(new Color(246, 215, 118));
        n.add(n2);
        n2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Room();
            }
        });

        // Addition of reception list Department
        JButton n3 = new JButton("Department");
        n3.setBounds(510, 15, 200, 30);
        n3.setBackground(new Color(246, 215, 118));
        n.add(n3);
        n3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new department();
            }
        });

//        // Addition of reception list All Employee info
//        JButton n4 = new JButton("All Employee Info");
//        n4.setBounds(270, 15, 200, 30);
//        n4.setBackground(new Color(246, 215, 118));
//        n.add(n4);
//        n4.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                new Main();
//            }
//        });

        // Addition of reception list Patient Info
        JButton n5 = new JButton("Patient Info");
        n5.setBounds(270, 58, 200, 30);
        n5.setBackground(new Color(246, 215, 118));
        n.add(n5);
        n5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new patientinfo();
            }
        });

        // Addition of reception list Patient Discharge
        JButton n6 = new JButton("Patient Discharge");
        n6.setBounds(270, 15, 200, 30);
        n6.setBackground(new Color(246, 215, 118));
        n.add(n6);
        n6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new patient();
            }
        });



//        // Addition of reception Search Room
//        JButton n9 = new JButton("Search Room");
//        n9.setBounds(510, 100, 200, 30);
//        n9.setBackground(new Color(246, 215, 118));
//        n.add(n9);

        // Addition of reception Logout
        JButton n10 = new JButton("Logout");
        n10.setBounds(510, 58, 200, 30);
        n10.setBackground(new Color(246, 215, 118));
        n.add(n10);
        n10.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        // Setting the normal design
        setTitle("Thakur Healthcare: Reception");
        setSize(1950, 1090);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        // Calling the function
        test obj = new test();
    }
}
