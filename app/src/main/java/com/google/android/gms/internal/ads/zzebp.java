package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.ConnectionResult;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzebp extends zzebu {
    private final Context zzg;
    private final VersionInfoParcel zzh;
    private final zzebo zzi;

    public zzebp(Context context, VersionInfoParcel versionInfoParcel, zzebo zzeboVar, zzbwn zzbwnVar) {
        this.zzg = context;
        this.zzh = versionInfoParcel;
        this.zzi = zzeboVar;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnected(@Nullable Bundle bundle) {
        synchronized (this.zzb) {
            if (!this.zzd) {
                this.zzd = true;
                try {
                    this.zzf.zzp().zzi(this.zzh.afmaVersion);
                    this.zzi.zza();
                } catch (RemoteException e) {
                    this.zzi.zzb(e);
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzebu, com.google.android.gms.common.internal.BaseGmsClient.BaseOnConnectionFailedListener
    public final void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        super.onConnectionFailed(connectionResult);
        this.zzi.zzb(new RemoteException("Connection failed: ".concat(String.valueOf(connectionResult.getErrorMessage()))));
    }

    @Override // com.google.android.gms.internal.ads.zzebu, com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnectionSuspended(int i2) {
        int i8 = com.google.android.gms.ads.internal.util.zze.zza;
        com.google.android.gms.ads.internal.util.client.zzo.zzd("Cannot connect to remote service, fallback to local instance.");
        this.zzi.zzb(new RemoteException(androidx.camera.core.processing.util.a.m(new StringBuilder(String.valueOf(i2).length() + 33), "Connection suspended with cause: ", i2)));
    }

    public final void zza() {
        synchronized (this.zzb) {
            try {
                if (this.zzc) {
                    return;
                }
                this.zzc = true;
                zzbwm zzbwmVar = new zzbwm(this.zzg, com.google.android.gms.ads.internal.zzt.zzs().zza(), this, this);
                this.zzf = zzbwmVar;
                zzbwmVar.checkAvailabilityAndConnect();
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
