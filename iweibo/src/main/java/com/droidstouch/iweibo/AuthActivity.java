package com.droidstouch.iweibo;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;

/**
 * Created by Administrator on 2016/1/10.
 */
public class AuthActivity extends Activity {
    private Dialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);
        View dlgView=View.inflate(this,R.layout.activity_atuourize_dialog,null);
        dialog=new Dialog(this,R.style.auth_dialog);
        dialog.setCanceledOnTouchOutside(false);//设置dialog点击屏幕不消失
        dialog.setContentView(dlgView);
        dialog.show();
    }
}
