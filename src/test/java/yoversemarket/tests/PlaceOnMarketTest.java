package yoversemarket.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import yoversemarket.utils.AccountManager;

import java.awt.*;
import java.lang.reflect.Method;

import static yoversemarket.utils.extentreports.ExtentTestManager.startTest;

public class PlaceOnMarketTest extends BaseTest {

    @BeforeClass
    public void setupAccountPlaceOnMarket()
    {
        accountManager.setLocalStorage("walletconnect","{\"connected\":true,\"accounts\":[\"0x9d5e172e1e2cdfc97093a8e7db2d497e87718a66\"],\"chainId\":41234,\"bridge\":\"https://1bridge.verichains.xyz\",\"key\":\"06cac495aa3a3ff86aac4e638239a55113a224027f2727ce4748bc0352866e3a\",\"clientId\":\"11f94389-3680-4d02-b802-0ce5db5927a5\",\"clientMeta\":{\"description\":\"\",\"url\":\"https://marketplace.dev.rndengineer.org\",\"icons\":[\"https://marketplace.dev.rndengineer.org/assets/logo/apple-touch-icon.png\",\"https://marketplace.dev.rndengineer.org/assets/logo/32x32_png.png\",\"https://marketplace.dev.rndengineer.org/assets/logo/16x16_png.png\"],\"name\":\"VNG Character #125\"},\"peerId\":\"43b9f212-2913-411e-aa8a-63e182ef98e8\",\"peerMeta\":{\"description\":\"YoVerse.dev\",\"url\":\"https://wallet.dev.rndengineer.org/\",\"icons\":[\"https://walletconnect.org/walletconnect-logo.png\"],\"name\":\"YoVerse.dev\"},\"handshakeId\":1664874108191724,\"handshakeTopic\":\"7137b697-e6ac-4ea3-8ba4-273e6e838e1e\"}");
        accountManager.setCookie( "yoversemarket","eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ3YWxsZXRBZGRyZXNzIjoiMHg5ZDVFMTcyRTFFMkNkRkM5NzA5M2E4ZTdkYjJENDk3ZTg3NzE4QTY2IiwiZXhwIjoxNjY1MTMzMzUyfQ.ecIhwUJtkubO4U4v5GQ30NAHCBB3oN2ahpLayh_nAn0",
                "rf_yoversemarket","eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ3YWxsZXRBZGRyZXNzIjoiMHg5ZDVFMTcyRTFFMkNkRkM5NzA5M2E4ZTdkYjJENDk3ZTg3NzE4QTY2IiwiZXhwIjoxNjY2MTcwMTUyfQ.lstiSjo7TJshVGvKxksz0hgMmO1MpN2lp8Qsu___Iuw" );
    }

    @BeforeMethod
    public void beforeMethod(Method method ){
        startTest(method.getName(),method.getAnnotation(Test.class).description());
//        placeOnMarketPage= basePage.goToMarket();
        placeOnMarketPage= basePage.goToMarket();
        placeOnMarketPage.loginAsPlaceOnMarket(accountManager);
    }

//    @Test
    public void TC10_SellNFTFixPrice() throws InterruptedException, AWTException {
        placeOnMarketPage.loginAsPlaceOnMarket(accountManager);
        placeOnMarketPage.clickMyMenuAccount();
        placeOnMarketPage.clickMyProfile();
        placeOnMarketPage.clickTabOwned();
        placeOnMarketPage.selectNFT("VNGCharacter #129");
        placeOnMarketPage.clickNFTDetailPlaceOnMarket();
        placeOnMarketPage.clickFieldDurationFixedPrice();
        placeOnMarketPage.clickDropdownDateRange();
        placeOnMarketPage.selectDateRange( "24 hours" );
        placeOnMarketPage.clickConfirmDateRange();
        placeOnMarketPage.clickDropDownToken();
        placeOnMarketPage.selectTokenStar();
        placeOnMarketPage.inputFixedAmount( "123" );
        placeOnMarketPage.clickButtonPlaceOnMarket();
    }

//    @Test
    public void TC11_SellNFTFixPrice() throws InterruptedException, AWTException {
//        placeOnMarketPage.loginAsPlaceOnMarket(accountManager);
        placeOnMarketPage.clickMyMenuAccount();
        placeOnMarketPage.clickMyProfile();
        placeOnMarketPage.clickTabOwned();
        placeOnMarketPage.selectNFT("VNGCharacter #16");
        placeOnMarketPage.clickNFTDetailPlaceOnMarket();
        placeOnMarketPage.clickFieldDurationFixedPrice();
        placeOnMarketPage.selectYearPopupDuration();
        placeOnMarketPage.selectMonthPopupDuration( "November" );
        placeOnMarketPage.selectDayPopupDuration( "14" );
        placeOnMarketPage.clickConfirmDateRange();
        placeOnMarketPage.clickDropDownToken();
        placeOnMarketPage.selectTokenStar();
        placeOnMarketPage.inputFixedAmount( "123" );
        placeOnMarketPage.clickButtonPlaceOnMarket();
    }
    
//    @Test
    public void TC2_Timed_Auction() throws InterruptedException, AWTException {
//        placeOnMarketPage.loginAsPlaceOnMarket(accountManager);
        placeOnMarketPage.clickMyMenuAccount();
        placeOnMarketPage.clickMyProfile();
        placeOnMarketPage.clickTabOwned();
        placeOnMarketPage.selectNFT("VNGCharacter #16");
        placeOnMarketPage.clickNFTDetailPlaceOnMarket();
        placeOnMarketPage.clickTabTimedAuction();
        placeOnMarketPage.clickFieldDurationTimedAuction();
        placeOnMarketPage.clickDropdownDateRange();
        placeOnMarketPage.selectDateRange( "24 hours" );
        placeOnMarketPage.clickConfirmDateRange();
        /**/
        placeOnMarketPage.clickDropdownMiniumBidIncrement();
        placeOnMarketPage.selectBidIncrement( "20%" );
        /**/
        placeOnMarketPage.clickDropdownStartingPrice();
        placeOnMarketPage.selectTokenStarDropdownStartingPrice();
        placeOnMarketPage.inputAmount( "11" );
        /**/
        placeOnMarketPage.enableToggleOptionBuyNow();
        placeOnMarketPage.inputAmountBuyNow( "110" );
        placeOnMarketPage.clickButtonPlaceOnMarket();
    }
    @Test
    public void TC3_Print_Price() throws InterruptedException {
        placeOnMarketPage.loginAsPlaceOnMarket(accountManager);
        placeOnMarketPage.clickMenuExplore();
        placeOnMarketPage.clickTabCollections();
        placeOnMarketPage.selectCollection( "VNG Character" );
        placeOnMarketPage.clickDropdownSort();
        placeOnMarketPage.selectItemDropdownSort( "Price: low to high" );
        placeOnMarketPage.getPriceListNFT();
        System.out.println("In ne: "+ placeOnMarketPage.getPriceListNFT());

    }
}
