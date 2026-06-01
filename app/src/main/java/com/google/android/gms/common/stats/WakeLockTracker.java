package com.google.android.gms.common.stats;

import android.content.Context;
import android.content.Intent;
import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
@KeepForSdk
@Deprecated
public class WakeLockTracker {
    private static final WakeLockTracker zza = new WakeLockTracker();

    @NonNull
    @KeepForSdk
    public static WakeLockTracker getInstance() {
        return zza;
    }

    @KeepForSdk
    public void registerEvent(@NonNull Context context, @NonNull String str, int i2, @NonNull String str2, @NonNull String str3, @NonNull String str4, int i8, @NonNull List<String> list) {
    }

    @KeepForSdk
    public void registerEvent(@NonNull Context context, @NonNull String str, int i2, @NonNull String str2, @NonNull String str3, @NonNull String str4, int i8, @NonNull List<String> list, long j) {
    }

    @KeepForSdk
    public void registerReleaseEvent(@NonNull Context context, @NonNull Intent intent) {
    }

    @KeepForSdk
    public void registerAcquireEvent(@NonNull Context context, @NonNull Intent intent, @NonNull String str, @NonNull String str2, @NonNull String str3, int i2, @NonNull String str4) {
    }

    @KeepForSdk
    public void registerDeadlineEvent(@NonNull Context context, @NonNull String str, @NonNull String str2, @NonNull String str3, int i2, @NonNull List<String> list, boolean z2, long j) {
    }
}
