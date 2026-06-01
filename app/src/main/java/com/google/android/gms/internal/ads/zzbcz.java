package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.DeadObjectException;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.BaseGmsClient;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzbcz implements BaseGmsClient.BaseConnectionCallbacks {
    final /* synthetic */ zzbdb zza;

    public zzbcz(zzbdb zzbdbVar) {
        Objects.requireNonNull(zzbdbVar);
        this.zza = zzbdbVar;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnected(@Nullable Bundle bundle) {
        zzbdb zzbdbVar = this.zza;
        synchronized (zzbdbVar.zzh()) {
            try {
            } catch (DeadObjectException e) {
                int i2 = com.google.android.gms.ads.internal.util.zze.zza;
                com.google.android.gms.ads.internal.util.client.zzo.zzg("Unable to obtain a cache service instance.", e);
                this.zza.zzg();
            }
            if (zzbdbVar.zzi() != null) {
                zzbdbVar.zzk(zzbdbVar.zzi().zzq());
                this.zza.zzh().notifyAll();
            } else {
                this.zza.zzh().notifyAll();
            }
        }
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnectionSuspended(int i2) {
        zzbdb zzbdbVar = this.zza;
        synchronized (zzbdbVar.zzh()) {
            zzbdbVar.zzk(null);
            zzbdbVar.zzh().notifyAll();
        }
    }
}
