package irishrail.sample.com.irishrailrealtime.utils;

import android.util.Log;

import java.util.Arrays;

import irishrail.sample.com.irishrailrealtime.BuildConfig;


/**
 * Created by evano on 13/12/2015.
 */
public class L {

    private static final String APP_TAG = "[IR_APP]";

    public static void d(String tag, String msg) {
        if (BuildConfig.DEBUG) {
            Log.d(tag, msg);
        }
    }

    public static void d(String tag, String format, Object... args) {
        if (BuildConfig.DEBUG) {
            Log.d(tag, String.format(format, args));
        }
    }

    public static void e(String tag, String format, Object... args) {
        if (BuildConfig.DEBUG) {
            Log.d(tag, String.format(format, args));
        }
        //log to logfile here
    }

    public static void d(String data) {
        if (BuildConfig.DEBUG && data != null) {
            Log.d(APP_TAG, data);
        }
    }

    public static void e(Throwable e) {
        if (BuildConfig.DEBUG && e != null) {
            Log.d(APP_TAG, "Message: " + e.getMessage() + "\n"
                    + "Cause:" + e.getCause() + "\n" + "Trace:\n" + Arrays.toString(e.getStackTrace()));
        }

    }
}