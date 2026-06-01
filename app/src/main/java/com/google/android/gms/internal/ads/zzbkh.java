package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzbkh extends zzbjo {
    final /* synthetic */ zzbki zza;

    public /* synthetic */ zzbkh(zzbki zzbkiVar, byte[] bArr) {
        Objects.requireNonNull(zzbkiVar);
        this.zza = zzbkiVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbjp
    public final void zze(zzbjc zzbjcVar) {
        zzbki zzbkiVar = this.zza;
        zzbkiVar.zzc().zzb(zzbkiVar.zze(zzbjcVar));
    }
}
