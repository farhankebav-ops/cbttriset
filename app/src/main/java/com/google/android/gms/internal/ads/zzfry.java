package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.HandlerThread;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
@VisibleForTesting
final class zzfry implements BaseGmsClient.BaseConnectionCallbacks, BaseGmsClient.BaseOnConnectionFailedListener {

    @VisibleForTesting
    protected final zzfsu zza;
    private final String zzb;
    private final String zzc;
    private final LinkedBlockingQueue zzd;
    private final HandlerThread zze;

    public zzfry(Context context, String str, String str2) {
        this.zzb = str;
        this.zzc = str2;
        HandlerThread handlerThread = new HandlerThread("GassClient");
        this.zze = handlerThread;
        handlerThread.start();
        zzfsu zzfsuVar = new zzfsu(context, handlerThread.getLooper(), this, this, 9200000);
        this.zza = zzfsuVar;
        this.zzd = new LinkedBlockingQueue();
        zzfsuVar.checkAvailabilityAndConnect();
    }

    @VisibleForTesting
    public static zzauz zzc() {
        zzauc zzaucVarZzj = zzauz.zzj();
        zzaucVarZzj.zzl(32768L);
        return (zzauz) zzaucVarZzj.zzbu();
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnected(Bundle bundle) {
        zzfsz zzfszVarZzd = zzd();
        if (zzfszVarZzd != null) {
            try {
                try {
                    this.zzd.put(zzfszVarZzd.zze(new zzfsv(this.zzb, this.zzc)).zza());
                } catch (InterruptedException unused) {
                } catch (Throwable th) {
                    zzb();
                    this.zze.quit();
                    throw th;
                }
            } catch (Throwable unused2) {
                this.zzd.put(zzc());
            }
            zzb();
            this.zze.quit();
        }
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseOnConnectionFailedListener
    public final void onConnectionFailed(ConnectionResult connectionResult) {
        try {
            this.zzd.put(zzc());
        } catch (InterruptedException unused) {
        }
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnectionSuspended(int i2) {
        try {
            this.zzd.put(zzc());
        } catch (InterruptedException unused) {
        }
    }

    public final zzauz zza(int i2) {
        zzauz zzauzVar;
        try {
            zzauzVar = (zzauz) this.zzd.poll(5000L, TimeUnit.MILLISECONDS);
        } catch (InterruptedException unused) {
            zzauzVar = null;
        }
        return zzauzVar == null ? zzc() : zzauzVar;
    }

    public final void zzb() {
        zzfsu zzfsuVar = this.zza;
        if (zzfsuVar != null) {
            if (zzfsuVar.isConnected() || zzfsuVar.isConnecting()) {
                zzfsuVar.disconnect();
            }
        }
    }

    public final zzfsz zzd() {
        try {
            return this.zza.zzp();
        } catch (DeadObjectException | IllegalStateException unused) {
            return null;
        }
    }
}
