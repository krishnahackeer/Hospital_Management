package Hospital;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class newpatient extends JFrame implements ActionListener {
    JComboBox combobox ;
    JTextField t1,t2,t3,t4,t5;
    JRadioButton r1,r2;
    Choice c1;
    JLabel date;
    JButton b1,b2;
    public
    newpatient() {

        // Panel is added (sheet)
     JPanel p = new JPanel();
     p.setBackground(Color.WHITE);
     p.setBounds(5,5,840,540);
     p.setLayout(null);

     // Image is generated of patient
        ImageIcon image = new ImageIcon(ClassLoader.getSystemResource("Hospital/dadiimage.png"));
        Image i1 = image.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon image1 = new ImageIcon(i1);
        JLabel label = new JLabel(image1);
        label.setBounds(550, 150, 200, 200);
        add(label);

        // pateint text is atttached
        JLabel  name = new JLabel("NEW PATIENT FORM");
        name.setBounds(130, 11, 260, 53);
        name.setFont(new Font("Tahuma", Font.BOLD, 20));
        name.setForeground(Color.BLACK);
        add(name);

        // ID text is code
        JLabel  id = new JLabel("ID :");
        id.setBounds(150, 75, 200, 14);
       id.setFont(new Font("Tahuma", Font.BOLD, 14));
        id.setForeground(Color.BLACK);
        add(id);


        // PERSONAL DETAILS options is coded here

        combobox = new JComboBox(new String[] {"Aadhar Card", "Driving Licence", "Voter id"});
        combobox.setBounds(271,75,200,20);
        combobox.setForeground(Color.BLACK);
        combobox.setBackground(Color.WHITE);
        add(combobox);

        // Number and its text area is coded here

        JLabel  number = new JLabel("Number :");
        number.setBounds(150, 130, 200, 14);
        number.setFont(new Font("Tahuma", Font.BOLD, 14));
        number.setForeground(Color.BLACK);
        add(number);

        t1 = new JTextField();
        t1.setBounds(271,130,200,20);
        t1.setFont(new Font("Tahoma", Font.BOLD,14));
        t1.setBackground(Color.WHITE);
        add(t1);

        // NAME code

        JLabel  namer= new JLabel("Name :");
        namer.setBounds(150, 185, 200, 14);
        namer.setFont(new Font("Tahuma", Font.BOLD, 14));
        namer.setForeground(Color.BLACK);
        add(namer);

        t5 = new JTextField();
        t5.setBounds(271,185,200,20);
        t5.setFont(new Font("Tahoma", Font.BOLD,14));
        t5.setBackground(Color.WHITE);
        add(t5);

        // Gender code
        JLabel gender = new JLabel("Gender :");
        gender.setBounds(150, 240, 200, 14);
        gender.setFont(new Font("Tahuma", Font.BOLD, 14));
        gender.setForeground(Color.BLACK);
        add(gender);
        r1 = new JRadioButton("Male");
        r1.setBounds(271,240,60,20);
       r1.setFont(new Font("Tahuma", Font.BOLD, 14));
        add(r1);

        r2 = new JRadioButton("Female");
        r2.setBounds(350,240,85,20);
        r2.setFont(new Font("Tahuma", Font.BOLD, 14));
        add(r2);

        ButtonGroup b = new ButtonGroup();
        b.add(r1);
        b.add(r2);

        // Disease name
        JLabel  labeldisease = new JLabel("Disease :");
        labeldisease.setBounds(150, 295, 200, 14);
        labeldisease.setFont(new Font("Tahuma", Font.BOLD, 14));
        labeldisease.setForeground(Color.BLACK);
        add(labeldisease);



        t2 = new JTextField();
        t2.setBounds(271,295,200,20);
        t2.setFont(new Font("Tahoma", Font.BOLD,14));
        t2.setBackground(Color.WHITE);
        add(t2);

        // Room no.
        JLabel  room = new JLabel("Room No.");
        room.setBounds(150, 350, 100, 14);
        room.setFont(new Font("Tahuma", Font.BOLD, 14));
        room.setForeground(Color.BLACK);
        add(room);


        c1 = new Choice();
        try{
            conn c = new conn();
            ResultSet resultset = c.statementl.executeQuery("select * from Room");
            while(resultset.next()){
                c1.add(resultset.getString("room_no"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        c1.setBackground(new Color(3,45,48));
        c1.setBounds(271,350,200,15);
        c1.setFont(new Font("Tahuma", Font.BOLD, 14));
        c1.setForeground(Color.BLACK);
        c1.setBackground(Color.WHITE);
        add(c1);



        // Time
        JLabel  time = new JLabel("Time :");
        time.setBounds(150, 405, 200, 14);
       time.setFont(new Font("Tahuma", Font.BOLD, 14));
        time.setForeground(Color.BLACK);
        add(time);

        // Date
        Date date1 = new Date();
        date = new JLabel(" "+date1);
        date.setBounds(271,405,250,14);
        date.setFont(new Font("Tahuma", Font.BOLD, 14));
        date.setBackground(Color.WHITE);
        date.setForeground(Color.BLACK);
        add(date);

        // Deposit
        JLabel deposit = new JLabel("Deposit: "
        );

        deposit.setBounds(150,460,250,20);
        deposit.setFont(new Font("Tahuma", Font.BOLD, 14));
        deposit.setBackground(Color.WHITE);
        deposit.setForeground(Color.BLACK);
        add(deposit);


        t4 = new JTextField();
        t4.setBounds(271,460,200,20);
        t4.setFont(new Font("Tahoma", Font.BOLD,14));
        t4.setBackground(Color.WHITE);
        add(t4);
        // add button and back button

        b1 = new JButton("Back");
        b1.setBounds(260, 505,120,30);
        b1.setFont(new Font("Tahuma", Font.CENTER_BASELINE, 14));
        b1.setForeground(Color.BLACK);
        add(b1);
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();

            }
        });


        b2 = new JButton("ADD");
        b2.setBounds(100, 505,120,30);
        b2.setFont(new Font("Tahuma",Font.CENTER_BASELINE, 14));
        b2.setBackground(Color.green);
        b2.setForeground(Color.BLACK);
        add(b2);
        b2.addActionListener(this);

        setTitle("Thakur Healthcare- Patient form");
        setLocation(300,100);
        setLayout(null);
        getContentPane().setBackground(new Color(222,224,224));
        setSize(850,600);
        setVisible(true);
    }




    public static void main(String[] args) {
        new newpatient();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == b2) { // Changed to b2 for the "ADD" button
            conn c = new conn();
            String radioBTN = null;
            if(r1.isSelected()) {
                radioBTN = "Male";
            } else if(r2.isSelected()) {
                radioBTN = "Female";
            }
            String s1 = (String) combobox.getSelectedItem();
            String s2 = t1.getText();
            String s3 = t2.getText();
            String s5 = t4.getText();
            String s6 = radioBTN;
            String s7 = c1.getSelectedItem();
            String s8 = date.getText();
            String s9 = t5.getText();

            try {
                String q = "insert into form values('" + s1 + "','" + s2 + "','" + s9+ "','" + s6 + "','" + s3 + "','" + s7 + "','" + s8 + "','" + s5 + "')";
                String q1 = "update room set available = 'Occupied' where room_no = '" + s7 + "'";
                c.statementl.executeUpdate(q);
                c.statementl.executeUpdate(q1);
                JOptionPane.showMessageDialog(null, "Added Successfully");
                setVisible(true);
                dispose();
                new test();

            } catch(Exception E) {
                E.printStackTrace();
            }
        } else if (e.getSource() == b1) { // Handling the "Back" button
            setVisible(false);
        }



}
}
