package ar.edu.utn.frba.dds.client.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor

public class WeatherApiResponse {
    @JsonProperty("location")
    private Ciudad ciudad;
    @JsonProperty("current")
    private ClimaActual climaActual;

    public WeatherApiResponse() {
    }
}
