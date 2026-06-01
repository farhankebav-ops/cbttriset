package com.google.android.gms.measurement.internal;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzmm extends zzay {
    final /* synthetic */ zznl zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzmm(zznl zznlVar, zzjg zzjgVar) {
        super(zzjgVar);
        Objects.requireNonNull(zznlVar);
        this.zza = zznlVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzay
    public final void zza() {
        zznl zznlVar = this.zza;
        zznlVar.zzg();
        if (zznlVar.zzh()) {
            zznlVar.zzu.zzaV().zzk().zza("Inactivity, disconnecting from the service");
            zznlVar.zzM();
        }
    }
}
