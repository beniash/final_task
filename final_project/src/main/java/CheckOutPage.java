import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Юля on 08.11.2016.
 */
public class CheckOutPage {
    private static final By CHECKOUT_FIRST = By.xpath(".//*[@id='center_column']/p[2]/a[1]/span");
    private static final By CHECKOUT_SECOND = By.xpath(".//*[@id='center_column']/form/p/button");
    private static final By AGREE_CHECKBOX = By.xpath(".//*[@id='cgv']");
    private static final By CHECKOUT_THIRD = By.xpath(".//*[@id='form']/p/button");
    private static final By PAYMENT = By.xpath(".//*[@id='HOOK_PAYMENT']/div[1]/div/p/a");
    private static final By CHECKOUT_FOURTH = By.xpath(".//*[@id='cart_navigation']/button");
    private static final By HISTORY_BUTTON = By.xpath(".//*[@id='center_column']/p/a");
    private static final By ORDER_HISTORY = By.cssSelector("tr.first_item");
    private WebDriver driver;
    public CheckOutPage(WebDriver driver) {
        this.driver = driver;
    }

    public HistoryPage buy() {
        driver.findElement(CHECKOUT_FIRST).click();
        driver.findElement(CHECKOUT_SECOND).click();
        driver.findElement(AGREE_CHECKBOX).click();
        driver.findElement(CHECKOUT_THIRD).click();
        driver.findElement(PAYMENT).click();
        driver.findElement(CHECKOUT_FOURTH).click();
        driver.findElement(HISTORY_BUTTON).click();
        driver.findElement(ORDER_HISTORY).click();
        return new HistoryPage(driver);
    }
}
