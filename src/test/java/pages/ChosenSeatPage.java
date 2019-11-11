package pages;

import org.openqa.selenium.By;

public class ChosenSeatPage {

    private BaseFunc baseFunc; //peremennaja baseFunc

    private final By BOOKED_SEAT = By.xpath(".//div[@class = 'line']");
    private final By BOOK_BUTTON = By.id("book3");

    public ChosenSeatPage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    public String getChosenSeat() {
       String bookedSeat = "";
       return bookedSeat = baseFunc.getDigits(baseFunc.getText(BOOKED_SEAT));
    }

    public void pressBookButton() {
        baseFunc.clickElement(BOOK_BUTTON);
    }

}
