package ar.edu.utn.frba.dds.service;

import ar.edu.utn.frba.dds.client.WeatherApiClient;
import ar.edu.utn.frba.dds.client.dto.WeatherApiResponse;
import ar.edu.utn.frba.dds.domain.RegistroClima;
import ar.edu.utn.frba.dds.repository.RegistroClimaRepository;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@Builder

public class WeatherFetchService {


    private final WeatherApiClient weatherApiClient;
    private final RegistroClimaRepository registroClimaRepository;

    public void obtenerYGuardarClima() {

        WeatherApiResponse respuesta = weatherApiClient.obtenerClimaActual();

        RegistroClima registroClima = RegistroClima.builder()
                .ciudad(respuesta.getCiudad().getNombre())
                .temperatura(respuesta.getClimaActual().getTemperatura())
                .humedad(respuesta.getClimaActual().getHumedad())
                .fechaCaptura(LocalDateTime.now())
                .build();

        registroClimaRepository.save(registroClima);
    }
}