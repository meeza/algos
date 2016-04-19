package azeem.open.implementation.emailverificationsystem;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

/**
 *
 * @author Mohd Azeem
 */
public class VerificationSystem {

    private final int key;
    private final String database;

    public VerificationSystem() {
        database = "emailverification";
        key = 123;
    }

    /**
     *
     * @param name
     * @param email
     * @return key of the corespondent record in PENDING_USERS table
     */
    public String register(String name, String email) {

        String query = "insert into " + database + ".PENDING_USERS "
                + "values (default, " + name + ", " + email + ")";
        MySQLAccessAgent db_agent = new MySQLAccessAgent(database);
        String key = db_agent.updateTable(query);
        return generateURL(key);
    }

    public Boolean verify(String cypherText)
            throws SQLException {
        String status = null;
        String key = retrieveID(cypherText);
        String query = "select * from" + database + ".PENDING_USERS where id= " + key;
        MySQLAccessAgent db_agent1 = new MySQLAccessAgent(database);
        ResultSet record = db_agent1.query(query);
        if(record == null)
            return false;
        Timestamp record_time = record.getTimestamp(1);
        Timestamp cur_time = getCurTimestamp();

        // time difference in hours
        long time_difference = (cur_time.getTime() - record_time.getTime()) / (1000 * 60 * 60);
        if (time_difference < 24) {
            String name = (String) record.getObject(2);
            String email = (String) record.getObject(3);
            query = "insert into " + database + ".ACTIVE_USERS "
                    + "values (default, " + name + ", " + email + ")";
            MySQLAccessAgent db_agent2 = new MySQLAccessAgent(database);
            status = db_agent2.updateTable(query);
        }
        query = "delete from" + database + ".PENDING_USERS where id= " + key;
        return status!= null;
    }
    
    private Timestamp getCurTimestamp() {
        java.util.Date date = new java.util.Date();
        Timestamp cur_time = new Timestamp(date.getTime());
        return cur_time;
    }

    private String retrieveID(String cypherText) {
        if(cypherText == null){            
            return "0";
        }            
        String[] tokens = cypherText.split("?");
        String id_cypher = tokens[tokens.length-1];
        int id = Integer.parseInt(id_cypher) - key;
        return String.valueOf(id);
    }
    
    private String generateURL(String id){
        if(id == null){            
            return "0";
        }
        System.out.println("id: "+id);
        int cypher = Integer.parseInt(id)+key;
        return String.valueOf("www.mysite.com/user?"+cypher);
    }

}
