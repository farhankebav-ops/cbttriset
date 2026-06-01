package com.google.android.gms.ads.internal.client;

import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.ads.zzbod;
import com.google.android.gms.internal.ads.zzbrj;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzfm extends zzda {
    private zzbod zza;

    public final /* synthetic */ void zzb() {
        zzbod zzbodVar = this.zza;
        if (zzbodVar != null) {
            try {
                zzbodVar.zzb(Collections.EMPTY_LIST);
            } catch (RemoteException e) {
                com.google.android.gms.ads.internal.util.client.zzo.zzj("Could not notify onComplete event.", e);
            }
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zzdb
    public final void zze() throws RemoteException {
        com.google.android.gms.ads.internal.util.client.zzo.zzf("The initialization is not processed because MobileAdsSettingsManager is not created successfully.");
        com.google.android.gms.ads.internal.util.client.zzf.zza.post(new Runnable() { // from class: com.google.android.gms.ads.internal.client.zzfl
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                this.zza.zzb();
            }
        });
    }

    @Override // com.google.android.gms.ads.internal.client.zzdb
    public final float zzk() throws RemoteException {
        return 1.0f;
    }

    @Override // com.google.android.gms.ads.internal.client.zzdb
    public final boolean zzl() throws RemoteException {
        return false;
    }

    @Override // com.google.android.gms.ads.internal.client.zzdb
    public final String zzm() {
        return "";
    }

    @Override // com.google.android.gms.ads.internal.client.zzdb
    public final void zzp(zzbod zzbodVar) throws RemoteException {
        this.zza = zzbodVar;
    }

    @Override // com.google.android.gms.ads.internal.client.zzdb
    public final List zzq() throws RemoteException {
        return Collections.EMPTY_LIST;
    }

    @Override // com.google.android.gms.ads.internal.client.zzdb
    public final void zzs() {
    }

    @Override // com.google.android.gms.ads.internal.client.zzdb
    public final void zzf(float f4) throws RemoteException {
    }

    @Override // com.google.android.gms.ads.internal.client.zzdb
    public final void zzg(String str) throws RemoteException {
    }

    @Override // com.google.android.gms.ads.internal.client.zzdb
    public final void zzh(boolean z2) throws RemoteException {
    }

    @Override // com.google.android.gms.ads.internal.client.zzdb
    public final void zzn(@Nullable String str) throws RemoteException {
    }

    @Override // com.google.android.gms.ads.internal.client.zzdb
    public final void zzo(zzbrj zzbrjVar) throws RemoteException {
    }

    @Override // com.google.android.gms.ads.internal.client.zzdb
    public final void zzr(zzfv zzfvVar) throws RemoteException {
    }

    @Override // com.google.android.gms.ads.internal.client.zzdb
    public final void zzt(zzdn zzdnVar) {
    }

    @Override // com.google.android.gms.ads.internal.client.zzdb
    public final void zzu(boolean z2) throws RemoteException {
    }

    @Override // com.google.android.gms.ads.internal.client.zzdb
    public final void zzv(String str) {
    }

    @Override // com.google.android.gms.ads.internal.client.zzdb
    public final void zzi(IObjectWrapper iObjectWrapper, String str) throws RemoteException {
    }

    @Override // com.google.android.gms.ads.internal.client.zzdb
    public final void zzj(@Nullable String str, IObjectWrapper iObjectWrapper) throws RemoteException {
    }
}
