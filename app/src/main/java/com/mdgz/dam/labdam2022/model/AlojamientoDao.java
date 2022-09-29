package com.mdgz.dam.labdam2022.model;

import java.util.ArrayList;
import java.util.List;

public class AlojamientoDao {

    public List<Alojamiento> list(){
        List<Alojamiento> lista = new ArrayList();
        lista.add(new Departamento(1, "Dpto1", "El primer dpto", 2, 300000.0));
        lista.add(new Departamento(2, "Dpto2", "El segundo dpto", 3, 300000.0));
        lista.add(new Departamento(3, "Dpto3", "El tercer dpto", 5, 300000.0));

        return lista;

}
}
