import org.apache.regexp.RE;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

/**
 * Created by Юля on 08.11.2016.
 */


public class CreateAccountPage {
    private static final By FIRST_NAME = By.xpath(".//*[@id='customer_firstname']");
    private static final By LAST_NAME = By.xpath(".//*[@id='customer_lastname']");
    private static final By PASSWORD = By.xpath(".//*[@id='passwd']");
    private static final By ADDRESS = By.xpath(".//*[@id='address1']");
    private static final By CITY = By.xpath(".//*[@id='city']");
    private static final By STATE = By.xpath(".//*[@id='id_state']");
    private static final By POSTCODE = By.xpath(".//*[@id='postcode']");
    private static final By MOBILE = By.xpath(".//*[@id='phone_mobile']");
    private static final By ALIAS = By.xpath(".//*[@id='alias']");
    private static final By REGISTER = By.xpath(".//*[@id='submitAccount']");
    private WebDriver driver;
    public CreateAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    public MyAccountPage createAccount(CharSequence first_name, CharSequence last_name, CharSequence pass, CharSequence address, CharSequence city,
                         CharSequence postcode,CharSequence mobile,CharSequence alias) {
        driver.findElement(FIRST_NAME).sendKeys(first_name);
        driver.findElement(LAST_NAME).sendKeys(last_name);
        driver.findElement(PASSWORD).sendKeys(pass);
        driver.findElement(ADDRESS).sendKeys(address);
        driver.findElement(CITY).sendKeys(city);
        Select select = new Select(driver.findElement(STATE));
        select.selectByIndex(1);
        driver.findElement(POSTCODE).sendKeys(postcode);
        driver.findElement(MOBILE).sendKeys(mobile);
        driver.findElement(ALIAS).sendKeys(alias);
        driver.findElement(REGISTER).click();
        return new MyAccountPage(driver);
    }

}
