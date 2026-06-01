package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzcld implements zzfax {
    private final zzckz zza;
    private Context zzb;
    private String zzc;

    public /* synthetic */ zzcld(zzckz zzckzVar, byte[] bArr) {
        this.zza = zzckzVar;
    }

    @Override // com.google.android.gms.internal.ads.zzfax
    public final zzfay zza() {
        zzifp.zzc(this.zzb, Context.class);
        zzifp.zzc(this.zzc, String.class);
        return new zzcle(this.zza, this.zzb, this.zzc);
    }

    @Override // com.google.android.gms.internal.ads.zzfax
    public final /* bridge */ /* synthetic */ zzfax zzb(String str) {
        str.getClass();
        this.zzc = str;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzfax
    public final /* bridge */ /* synthetic */ zzfax zzc(Context context) {
        context.getClass();
        this.zzb = context;
        return this;
    }
}
