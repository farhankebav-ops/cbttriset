package com.google.android.gms.ads.nonagon.signalgeneration;

import androidx.annotation.Nullable;
import com.google.android.gms.internal.ads.zzifh;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzbc implements zzifh {
    private final zzay zza;

    private zzbc(zzay zzayVar) {
        this.zza = zzayVar;
    }

    public static zzbc zza(zzay zzayVar) {
        return new zzbc(zzayVar);
    }

    @Override // com.google.android.gms.internal.ads.zzifw, com.google.android.gms.internal.ads.zzifv
    @Nullable
    public final /* synthetic */ Object zzb() {
        return this.zza.zzd();
    }
}
