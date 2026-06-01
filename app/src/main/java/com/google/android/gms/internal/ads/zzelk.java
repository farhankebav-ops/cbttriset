package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzelk extends zzbte {
    private final zzehn zza;

    public /* synthetic */ zzelk(zzell zzellVar, zzehn zzehnVar, byte[] bArr) {
        Objects.requireNonNull(zzellVar);
        this.zza = zzehnVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbtf
    public final void zze() throws RemoteException {
        ((zzeiz) this.zza.zzc).zzj();
    }

    @Override // com.google.android.gms.internal.ads.zzbtf
    public final void zzf(String str) throws RemoteException {
        ((zzeiz) this.zza.zzc).zzw(0, str);
    }

    @Override // com.google.android.gms.internal.ads.zzbtf
    public final void zzg(com.google.android.gms.ads.internal.client.zze zzeVar) throws RemoteException {
        ((zzeiz) this.zza.zzc).zzx(zzeVar);
    }
}
