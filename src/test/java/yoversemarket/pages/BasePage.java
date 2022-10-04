package yoversemarket.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.html5.LocalStorage;
import org.openqa.selenium.html5.WebStorage;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import yoversemarket.utils.AccountManager;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.List;

public class BasePage {

//    public static ChromeDriver driver;


    public static ThreadLocal<WebDriver> drivers = new ThreadLocal<>();

//    public static Cookie cookie;
//    public static LocalStorage local;
    public static Robot robot;

    public static  String urlmarket = "https://marketplace.dev.rndengineer.org/";

    public static WebDriverWait wait;

    public void initDriver(String browser)
    {
        switch (browser) {
            case "chrome":
                System.setProperty( "webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe" );
                drivers.set(new ChromeDriver());
                break;
            case "firefox":
                System.setProperty( "webdriver.gecko.driver", "src/test/resources/drivers/geckodriver.exe" );
                drivers.set(new FirefoxDriver());
                break;
            case "edge":
                System.setProperty( "webdriver.edge.driver", "src/test/resources/drivers/msedgedriver.exe" );
                drivers.set(new EdgeDriver());
                break;
            default:
                throw new IllegalArgumentException( "Nhap lai tml! Co ten cung go sai."+" " + browser+ " khong support" );
        }
    }

    public void startBrowser(String browser){
        initDriver(browser);
        wait = new WebDriverWait(getDriver(), Duration.ofSeconds(30));
        getDriver().manage().window().maximize();
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        getDriver().manage().timeouts().scriptTimeout(Duration.ofSeconds(20));
        getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        getDriver().get(urlmarket);
        getDriver().findElement(By.xpath( "//div[text()='Connect Wallet']//parent::button" )).click();
//        //Use local storage and cookie
//        LocalStorage local = ((WebStorage) getDriver()).getLocalStorage();
////        local.setItem("token", "\"e09d7326-c8cb-34e0-b379-990e4722ce21\"");
//        local.setItem("walletconnect","{\"connected\":true,\"accounts\":[\"0x29e9961a9de0cf9360503eea9cf753fe89d1daea\"],\"chainId\":41234,\"bridge\":\"https://bridge.verichains.xyz\",\"key\":\"c08d1d54fa3940bc4a9ac609cc37872f21fa2ec8c1d499d59dc0c4588e7cf7cb\",\"clientId\":\"a06739dc-d6e5-47e1-992c-8e48945f5981\",\"clientMeta\":{\"description\":\"\",\"url\":\"https://marketplace.dev.rndengineer.org\",\"icons\":[\"https://marketplace.dev.rndengineer.org/assets/logo/apple-touch-icon.png\",\"https://marketplace.dev.rndengineer.org/assets/logo/32x32_png.png\",\"https://marketplace.dev.rndengineer.org/assets/logo/16x16_png.png\"],\"name\":\"YoVerse Market\"},\"peerId\":\"05fa6057-7579-4979-b59d-e0f3573597f7\",\"peerMeta\":{\"description\":\"YoVerse.dev\",\"url\":\"https://wallet.dev.rndengineer.org/\",\"icons\":[\"https://walletconnect.org/walletconnect-logo.png\"],\"name\":\"YoVerse.dev\"},\"handshakeId\":1663731841421748,\"handshakeTopic\":\"6d10251d-9b9b-4869-acd7-ca4afcd965d3\"}");
//        Cookie cookie1 = new Cookie( "yoversemarket","eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ3YWxsZXRBZGRyZXNzIjoiMHgyOWU5OTYxQTlERTBDRjkzNjA1MDNFZWE5Y0Y3NTNmZTg5RDFEQUVBIiwiZXhwIjoxNjY0MDAyNjY0fQ.xcLKIwz8812Xj22O_rVtZyxl4oDGeTSqlo_dI-0Bj8M" );
//        Cookie cookie2 = new Cookie( "rf_yoversemarket","eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ3YWxsZXRBZGRyZXNzIjoiMHgyOWU5OTYxQTlERTBDRjkzNjA1MDNFZWE5Y0Y3NTNmZTg5RDFEQUVBIiwiZXhwIjoxNjY1MDM5NDY0fQ.2nCDNnjY1qRpN8dt10_qm1O6JJEum7RmhKq6LRYA6jQ" );
//        getDriver().manage().addCookie( cookie1 );
//        getDriver().manage().addCookie( cookie2 );
//        getDriver().get("https://marketplace.dev.rndengineer.org/");
    }

