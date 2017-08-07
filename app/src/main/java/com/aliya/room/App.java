package com.aliya.room;

import android.app.Application;
import android.os.SystemClock;
import android.util.Log;

import com.aliya.room.database.AppDatabase;
import com.aliya.room.database.Builder;

/**
 * Application
 *
 * @author a_liYa
 * @date 2017/8/7 16:19.
 */
public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        long start = SystemClock.uptimeMillis();
        Builder.build(this, AppDatabase.class);
        Log.e("TAG", "创建数据库耗时：" + (SystemClock.uptimeMillis() - start) + " ms");
    }
}
