package com.david.parqueadero.domain.port.out;

import com.david.parqueadero.domain.model.Vehiculo;

import java.util.Optional;

public interface VehiculoRepositoryPort {
    Optional<Vehiculo> buscarPorPlaca(String placa);

    void guardarVehiculo(Vehiculo vehiculo);
}
