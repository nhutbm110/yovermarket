package yoversemarket.utils;

public class AccountManager {
    public String localStorageKey;
    public String localStorageValue;
    public String cookieKey1;
    public String cookieValue1;
    public String cookieKey2;
    public String cookieValue2;

    public void setLocalStorage(String key, String value)
    {
        localStorageKey = key;
        localStorageValue = value;
    }

    public String getLocalStorageKey()
    {
        return localStorageKey;
    }

    public String getLocalStorageValue()
    {
        return localStorageValue;
    }

    public void setCookie(String key1, String value1, String key2, String value2 )
    {
        cookieKey1 = key1;
        cookieValue1 = value1;
        cookieKey2 = key2;
        cookieValue2 = value2;

    }

    public String getCookieKey1()
    {
        return cookieKey1;
    }

    public String getCookieValue1()
    {
        return cookieValue1;
    }

    public String getCookieKey2()
    {
        return cookieKey2;
    }

    public String getCookieValue2()
    {
        return cookieValue2;
    }

}
