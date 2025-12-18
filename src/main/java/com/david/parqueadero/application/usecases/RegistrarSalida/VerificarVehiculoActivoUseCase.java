package com.david.parqueadero.application.usecases.RegistrarSalida;

import com.david.parqueadero.domain.model.Parqueo;
import com.david.parqueadero.domain.port.out.ParqueoRepositoryPort;

import java.util.Optional;

public class VerificarVehiculoActivoUseCase {
    private final ParqueoRepositoryPort parqueoRepositoryPort;

    public VerificarVehiculoActivoUseCase(ParqueoRepositoryPort parqueoRepositoryPort) {
        this.parqueoRepositoryPort = parqueoRepositoryPort;
    }

    public Parqueo verificarVehiculoActivo(String placa) {
        return parqueoRepositoryPort.buscarActivoPorPlaca(placa)
                .orElseThrow(() -> new IllegalStateException("El vehículo con placa " + placa + " no está activo en el parqueadero."));
    }
}
