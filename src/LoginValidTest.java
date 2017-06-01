import java.util.ArrayList;
import java.util.Set;
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
public class LoginValidTest  extends  BaseTest{
    private WebDriver driver;
    @Before
    public void setUp() throws Exception {
        driver = super.setUpBeforeTestClass();
    }


    @Test
    public void Login() throws Exception {
        driver = super.setUpBeforeTestMethod(true);
        assertEquals("iksdcftest", driver.findElement(By.id("account_pulldown")).getText());
        Set<Cookie> cookies = driver.manage().getCookies();
        boolean succeeded = false;
        for (Cookie cookie: cookies)
        {
            if (cookie.getName().contains("steamLogin") ) {
                assertTrue("Login successful",true);
                succeeded = true;
                break;
            }
        }
        if (!succeeded)
        {
            assert false;
        }
    }




    @After
    public void tearDown() throws Exception {
        super.tearDownAfterTestClass();
    }



}
