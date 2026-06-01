package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzaff implements zzada {
    private final zzeg zza = new zzeg(4);
    private final zzaef zzb = new zzaef(-1, -1, "image/avif");

    private final boolean zzg(zzadb zzadbVar, int i2) throws IOException {
        zzeg zzegVar = this.zza;
        zzegVar.zza(4);
        ((zzacr) zzadbVar).zzh(zzegVar.zzi(), 0, 4, false);
        return zzegVar.zzz() == ((long) i2);
    }

    @Override // com.google.android.gms.internal.ads.zzada
    public final boolean zza(zzadb zzadbVar) throws IOException {
        ((zzacr) zzadbVar).zzj(4, false);
        return zzg(zzadbVar, 1718909296) && zzg(zzadbVar, 1635150182);
    }

    @Override // com.google.android.gms.internal.ads.zzada
    public final /* synthetic */ List zzb() {
        return d.a(this);
    }

    @Override // com.google.android.gms.internal.ads.zzada
    public final void zzc(zzadd zzaddVar) {
        this.zzb.zzc(zzaddVar);
    }

    @Override // com.google.android.gms.internal.ads.zzada
    public final int zzd(zzadb zzadbVar, zzaea zzaeaVar) throws IOException {
        return this.zzb.zzd(zzadbVar, zzaeaVar);
    }

    @Override // com.google.android.gms.internal.ads.zzada
    public final void zze(long j, long j3) {
        this.zzb.zze(j, j3);
    }

    @Override // com.google.android.gms.internal.ads.zzada
    public final /* synthetic */ zzada zzf() {
        return d.b(this);
    }
}
