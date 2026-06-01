package com.google.android.gms.internal.ads;

import android.content.Context;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzeee implements zzfjx {
    protected final Context zza;
    protected final String zzb;

    @Nullable
    private final String zzc;

    public zzeee(Context context, String str, zzbxr zzbxrVar, int i2, @Nullable String str2) {
        this.zza = context;
        this.zzb = str;
        this.zzc = str2;
    }

    @Override // com.google.android.gms.internal.ads.zzfjx
    /* JADX INFO: renamed from: zzb, reason: merged with bridge method [inline-methods] */
    public final zzeed zza(zzeec zzeecVar) throws zzdzv {
        return zzc(zzeecVar.zza, zzeecVar.zzb, zzeecVar.zzc, zzeecVar.zzd, zzeecVar.zze, com.google.android.gms.ads.internal.zzt.zzk().elapsedRealtime());
    }

    /* JADX WARN: Code restructure failed: missing block: B:65:0x019f, code lost:
    
        r12.disconnect();
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x0221, code lost:
    
        r3 = new java.lang.StringBuilder(java.lang.String.valueOf(r0).length() + 35);
        r3.append("Received error HTTP response code: ");
        r3.append(r0);
        com.google.android.gms.ads.internal.util.client.zzo.zzi(r3.toString());
        r4 = new java.lang.StringBuilder(java.lang.String.valueOf(r0).length() + 35);
        r4.append("Received error HTTP response code: ");
        r4.append(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x025b, code lost:
    
        throw new com.google.android.gms.internal.ads.zzdzv(1, r4.toString());
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x027c, code lost:
    
        return r7;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.google.android.gms.internal.ads.zzeed zzc(java.lang.String r19, int r20, java.util.Map r21, byte[] r22, java.lang.String r23, long r24) throws com.google.android.gms.internal.ads.zzdzv, java.net.MalformedURLException {
        /*
            Method dump skipped, instruction units count: 667
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzeee.zzc(java.lang.String, int, java.util.Map, byte[], java.lang.String, long):com.google.android.gms.internal.ads.zzeed");
    }
}
