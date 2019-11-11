package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class BookSeatPage {

    private BaseFunc baseFunc; //peremennaja baseFunc
    private final By SEAT = By.xpath(".//div[@class = 'seat']");

    //constructor

    public BookSeatPage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    public void selectSeat(String seatNumber) {
        baseFunc.clickElementFromList(SEAT, Integer.valueOf(seatNumber)-1);
    }

}
