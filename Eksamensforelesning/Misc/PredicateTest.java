package Eksamensforelesning.Misc;

import java.util.ArrayList;
import java.util.Collection;

public class PredicateTest {

    private PredicateInterface pred = new PredicateInterface();
    
    public Collection<Integer> numberFilter(Integer... tall) {
        return null;
    }

    public static void main(String[] args) {
        
        PredicateTest object = new PredicateTest();

        System.out.println(object.numberFilter(1,2,3,4,5,6,7,8,9,10,11));
    }
}
