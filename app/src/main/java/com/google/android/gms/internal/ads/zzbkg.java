package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzbkg extends zzbjl {
    final /* synthetic */ zzbki zza;

    public /* synthetic */ zzbkg(zzbki zzbkiVar, byte[] bArr) {
        Objects.requireNonNull(zzbkiVar);
        this.zza = zzbkiVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbjm
    public final void zze(zzbjc zzbjcVar, String str) {
        zzbki zzbkiVar = this.zza;
        if (zzbkiVar.zzd() == null) {
            return;
        }
        zzbkiVar.zzd().zzc(zzbkiVar.zze(zzbjcVar), str);
    }
}
