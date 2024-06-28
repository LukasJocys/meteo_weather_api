package lt.lukas.weatherapi.controller;

import lt.lukas.weatherapi.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Controller

public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    //http://localhost:8080/weather?city=vilnius
    @GetMapping("/weather")
    public String getWeather(@RequestParam String city, Model model) {
        String temperature = weatherService.getTemperature(city);
        String condition = weatherService.getCondition(city);

        model.addAttribute("city",
                city.substring(0, 1).toUpperCase() +
                        city.substring(1).toLowerCase());
        model.addAttribute("temperature", temperature + "°C");
        model.addAttribute("condition", condition);

        return "weather";
    }

    //http://localhost:8080/allcities
    @GetMapping("/allcities")
    public String getAllCitiesWeather(Model model) {
        String[] cities = {"vilnius", "kaunas", "klaipeda", "birzai", "panevezys"};
        Map<String, Map<String, String>> cityWeatherData = new HashMap<>();

        for (String city : cities) {
            Map<String, String> weatherData = new HashMap<>();
            weatherData.put("temperature", weatherService.getTemperature(city));
            weatherData.put("condition", weatherService.getCondition(city));
            cityWeatherData.put(city, weatherData);
        }

        model.addAttribute("cityWeatherData", cityWeatherData);

        return "allcities";
    }

}
