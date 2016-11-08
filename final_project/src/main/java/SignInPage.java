import org.apache.xpath.operations.String;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Юля on 08.11.2016.
 */
public class SignInPage {
    private static final By EMAIL_INPUT = By.xpath(".//*[@id='email']");
    private static final By PASSWORD_BUTTON = By.xpath(".//*[@id='passwd']");
    private static final By LOGIN_BUTTON = By.xpath(".//*[@id='SubmitLogin']");
    private static final By EMAIL_NEW_INPUT = By.xpath(".//*[@id='email_create']");
    private static final By CREATE_BUTTON = By.xpath(".//*[@id='SubmitCreate']");
    private WebDriver driver;
    public SignInPage(WebDriver driver) {
        this.driver = driver;
    }

    public HomePage signin(CharSequence email, CharSequence password) {
        driver.findElement(EMAIL_INPUT).sendKeys(email);
        driver.findElement(PASSWORD_BUTTON).sendKeys(password);
        driver.findElement(LOGIN_BUTTON).click();
        return new HomePage(driver);
    }

    public CreateAccountPage createAccount(CharSequence email) {
        driver.findElement(EMAIL_NEW_INPUT).sendKeys(email);
        driver.findElement(CREATE_BUTTON).click();
        return new CreateAccountPage(driver);
    }
}
