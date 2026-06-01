package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzgqr extends zzgqq {
    final /* synthetic */ zzgqs zza;

    public zzgqr(zzgqs zzgqsVar, int i2) {
        Objects.requireNonNull(zzgqsVar);
        this.zza = zzgqsVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgqq
    public final zzgpz zza() {
        return new zzgqu(this.zza.zza(), new zzgqp(2));
    }
}
