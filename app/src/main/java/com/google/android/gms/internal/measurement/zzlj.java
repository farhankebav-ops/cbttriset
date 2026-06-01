package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public class zzlj {
    public static final /* synthetic */ int zza = 0;
    private static volatile int zzb = 100;

    public /* synthetic */ zzlj(byte[] bArr) {
    }

    public static int zzb(int i2) {
        return (i2 >>> 1) ^ (-(i2 & 1));
    }

    public static long zzc(long j) {
        return (j >>> 1) ^ (-(1 & j));
    }
}
