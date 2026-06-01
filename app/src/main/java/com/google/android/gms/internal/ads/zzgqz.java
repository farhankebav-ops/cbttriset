package com.google.android.gms.internal.ads;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzgqz extends zzgpe {
    static final zzgpe zza = new zzgqz(new Object[0], 0);
    final transient Object[] zzb;
    private final transient int zzc;

    public zzgqz(Object[] objArr, int i2) {
        this.zzb = objArr;
        this.zzc = i2;
    }

    @Override // java.util.List
    public final Object get(int i2) {
        zzgmd.zzm(i2, this.zzc, FirebaseAnalytics.Param.INDEX);
        Object obj = this.zzb[i2];
        Objects.requireNonNull(obj);
        return obj;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.ads.zzgpa
    public final Object[] zzb() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzgpa
    public final int zzc() {
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzgpa
    public final int zzd() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.ads.zzgpa
    public final boolean zzf() {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzgpe, com.google.android.gms.internal.ads.zzgpa
    public final int zzg(Object[] objArr, int i2) {
        Object[] objArr2 = this.zzb;
        int i8 = this.zzc;
        System.arraycopy(objArr2, 0, objArr, i2, i8);
        return i2 + i8;
    }
}
