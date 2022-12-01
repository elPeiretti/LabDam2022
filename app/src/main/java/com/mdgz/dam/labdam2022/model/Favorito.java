package com.mdgz.dam.labdam2022.model;

import androidx.annotation.NonNull;
import androidx.room.*;

import java.util.UUID;

public class Favorito {

    private Integer id;
    private UUID alojamientoID;
    private UUID usuarioID;

    public Favorito(Integer id, UUID alojamientoID, UUID usuarioID){
        this.id = id;
        this.alojamientoID = alojamientoID;
        this.usuarioID = usuarioID;
    }

    public Favorito(UUID alojamientoID, UUID usuarioID){
        this.alojamientoID = alojamientoID;
        this.usuarioID = usuarioID;
    }

    @NonNull
    public Integer getId() {
        return id;
    }

    public void setId(@NonNull Integer id) {
        this.id = id;
    }

    public UUID getAlojamientoID() {
        return alojamientoID;
    }

    public void setAlojamientoID(UUID alojamientoID) {
        this.alojamientoID = alojamientoID;
    }

    public UUID getUsuarioID() {
        return usuarioID;
    }

    public void setUsuarioID(UUID usuarioID) {
        this.usuarioID = usuarioID;
    }

    public Favorito(){
    }
}
