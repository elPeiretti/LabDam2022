package com.mdgz.dam.labdam2022.persistencia.InterfacesDataSource;


import android.content.Context;

import com.mdgz.dam.labdam2022.model.Alojamiento;
import com.mdgz.dam.labdam2022.model.Departamento;
import com.mdgz.dam.labdam2022.model.Habitacion;

import java.util.List;

public interface AlojamientoDataSource {
    List<Departamento> getAllDepartamentos(Context ctx);
    List<Habitacion> getAllHabitaciones(Context ctx);
    List<Alojamiento> getAllAlojamientos(Context ctx);
}
