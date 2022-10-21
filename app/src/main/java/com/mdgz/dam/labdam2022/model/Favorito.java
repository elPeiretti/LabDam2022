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
    private Integer alojamientoID;
    @ColumnInfo(name="ID_USUARIO")
    private Integer usuarioID;

    @NonNull
    public Integer getId() {
        return id;
    }

    public void setId(@NonNull Integer id) {
        this.id = id;
    }

    public Integer getAlojamientoID() {
        return alojamientoID;
    }

    public void setAlojamientoID(Integer alojamientoID) {
        this.alojamientoID = alojamientoID;
    }

    public Integer getUsuarioID() {
        return usuarioID;
    }

    public void setUsuarioID(Integer usuarioID) {
        this.usuarioID = usuarioID;
    }

    public Favorito(){
    }
}
