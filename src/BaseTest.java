import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Properties;
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by Musa-Desktop on 1.06.2017.
 */
public class BaseTest {

    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    protected WebDriver setUpBeforeTestClass(){
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/chromedriver.exe");
        driver = new ChromeDriver();
        baseUrl = "http://store.steampowered.com/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(baseUrl);
        return driver;
    }


    protected WebDriver setUpBeforeTestMethod(boolean valid) {

        Properties prop = new Properties();
        try {


            InputStream input = null;
            input = new FileInputStream("config.properties");

            prop.load(input);

        } catch (Exception e) {
            e.printStackTrace();
        }
        SecureRandom random = new SecureRandom();
        String username = "";
        String password = "";

        if (!valid) {
            username = new BigInteger(130, random).toString(32);
            password = new BigInteger(130, random).toString(32);
        }else
        {
            username = prop.getProperty("username");
            password = prop.getProperty("password");
        }

        driver.findElement(By.linkText("login")).click();
        driver.findElement(By.id("input_username")).clear();
        driver.findElement(By.id("input_username")).sendKeys(username);
        driver.findElement(By.id("input_password")).clear();
        driver.findElement(By.id("input_password")).sendKeys(password);
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        return driver;
    }

    protected WebDriver tearDownAfterTestMethod() {
        driver.findElement(By.id("account_pulldown")).click();
        driver.findElement(By.linkText("Logout")).click();
        return driver;
    }

    protected void tearDownAfterTestClass() {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

}
