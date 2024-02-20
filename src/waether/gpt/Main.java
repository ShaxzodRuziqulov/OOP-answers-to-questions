package waether.gpt;
import java.util.Date;

// WeatherData sinfi
class WeatherData {
    private Date date;
    private double temperature;
    private double humidity;
    private String condition;

    public WeatherData(Date date, double temperature, double humidity, String condition) {
        this.date = date;
        this.temperature = temperature;
        this.humidity = humidity;
        this.condition = condition;
    }

    // Getter methods
    public Date getDate() {
        return date;
    }

    public double getTemperature() {
        return temperature;
    }

    public double getHumidity() {
        return humidity;
    }

    public String getCondition() {
        return condition;
    }
}

// WeatherForecast sinfi
class WeatherForecast {
    private Date date;
    private String forecast;

    public WeatherForecast(Date date, String forecast) {
        this.date = date;
        this.forecast = forecast;
    }

    // Getter methods
    public Date getDate() {
        return date;
    }

    public String getForecast() {
        return forecast;
    }
}

// WeatherApp sinfi
class WeatherApp {
    private WeatherData currentWeather;
    private WeatherForecast weatherForecast;

    public WeatherApp(WeatherData currentWeather, WeatherForecast weatherForecast) {
        this.currentWeather = currentWeather;
        this.weatherForecast = weatherForecast;
    }

    // Metodlar
    public void displayCurrentWeather() {
        System.out.println("Current Weather:");
        System.out.println("Date: " + currentWeather.getDate());
        System.out.println("Temperature: " + currentWeather.getTemperature() + "°C");
        System.out.println("Humidity: " + currentWeather.getHumidity() + "%");
        System.out.println("Condition: " + currentWeather.getCondition());
    }

    public void displayWeatherForecast() {
        System.out.println("\nWeather Forecast:");
        System.out.println("Date: " + weatherForecast.getDate());
        System.out.println("Forecast: " + weatherForecast.getForecast());
    }
}

public class Main {
    public static void main(String[] args) {
        // Bugungi ob-havo ma'lumoti
        WeatherData currentWeather = new WeatherData(new Date(), 25.5, 60, "Sunny");

        // Ob-havo bashorati
        WeatherForecast weatherForecast = new WeatherForecast(new Date(), "Partly cloudy");

        // Ob-havo ilovasi yaratish va ma'lumotlarni ko'rsatish
        WeatherApp weatherApp = new WeatherApp(currentWeather, weatherForecast);
        weatherApp.displayCurrentWeather();
        weatherApp.displayWeatherForecast();
    }
}

