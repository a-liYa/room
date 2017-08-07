package com.aliya.room.simple;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.aliya.room.user.UserTools;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    UserTools userTool;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        userTool = new UserTools();
    }

    @OnClick({R.id.tv_insert, R.id.tv_find_all, R.id.tv_delete_all})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_insert:
                userTool.insert();
                break;
            case R.id.tv_find_all:
                userTool.findAll();
                break;
            case R.id.tv_delete_all:
                userTool.deleteAll();
                break;
        }
    }

    private void loge(String msg) {
        Log.e("TAG", msg);
    }
}
