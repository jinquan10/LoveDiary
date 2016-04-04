package org.jz.lovediary.util;

import org.jz.lovediary.BuildConfig;

import java.text.SimpleDateFormat;
import java.util.TimeZone;

/**
 * Created by JZ on 3/5/2016.
 */
public final class Utils {
    public static final String APP_TAG = "jzjz";
    public static final long MILLIS_PER_DAY = 86400000;
    public static final long MILLIS_PER_SECOND = 1000;
    public static final SimpleDateFormat DEFAULT_DATE_FORMATTER = new SimpleDateFormat("MMM d, y");

    public static boolean isFromToday(long gmtMillis) {
        long tzOffset = TimeZone.getDefault().getOffset(gmtMillis);

        long inputMillis = gmtMillis + tzOffset;
        long todayMillis = System.currentTimeMillis() + tzOffset;

        if (BuildConfig.DEBUG) {
            inputMillis -= inputMillis % MILLIS_PER_SECOND;
            todayMillis -= todayMillis % MILLIS_PER_SECOND;
        } else {
            inputMillis -= inputMillis % MILLIS_PER_DAY;
            todayMillis -= todayMillis % MILLIS_PER_DAY;
        }

        if (todayMillis == inputMillis) {
            return true;
        }

        return false;
    }
}
