package com.google.android.gms.common.stats;

import android.content.ComponentName;
import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
@KeepForSdk
public final class LoggingConstants {

    @NonNull
    @KeepForSdk
    @Deprecated
    public static final String EXTRA_WAKE_LOCK_KEY = "WAKE_LOCK_KEY";

    @NonNull
    public static final ComponentName zza = new ComponentName("com.google.android.gms", "com.google.android.gms.common.stats.GmsCoreStatsService");

    private LoggingConstants() {
    }
}
