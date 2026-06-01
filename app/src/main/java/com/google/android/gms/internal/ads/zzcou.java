package com.google.android.gms.internal.ads;

import android.content.Context;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzcou implements zzczj {
    private final zzfhl zza;

    public zzcou(zzfhl zzfhlVar) {
        this.zza = zzfhlVar;
    }

    @Override // com.google.android.gms.internal.ads.zzczj
    public final void zza(@Nullable Context context) {
        try {
            this.zza.zzi();
        } catch (zzfgu e) {
            int i2 = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzj("Cannot invoke onPause for the mediation adapter.", e);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzczj
    public final void zzb(@Nullable Context context) {
        try {
            zzfhl zzfhlVar = this.zza;
            zzfhlVar.zzj();
            if (context != null) {
                zzfhlVar.zzp(context);
            }
        } catch (zzfgu e) {
            int i2 = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzj("Cannot invoke onResume for the mediation adapter.", e);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzczj
    public final void zzc(@Nullable Context context) {
        try {
            this.zza.zzf();
        } catch (zzfgu e) {
            int i2 = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzj("Cannot invoke onDestroy for the mediation adapter.", e);
        }
    }
}
