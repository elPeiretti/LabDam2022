package com.mdgz.dam.labdam2022.persistencia.retrofit.entity;

import java.util.Date;
import java.util.UUID;

public class ReservaRF {

    private String alojamientoId;
    private String usuarioId;
    private String fechaIngreso;
    private String fechaSalida;


    public ReservaRF(){}
    public ReservaRF(String alojId, String userId, String fechaIngreso,String fechaSalida){
        this.alojamientoId = alojId;
        this.usuarioId = userId;
        this.fechaIngreso = fechaIngreso;
        this.fechaSalida = fechaSalida;
    }

    public String getAlojamientoId() {
        return alojamientoId;
    }

    public String getUsuarioId() {
        return usuarioId;
    }

    public String getFechaIngreso() { return fechaIngreso; }

    public String getFechaSalida() { return fechaSalida; }

}
