package azeem.open.implementation.gunproblem;

import java.util.ArrayList;

/**
 *
 * @author Mohd Azeem
 */
public class GunProblemTester {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // set the number 'k'
        int k = 4;
        // create a linked list of prisioners
        CircularLinkedList prisonersCircle = new CircularLinkedList(k);
        // enter elements into the prisioners linked list
        for(int i = 1; i <= 5; i++){
            Prisioner prisioner = new Prisioner();
            prisioner.pointer = i;
            prisonersCircle.add(prisioner);
        }
        while(prisonersCircle.circulateGunAndKill()){
            ;
        }
        Prisioner surviverMan = prisonersCircle.get(0);
        System.out.println("surviverMan: "+surviverMan.pointer);
    }
    
}
