package com.google.android.gms.internal.ads;

import android.content.Context;
import androidx.annotation.Nullable;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzejj implements zzdjl {
    final /* synthetic */ zzehn zza;
    final /* synthetic */ zzffu zzb;
    final /* synthetic */ zzejk zzc;

    public zzejj(zzejk zzejkVar, zzehn zzehnVar, zzffu zzffuVar) {
        this.zza = zzehnVar;
        this.zzb = zzffuVar;
        Objects.requireNonNull(zzejkVar);
        this.zzc = zzejkVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdjl
    public final void zza(boolean z2, Context context, @Nullable zzczb zzczbVar) throws zzdjk {
        try {
            zzfhl zzfhlVar = (zzfhl) this.zza.zzb;
            zzfhlVar.zzs(z2);
            if (this.zzc.zzc().clientJarVersion < ((Integer) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzaZ)).intValue()) {
                zzfhlVar.zzd();
            } else {
                zzfhlVar.zze(context);
            }
        } catch (zzfgu e) {
            int i2 = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzh("Cannot show interstitial.");
            throw new zzdjk(e.getCause());
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdjl
    @Nullable
    public final zzffu zzb() {
        return this.zzb;
    }
}
