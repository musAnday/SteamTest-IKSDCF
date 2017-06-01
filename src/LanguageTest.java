import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;


/**
 * Created by Musa-Desktop on 1.06.2017.
 */
public class LanguageTest extends BaseTest {

    static private WebDriver driver;
    static private Wait<WebDriver> wait;

    @Before
    public void setUp() throws Exception {
        driver = super.setUpBeforeTestClass();
        wait = new WebDriverWait(driver, 30);
    }


    @Test
    public void testLanguageSwitch() throws Exception {
        driver.findElement(By.id("language_pulldown")).click();
        driver.findElement(By.linkText("Magyar (Hungarian)")).click();
        assertEquals("Barátok által", driver.findElement(By.linkText("Barátok által")).getText());
        assertEquals("Virtuális valóság", driver.findElement(By.linkText("Virtuális valóság")).getText());
        assertEquals("Akciós", driver.findElement(By.linkText("Akciós")).getText());
    }


    @After
    public void tearDown() throws Exception {
        super.tearDownAfterTestClass();
    }
}
