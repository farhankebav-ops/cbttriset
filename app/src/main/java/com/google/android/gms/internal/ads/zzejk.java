package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzejk implements zzehq {
    private final Context zza;
    private final zzdjd zzb;
    private final VersionInfoParcel zzc;
    private final Executor zzd;

    public zzejk(Context context, VersionInfoParcel versionInfoParcel, zzdjd zzdjdVar, Executor executor) {
        this.zza = context;
        this.zzc = versionInfoParcel;
        this.zzb = zzdjdVar;
        this.zzd = executor;
    }

    @Override // com.google.android.gms.internal.ads.zzehq
    public final void zza(zzfgf zzfgfVar, zzffu zzffuVar, zzehn zzehnVar) throws zzfgu {
        zzfhl zzfhlVar = (zzfhl) zzehnVar.zzb;
        zzfgn zzfgnVar = zzfgfVar.zza.zza;
        String string = zzffuVar.zzv.toString();
        String strZzm = com.google.android.gms.ads.internal.util.zzbp.zzm(zzffuVar.zzs);
        zzfhlVar.zzh(this.zza, zzfgnVar.zzd, string, strZzm, (zzbrp) zzehnVar.zzc);
    }

    @Override // com.google.android.gms.internal.ads.zzehq
    public final /* bridge */ /* synthetic */ Object zzb(zzfgf zzfgfVar, zzffu zzffuVar, zzehn zzehnVar) throws zzfgu, zzekz {
        zzdhx zzdhxVarZzd = this.zzb.zzd(new zzcue(zzfgfVar, zzffuVar, zzehnVar.zza), new zzdia(new zzejj(this, zzehnVar, zzffuVar), null));
        zzdhxVarZzd.zza().zzq(new zzcou((zzfhl) zzehnVar.zzb), this.zzd);
        ((zzeiz) zzehnVar.zzc).zzc(zzdhxVarZzd.zzf());
        return zzdhxVarZzd.zzh();
    }

    public final /* synthetic */ VersionInfoParcel zzc() {
        return this.zzc;
    }
}
