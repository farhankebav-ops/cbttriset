package com.google.android.gms.internal.ads;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzgpd extends zzgpe {
    final transient int zza;
    final transient int zzb;
    final /* synthetic */ zzgpe zzc;

    public zzgpd(zzgpe zzgpeVar, int i2, int i8) {
        Objects.requireNonNull(zzgpeVar);
        this.zzc = zzgpeVar;
        this.zza = i2;
        this.zzb = i8;
    }

    @Override // java.util.List
    public final Object get(int i2) {
        zzgmd.zzm(i2, this.zzb, FirebaseAnalytics.Param.INDEX);
        return this.zzc.get(i2 + this.zza);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzgpa
    public final Object[] zzb() {
        return this.zzc.zzb();
    }

    @Override // com.google.android.gms.internal.ads.zzgpa
    public final int zzc() {
        return this.zzc.zzc() + this.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzgpa
    public final int zzd() {
        return this.zzc.zzc() + this.zza + this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzgpa
    public final boolean zzf() {
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzgpe, java.util.List
    /* JADX INFO: renamed from: zzh */
    public final zzgpe subList(int i2, int i8) {
        zzgmd.zzo(i2, i8, this.zzb);
        int i9 = this.zza;
        return this.zzc.subList(i2 + i9, i8 + i9);
    }
}
