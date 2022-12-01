package com.mdgz.dam.labdam2022.persistencia.retrofit.entity;

import java.util.UUID;

public class FavoritoRF {
    private String alojamientoID;
    private String usuarioID;

    public FavoritoRF(){}
    public FavoritoRF(String alojID, String userID){
        this.alojamientoID = alojID;
        this.usuarioID = userID;
    }

    public String getAlojamientoID() {
        return alojamientoID;
    }

    public String getUsuarioID() {
        return usuarioID;
    }
}
