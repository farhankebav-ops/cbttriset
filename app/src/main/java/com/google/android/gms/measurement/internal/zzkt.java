package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzkt implements Runnable {
    final /* synthetic */ zzaz zza;
    final /* synthetic */ zzlj zzb;

    public zzkt(zzlj zzljVar, zzaz zzazVar) {
        this.zza = zzazVar;
        Objects.requireNonNull(zzljVar);
        this.zzb = zzljVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzlj zzljVar = this.zzb;
        zzic zzicVar = zzljVar.zzu;
        zzhh zzhhVarZzd = zzicVar.zzd();
        zzic zzicVar2 = zzhhVarZzd.zzu;
        zzhhVarZzd.zzg();
        zzaz zzazVarZzj = zzhhVarZzd.zzj();
        zzaz zzazVar = this.zza;
        if (!zzjl.zzu(zzazVar.zzb(), zzazVarZzj.zzb())) {
            zzicVar.zzaV().zzi().zzb("Lower precedence consent source ignored, proposed source", Integer.valueOf(zzazVar.zzb()));
            return;
        }
        SharedPreferences.Editor editorEdit = zzhhVarZzd.zzd().edit();
        editorEdit.putString("dma_consent_settings", zzazVar.zze());
        editorEdit.apply();
        zzicVar.zzaV().zzk().zzb("Setting DMA consent(FE)", zzazVar);
        zzic zzicVar3 = zzljVar.zzu;
        if (zzicVar3.zzt().zzP()) {
            zzicVar3.zzt().zzl();
        } else {
            zzicVar3.zzt().zzj(false);
        }
    }
}
