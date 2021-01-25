package com.techelevator;

public class BuyOutAuction extends Auction{
    private final int buyoutPrice;

    public BuyOutAuction(String itemForSale, int buyoutPrice) {
        super(itemForSale);
        this.buyoutPrice = buyoutPrice;
    }

    public boolean isAuctionOver(){
        Bid winningBid = super.getHighBid();
        return winningBid.getBidAmount() >= buyoutPrice;//meet or exceed the buyout price!
    }

    @Override
    public boolean placeBid(Bid offeredBid) {
        boolean isWinner = false;
        if(!isAuctionOver()) {
            isWinner = super.placeBid(offeredBid);
        }
         return isWinner;
    }
}
