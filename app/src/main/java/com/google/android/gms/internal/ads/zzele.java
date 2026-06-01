package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import com.google.android.gms.common.util.Clock;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzele {

    @Nullable
    private zzekv zza;

    public zzele() {
    }

    public static zzele zza(zzekv zzekvVar) {
        return new zzele(zzekvVar);
    }

    public final zzekv zzb(Clock clock, zzekx zzekxVar, zzehp zzehpVar, zzfng zzfngVar) {
        zzekv zzekvVar = this.zza;
        return zzekvVar != null ? zzekvVar : new zzekv(clock, zzekxVar, zzehpVar, zzfngVar);
    }

    private zzele(zzekv zzekvVar) {
        this.zza = zzekvVar;
    }
}
