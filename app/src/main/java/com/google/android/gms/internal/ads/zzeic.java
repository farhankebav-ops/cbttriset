package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.dynamic.ObjectWrapper;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzeic implements zzehq {
    private final Context zza;
    private final zzcqu zzb;

    public zzeic(Context context, zzcqu zzcquVar) {
        this.zza = context;
        this.zzb = zzcquVar;
    }

    @Override // com.google.android.gms.internal.ads.zzehq
    public final void zza(zzfgf zzfgfVar, zzffu zzffuVar, zzehn zzehnVar) throws zzfgu {
        try {
            zzbti zzbtiVar = (zzbti) zzehnVar.zzb;
            zzbtiVar.zzo(zzffuVar.zzZ);
            zzbtiVar.zzs(zzffuVar.zzU, zzffuVar.zzv.toString(), zzfgfVar.zza.zza.zzd, ObjectWrapper.wrap(this.zza), new zzeib(zzehnVar, null), (zzbrp) zzehnVar.zzc);
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.zze.zzb("Remote exception loading an app open RTB ad", e);
            throw new zzfgu(e);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzehq
    public final /* bridge */ /* synthetic */ Object zzb(zzfgf zzfgfVar, zzffu zzffuVar, zzehn zzehnVar) throws zzfgu, zzekz {
        zzeji zzejiVar = new zzeji(zzffuVar, (zzbti) zzehnVar.zzb, AdFormat.APP_OPEN_AD);
        zzcqr zzcqrVarZzf = this.zzb.zzf(new zzcue(zzfgfVar, zzffuVar, zzehnVar.zza), new zzdia(zzejiVar, null), new zzcqs(zzffuVar.zzaa));
        zzejiVar.zzc(zzcqrVarZzf.zzd());
        ((zzeiz) zzehnVar.zzc).zzc(zzcqrVarZzf.zzg());
        return zzcqrVarZzf.zzh();
    }
}
