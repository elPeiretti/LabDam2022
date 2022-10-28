package com.mdgz.dam.labdam2022.persistencia.InterfacesDataSource;

import com.mdgz.dam.labdam2022.model.Alojamiento;

import java.util.List;

public interface AlojamientoDataSource {
    interface GetAllAlojamientosCallback {
        void onError();
        void onResult(List<Alojamiento> deptos);
    }

    void getAllAlojamientos(GetAllAlojamientosCallback callback);
}
