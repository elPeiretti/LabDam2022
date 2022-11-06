package com.mdgz.dam.labdam2022.persistencia.room.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.mdgz.dam.labdam2022.model.Reserva;

import java.util.List;

@Dao
public interface ReservaDAO{
    @Query("SELECT * FROM reserva")
    List<Reserva> loadAllReservas();

    @Insert
    void insertReserva(Reserva r);
}
