package com.david.parqueadero.domain.useCases.RegistrarSalida;

import com.david.parqueadero.domain.model.Parqueo;
import org.springframework.stereotype.Component;

import java.time.temporal.ChronoUnit;

@Component
public class CalcularTiempoUseCase {
    public long calcularTiempo(Parqueo parqueo) {
        return ChronoUnit.HOURS.between(parqueo.getHoraIngreso(), parqueo.getHoraSalida());
    }
}
