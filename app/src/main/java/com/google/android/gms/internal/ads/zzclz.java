package com.google.android.gms.internal.ads;

import android.content.Context;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzclz implements zzffn {
    private final zzckz zza;
    private Context zzb;
    private String zzc;

    public /* synthetic */ zzclz(zzckz zzckzVar, byte[] bArr) {
        this.zza = zzckzVar;
    }

    @Override // com.google.android.gms.internal.ads.zzffn
    public final zzffo zza() {
        zzifp.zzc(this.zzb, Context.class);
        return new zzcma(this.zza, this.zzb, this.zzc);
    }

    @Override // com.google.android.gms.internal.ads.zzffn
    public final /* synthetic */ zzffn zzb(@Nullable String str) {
        this.zzc = str;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzffn
    public final /* bridge */ /* synthetic */ zzffn zzc(Context context) {
        context.getClass();
        this.zzb = context;
        return this;
    }
}
