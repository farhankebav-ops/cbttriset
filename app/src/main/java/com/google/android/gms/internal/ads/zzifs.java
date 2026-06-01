package com.google.android.gms.internal.ads;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzifs {
    private final List zza;
    private final List zzb;

    public /* synthetic */ zzifs(int i2, int i8, zzifr zzifrVar) {
        this.zza = zzife.zza(i2);
        this.zzb = zzife.zza(i8);
    }

    public final zzifs zza(zzifq zzifqVar) {
        this.zza.add(zzifqVar);
        return this;
    }

    public final zzifs zzb(zzifq zzifqVar) {
        this.zzb.add(zzifqVar);
        return this;
    }

    public final zzift zzc() {
        return new zzift(this.zza, this.zzb, null);
    }
}
