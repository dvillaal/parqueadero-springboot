package com.david.parqueadero.application.usecases.RegistrarEntrada;

import com.david.parqueadero.domain.model.Parqueo;
import com.david.parqueadero.domain.model.Vehiculo;
import com.david.parqueadero.domain.model.enums.TipoVehiculo;
import com.david.parqueadero.domain.port.out.ParqueoRepositoryPort;
import com.david.parqueadero.domain.port.out.VehiculoRepositoryPort;

import java.time.LocalDateTime;
import java.util.UUID;

public class GuardarParqueoUseCase {
    private final ParqueoRepositoryPort parqueoRepositoryPort;
    private final VehiculoRepositoryPort vehiculoRepositoryPort;

    public GuardarParqueoUseCase(ParqueoRepositoryPort parqueoRepositoryPort, VehiculoRepositoryPort vehiculoRepositoryPort) {
        this.parqueoRepositoryPort = parqueoRepositoryPort;
        this.vehiculoRepositoryPort = vehiculoRepositoryPort;
    }

    public void guardarParqueo(String placa, TipoVehiculo tipo) {

        Vehiculo vehiculo = vehiculoRepositoryPort
                .buscarPorPlaca(placa)
                .orElseGet(() -> {
                    Vehiculo nuevoVehiculo = new Vehiculo(placa, tipo);
                    vehiculoRepositoryPort.guardarVehiculo(nuevoVehiculo);
                    return nuevoVehiculo;
                });

        Parqueo parqueo = new Parqueo(vehiculo, LocalDateTime.now());
        parqueoRepositoryPort.guardarParqueo(parqueo);
    }
}
