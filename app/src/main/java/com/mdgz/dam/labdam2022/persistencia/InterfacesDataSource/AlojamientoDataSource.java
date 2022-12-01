package com.mdgz.dam.labdam2022.persistencia.InterfacesDataSource;

import com.mdgz.dam.labdam2022.model.Alojamiento;
import com.mdgz.dam.labdam2022.model.Departamento;
import com.mdgz.dam.labdam2022.model.Habitacion;

import java.util.List;

public interface AlojamientoDataSource  {

    void getAllHabitaciones(OnResult<List<Habitacion>> callback);
    void getAllDepartamentos(OnResult<List<Departamento>> callback);
    void getAllAlojamientos(OnResult<List<Alojamiento>> callback);

}
