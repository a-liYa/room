package com.aliya.room;

import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.aliya.room.bean.User;
import com.aliya.room.dao.UserDao;
import com.aliya.room.database.Builder;
import com.aliya.room.database.UserDaoDatabase;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.tv_insert, R.id.tv_find_all, R.id.tv_delete_all})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_insert:
                insert();
                break;
            case R.id.tv_find_all:
                findAll();
                break;
            case R.id.tv_delete_all:
                deleteAll();
                break;
        }
    }

    private void deleteAll() {

        new Thread(new Runnable() {
            @Override
            public void run() {
                long start = SystemClock.uptimeMillis();
                UserDao userDao = ((UserDaoDatabase)Builder.getDatabase()).userDao();
                userDao.deleteAll(userDao.getAll());
                loge("删除全部 - 耗时：" + (SystemClock.uptimeMillis() - start) + " ms");
            }
        }).start();

    }

    private void findAll() {

        new Thread(new Runnable() {
            @Override
            public void run() {
                long start = SystemClock.uptimeMillis();
                UserDao userDao = ((UserDaoDatabase)Builder.getDatabase()).userDao();
                List<User> all = userDao.getAll();
                loge("查询" + all.size()+"条 - 耗时：" + (SystemClock.uptimeMillis() - start) + " ms");
                final int N = Math.min(all.size(), 100);
                for (int i = 0; i < N; i++) {
                    loge("第" + i+ "条 ：" + all.get(i).toString());
                }
            }
        }).start();

    }

    private void insert() {

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
                UserDao userDao = ((UserDaoDatabase)Builder.getDatabase()).userDao();
                userDao.insertAll(users.toArray(new User[]{}));
                loge("插入" + users.size()+"条 - 耗时：" + (SystemClock.uptimeMillis() - start) + " ms");
            }
        }).start();

    }

    private void loge(String msg) {
        Log.e("TAG", msg);
    }
}
