package Hospital;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.sql.ResultSet;

public class patient extends JFrame {
    private JComboBox<String> c2;
    private JComboBox<String> c1;

    patient() {
        // Checkout text is coded
        JLabel l1 = new JLabel("CHECK OUT");
        l1.setBounds(150, 5, 150, 20);
        l1.setForeground(Color.BLACK);
        l1.setFont(new Font("Thaoma", Font.BOLD, 20));
        l1.setBackground(Color.WHITE);
        add(l1);

        // Customer ID text is coded
        JLabel l3 = new JLabel("Customer Id");
        l3.setBounds(30, 40, 150, 20);
        l3.setForeground(Color.BLACK);
        l3.setFont(new Font("Thaoma", Font.BOLD, 14));
        l3.setBackground(Color.WHITE);
        add(l3);

        c2 = new JComboBox<>();
        c2.setBounds(200, 40, 250, 25);
        c2.setForeground(Color.BLACK);
        c2.setBackground(Color.WHITE);
        c2.setFont(new Font("Thaoma", Font.BOLD, 14));
        add(c2);

        // Load Customer Ids into c2
        try {
            conn c = new conn();
            ResultSet result = c.statementl.executeQuery("select * from form");
            while (result.next()) {
                c2.addItem(result.getString("ID"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // ID number text is coded
        JLabel l2 = new JLabel("Id Number");
        l2.setBounds(30, 95, 150, 20);
        l2.setForeground(Color.BLACK);
        l2.setFont(new Font("Thaoma", Font.BOLD, 14));
        l2.setBackground(Color.WHITE);
        add(l2);

        // Choice for ID numbers
        c1 = new JComboBox<>();
        c1.setBounds(200, 95, 250, 25);
        c1.setForeground(Color.BLACK);
        c1.setBackground(Color.WHITE);
        c1.setFont(new Font("Thaoma", Font.BOLD, 14));
        add(c1);

        // Add ActionListener to c2 to populate c1 based on selected item
        c2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                try {
                    c1.removeAllItems(); // Clear existing items
                    conn c = new conn();
                    String selectedId = (String) c2.getSelectedItem();
                    ResultSet result = c.statementl.executeQuery("select Number from form where ID = '" + selectedId + "'");
                    while (result.next()) {
                        c1.addItem(result.getString("Number"));
                    }
                    // Add an empty item to the start of c1 to ensure no value is pre-selected
                    c1.insertItemAt("", 0);
                    c1.setSelectedIndex(0);
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });

        // Rest of the code for labels and buttons...

        // Room No label and field
        JLabel room = new JLabel("Room No.");
        room.setBounds(30, 145, 150, 20);
        room.setForeground(Color.BLACK);
        room.setFont(new Font("Thaoma", Font.BOLD, 14));
        room.setBackground(Color.WHITE);
        add(room);

        JLabel l6 = new JLabel();
        l6.setBounds(200, 145, 150, 20);
        l6.setForeground(Color.BLACK);
        l6.setFont(new Font("Thaoma", Font.BOLD, 14));
        l6.setBackground(Color.WHITE);
        add(l6);

        // In Time label and field
        JLabel rno = new JLabel("In Time");
        rno.setBounds(30, 195, 250, 20);
        rno.setForeground(Color.BLACK);
        rno.setFont(new Font("Thaoma", Font.BOLD, 14));
        rno.setBackground(Color.WHITE);
        add(rno);

        JLabel it = new JLabel();
        it.setBounds(200, 195, 250, 20);
        it.setForeground(Color.BLACK);
        it.setFont(new Font("Thaoma", Font.BOLD, 14));
        it.setBackground(Color.WHITE);
        add(it);

        // Out Time label and field
        JLabel ot = new JLabel("Out Time");
        ot.setBounds(30, 245, 150, 20);
        ot.setForeground(Color.BLACK);
        ot.setFont(new Font("Thaoma", Font.BOLD, 14));
        ot.setBackground(Color.WHITE);
        add(ot);

        // Date label
        Date date;
        date = new Date();
        JLabel date1 = new JLabel("" + date);
        date1.setBounds(200, 245, 250, 20);
        date1.setForeground(Color.BLACK);
        date1.setFont(new Font("Thaoma", Font.BOLD, 14));
        date1.setBackground(Color.WHITE);
        add(date1);

        // Button for discharge
        JButton b1 = new JButton("Discharge");
        b1.setBounds(30, 305, 150, 30);
        b1.setFont(new Font("Tahuma", Font.CENTER_BASELINE, 14));
        b1.setBackground(Color.WHITE);
        b1.setForeground(Color.BLACK);
        add(b1);
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                conn c = new conn();
                try {
                    c.statementl.executeUpdate("delete from form where Number='" + c1.getSelectedItem() + "'");
                    c.statementl.executeUpdate("update Room set available = 'Available' where room_no= '" + l6.getText() + "'");
                    JOptionPane.showMessageDialog(null, "Done");
                } catch (Exception ex) {
                    ex.printStackTrace();
                }

            }
        });

        // Button for Back
        JButton b2 = new JButton("Back");
        b2.setBounds(340, 305, 120, 30);
        b2.setFont(new Font("Tahuma", Font.CENTER_BASELINE, 14));
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        add(b2);
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        // Button for Check
        JButton b3 = new JButton("Check");
        b3.setBounds(210, 305, 120, 30);
        b3.setFont(new Font("Tahuma", Font.CENTER_BASELINE, 14));
        b3.setBackground(Color.green);
        b3.setForeground(Color.BLACK);
        add(b3);
        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    conn c = new conn();
                    ResultSet result = c.statementl.executeQuery("select * from form where Number = '" + c1.getSelectedItem() + "'");
                    while (result.next()) {
                        l6.setText(result.getString("Room_Number"));
                        it.setText(result.getString("Time"));
                    }
                } catch (Exception E1) {
                    E1.printStackTrace();
                }
            }
        });

        // Frame settings
        setTitle("Thakur Healthcare- Patient Discharge");
        setSize(800, 400);
        setLocation(400, 250);
        getContentPane().setBackground(new Color(222, 224, 224));
        setLayout(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new patient();
    }
}
