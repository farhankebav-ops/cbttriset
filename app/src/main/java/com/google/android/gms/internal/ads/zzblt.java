package com.google.android.gms.internal.ads;

import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final /* synthetic */ class zzblt implements zzblx {
    static final /* synthetic */ zzblt zza = new zzblt();

    private /* synthetic */ zzblt() {
    }

    @Override // com.google.android.gms.internal.ads.zzblx
    public final /* synthetic */ void zza(Object obj, Map map) {
        zzcir zzcirVar = (zzcir) obj;
        zzblx zzblxVar = zzblw.zza;
        String str = (String) map.get("tx");
        String str2 = (String) map.get("ty");
        String str3 = (String) map.get("td");
        try {
            int i2 = Integer.parseInt(str);
            int i8 = Integer.parseInt(str2);
            int i9 = Integer.parseInt(str3);
            zzaxa zzaxaVarZzS = zzcirVar.zzS();
            if (zzaxaVarZzS != null) {
                zzaxaVarZzS.zzb().zze(i2, i8, i9);
            }
        } catch (NumberFormatException unused) {
            int i10 = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzi("Could not parse touch parameters from gmsg.");
        }
    }
}
