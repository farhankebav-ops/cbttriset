package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzbut extends zzbjl {
    final /* synthetic */ zzbuv zza;

    public /* synthetic */ zzbut(zzbuv zzbuvVar, byte[] bArr) {
        Objects.requireNonNull(zzbuvVar);
        this.zza = zzbuvVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbjm
    public final void zze(zzbjc zzbjcVar, String str) {
        zzbuv zzbuvVar = this.zza;
        if (zzbuvVar.zze() == null) {
            return;
        }
        zzbuvVar.zze().onCustomClick(zzbuvVar.zzc(zzbjcVar), str);
    }
}
