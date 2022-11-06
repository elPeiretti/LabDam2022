package com.mdgz.dam.labdam2022.persistencia.room;

import android.content.Context;

import com.mdgz.dam.labdam2022.model.Favorito;
import com.mdgz.dam.labdam2022.model.Reserva;
import com.mdgz.dam.labdam2022.persistencia.InterfacesDataSource.ReservaDataSource;
import com.mdgz.dam.labdam2022.persistencia.room.dao.ReservaDAO;

import java.util.ArrayList;
import java.util.List;

public class ReservaRoomDataSource implements ReservaDataSource {

    private ReservaDAO reservaDAO;


    public ReservaRoomDataSource(Context ctx) {
        MyDatabase bdd = MyDatabase.getInstance(ctx);
        reservaDAO = bdd.reservaDAO();
    }


    @Override
    public void getAllReservas(GetAllReservasCallback callback) {
        List<Reserva> reservas = new ArrayList<Reserva>();
        reservas.addAll(reservaDAO.loadAllReservas());
        callback.onResult(reservas);
    }

    @Override
    public void saveReserva(SaveReservaCallback callback, Reserva r) {
        reservaDAO.insertReserva(r);
        callback.onResult();
    }
}
