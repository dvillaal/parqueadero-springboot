package com.david.parqueadero.domain.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
public class Parqueo {

    @Id
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "vehiculo_placa", nullable = false)
    private Vehiculo vehiculo;

    private LocalDateTime horaIngreso;
    private LocalDateTime horaSalida;
    private BigDecimal valorCobrado;

    public  Parqueo(){
    }

    public Parqueo(Vehiculo vehiculo, LocalDateTime horaIngreso) {
        this.id = UUID.randomUUID();
        this.vehiculo = vehiculo;
        this.horaIngreso = horaIngreso;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public LocalDateTime getHoraIngreso() {
        return horaIngreso;
    }

    public LocalDateTime getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(LocalDateTime horaSalida) {
        this.horaSalida = horaSalida;
    }

    public void setValorCobrado(BigDecimal valorCobrado) {
        this.valorCobrado = valorCobrado;
    }
}
