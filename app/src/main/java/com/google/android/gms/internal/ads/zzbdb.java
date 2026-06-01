package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Binder;
import android.os.RemoteException;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.internal.BaseGmsClient;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzbdb {
    private ScheduledFuture zza = null;
    private final Runnable zzb = new zzbcx(this);
    private final Object zzc = new Object();

    @Nullable
    private zzbde zzd;

    @Nullable
    private Context zze;

    @Nullable
    private zzbdh zzf;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: zzl, reason: merged with bridge method [inline-methods] */
    public final void zzf() {
        synchronized (this.zzc) {
            try {
                if (this.zze != null && this.zzd == null) {
                    zzbde zzbdeVarZze = zze(new zzbcz(this), new zzbda(this));
                    this.zzd = zzbdeVarZze;
                    zzbdeVarZze.checkAvailabilityAndConnect();
                }
            } finally {
            }
        }
    }

    public final void zza(Context context) {
        if (context == null) {
            return;
        }
        synchronized (this.zzc) {
            try {
                if (this.zze != null) {
                    return;
                }
                this.zze = context.getApplicationContext();
                if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzeO)).booleanValue()) {
                    zzf();
                } else {
                    if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzeN)).booleanValue()) {
                        com.google.android.gms.ads.internal.zzt.zzg().zzb(new zzbcy(this));
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void zzb() {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzeP)).booleanValue()) {
            synchronized (this.zzc) {
                try {
                    zzf();
                    ScheduledFuture scheduledFuture = this.zza;
                    if (scheduledFuture != null) {
                        scheduledFuture.cancel(false);
                    }
                    this.zza = zzcbv.zzd.schedule(this.zzb, ((Long) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzeQ)).longValue(), TimeUnit.MILLISECONDS);
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public final zzbdc zzc(zzbdf zzbdfVar) {
        synchronized (this.zzc) {
            if (this.zzf == null) {
                return new zzbdc();
            }
            try {
                if (this.zzd.zzp()) {
                    return this.zzf.zzf(zzbdfVar);
                }
                return this.zzf.zze(zzbdfVar);
            } catch (RemoteException e) {
                int i2 = com.google.android.gms.ads.internal.util.zze.zza;
                com.google.android.gms.ads.internal.util.client.zzo.zzg("Unable to call into cache service.", e);
                return new zzbdc();
            }
        }
    }

    public final long zzd(zzbdf zzbdfVar) {
        synchronized (this.zzc) {
            try {
                if (this.zzf == null) {
                    return -2L;
                }
                if (this.zzd.zzp()) {
                    try {
                        return this.zzf.zzg(zzbdfVar);
                    } catch (RemoteException e) {
                        int i2 = com.google.android.gms.ads.internal.util.zze.zza;
                        com.google.android.gms.ads.internal.util.client.zzo.zzg("Unable to call into cache service.", e);
                    }
                }
                return -2L;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @VisibleForTesting
    public final synchronized zzbde zze(BaseGmsClient.BaseConnectionCallbacks baseConnectionCallbacks, BaseGmsClient.BaseOnConnectionFailedListener baseOnConnectionFailedListener) {
        return new zzbde(this.zze, com.google.android.gms.ads.internal.zzt.zzs().zza(), baseConnectionCallbacks, baseOnConnectionFailedListener);
    }

    public final /* synthetic */ void zzg() {
        synchronized (this.zzc) {
            try {
                zzbde zzbdeVar = this.zzd;
                if (zzbdeVar == null) {
                    return;
                }
                if (zzbdeVar.isConnected() || this.zzd.isConnecting()) {
                    this.zzd.disconnect();
                }
                this.zzd = null;
                this.zzf = null;
                Binder.flushPendingCommands();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final /* synthetic */ Object zzh() {
        return this.zzc;
    }

    public final /* synthetic */ zzbde zzi() {
        return this.zzd;
    }

    public final /* synthetic */ void zzj(zzbde zzbdeVar) {
        this.zzd = null;
    }

    public final /* synthetic */ void zzk(zzbdh zzbdhVar) {
        this.zzf = zzbdhVar;
    }
}
