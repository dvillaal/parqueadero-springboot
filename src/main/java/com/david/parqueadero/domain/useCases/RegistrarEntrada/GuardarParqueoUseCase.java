package com.david.parqueadero.domain.useCases.RegistrarEntrada;

import com.david.parqueadero.domain.model.Parqueo;
import com.david.parqueadero.domain.model.Vehiculo;
import com.david.parqueadero.domain.model.enums.TipoVehiculo;
import com.david.parqueadero.domain.port.out.ParqueoRepositoryPort;
import com.david.parqueadero.domain.port.out.VehiculoRepositoryPort;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
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
