package ar.edu.utn.frba.dds.scheduler;

import ar.edu.utn.frba.dds.service.EvaluacionAlertaService;
import ar.edu.utn.frba.dds.service.WeatherFetchService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ClimaScheduler {

    private final WeatherFetchService weatherFetchService;
    private final EvaluacionAlertaService evaluacionAlertaService;

    @Scheduled(fixedRateString = "${clima.scheduler.obtener}")
    public void obtenerClima() {
        weatherFetchService.obtenerYGuardarClima();
    }

    @Scheduled(fixedRateString = "${clima.scheduler.evaluar}")
    public void evaluarClima() {
        evaluacionAlertaService.evaluarUltimoRegistroClimatico();
    }
}