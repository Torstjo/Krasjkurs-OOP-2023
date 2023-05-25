package Eksamensforelesning.Misc;

import java.util.function.Predicate;

public class PredicateInterface implements Predicate<Integer> {

    @Override
    public boolean test(Integer t) {
        // TODO Auto-generated method stub
        return t > 5;
    }
    
}
