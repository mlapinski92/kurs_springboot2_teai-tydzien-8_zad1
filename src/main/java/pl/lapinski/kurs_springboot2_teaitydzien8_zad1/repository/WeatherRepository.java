package pl.lapinski.kurs_springboot2_teaitydzien8_zad1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.lapinski.kurs_springboot2_teaitydzien8_zad1.model.Model;

@Repository
public interface WeatherRepository extends JpaRepository <Model, Long> {

}
