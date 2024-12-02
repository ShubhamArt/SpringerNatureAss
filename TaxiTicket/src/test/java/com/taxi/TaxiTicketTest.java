package com.taxi;
import org.junit.Assert;
import org.junit.Test;

public class TaxiTicketTest {
    //Write the Test Case First
    @Test
    public void testTicketGeneration() {
        // Test input: source = PUNE, destination = NASIK, travellers = 2
        TaxiTicket ticket = new TaxiTicket("PUNE", "NASIK", 2);
        String expectedOutput = "Taxi Ticket\n-----------\nSource: PUNE\nDestination: NASIK\nKms: 200\nNo. of travellers = 2\nTotal = 2500 INR";
        Assert.assertEquals(expectedOutput, ticket.generateTicket());
    }
}
