package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public interface zzawv {
    void zzd(@Nullable MotionEvent motionEvent);

    @Deprecated
    void zze(int i2, int i8, int i9);

    String zzf(Context context, @Nullable String str, @Nullable View view, @Nullable Activity activity);

    String zzg(Context context, @Nullable String str, @Nullable View view);

    void zzh(@Nullable View view);

    void zzi(StackTraceElement[] stackTraceElementArr);

    String zzj(Context context, @Nullable View view, @Nullable Activity activity);

    String zzk(Context context);

    String zzl(Context context);
}
