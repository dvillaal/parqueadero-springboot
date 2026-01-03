package com.david.parqueadero.domain.useCases.RegistrarEntrada;

import com.david.parqueadero.domain.model.enums.TipoVehiculo;
import org.springframework.stereotype.Component;

@Component
public class RegistrarEntradaUseCase {
    private final VerificarVehiculoNoActivoUseCase verificarVehiculoNoActivoUseCase;
    private final RevisarDisponibilidadUseCase revisarDisponibilidadUseCase;
    private final GuardarParqueoUseCase guardarParqueoUseCase;

    public RegistrarEntradaUseCase(VerificarVehiculoNoActivoUseCase verificarVehiculoNoActivoUseCase, RevisarDisponibilidadUseCase revisarDisponibilidadUseCase, GuardarParqueoUseCase guardarParqueoUseCase) {
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
