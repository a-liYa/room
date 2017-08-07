package com.aliya.room.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.aliya.room.bean.User;

/**
 * RoomDatabase
 *
 * @author a_liYa
 * @date 2017/8/7 16:17.
 */
@Database(entities = {User.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase implements UserDaoDatabase {

//    public abstract UserDao userDao();

}
