package com.david.parqueadero.infraestructure.adapters;

import com.david.parqueadero.domain.model.Vehiculo;
import com.david.parqueadero.domain.port.out.VehiculoRepositoryPort;
import com.david.parqueadero.infraestructure.repositories.JpaVehiculoRepository;

import java.util.Optional;

public class VehiculoRepositoryAdapter implements VehiculoRepositoryPort {
    private final JpaVehiculoRepository jpaRepository;

    public VehiculoRepositoryAdapter(JpaVehiculoRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public void guardarVehiculo(com.david.parqueadero.domain.model.Vehiculo vehiculo) {
        jpaRepository.save(vehiculo);
    }

    @Override
    public Optional<Vehiculo> buscarPorPlaca(String placa) {
        return jpaRepository.buscarPorPlaca(placa);
    }
}
