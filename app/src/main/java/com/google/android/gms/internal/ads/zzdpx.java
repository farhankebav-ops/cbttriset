package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzdpx extends zzbiw {

    @Nullable
    private final String zza;
    private final zzdll zzb;
    private final zzdlq zzc;

    public zzdpx(@Nullable String str, zzdll zzdllVar, zzdlq zzdlqVar) {
        this.zza = str;
        this.zzb = zzdllVar;
        this.zzc = zzdlqVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbix
    public final IObjectWrapper zzb() throws RemoteException {
        return ObjectWrapper.wrap(this.zzb);
    }

    @Override // com.google.android.gms.internal.ads.zzbix
    public final String zzc() throws RemoteException {
        return this.zzc.zzB();
    }

    @Override // com.google.android.gms.internal.ads.zzbix
    public final List zzd() throws RemoteException {
        return this.zzc.zzC();
    }

    @Override // com.google.android.gms.internal.ads.zzbix
    public final String zze() throws RemoteException {
        return this.zzc.zzG();
    }

    @Override // com.google.android.gms.internal.ads.zzbix
    public final zzbii zzf() throws RemoteException {
        return this.zzc.zzP();
    }

    @Override // com.google.android.gms.internal.ads.zzbix
    public final String zzg() throws RemoteException {
        return this.zzc.zzI();
    }

    @Override // com.google.android.gms.internal.ads.zzbix
    public final double zzh() throws RemoteException {
        return this.zzc.zzO();
    }

    @Override // com.google.android.gms.internal.ads.zzbix
    public final String zzi() throws RemoteException {
        return this.zzc.zzM();
    }

    @Override // com.google.android.gms.internal.ads.zzbix
    public final String zzj() throws RemoteException {
        return this.zzc.zzN();
    }

    @Override // com.google.android.gms.internal.ads.zzbix
    public final Bundle zzk() throws RemoteException {
        return this.zzc.zzH();
    }

    @Override // com.google.android.gms.internal.ads.zzbix
    public final void zzl() throws RemoteException {
        this.zzb.zzd();
    }

    @Override // com.google.android.gms.internal.ads.zzbix
    public final com.google.android.gms.ads.internal.client.zzed zzm() throws RemoteException {
        return this.zzc.zzy();
    }

    @Override // com.google.android.gms.internal.ads.zzbix
    public final void zzn(Bundle bundle) throws RemoteException {
        this.zzb.zzc(bundle);
    }

    @Override // com.google.android.gms.internal.ads.zzbix
    public final boolean zzo(Bundle bundle) throws RemoteException {
        return this.zzb.zze(bundle);
    }

    @Override // com.google.android.gms.internal.ads.zzbix
    public final void zzp(Bundle bundle) throws RemoteException {
        this.zzb.zzf(bundle);
    }

    @Override // com.google.android.gms.internal.ads.zzbix
    public final zzbib zzq() throws RemoteException {
        return this.zzc.zzz();
    }

    @Override // com.google.android.gms.internal.ads.zzbix
    public final IObjectWrapper zzr() throws RemoteException {
        return this.zzc.zzL();
    }

    @Override // com.google.android.gms.internal.ads.zzbix
    public final String zzs() throws RemoteException {
        return this.zza;
    }
}
