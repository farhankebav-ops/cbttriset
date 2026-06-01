package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzepy implements zzeya {
    private final Clock zza;
    private final zzfgn zzb;

    public zzepy(Clock clock, zzfgn zzfgnVar) {
        this.zza = clock;
        this.zzb = zzfgnVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeya
    public final j2.q zza() {
        return zzgui.zza(new zzepz(this.zzb, this.zza.currentTimeMillis()));
    }

    @Override // com.google.android.gms.internal.ads.zzeya
    public final int zzb() {
        return 4;
    }
}
