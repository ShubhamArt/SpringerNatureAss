package com.taxi;

public class TaxiTicket {
    private String source;
    private String destination;
    private int travellers;

    public TaxiTicket(String source, String destination, int travellers) {
        this.source = source;
        this.destination = destination;
        this.travellers = travellers;
    }

    public String generateTicket() {
        int distance = getDistance();
        int totalFare = calculateFare(distance) * travellers;

        return String.format("Taxi Ticket\n-----------\nSource: %s\nDestination: %s\nKms: %d\nNo. of travellers = %d\nTotal = %d INR",
                source, destination, distance, travellers, totalFare);
    }
    private int getDistance() {
        return 0;
    }

    private int calculateFare(int distance) {
        return 0;
    }

}
