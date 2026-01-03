package com.david.parqueadero.domain.useCases.RegistrarSalida;

import com.david.parqueadero.domain.model.Parqueo;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class ActualizarTiempoUseCase {

    public Parqueo actualizarTiempo(Parqueo parqueo) {
        parqueo.setHoraSalida(LocalDateTime.now());
        return parqueo;
    }
}
