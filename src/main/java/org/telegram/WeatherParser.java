package org.telegram;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class WeatherParser {
    private static final String rp5 = "https://rp5.ru/%D0%9F%D0%BE%D0%B3%D0%BE%D0%B4%D0%B0_%D0%B2_%D0%9A%D0%B8%D0%B5%D0%B2%D0%B5,_%D0%A3%D0%BA%D1%80%D0%B0%D0%B8%D0%BD%D0%B0";
    private static final String gismeteo = "https://www.gismeteo.ua/weather-kyiv-4944/now/";
    private static final String sinoptik = "https://sinoptik.ua/%D0%BF%D0%BE%D0%B3%D0%BE%D0%B4%D0%B0-%D0%BA%D0%B8%D0%B5%D0%B2";

    public static String getRp5Weather() {
        String temperatureNow = "";
        String forecast = "";
        try{
            Document doc = Jsoup.connect(rp5)
                    .userAgent("/Chrome  90.0.4430.93")
                    .referrer("http://google.com")
                    .get();
            temperatureNow = doc.select("#ArchTemp > span.t_0").text();
            String[] forecastTodayRp5 = doc.select("#forecastShort-content > b").text().split(" ");
            forecast = forecastTodayRp5[0] + " " + forecastTodayRp5[1] + " " + forecastTodayRp5[2] + " " + forecastTodayRp5[3].charAt(0)
                    + forecastTodayRp5[3].charAt(1) + " " + forecastTodayRp5[6] + " " + forecastTodayRp5[7] + " " + forecastTodayRp5[8] + " " +forecastTodayRp5[9] + " " +forecastTodayRp5[10];
        } catch (IOException e) {
            System.out.println("Site request error");
            e.printStackTrace();
        }
        return "Сейчас в Киеве " + temperatureNow + "\n" + forecast;
    }

    public static String getGismeteo() {
        String temperatureNow = "";
        String forecast = "";
        try {
            Document doc = Jsoup.connect(gismeteo)
                    .userAgent("/Chrome  90.0.4430.93")
                    .referrer("http://google.com")
                    .get();
        temperatureNow = doc.select("body > section > div.content_wrap > div > div.main > div > div.__frame_sm > div.forecast_frame.forecast_now > div.tabs._left > div > div > div.tab-content > div.tab-weather > div.js_meas_container.temperature.tab-weather__value > span.unit.unit_temperature_c > span").text();
        forecast = doc.select("body > section > div.content_wrap > div > div.main > div > div.__frame_sm > div.forecast_frame.forecast_now > div.forecast_wrap.horizontal > div > div.now__desc > span").text();
        } catch (IOException e) {
            System.out.println("Site request error");
            e.printStackTrace();
        }
        return "Сейчас в Киеве " + temperatureNow + "°C, " + forecast.toLowerCase();
    }
}
