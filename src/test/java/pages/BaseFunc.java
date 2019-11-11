package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class BaseFunc {

    private WebDriver driver;

    public BaseFunc() {
        System.setProperty("webdriver.chrome.driver", "/Users/alenamihina/Downloads/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    public void goToUrl(String url) {
        if (url.startsWith("http://") || url.startsWith("https://")){    // || - OR

        } else {
            url = "http://" + url;
        }
        driver.get(url);
    }

    public void selectByText(By locator, String text) {
        Select select = new Select(getElement(locator));
        select.selectByVisibleText(text);
    }

    public WebElement getElement(By locator) {
        return driver.findElement(locator);
    }

    public WebElement getElementFromList(By locator, Integer index) {
        return driver.findElements(locator).get(index);
    }

    public void clickElement(By locator) {
        getElement(locator).click();
    }
    public void clickElementFromList(By locator, Integer index) {
        getElementFromList(locator, index).click();
    }

    public String getText(By locator) {
        return getElement(locator).getText();
    }

    public void fillField(By locator, String text) {
        driver.findElement(locator).sendKeys(text);
    }

    public String getDigits(String text) {
        return text.replaceAll("\\D+", "");
    }
}
