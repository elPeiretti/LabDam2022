package com.mdgz.dam.labdam2022.repo;

import com.mdgz.dam.labdam2022.R;
import com.mdgz.dam.labdam2022.model.Alojamiento;
import com.mdgz.dam.labdam2022.model.Departamento;
import com.mdgz.dam.labdam2022.model.Habitacion;
import com.mdgz.dam.labdam2022.model.Hotel;
import com.mdgz.dam.labdam2022.model.Ubicacion;

import java.util.ArrayList;
import java.util.List;

public class AlojamientoRepository {

    private static final Ubicacion ubicacion1 = new Ubicacion(-42.6,-38.3,"San Martin","1989",CiudadRepository._CIUDADES.get(0));
    private static final Ubicacion ubicacion2 = new Ubicacion(-42.25,-38.2,"Lopez y Planes","2007",CiudadRepository._CIUDADES.get(1));

    public static final List<Alojamiento> _ALOJAMIENTOS = List.of(
        new Departamento(1, "Dpto1", "El primer dpto",2, 120000.0,true, 300d,1, ubicacion1, R.drawable.depto1),
        new Departamento(2, "Dpto2", "El segundo dpto",1, 25000.0,false, 100d,1, ubicacion1,R.drawable.depto2),
        new Departamento(3, "Dpto3", "El tercer dpto",10, 290000.0,true, 600d,5, ubicacion2,R.drawable.depto3),
        new Habitacion(1,"habitacion1","una habitacion",1,3000d,1,0,false, new Hotel(1,"Hotel 1",3,ubicacion2),R.drawable.habitacion1),
        new Habitacion(2,"habitacion2","otra habitacion",3,12500d,1,1,false, new Hotel(1,"Hotel 1",3,ubicacion2),R.drawable.habitacion2)
    );

    public List<Alojamiento> listaAlojamientos(){
        return  _ALOJAMIENTOS;
    }
}
