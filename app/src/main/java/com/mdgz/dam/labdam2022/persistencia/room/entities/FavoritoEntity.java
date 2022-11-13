package com.mdgz.dam.labdam2022.persistencia.room.entities;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.util.UUID;

@Entity()
public class FavoritoEntity {

    @PrimaryKey (autoGenerate = true)
    @NonNull
    @ColumnInfo(name="ID_FAVORITO")
    private Integer id;
    @ColumnInfo(name="ID_ALOJAMIENTO")
    private UUID alojamientoID;
    @ColumnInfo(name="ID_USUARIO")
    private UUID usuarioID;

    @Ignore
    public FavoritoEntity(){}

    public FavoritoEntity(Integer id, UUID alojamientoID, UUID usuarioID){
        this.id = id;
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

}
