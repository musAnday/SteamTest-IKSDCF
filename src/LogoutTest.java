import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by Musa-Desktop on 1.06.2017.
 */
public class LogoutTest extends BaseTest {
    private WebDriver driver;
    @Before
    public void setUp() throws Exception {
        driver = super.setUpBeforeTestClass();
        driver = super.setUpBeforeTestMethod(true);
    }


    @Test
    public void Logout() throws Exception {
        driver = super.tearDownAfterTestMethod();
        assertTrue(isElementPresent(By.linkText("login")));
    }

    @After
    public void tearDown() throws Exception {
        super.tearDownAfterTestClass();
    }


    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

}
