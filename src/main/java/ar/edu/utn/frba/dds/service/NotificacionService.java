package ar.edu.utn.frba.dds.service;

import ar.edu.utn.frba.dds.domain.Alerta;
import ar.edu.utn.frba.dds.domain.RegistroClima;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NotificacionService {

    private final JavaMailSender enviadoCorreo;

    private static final String[] DESTINATARIOS = {
            "admin@clima.com",
            "emergencias@clima.com",
            "meteorologia@clima.com"
    };

    public void enviarAlerta(Alerta alerta) {

        RegistroClima registroClima = alerta.getRegistroClima();

        SimpleMailMessage mensaje = new SimpleMailMessage();

        mensaje.setTo(DESTINATARIOS);
        mensaje.setSubject("ALERTA CLIMÁTICA");

        mensaje.setText(
                "Se detectó una condición climática crítica.\n\n" +
                        "Ciudad: " + registroClima.getCiudad() + "\n" +
                        "Temperatura: " + registroClima.getTemperatura() + " °C\n" +
                        "Humedad: " + registroClima.getHumedad() + " %\n" +
                        "Fecha de captura: " + registroClima.getFechaCaptura() + "\n" +
                        "Fecha de creación de la alerta: " + alerta.getFechaCreacion()
        );

        enviadoCorreo.send(mensaje);
    }
}