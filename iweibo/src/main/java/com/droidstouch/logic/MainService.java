package com.droidstouch.logic;

import android.app.Activity;
import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;

import com.droidstouch.bean.Task;
import com.droidstouch.iweibo.IWeiBoActivity;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by Administrator on 2016/1/9.
 */
public class MainService extends Service implements Runnable {
    //任务队列
    private static Queue<Task> tasks = new LinkedList<Task>();
    //是否运行线程
    private boolean isRun;
    private static List<Activity> activities = new ArrayList<Activity>();

    public static Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            System.out.println("msg");
            System.out.println("msg what:"+msg.what);
            System.out.println("msg obj:"+msg.obj);
            switch (msg.what) {
                case Task.WEIBO_LOGIN://用户登录
                    IWeiBoActivity activity= (IWeiBoActivity) getActivityByName("LoginActivity");
                    System.out.println("activity name:"+activity.getClass().getName());
                    //更新ui
                    activity.refresh(msg.obj);
                    break;
            }
        }
    };

    /**
     * 往activities集合里添加一个activity
     *
     * @param activity
     */
    public static void addActivity(Activity activity) {
        if (!activities.contains(activity)){
            activities.add(activity);
        }
    }

    /**
     * 根据activity的name获取activity实例
     * @param name
     * @return
     */
    public static Activity getActivityByName(String name) {
        if (!activities.isEmpty()) {
            for (Activity activity : activities) {
                if (activity != null) {
                    if (activity.getClass().getName().indexOf(name) >= 0) {
                        return activity;
                    }
                }
            }
        }
        return null;
    }

    /*
       往任务队列里添加任务
     */
    public static void newTask(Task t) {
        tasks.add(t);
    }

    public static void doTask(Task t) {
        Message msg = new Message();
        msg.what = t.getTaskId();
        switch (t.getTaskId()) {
            case Task.WEIBO_LOGIN:
                System.out.println("doTask----->>>>> weibo login");
                msg.obj = "登录成功";
                break;
        }
        handler.sendMessage(msg);
    }

    @Override
    public void onCreate() {
        isRun = true;
        Thread thread = new Thread(this);
        thread.start();
        super.onCreate();
    }

    @Override
    public void run() {
        while (isRun) {
            Task task;
            if (!tasks.isEmpty()) {
                task = tasks.poll();//从队列中取出并移出一个任务
                if (task != null) {
                    doTask(task);
                }
            }
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
