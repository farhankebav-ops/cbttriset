package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzgg implements zzga {
    private final Context zza;
    private final zzga zzb;

    public zzgg(Context context) {
        zzgi zzgiVar = new zzgi();
        this.zza = context.getApplicationContext();
        this.zzb = zzgiVar;
    }

    @Override // com.google.android.gms.internal.ads.zzga
    public final /* bridge */ /* synthetic */ zzgb zza() {
        return new zzgh(this.zza, this.zzb.zza());
    }
}
