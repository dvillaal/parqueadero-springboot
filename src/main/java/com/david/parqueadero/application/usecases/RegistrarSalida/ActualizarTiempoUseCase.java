package com.david.parqueadero.application.usecases.RegistrarSalida;

import com.david.parqueadero.domain.model.Parqueo;

import java.time.LocalDateTime;

public class ActualizarTiempoUseCase {

    public Parqueo actualizarTiempo(Parqueo parqueo) {
        parqueo.setHoraSalida(LocalDateTime.now());
        return parqueo;
    }
}
