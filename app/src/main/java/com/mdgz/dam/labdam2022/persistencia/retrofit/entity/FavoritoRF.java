package com.mdgz.dam.labdam2022.persistencia.retrofit.entity;

import java.util.UUID;

public class FavoritoRF {
    private String alojamientoId;
    private String usuarioId;

    public FavoritoRF(){}
    public FavoritoRF(String alojId, String userId){
        this.alojamientoId = alojId;
        this.usuarioId = userId;
    }

    public String getAlojamientoId() {
        return alojamientoId;
    }

    public String getUsuarioId() {
        return usuarioId;
    }
}
