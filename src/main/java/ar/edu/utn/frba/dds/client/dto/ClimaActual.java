package ar.edu.utn.frba.dds.client.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor


public class ClimaActual {
    @JsonProperty("temp_c")
    private double temperatura;
    @JsonProperty("humidity")
    private int humedad;

    public ClimaActual() {
    }

}
