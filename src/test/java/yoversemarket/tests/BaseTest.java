package yoversemarket.tests;

import yoversemarket.pages.*;
import org.testng.annotations.*;
import yoversemarket.utils.AccountManager;

import java.lang.reflect.Method;

import static yoversemarket.utils.extentreports.ExtentTestManager.startTest;

public class BaseTest {
    AccountManager accountManager;
    BasePage basePage;
    PlaceOnMarketPage placeOnMarketPage;
    MakeOfferPage makeOfferPage;
    LoginPage loginPage;
    WalletPage walletPage;

    @Parameters({"browser"})
    @BeforeTest
    public void beforeTest(String browser) throws InterruptedException {
        basePage = new BasePage();
        basePage.startBrowser(browser);
        accountManager = new AccountManager();
    }

    @BeforeMethod
    public void beforeMethod(Method method ){
        startTest(method.getName(),method.getAnnotation(Test.class).description());
//        placeOnMarketPage= basePage.goToMarket();
//        placeOnMarketPage= basePage.goToMarket();
    }

//    @Test
    public void tc1()
    {
        System.out.println(basePage.getURL());
    }

//    @Test
    public void tc2() throws InterruptedException {
        System.out.println(basePage.getTitle());
    }

    @AfterMethod
    public void afterMethod() {

    }

    @AfterTest
    public void afterTest()
    {
//        basePage.closeBrowser();
    }
}
