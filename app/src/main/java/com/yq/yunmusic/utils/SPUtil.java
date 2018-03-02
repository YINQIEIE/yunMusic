package com.yq.yunmusic.utils;

import android.content.Context;
import android.content.SharedPreferences;

import static jdhr.com.morningcheck.model.preference.PrefConstants.ADMIN_PASSWORD;
import static jdhr.com.morningcheck.model.preference.PrefConstants.AUTOMATE_TIME;
import static jdhr.com.morningcheck.model.preference.PrefConstants.BLE_SWIPE_DEVICE_ADDRESS;
import static jdhr.com.morningcheck.model.preference.PrefConstants.BLE_SWIPE_DEVICE_NAME;
import static jdhr.com.morningcheck.model.preference.PrefConstants.BLE_TEMPERATURE_DEVICE_ADDRESS;
import static jdhr.com.morningcheck.model.preference.PrefConstants.BLE_TEMPERATURE_DEVICE_NAME;
import static jdhr.com.morningcheck.model.preference.PrefConstants.DEFAULT_ALLOW_AVATAR;
import static jdhr.com.morningcheck.model.preference.PrefConstants.DEFAULT_ENTER_FROM_TIME;
import static jdhr.com.morningcheck.model.preference.PrefConstants.DEFAULT_ENTER_TO_TIME;
import static jdhr.com.morningcheck.model.preference.PrefConstants.DEFAULT_EXIT_FROM_TIME;
import static jdhr.com.morningcheck.model.preference.PrefConstants.DEFAULT_EXIT_TO_TIME;
import static jdhr.com.morningcheck.model.preference.PrefConstants.ENTER_PEAK_TIME_FROM;
import static jdhr.com.morningcheck.model.preference.PrefConstants.ENTER_PEAK_TIME_TO;
import static jdhr.com.morningcheck.model.preference.PrefConstants.EXIT_PEAK_TIME_FROM;
import static jdhr.com.morningcheck.model.preference.PrefConstants.EXIT_PEAK_TIME_TO;
import static jdhr.com.morningcheck.model.preference.PrefConstants.FILE_NAME;
import static jdhr.com.morningcheck.model.preference.PrefConstants.FIRST_TIME;
import static jdhr.com.morningcheck.model.preference.PrefConstants.MODIFIABLE_AVATAR;
import static jdhr.com.morningcheck.model.preference.PrefConstants.ORG_ID;
import static jdhr.com.morningcheck.model.preference.PrefConstants.TEACHER_ACCOUNT;
import static jdhr.com.morningcheck.model.preference.PrefConstants.TEACHER_PASSWORD;

/**
 * Created by admin on 2017/9/30.
 */

public class SPUtil {

    public static final String TAG = SPUtil.class.getSimpleName();


    private SharedPreferences sp(){
    }

    /**
     * 保存布尔类型的值
     *
     * @param context
     * @param key
     * @param val
     */
    public static void saveBooleanVal(Context context, String key, boolean val) {
        PrefUtils.put(context, FILE_NAME, key, val);
    }

    public static boolean getBooleanByKey(Context context, String key, boolean defValue) {
        return (boolean) PrefUtils.get(context, FILE_NAME, key, defValue);
    }

    public static String getStringValByKey(Context context, String key) {
        return (String) PrefUtils.get(context, FILE_NAME, key, "");
    }

    public static String getStringValByKey(Context context, String key, String defValue) {
        return (String) PrefUtils.get(context, FILE_NAME, key, defValue);
    }

    public static void saveIntValue(Context context, String key, int val) {
        PrefUtils.put(context, FILE_NAME, key, val);
    }

    public static int getIntValue(Context context, String key) {
        return (int) PrefUtils.get(context, FILE_NAME, key, 0);
    }

    public static int getIntValue(Context context, String key, int defValue) {
        return (int) PrefUtils.get(context, FILE_NAME, key, defValue);
    }

    public static void saveFloatValue(Context context, String key, float val) {
        PrefUtils.put(context, FILE_NAME, key, val);
    }

    public static float getFloatValue(Context context, String key) {
        return (float) PrefUtils.get(context, FILE_NAME, key, 0f);
    }

    public static float getFloatValue(Context context, String key, float defValue) {
        return (float) PrefUtils.get(context, FILE_NAME, key, defValue);
    }
}
