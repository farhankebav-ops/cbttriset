package com.google.android.gms.internal.ads;

import android.content.Context;
import android.util.DisplayMetrics;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzgbj implements zzifh {
    private final zzifq zza;

    private zzgbj(zzifq zzifqVar) {
        this.zza = zzifqVar;
    }

    public static zzgbj zza(zzifq zzifqVar) {
        return new zzgbj(zzifqVar);
    }

    @Override // com.google.android.gms.internal.ads.zzifw, com.google.android.gms.internal.ads.zzifv
    public final /* bridge */ /* synthetic */ Object zzb() {
        DisplayMetrics displayMetrics = ((Context) this.zza.zzb()).getResources().getDisplayMetrics();
        zzifp.zzb(displayMetrics);
        return displayMetrics;
    }
}
