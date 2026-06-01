package com.google.android.gms.internal.ads;

import android.view.View;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzdif implements zzifh {
    private final zzdia zza;

    private zzdif(zzdia zzdiaVar) {
        this.zza = zzdiaVar;
    }

    public static zzdif zzc(zzdia zzdiaVar) {
        return new zzdif(zzdiaVar);
    }

    @Nullable
    public final View zza() {
        return this.zza.zzd();
    }

    @Override // com.google.android.gms.internal.ads.zzifw, com.google.android.gms.internal.ads.zzifv
    @Nullable
    public final /* synthetic */ Object zzb() {
        return this.zza.zzd();
    }
}
