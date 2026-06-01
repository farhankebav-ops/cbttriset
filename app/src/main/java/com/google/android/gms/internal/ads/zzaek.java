package com.google.android.gms.internal.ads;

import androidx.annotation.RestrictTo;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class zzaek implements zzadd {
    private final long zzb;
    private final zzadd zzc;

    public zzaek(long j, zzadd zzaddVar) {
        this.zzb = j;
        this.zzc = zzaddVar;
    }

    public final /* synthetic */ long zza() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzadd
    public final zzaem zzu(int i2, int i8) {
        return this.zzc.zzu(i2, i8);
    }

    @Override // com.google.android.gms.internal.ads.zzadd
    public final void zzv() {
        this.zzc.zzv();
    }

    @Override // com.google.android.gms.internal.ads.zzadd
    public final void zzw(zzaed zzaedVar) {
        this.zzc.zzw(new zzaej(this, zzaedVar, zzaedVar));
    }
}
