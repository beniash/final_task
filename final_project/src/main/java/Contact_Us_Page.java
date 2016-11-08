import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by Юля on 08.11.2016.
 */
    public class Contact_Us_Page {
        private static final By SUBJECT_DROPDOWN = By.xpath(".//*[@id='id_contact']");
        private static final By EMAIL_INPUT = By.xpath(".//*[@id='email']");
        private static final By ORDER_REF_INPUT = By.xpath(".//*[@id='id_order']");
        private static final By MESSAGE_INPUT = By.xpath(".//*[@id='message']");
        private static final By UPLOAD_INPUT = By.xpath(".//*[@id='fileUpload']");
        private static final By SEND_BUTTON = By.xpath(".//*[@id='submitMessage']");
        private static final By MESSAGE_SENT_TEXT = By.xpath("//p[contains(text(),'Your message has been successfully sent to our team.')]");
        private  static final By ERROR_MESSAGE = By.xpath("//li[contains(text(),'The message cannot be blank.')]");
        private WebDriver driver;

        public Contact_Us_Page(WebDriver driver) {
            this.driver = driver;
        }

        public Contact_Us_Page contact_us_input(CharSequence email, CharSequence order, CharSequence message, CharSequence path) {
            Select select = new Select(driver.findElement(SUBJECT_DROPDOWN));
            select.selectByIndex(1);
            driver.findElement(EMAIL_INPUT).sendKeys(email);
            driver.findElement(ORDER_REF_INPUT).sendKeys(order);
            driver.findElement(MESSAGE_INPUT).sendKeys(message);
            driver.findElement(UPLOAD_INPUT).sendKeys(path);
            driver.findElement(SEND_BUTTON).click();
            return new Contact_Us_Page(driver);
        }

    public Contact_Us_Page contact_exept_message_input(CharSequence email, CharSequence order, CharSequence path) {
        Select select = new Select(driver.findElement(SUBJECT_DROPDOWN));
        select.selectByIndex(1);
        driver.findElement(EMAIL_INPUT).sendKeys(email);
        driver.findElement(ORDER_REF_INPUT).sendKeys(order);
        driver.findElement(UPLOAD_INPUT).sendKeys(path);
        driver.findElement(SEND_BUTTON).click();
        return new Contact_Us_Page(driver);
    }

        public boolean isMessageSentDisplayed() {
            return driver.findElement(MESSAGE_SENT_TEXT).isDisplayed();
        }

        public boolean isErrorMessageDisplayed() {
        return driver.findElement(ERROR_MESSAGE).isDisplayed();
    }
}

