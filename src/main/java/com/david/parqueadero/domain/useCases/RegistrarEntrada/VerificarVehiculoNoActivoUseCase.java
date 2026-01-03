package com.david.parqueadero.domain.useCases.RegistrarEntrada;

import com.david.parqueadero.domain.port.out.ParqueoRepositoryPort;
import org.springframework.stereotype.Component;

@Component
public class VerificarVehiculoNoActivoUseCase {
    private final ParqueoRepositoryPort parqueoRepositoryPort;

    public VerificarVehiculoNoActivoUseCase(ParqueoRepositoryPort parqueoRepositoryPort) {
        this.parqueoRepositoryPort = parqueoRepositoryPort;
    }

    public void verificarVehiculoNoActivo(String placa) {
        boolean existeParqueoActivo = parqueoRepositoryPort.buscarActivoPorPlaca(placa).isPresent();

        if (existeParqueoActivo) {
            throw new IllegalStateException("El vehículo con placa " + placa + " ya está activo en el parqueadero.");
        }
    }
}
