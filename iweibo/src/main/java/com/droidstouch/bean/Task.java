package com.droidstouch.bean;

import java.util.Map;
import java.util.Objects;

/**
 * Created by Administrator on 2016/1/9.
 * 任务类
 */
public class Task {
    private int taskId;
    private Map<String,Object> taskParams;
    public static final int WEIBO_LOGIN=1;
    public Task(int taskId, Map<String, Object> taskParams) {
        this.taskId = taskId;
        this.taskParams = taskParams;
    }

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public Map<String, Object> getTaskParams() {
        return taskParams;
    }

    public void setTaskParams(Map<String, Object> taskParams) {
        this.taskParams = taskParams;
    }
}
