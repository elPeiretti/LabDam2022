package com.mdgz.dam.labdam2022.persistencia.InterfacesDataSource;

import com.mdgz.dam.labdam2022.model.Favorito;
import com.mdgz.dam.labdam2022.model.Reserva;

import java.util.List;
import java.util.UUID;

public interface ReservaDataSource {
    interface GetAllReservasCallback {
        void onError();
        void onResult(List<Reserva> res);
    }
    interface SaveReservaCallback {
        void onError();
        void onResult();
    }
    interface RemoveReservaCallback {
        void onError();
        void onResult();
    }

    void getAllReservas(ReservaDataSource.GetAllReservasCallback callback);
    void saveReserva(ReservaDataSource.SaveReservaCallback callback, Reserva r);
    void removeReserva(ReservaDataSource.RemoveReservaCallback callback, UUID reservaId);
}
