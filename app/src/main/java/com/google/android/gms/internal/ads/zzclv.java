package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzclv implements zzeda {
    private final zzckz zza;
    private Context zzb;

    public /* synthetic */ zzclv(zzckz zzckzVar, byte[] bArr) {
        this.zza = zzckzVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeda
    public final zzedb zza() {
        zzifp.zzc(this.zzb, Context.class);
        return new zzclw(this.zza, this.zzb);
    }

    @Override // com.google.android.gms.internal.ads.zzeda
    public final /* bridge */ /* synthetic */ zzeda zzb(Context context) {
        this.zzb = context;
        return this;
    }
}
