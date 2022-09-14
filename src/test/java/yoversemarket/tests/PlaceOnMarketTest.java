package yoversemarket.tests;

import org.testng.annotations.Test;

import java.awt.*;

public class PlaceOnMarketTest extends BaseTest {

//    @Test
    public void TC1_OpenPageOwned() throws InterruptedException, AWTException {
        placeOnMarketPage.clickMyMenuAccount();
        placeOnMarketPage.clickMyProfile();
        placeOnMarketPage.clickTabOwned();
        placeOnMarketPage.selectNFT("354");
        placeOnMarketPage.clickNFTDetailPlaceOnMarket();
        placeOnMarketPage.clickFieldDuration();
        placeOnMarketPage.clickDropdownDateRange();
        placeOnMarketPage.selectDateRange( "24" );
        placeOnMarketPage.clickConfirmDateRange();
        placeOnMarketPage.clickDropDownToken();
        placeOnMarketPage.selectTokenStar();
        placeOnMarketPage.inputAmount( "123" );
        placeOnMarketPage.clickButtonPlaceOnMarket();
    }
    @Test
    public void TC2_Timed_Auction() throws InterruptedException, AWTException {
        placeOnMarketPage.clickMyMenuAccount();
        placeOnMarketPage.clickMyProfile();
        placeOnMarketPage.clickTabOwned();
        placeOnMarketPage.selectNFT("228");
        placeOnMarketPage.clickNFTDetailPlaceOnMarket();
        placeOnMarketPage.clickTabTimedAuction();
        placeOnMarketPage.clickFieldDuration();
        placeOnMarketPage.clickDropdownDateRange();
        placeOnMarketPage.selectDateRange( "24" );
        placeOnMarketPage.clickConfirmDateRange();
        /**/
        placeOnMarketPage.clickDropdownMiniumBidIncrement();
        placeOnMarketPage.selectBidIncrement( "10%" );
        /**/
        placeOnMarketPage.clickDropdownStartingPrice();
        placeOnMarketPage.selectTokenStarDropdownStartingPrice();
        placeOnMarketPage.inputAmount( "11" );
        /**/
        placeOnMarketPage.enableToggleOptionBuyNow();
        placeOnMarketPage.inputAmountBuyNow( "110" );
        placeOnMarketPage.clickButtonPlaceOnMarket();

    }
}
