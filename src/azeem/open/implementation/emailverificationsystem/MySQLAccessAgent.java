package azeem.open.implementation.emailverificationsystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mohd Azeem
 */
public class MySQLAccessAgent {

    private final String url;    
    private final String driver;
    private final String userName;
    private final String password;
    private final String dbName;

    public MySQLAccessAgent(String database) {
        url = "jdbc:mysql://localhost/"; 
        driver = "com.mysql.jdbc.Driver";
        userName = "meeza";
        password = "meeza";
        dbName = database;
    }
    
    
    public ResultSet query(String query)
    {
//         = table;
        ResultSet res = null;
//        Timestamp time_stamp = null;
        try {            
            Class.forName(driver).newInstance();
            Connection conn = DriverManager.getConnection(url + dbName, userName, password);
            System.out.println("Schema \t"+conn.getSchema());
            Statement st = conn.createStatement();
            res = st.executeQuery(query);
            conn.close();
        
        } catch (ClassNotFoundException e) {
        } catch (IllegalAccessException e) {
        } catch (InstantiationException e) {
        } catch (SQLException e) {
            System.out.println("SQL Exception");
        }
 
        return res;
    }
    public String updateTable(String query){
        String key_val = "";
        try {
            Class.forName(driver).newInstance();
            Connection conn = DriverManager.getConnection(url + dbName, userName, password);
            System.out.println("Schema \t"+conn.getSchema());
            Statement st = conn.createStatement();
            st.executeUpdate(query);
            ResultSet key = st.getGeneratedKeys();
            key_val = key.getString(1);            
            conn.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MySQLAccessAgent.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(MySQLAccessAgent.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(MySQLAccessAgent.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            System.out.println("SQL Exception");
            Logger.getLogger(MySQLAccessAgent.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return key_val;
    }
}
