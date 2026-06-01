package com.google.android.gms.internal.ads;

import android.os.Looper;
import android.util.DisplayMetrics;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzayg {
    public static final /* synthetic */ int zza = 0;
    private static final char[] zzb = "0123456789abcdef".toCharArray();

    public static String zza(byte[] bArr) {
        int length = bArr.length;
        char[] cArr = new char[length + length];
        for (int i2 = 0; i2 < bArr.length; i2++) {
            byte b8 = bArr[i2];
            char[] cArr2 = zzb;
            int i8 = i2 + i2;
            cArr[i8] = cArr2[(b8 & 255) >>> 4];
            cArr[i8 + 1] = cArr2[b8 & 15];
        }
        return new String(cArr);
    }

    public static byte[] zzb(String str) {
        int length = str.length();
        if (length % 2 != 0) {
            throw new IllegalArgumentException("String must be of even-length");
        }
        byte[] bArr = new byte[length / 2];
        for (int i2 = 0; i2 < length; i2 += 2) {
            bArr[i2 / 2] = (byte) (Character.digit(str.charAt(i2 + 1), 16) + (Character.digit(str.charAt(i2), 16) << 4));
        }
        return bArr;
    }

    public static boolean zzc(String str) {
        return str == null || str.isEmpty();
    }

    public static boolean zzd() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    public static boolean zze(DisplayMetrics displayMetrics) {
        return (displayMetrics == null || displayMetrics.density == 0.0f) ? false : true;
    }

    public static long zzf(double d8, int i2, DisplayMetrics displayMetrics) {
        return Math.round(d8 / ((double) displayMetrics.density));
    }
}
