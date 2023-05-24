package Eksamensforelesning.Misc;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

public class collectTest {
    
    public static void main(String[] args) {
        
        Collection<Integer> collection = Arrays.asList(1,2,3,4,5,6,7);

        Collection<Integer> immutableList = collection.stream().filter(tall -> tall > 3).toList();
        Collection<Integer> mutableList = collection.stream().filter(tall -> tall > 3).collect(Collectors.toList());

        System.out.println("Her går det fint:");
        mutableList.add(8);
        System.out.println(mutableList);

        System.out.println("Her går det galt");
        immutableList.add(8);
        System.out.println(immutableList);
    }
}
