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

import java.awt.*;
import java.awt.event.KeyEvent;
import java.time.Duration;

public class BasePage {

//    public static ChromeDriver driver;

    public static ThreadLocal<WebDriver> drivers = new ThreadLocal<>();

    static Cookie cookie;
    static LocalStorage local;
    static Robot robot;

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
//
        initDriver(browser);
        wait = new WebDriverWait(getDriver(), Duration.ofSeconds(20));
        getDriver().manage().window().maximize();
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        getDriver().manage().timeouts().scriptTimeout(Duration.ofSeconds(20));
        getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));

//        Tu quet QRcode
        getDriver().get("https://market.yoverse.io/");
        getDriver().findElement(By.xpath( "//div[text()='Connect Wallet']//parent::button" )).click();
        LocalStorage local = ((WebStorage) getDriver()).getLocalStorage();
//        local.setItem("token", "\"e09d7326-c8cb-34e0-b379-990e4722ce21\"");
        local.setItem("walletconnect","{\"connected\":true,\"accounts\":[\"0x57fdb570cf9ea5569314ffeb85e1e40c3c838862\"],\"chainId\":41000,\"bridge\":\"https://1connect.bshield.io\",\"key\":\"14eeaa32643feb98e2270c6142a8e47ec03398779e42fefca168e9c9450af8a2\",\"clientId\":\"deba431e-e9bd-42e4-94a1-a7d9d0c079b5\",\"clientMeta\":{\"description\":\"\",\"url\":\"https://market.yoverse.io\",\"icons\":[\"https://market.yoverse.io/assets/logo/apple-touch-icon.png\",\"https://market.yoverse.io/assets/logo/32x32_png.png\",\"https://market.yoverse.io/assets/logo/16x16_png.png\"],\"name\":\"YoVerse Market\"},\"peerId\":\"005b3bcd-ae34-4421-882a-9bc4e5f862fa\",\"peerMeta\":{\"description\":\"YoVerse.beta\",\"url\":\"https://wallet.yoverse.io/\",\"icons\":[\"https://walletconnect.org/walletconnect-logo.png\"],\"name\":\"YoVerse.beta\"},\"handshakeId\":1663138159843770,\"handshakeTopic\":\"895affe8-b052-4295-b552-91f44abf4fd6\"}");
        Cookie cookie1 = new Cookie( "yoversemarket","" );
        Cookie cookie2 = new Cookie( "rf_yoversemarket","" );
        getDriver().manage().addCookie( cookie1 );
        getDriver().manage().addCookie( cookie2 );
        getDriver().get("https://market.yoverse.io/");
    }

    public static WebDriver getDriver()
    {
        return drivers.get();
    }

    public void closeBrowser()
    {
        getDriver().quit();
    }

    public String getURL()
    {
        return getDriver().getCurrentUrl();
    }

    public String getTitle() throws InterruptedException {
        Thread.sleep( 2000 );
        return getDriver().getTitle();
    }

    public PlaceOnMarketPage goToMarket(){
        getDriver().get("https://market.yoverse.io/");
        return new PlaceOnMarketPage();
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
