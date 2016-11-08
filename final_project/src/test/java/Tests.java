import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.TestCaseId;

import java.util.Random;

import static java.util.concurrent.TimeUnit.SECONDS;

public class Tests {
    private static final String URL = "http://automationpractice.com/index.php";
    private static final String EMAIL = "testemail234@gmail.ru";
    private static final String ORDER = "Order N4565";
    private static final String MESSAGE = "My message for support";
    private static final String PATH = "d://uploadtest.txt";
    private static final String BLOUSE = "Blouse";
    private static final String EMAILWORKING = "111@test.by";
    private static final String PASSWORD = "11111";
    private static final String FIRST_NAME = "John";
    private static final String LAST_NAME = "Black";
    private static final String ADDRESS = "USA";
    private static final String CITY = "New York";
    private static final String POSTCODE = "22200";
    private static final String MOBILE = "12356887";
    private static final String ALIAS = "text alias";
    private WebDriver driver;
    private Contact_Us_Page contact_us_page;
    private HomePage homePage;
    private SearchPage searchPage;
    private TShirtPage tShirtPage;
    private SignInPage signInPage;
    private CheckOutPage checkOutPage;
    private HistoryPage historyPage;
    private CreateAccountPage createAccountPage;
    private MyAccountPage myAccountPage;


    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, SECONDS);
        driver.manage().window().maximize();
        driver.get(URL);
        homePage = new HomePage(driver);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.close();
    }

    @Test
    @TestCaseId("E1")
    public void ContactUsTest() {
        contact_us_page = homePage.clickcontact();
        contact_us_page.contact_us_input(EMAIL,ORDER,MESSAGE,PATH);
        Assert.assertTrue(contact_us_page.isMessageSentDisplayed(), "Message is not displayed");
    }

    @Test
    @TestCaseId("E2")
    public void IncorrectContactUsTest() {
        contact_us_page = homePage.clickcontact();
        contact_us_page.contact_exept_message_input(EMAIL, ORDER, PATH);
        Assert.assertTrue(contact_us_page.isErrorMessageDisplayed(),"Error message is not displayed");
    }

    @Test
    @TestCaseId("E3")
    public void CreateAccountTest(){
        signInPage = homePage.clicksignin();
        createAccountPage = signInPage.createAccount(EMAIL);
        myAccountPage = createAccountPage.createAccount(FIRST_NAME, LAST_NAME, PASSWORD, ADDRESS, CITY, POSTCODE, MOBILE, ALIAS);
        Assert.assertTrue(myAccountPage.myAccountisDisplayed(),"New account is not created");
        }


    @Test
    @TestCaseId("E4")
    public void SearchTShirtTest() {
        searchPage = homePage.searchItem(BLOUSE);
        Assert.assertTrue(searchPage.isBlouseDisplayed(),"Blouse is not displayed");
    }

    @Test
    @TestCaseId("E5")
    public void AddToCartTest() throws InterruptedException {
        searchPage = homePage.searchItem(BLOUSE);
        searchPage.addToCart();
        searchPage.isItemDisplayed();
        searchPage.deleteItem();
        searchPage.isCartEmpty();
  }

    @Test
    @TestCaseId("E6")
    public void CatalogTest() {
        tShirtPage = homePage.lookTShirts();
        Assert.assertTrue(tShirtPage.isTSirtDisplayed(),"T-Shirt is not displayed");
    }

    @Test
    @TestCaseId("E7")
    public void BuyTest() {
        signInPage = homePage.clicksignin();
        homePage = signInPage.signin(EMAILWORKING,PASSWORD);
        searchPage = homePage.searchItem(BLOUSE);
        checkOutPage = searchPage.addToCartAndCheck();
        historyPage = checkOutPage.buy();
        Assert.assertTrue(historyPage.isBoughtItemDisplayed(), "Item you bought is not displayed");
    }

}
