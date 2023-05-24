package EksamensforelesningLF.Misc;

import java.util.function.Predicate;

public class PredicateInterface implements Predicate<Integer> {

    @Override
    public boolean test(Integer tall) {
        if (tall > 5) {
            return true;
        }

        return false;
    }
    
}
