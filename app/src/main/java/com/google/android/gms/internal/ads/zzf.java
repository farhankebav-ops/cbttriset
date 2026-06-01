package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class zzf implements zzbb {
    protected final zzbe zza = new zzbe();

    @Override // com.google.android.gms.internal.ads.zzbb
    public final boolean zza() {
        return zzh() == 3 && zzk() && zzi() == 0;
    }

    @Override // com.google.android.gms.internal.ads.zzbb
    public final void zzb(long j) {
        zzc(zzs(), j, 5, false);
    }

    public abstract void zzc(int i2, long j, int i8, boolean z2);
}
