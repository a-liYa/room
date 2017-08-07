package com.aliya.room.database;

import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

/**
 * Builder
 *
 * @author a_liYa
 * @date 2017/8/7 20:47.
 */
public class Builder {

    private static RoomDatabase db;

    private static final String DATABASE_NAME = "database-a_liYa";

    public static <T extends RoomDatabase> RoomDatabase build(Context context, Class<T> database) {
        if (db == null) {
            synchronized (Builder.class) {
                if (db == null) {
                    db = Room.databaseBuilder(context, database, DATABASE_NAME).build();
                }
            }
        }
        return db;
    }

    public static <T> T getDatabase() {
        return (T) db;
    }

}
