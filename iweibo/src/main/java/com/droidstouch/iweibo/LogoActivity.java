package com.droidstouch.iweibo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;

public class LogoActivity extends Activity {
    private ImageView img_log;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logo);
        img_log= (ImageView) findViewById(R.id.img_log);

        //设置进入app时的延时3秒效果
        AlphaAnimation animation=new AlphaAnimation(0.0f,1.0f);
        animation.setDuration(3000);
        img_log.setAnimation(animation);
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                Intent intent=new Intent();
                intent.setClass(LogoActivity.this,LoginActivity.class);
                startActivity(intent);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }

}
