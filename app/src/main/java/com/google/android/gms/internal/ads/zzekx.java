package com.google.android.gms.internal.ads;

import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzekx {
    private final zzfhg zza;
    private final zzdsv zzb;
    private final zzdvi zzc;

    public zzekx(zzfhg zzfhgVar, zzdsv zzdsvVar, zzdvi zzdviVar) {
        this.zza = zzfhgVar;
        this.zzb = zzdsvVar;
        this.zzc = zzdviVar;
    }

    public final void zza(zzffx zzffxVar, zzffu zzffuVar, int i2, zzeho zzehoVar, long j) {
        zzdsu zzdsuVarZzc;
        zzdvh zzdvhVarZza = this.zzc.zza();
        zzdvhVarZza.zza(zzffxVar);
        zzdvhVarZza.zzb(zzffuVar);
        zzdvhVarZza.zzc("action", "adapter_status");
        zzdvhVarZza.zzc("adapter_l", String.valueOf(j));
        zzdvhVarZza.zzc("sc", Integer.toString(i2));
        if (zzehoVar != null) {
            zzdvhVarZza.zzc("arec", Integer.toString(zzehoVar.zzb().zza));
            String strZza = this.zza.zza(zzehoVar.getMessage());
            if (strZza != null) {
                zzdvhVarZza.zzc("areec", strZza);
            }
        }
        zzdsv zzdsvVar = this.zzb;
        Iterator it = zzffuVar.zzt.iterator();
        while (true) {
            if (!it.hasNext()) {
                zzdsuVarZzc = null;
                break;
            } else {
                zzdsuVarZzc = zzdsvVar.zzc((String) it.next());
                if (zzdsuVarZzc != null) {
                    break;
                }
            }
        }
        if (zzdsuVarZzc != null) {
            zzdvhVarZza.zzc("ancn", zzdsuVarZzc.zza);
            zzbtx zzbtxVar = zzdsuVarZzc.zzb;
            if (zzbtxVar != null) {
                zzdvhVarZza.zzc("adapter_v", zzbtxVar.toString());
            }
            zzbtx zzbtxVar2 = zzdsuVarZzc.zzc;
            if (zzbtxVar2 != null) {
                zzdvhVarZza.zzc("adapter_sv", zzbtxVar2.toString());
            }
        }
        zzdvhVarZza.zzd();
    }
}
