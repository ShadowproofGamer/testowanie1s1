package testy;
import labunittest.UrlObject;
import labunittest.WeatherDownloader;
import labunittest.WeatherDownloadWorker;
import labunittest.WeatherObject;
import org.junit.Test;

import javax.xml.ws.http.HTTPException;
import java.security.InvalidParameterException;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TestWeatherDownloader {
    private WeatherDownloader weatherDownloader;
    WeatherDownloadWorker weatherDownloadWorkerMockito = mock(WeatherDownloadWorker.class);
    UrlObject urlObjectMockito = mock(UrlObject.class);

    @Test(expected = InvalidParameterException.class)
    public void testWeatherDownloaderGetByCityNameInvalidParameterException(){
        when(weatherDownloadWorkerMockito.downloadData()).thenReturn(true);
        HashMap<String, String> map = new HashMap<>();
        map.put("x", "Warsaw");
        when(urlObjectMockito.getParameters()).thenReturn(map);
        this.weatherDownloader = new WeatherDownloader(weatherDownloadWorkerMockito);

        assertEquals(InvalidParameterException.class, weatherDownloader.getByCityName(urlObjectMockito));

    }
    @Test(expected = HTTPException.class)
    public void testWeatherDownloaderGetByCityNameHTTPException(){
        when(weatherDownloadWorkerMockito.downloadData()).thenReturn(false);
        HashMap<String, String> map = new HashMap<>();
        map.put("city", "Warsaw");
        when(urlObjectMockito.getParameters()).thenReturn(map);
        this.weatherDownloader = new WeatherDownloader(weatherDownloadWorkerMockito);

        assertEquals(HTTPException.class, weatherDownloader.getByCityName(urlObjectMockito));

    }
    @Test
    public void testWeatherDownloaderGetByCityNameValid(){
        when(weatherDownloadWorkerMockito.downloadData()).thenReturn(true);
        HashMap<String, String> map = new HashMap<>();
        map.put("city", "Warsaw");
        when(urlObjectMockito.getParameters()).thenReturn(map);
        this.weatherDownloader = new WeatherDownloader(weatherDownloadWorkerMockito);

        System.out.println(weatherDownloader.getByCityName(urlObjectMockito) instanceof WeatherObject);
        //assertEquals(WeatherObject.class, weatherDownloader.getByCityName(urlObjectMockito));

    }
    @Test(expected = InvalidParameterException.class)
    public void testWeatherDownloaderGetByCoordinatesInvalidParameterException(){
        when(weatherDownloadWorkerMockito.downloadData()).thenReturn(true);
        HashMap<String, String> map = new HashMap<>();
        map.put("city", "Warsaw");
        when(urlObjectMockito.getParameters()).thenReturn(map);
        this.weatherDownloader = new WeatherDownloader(weatherDownloadWorkerMockito);

        assertEquals(InvalidParameterException.class, weatherDownloader.getByCoordinates(urlObjectMockito));

    }
    @Test(expected = HTTPException.class)
    public void testWeatherDownloaderGetByCoordinatesHTTPException(){
        when(weatherDownloadWorkerMockito.downloadData()).thenReturn(false);
        HashMap<String, String> map = new HashMap<>();
        map.put("lon", "Warsaw");
        map.put("lat", "Warsaw");
        when(urlObjectMockito.getParameters()).thenReturn(map);
        this.weatherDownloader = new WeatherDownloader(weatherDownloadWorkerMockito);

        assertEquals(HTTPException.class, weatherDownloader.getByCoordinates(urlObjectMockito));

    }
    @Test
    public void testWeatherDownloaderGetByCoordinatesValid(){
        when(weatherDownloadWorkerMockito.downloadData()).thenReturn(true);
        HashMap<String, String> map = new HashMap<>();
        map.put("lon", "Warsaw");
        map.put("lat", "Warsaw");
        when(urlObjectMockito.getParameters()).thenReturn(map);
        this.weatherDownloader = new WeatherDownloader(weatherDownloadWorkerMockito);

        System.out.println(weatherDownloader.getByCoordinates(urlObjectMockito) instanceof WeatherObject);
        //assertEquals(WeatherObject.class, weatherDownloader.getByCoordinates(urlObjectMockito));

    }
}

/*
Kod ma/miał następujące problemy:
1. Trzeba było napisać nowy konstruktor klasy WeatherDownloader aby możliwe było jej właściwe testowanie.
2. Brak możliwości łatwego sprawdzenia prawidłowości pól klasy

 */