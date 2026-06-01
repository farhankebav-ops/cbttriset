package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.SharedPreferences;
import com.mimikridev.ads.util.Constant;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzbef {
    public static void zza(Context context) {
        zzg(context, "init_without_write");
    }

    public static void zzb(Context context) {
        zzg(context, "crash_without_write");
    }

    public static int zzc(Context context) {
        return zzf(context, "init_without_write");
    }

    public static int zzd(Context context) {
        return zzf(context, "crash_without_write");
    }

    public static void zze(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(Constant.ADMOB, 0);
        if (sharedPreferences == null) {
            return;
        }
        sharedPreferences.edit().putInt("init_without_write", 0).putInt("crash_without_write", 0).commit();
    }

    private static int zzf(Context context, String str) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(Constant.ADMOB, 0);
        if (sharedPreferences == null) {
            return 0;
        }
        try {
            return sharedPreferences.getInt(str, 0);
        } catch (ClassCastException unused) {
            return 0;
        }
    }

    private static void zzg(Context context, String str) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(Constant.ADMOB, 0);
        if (sharedPreferences == null) {
            return;
        }
        sharedPreferences.edit().putInt(str, zzf(context, str) + 1).commit();
    }
}
