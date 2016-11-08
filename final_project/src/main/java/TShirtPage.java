import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;


public class TShirtPage {
    private static final By TSHIRT= By.cssSelector("a.product-name[title*='T-shirt']");
    private WebDriver driver;
       public TShirtPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isTSirtDisplayed() {
        return driver.findElement(TSHIRT).isDisplayed();
    }


}
