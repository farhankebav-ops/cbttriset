package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzalx implements Comparable {
    public final int zza;
    public final zzals zzb;

    public zzalx(int i2, zzals zzalsVar) {
        this.zza = i2;
        this.zzb = zzalsVar;
    }

    @Override // java.lang.Comparable
    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        return Integer.compare(this.zza, ((zzalx) obj).zza);
    }
}
