package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.BaseGmsClient;
import java.io.IOException;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzbdn implements BaseGmsClient.BaseConnectionCallbacks {
    public static final /* synthetic */ int zzd = 0;
    final /* synthetic */ zzbdf zza;
    final /* synthetic */ zzcca zzb;
    final /* synthetic */ zzbdp zzc;

    public zzbdn(zzbdp zzbdpVar, zzbdf zzbdfVar, zzcca zzccaVar) {
        this.zza = zzbdfVar;
        this.zzb = zzccaVar;
        Objects.requireNonNull(zzbdpVar);
        this.zzc = zzbdpVar;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnected(@Nullable Bundle bundle) {
        zzbdp zzbdpVar = this.zzc;
        synchronized (zzbdpVar.zzf()) {
            try {
                if (zzbdpVar.zzd()) {
                    return;
                }
                zzbdpVar.zze(true);
                final zzbde zzbdeVarZzc = zzbdpVar.zzc();
                if (zzbdeVarZzc == null) {
                    return;
                }
                zzgus zzgusVar = zzcbv.zza;
                final zzbdf zzbdfVar = this.zza;
                final zzcca zzccaVar = this.zzb;
                final j2.q qVarZza = zzgusVar.zza(new Runnable() { // from class: com.google.android.gms.internal.ads.zzbdm
                    @Override // java.lang.Runnable
                    public final /* synthetic */ void run() {
                        zzcca zzccaVar2 = zzccaVar;
                        zzbde zzbdeVar = zzbdeVarZzc;
                        zzbdn zzbdnVar = this.zza;
                        try {
                            zzbdh zzbdhVarZzq = zzbdeVar.zzq();
                            boolean zZzp = zzbdeVar.zzp();
                            zzbdf zzbdfVar2 = zzbdfVar;
                            zzbdc zzbdcVarZzf = zZzp ? zzbdhVarZzq.zzf(zzbdfVar2) : zzbdhVarZzq.zze(zzbdfVar2);
                            if (!zzbdcVarZzf.zza()) {
                                zzccaVar2.zzd(new RuntimeException("No entry contents."));
                                zzbdnVar.zzc.zzb();
                                return;
                            }
                            zzbdk zzbdkVar = new zzbdk(zzbdnVar, zzbdcVarZzf.zzb(), 1);
                            int i2 = zzbdkVar.read();
                            if (i2 == -1) {
                                throw new IOException("Unable to read from cache.");
                            }
                            zzbdkVar.unread(i2);
                            zzccaVar2.zzc(zzbdr.zza(zzbdkVar, zzbdcVarZzf.zzd(), zzbdcVarZzf.zzg(), zzbdcVarZzf.zzf(), zzbdcVarZzf.zze()));
                        } catch (RemoteException e) {
                            e = e;
                            int i8 = com.google.android.gms.ads.internal.util.zze.zza;
                            com.google.android.gms.ads.internal.util.client.zzo.zzg("Unable to obtain a cache service instance.", e);
                            zzccaVar2.zzd(e);
                            zzbdnVar.zzc.zzb();
                        } catch (IOException e4) {
                            e = e4;
                            int i82 = com.google.android.gms.ads.internal.util.zze.zza;
                            com.google.android.gms.ads.internal.util.client.zzo.zzg("Unable to obtain a cache service instance.", e);
                            zzccaVar2.zzd(e);
                            zzbdnVar.zzc.zzb();
                        }
                    }
                });
                zzccaVar.addListener(new Runnable() { // from class: com.google.android.gms.internal.ads.zzbdl
                    @Override // java.lang.Runnable
                    public final /* synthetic */ void run() {
                        if (zzccaVar.isCancelled()) {
                            qVarZza.cancel(true);
                        }
                    }
                }, zzcbv.zzg);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnectionSuspended(int i2) {
    }
}
