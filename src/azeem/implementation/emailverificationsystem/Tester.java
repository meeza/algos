package azeem.implementation.emailverificationsystem;

import java.sql.SQLException;


/**
 *
 * @author Mohd Azeem
 */
public class Tester {

    public static void main(String[] args) throws SQLException {
        VerificationSystem v = new VerificationSystem();
        String verification_link = v.register("apple", "moocazeem@gmail.com");
        System.out.println("click the verification link within 24 hours: "+verification_link);
        //// now send the verification link to the user
        //---------------------//
        // now if user clicks on the link the following method is called
        v.verify(verification_link);
    }
}
