package com.mdgz.dam.labdam2022.persistencia.bdd;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.mdgz.dam.labdam2022.misc.Converters;
import com.mdgz.dam.labdam2022.model.*;
import com.mdgz.dam.labdam2022.persistencia.InterfacesDataSource.*;

@Database(entities={Alojamiento.class, Favorito.class, Reserva.class, Ciudad.class, Departamento.class, Habitacion.class,
                    Hotel.class, Ubicacion.class}, version=1)
@TypeConverters({Converters.class})
public abstract class MyDatabase extends RoomDatabase{
    public abstract AlojamientoDAO alojamientoDAO();
    public abstract FavoritoDAO favoritoDAO();
    public abstract ReservaDAO reservaDAO();
}
