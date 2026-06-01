package com.google.android.gms.internal.ads;

import android.content.Context;
import androidx.annotation.Nullable;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzemb implements zzdjl {
    final /* synthetic */ zzehn zza;
    final /* synthetic */ zzffu zzb;

    public zzemb(zzemd zzemdVar, zzehn zzehnVar, zzffu zzffuVar) {
        this.zza = zzehnVar;
        this.zzb = zzffuVar;
        Objects.requireNonNull(zzemdVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdjl
    public final void zza(boolean z2, Context context, @Nullable zzczb zzczbVar) throws zzdjk {
        try {
            zzfhl zzfhlVar = (zzfhl) this.zza.zzb;
            zzfhlVar.zzs(z2);
            zzfhlVar.zzm();
        } catch (zzfgu e) {
            int i2 = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzj("Cannot show rewarded video.", e);
            throw new zzdjk(e.getCause());
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdjl
    @Nullable
    public final zzffu zzb() {
        return this.zzb;
    }
}
