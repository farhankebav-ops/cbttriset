package com.google.android.gms.internal.ads;

import com.google.firebase.analytics.FirebaseAnalytics;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzgmd {
    public static void zza(boolean z2) {
        if (!z2) {
            throw new IllegalArgumentException();
        }
    }

    public static void zzb(boolean z2, Object obj) {
        if (!z2) {
            throw new IllegalArgumentException((String) obj);
        }
    }

    public static void zzc(boolean z2, String str, char c7) {
        if (!z2) {
            throw new IllegalArgumentException(zzgmu.zzd(str, Character.valueOf(c7)));
        }
    }

    public static void zzd(boolean z2, String str, int i2) {
        if (!z2) {
            throw new IllegalArgumentException(zzgmu.zzd(str, Integer.valueOf(i2)));
        }
    }

    public static void zze(boolean z2, String str, long j) {
        if (!z2) {
            throw new IllegalArgumentException(zzgmu.zzd(str, Long.valueOf(j)));
        }
    }

    public static void zzf(boolean z2, String str, Object obj) {
        if (!z2) {
            throw new IllegalArgumentException(zzgmu.zzd(str, obj));
        }
    }

    public static void zzg(boolean z2, String str, int i2, int i8) {
        if (!z2) {
            throw new IllegalArgumentException(zzgmu.zzd(str, Integer.valueOf(i2), Integer.valueOf(i8)));
        }
    }

    public static void zzh(boolean z2) {
        if (!z2) {
            throw new IllegalStateException();
        }
    }

    public static void zzi(boolean z2, Object obj) {
        if (!z2) {
            throw new IllegalStateException(String.valueOf(obj));
        }
    }

    public static void zzj(boolean z2, String str, Object obj, Object obj2) {
        if (!z2) {
            throw new IllegalStateException(zzgmu.zzd(str, obj, obj2));
        }
    }

    public static Object zzk(Object obj, Object obj2) {
        if (obj != null) {
            return obj;
        }
        throw new NullPointerException((String) obj2);
    }

    public static Object zzl(Object obj, String str, Object obj2) {
        if (obj != null) {
            return obj;
        }
        throw new NullPointerException(zzgmu.zzd(str, obj2));
    }

    public static int zzm(int i2, int i8, String str) {
        String strZzd;
        if (i2 >= 0 && i2 < i8) {
            return i2;
        }
        if (i2 < 0) {
            strZzd = zzgmu.zzd("%s (%s) must not be negative", FirebaseAnalytics.Param.INDEX, Integer.valueOf(i2));
        } else {
            if (i8 < 0) {
                throw new IllegalArgumentException(androidx.camera.core.processing.util.a.m(new StringBuilder(String.valueOf(i8).length() + 15), "negative size: ", i8));
            }
            strZzd = zzgmu.zzd("%s (%s) must be less than size (%s)", FirebaseAnalytics.Param.INDEX, Integer.valueOf(i2), Integer.valueOf(i8));
        }
        throw new IndexOutOfBoundsException(strZzd);
    }

    public static int zzn(int i2, int i8, String str) {
        if (i2 < 0 || i2 > i8) {
            throw new IndexOutOfBoundsException(zzp(i2, i8, FirebaseAnalytics.Param.INDEX));
        }
        return i2;
    }

    public static void zzo(int i2, int i8, int i9) {
        if (i2 < 0 || i8 < i2 || i8 > i9) {
            throw new IndexOutOfBoundsException((i2 < 0 || i2 > i9) ? zzp(i2, i9, "start index") : (i8 < 0 || i8 > i9) ? zzp(i8, i9, "end index") : zzgmu.zzd("end index (%s) must not be less than start index (%s)", Integer.valueOf(i8), Integer.valueOf(i2)));
        }
    }

    private static String zzp(int i2, int i8, String str) {
        if (i2 < 0) {
            return zzgmu.zzd("%s (%s) must not be negative", str, Integer.valueOf(i2));
        }
        if (i8 >= 0) {
            return zzgmu.zzd("%s (%s) must not be greater than size (%s)", str, Integer.valueOf(i2), Integer.valueOf(i8));
        }
        throw new IllegalArgumentException(androidx.camera.core.processing.util.a.m(new StringBuilder(String.valueOf(i8).length() + 15), "negative size: ", i8));
    }
}
