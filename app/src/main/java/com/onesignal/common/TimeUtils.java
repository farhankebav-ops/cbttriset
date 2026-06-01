package com.onesignal.common;

import android.os.Build;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class TimeUtils {
    public static final TimeUtils INSTANCE = new TimeUtils();

    private TimeUtils() {
    }

    public final String getTimeZoneId() {
        if (Build.VERSION.SDK_INT >= 26) {
            String id = ZoneId.systemDefault().getId();
            k.d(id, "{\n            ZoneId.systemDefault().id\n        }");
            return id;
        }
        String id2 = TimeZone.getDefault().getID();
        k.d(id2, "{\n            TimeZone.getDefault().id\n        }");
        return id2;
    }

    public final int getTimeZoneOffset() {
        TimeZone timeZone = Calendar.getInstance().getTimeZone();
        int rawOffset = timeZone.getRawOffset();
        if (timeZone.inDaylightTime(new Date())) {
            rawOffset += timeZone.getDSTSavings();
        }
        return rawOffset / 1000;
    }
}
