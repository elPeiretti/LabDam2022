package com.mdgz.dam.labdam2022.persistencia.repo;

import android.content.Context;

import androidx.room.Room;

import com.mdgz.dam.labdam2022.persistencia.InterfacesDataSource.AlojamientoDAO;
import com.mdgz.dam.labdam2022.model.Alojamiento;
import com.mdgz.dam.labdam2022.model.Departamento;
import com.mdgz.dam.labdam2022.model.Habitacion;
import com.mdgz.dam.labdam2022.model.Hotel;
import com.mdgz.dam.labdam2022.model.Ubicacion;
import com.mdgz.dam.labdam2022.persistencia.bdd.MyDatabase;

import java.util.List;

public class AlojamientoRepository {

    private static final Ubicacion ubicacion1 = new Ubicacion(-42.6,-38.3,"San Martin","1989",CiudadRepository._CIUDADES.get(0));
    private static final Ubicacion ubicacion2 = new Ubicacion(-42.25,-38.2,"Lopez y Planes","2007",CiudadRepository._CIUDADES.get(1));
    private static AlojamientoRepository _REPO = null;
    private AlojamientoDAO alojamientoDao;

    public static final List<Alojamiento> _ALOJAMIENTOS = List.of(
      //  new Departamento(1, "Dpto1", "El primer dpto",2, 120000.0,true, 300d,1, ubicacion1, R.drawable.depto1),
            new Departamento(1, "Dpto1", "El primer dpto",2, 120000.0,true, 300d,1, ubicacion1, "https://imgar.zonapropcdn.com/avisos/1/00/47/80/48/58/720x532/1765004636.jpg"),
       // new Departamento(2, "Dpto2", "El segundo dpto",1, 25000.0,false, 100d,1, ubicacion1,R.drawable.depto2),
            new Departamento(2, "Dpto2", "El segundo dpto",1, 25000.0,false, 100d,1, ubicacion1,"https://cf.bstatic.com/xdata/images/hotel/max1024x768/242172610.jpg?k=7a80e01d5d1f41c65c05f3b36705dccdb97d26dc47417d5b5440ea3217925001&o=&hp=1"),
        // new Departamento(3, "Dpto3", "El tercer dpto",10, 290000.0,true, 600d,5, ubicacion2,R.drawable.depto3),
            new Departamento(3, "Dpto3", "El tercer dpto",10, 290000.0,true, 600d,5, ubicacion2,"https://cf.bstatic.com/xdata/images/hotel/270x200/283211646.jpg?k=b5f5623d636426ad7579429591fad7fab0d174bb428d4b409ff2606bc3c7c5f3&o="),
       // new Habitacion(1,"habitacion1","una habitacion",1,3000d,1,0,false, new Hotel(1,"Hotel 1",3,ubicacion2),R.drawable.habitacion1),
            new Habitacion(1,"habitacion1","una habitacion",1,3000d,1,0,false, new Hotel(1,"Hotel 1",3,ubicacion2),"https://media-cdn.tripadvisor.com/media/photo-s/0f/03/33/f1/habitacion-individual.jpg"),
      //  new Habitacion(2,"habitacion2","otra habitacion",3,12500d,1,1,false, new Hotel(1,"Hotel 1",3,ubicacion2),R.drawable.habitacion2)
            new Habitacion(2,"habitacion2","otra habitacion",3,12500d,1,1,false, new Hotel(1,"Hotel 1",3,ubicacion2),"https://media-cdn.tripadvisor.com/media/photo-s/0f/52/9e/83/habitacion-estudio-cama.jpg")
    );

    private AlojamientoRepository(Context ctx){
        MyDatabase bdd = Room.databaseBuilder(ctx,MyDatabase.class,"dam-2022").allowMainThreadQueries().build();
        alojamientoDao = bdd.alojamientoDAO();
    }

    public static AlojamientoRepository getInstance(Context ctx){
        return (_REPO==null) ? _REPO = new AlojamientoRepository(ctx) : _REPO;
    }
    public void agregarDepto(Departamento d){
        alojamientoDao.insertDepartamento(d);
    }

    public List<Alojamiento> listaAlojamientos(){
        return  _ALOJAMIENTOS;
    }
}
