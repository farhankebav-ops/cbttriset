package com.google.android.gms.internal.ads;

import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzblz implements zzblx {
    private final zzbma zza;

    public zzblz(zzbma zzbmaVar) {
        this.zza = zzbmaVar;
    }

    @Override // com.google.android.gms.internal.ads.zzblx
    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        zzcgy zzcgyVar = (zzcgy) obj;
        boolean zEquals = "1".equals(map.get("transparentBackground"));
        boolean zEquals2 = "1".equals(map.get("blur"));
        float f4 = 0.0f;
        try {
            if (map.get("blurRadius") != null) {
                f4 = Float.parseFloat((String) map.get("blurRadius"));
            }
        } catch (NumberFormatException e) {
            int i2 = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzg("Fail to parse float", e);
        }
        zzbma zzbmaVar = this.zza;
        zzbmaVar.zza(zEquals);
        zzbmaVar.zzb(zEquals2, f4);
        zzcgyVar.zzaE(zEquals);
    }
}
