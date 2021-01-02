import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCaseTwo {

    @Test(priority = 4)
    void openBrowser() {
        System.out.println("Test case two browser open");
    }

    @Test(priority = 5)
    void loginTest() {
        System.out.println("Login test running");
        Assert.assertEquals(1, 2);
    }
}
