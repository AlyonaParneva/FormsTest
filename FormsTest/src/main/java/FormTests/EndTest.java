package FormTests;

import org.junit.jupiter.api.AfterAll;
import org.openqa.selenium.WebDriver;

public class EndTest extends BaseTest{
    @AfterAll
    public static void tearDown(WebDriver driver) {
        if (driver != null) {
            driver.quit();}
    }
}
