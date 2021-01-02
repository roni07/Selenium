import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class Listener {
    public static void main(String[] args) throws InterruptedException {
        String oushodSheba = "https://oushodsheba.com";

        System.setProperty("webdriver.chrome.driver", "/home/roni/Documents/SeleniumTools/chromedriver");
        WebDriver driver = new ChromeDriver();

        JavascriptExecutor javascriptExecutor= ((JavascriptExecutor)driver);
        EventFiringWebDriver eventHandler = new EventFiringWebDriver(driver);
        EventCapture eventCapture = new EventCapture();

        eventHandler.register(eventCapture);
        eventHandler.navigate().to(oushodSheba);

        driver.manage().window().maximize();

        Thread.sleep(4000);
        WebElement searchInput = driver.findElement(By.xpath("//body/div[@id='__next']/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/form[1]/input[1]"));
        eventCapture.beforeFindBy(By.xpath("//body/div[@id='__next']/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/form[1]/input[1]"), searchInput, driver);

        searchInput.sendKeys("napa");
        eventCapture.afterFindBy(By.xpath("//body/div[@id='__next']/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/form[1]/input[1]"), searchInput, driver);

        Thread.sleep(2000);
        driver.findElement(By.xpath("//body/div[@id='__next']/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/form[1]/button[1]")).click();

        javascriptExecutor.executeScript("window.scrollBy(0, 550)");
        Thread.sleep(1500);
        javascriptExecutor.executeScript("window.scrollBy(550, 0)");

        WebElement helpButton = driver.findElement(By.xpath("//header/div[3]/div[2]/a[1]"));
        helpButton.click();
    }
}
