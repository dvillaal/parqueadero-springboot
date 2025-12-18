package com.david.parqueadero.application.usecases.RegistrarSalida;

import com.david.parqueadero.domain.model.Parqueo;

import java.math.BigDecimal;

public class ActualizarCobroUseCase {

    public Parqueo actualizarCobro(Parqueo parqueo, BigDecimal cobro) {
        parqueo.setValorCobrado(cobro);
        return parqueo;
    }
}
