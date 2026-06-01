package com.google.android.gms.internal.ads;

import android.os.Bundle;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzcya implements zzifh {
    private final zzcxx zza;

    private zzcya(zzcxx zzcxxVar) {
        this.zza = zzcxxVar;
    }

    public static zzcya zzc(zzcxx zzcxxVar) {
        return new zzcya(zzcxxVar);
    }

    @Nullable
    public final Bundle zza() {
        return this.zza.zzd();
    }

    @Override // com.google.android.gms.internal.ads.zzifw, com.google.android.gms.internal.ads.zzifv
    @Nullable
    public final /* synthetic */ Object zzb() {
        return this.zza.zzd();
    }
}
