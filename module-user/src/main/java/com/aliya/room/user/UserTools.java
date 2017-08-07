package com.aliya.room.user;

import android.os.SystemClock;
import android.util.Log;

import com.aliya.room.Builder;
import com.aliya.room.user.bean.User;
import com.aliya.room.user.dao.UserDao;
import com.aliya.room.user.database.UserDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * 使用
 *
 * @author a_liYa
 * @date 2017/8/7 21:41.
 */
public class UserTools {

    /**
     * 插入10000条数据
     */
    public void insert() {
        final List<User> users = new ArrayList<>();

        for (int i = 0; i < 10000; i++) {
            User user = new User();
            user.setUid(i);
            user.setFirstName("姓" + i);
            user.setLastName("名" + i);
            user.url = "url " + i;
            users.add(user);
        }

        new Thread(new Runnable() {
            @Override
            public void run() {
                long start = SystemClock.uptimeMillis();
                UserDao userDao = ((UserDatabase) Builder.getDatabase()).userDao();
                userDao.insertAll(users.toArray(new User[]{}));
                loge("插入" + users.size() + "条 - 耗时：" + (SystemClock.uptimeMillis() - start) + " ms");
            }
        }).start();
    }

    /**
     * 查询全部
     */
    public void findAll() {

        new Thread(new Runnable() {
            @Override
            public void run() {
                long start = SystemClock.uptimeMillis();
                UserDao userDao = ((UserDatabase) Builder.getDatabase()).userDao();
                List<User> all = userDao.getAll();
                loge("查询" + all.size() + "条 - 耗时：" + (SystemClock.uptimeMillis() - start) + " ms");
                final int N = Math.min(all.size(), 100);
                for (int i = 0; i < N; i++) {
                    loge("第" + i + "条 ：" + all.get(i).toString());
                }
            }
        }).start();

    }

    /**
     * 删除全部
     */
    public void deleteAll() {

        new Thread(new Runnable() {
            @Override
            public void run() {
                long start = SystemClock.uptimeMillis();
                UserDao userDao = ((UserDatabase) Builder.getDatabase()).userDao();
                userDao.deleteAll(userDao.getAll());
                loge("删除全部 - 耗时：" + (SystemClock.uptimeMillis() - start) + " ms");
            }
        }).start();

    }


    private void loge(String msg) {
        Log.e("TAG", msg);
    }

}
