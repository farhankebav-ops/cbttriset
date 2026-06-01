package com.google.android.gms.internal.ads;

import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import java.util.HashMap;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzhv implements zzyv {
    final /* synthetic */ zzhx zza;

    @GuardedBy("this")
    private final HashMap zzb;

    @GuardedBy("this")
    private final zzpc zzc;

    public zzhv(zzhx zzhxVar, zzpc zzpcVar) {
        Objects.requireNonNull(zzhxVar);
        this.zza = zzhxVar;
        this.zzb = new HashMap();
        this.zzc = zzpcVar;
    }

    @GuardedBy("this")
    private final void zze(zzyt zzytVar) {
        zzpc zzpcVar = (zzpc) this.zzb.remove(zzytVar);
        zzpcVar.getClass();
        zzhw zzhwVar = (zzhw) this.zza.zzl().get(zzpcVar);
        if (zzhwVar != null) {
            zzhwVar.zzb();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzyv
    public final synchronized zzyt zza() {
        zzyt zzytVarZza;
        zzhx zzhxVar = this.zza;
        zzzb zzzbVarZzk = zzhxVar.zzk();
        HashMap map = this.zzb;
        zzytVarZza = zzzbVarZzk.zza();
        zzpc zzpcVar = this.zzc;
        map.put(zzytVarZza, zzpcVar);
        zzhw zzhwVar = (zzhw) zzhxVar.zzl().get(zzpcVar);
        if (zzhwVar != null) {
            zzhwVar.zza();
        }
        return zzytVarZza;
    }

    @Override // com.google.android.gms.internal.ads.zzyv
    public final synchronized void zzb(zzyt zzytVar) {
        this.zza.zzk().zzb(zzytVar);
        zze(zzytVar);
    }

    @Override // com.google.android.gms.internal.ads.zzyv
    public final synchronized void zzc(@Nullable zzyu zzyuVar) {
        this.zza.zzk().zzc(zzyuVar);
        while (zzyuVar != null) {
            zze(zzyuVar.zzd());
            zzyuVar = zzyuVar.zze();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzyv
    public final synchronized void zzd() {
        this.zza.zzk().zzd();
    }
}
