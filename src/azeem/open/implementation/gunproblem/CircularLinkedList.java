package azeem.open.implementation.gunproblem;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;

/**
 *
 * @author Mohd Azeem
 */
public class CircularLinkedList extends ArrayList<Prisioner>{
    int k;
    public int gunPersonIndexInCircle = 0;
    public CircularLinkedList(int k) {
        this.k = k;
    }
    
    public boolean circulateGunAndKill(){
        int size = this.size();
        if(size == 1){
            return false;
        }        
        gunPersonIndexInCircle = (gunPersonIndexInCircle + k) % size;
        int toKillPerson = (gunPersonIndexInCircle + size - 1) % size;
        this.remove(toKillPerson);
        gunPersonIndexInCircle = toKillPerson;
        return true;
    }
}
