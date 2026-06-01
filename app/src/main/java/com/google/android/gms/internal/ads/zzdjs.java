package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzdjs implements zzctr {
    private final Map zza;
    private final Map zzb;
    private final Map zzc;
    private final zzifw zzd;
    private final zzdma zze;

    public zzdjs(Map map, Map map2, Map map3, zzifw zzifwVar, zzdma zzdmaVar) {
        this.zza = map;
        this.zzb = map2;
        this.zzc = map3;
        this.zzd = zzifwVar;
        this.zze = zzdmaVar;
    }

    @Override // com.google.android.gms.internal.ads.zzctr
    @Nullable
    public final zzehk zza(int i2, String str) {
        zzehk zzehkVarZza;
        zzehk zzehkVar = (zzehk) this.zza.get(str);
        if (zzehkVar != null) {
            return zzehkVar;
        }
        if (i2 != 1) {
            if (i2 != 4) {
                return null;
            }
            zzejq zzejqVar = (zzejq) this.zzc.get(str);
            if (zzejqVar != null) {
                return zzctw.zza(zzejqVar);
            }
            zzehkVarZza = (zzehk) this.zzb.get(str);
            if (zzehkVarZza == null) {
                return null;
            }
        } else if (this.zze.zzd() == null || (zzehkVarZza = ((zzctr) this.zzd.zzb()).zza(i2, str)) == null) {
            return null;
        }
        return zzctw.zzb(zzehkVarZza);
    }
}
