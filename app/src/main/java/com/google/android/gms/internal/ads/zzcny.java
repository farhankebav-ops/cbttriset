package com.google.android.gms.internal.ads;

import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzcny implements zzcnu {
    private final com.google.android.gms.ads.internal.util.zzg zza;

    public zzcny(com.google.android.gms.ads.internal.util.zzg zzgVar) {
        this.zza = zzgVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcnu
    public final void zza(Map map) {
        this.zza.zzd(Boolean.parseBoolean((String) map.get("content_vertical_opted_out")));
    }
}
