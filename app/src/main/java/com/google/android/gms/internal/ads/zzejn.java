package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.dynamic.ObjectWrapper;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzejn implements zzehq {
    private final Context zza;
    private final zzdjd zzb;

    public zzejn(Context context, zzdjd zzdjdVar) {
        this.zza = context;
        this.zzb = zzdjdVar;
    }

    @Override // com.google.android.gms.internal.ads.zzehq
    public final void zza(zzfgf zzfgfVar, zzffu zzffuVar, zzehn zzehnVar) throws zzfgu {
        try {
            zzbti zzbtiVar = (zzbti) zzehnVar.zzb;
            zzbtiVar.zzo(zzffuVar.zzZ);
            zzbtiVar.zzj(zzffuVar.zzU, zzffuVar.zzv.toString(), zzfgfVar.zza.zza.zzd, ObjectWrapper.wrap(this.zza), new zzejm(this, zzehnVar, null), (zzbrp) zzehnVar.zzc);
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.zze.zzb("Remote exception loading a interstitial RTB ad", e);
            throw new zzfgu(e);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzehq
    public final /* bridge */ /* synthetic */ Object zzb(zzfgf zzfgfVar, zzffu zzffuVar, zzehn zzehnVar) throws zzfgu, zzekz {
        zzeji zzejiVar = new zzeji(zzffuVar, (zzbti) zzehnVar.zzb, AdFormat.INTERSTITIAL);
        zzdhx zzdhxVarZzd = this.zzb.zzd(new zzcue(zzfgfVar, zzffuVar, zzehnVar.zza), new zzdia(zzejiVar, null));
        zzejiVar.zzc(zzdhxVarZzd.zzd());
        ((zzeiz) zzehnVar.zzc).zzc(zzdhxVarZzd.zzg());
        return zzdhxVarZzd.zzh();
    }
}
