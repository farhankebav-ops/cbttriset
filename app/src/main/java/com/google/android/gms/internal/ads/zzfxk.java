package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzfxk implements zzgtq {
    final /* synthetic */ Context zza;
    final /* synthetic */ zzfxn zzb;

    public zzfxk(zzfxn zzfxnVar, Context context) {
        this.zza = context;
        Objects.requireNonNull(zzfxnVar);
        this.zzb = zzfxnVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgtq
    public final /* bridge */ /* synthetic */ j2.q zza(Object obj) throws Exception {
        return this.zzb.zzg().zzb(this.zza);
    }
}
