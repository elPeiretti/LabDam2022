package com.mdgz.dam.labdam2022.persistencia.room.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.mdgz.dam.labdam2022.model.Reserva;
import com.mdgz.dam.labdam2022.persistencia.room.entities.ReservaEntity;

import java.util.List;

@Dao
public interface ReservaDAO{
    @Query("SELECT * FROM reservaentity")
    List<ReservaEntity> loadAllReservas();

    @Insert
    void insertReserva(ReservaEntity r);
}
