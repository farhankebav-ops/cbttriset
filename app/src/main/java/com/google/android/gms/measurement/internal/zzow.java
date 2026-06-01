package com.google.android.gms.measurement.internal;

import java.util.List;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzow implements zzgw {
    final /* synthetic */ String zza;
    final /* synthetic */ List zzb;
    final /* synthetic */ zzpg zzc;

    public zzow(zzpg zzpgVar, String str, List list) {
        this.zza = str;
        this.zzb = list;
        Objects.requireNonNull(zzpgVar);
        this.zzc = zzpgVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzgw
    public final void zza(String str, int i2, Throwable th, byte[] bArr, Map map) {
        this.zzc.zzV(true, i2, th, bArr, this.zza, this.zzb);
    }
}
