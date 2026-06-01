package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzemd implements zzehq {
    private final Context zza;
    private final Executor zzb;
    private final zzdrn zzc;

    public zzemd(Context context, Executor executor, zzdrn zzdrnVar) {
        this.zza = context;
        this.zzb = executor;
        this.zzc = zzdrnVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void zze(zzfgf zzfgfVar, zzffu zzffuVar, zzehn zzehnVar) {
        try {
            ((zzfhl) zzehnVar.zzb).zzl(zzfgfVar.zza.zza.zzd, zzffuVar.zzv.toString());
        } catch (Exception e) {
            String str = zzehnVar.zza;
            int i2 = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzj("Fail to load ad from adapter ".concat(String.valueOf(str)), e);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzehq
    public final void zza(zzfgf zzfgfVar, zzffu zzffuVar, zzehn zzehnVar) throws zzfgu {
        zzfhl zzfhlVar = (zzfhl) zzehnVar.zzb;
        if (zzfhlVar.zzn()) {
            zze(zzfgfVar, zzffuVar, zzehnVar);
            return;
        }
        zzema zzemaVar = new zzema(this, zzfgfVar, zzffuVar, zzehnVar);
        zzczy zzczyVar = zzehnVar.zzc;
        ((zzeja) zzczyVar).zzd(zzemaVar);
        Context context = this.zza;
        zzfgn zzfgnVar = zzfgfVar.zza.zza;
        String string = zzffuVar.zzv.toString();
        zzfhlVar.zzk(context, zzfgnVar.zzd, null, (zzbyg) zzczyVar, string);
    }

    @Override // com.google.android.gms.internal.ads.zzehq
    public final /* bridge */ /* synthetic */ Object zzb(zzfgf zzfgfVar, zzffu zzffuVar, zzehn zzehnVar) throws zzfgu, zzekz {
        zzdrj zzdrjVarZzf = this.zzc.zzf(new zzcue(zzfgfVar, zzffuVar, zzehnVar.zza), new zzdrk(new zzemb(this, zzehnVar, zzffuVar)));
        zzdrjVarZzf.zza().zzq(new zzcou((zzfhl) zzehnVar.zzb), this.zzb);
        zzczv zzczvVarZzb = zzdrjVarZzf.zzb();
        zzcym zzcymVarZzc = zzdrjVarZzf.zzc();
        ((zzeja) zzehnVar.zzc).zzc(new zzemc(this, zzdrjVarZzf.zzi(), zzcymVarZzc, zzczvVarZzb, zzdrjVarZzf.zzk()));
        return zzdrjVarZzf.zzh();
    }

    public final /* synthetic */ Executor zzc() {
        return this.zzb;
    }
}
