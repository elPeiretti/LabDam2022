package com.mdgz.dam.labdam2022.persistencia.repo;

import android.content.Context;

import com.mdgz.dam.labdam2022.model.Reserva;
import com.mdgz.dam.labdam2022.persistencia.InterfacesDataSource.ReservaDataSource;
import com.mdgz.dam.labdam2022.persistencia.room.ReservaRoomDataSource;

public class ReservaRepository implements ReservaDataSource {

    private ReservaDataSource reservaDataSource;

    public ReservaRepository(ReservaDataSource reservaDataSource) {
        this.reservaDataSource = reservaDataSource;
    }

    public static ReservaDataSource createInstance(Context ctx) {
        return new ReservaRepository(new ReservaRoomDataSource(ctx));
    }

    @Override
    public void getAllReservas(GetAllReservasCallback callback) {
        reservaDataSource.getAllReservas(callback);
    }

    @Override
    public void saveReserva(SaveReservaCallback callback, Reserva r) {
        reservaDataSource.saveReserva(callback,r);
    }
}
