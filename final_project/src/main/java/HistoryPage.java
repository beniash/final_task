import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Юля on 08.11.2016.
 */
public class HistoryPage {
    private static final By BOUGHT_ITEM = By.cssSelector("tr.first_item");
    private WebDriver driver;
    public HistoryPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isBoughtItemDisplayed() {
        return driver.findElement(BOUGHT_ITEM).isDisplayed();
    }
}
