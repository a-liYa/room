package com.aliya.room.user.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.aliya.room.user.bean.User;

@Database(entities = {User.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase implements UserDatabase {

}
