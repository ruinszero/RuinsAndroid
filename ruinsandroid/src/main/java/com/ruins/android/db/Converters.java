package com.ruins.android.db;

import android.arch.persistence.room.TypeConverter;

import java.util.Date;

/**
 * Created by Ruins on 2017/8/23.
 * @author Ruins
 */

public class Converters {
    @TypeConverter
    public static Date fromTimestamp(Long value) {
        return value == null ? null : new Date(value);
    }

    @TypeConverter
    public static Long dateToTimestamp(Date date) {
        return date == null ? null : date.getTime();
    }
}
