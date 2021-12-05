package testy;

import labunittest.*;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class TestUrlParser {
    private UrlParser urlParser;

    @Test(expected = RuntimeException.class)
    public void testUrlParseInvalid0() {
        this.urlParser = new UrlParser();
        UrlObject urlObject = this.urlParser.parseUrl("");
        System.out.println("Test nr 1. " + " Parameters: " + urlObject.getParameters() + " Path: " + urlObject.getPath() + " FullAddress: " + urlObject.getFullAddress() + " Scheme: " + urlObject.getScheme() + " Class: " + urlObject.getClass());
    }

    //1) By city: http://getmyweather.com/byCity?city={cityName}
    //2) By coordinates: http://getmyweather.com/byCoordinates?lat={lat}&lon={lon}
    //Enter url to download weather:
    @Test
    public void testUrlParseValid() {
        this.urlParser = new UrlParser();
        UrlObject urlObject = this.urlParser.parseUrl("http://getmyweather.com/byCity?city=Warsaw");
        System.out.println("Test nr 2. " + " Parameters: " + urlObject.getParameters() + " Path: " + urlObject.getPath() + " FullAddress: " + urlObject.getFullAddress() + " Scheme: " + urlObject.getScheme() + " Class: " + urlObject.getClass());
    }

    @Test
    public void testUrlParseValid2() {
        this.urlParser = new UrlParser();
        UrlObject urlObject = this.urlParser.parseUrl("http://oo.com/byCity?city=Warsaw");
        System.out.println("Test nr 3. " + " Parameters: " + urlObject.getParameters() + " Path: " + urlObject.getPath() + " FullAddress: " + urlObject.getFullAddress() + " Scheme: " + urlObject.getScheme() + " Class: " + urlObject.getClass());
    }

    @Test(expected = RuntimeException.class)
    public void testUrlParseInvalid() {
        this.urlParser = new UrlParser();
        UrlObject urlObject = this.urlParser.parseUrl("httxp://oo.com/byCity?city=Warsaw");
        System.out.println("Test nr 4. " + " Parameters: " + urlObject.getParameters() + " Path: " + urlObject.getPath() + " FullAddress: " + urlObject.getFullAddress() + " Scheme: " + urlObject.getScheme() + " Class: " + urlObject.getClass());
    }

    @Test(expected = RuntimeException.class)
    public void testUrlParseInvalid2() {
        this.urlParser = new UrlParser();
        UrlObject urlObject = this.urlParser.parseUrl("http://oo.com/byCity?city=Warsaw&gigglygiggly");
        System.out.println("Test nr 5. " + " Parameters: " + urlObject.getParameters() + " Path: " + urlObject.getPath() + " FullAddress: " + urlObject.getFullAddress() + " Scheme: " + urlObject.getScheme() + " Class: " + urlObject.getClass());
    }

    @Test
    public void testUrlParseValid3() {
        this.urlParser = new UrlParser();
        UrlObject urlObject = this.urlParser.parseUrl("http://oo.com/byCity");
        System.out.println("Test nr 6. " + " Parameters: " + urlObject.getParameters() + " Path: " + urlObject.getPath() + " FullAddress: " + urlObject.getFullAddress() + " Scheme: " + urlObject.getScheme() + " Class: " + urlObject.getClass());
    }

    @Test
    public void testUrlParseValid4() {
        this.urlParser = new UrlParser();
        UrlObject urlObject = this.urlParser.parseUrl("http://getmyweather.com/byCoordinates?lat=x&lon=y");
        System.out.println("Test nr 7. " + " Parameters: " + urlObject.getParameters() + " Path: " + urlObject.getPath() + " FullAddress: " + urlObject.getFullAddress() + " Scheme: " + urlObject.getScheme() + " Class: " + urlObject.getClass());
    }

    @Test
    public void testUrlParseValid5() {
        this.urlParser = new UrlParser();
        UrlObject urlObject = this.urlParser.parseUrl("https://getmyweather.com/byCoordinates?lat=x");
        System.out.println("Test nr 8. " + " Parameters: " + urlObject.getParameters() + " Path: " + urlObject.getPath() + " FullAddress: " + urlObject.getFullAddress() + " Scheme: " + urlObject.getScheme() + " Class: " + urlObject.getClass());
    }

    @Test
    public void testUrlParseValid6() {
        this.urlParser = new UrlParser();
        UrlObject urlObject = this.urlParser.parseUrl("https:///getmyweather.com/byCoordinates?lat=x&lon=y");
        System.out.println("Test nr 9. " + " Parameters: " + urlObject.getParameters() + " Path: " + urlObject.getPath() + " FullAddress: " + urlObject.getFullAddress() + " Scheme: " + urlObject.getScheme() + " Class: " + urlObject.getClass());
    }
}
/*
Kod ma następujące problemy:
1. Kod nie sprawdza poprawności całego adresu a jedynie nagłówka (czyli zmiana z http:// na http:/// jest niewykrywalna przez kod)
Prowadzi to do takich problemów jak brak pełnego adresu albo przyjmowanie parametrów które nie powinny się tam znaleźć

 */