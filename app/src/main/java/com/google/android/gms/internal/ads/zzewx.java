package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzewx implements zzeya {
    private final String zza;
    private final int zzb;

    public zzewx(String str, int i2) {
        this.zza = str;
        this.zzb = i2;
    }

    @Override // com.google.android.gms.internal.ads.zzeya
    public final j2.q zza() {
        return zzgui.zza(new zzewy(this.zza, this.zzb));
    }

    @Override // com.google.android.gms.internal.ads.zzeya
    public final int zzb() {
        return 31;
    }
}
