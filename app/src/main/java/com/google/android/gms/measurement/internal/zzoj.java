package com.google.android.gms.measurement.internal;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzoj extends zzay {
    final /* synthetic */ zzok zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzoj(zzok zzokVar, zzjg zzjgVar) {
        super(zzjgVar);
        Objects.requireNonNull(zzokVar);
        this.zza = zzokVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzay
    public final void zza() {
        zzok zzokVar = this.zza;
        zzokVar.zzd();
        zzokVar.zzu.zzaV().zzk().zza("Starting upload from DelayedRunnable");
        zzokVar.zzg.zzM();
    }
}
