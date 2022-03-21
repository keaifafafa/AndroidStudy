package com.example.a02_lifecycle;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

/**
 * 活动控制器
 */
public class ActivityManager {

    public static List<Activity> activityList = new ArrayList<>();

    /**
     * 添加 activity
     *
     * @param activity
     */
    public static void addActivity(Activity activity) {
        activityList.add(activity);
    }

    /**
     * 移除单个 activity
     *
     * @param activity
     */
    public static void removeActivity(Activity activity) {
        activityList.remove(activity);
    }

    public static void removeAllActivity() {
//        activityList.removeAll(activityList);
        for (Activity activity : activityList) {
            if (!activity.isFinishing()) {
                activity.finish();
            }
        }
    }


}
