package com.google.android.gms.ads.internal.util;

import androidx.annotation.Nullable;
import com.google.android.gms.internal.ads.zzapc;
import com.google.android.gms.internal.ads.zzapx;
import com.google.android.gms.internal.ads.zzcca;
import j2.q;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzbl {
    private static zzapx zza;
    private static final Object zzb = new Object();

    /* JADX WARN: Removed duplicated region for block: B:16:0x0036 A[Catch: all -> 0x0034, TryCatch #0 {all -> 0x0034, blocks: (B:7:0x0010, B:9:0x0014, B:11:0x001d, B:13:0x002f, B:17:0x003b, B:16:0x0036, B:18:0x003d), top: B:22:0x0010 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public zzbl(android.content.Context r4) {
        /*
            r3 = this;
            r3.<init>()
            android.content.Context r0 = r4.getApplicationContext()
            if (r0 == 0) goto Ld
            android.content.Context r4 = r4.getApplicationContext()
        Ld:
            java.lang.Object r0 = com.google.android.gms.ads.internal.util.zzbl.zzb
            monitor-enter(r0)
            com.google.android.gms.internal.ads.zzapx r1 = com.google.android.gms.ads.internal.util.zzbl.zza     // Catch: java.lang.Throwable -> L34
            if (r1 != 0) goto L3d
            com.google.android.gms.internal.ads.zzbeu.zza(r4)     // Catch: java.lang.Throwable -> L34
            boolean r1 = com.google.android.gms.common.util.ClientLibraryUtils.isPackageSide()     // Catch: java.lang.Throwable -> L34
            if (r1 != 0) goto L36
            com.google.android.gms.internal.ads.zzbel r1 = com.google.android.gms.internal.ads.zzbeu.zzeY     // Catch: java.lang.Throwable -> L34
            com.google.android.gms.internal.ads.zzbes r2 = com.google.android.gms.ads.internal.client.zzbd.zzc()     // Catch: java.lang.Throwable -> L34
            java.lang.Object r1 = r2.zzd(r1)     // Catch: java.lang.Throwable -> L34
            java.lang.Boolean r1 = (java.lang.Boolean) r1     // Catch: java.lang.Throwable -> L34
            boolean r1 = r1.booleanValue()     // Catch: java.lang.Throwable -> L34
            if (r1 == 0) goto L36
            com.google.android.gms.internal.ads.zzapx r4 = com.google.android.gms.ads.internal.util.zzay.zzb(r4)     // Catch: java.lang.Throwable -> L34
            goto L3b
        L34:
            r4 = move-exception
            goto L3f
        L36:
            r1 = 0
            com.google.android.gms.internal.ads.zzapx r4 = com.google.android.gms.internal.ads.zzaqz.zza(r4, r1)     // Catch: java.lang.Throwable -> L34
        L3b:
            com.google.android.gms.ads.internal.util.zzbl.zza = r4     // Catch: java.lang.Throwable -> L34
        L3d:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L34
            return
        L3f:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L34
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.util.zzbl.<init>(android.content.Context):void");
    }

    public final q zza(String str) {
        zzcca zzccaVar = new zzcca();
        zza.zzb(new zzbk(str, null, zzccaVar));
        return zzccaVar;
    }

    public final q zzb(int i2, String str, @Nullable Map map, @Nullable byte[] bArr) {
        zzbi zzbiVar = new zzbi(null);
        zzbg zzbgVar = new zzbg(this, str, zzbiVar);
        com.google.android.gms.ads.internal.util.client.zzl zzlVar = new com.google.android.gms.ads.internal.util.client.zzl(null);
        zzbh zzbhVar = new zzbh(this, i2, str, zzbiVar, zzbgVar, bArr, map, zzlVar);
        if (com.google.android.gms.ads.internal.util.client.zzl.zzj()) {
            try {
                zzlVar.zzb(str, "GET", zzbhVar.zzm(), zzbhVar.zzn());
            } catch (zzapc e) {
                String message = e.getMessage();
                int i8 = zze.zza;
                com.google.android.gms.ads.internal.util.client.zzo.zzi(message);
            }
        }
        zza.zzb(zzbhVar);
        return zzbiVar;
    }
}
