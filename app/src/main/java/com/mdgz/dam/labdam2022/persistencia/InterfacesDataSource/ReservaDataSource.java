package com.mdgz.dam.labdam2022.persistencia.InterfacesDataSource;

import com.mdgz.dam.labdam2022.model.Favorito;
import com.mdgz.dam.labdam2022.model.Reserva;

import java.util.List;

public interface ReservaDataSource {
    interface GetAllReservasCallback {
        void onError();
        void onResult(List<Reserva> favs);
    }
    interface SaveReservaCallback {
        void onError();
        void onResult();
    }

    void getAllReservas(ReservaDataSource.GetAllReservasCallback callback);
    void saveReserva(ReservaDataSource.SaveReservaCallback callback, Reserva r);
}
