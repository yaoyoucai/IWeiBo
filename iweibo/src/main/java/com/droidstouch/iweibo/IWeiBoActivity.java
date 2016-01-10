package com.droidstouch.iweibo;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by Administrator on 2016/1/9.
 * Activity 接口 所有activity都要实现它
 */
public interface IWeiBoActivity{
     //初始化数据
     public void init();
     //刷新ui
     public  void refresh(Object... params);
}
