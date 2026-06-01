package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzgad implements zzgtq {
    final /* synthetic */ zzgai zza;

    public zzgad(zzgai zzgaiVar) {
        Objects.requireNonNull(zzgaiVar);
        this.zza = zzgaiVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgtq
    public final /* bridge */ /* synthetic */ j2.q zza(Object obj) throws Exception {
        zzgab zzgabVar = (zzgab) obj;
        if (zzgabVar != null) {
            return zzgui.zza(zzgabVar);
        }
        zzgai zzgaiVar = this.zza;
        zzgaiVar.zza().zzb(51);
        return zzgaiVar.zzd(2);
    }
}
