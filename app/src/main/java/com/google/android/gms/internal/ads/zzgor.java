package com.google.android.gms.internal.ads;

import java.util.Comparator;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzgor extends zzgot {
    public zzgor() {
        super(null);
    }

    public static final zzgot zzf(int i2) {
        return i2 < 0 ? zzgot.zzb : i2 > 0 ? zzgot.zzc : zzgot.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzgot
    public final zzgot zza(Object obj, Object obj2, Comparator comparator) {
        return zzf(comparator.compare(obj, obj2));
    }

    @Override // com.google.android.gms.internal.ads.zzgot
    public final zzgot zzb(int i2, int i8) {
        return zzf(Integer.compare(i2, i8));
    }

    @Override // com.google.android.gms.internal.ads.zzgot
    public final zzgot zzc(boolean z2, boolean z7) {
        return zzf(Boolean.compare(z7, z2));
    }

    @Override // com.google.android.gms.internal.ads.zzgot
    public final zzgot zzd(boolean z2, boolean z7) {
        return zzf(Boolean.compare(z2, z7));
    }

    @Override // com.google.android.gms.internal.ads.zzgot
    public final int zze() {
        return 0;
    }
}
