package pl.lapinski.kurs_springboot2_teaitydzien8_zad1.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import pl.lapinski.kurs_springboot2_teaitydzien8_zad1.client.WeatherClient;
import pl.lapinski.kurs_springboot2_teaitydzien8_zad1.model.Model;
import pl.lapinski.kurs_springboot2_teaitydzien8_zad1.repository.WeatherRepository;

@Configuration
@EnableScheduling
public class WeatherService {

    private final String WARSAW = "Warsaw";

    private WeatherRepository weatherRepository;
    private WeatherClient weatherClient;

    @Autowired
    public WeatherService(WeatherRepository weatherRepository, WeatherClient weatherClient) {
        this.weatherRepository = weatherRepository;
        this.weatherClient = weatherClient;
    }

    @Scheduled(fixedDelay = 10000)
    @EventListener(ApplicationReadyEvent.class)
    public void init() {
        Model selectedCityModel = weatherClient.getModelWeather(WARSAW);
        weatherRepository.save(selectedCityModel);
    }

//    @Scheduled(fixedDelay = 10000)
//    public void updateTemperature() {
//        Model selectedCityModel5 = weatherClient.getModelWeather(WARSAW);
//        weatherRepository.updateTemperature(selectedCityModel5.getTemperature());
//    }
}
