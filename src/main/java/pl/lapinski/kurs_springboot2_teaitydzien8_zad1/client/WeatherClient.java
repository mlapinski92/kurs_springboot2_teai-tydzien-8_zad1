package pl.lapinski.kurs_springboot2_teaitydzien8_zad1.client;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import pl.lapinski.kurs_springboot2_teaitydzien8_zad1.model.Model;
import pl.lapinski.kurs_springboot2_teaitydzien8_zad1.model.apimodel.Weather;

@Component
public class WeatherClient {

    private Weather weather;

    public WeatherClient() {
    }

    public Model getModelWeather(String location) {
        RestTemplate restTemplate = new RestTemplate();
        weather = restTemplate.getForObject("http://api.weatherstack.com/current?access_key=7a52e47b96dd0cecec2259829a557580&query=" + location,
                Weather.class);

        Model model = new Model(weather.getLocation().getName(),
                weather.getCurrent().getTemperature().toString(),
                weather.getCurrent().getObservationTime());
        return model;
    }
}
