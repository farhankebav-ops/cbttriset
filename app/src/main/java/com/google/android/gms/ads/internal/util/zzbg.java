package com.google.android.gms.ads.internal.util;

import com.google.android.gms.internal.ads.zzapy;
import com.google.android.gms.internal.ads.zzaqd;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
final class zzbg implements zzapy {
    final /* synthetic */ String zza;
    final /* synthetic */ zzbi zzb;

    public zzbg(zzbl zzblVar, String str, zzbi zzbiVar) {
        this.zza = str;
        this.zzb = zzbiVar;
        Objects.requireNonNull(zzblVar);
    }

    @Override // com.google.android.gms.internal.ads.zzapy
    public final void zza(zzaqd zzaqdVar) {
        String str = this.zza;
        String string = zzaqdVar.toString();
        String strN = androidx.camera.core.processing.util.a.n(new StringBuilder(String.valueOf(str).length() + 21 + String.valueOf(string).length()), "Failed to load URL: ", str, "\n", string);
        int i2 = zze.zza;
        com.google.android.gms.ads.internal.util.client.zzo.zzi(strN);
        this.zzb.zza((Object) null);
    }
}
