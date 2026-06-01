package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzfdi {
    private final zzfic zza;
    private final zzcxv zzb;
    private final Executor zzc;
    private zzfdg zzd;

    public zzfdi(zzfic zzficVar, zzcxv zzcxvVar, Executor executor) {
        this.zza = zzficVar;
        this.zzb = zzcxvVar;
        this.zzc = executor;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Deprecated
    /* JADX INFO: renamed from: zze, reason: merged with bridge method [inline-methods] */
    public final zzfim zzb() {
        zzfgn zzfgnVarZzb = this.zzb.zzb();
        return this.zza.zzd(zzfgnVarZzb.zzd, zzfgnVarZzb.zzg, zzfgnVarZzb.zzk);
    }

    public final j2.q zza() {
        j2.q qVarZza;
        zzfdg zzfdgVar = this.zzd;
        if (zzfdgVar != null) {
            return zzgui.zza(zzfdgVar);
        }
        if (((Boolean) zzbhb.zza.zze()).booleanValue()) {
            zzgua zzguaVarZzw = zzgua.zzw(this.zzb.zza().zze(this.zza.zze()));
            zzfdf zzfdfVar = new zzfdf(this);
            Executor executor = this.zzc;
            qVarZza = (zzgua) zzgui.zzg((zzgua) zzgui.zzk(zzguaVarZzw, zzfdfVar, executor), zzecj.class, new zzfde(this), executor);
        } else {
            zzfdg zzfdgVar2 = new zzfdg(null, zzb(), null);
            this.zzd = zzfdgVar2;
            qVarZza = zzgui.zza(zzfdgVar2);
        }
        return zzgui.zzk(qVarZza, zzfdh.zza, this.zzc);
    }

    public final /* synthetic */ zzfdg zzc() {
        return this.zzd;
    }

    public final /* synthetic */ void zzd(zzfdg zzfdgVar) {
        this.zzd = zzfdgVar;
    }
}
