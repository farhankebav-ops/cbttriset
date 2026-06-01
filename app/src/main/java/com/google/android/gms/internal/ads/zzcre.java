package com.google.android.gms.internal.ads;

import android.view.ViewGroup;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzcre implements zzifh {
    private final zzcrd zza;

    private zzcre(zzcrd zzcrdVar) {
        this.zza = zzcrdVar;
    }

    public static zzcre zzc(zzcrd zzcrdVar) {
        return new zzcre(zzcrdVar);
    }

    @Nullable
    public final ViewGroup zza() {
        return this.zza.zza();
    }

    @Override // com.google.android.gms.internal.ads.zzifw, com.google.android.gms.internal.ads.zzifv
    @Nullable
    public final /* synthetic */ Object zzb() {
        return this.zza.zza();
    }
}
