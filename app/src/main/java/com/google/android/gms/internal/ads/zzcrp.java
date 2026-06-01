package com.google.android.gms.internal.ads;

import android.view.View;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzcrp implements zzifh {
    private final zzcrn zza;

    private zzcrp(zzcrn zzcrnVar) {
        this.zza = zzcrnVar;
    }

    public static zzcrp zzc(zzcrn zzcrnVar) {
        return new zzcrp(zzcrnVar);
    }

    public static View zzd(zzcrn zzcrnVar) {
        View viewZzb = zzcrnVar.zzb();
        zzifp.zzb(viewZzb);
        return viewZzb;
    }

    public final View zza() {
        return zzd(this.zza);
    }

    @Override // com.google.android.gms.internal.ads.zzifw, com.google.android.gms.internal.ads.zzifv
    public final /* synthetic */ Object zzb() {
        return zzd(this.zza);
    }
}
