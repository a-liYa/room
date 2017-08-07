package com.aliya.room.user.database;

import com.aliya.room.DaoBase;
import com.aliya.room.user.dao.UserDao;

/**
 * UserDatabase
 *
 * @author a_liYa
 * @date 2017/8/7 21:38.
 */
public interface UserDatabase extends DaoBase {

    UserDao userDao();

}
