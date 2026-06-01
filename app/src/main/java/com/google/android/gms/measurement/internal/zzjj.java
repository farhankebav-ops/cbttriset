package com.google.android.gms.measurement.internal;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public enum zzjj {
    STORAGE(zzjk.AD_STORAGE, zzjk.ANALYTICS_STORAGE),
    DMA(zzjk.AD_USER_DATA);

    private final zzjk[] zzc;

    zzjj(zzjk... zzjkVarArr) {
        this.zzc = zzjkVarArr;
    }

    public final zzjk[] zza() {
        return this.zzc;
    }

    public final /* synthetic */ zzjk[] zzb() {
        return this.zzc;
    }
}
