package com.google.android.gms.internal.ads;

import androidx.annotation.NonNull;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzbda implements BaseGmsClient.BaseOnConnectionFailedListener {
    final /* synthetic */ zzbdb zza;

    public zzbda(zzbdb zzbdbVar) {
        Objects.requireNonNull(zzbdbVar);
        this.zza = zzbdbVar;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseOnConnectionFailedListener
    public final void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        zzbdb zzbdbVar = this.zza;
        synchronized (zzbdbVar.zzh()) {
            try {
                zzbdbVar.zzk(null);
                if (zzbdbVar.zzi() != null) {
                    zzbdbVar.zzj(null);
                }
                zzbdbVar.zzh().notifyAll();
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
