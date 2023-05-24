package EksamensforelesningLF.Arv;

import java.util.ArrayList;
import java.util.Collection;

public class Property {
    
    // Add any needed fields here
    private String name;
    private int price;
    private boolean isSold = false;
    private Collection<BidListener> listeners = new ArrayList<>();
    private Collection<BidListener> highListeners = new ArrayList<>();
    private Collection<Bid> bids = new ArrayList<>(); 
    /**
     *
     * @param name  the name of the property to be sold
     * @param price the listing price of the property
     */
    public Property(String name, int price) {
        // TODO
        this.name = name;
        this.price = price;
    }
 
    /**
     *
     * @return the name of the property
     */
    public String getName() {
        // TODO
        return name;
    }
 
    /**
     *
     * @return the price of the property
     */
    public int getPrice() {
        // TODO
        return price;
    }
 
    /**
     *
     * @return whether the property is sold, default value is false
     */
    public boolean isSold() {
        // TODO
        return isSold;
    }
 
    /**
     * Sets the property as sold
     *
     * @throws IllegalStateException if no bids have been received
     */
    public void setIsSold() {
        if (getNumberOfBids() == 0) {
            throw new IllegalStateException("No bids have been received!");
        }
        this.isSold = true;
    }
 
    /**
     *
     * @return the number of bids received on this property
     */
    public int getNumberOfBids() {
        // TODO
        return bids.size();
    }
 
    /**
     *
     * @param listener register listener to be notified of any bids to this property
     */
    public void addListenerForAllBids(BidListener listener) {
        if (!listeners.contains(listener)) {
            listeners.add(listener);
        }
    }
 
    /**
     *
     * @param listener register listener to be notified of only bids that are new
     *                 highest bids You do not need to handle the case where a
     *                 listener gets registered both for highest bid and for all
     *                 bids
     */
    public void addListenerForHighestBids(BidListener listener) {
        if (!highListeners.contains(listener)) {
            highListeners.remove(listener);
        }
    }
 
    /**
     *
     * @param listener removes listener from this property, registered with any of
     *                 the above methods
     */
    public void removeListener(BidListener listener) {
        if (highListeners.contains(listener)) {
            highListeners.remove(listener);
        }
        if (listeners.contains(listener)) {
            listeners.remove(listener);
        }
    }
 
    /**
     * Creates a new bid object and notifies all listeners that a bid has been given
     *
     * @param bidder the name of the bidder
     * @param bid    the amount of the bid
     *
     * @throws IllegalStateException - if the property is already sold
     */
    public void bidReceived(String bidder, int bid) {
        if (isSold()) {
            throw new IllegalStateException("Can't bid on a property that isn't for sale!");
        }
        Bid newBid = new Bid(bidder, this, bid);

        bids.add(newBid);

        notifyListeners(newBid);
    }
 
    /**
     * Notifies listeners that a bid has been received. There are currently no
     * listeners implemented in the main method, but this is used for test purposes
     * by us after the exam.
     *
     * This is package private for testing purposes
     *
     * @param bid the most recent bid
     */
    void notifyListeners(Bid bid) {
        for (BidListener bidListener : listeners) {
            bidListener.propertyBid(bid);
        }
    }
 
    /**
     *
     * @return the current highest bid. If the property has no bids, return 0
     */
    public int getHighestBid() {
        // TODO
        return bids.stream().mapToInt(b -> b.getBid()).max().orElse(0);
    }
 
    public static void main(String[] args) {
        Property p = new Property("name", 1000);
        p.bidReceived("BIDDER", 500);
        // 500
        System.out.println(p.getHighestBid());
        p.bidReceived("BIDDER2", 1100);
        // 1100
        System.out.println(p.getHighestBid());
        // false
        System.out.println(p.isSold());
        p.setIsSold();
        // true
        System.out.println(p.isSold());
 
    }
}
