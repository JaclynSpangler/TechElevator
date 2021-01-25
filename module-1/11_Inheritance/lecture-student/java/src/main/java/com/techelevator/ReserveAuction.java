package com.techelevator;

public class ReserveAuction extends Auction{

    private final int reservePrice;//doesnt need setter because it is final!

    public ReserveAuction(String itemForSale, int reservePrice) {
        super(itemForSale);
        this.reservePrice= reservePrice;
    }

    public int getReservePrice(){

        return reservePrice;
    }
    @Override //annotation on there to help us as a developer to check that its doing what it should
    public boolean placeBid(Bid offeredBid){
        boolean isWinningBid = false;

        if(offeredBid.getBidAmount() >= reservePrice) {
            isWinningBid = super.placeBid(offeredBid);
        }
        return isWinningBid;
    }


}
