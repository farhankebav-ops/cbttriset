package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzgqx {
    public static Object[] zza(Object[] objArr, int i2) {
        for (int i8 = 0; i8 < i2; i8++) {
            zzb(objArr[i8], i8);
        }
        return objArr;
    }

    public static Object zzb(Object obj, int i2) {
        if (obj != null) {
            return obj;
        }
        throw new NullPointerException(androidx.camera.core.processing.util.a.m(new StringBuilder(String.valueOf(i2).length() + 9), "at index ", i2));
    }
}
