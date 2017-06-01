import java.io.File;
import java.util.List;
import java.util.Random;
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Musa-Desktop on 1.06.2017.
 */
public class SetProfileTest extends BaseTest{
    static private WebDriver driver;
    static private Wait<WebDriver> wait;
    @Before
    public void setUp() throws Exception {
        driver = super.setUpBeforeTestClass();
        driver = super.setUpBeforeTestMethod(true);
        wait = new WebDriverWait(driver, 30);
    }

    @Test
    public void testSearchAGame() throws Exception {
        driver.findElement(By.className("user_avatar")).click();

        Random randomGenerator = new Random();
        File file = null;
        file = new File(System.getProperty("user.dir") + "/test-picture.jpg");


        WebElement editButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("btn_profile_action")));
        editButton.click();

        WebElement browseButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("avatar_upload_input")));
        WebElement uploadButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("avatar_upload_button")));

        WebElement realName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("real_name")));
        WebElement profileName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("personaName")));
        WebElement summary = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("summary")));
        WebElement submitButton = driver.findElement(By.xpath("//button[@type='submit']"));


        Select country = new Select(driver.findElement(By.id("country")));
        browseButton.sendKeys(file.getAbsolutePath());
        uploadButton.click();
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("avatar_upload_input")));

        List<WebElement> allCountries = country.getOptions();

        realName.clear();
        realName.sendKeys("Musa Anday Arzu TEST");
        profileName.clear();
        profileName.sendKeys("iksdcftest");

        //Country is selected randomly from dropdown..
        int index = randomGenerator.nextInt(allCountries.size());
        country.selectByVisibleText(allCountries.get(index).getText());


        summary.clear();
        summary.sendKeys("Software Quality and Testing course practise assignment.");

        summary.sendKeys("Software Quality and Testing course practise assignment.");
        submitButton.click();

        WebElement confirmationMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("saved_changes_msg")));

        assertTrue(driver.findElements(By.className("saved_changes_msg")).size() != 0);
    }

    @After
    public void tearDown() throws Exception {
        super.tearDownAfterTestMethod();
        super.tearDownAfterTestClass();

    }




}
