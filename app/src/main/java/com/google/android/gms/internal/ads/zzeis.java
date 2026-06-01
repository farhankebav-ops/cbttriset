package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzeis extends zzbsv {
    final /* synthetic */ zzeit zza;
    private final zzehn zzb;

    public /* synthetic */ zzeis(zzeit zzeitVar, zzehn zzehnVar, byte[] bArr) {
        Objects.requireNonNull(zzeitVar);
        this.zza = zzeitVar;
        this.zzb = zzehnVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbsw
    public final void zze(IObjectWrapper iObjectWrapper) throws RemoteException {
        this.zza.zzd((View) ObjectWrapper.unwrap(iObjectWrapper));
        ((zzeiz) this.zzb.zzc).zzj();
    }

    @Override // com.google.android.gms.internal.ads.zzbsw
    public final void zzf(String str) throws RemoteException {
        ((zzeiz) this.zzb.zzc).zzw(0, str);
    }

    @Override // com.google.android.gms.internal.ads.zzbsw
    public final void zzg(com.google.android.gms.ads.internal.client.zze zzeVar) throws RemoteException {
        ((zzeiz) this.zzb.zzc).zzx(zzeVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbsw
    public final void zzh(zzbrs zzbrsVar) throws RemoteException {
        this.zza.zze(zzbrsVar);
        ((zzeiz) this.zzb.zzc).zzj();
    }
}
