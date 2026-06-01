package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzexs implements zzeya {
    private final boolean zza;

    public zzexs(@Nullable zzfdq zzfdqVar) {
        this.zza = zzfdqVar != null;
    }

    @Override // com.google.android.gms.internal.ads.zzeya
    public final j2.q zza() {
        return zzgui.zza(new zzexr(this.zza, null));
    }

    @Override // com.google.android.gms.internal.ads.zzeya
    public final int zzb() {
        return 36;
    }
}
