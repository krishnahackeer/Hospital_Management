package Hospital;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.Statement;

public class conn {

        java.sql.Connection connection;
        Statement statementl;
    public conn() {
            try {
                connection=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/connection", "root", "krishna1A@123");
                System.out.println("Connected to the database successfully!");
                statementl=connection.createStatement();

            }catch (Exception e){
                e.printStackTrace();
            }
    }
    public static void main(String[] args) {
     new conn();

    }

}
