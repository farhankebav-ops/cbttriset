package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Binder;
import androidx.annotation.Nullable;
import java.util.concurrent.Future;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzbdp {

    @Nullable
    private zzbde zza;
    private boolean zzb;
    private final Context zzc;
    private final Object zzd = new Object();

    public zzbdp(Context context) {
        this.zzc = context;
    }

    public final Future zza(zzbdf zzbdfVar) {
        zzbdj zzbdjVar = new zzbdj(this);
        zzbdn zzbdnVar = new zzbdn(this, zzbdfVar, zzbdjVar);
        zzbdo zzbdoVar = new zzbdo(this, zzbdjVar);
        synchronized (this.zzd) {
            zzbde zzbdeVar = new zzbde(this.zzc, com.google.android.gms.ads.internal.zzt.zzs().zza(), zzbdnVar, zzbdoVar);
            this.zza = zzbdeVar;
            zzbdeVar.checkAvailabilityAndConnect();
        }
        return zzbdjVar;
    }

    public final /* synthetic */ void zzb() {
        synchronized (this.zzd) {
            try {
                zzbde zzbdeVar = this.zza;
                if (zzbdeVar == null) {
                    return;
                }
                zzbdeVar.disconnect();
                this.zza = null;
                Binder.flushPendingCommands();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final /* synthetic */ zzbde zzc() {
        return this.zza;
    }

    public final /* synthetic */ boolean zzd() {
        return this.zzb;
    }

    public final /* synthetic */ void zze(boolean z2) {
        this.zzb = true;
    }

    public final /* synthetic */ Object zzf() {
        return this.zzd;
    }
}
