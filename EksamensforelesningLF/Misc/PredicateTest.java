package EksamensforelesningLF.Misc;

import java.util.ArrayList;
import java.util.Collection;

public class PredicateTest {

    private PredicateInterface pred = new PredicateInterface();
    
    public Collection<Integer> numberFilter(Integer... tall) {
        Collection<Integer> res = new ArrayList<>();
        for (Integer integer : tall) {
            if (pred.test(integer)) {
                res.add(integer);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        
        PredicateTest object = new PredicateTest();

        System.out.println(object.numberFilter(1,2,3,4,5,6,7,8,9,10,11));
    }
}
