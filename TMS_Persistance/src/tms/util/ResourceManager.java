package tms.util;

import java.sql.*;

public class ResourceManager {
    
    private static Connection con;
    private static String driverName = "oracle.jdbc.driver.OracleDriver";
    private static  String connectURL = "jdbc:oracle:thin:@localhost:1521:XE";
    private static String username = "TMS";
    private static String password = "TMS";
    
    public static Connection getConnection() {
        
        try {
            Class.forName(driverName);
            System.out.println("Driver loaded..");
            
            con = DriverManager.getConnection(connectURL, username, password);
            System.out.println("Connection established..");      
            
        } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch(SQLException e) {
                e.printStackTrace();
            }
        return con;
    }
    
    public static void close(Connection con) {
        try {
            con.close();
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static void close(PreparedStatement preparedStatement) {
        try {
            preparedStatement.close();
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static void close(ResultSet res) {
        try {
            res.close();
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }
   
}
