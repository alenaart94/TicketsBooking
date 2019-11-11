package pages;

import org.openqa.selenium.By;

public class BookingConfirmationPage {
    private BaseFunc baseFunc;
    private final By CONFIRMATION_LABEL = By.xpath(".//div[@class = 'finalTxt']");

    public BookingConfirmationPage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    public String getBookingConfirmation() {
        return baseFunc.getText(CONFIRMATION_LABEL);
    }

}
