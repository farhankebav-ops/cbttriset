package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzgsk {
    public static long zza(double d8) {
        zzgmd.zzb(zzb(d8), "not a normal value");
        int exponent = Math.getExponent(d8);
        long jDoubleToRawLongBits = Double.doubleToRawLongBits(d8) & 4503599627370495L;
        return exponent == -1023 ? jDoubleToRawLongBits + jDoubleToRawLongBits : jDoubleToRawLongBits | 4503599627370496L;
    }

    public static boolean zzb(double d8) {
        return Math.getExponent(d8) <= 1023;
    }
}
