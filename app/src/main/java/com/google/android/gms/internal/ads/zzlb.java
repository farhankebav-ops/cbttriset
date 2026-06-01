package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzlb implements zzkt {
    public final zzup zza;
    public int zzd;
    public boolean zze;
    public final List zzc = new ArrayList();
    public final Object zzb = new Object();

    public zzlb(zzuw zzuwVar, boolean z2) {
        this.zza = new zzup(zzuwVar, z2);
    }

    @Override // com.google.android.gms.internal.ads.zzkt
    public final Object zza() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzkt
    public final zzbf zzb() {
        return this.zza.zzz();
    }

    public final void zzc(int i2) {
        this.zzd = i2;
        this.zze = false;
        this.zzc.clear();
    }
}
