package Eksamensforelesning.Observert;

import java.util.HashMap;
import java.util.Map;

public class RentalCarListener implements StatusListener {
    // TODO - Add any needed fields here

    private Map<String, Integer> rebates = new HashMap<>();
 
    @Override
    /**
     * Method that should be called when a given userName has updated its status.
     */
    public void statusChanged(String username, String oldStatus, String newStatus) {
        if (newStatus == "Gold") {
            rebates.put(username, 100);
        }
        else {
            rebates.put(username, 0);
        }
    }
 
    /**
     * Get's the discount of a user. Should be a 100 if the user currently has Gold
     * status, otherwise should be 0.
     *
     * @param username The username of the user
     *
     * @return The discount the user qualifies for.
     */
    public int getDiscount(String username) {
        // TODO
        return rebates.get(username);
    }
}
