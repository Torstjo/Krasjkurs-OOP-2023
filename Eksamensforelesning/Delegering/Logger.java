package Eksamensforelesning.Delegering;

import java.util.ArrayList;
import java.util.Collection;

public class Logger {
    
    Collection<String> hasLogged = new ArrayList<>();
 
    public void log(String log) {
        System.out.println(log);
        hasLogged.add(log);
    
    }
}
