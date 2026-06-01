package com.google.android.gms.internal.ads;

import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzgtu extends zzgtv {
    final /* synthetic */ zzgtw zza;
    private final Callable zzc;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzgtu(zzgtw zzgtwVar, Callable callable, Executor executor) {
        super(zzgtwVar, executor);
        Objects.requireNonNull(zzgtwVar);
        this.zza = zzgtwVar;
        this.zzc = callable;
    }

    @Override // com.google.android.gms.internal.ads.zzgup
    public final Object zza() throws Exception {
        return this.zzc.call();
    }

    @Override // com.google.android.gms.internal.ads.zzgtv
    public final void zzb(Object obj) {
        this.zza.zza(obj);
    }

    @Override // com.google.android.gms.internal.ads.zzgup
    public final String zzc() {
        return this.zzc.toString();
    }
}
