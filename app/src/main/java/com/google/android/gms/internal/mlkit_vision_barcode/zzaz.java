package com.google.android.gms.internal.mlkit_vision_barcode;

import a1.a;
import com.google.firebase.analytics.FirebaseAnalytics;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzaz {
    public static int zza(int i2, int i8, String str) {
        String strZzb;
        if (i2 >= 0 && i2 < i8) {
            return i2;
        }
        if (i2 < 0) {
            strZzb = zzba.zzb("%s (%s) must not be negative", FirebaseAnalytics.Param.INDEX, Integer.valueOf(i2));
        } else {
            if (i8 < 0) {
                throw new IllegalArgumentException(a.g(i8, "negative size: "));
            }
            strZzb = zzba.zzb("%s (%s) must be less than size (%s)", FirebaseAnalytics.Param.INDEX, Integer.valueOf(i2), Integer.valueOf(i8));
        }
        throw new IndexOutOfBoundsException(strZzb);
    }

    public static int zzb(int i2, int i8, String str) {
        if (i2 < 0 || i2 > i8) {
            throw new IndexOutOfBoundsException(zzg(i2, i8, FirebaseAnalytics.Param.INDEX));
        }
        return i2;
    }

    public static Object zzc(Object obj, Object obj2) {
        if (obj != null) {
            return obj;
        }
        throw new NullPointerException("Executor was null.");
    }

    public static void zzd(boolean z2) {
        if (!z2) {
            throw new IllegalArgumentException();
        }
    }

    public static void zze(int i2, int i8, int i9) {
        if (i2 < 0 || i8 < i2 || i8 > i9) {
            throw new IndexOutOfBoundsException((i2 < 0 || i2 > i9) ? zzg(i2, i9, "start index") : (i8 < 0 || i8 > i9) ? zzg(i8, i9, "end index") : zzba.zzb("end index (%s) must not be less than start index (%s)", Integer.valueOf(i8), Integer.valueOf(i2)));
        }
    }

    public static void zzf(boolean z2, Object obj) {
        if (!z2) {
            throw new IllegalStateException((String) obj);
        }
    }

    private static String zzg(int i2, int i8, String str) {
        if (i2 < 0) {
            return zzba.zzb("%s (%s) must not be negative", str, Integer.valueOf(i2));
        }
        if (i8 >= 0) {
            return zzba.zzb("%s (%s) must not be greater than size (%s)", str, Integer.valueOf(i2), Integer.valueOf(i8));
        }
        throw new IllegalArgumentException(a.g(i8, "negative size: "));
    }
}