    public static WebDriver getDriver()
    {
        return drivers.get();
    }

    public void closeBrowser()
    {
        getDriver().quit();
    }

    public PlaceOnMarketPage goToMarket(){
        getDriver().get(urlmarket);
        return new PlaceOnMarketPage();
    }


//    public LoginPage goToMarket(){
//        getDriver().get(urlmarket);
//        return new LoginPage();
//    }

    public void usingLocalStorage(AccountManager accountManager) {
        LocalStorage local = ((WebStorage) getDriver()).getLocalStorage();
        local.setItem( accountManager.getLocalStorageKey(), accountManager.getLocalStorageValue());
    }

    public void usingCookie(AccountManager accountManager) {
        Cookie cookie = new Cookie(accountManager.getCookieKey1(),accountManager.getCookieValue1());
        getDriver().manage().addCookie( cookie );
        cookie = new Cookie( accountManager.getCookieKey2(), accountManager.getCookieValue2());
        getDriver().manage().addCookie( cookie );
    }



    public MakeOfferPage loginAsMakeOffer(AccountManager accountManager) {
        usingLocalStorage(accountManager);
        usingCookie(accountManager);
        getDriver().get( urlmarket );
        return new MakeOfferPage();
    }

    public String getURL()
    {
        return getDriver().getCurrentUrl();
    }
    public String getTitle() throws InterruptedException {
        Thread.sleep( 2000 );
        return getDriver().getTitle();
    }

    public boolean isAttributePresent(By ele, String attr) {
        boolean result = false;
        try {
            wait.until( ExpectedConditions.attributeToBeNotEmpty( getDriver().findElement( ele ),attr ));
            String value =   getDriver().findElement(ele).getAttribute(attr);
            if (value != null){
                result = true;
            }
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return result;
    }

    public boolean isAttributeNotPresent(By ele, String attr) {
        boolean result = false;
        try {
//            wait.until( ExpectedConditions.visibilityOfElementLocated(sendtoNextButton));
            String value =   getDriver().findElement(ele).getAttribute(attr);
            if (value == null){
                result = true;
            }
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return result;
    }
    public void waitForElementPresent(By ele)
    {
        wait.until( ExpectedConditions.visibilityOfElementLocated(ele));
    }

    public void waitForElementClickable(By ele)
    {
        wait.until( ExpectedConditions.elementToBeClickable(ele));
    }

   public void robotEnter() throws AWTException {
       Robot robot = new Robot();
       robot.keyPress( KeyEvent.VK_ENTER); // Press Enter key
       robot.keyRelease(KeyEvent.VK_ENTER); // Release Enter key
   }

   public void scrollByJS(WebElement ele) throws InterruptedException {
       JavascriptExecutor js = (JavascriptExecutor) getDriver();
       Thread.sleep( 5000 );
       js.executeScript("arguments[0].scrollIntoView(true);", ele);
   }

    public void scrollDownBottomByJS(WebElement ele) throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        Thread.sleep( 5000 );
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)",ele);
    }

    public void scrollByAction(WebElement ele) throws InterruptedException {
        Actions actions = new Actions(getDriver());
        actions.moveToElement(ele);
        Thread.sleep( 2000 );
        actions.perform();
    }

    public void robotScrollDown() throws AWTException {
        Robot robot = new Robot();
        robot.keyPress( KeyEvent.VK_PAGE_DOWN); // Press Enter key
        robot.keyRelease(KeyEvent.VK_PAGE_DOWN); // Release Enter key
    }

}
