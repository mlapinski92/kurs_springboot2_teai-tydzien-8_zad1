package pl.lapinski.kurs_springboot2_teaitydzien8_zad1.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Model {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String location;
    private String temperature;
    private String observationTime;


    public Model(String location, String temperature, String observationTime) {
        this.location = location;
        this.temperature = temperature;
        this.observationTime = observationTime;
    }

    public Model() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getLocaltime() {
        return observationTime;
    }

    public void setLocaltime(String localtime) {
        this.observationTime = localtime;
    }

    @Override
    public String toString() {
        return "Model{" +
                "id=" + id +
                ", location='" + location + '\'' +
                ", temperature='" + temperature + '\'' +
                ", observationTime='" + observationTime + '\'' +
                '}';
    }
}
