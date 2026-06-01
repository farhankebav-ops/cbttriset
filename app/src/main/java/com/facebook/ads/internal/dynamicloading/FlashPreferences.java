package com.facebook.ads.internal.dynamicloading;

import android.content.Context;
import android.content.SharedPreferences;
import com.facebook.infer.annotation.Nullsafe;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
@Nullsafe(Nullsafe.Mode.LOCAL)
public class FlashPreferences {
    public static final String PREFERENCES_FILE = "com.facebook.ads.flash";
    public static final String SP_KEY_FLASH_CONFIG = "flash_config";
    public static final String SP_KEY_LAST_CONFIG_UPDATE_TIMESTAMP = "update_timestamp";
    public static final String SP_KEY_LAST_RESULT = "last_result";

    public static SharedPreferences getSharedPreferences(Context context) {
        return context.getSharedPreferences(PREFERENCES_FILE, 0);
    }
}
