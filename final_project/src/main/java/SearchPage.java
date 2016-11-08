import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

/**
 * Created by Юля on 08.11.2016.
 */
public class SearchPage {
    private static final By BLOUSE = By.cssSelector("a.product-name[title*='Blouse']");
    private static final By ADD_BUTTON = By.xpath(".//*[@id='center_column']/ul/li/div/div[2]/div[2]/a[1]/span");
    private static final By CLOSE = By.xpath(".//*[@id='layer_cart']/div[1]/div[1]/span");
    private static final By CART_WITH_ITEM = By.cssSelector(".shopping_cart>a");
    private static final By ITEM = By.cssSelector(".product-container");
    private static final By ITEM_CART = By.cssSelector(".first_item.last_item");
    private static final By DELETE_BUTTON = By.cssSelector(".ajax_cart_block_remove_link");
    private static final By EMPTY_CART = By.xpath("//span[contains(text(),'empty')]");
    private static final By CHECKOUT_BUTTON = By.xpath(".//*[@id='layer_cart']/div[1]/div[2]/div[4]/a/span");
    private WebDriver driver;

    public SearchPage(WebDriver driver) {
        this.driver = driver;
    }

    public SearchPage addToCart() {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(ITEM)).build().perform();
        driver.findElement(ADD_BUTTON).click();
        driver.findElement(CLOSE).click();
        return new SearchPage(driver);
    }

    public CheckOutPage addToCartAndCheck() {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(ITEM)).build().perform();
        driver.findElement(ADD_BUTTON).click();
        driver.findElement(CHECKOUT_BUTTON).click();
        return new CheckOutPage(driver);

    }

    public boolean isItemDisplayed() {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(CART_WITH_ITEM)).build().perform();
       return driver.findElement(ITEM_CART).isDisplayed();
    }

    public SearchPage deleteItem() {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(CART_WITH_ITEM)).build().perform();
        driver.findElement(DELETE_BUTTON).click();
        return new SearchPage(driver);
    }

    public boolean isCartEmpty() throws InterruptedException {
        Thread.sleep(2000);
        return driver.findElement(EMPTY_CART).isDisplayed();
    }


    public boolean isBlouseDisplayed() {
        return driver.findElement(BLOUSE).isDisplayed();
    }
}
