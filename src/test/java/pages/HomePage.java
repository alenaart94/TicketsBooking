package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class HomePage {
    private BaseFunc baseFunc; // 1. peremennaja dlja BaseFunc. Sozdatj!

    private final By TITLE = By.xpath(".//div[@class = 'toolbar']");
    private final By DIRECTION_A = By.id("afrom");
    private final By DIRECTION_B = By.id("bfrom");
    private final By GOGOGO = By.xpath(".//span[@class = 'gogogo']");

    // 2. Create constructor (funkcionaljnostj, nabor locatorov, kotorie s nimi rabotajut konkretnogo page.
    // Nuzhno predostavitj brauzernoe okno, v kotorom budem rabotatj)

    public HomePage(BaseFunc baseFunc) {

        this.baseFunc = baseFunc;
    }


    String dirAValue;
    String dirBValue;

    public String getBrandNameHP() {
        //Find element
        //save to string
        return baseFunc.getElement(TITLE).getText();

    }

    public void selectDeparture(String airport) {
        //find dropdown
        //choose value from dropdown
        baseFunc.selectByText(DIRECTION_A, airport);
    }

    public void selectArrival(String airport) {
        baseFunc.selectByText(DIRECTION_B, airport);
    }

    public void pressGoGoGo() {
        baseFunc.clickElement(GOGOGO);
    }

}
