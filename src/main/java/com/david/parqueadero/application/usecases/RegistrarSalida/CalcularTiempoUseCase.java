package com.david.parqueadero.application.usecases.RegistrarSalida;

import com.david.parqueadero.domain.model.Parqueo;

import java.time.temporal.ChronoUnit;

public class CalcularTiempoUseCase {
    public long calcularTiempo(Parqueo parqueo) {
        return ChronoUnit.HOURS.between(parqueo.getHoraIngreso(), parqueo.getHoraSalida());
    }
}
