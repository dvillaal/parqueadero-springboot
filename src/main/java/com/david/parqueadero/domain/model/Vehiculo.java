package com.david.parqueadero.domain.model;

import com.david.parqueadero.domain.model.enums.TipoVehiculo;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;

@Entity
public class Vehiculo {

    @Id
    private String placa;

    @Enumerated(EnumType.STRING)
    private TipoVehiculo tipo;

    public Vehiculo(){
    }

    public Vehiculo(String placa, TipoVehiculo tipo) {
        this.placa = placa;
        this.tipo = tipo;
    }

    public String getPlaca() {
        return placa;
    }

    public TipoVehiculo getTipo() {
        return tipo;
    }

}
