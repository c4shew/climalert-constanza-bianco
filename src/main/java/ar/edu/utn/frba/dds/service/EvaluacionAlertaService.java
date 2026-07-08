package ar.edu.utn.frba.dds.service;

import ar.edu.utn.frba.dds.domain.Alerta;
import ar.edu.utn.frba.dds.domain.RegistroClima;
import ar.edu.utn.frba.dds.repository.AlertaRepository;
import ar.edu.utn.frba.dds.repository.RegistroClimaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EvaluacionAlertaService {

    private final RegistroClimaRepository registroClimaRepository;
    private final AlertaRepository alertaRepository;
    private final NotificacionService notificacionService;

    public void evaluarUltimoRegistroClimatico() {

        Optional<RegistroClima> registroOpcional =
                registroClimaRepository.findTopByOrderByFechaCapturaDesc();

        if (registroOpcional.isEmpty()) {
            return;
        }

        RegistroClima registroClima = registroOpcional.get();

        if (registroClima.climaEsCritico()) {

            Alerta alerta = Alerta.builder()
                    .registroClima(registroClima)
                    .fechaCreacion(LocalDateTime.now())
                    .build();

            alertaRepository.save(alerta);

            notificacionService.enviarAlerta(alerta);
        }
    }
}