package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import androidx.annotation.Nullable;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzemf implements zzehm {
    private final zzenj zza;
    private final zzdsy zzb;

    public zzemf(zzenj zzenjVar, zzdsy zzdsyVar) {
        this.zza = zzenjVar;
        this.zzb = zzdsyVar;
    }

    @Override // com.google.android.gms.internal.ads.zzehm
    @Nullable
    public final zzehn zza(String str, JSONObject jSONObject) throws zzfgu {
        zzbti zzbtiVarZzb;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzbV)).booleanValue()) {
            try {
                zzbtiVarZzb = this.zzb.zzb(str);
            } catch (RemoteException e) {
                int i2 = com.google.android.gms.ads.internal.util.zze.zza;
                com.google.android.gms.ads.internal.util.client.zzo.zzg("Coundn't create RTB adapter: ", e);
                zzbtiVarZzb = null;
            }
        } else {
            zzbtiVarZzb = this.zza.zzb(str);
        }
        if (zzbtiVarZzb == null) {
            return null;
        }
        return new zzehn(zzbtiVarZzb, new zzeiz(), str);
    }
}
