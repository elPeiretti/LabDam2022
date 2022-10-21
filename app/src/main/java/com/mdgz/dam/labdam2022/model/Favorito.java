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

    public Favorito(){
    }
}
