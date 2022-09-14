package yoversemarket.tests;

import yoversemarket.pages.BasePage;
import yoversemarket.pages.PlaceOnMarketPage;
import yoversemarket.pages.WalletPage;
import org.testng.annotations.*;

import java.lang.reflect.Method;

import static yoversemarket.utils.extentreports.ExtentTestManager.startTest;

public class BaseTest {
    BasePage basePage;
    PlaceOnMarketPage placeOnMarketPage;
    WalletPage walletPage;

    @Parameters({"browser"})
    @BeforeTest
    public void beforeTest(String browser) throws InterruptedException {
        basePage = new BasePage();
        basePage.startBrowser(browser);
    }

    @BeforeMethod
    public void beforeMethod(Method method ){
        startTest(method.getName(),method.getAnnotation(Test.class).description());
        placeOnMarketPage= basePage.goToMarket();
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
