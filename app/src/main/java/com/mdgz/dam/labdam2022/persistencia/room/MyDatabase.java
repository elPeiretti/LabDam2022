package com.mdgz.dam.labdam2022.persistencia.room;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.mdgz.dam.labdam2022.misc.Converters;
import com.mdgz.dam.labdam2022.persistencia.room.dao.*;
import com.mdgz.dam.labdam2022.persistencia.repo.AlojamientoRepository;
import com.mdgz.dam.labdam2022.persistencia.room.entities.*;
import com.mdgz.dam.labdam2022.persistencia.room.mapper.DepartamentoMapper;
import com.mdgz.dam.labdam2022.persistencia.room.mapper.HabitacionMapper;

import java.util.concurrent.Executors;

@Database(entities={AlojamientoEntity.class, FavoritoEntity.class, ReservaEntity.class, CiudadEntity.class,
        DepartamentoEntity.class, HabitacionEntity.class, HotelEntity.class, UbicacionEntity.class}, version=3)
@TypeConverters({Converters.class})
public abstract class MyDatabase extends RoomDatabase{

    public abstract AlojamientoDAO alojamientoDAO();
    public abstract FavoritoDAO favoritoDAO();
    public abstract ReservaDAO reservaDAO();

    private static MyDatabase instance;

    public synchronized static MyDatabase getInstance(Context context) {
        if (instance == null) {
            instance = buildDatabase(context);
        }
        instance.alojamientoDAO().loadAllDepartamentos();
        return instance;
    }

    private static MyDatabase buildDatabase(final Context context){
        return Room.databaseBuilder(context,
                MyDatabase.class,
                "dam-2022")
                .addCallback(new Callback(){
                    @Override
                    public void onCreate(@NonNull SupportSQLiteDatabase db){
                        super.onCreate(db);
                        Executors.newSingleThreadScheduledExecutor().execute( new Runnable(){
                            @Override
                            public void run() {
                                getInstance(context).alojamientoDAO().insertAllDepartamentos(DepartamentoMapper.toEntities(AlojamientoRepository._DEPARTAMENTOS));
                                getInstance(context).alojamientoDAO().insertAllHabitaciones(HabitacionMapper.toEntities(AlojamientoRepository._HABITACIONES));
                            }
                        });
                    }
        }).allowMainThreadQueries()
                //.fallbackToDestructiveMigration()
                .build();
    }
}
