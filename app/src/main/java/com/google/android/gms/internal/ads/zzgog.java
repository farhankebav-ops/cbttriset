package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzgog extends zzgoj {
    final /* synthetic */ zzgon zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzgog(zzgon zzgonVar) {
        super(zzgonVar, null);
        Objects.requireNonNull(zzgonVar);
        this.zza = zzgonVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgoj
    public final /* bridge */ /* synthetic */ Object zza(int i2) {
        return new zzgol(this.zza, i2);
    }
}
