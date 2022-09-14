package yoversemarket.pages;

import org.openqa.selenium.By;

import java.awt.*;

public class PlaceOnMarketPage extends BasePage {

    By myProfile = By.xpath("//button[contains(text(),'Profile')]");
    By tabOwned = By.xpath("//div[@id='tab-1']");
//    By menuAccount = By.xpath("//img[@alt='0x76fF17']//parent::div");
    String menuAccount = "//img[@alt='%s']//parent::div";
    By tabOnMarket = By.xpath("//button[contains(text(),'Market')]");
    String listNFT = "//h2[contains(.,'230')]//parent::a";
    By bttNFTDetailPlaceOnMarket = By.xpath("//button[@type='button' and contains(text(),'Place')]");
    By fieldDuration = By.xpath("//div[@role='group']");
    By dropdownDateRange = By.xpath("//div[contains(text(),'Date')]//following-sibling::div");
    String listValueDateRange = "//div[contains(text(),'%s')]";
    By confirmDateRange = By.xpath("//button[@type='button' and contains(text(),'Confirm')]");
    By dropdownPrice = By.xpath("//button[@id='menu-button-price-token']");
    By dropdownPriceTokenStar = By.xpath("//button[@data-index='0']");
    By dropdownPriceTokenYove = By.xpath("//button[@data-index='1']");
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

    public void clickFieldDuration()
    {
        waitForElementPresent(fieldDuration);
        getDriver().findElement(fieldDuration).click();
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
    public void clickMyMenuAccount(String value) throws InterruptedException {
        menuAccount = String.format( menuAccount,value );
        Thread.sleep( 500 );
        getDriver().findElement( By.xpath( menuAccount ) ).click();
    }
    public void clickMyProfile()
    {
        waitForElementPresent(myProfile);
        getDriver().findElement(myProfile).click();
    }
    public void clickTabOwned() throws InterruptedException, AWTException {
//        waitForElementPresent(tabOnMarket);
//        Thread.sleep( 5000 );
//        scrollByAction( getDriver().findElement(tabOnMarket) );
//        robotScrollDown();
//        Thread.sleep( 3000 );
        waitForElementPresent(tabOwned);
        waitForElementClickable(tabOwned);
//        scrollByJS( getDriver().findElement(tabOwned));
//        scrollByAction( getDriver().findElement( tabOwned ) );
        getDriver().findElement(tabOwned).click();
    }

}
