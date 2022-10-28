package com.mdgz.dam.labdam2022.persistencia.bdd;

import android.app.ActivityManager;
import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.mdgz.dam.labdam2022.misc.Converters;
import com.mdgz.dam.labdam2022.model.*;
import com.mdgz.dam.labdam2022.persistencia.InterfacesDataSource.*;
import com.mdgz.dam.labdam2022.persistencia.repo.AlojamientoRepository;

import java.util.concurrent.Executors;

@Database(entities={Favorito.class, Reserva.class, Ciudad.class, Departamento.class, Habitacion.class,
                    Hotel.class, Ubicacion.class}, version=1)
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
                                getInstance(context).alojamientoDAO().insertAllDepartamentos(AlojamientoRepository._DEPARTAMENTOS);
                                getInstance(context).alojamientoDAO().insertAllHabitaciones(AlojamientoRepository._HABITACIONES);
                            }
                        });
                    }
        }).allowMainThreadQueries().build();
    }
}
