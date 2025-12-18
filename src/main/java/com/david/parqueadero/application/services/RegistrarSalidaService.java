package com.david.parqueadero.application.services;

import com.david.parqueadero.application.usecases.RegistrarSalida.*;
import com.david.parqueadero.domain.model.Parqueo;

import java.math.BigDecimal;

public class RegistrarSalidaService {
    private final VerificarVehiculoActivoUseCase verificarVehiculoActivoUseCase;
    private final ActualizarTiempoUseCase actualizarTiempoUseCase;
    private final CalcularTiempoUseCase calcularTiempoUseCase;
    private final CalcularCobroUseCase calcularCobroUseCase;
    private final ActualizarCobroUseCase actualizarCobroUseCase;
    private final ActualizarParqueoUseCase actualizarParqueoUseCase;

    public RegistrarSalidaService(VerificarVehiculoActivoUseCase verificarVehiculoActivoUseCase, ActualizarTiempoUseCase actualizarTiempoUseCase, CalcularTiempoUseCase calcularTiempoUseCase, CalcularCobroUseCase calcularCobroUseCase, ActualizarParqueoUseCase actualizarParqueoUseCase, ActualizarCobroUseCase actualizarCobroUseCase) {
        this.verificarVehiculoActivoUseCase = verificarVehiculoActivoUseCase;
        this.actualizarTiempoUseCase = actualizarTiempoUseCase;
        this.calcularTiempoUseCase = calcularTiempoUseCase;
        this.calcularCobroUseCase = calcularCobroUseCase;
        this.actualizarCobroUseCase = actualizarCobroUseCase;
        this.actualizarParqueoUseCase = actualizarParqueoUseCase;
    }

    public void registrarSalida(String placa) {
        Parqueo parqueoActivo = verificarVehiculoActivoUseCase.verificarVehiculoActivo(placa);
        Parqueo parqueoConTiempo = actualizarTiempoUseCase.actualizarTiempo(parqueoActivo);
        long horasEstacionamiento = calcularTiempoUseCase.calcularTiempo(parqueoConTiempo);
        BigDecimal cobro = calcularCobroUseCase.calcularCobro(parqueoConTiempo, horasEstacionamiento);
        Parqueo parqueoConCobro = actualizarCobroUseCase.actualizarCobro(parqueoConTiempo, cobro);
        actualizarParqueoUseCase.actualizarParqueo(parqueoConCobro);
    }
}
