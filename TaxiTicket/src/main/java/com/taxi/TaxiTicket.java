package com.taxi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TaxiTicket {
    private String source;
    private String destination;
    private int travellers;

    //private static List<Route> routes = new ArrayList<>();
    private static Map<String, Integer> routeMap = new HashMap<>();

    static {
        /*routes.add(new Route("PUNE", "MUMBAI", 120));
        routes.add(new Route("PUNE", "NASIK", 200));
        routes.add(new Route("MUMBAI", "GOA", 350));
        routes.add(new Route("MUMBAI", "NASIK", 180));*/

        routeMap.put("PUNE-MUMBAI", 120);
        routeMap.put("PUNE-NASIK", 200);
        routeMap.put("MUMBAI-GOA", 350);
        routeMap.put("MUMBAI-NASIK", 180);
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
      /*  for (Route route : routes) {
            if ((route.getFrom().equals(source) && route.getTo().equals(destination)) ||
                    (route.getFrom().equals(destination) && route.getTo().equals(source))) {
                return route.getDistance();
            }
        }
        return 0;*/
        String routeKey = source + "-" + destination;
        if (routeMap.containsKey(routeKey)) {
            return routeMap.get(routeKey);
        }
        routeKey = destination + "-" + source;
        return routeMap.getOrDefault(routeKey, 0);
    }

    private int calculateFare(int distance) {
        if (distance <= 100) {
            return 750;
        } else {
            return 750 + (distance - 100) * 5;
        }
    }

}
