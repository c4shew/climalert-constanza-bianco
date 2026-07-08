package ar.edu.utn.frba.dds.repository;

import ar.edu.utn.frba.dds.domain.RegistroClima;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RegistroClimaRepository
        extends JpaRepository<RegistroClima, Long> {

    Optional<RegistroClima> findTopByOrderByFechaCapturaDesc();

}
