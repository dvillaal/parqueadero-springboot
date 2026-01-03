package com.david.parqueadero.domain.useCases.RegistrarSalida;

import com.david.parqueadero.domain.model.Parqueo;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class ActualizarCobroUseCase {

    public Parqueo actualizarCobro(Parqueo parqueo, BigDecimal cobro) {
        parqueo.setValorCobrado(cobro);
        return parqueo;
    }
}
