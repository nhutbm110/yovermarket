package yoversemarket.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.html5.LocalStorage;
import org.openqa.selenium.html5.WebStorage;
import yoversemarket.utils.AccountManager;

public class LoginPage extends BasePage {

    By bttLogin = By.xpath( "//div[text()='Connect Wallet']//parent::button" );

    public void clickLogin() {
        waitForElementPresent( bttLogin );
        getDriver().findElement( bttLogin ).click();
    }

//    public void usingLocalStorage(AccountManager accountManager) {
//        LocalStorage local = ((WebStorage) getDriver()).getLocalStorage();
//        local.setItem( accountManager.getLocalStorageKey(), accountManager.getLocalStorageValue());
//    }
//
//    public void usingCookie(AccountManager accountManager) {
//        Cookie cookie = new Cookie(accountManager.getCookieKey1(),accountManager.getCookieValue1());
//        getDriver().manage().addCookie( cookie );
//        cookie = new Cookie( accountManager.getCookieKey2(), accountManager.getCookieValue2());
//        getDriver().manage().addCookie( cookie );
//    }
//
//    public PlaceOnMarketPage loginAsPlaceOnMarket(AccountManager accountManager) {
//        usingLocalStorage(accountManager);
//        usingCookie(accountManager);
//        getDriver().get( urlmarket );
//        return new PlaceOnMarketPage();
//    }
//
//    public MakeOfferPage loginAsMakeOffer(AccountManager accountManager) {
//        usingLocalStorage(accountManager);
//        usingCookie(accountManager);
//        getDriver().get( urlmarket );
//        return new MakeOfferPage();
//    }


}
