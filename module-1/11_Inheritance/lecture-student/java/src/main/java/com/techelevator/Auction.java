package com.techelevator;

import java.util.ArrayList;
import java.util.List;

public class Auction {//has bids but not an inheritance

    private final String itemForSale;
    private Bid currentHighBid;
    private final List<Bid> allBids;//all bids placed in the auction


    //constructor
    public Auction(String itemForSale) {
        this.itemForSale = itemForSale;
        this.currentHighBid = new Bid("", 0);
        allBids = new ArrayList<>();
    }

    public boolean placeBid(Bid offeredBid) {
        allBids.add(offeredBid);
        boolean isCurrentWinningBid = false;
        if (offeredBid.getBidAmount() > currentHighBid.getBidAmount()) {
            currentHighBid = offeredBid;
            isCurrentWinningBid = true;
        }
        return isCurrentWinningBid;
    }

    public Bid getHighBid() {

        return currentHighBid;
    }

    public List<Bid> getAllBids() {

        return new ArrayList<>(allBids);
    }

    public String getItemForSale() {

        return itemForSale;
    }
}
