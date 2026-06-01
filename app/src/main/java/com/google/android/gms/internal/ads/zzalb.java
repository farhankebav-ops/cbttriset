package com.google.android.gms.internal.ads;

import android.graphics.Color;
import androidx.annotation.ColorInt;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzalb {
    public final String zza;
    public final int zzb;

    @Nullable
    @ColorInt
    public final Integer zzc;

    @Nullable
    @ColorInt
    public final Integer zzd;
    public final float zze;
    public final boolean zzf;
    public final boolean zzg;
    public final boolean zzh;
    public final boolean zzi;
    public final int zzj;

    private zzalb(String str, int i2, @Nullable @ColorInt Integer num, @Nullable @ColorInt Integer num2, float f4, boolean z2, boolean z7, boolean z8, boolean z9, int i8) {
        this.zza = str;
        this.zzb = i2;
        this.zzc = num;
        this.zzd = num2;
        this.zze = f4;
        this.zzf = z2;
        this.zzg = z7;
        this.zzh = z8;
        this.zzi = z9;
        this.zzj = i8;
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0117 A[Catch: RuntimeException -> 0x00ba, TRY_LEAVE, TryCatch #2 {RuntimeException -> 0x00ba, blocks: (B:33:0x00c0, B:35:0x00c6, B:39:0x00d6, B:41:0x00da, B:45:0x00e9, B:47:0x00ed, B:51:0x00fe, B:53:0x0102, B:57:0x0113, B:59:0x0117, B:60:0x011f, B:68:0x013d, B:66:0x0130, B:28:0x00a1, B:23:0x008d), top: B:73:0x008d, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x013b  */
    @androidx.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.google.android.gms.internal.ads.zzalb zza(java.lang.String r20, com.google.android.gms.internal.ads.zzakz r21) {
        /*
            Method dump skipped, instruction units count: 342
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzalb.zza(java.lang.String, com.google.android.gms.internal.ads.zzakz):com.google.android.gms.internal.ads.zzalb");
    }

    @Nullable
    @ColorInt
    public static Integer zzb(String str) {
        try {
            long j = str.startsWith("&H") ? Long.parseLong(str.substring(2), 16) : Long.parseLong(str);
            zzgmd.zza(j <= 4294967295L);
            return Integer.valueOf(Color.argb(zzgst.zza(((j >> 24) & 255) ^ 255), zzgst.zza(j & 255), zzgst.zza((j >> 8) & 255), zzgst.zza((j >> 16) & 255)));
        } catch (IllegalArgumentException e) {
            zzdt.zzd("SsaStyle", a1.a.s(new StringBuilder(String.valueOf(str).length() + 36), "Failed to parse color expression: '", str, "'"), e);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int zzd(String str) {
        int i2;
        try {
            i2 = Integer.parseInt(str.trim());
        } catch (NumberFormatException unused) {
        }
        switch (i2) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
                return i2;
            default:
                com.google.android.gms.ads.internal.client.a.q(str, "Ignoring unknown alignment: ", "SsaStyle");
                return -1;
        }
    }

    private static boolean zze(String str) {
        try {
            int i2 = Integer.parseInt(str);
            return i2 == 1 || i2 == -1;
        } catch (NumberFormatException e) {
            zzdt.zzd("SsaStyle", a1.a.s(new StringBuilder(String.valueOf(str).length() + 33), "Failed to parse boolean value: '", str, "'"), e);
            return false;
        }
    }
}
