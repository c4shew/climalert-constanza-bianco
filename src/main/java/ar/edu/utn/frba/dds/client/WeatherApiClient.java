package ar.edu.utn.frba.dds.client;

import ar.edu.utn.frba.dds.client.dto.WeatherApiResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class WeatherApiClient {

    private final WebClient webClient;

    @Value("${weather.api.key}") 
    private String apiKey;
    @Value("${weather.api.city}")
    private String ciudad;

    public WeatherApiClient(WebClient webClient) {
        this.webClient = webClient;
    }

    public WeatherApiResponse obtenerClimaActual() {

        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/current.json")
                        .queryParam("key", apiKey)
                        .queryParam("q", ciudad)
                        .queryParam("aqi", "no")
                        .build())
                .retrieve()
                .bodyToMono(WeatherApiResponse.class)
                .block();
    }
}
