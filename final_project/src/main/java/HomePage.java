import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Юля on 08.11.2016.
 */
public class HomePage {
    private static final By CONTACT_BUTTON = By.xpath(".//*[@id='contact-link']/a");
    private static final By SEARCH_INPUT = By.xpath(".//*[@id='search_query_top']");
    private static final By SEARCH_BUTTON = By.xpath(".//*[@id='searchbox']/button");
    private static final By TSHIRT_BUTTON = By.xpath(".//*[@id='block_top_menu']/ul/li[3]/a");
    private static final By SIGNIN_BUTTON = By.xpath(".//*[@id='header']/div[2]/div/div/nav/div[1]/a");
    private WebDriver driver;
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public Contact_Us_Page clickcontact() {
        driver.findElement(CONTACT_BUTTON).click();
        return new Contact_Us_Page(driver);
    }

    public SearchPage searchItem(String searchItem) {
        driver.findElement(SEARCH_INPUT).sendKeys(searchItem);
        driver.findElement(SEARCH_BUTTON).click();
        return new SearchPage(driver);
    }

    public TShirtPage lookTShirts() {
        driver.findElement(TSHIRT_BUTTON).click();
        return new TShirtPage(driver);
    }

    public SignInPage clicksignin() {
        driver.findElement(SIGNIN_BUTTON).click();
        return new SignInPage(driver);
    }
}
