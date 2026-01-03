package com.david.parqueadero.infraestructure.repositories;

import com.david.parqueadero.domain.model.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JpaVehiculoRepository extends JpaRepository<Vehiculo, String> {
    Optional<Vehiculo> findByPlaca(String placa);
}
