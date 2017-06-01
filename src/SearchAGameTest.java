import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;


public class SearchAGameTest extends BaseTest{
  private WebDriver driver;

  @Before
  public void setUp() throws Exception {
      driver = super.setUpBeforeTestClass();
  }

  @Test
  public void testSearchAGame() throws Exception {
    driver.findElement(By.id("store_nav_search_term")).clear();
    driver.findElement(By.id("store_nav_search_term")).sendKeys("Witcher");
    driver.findElement(By.cssSelector("#store_search_link > img")).click();
    assertEquals("The Witcher® 3: Wild Hunt", driver.findElement(By.cssSelector("span.title")).getText());
  }

  @After
  public void tearDown() throws Exception {
    super.tearDownAfterTestClass();
  }

}
