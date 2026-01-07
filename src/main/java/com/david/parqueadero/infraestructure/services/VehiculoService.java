package com.david.parqueadero.infraestructure.services;

import com.david.parqueadero.domain.model.Vehiculo;
import com.david.parqueadero.domain.port.out.VehiculoRepositoryPort;
import com.david.parqueadero.infraestructure.repositories.JpaVehiculoRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class VehiculoService implements VehiculoRepositoryPort {
    private final JpaVehiculoRepository jpaVehiculoRepository;

    public VehiculoService(JpaVehiculoRepository jpaVehiculoRepository) {
        this.jpaVehiculoRepository = jpaVehiculoRepository;
    }

    @Override
    public void guardarVehiculo(Vehiculo vehiculo) {
        jpaVehiculoRepository.save(vehiculo);
    }

    @Override
    public Optional<Vehiculo> buscarPorPlaca(String placa) {
        return jpaVehiculoRepository.findByPlaca(placa);
    }
}
