package dtos;

public class FlightParameters {
    private String originAirport;
    private String destinationAirport;
    private String departureDate;
    private String arrivalDate;
    private int maximumPrice;

    public FlightParameters(String originAirport, String destinationAirport, String departureDate, String arrivalDate, int maximumPrice) {
        this.originAirport = originAirport;
        this.destinationAirport = destinationAirport;
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
        this.maximumPrice = maximumPrice;
    }

    public String getOriginAirport() {
        return originAirport;
    }

    public void setOriginAirport(String originAirport) {
        this.originAirport = originAirport;
    }

    public String getDestinationAirport() {
        return destinationAirport;
    }

    public void setDestinationAirport(String destinationAirport) {
        this.destinationAirport = destinationAirport;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }

    public String getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(String arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public int getMaximumPrice() {
        return maximumPrice;
    }

    public void setMaximumPrice(int maximumPrice) {
        this.maximumPrice = maximumPrice;
    }
}
