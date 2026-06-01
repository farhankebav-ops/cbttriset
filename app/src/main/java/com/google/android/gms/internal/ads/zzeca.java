package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.ConnectionResult;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzeca extends zzebu {
    private String zzg;
    private int zzh = 1;

    public zzeca(Context context) {
        this.zzf = new zzbwm(context, com.google.android.gms.ads.internal.zzt.zzs().zza(), this, this);
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnected(@Nullable Bundle bundle) {
        synchronized (this.zzb) {
            try {
                if (!this.zzd) {
                    this.zzd = true;
                    try {
                        int i2 = this.zzh;
                        if (i2 == 2) {
                            this.zzf.zzp().zzg(this.zze, ((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zznX)).booleanValue() ? new zzebt(this.zza, this.zze) : new zzebs(this));
                        } else if (i2 == 3) {
                            this.zzf.zzp().zzh(this.zzg, ((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zznX)).booleanValue() ? new zzebt(this.zza, this.zze) : new zzebs(this));
                        } else {
                            this.zza.zzd(new zzecj(1));
                        }
                    } catch (RemoteException | IllegalArgumentException unused) {
                        this.zza.zzd(new zzecj(1));
                    } catch (Throwable th) {
                        com.google.android.gms.ads.internal.zzt.zzh().zzg(th, "RemoteUrlAndCacheKeyClientTask.onConnected");
                        this.zza.zzd(new zzecj(1));
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzebu, com.google.android.gms.common.internal.BaseGmsClient.BaseOnConnectionFailedListener
    public final void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        int i2 = com.google.android.gms.ads.internal.util.zze.zza;
        com.google.android.gms.ads.internal.util.client.zzo.zzd("Cannot connect to remote service, fallback to local instance.");
        this.zza.zzd(new zzecj(1));
    }

    public final j2.q zza(zzbxj zzbxjVar) {
        synchronized (this.zzb) {
            try {
                int i2 = this.zzh;
                if (i2 != 1 && i2 != 2) {
                    return zzgui.zzc(new zzecj(2));
                }
                if (this.zzc) {
                    return this.zza;
                }
                this.zzh = 2;
                this.zzc = true;
                this.zze = zzbxjVar;
                this.zzf.checkAvailabilityAndConnect();
                zzcca zzccaVar = this.zza;
                zzccaVar.addListener(new Runnable() { // from class: com.google.android.gms.internal.ads.zzebz
                    @Override // java.lang.Runnable
                    public final /* synthetic */ void run() {
                        this.zza.zzb();
                    }
                }, zzcbv.zzg);
                return zzccaVar;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final j2.q zzd(String str) {
        synchronized (this.zzb) {
            try {
                int i2 = this.zzh;
                if (i2 != 1 && i2 != 3) {
                    return zzgui.zzc(new zzecj(2));
                }
                if (this.zzc) {
                    return this.zza;
                }
                this.zzh = 3;
                this.zzc = true;
                this.zzg = str;
                this.zzf.checkAvailabilityAndConnect();
                zzcca zzccaVar = this.zza;
                zzccaVar.addListener(new Runnable() { // from class: com.google.android.gms.internal.ads.zzeby
                    @Override // java.lang.Runnable
                    public final /* synthetic */ void run() {
                        this.zza.zzb();
                    }
                }, zzcbv.zzg);
                return zzccaVar;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
