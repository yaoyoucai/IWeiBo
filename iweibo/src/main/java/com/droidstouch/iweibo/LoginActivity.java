package com.droidstouch.iweibo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.droidstouch.bean.Task;
import com.droidstouch.logic.MainService;

/**
 * Created by Administrator on 2016/1/9.
 * 登录的activity
 */
public class LoginActivity extends Activity implements IWeiBoActivity {
    /**
     *  该处textView 必须设置为静态，否则退出重进程序，TextView不可见，原理目前未知
     */
    private static TextView tv_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Intent intent=new Intent();
        intent.setClass(this,AuthActivity.class);
        startActivity(intent);

      /*  tv_login = (TextView) findViewById(R.id.tv_login);
        Intent intent = new Intent();
        intent.setClass(LoginActivity.this, MainService.class);
        startService(intent);
        MainService.addActivity(this);*/
    }

    public void click(View view) {
        switch (view.getId()) {
            case R.id.bt_login:
                login();
                break;
        }
    }

    public void login() {
        Task task = new Task(Task.WEIBO_LOGIN, null);
        MainService.newTask(task);
    }

    @Override
    public void init() {

    }

    @Override
    public void refresh(Object... params) {
        System.out.println("value" + params[0].toString().trim());
        tv_login.setText(params[0].toString().trim());
        System.out.println(tv_login.getText());
    }
}
