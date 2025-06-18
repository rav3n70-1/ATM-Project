package source;

import java.sql.*;

public class sqlConnection {
    static Connection cn;
    
    public static Connection ConnectorDb() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection cn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/db u", 
                "root", 
                "");
            System.out.println("Database Connected!");
            return cn;
        } catch (Exception e) {
            System.out.println("Database not Connected!");
            return null;
        }
    }
}
