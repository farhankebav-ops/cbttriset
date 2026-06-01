package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzfhk {
    public static void zza(int i2, Throwable th, String str) {
        String strM = androidx.camera.core.processing.util.a.m(new StringBuilder(String.valueOf(i2).length() + 20), "Ad failed to load : ", i2);
        int i8 = com.google.android.gms.ads.internal.util.zze.zza;
        com.google.android.gms.ads.internal.util.client.zzo.zzh(strM);
        com.google.android.gms.ads.internal.util.zze.zzb(str, th);
        if (i2 == 3) {
            return;
        }
        com.google.android.gms.ads.internal.zzt.zzh().zzh(th, str);
    }

    public static void zzb(Context context, boolean z2) {
        if (z2) {
            int i2 = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzh("This request is sent from a test device.");
            return;
        }
        com.google.android.gms.ads.internal.client.zzbb.zza();
        String strZzD = com.google.android.gms.ads.internal.util.client.zzf.zzD(context);
        String strS = a1.a.s(new StringBuilder(String.valueOf(strZzD).length() + 102), "Use RequestConfiguration.Builder().setTestDeviceIds(Arrays.asList(\"", strZzD, "\")) to get test ads on this device.");
        int i8 = com.google.android.gms.ads.internal.util.zze.zza;
        com.google.android.gms.ads.internal.util.client.zzo.zzh(strS);
    }
}
