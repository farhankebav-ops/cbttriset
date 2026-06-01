package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzrk implements zzqe {
    final /* synthetic */ zzrl zza;

    public /* synthetic */ zzrk(zzrl zzrlVar, byte[] bArr) {
        Objects.requireNonNull(zzrlVar);
        this.zza = zzrlVar;
    }

    @Override // com.google.android.gms.internal.ads.zzqe
    public final void zza() {
        zzlm zzlmVarZzaY = this.zza.zzaY();
        if (zzlmVarZzaY != null) {
            zzlmVarZzaY.zza();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzqe
    public final void zzb(Exception exc) {
        zzdt.zzf("MediaCodecAudioRenderer", "Audio sink error", exc);
        this.zza.zzaw().zzi(exc);
    }

    @Override // com.google.android.gms.internal.ads.zzqe
    public final void zzc(zzqb zzqbVar) {
        this.zza.zzaw().zzl(zzqbVar);
    }
}
