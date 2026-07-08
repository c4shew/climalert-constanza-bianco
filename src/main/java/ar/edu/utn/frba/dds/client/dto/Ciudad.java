package ar.edu.utn.frba.dds.client.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@AllArgsConstructor
@ToString
public class Ciudad {
    @JsonProperty ("name")
    private String nombre;
    public Ciudad() {
    }
}
