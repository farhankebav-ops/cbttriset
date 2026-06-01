package com.google.android.gms.internal.ads;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzgqu extends zzgnf {
    final transient zzgmv zza;

    public zzgqu(Map map, zzgmv zzgmvVar) {
        super(map);
        this.zza = zzgmvVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgnf, com.google.android.gms.internal.ads.zzgnw
    public final /* bridge */ /* synthetic */ Collection zzc() {
        return (List) this.zza.zza();
    }

    @Override // com.google.android.gms.internal.ads.zzgnw, com.google.android.gms.internal.ads.zzgnz
    public final Set zzh() {
        return zzi();
    }

    @Override // com.google.android.gms.internal.ads.zzgnw, com.google.android.gms.internal.ads.zzgnz
    public final Map zzl() {
        return zzm();
    }
}
