package steps;

import dtos.FlightParameters;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import pageobjects.Search;
import utilities.DriverManager;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class SearchSteps {
    private World world;
    private Search search;
    private final static String DEEPLINK_RECIPE = "https://www.kayak.ch/flights/%s-%s/%s/%s?sort=bestflight_a&fs=price=-%s";
    private final static String BASE_URL = "http://kayak.ch/flights";


    public SearchSteps(World world) {
        this.world = world;
        search = new Search();
    }

    @Given("^I use the Kayak website$")
    public void initializeTest() {
        DriverManager.getDriver().get(BASE_URL);
        DriverManager.getDriver().findElement(By.xpath("//*[contains(@id,'-accept')]")).click();
    }

    @When("^I search for a flight with a deeplink:$")
    public void searchFlightWithDeepLink(FlightParameters flightParameters) {
        SimpleDateFormat inputFormat = new SimpleDateFormat("dd.MM.yyyy");
        SimpleDateFormat urlFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.GERMAN);
        String departureDate;
        String arrivalDate;
        try {
            departureDate = urlFormat.format(inputFormat.parse(flightParameters.getDepartureDate())).toString();
            arrivalDate = urlFormat.format(inputFormat.parse(flightParameters.getArrivalDate())).toString();
        } catch (ParseException e) {
            throw new IllegalArgumentException("The provided date is not allowed!");
        }
        world.flightParameters = flightParameters;
        DriverManager.getDriver().get(String.format(DEEPLINK_RECIPE,
                flightParameters.getOriginAirport(),
                flightParameters.getDestinationAirport(),
                departureDate,
                arrivalDate,
                flightParameters.getMaximumPrice()));
    }


    @When("^I search for a flight:$")
    public void searchFlight(FlightParameters flightParameters) {
        world.flightParameters = flightParameters;
        search.enterOriginAirport(flightParameters.getOriginAirport())
                .enterDepartureAirport(flightParameters.getDestinationAirport())
                .enterDepartureDate(flightParameters.getDepartureDate())
                .enterArrivalDate(flightParameters.getArrivalDate())
                .submit();
    }
}
