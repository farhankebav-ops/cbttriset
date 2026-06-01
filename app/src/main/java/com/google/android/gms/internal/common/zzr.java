package com.google.android.gms.internal.common;

import androidx.camera.core.processing.util.a;
import com.google.firebase.analytics.FirebaseAnalytics;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzr {
    public static void zza(boolean z2) {
        if (!z2) {
            throw new IllegalStateException();
        }
    }

    public static int zzb(int i2, int i8, String str) {
        String strZza;
        if (i2 >= 0 && i2 < i8) {
            return i2;
        }
        if (i2 < 0) {
            strZza = zzx.zza("%s (%s) must not be negative", FirebaseAnalytics.Param.INDEX, Integer.valueOf(i2));
        } else {
            if (i8 < 0) {
                throw new IllegalArgumentException(a.m(new StringBuilder(String.valueOf(i8).length() + 15), "negative size: ", i8));
            }
            strZza = zzx.zza("%s (%s) must be less than size (%s)", FirebaseAnalytics.Param.INDEX, Integer.valueOf(i2), Integer.valueOf(i8));
        }
        throw new IndexOutOfBoundsException(strZza);
    }

    public static int zzc(int i2, int i8, String str) {
        if (i2 < 0 || i2 > i8) {
            throw new IndexOutOfBoundsException(zze(i2, i8, FirebaseAnalytics.Param.INDEX));
        }
        return i2;
    }

    public static void zzd(int i2, int i8, int i9) {
        if (i2 < 0 || i8 < i2 || i8 > i9) {
            throw new IndexOutOfBoundsException((i2 < 0 || i2 > i9) ? zze(i2, i9, "start index") : (i8 < 0 || i8 > i9) ? zze(i8, i9, "end index") : zzx.zza("end index (%s) must not be less than start index (%s)", Integer.valueOf(i8), Integer.valueOf(i2)));
        }
    }

    private static String zze(int i2, int i8, String str) {
        if (i2 < 0) {
            return zzx.zza("%s (%s) must not be negative", str, Integer.valueOf(i2));
        }
        if (i8 >= 0) {
            return zzx.zza("%s (%s) must not be greater than size (%s)", str, Integer.valueOf(i2), Integer.valueOf(i8));
        }
        throw new IllegalArgumentException(a.m(new StringBuilder(String.valueOf(i8).length() + 15), "negative size: ", i8));
    }
}
