package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class BookingPage {

    private BaseFunc baseFunc;

    private final By TITLE = By.xpath(".//div[@class = 'toolbar']");
    private final By DESTINATION = By.xpath(".//span[@class = 'bTxt']");
    private final By CUSTOMER_NAME = By.id("name");
    private final By CUSTOMER_SURNAME = By.id("surname");
    private final By DISCOUNT_CODE = By.id("discount");
    private final By ADULT_COUNT = By.id("adults");
    private final By CHILD_COUNT = By.id("children");
    private final By LUGGAGE_COUNT = By.id("bugs");
    private final By NEXT_FLIGHT = By.id("flight");
    private final By BOOK_BUTTON = By.id("book2");


    public BookingPage (BaseFunc baseFunc) {

        this.baseFunc = baseFunc;
    }

    public String getBrandNameBP() {
       return baseFunc.getText(TITLE);
    }

    public String getDeparture() {
        return baseFunc.getElementFromList(DESTINATION, 0).getText();
    }

    public String getArrival() {
        return baseFunc.getElementFromList(DESTINATION, 1).getText();
    }

    public void enterCustomerName(String text) {
        baseFunc.fillField(CUSTOMER_NAME, text);
    }

    public void enterCustomerSurname(String text) {
        baseFunc.fillField(CUSTOMER_SURNAME, text);
    }

    public void enterDiscountCode(String text) {
        baseFunc.fillField(DISCOUNT_CODE, text);
    }

    public void enterAdultCount(String text) {
        baseFunc.fillField(ADULT_COUNT, text);
    }

    public void enterChildrenCount(String text) {
        baseFunc.fillField(CHILD_COUNT,text);
    }

    public void enterLuggageCount(String text) {
        baseFunc.fillField(LUGGAGE_COUNT, text);
    }

    public void selectNextFlight(String text) {
        baseFunc.selectByText(NEXT_FLIGHT,text);
    }

    public void pressBookButton() {
        baseFunc.clickElement(BOOK_BUTTON);
    }
}
