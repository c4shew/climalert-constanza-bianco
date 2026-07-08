package ar.edu.utn.frba.dds.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "registros_clima")

public class RegistroClima {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String ciudad;
    private double temperatura;
    private int humedad;
    private LocalDateTime fechaCaptura;

    public boolean climaEsCritico() {
        return temperatura>35 && humedad>60;
    }
}
