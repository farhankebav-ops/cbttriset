package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.IntentFilter;
import android.media.AudioDeviceInfo;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import android.util.SparseArray;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.ironsource.C2300e4;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzpe {

    @VisibleForTesting
    static final zzgph zzb;
    private final SparseArray zzd = new SparseArray();
    private final int zze;
    public static final zzpe zza = new zzpe(zzgpe.zzj(zzpd.zza));
    private static final zzgpe zzc = zzgpe.zzl(2, 5, 6);

    static {
        zzgpg zzgpgVar = new zzgpg();
        zzgpgVar.zza(5, 6);
        zzgpgVar.zza(17, 6);
        zzgpgVar.zza(7, 6);
        zzgpgVar.zza(30, 10);
        zzgpgVar.zza(18, 6);
        zzgpgVar.zza(6, 8);
        zzgpgVar.zza(8, 8);
        zzgpgVar.zza(14, 8);
        zzb = zzgpgVar.zzc();
    }

    private zzpe(List list) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            zzpd zzpdVar = (zzpd) list.get(i2);
            this.zzd.put(zzpdVar.zzb, zzpdVar);
        }
        int iMax = 0;
        for (int i8 = 0; i8 < this.zzd.size(); i8++) {
            iMax = Math.max(iMax, ((zzpd) this.zzd.valueAt(i8)).zzc);
        }
        this.zze = iMax;
    }

    public static zzpe zza(Context context, zzd zzdVar, @Nullable AudioDeviceInfo audioDeviceInfo) {
        return zzb(context, context.registerReceiver(null, new IntentFilter("android.media.action.HDMI_AUDIO_PLUG")), zzdVar, audioDeviceInfo);
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0022  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.google.android.gms.internal.ads.zzpe zzb(android.content.Context r11, @androidx.annotation.Nullable android.content.Intent r12, com.google.android.gms.internal.ads.zzd r13, @androidx.annotation.Nullable android.media.AudioDeviceInfo r14) {
        /*
            Method dump skipped, instruction units count: 588
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzpe.zzb(android.content.Context, android.content.Intent, com.google.android.gms.internal.ads.zzd, android.media.AudioDeviceInfo):com.google.android.gms.internal.ads.zzpe");
    }

    @Nullable
    public static Uri zzc() {
        if (zze()) {
            return Settings.Global.getUriFor("external_surround_sound_enabled");
        }
        return null;
    }

    private static boolean zze() {
        String str = Build.MANUFACTURER;
        return str.equals("Amazon") || str.equals("Xiaomi");
    }

    private static zzgpe zzf(@Nullable int[] iArr, int i2) {
        int i8 = zzgpe.zzd;
        zzgpb zzgpbVar = new zzgpb();
        for (int i9 : iArr) {
            zzgpbVar.zzf(new zzpd(i9, i2));
        }
        return zzgpbVar.zzi();
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0046 A[ORIG_RETURN, RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean equals(@androidx.annotation.Nullable java.lang.Object r8) {
        /*
            r7 = this;
            if (r7 != r8) goto L3
            goto L46
        L3:
            boolean r0 = r8 instanceof com.google.android.gms.internal.ads.zzpe
            r1 = 0
            if (r0 != 0) goto L9
            goto L48
        L9:
            com.google.android.gms.internal.ads.zzpe r8 = (com.google.android.gms.internal.ads.zzpe) r8
            android.util.SparseArray r0 = r7.zzd
            android.util.SparseArray r2 = r8.zzd
            java.lang.String r3 = com.google.android.gms.internal.ads.zzep.zza
            int r3 = android.os.Build.VERSION.SDK_INT
            r4 = 31
            if (r3 < r4) goto L1e
            boolean r0 = com.google.android.gms.internal.ads.k0.y(r0, r2)
            if (r0 == 0) goto L48
            goto L40
        L1e:
            int r3 = r0.size()
            int r4 = r2.size()
            if (r3 != r4) goto L48
            r4 = r1
        L29:
            if (r4 >= r3) goto L40
            int r5 = r0.keyAt(r4)
            java.lang.Object r6 = r0.valueAt(r4)
            java.lang.Object r5 = r2.get(r5)
            boolean r5 = java.util.Objects.equals(r6, r5)
            if (r5 == 0) goto L48
            int r4 = r4 + 1
            goto L29
        L40:
            int r0 = r7.zze
            int r8 = r8.zze
            if (r0 != r8) goto L48
        L46:
            r8 = 1
            return r8
        L48:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzpe.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        int iContentHashCode;
        String str = zzep.zza;
        int i2 = Build.VERSION.SDK_INT;
        SparseArray sparseArray = this.zzd;
        if (i2 >= 31) {
            iContentHashCode = sparseArray.contentHashCode();
        } else {
            int iHashCode = 17;
            for (int i8 = 0; i8 < sparseArray.size(); i8++) {
                iHashCode = Objects.hashCode(sparseArray.valueAt(i8)) + ((sparseArray.keyAt(i8) + (iHashCode * 31)) * 31);
            }
            iContentHashCode = iHashCode;
        }
        return (iContentHashCode * 31) + this.zze;
    }

    public final String toString() {
        String string = this.zzd.toString();
        int i2 = this.zze;
        StringBuilder sb = new StringBuilder(String.valueOf(i2).length() + 50 + string.length() + 1);
        sb.append("AudioCapabilities[maxChannelCount=");
        sb.append(i2);
        sb.append(", audioProfiles=");
        sb.append(string);
        sb.append(C2300e4.i.e);
        return sb.toString();
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x003a A[PHI: r1
  0x003a: PHI (r1v3 int) = (r1v2 int), (r1v7 int) binds: [B:11:0x002c, B:14:0x0036] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0099  */
    @androidx.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final android.util.Pair zzd(com.google.android.gms.internal.ads.zzv r10, com.google.android.gms.internal.ads.zzd r11) {
        /*
            r9 = this;
            java.lang.String r0 = r10.zzo
            r0.getClass()
            java.lang.String r1 = r10.zzk
            int r1 = com.google.android.gms.internal.ads.zzas.zzh(r0, r1)
            com.google.android.gms.internal.ads.zzgph r2 = com.google.android.gms.internal.ads.zzpe.zzb
            java.lang.Integer r3 = java.lang.Integer.valueOf(r1)
            boolean r2 = r2.containsKey(r3)
            if (r2 != 0) goto L19
            goto Lbf
        L19:
            r2 = 7
            r3 = 8
            r4 = 6
            r5 = 18
            if (r1 != r5) goto L2c
            android.util.SparseArray r1 = r9.zzd
            boolean r1 = com.google.android.gms.internal.ads.zzep.zza(r1, r5)
            if (r1 != 0) goto L2b
            r1 = r4
            goto L47
        L2b:
            r1 = r5
        L2c:
            if (r1 != r3) goto L3a
            android.util.SparseArray r1 = r9.zzd
            boolean r1 = com.google.android.gms.internal.ads.zzep.zza(r1, r3)
            if (r1 == 0) goto L38
            r1 = r3
            goto L3a
        L38:
            r1 = r2
            goto L47
        L3a:
            r6 = 30
            if (r1 != r6) goto L47
            android.util.SparseArray r7 = r9.zzd
            boolean r6 = com.google.android.gms.internal.ads.zzep.zza(r7, r6)
            if (r6 != 0) goto L47
            goto L38
        L47:
            android.util.SparseArray r6 = r9.zzd
            boolean r7 = com.google.android.gms.internal.ads.zzep.zza(r6, r1)
            if (r7 == 0) goto Lbf
            java.lang.Object r6 = r6.get(r1)
            com.google.android.gms.internal.ads.zzpd r6 = (com.google.android.gms.internal.ads.zzpd) r6
            r6.getClass()
            int r7 = r10.zzG
            r8 = -1
            if (r7 == r8) goto L7a
            if (r1 != r5) goto L60
            goto L7a
        L60:
            java.lang.String r10 = "audio/vnd.dts.uhd;profile=p2"
            boolean r10 = r0.equals(r10)
            if (r10 == 0) goto L73
            int r10 = android.os.Build.VERSION.SDK_INT
            r11 = 33
            if (r10 >= r11) goto L73
            r10 = 10
            if (r7 <= r10) goto L85
            goto Lbf
        L73:
            boolean r10 = r6.zza(r7)
            if (r10 != 0) goto L85
            goto Lbf
        L7a:
            int r10 = r10.zzH
            if (r10 != r8) goto L81
            r10 = 48000(0xbb80, float:6.7262E-41)
        L81:
            int r7 = r6.zzb(r10, r11)
        L85:
            int r10 = android.os.Build.VERSION.SDK_INT
            r11 = 28
            if (r10 > r11) goto L99
            if (r7 != r2) goto L8e
            goto L9a
        L8e:
            r11 = 3
            if (r7 == r11) goto L97
            r11 = 4
            if (r7 == r11) goto L97
            r11 = 5
            if (r7 != r11) goto L99
        L97:
            r3 = r4
            goto L9a
        L99:
            r3 = r7
        L9a:
            r11 = 26
            if (r10 > r11) goto Lac
            java.lang.String r10 = "fugu"
            java.lang.String r11 = android.os.Build.DEVICE
            boolean r10 = r10.equals(r11)
            if (r10 == 0) goto Lac
            r10 = 1
            if (r3 != r10) goto Lac
            r3 = 2
        Lac:
            int r10 = com.google.android.gms.internal.ads.zzep.zzB(r3)
            if (r10 == 0) goto Lbf
            java.lang.Integer r11 = java.lang.Integer.valueOf(r1)
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)
            android.util.Pair r10 = android.util.Pair.create(r11, r10)
            return r10
        Lbf:
            r10 = 0
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzpe.zzd(com.google.android.gms.internal.ads.zzv, com.google.android.gms.internal.ads.zzd):android.util.Pair");
    }
}
