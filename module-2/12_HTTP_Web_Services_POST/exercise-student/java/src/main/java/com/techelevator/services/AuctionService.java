package com.techelevator.services;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

import com.techelevator.models.Auction;

public class AuctionService {

    public static final String API_URL = "http://localhost:3000/auctions";

    public RestTemplate restTemplate = new RestTemplate();
    private final ConsoleService console = new ConsoleService();

    public Auction[] listAllAuctions() {
        Auction[] auctions = null;
        try {
            auctions = restTemplate.getForObject(API_URL, Auction[].class);
        } catch (RestClientResponseException ex) {
            console.printError("Could not retrieve the auctions. Is the server running?");
        } catch (ResourceAccessException ex) {
            console.printError("A network error occurred.");
        }
        return auctions;
    }

    public Auction listDetailsForAuction(int id) {
        Auction auction = null;
        try {
            auction = restTemplate.getForObject(API_URL + "/" + id, Auction.class);
        } catch (RestClientResponseException ex) {
            console.printError("Could not retrieve the auction.");
        } catch (ResourceAccessException ex) {
            console.printError("A network error occurred.");
        }
        return auction;
    }

    public Auction[] findAuctionsSearchTitle(String title) {
        Auction[] auctions = null;
        try {
            auctions = restTemplate.getForObject(API_URL + "?title_like=" + title, Auction[].class);
        } catch (RestClientResponseException ex) {
            console.printError("The title was not found. Please try again.");
        } catch (ResourceAccessException ex) {
            console.printError("A network error occurred.");
        }
        return auctions;
    }

    public Auction[] findAuctionsSearchPrice(double price) {
        Auction[] auctions = null;
        try {
            auctions = restTemplate.getForObject(API_URL + "?currentBid_lte=" + price, Auction[].class);
        } catch (RestClientResponseException ex) {
            console.printError("No auctions found. Please try again.");
        } catch (ResourceAccessException ex) {
            console.printError("A network error occurred.");
        }
        return auctions;
    }

    public Auction add(String auctionString) {
        Auction auction = makeAuction(auctionString);// makeReservation is explained down below
        if(auction == null){
            return null;
        }

        HttpEntity<Auction> entity = makeEntity(auction);
        try {
            auction = restTemplate.postForObject(API_URL, entity, Auction.class);
        }catch (RestClientResponseException ex ){
            return null;
        } catch(ResourceAccessException ex){
            return null;
        }
        return auction;
    }

    public Auction update(String auctionString) {
        Auction auction = makeAuction(auctionString);// makeReservation is explained down below
        if(auction == null){
            return null;
        }

        HttpEntity<Auction> entity = makeEntity(auction);
        try{
            restTemplate.put(API_URL+"/"+auction.getId(),entity);
        } catch (RestClientResponseException ex){

            return null;
        } catch (ResourceAccessException ex){

            return null;
        } return auction;
    }

    public boolean delete(int id) throws RestClientResponseException, ResourceAccessException {
        try {
            restTemplate.delete(API_URL+"/" + id);
        } catch (RestClientResponseException ex) {
            console.printError(ex.getRawStatusCode() + " : " + ex.getStatusText());
            return false;
        } catch (ResourceAccessException ex) {
            console.printError(ex.getMessage());
            return false;
        }

        return true;
    }

    private HttpEntity<Auction> makeEntity(Auction auction) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Auction> entity = new HttpEntity<>(auction, headers);
        return entity;
    }

    private Auction makeAuction(String CSV) {
        String[] parsed = CSV.split(",");
        // invalid input
        if (parsed.length < 4 || parsed.length > 5) {
            return null;
        }
        // Add method does not include an id and only has 5 strings
        if (parsed.length == 4) {
            // Create a string version of the id and place into an array to be concatenated
            String[] withId = new String[6];
            Auction[] auctions = listAllAuctions();
            if (auctions == null) {
            	return null; // Some exception or other problem occurred.
            }
            String[] idArray = new String[]{auctions.length + 1 + ""};
            // place the id into the first position of the data array
            System.arraycopy(idArray, 0, withId, 0, 1);
            System.arraycopy(parsed, 0, withId, 1, 4);
            parsed = withId;
        }
        return new Auction(Integer.parseInt(parsed[0].trim()), parsed[1].trim(), parsed[2].trim(), parsed[3].trim(), Double.parseDouble(parsed[4].trim()));
    }


}
