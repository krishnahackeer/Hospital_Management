package Hospital;
import java.sql.ResultSet;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Main extends JFrame implements ActionListener {
    JTextField textfield;
    JPasswordField textfiel;
    JButton r;

    // Constructor
    Main() {
        // for username label
        JLabel newtext = new JLabel("Username");
        newtext.setBounds(40, 40, 150, 30);
        newtext.setFont(new Font("Tahoma", Font.PLAIN, 25));
        newtext.setForeground(new Color(44, 44, 44));
        add(newtext);

// Password label
        JLabel newpass = new JLabel("Password");
        newpass.setBounds(40, 130, 150, 30);
        newpass.setFont(new Font("Tahoma", Font.PLAIN, 25));
        newpass.setForeground(new Color(44, 44, 44));
        add(newpass);

// Text field

        textfield = new JTextField();
        textfield.setBounds(250, 40, 200, 34);
        textfield.setFont(new Font("Tahoma", Font.PLAIN, 25));
        textfield.setBackground(new Color(255, 255, 255));
        textfield.setForeground(new Color(44, 44, 44));
        add(textfield);


         textfiel = new JPasswordField();
        textfiel.setBounds(250, 130, 200, 34);
        textfiel.setFont(new Font("Tahoma", Font.PLAIN, 25));
        textfiel.setBackground(new Color(255, 255, 255));
        textfiel.setForeground(new Color(44, 44, 44));
        add(textfiel);
        ImageIcon image = new ImageIcon(ClassLoader.getSystemResource("Hospital/thsjur.png"));
        Image i1 = image.getImage().getScaledInstance(250, 200, Image.SCALE_DEFAULT);
        ImageIcon image1 = new ImageIcon(i1);
        JLabel label = new JLabel(image1);
        label.setBounds(460, 20, 250, 200);
        add(label);


       r = new JButton("Login");
        r.setBounds(260, 220, 100, 30);
        r.setFont(new Font("Tahoma", Font.PLAIN, 25));
        r.setBackground(new Color(98, 190, 51));
        r.setForeground(new Color(255, 255, 255));
        r.addActionListener(this);
        add(r);


      JButton s = new JButton("Cancel");
        s.setBounds(80, 220, 100, 30);
        s.setFont(new Font("Tahoma", Font.PLAIN, 20));
        s.setBackground(new Color(44, 44, 44));
        s.setForeground(new Color(255, 255, 255));

        s.addActionListener(this);
        add(s);


        //sizing loaction visiblity is done
        setSize(750, 340);
        setLayout(null);
        setTitle("Thakur Healthcare: Login Page");
        setLocation(270, 180);
        setVisible(true);
        getContentPane().setBackground(new Color(222,224,224));



    }


      // Connection to Database
        @Override
        public void actionPerformed (ActionEvent e){

            if (e.getSource() == r) {
                try {
                    conn c = new conn();
                    String user = textfield.getText();
                    String pass = textfiel.getText();
                    String q = "select * from login where id = '" + user + "' and password = '" + pass + "'";
                    ResultSet resultset = c.statementl.executeQuery(q);


                    if (resultset.next()) {

                        new test();
                        setVisible(false);
                    } else {

                        JOptionPane.showMessageDialog(null, "Invalid");
                    }


                } catch (Exception E) {
                    E.printStackTrace();
                }

            } else {
                System.exit(0);

            }


        }
    public static void main(String[] args) {
        // Create an instance of Main
        new Main();

    }
    }
