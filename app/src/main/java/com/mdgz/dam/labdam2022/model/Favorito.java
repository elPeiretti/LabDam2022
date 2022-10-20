package com.mdgz.dam.labdam2022.model;

import androidx.annotation.NonNull;
import androidx.room.*;

import java.util.UUID;

@Entity
public class Favorito {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name="ID_FAVORITO")
    private UUID id;

    @ColumnInfo(name="ID_ALOJAMIENTO")
    private UUID alojamientoID;
    @ColumnInfo(name="ID_USUARIO")
    private UUID usuarioID;

    public Favorito(){
        this.id=UUID.randomUUID();
    }
}
