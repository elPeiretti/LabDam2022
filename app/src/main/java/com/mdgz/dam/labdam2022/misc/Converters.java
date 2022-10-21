package com.mdgz.dam.labdam2022.misc;

import androidx.room.TypeConverter;

import java.time.Instant;

public class Converters {
    @TypeConverter
    public static Long instantToLong(Instant i){
        return i==null? null : i.getEpochSecond();
    }
    @TypeConverter
    public static Instant InstantfromLong(Long seconds){
        return seconds == null ? null : Instant.ofEpochSecond(seconds);
    }
}
