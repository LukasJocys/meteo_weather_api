package lt.lukas.weatherapi.service;

import org.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class WeatherService {

    private final RestTemplate restTemplate = new RestTemplate();

    public String getTemperature(String city) {
        String url = "https://api.meteo.lt/v1/places/" + city + "/forecasts/long-term";
        String response = restTemplate.getForObject(url, String.class);

        JSONObject jsonObject = new JSONObject(response);

        return jsonObject.getJSONArray("forecastTimestamps").getJSONObject(0).getBigDecimal("airTemperature").toString();
    }

    public String getCondition(String city) {
        String url = "https://api.meteo.lt/v1/places/" + city + "/forecasts/long-term";
        String response = restTemplate.getForObject(url, String.class);

        JSONObject jsonObject = new JSONObject(response);

        return jsonObject.getJSONArray("forecastTimestamps").getJSONObject(0).getString("conditionCode");
    }
}

