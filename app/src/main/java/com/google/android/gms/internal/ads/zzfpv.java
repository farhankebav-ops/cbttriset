package com.google.android.gms.internal.ads;

import android.view.View;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzfpv {
    private final zzfrj zza;
    private final String zzb;
    private final zzfpb zzc;
    private final String zzd = "Ad overlay";

    public zzfpv(View view, zzfpb zzfpbVar, @Nullable String str) {
        this.zza = new zzfrj(view);
        this.zzb = view.getClass().getCanonicalName();
        this.zzc = zzfpbVar;
    }

    public final zzfrj zza() {
        return this.zza;
    }

    public final String zzb() {
        return this.zzb;
    }

    public final zzfpb zzc() {
        return this.zzc;
    }

    public final String zzd() {
        return this.zzd;
    }
}
