package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzfye implements zzifq {
    final /* synthetic */ zzfyf zza;

    public zzfye(zzfyf zzfyfVar) {
        Objects.requireNonNull(zzfyfVar);
        this.zza = zzfyfVar;
    }

    @Override // com.google.android.gms.internal.ads.zzifw, com.google.android.gms.internal.ads.zzifv
    public final /* bridge */ /* synthetic */ Object zzb() {
        zzfyf zzfyfVar = this.zza;
        return new zzfyi(zzfyfVar.zzb(), zzfyfVar.zzc(), null);
    }
}
