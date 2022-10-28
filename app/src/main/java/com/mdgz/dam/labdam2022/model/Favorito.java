package com.mdgz.dam.labdam2022.model;

import androidx.annotation.NonNull;
import androidx.room.*;

import java.util.UUID;

@Entity
public class Favorito {

    @PrimaryKey (autoGenerate = true)
    @NonNull
    @ColumnInfo(name="ID_FAVORITO")
    private Integer id;
    @ColumnInfo(name="ID_ALOJAMIENTO")
    private UUID alojamientoID;
    @ColumnInfo(name="ID_USUARIO")
    private UUID usuarioID;

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
