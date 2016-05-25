package org.mqstack.airhockey.util;

import android.util.Log;

/**
 * Created by USER on 2016/1/16.
 */
public class Logger {

    public static final boolean ON = true;

    public static void d(String tag, String msg) {
        if (ON && tag != null && msg != null) {
            Log.d(tag, msg);
        }
    }
}
