package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.unity3d.ads.core.data.datasource.AndroidDynamicDeviceInfoDataSource;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzedc implements zzebo {
    final /* synthetic */ zzedf zza;

    public zzedc(zzedf zzedfVar) {
        Objects.requireNonNull(zzedfVar);
        this.zza = zzedfVar;
    }

    @Override // com.google.android.gms.internal.ads.zzebo
    public final void zza() {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzoS)).booleanValue()) {
            zzdvh zzdvhVarZza = this.zza.zzd().zza();
            zzdvhVarZza.zzc("action", "ptard");
            zzdvhVarZza.zzc("ptard", AndroidDynamicDeviceInfoDataSource.DIRECTORY_MODE_READ);
            zzdvhVarZza.zzd();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzebo
    public final void zzb(RemoteException remoteException) {
        this.zza.zzc();
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzoT)).booleanValue()) {
            com.google.android.gms.ads.internal.zzt.zzh().zzg(remoteException, "Preconnect Remote");
        }
    }
}
