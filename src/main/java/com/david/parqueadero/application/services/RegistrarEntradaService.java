package com.david.parqueadero.application.services;

import com.david.parqueadero.application.usecases.RegistrarEntrada.VerificarVehiculoNoActivoUseCase;
import com.david.parqueadero.application.usecases.RegistrarEntrada.RevisarDisponibilidadUseCase;
import com.david.parqueadero.application.usecases.RegistrarEntrada.GuardarParqueoUseCase;
import com.david.parqueadero.domain.model.enums.TipoVehiculo;

public class RegistrarEntradaService {
    private final VerificarVehiculoNoActivoUseCase verificarVehiculoNoActivoUseCase;
    private final RevisarDisponibilidadUseCase revisarDisponibilidadUseCase;
    private final GuardarParqueoUseCase guardarParqueoUseCase;

    public RegistrarEntradaService(VerificarVehiculoNoActivoUseCase verificarVehiculoNoActivoUseCase, RevisarDisponibilidadUseCase revisarDisponibilidadUseCase, GuardarParqueoUseCase guardarParqueoUseCase) {
        this.verificarVehiculoNoActivoUseCase = verificarVehiculoNoActivoUseCase;
        this.revisarDisponibilidadUseCase = revisarDisponibilidadUseCase;
        this.guardarParqueoUseCase = guardarParqueoUseCase;
    }

    public void registrarEntrada(String placa, TipoVehiculo tipo) {
        verificarVehiculoNoActivoUseCase.verificarVehiculoNoActivo(placa);
        revisarDisponibilidadUseCase.revisarDisponibilidad(tipo);
        guardarParqueoUseCase.guardarParqueo(placa, tipo);
    }
}
