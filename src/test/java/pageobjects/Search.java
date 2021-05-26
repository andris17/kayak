package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import static utilities.WaitUtils.*;
import static utilities.BaseUtils.*;

public class Search {
    private static final By BLUR_CLICK = By.xpath("//*[@class='primary-content']");
    private static final By EXISTING_ITEM = By.xpath("//*[contains(@class, '-item-button')]");
    private static final By PRESENTATION_ITEMS = By.xpath("//*[contains(@class,'pres-horizon')]");
    private static final By FROM_FIELD = By.xpath("//*[contains(@class, 'haOe-origin')]");
    private static final By FIELD_INPUT = By.xpath("//*[contains(@class, 'k_my-input')]");
    private static final By TO_FIELD = By.xpath("//*[contains(@class, 'haOe-destination')]");
    private static final By DATES_FIELD = By.xpath("(//*[contains(@class,'haOe-dates')]//*[contains(@class,'-input')])[1]");
    private static final By END_DATE_FIELD = By.xpath("(//*[contains(@class,'haOe-dates')]//*[contains(@class,'-input')])[2]");
    private static final By SUBMIT_BUTTON = By.xpath("//*[contains(@class, 'haOe-submit')]");
    private static final By POPOVER = By.xpath("//div[contains(@class,'Popover')]");

    public Search enterOriginAirport(String airportInput) {
        if (getWebElements(EXISTING_ITEM).size() > 0) {
            clickOnElement(EXISTING_ITEM);
        } else {
            clickOnElement(FROM_FIELD);
        }

        enterText(FIELD_INPUT, airportInput);
        waitForElementToBeClickable(PRESENTATION_ITEMS);
        sendSpecialKey(Keys.ENTER);
        blur();
        return this;
    }

    public Search enterDepartureAirport(String airportInput) {
        clickOnElement(TO_FIELD);
        clickOnElement(FIELD_INPUT);

        enterText(FIELD_INPUT, airportInput);
        waitForElementToBeClickable(PRESENTATION_ITEMS);
        sendSpecialKey(Keys.ENTER);
        blur();
        return this;
    }

    public Search enterDepartureDate(String dateInput) {
        clickOnElement(DATES_FIELD);
        new DatePicker().selectDate(dateInput);
        blur();
        return this;
    }

    public Search enterArrivalDate(String dateInput) {
        clickOnElement(END_DATE_FIELD);
        new DatePicker().selectDate(dateInput);
        blur();
        return this;
    }

    public SearchResults submit() {
        clickOnElement(SUBMIT_BUTTON);
        return new SearchResults();
    }

    private void blur() {
        clickOnElement(BLUR_CLICK);
    }

    private boolean isPopoverHidden() {
        return !(getWebElements(POPOVER).size() > 0);
    }
}
