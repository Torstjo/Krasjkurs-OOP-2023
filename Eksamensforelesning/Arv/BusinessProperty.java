package Eksamensforelesning.Arv;

public class BusinessProperty extends Property {
    /**
     * BusinessProperty should implement the following extensions from Property. As
     * soon as a bid is received that is equal to or higher than the price, the
     * property should be marked as sold
     */
 
     public BusinessProperty(String name, int price) {
        super(name, price);
    }
 
    public static void main(String[] args) {
        Property p = new BusinessProperty("name", 1000);
        p.bidReceived("BIDDER", 500);
        // 500
        System.out.println(p.getHighestBid());
        p.bidReceived("BIDDER2", 1100);
        // 1100
        System.out.println(p.getHighestBid());
        // true
        System.out.println(p.isSold());
    }
}