package com.mdgz.dam.labdam2022.persistencia.room;

import android.content.Context;

import com.mdgz.dam.labdam2022.ActividadesYFragmentos.AlojamientoRecyclerAdapter;
import com.mdgz.dam.labdam2022.model.Alojamiento;
import com.mdgz.dam.labdam2022.model.Departamento;
import com.mdgz.dam.labdam2022.model.Habitacion;
import com.mdgz.dam.labdam2022.model.Hotel;
import com.mdgz.dam.labdam2022.persistencia.InterfacesDataSource.AlojamientoDataSource;
import com.mdgz.dam.labdam2022.persistencia.room.dao.AlojamientoDAO;
import com.mdgz.dam.labdam2022.persistencia.room.entities.AlojamientoEntity;
import com.mdgz.dam.labdam2022.persistencia.room.entities.DepartamentoEntity;
import com.mdgz.dam.labdam2022.persistencia.room.entities.HabitacionEntity;
import com.mdgz.dam.labdam2022.persistencia.room.entities.HotelEntity;
import com.mdgz.dam.labdam2022.persistencia.room.entities.UbicacionEntity;
import com.mdgz.dam.labdam2022.persistencia.room.mapper.AlojamientoMapper;
import com.mdgz.dam.labdam2022.persistencia.room.mapper.DepartamentoMapper;
import com.mdgz.dam.labdam2022.persistencia.room.mapper.HabitacionMapper;

import java.util.ArrayList;
import java.util.List;

public class AlojamientoRoomDataSource implements AlojamientoDataSource {

    private final AlojamientoDAO alojamientoDao;

    public AlojamientoRoomDataSource(Context ctx){
        MyDatabase bdd = MyDatabase.getInstance(ctx);
        alojamientoDao = bdd.alojamientoDAO();
    }

    @Override
    public void getAllHabitaciones(OnResult<List<Habitacion>> callback) {

        List<HabitacionEntity> he = alojamientoDao.loadAllHabitaciones();
        List<AlojamientoEntity> ae = alojamientoDao.loadAllAlojamientos();
        List<HotelEntity> hoteles = alojamientoDao.loadAllHoteles();
        List<UbicacionEntity> ubicaciones = alojamientoDao.loadAllUbicaciones();

        for(HotelEntity h : hoteles){
            for(UbicacionEntity u : ubicaciones){
                if(h.getIdUbicacion().equals(u.getId())){
                    h.setUbicacionEntity(u);
                    h.setId_ubicacion(u.getId());
                }
            }
        }

        for(HabitacionEntity h : he){
            for (HotelEntity hotel : hoteles){
                if(hotel.getId().equals(h.getId_hotel())){
                    h.setId_hotel(hotel.getId());
                    h.setHotelEntity(hotel);
                }
            }
        }

        for(HabitacionEntity h: he){
            for(AlojamientoEntity a: ae){
                if(h.getAlojamientoId().equals(a.getId())){
                    h.setAlojamientoId(a.getId());
                    h.setAlojamientoEntity(a);
                }
            }
        }
        callback.onSuccess(HabitacionMapper.fromEntities(he));
    }

    @Override
    public void getAllDepartamentos(OnResult<List<Departamento>> callback) {
        List<DepartamentoEntity> de = alojamientoDao.loadAllDepartamentos();
        List<AlojamientoEntity> ae = alojamientoDao.loadAllAlojamientos();
        List<UbicacionEntity> ue = alojamientoDao.loadAllUbicaciones();

        for(DepartamentoEntity d : de) {
            for(AlojamientoEntity a: ae){
                if(d.getAlojamientoId().equals(a.getId())){
                    d.setAlojamientoEntity(a);
                }
            }
        }

        for(DepartamentoEntity d :de){
            for(UbicacionEntity u: ue){
                if(d.getId_ubicacion().equals(u.getId())){
                    d.setUbicacionEntity(u);
                }
            }
        }
        callback.onSuccess(DepartamentoMapper.fromEntities(de));
    }

    @Override
    public void getAllAlojamientos(OnResult<List<Alojamiento>> callback) {
        getAllDepartamentos(new OnResult<List<Departamento>>() {
            @Override
            public void onSuccess(List<Departamento> dptos) {
                getAllHabitaciones(new OnResult<List<Habitacion>>() {
                    @Override
                    public void onSuccess(List<Habitacion> habs) {
                        List<Alojamiento> alojamientos = new ArrayList<Alojamiento>();
                        alojamientos.addAll(dptos);
                        alojamientos.addAll(habs);
                        callback.onSuccess(alojamientos);
                    }

                    @Override
                    public void onError(Throwable exception) {
                        callback.onError(exception);
                    }
                });
            }

            @Override
            public void onError(Throwable exception) {
                callback.onError(exception);
            }
        });
    }
}
