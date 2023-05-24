package EksamensforelesningLF.Arv;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import Eksamensforelesning.Observert.LoyaltyAward;
import Eksamensforelesning.Observert.LoyaltyUser;

public class CarRentalAwards extends LoyaltyAward {
    
    private Map<Integer, Integer> carBrandToPoints = Map.of(1, 1, 2, 10, 3, 100, 4, 200, 5, 500);
    private static List<String> validNames = Arrays.asList("CarRentalAgency1", "CarRentalAgency2");
 
    public CarRentalAwards(String awardName) {
        super(awardName);
    }
 
    @Override
    /**
     * Updates the award name
     * @param: awardName The name of the award
     *
     * @throws IllegalArgumentException If the award name is not part of the valid
     *                                  names
     */
    public void setAwardName(String awardName) {
        if (!validNames.contains(awardName)) {
            throw new IllegalArgumentException("Invalid award name");
        }
        super.setAwardName(awardName);
    }
 
    /**
     * Updates the status of the given LoyaltyUser with points based on the map
     * above. The map means that carBrand 1 will award 1 points, carBrand 2 will
     * award 10 points etc
     *
     * @param carBrand:    The brand of the car the user has rented. If the brand
     *                     does not exist 0 points should be awarded
     *
     * @param loyaltyUser: The user that rented the car
     *
     *
     */
    public void awardPoints(int carBrand, LoyaltyUser loyaltyUser) {
        Integer points = carBrandToPoints.get(carBrand);
        if (points != null) {
            super.awardPoints(points, loyaltyUser);
        }
    }
 
    public static void main(String[] args) {
        LoyaltyUser user = new LoyaltyUser("Name");
        // What goes wrong here
        LoyaltyAward award = new CarRentalAwards("CarRentalAgency1"); // ValidNames er ikke blitt instansiert. Kommer av at konstruktøren kaller på super sin konstruktør, som setter navnet vha setAwardName. Siden den overrides her, vil man kjøre funksjonen før objektet er instansiert, noe som gjør at man får enn nullpointerexception.
        // Løsningen er å gjøre awardNames statisk slik at den eksisterer uavhengig av objekter
        // What goes wrong here
        award.awardPoints(1, user); // Her er det en evig loop siden awardpoints kaller på seg selv. Løsningen blir å bruke superklassen sin awardpoints i stedet.
        // Legg til super.
        System.out.println(user.getPoints());
    }
}
