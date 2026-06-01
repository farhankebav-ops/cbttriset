package com.google.android.gms.internal.ads;

import androidx.annotation.NonNull;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzfne implements zzguf {
    final /* synthetic */ zzflc zza;
    final /* synthetic */ zzflm zzb;
    final /* synthetic */ zzdbd zzc;
    final /* synthetic */ zzfng zzd;

    public zzfne(zzfng zzfngVar, zzflc zzflcVar, zzflm zzflmVar, zzdbd zzdbdVar) {
        this.zza = zzflcVar;
        this.zzb = zzflmVar;
        this.zzc = zzdbdVar;
        Objects.requireNonNull(zzfngVar);
        this.zzd = zzfngVar;
    }

    @Override // com.google.android.gms.internal.ads.zzguf
    public final void zza(@NonNull Throwable th) {
        zzflc zzflcVar = this.zza;
        if (zzflcVar == null) {
            return;
        }
        zzflcVar.zzd(false);
        zzflm zzflmVar = this.zzb;
        if (zzflmVar != null) {
            zzflmVar.zza(zzflcVar);
            zzflmVar.zzh();
        } else {
            zzfng zzfngVar = this.zzd;
            zzfngVar.zze().zzb(zzflcVar.zzm());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00ce  */
    @Override // com.google.android.gms.internal.ads.zzguf
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final /* bridge */ /* synthetic */ void zzb(java.lang.Object r14) {
        /*
            Method dump skipped, instruction units count: 227
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfne.zzb(java.lang.Object):void");
    }
}
