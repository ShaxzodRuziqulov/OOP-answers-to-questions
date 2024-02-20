package waether;

import java.util.Date;
import java.util.Scanner;

class WeatherData {
    private Date date;
    private Double temperature;
    private Double humadity;
    private String condition;

    public WeatherData(Date date, Double temperature, Double humadity, String condition) {
        this.date = date;
        this.temperature = temperature;
        this.humadity = humadity;
        this.condition = condition;
    }

    public Date getDate() {
        return date;
    }

    public Double getTemperature() {
        return temperature;
    }

    public Double getHumadity() {
        return humadity;
    }

    public String getCondition() {
        return condition;
    }
}

class WeatherForecast {
    private Date date;
    private String Forecast;

    public WeatherForecast(Date date, String forecast) {
        this.date = date;
        Forecast = forecast;
    }

    public Date getDate() {
        return date;
    }

    public String getForecast() {
        return Forecast;
    }
}

class WeatherApp {
    private WeatherForecast weatherForecast;
    private WeatherData currentWeather;

    public WeatherApp(WeatherData currentWeather, WeatherForecast weatherForecast) {
        this.weatherForecast = weatherForecast;
        this.currentWeather = currentWeather;
    }

    public void displayCurrentWeather() {
        System.out.println("Current Weather: ");
        System.out.println("Date :" + currentWeather.getDate());
        System.out.println("Condition " + currentWeather.getCondition());
        System.out.println("Humadity " + currentWeather.getHumadity());
        System.out.println("Temperature " + currentWeather.getTemperature());
    }

    public void displayWeatherForecast() {
        System.out.println("\nWeatherForecast: ");
        System.out.println("Date " + weatherForecast.getDate());
        System.out.println("Forecast " + weatherForecast.getForecast());
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("temperaturani kiriting:");
            Double temperature = scanner.nextDouble();
            System.out.println("namlikni kiriting:");
            Double humadity = scanner.nextDouble();
            System.out.println("holatni kiriting:");
            String condition = scanner.next();
            WeatherData weatherData = new WeatherData(new Date(), temperature, humadity, condition);

            System.out.println(" kutilayotgan holatni kiriting:");
            String forecast = scanner.next();
            WeatherForecast weatherForecast = new WeatherForecast(new Date(), forecast);

            WeatherApp weatherApp = new WeatherApp(weatherData, weatherForecast);
            weatherApp.displayCurrentWeather();
            weatherApp.displayWeatherForecast();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
