
package steps;

import dtos.FlightParameters;
import io.cucumber.java.DataTableType;

import java.util.Map;

public class CucumberTypeTransformers {
    @DataTableType
    public FlightParameters flightParametersEntry(Map<String, String> entry) {
        String originAirport = entry.get("originAirport");
        String destinationAirport = entry.get("destinationAirport");
        String departureDate = entry.get("departureDate");
        String arrivalDate = entry.get("arrivalDate");
        int maximumPrice = Integer.parseInt(entry.get("maximumPrice") == null ? "0" : entry.get("maximumPrice"));

        return new FlightParameters(originAirport, destinationAirport, departureDate, arrivalDate, maximumPrice);
    }
}