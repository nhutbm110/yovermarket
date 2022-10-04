package yoversemarket.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.html5.LocalStorage;
import org.openqa.selenium.html5.WebStorage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import yoversemarket.utils.AccountManager;

import java.awt.*;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PlaceOnMarketPage extends BasePage {

    By myProfile = By.xpath("//div[contains(text(),'Profile')]/parent::button");
    By tabOwned = By.xpath("//div[@id='tab-1']");
    By menuAccount = By.xpath("//div[@id='header-profile-avatar']");

    By tabCollections = By.xpath("//div[@role='tablist']//button[contains(text(),'Collection')]");
    By menuExplore = By.xpath("//div[text()='Explore']/parent::*");
    By tabOnMarket = By.xpath("//button[contains(text(),'Market')]");
//    String listNFT = "//h2[contains(.,'%s')]//parent::a";
    String listNFT = "//div[contains(text(),'%s')]//parent::a";
    String listCollections = "//a[text()='%s']/parent::div";
    By logoBottom = By.xpath("//img[contains(@src,'assets/images/market_white_svg.svg')]");
    By priceListNFT= By.xpath("//div[contains(@id,'nft-card-price' ) and text()='Price']//following-sibling::div");
    By bttNFTDetailPlaceOnMarket = By.xpath("//button[@type='button' and contains(text(),'Place')]");
    By fieldDurationFixedPrice = By.xpath("//div[@id='fixed-price-duration']");
    By fieldDurationTimedAuction = By.xpath("//div[@id='timed-auction-duration']");
    By dropdownDateRange = By.xpath("//div[contains(text(),'Date')]//following-sibling::div");
    String listValueDateRange = "//div[contains(text(),'%s')]/parent::button";
    By confirmDateRange = By.xpath("//button[@type='button' and contains(text(),'Confirm')]");
    By dropdownPrice = By.xpath("//button[@id='menu-button-price-token']");
    By dropdownPriceTokenStar = By.xpath("//button[@data-index='0']");
    By dropdownPriceTokenYove = By.xpath("//button[@data-index='1']");
    By txtFixedAmount = By.xpath("//input[@id='fixed-price-amount']");
    By txtAmount = By.xpath("//input[@id='price-amount']");
    By bttSaleBidPlaceOnMarket = By.xpath("//div[contains(text(),'Place')]/parent::button");
    By timeAuction = By.xpath("//button[@id='timed-auction']");
    By dropdownBidIncrement = By.xpath("//button[@id='menu-button-minimum-bid-increment']");
    String listBidIncrement = "//div[text()='%s']/parent::button";
    By dropdownStartingPrice = By.xpath("//button[@id='menu-button-start-price-token']");
    By dropdownStartingPriceTokenStar = By.xpath("(//div[text()='STAR']/parent::div)[3]");
    By dropdownStartingPriceTokenYove = By.xpath("(//div[text()='YOVE']/parent::div)[1]");
//    By toggleOptionBuyNow = By.cssSelector( "input#switch-buy-now");
    By toggleOptionBuyNow = By.xpath("//input[@id='switch-buy-now']//following-sibling::span");
    By amountBuyNow = By.xpath("//input[@id='buy-now-amount']");
    By durationChooseYear = By.xpath("//div[@class='react-calendar']//button[contains(@class,'react-calendar__navigation__label')]");
    String durationChooseMonth = "//abbr[contains(text(),'%s')]/parent::button";
    String durationChooseDay = "//abbr[contains(text(),'%s')]/parent::button";
    By dropdownSort = By.xpath("//div[contains(@class,'css-xxul')]");
    String listItemDropdownSort = "//div[contains(text(),'%s')]/parent::button";



    public void clickDropdownSort()
    {
        waitForElementPresent(dropdownSort);
        waitForElementClickable(dropdownSort);
        getDriver().findElement(dropdownSort).click();
    }

    public void selectItemDropdownSort(String value) throws InterruptedException {
        listItemDropdownSort = String.format(listItemDropdownSort,value);
        Thread.sleep( 500 );
        getDriver().findElement(By.xpath(listItemDropdownSort)).click();
//        waitForElementClickable( logoBottom );
//        scrollDownBottomByJS(getDriver().findElement( logoBottom ));
    }

    public void selectMonthPopupDuration(String value) throws InterruptedException {
        durationChooseMonth = String.format(durationChooseMonth,value);
        Thread.sleep( 500 );
        getDriver().findElement(By.xpath(durationChooseMonth)).click();
    }

    public void selectDayPopupDuration(String value) throws InterruptedException {
        durationChooseDay = String.format(durationChooseDay,value);
        Thread.sleep( 500 );
        getDriver().findElement(By.xpath(durationChooseDay)).click();
    }

    public void selectYearPopupDuration()
    {
        waitForElementPresent(durationChooseYear);
        waitForElementClickable(durationChooseYear);
        getDriver().findElement(durationChooseYear).click();
    }

    public List<String> getPriceListNFT() throws InterruptedException {
        waitForElementPresent(priceListNFT);
        List<String> array = new ArrayList<String>();
//        wait.until( ExpectedConditions.visibilityOfElementLocated(priceListNFT));
        waitForElementPresent(priceListNFT);
         List<WebElement> elements  = getDriver().findElements(priceListNFT);
//            for (int i = 0; i < elements.size(); i++)
////            {
//////                String data = getDriver().findElement(priceListNFT).getText();
//////                array.add(data);
////                array.add(elements.get(i).getText());
////            }

            elements.forEach( element -> array.add(element.getText()));
         return array;
    }




    public PlaceOnMarketPage loginAsPlaceOnMarket(AccountManager accountManager) {
        usingLocalStorage(accountManager);
        usingCookie(accountManager);
        getDriver().get( urlmarket );
        return new PlaceOnMarketPage();
    }

    public void clickMenuExplore()
    {
        waitForElementPresent(menuExplore);
        getDriver().findElement(menuExplore).click();
    }

    public void clickTabCollections()
    {
        waitForElementPresent(tabCollections);
        waitForElementClickable(tabCollections);
        getDriver().findElement(tabCollections).click();
    }

    public void selectCollection(String value) throws InterruptedException {
        listCollections = String.format(listCollections,value);
        Thread.sleep( 500 );
        getDriver().findElement(By.xpath(listCollections)).click();
    }

    public void inputAmountBuyNow(String value)
    {
        waitForElementPresent(amountBuyNow);
        getDriver().findElement(amountBuyNow).clear();
        getDriver().findElement(amountBuyNow).sendKeys( value );
    }

    public void enableToggleOptionBuyNow()
    {
        waitForElementPresent(toggleOptionBuyNow);
        waitForElementClickable(toggleOptionBuyNow);
        getDriver().findElement(toggleOptionBuyNow).click();
    }

    public void clickDropdownStartingPrice()
    {
        waitForElementPresent(dropdownStartingPrice);
        waitForElementClickable(dropdownStartingPrice);
        getDriver().findElement(dropdownStartingPrice).click();
    }

    public void selectTokenStarDropdownStartingPrice()
    {
        waitForElementPresent(dropdownStartingPriceTokenStar);
        waitForElementClickable(dropdownStartingPriceTokenStar);
        getDriver().findElement(dropdownStartingPriceTokenStar).click();
    }

    public void selectTokenYoveDropdownStartingPrice()
    {
        waitForElementPresent(dropdownStartingPriceTokenYove);
        getDriver().findElement(dropdownStartingPriceTokenYove).click();
    }


    public void selectBidIncrement(String value) throws InterruptedException {
        listBidIncrement = String.format(listBidIncrement,value);
        Thread.sleep( 500 );
        getDriver().findElement(By.xpath(listBidIncrement)).click();
    }

    public void clickDropdownMiniumBidIncrement()
    {
        waitForElementPresent(dropdownBidIncrement);
        getDriver().findElement(dropdownBidIncrement).click();
    }

    public void clickTabTimedAuction()
    {
        waitForElementPresent(timeAuction);
        getDriver().findElement(timeAuction).click();
    }

    public void clickButtonPlaceOnMarket()
    {
        waitForElementPresent(bttSaleBidPlaceOnMarket);
        getDriver().findElement(bttSaleBidPlaceOnMarket).click();
    }

    public void inputAmount(String value)
    {
        waitForElementPresent(txtAmount);
        getDriver().findElement(txtAmount).clear();
        getDriver().findElement(txtAmount).sendKeys( value );
    }

    public void inputFixedAmount(String value)
    {
        waitForElementPresent(txtFixedAmount);
        getDriver().findElement(txtFixedAmount).clear();
        getDriver().findElement(txtFixedAmount).sendKeys( value );
    }

    public void clickDropDownToken()
    {
        waitForElementPresent(dropdownPrice);
        getDriver().findElement(dropdownPrice).click();
    }
    public void selectTokenStar()
    {
        waitForElementPresent(dropdownPriceTokenStar);
        getDriver().findElement(dropdownPriceTokenStar).click();
    }

    public void selectTokenYove()
    {
        waitForElementPresent(dropdownPriceTokenYove);
        getDriver().findElement(dropdownPriceTokenYove).click();
    }

    public void clickConfirmDateRange()
    {
        waitForElementPresent(confirmDateRange);
        getDriver().findElement(confirmDateRange).click();
    }

    public void clickDropdownDateRange() throws InterruptedException {
        waitForElementPresent(dropdownDateRange);
        Thread.sleep( 500 );
        getDriver().findElement(dropdownDateRange).click();
    }

    public void selectDateRange(String value) throws InterruptedException {
        listValueDateRange = String.format(listValueDateRange,value);
        Thread.sleep( 500 );
        getDriver().findElement(By.xpath(listValueDateRange)).click();
    }

    public void clickFieldDurationFixedPrice()
    {
        waitForElementPresent(fieldDurationFixedPrice);
        getDriver().findElement(fieldDurationFixedPrice).click();
    }

    public void clickFieldDurationTimedAuction()
    {
        waitForElementPresent(fieldDurationTimedAuction);
        getDriver().findElement(fieldDurationTimedAuction).click();
    }

    public void clickNFTDetailPlaceOnMarket() throws InterruptedException {
        waitForElementPresent(bttNFTDetailPlaceOnMarket);
        Thread.sleep( 500 );
        getDriver().findElement(bttNFTDetailPlaceOnMarket).click();
    }
    public void selectNFT(String value) throws InterruptedException, AWTException {
        listNFT = String.format(listNFT,value);
//        Thread.sleep( 1500 );
//        robotScrollDown();
        getDriver().findElement(By.xpath(listNFT)).click();
    }
    public void clickMyMenuAccount(){
//        menuAccount = String.format( menuAccount,value );
        waitForElementPresent( menuAccount );
        getDriver().findElement( menuAccount ).click();
    }
    public void clickMyProfile()
    {
        waitForElementPresent(myProfile);
        getDriver().findElement(myProfile).click();
    }
    public void clickTabOwned() throws InterruptedException {
        waitForElementPresent(tabOwned);
        waitForElementClickable(tabOwned);
        getDriver().findElement(tabOwned).click();
    }
}
