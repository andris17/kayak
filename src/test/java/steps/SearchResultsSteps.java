package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageobjects.SearchResults;

public class SearchResultsSteps {
    private World world;
    private SearchResults searchResults;

    public SearchResultsSteps(World world) {
        this.world = world;
        searchResults = new SearchResults();
    }

    @When("I set the maximum price to {int}")
    public void searchFlight(int maximumPrice) {
        world.flightParameters.setMaximumPrice(maximumPrice);
        searchResults.closeDialog().setSliderValue(maximumPrice);
    }

    @Then("^I see search results$")
    public void verifySearchResults() {
        Assert.assertTrue(searchResults.getSearchResultsCount() > 0, "No search results were found!");
    }

    @Then("^all results have lower price than the maximum$")
    public void verifyResultsPrices() {
        Assert.assertTrue(searchResults.getSearchResultsPrices().stream().allMatch(e -> e < world.flightParameters.getMaximumPrice()));
    }
}
