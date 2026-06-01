package com.google.android.gms.internal.ads;

import java.nio.charset.StandardCharsets;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzafe implements zzaev {
    public final String zza;

    private zzafe(String str) {
        this.zza = str;
    }

    public static zzafe zzb(zzeg zzegVar) {
        return new zzafe(zzegVar.zzK(zzegVar.zzd(), StandardCharsets.UTF_8));
    }

    @Override // com.google.android.gms.internal.ads.zzaev
    public final int zza() {
        return 1852994675;
    }
}
