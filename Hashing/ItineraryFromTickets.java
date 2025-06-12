/*
Find Itinerary from Tickets

Given a list of tickets, find the itinerary in order using the given list.

Note: It may be assumed that the input list of tickets is not cyclic and there is one ticket
from every city except the final destination.

Example 1:
Input: "Chennai" -> "Bengaluru"
	    "Mumbai" -> "Delhi"
	    "Goa" -> "Chennai"
		"Delhi" -> "Goa"
Output: "Mumbai" -> "Delhi" -> "Goa" -> "Chennai" -> "Bengaluru"

Example 2:
Input: "New York" -> "Chicago"
		"Denver" -> "San Francisco"
        "Chicago" -> "Denver"
        "San Francisco" -> "Los Angeles"
Output: New York -> Chicago -> Denver -> San Francisco -> Los Angeles

*/

package Hashing;

import java.util.HashMap;
import java.util.Map;

public class ItineraryFromTickets {
	public static String getStart(HashMap<String, String> ticketsFromTo) {
		HashMap<String, String> ticketsToFrom = new HashMap<>();
		
		for (Map.Entry<String, String> entry : ticketsFromTo.entrySet()) {
			ticketsToFrom.put(entry.getValue(), entry.getKey());
		}
		
		for (String key : ticketsFromTo.keySet()) {
			if (!ticketsToFrom.containsKey(key)) {
				return key;
			}
		}
		
		return null;
	}
	
	public static void getItinerary(HashMap<String, String> ticketsFromTo) {
		String start = getStart(ticketsFromTo);
		
		if (start != null) {
			System.out.print(start);
			for (String ignored : ticketsFromTo.keySet()) {
				System.out.print(" -> " + ticketsFromTo.get(start));
				start = ticketsFromTo.get(start);
			}
		}
	}
	
	public static void main(String[] args) {
		HashMap<String, String> ticketsFromTo = new HashMap<>();
		ticketsFromTo.put("Chennai", "Bengaluru");
		ticketsFromTo.put("Mumbai", "Delhi");
		ticketsFromTo.put("Goa", "Chennai");
		ticketsFromTo.put("Delhi", "Goa");
		
		getItinerary(ticketsFromTo);
	}
}
