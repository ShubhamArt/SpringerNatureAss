package com.taxi;

import java.util.ArrayList;
import java.util.List;

public class TaxiTicket {
    private String source;
    private String destination;
    private int travellers;

    private static List<Route> routes = new ArrayList<>();

    static {
        routes.add(new Route("PUNE", "MUMBAI", 120));
        routes.add(new Route("PUNE", "NASIK", 200));
        routes.add(new Route("MUMBAI", "GOA", 350));
        routes.add(new Route("MUMBAI", "NASIK", 180));
    }
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
        for (Route route : routes) {
            if ((route.getFrom().equals(source) && route.getTo().equals(destination)) ||
                    (route.getFrom().equals(destination) && route.getTo().equals(source))) {
                return route.getDistance();
            }
        }
        return 0;
    }

    private int calculateFare(int distance) {
        if (distance <= 100) {
            return 750;
        } else {
            return 750 + (distance - 100) * 5;
        }
    }

}
