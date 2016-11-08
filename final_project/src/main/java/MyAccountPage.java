import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Юля on 08.11.2016.
 */
public class MyAccountPage {
    private static final By MY_ACCOUNT = By.xpath("//h1[contains(text(),'My account')]");
    private WebDriver driver;
    public MyAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean myAccountisDisplayed() {
        return driver.findElement(MY_ACCOUNT).isDisplayed();
    }

}
