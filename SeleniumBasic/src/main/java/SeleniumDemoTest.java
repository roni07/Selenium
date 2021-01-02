import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class SeleniumDemoTest {

    public static void main(String[] args) throws InterruptedException {

        WebDriver webDriver;
        String oushodShebaUrl = "https://oushodsheba.com/";
        String url = "https://themeforest.net/";
        String googleURL = "https://accounts.google.com";

        System.setProperty("webdriver.chrome.driver", "/home/roni/Documents/SeleniumTools/chromedriver");

        webDriver = new ChromeDriver();

        webDriver.manage().window().maximize();

        webDriver.manage().deleteAllCookies();

//        webDriver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
//        webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        webDriver.get(oushodShebaUrl);
//        webDriver.get(url);

        Thread.sleep(1000);
        WebElement searchInput = webDriver.findElement(By.xpath("//body/div[@id='__next']/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/form[1]/input[1]"));
        sendKeys(webDriver, searchInput, 10, "napa");

        WebElement searchButton = webDriver.findElement(By.xpath("//body/div[@id='__next']/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/form[1]/button[1]"));
        onClick(webDriver, searchButton, 10);
    }

    public static void sendKeys(WebDriver webDriver, WebElement webElement, int timeOut, String value) {
        new WebDriverWait(webDriver, timeOut).until(ExpectedConditions.visibilityOf(webElement));
        webElement.sendKeys(value);
    }

    public static void onClick(WebDriver webDriver, WebElement webElement, int timeOut) {
        new WebDriverWait(webDriver, timeOut).until(ExpectedConditions.elementToBeClickable(webElement));
        webElement.click();
    }
}
