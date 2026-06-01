package com.google.android.gms.ads.internal.util;

import com.google.android.gms.internal.ads.zzcjv;
import com.google.android.gms.internal.ads.zzifh;
import com.google.android.gms.internal.ads.zzifq;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzca implements zzifh {
    private final zzifq zza;

    private zzca(zzifq zzifqVar) {
        this.zza = zzifqVar;
    }

    public static zzca zza(zzifq zzifqVar) {
        return new zzca(zzifqVar);
    }

    @Override // com.google.android.gms.internal.ads.zzifw, com.google.android.gms.internal.ads.zzifv
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzbz(((zzcjv) this.zza).zza());
    }
}
