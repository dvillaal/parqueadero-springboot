package com.david.parqueadero.infraestructure.services;

import com.david.parqueadero.domain.model.Vehiculo;
import com.david.parqueadero.domain.port.out.VehiculoRepositoryPort;
import com.david.parqueadero.infraestructure.repositories.JpaVehiculoRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class VehiculoService implements VehiculoRepositoryPort {
    private final JpaVehiculoRepository jpaRepository;

    public VehiculoService(JpaVehiculoRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public void guardarVehiculo(com.david.parqueadero.domain.model.Vehiculo vehiculo) {
        jpaRepository.save(vehiculo);
    }

    @Override
    public Optional<Vehiculo> buscarPorPlaca(String placa) {
        return jpaRepository.findByPlaca(placa);
    }
}
