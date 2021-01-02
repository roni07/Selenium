import org.testng.annotations.Test;

public class TestCaseOne {

    @Test(priority = 1)
    void openBrowser() {
        System.out.println("Browser opening");
    }

    @Test(priority = 2)
    void testTestCaseOne() {
        System.out.println("Test case one is testing");
    }

    @Test(priority = 3)
    void closeBrowser() {
        System.out.println("Browser closed");
    }
}
