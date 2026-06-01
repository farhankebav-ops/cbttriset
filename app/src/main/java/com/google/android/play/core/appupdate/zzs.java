package com.google.android.play.core.appupdate;

import com.google.android.play.core.appupdate.internal.zzaf;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzs implements zzaf {
    private final zzaf zza;
    private final zzaf zzb;

    public zzs(zzaf zzafVar, zzaf zzafVar2) {
        this.zza = zzafVar;
        this.zzb = zzafVar2;
    }

    @Override // com.google.android.play.core.appupdate.internal.zzaf
    public final /* bridge */ /* synthetic */ Object zza() {
        return new zzr(((zzk) this.zza).zzb(), (zzt) this.zzb.zza());
    }
}
