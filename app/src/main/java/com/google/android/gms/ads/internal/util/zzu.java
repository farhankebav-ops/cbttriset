package com.google.android.gms.ads.internal.util;

import android.app.Activity;
import android.content.res.Configuration;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.internal.ads.zzbeu;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class zzu extends zzt {
    @VisibleForTesting
    public static final boolean zze(int i2, int i8, int i9) {
        return Math.abs(i2 - i8) <= i9;
    }

    @Override // com.google.android.gms.ads.internal.util.zzz
    public final boolean zzd(Activity activity, Configuration configuration) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzfE)).booleanValue()) {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzfG)).booleanValue()) {
                return activity.isInMultiWindowMode();
            }
            com.google.android.gms.ads.internal.client.zzbb.zza();
            int iZzC = com.google.android.gms.ads.internal.util.client.zzf.zzC(activity, configuration.screenHeightDp);
            int iZzC2 = com.google.android.gms.ads.internal.util.client.zzf.zzC(activity, configuration.screenWidthDp);
            WindowManager windowManager = (WindowManager) activity.getApplicationContext().getSystemService("window");
            com.google.android.gms.ads.internal.zzt.zzc();
            DisplayMetrics displayMetricsZzx = zzs.zzx(windowManager);
            int i2 = displayMetricsZzx.heightPixels;
            int i8 = displayMetricsZzx.widthPixels;
            int identifier = activity.getResources().getIdentifier("status_bar_height", "dimen", "android");
            int dimensionPixelSize = identifier > 0 ? activity.getResources().getDimensionPixelSize(identifier) : 0;
            int iIntValue = ((Integer) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzfC)).intValue() * ((int) Math.round(((double) activity.getResources().getDisplayMetrics().density) + 0.5d));
            if (!zze(i2, iZzC + dimensionPixelSize, iIntValue) || !zze(i8, iZzC2, iIntValue)) {
                return true;
            }
        }
        return false;
    }
}
