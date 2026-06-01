package com.google.android.gms.internal.consent_sdk;

import com.google.firebase.analytics.FirebaseAnalytics;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzdd extends zzde {
    final transient int zza;
    final transient int zzb;
    final /* synthetic */ zzde zzc;

    public zzdd(zzde zzdeVar, int i2, int i8) {
        this.zzc = zzdeVar;
        this.zza = i2;
        this.zzb = i8;
    }

    @Override // java.util.List
    public final Object get(int i2) {
        zzcx.zza(i2, this.zzb, FirebaseAnalytics.Param.INDEX);
        return this.zzc.get(i2 + this.zza);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.consent_sdk.zzdb
    public final int zzb() {
        return this.zzc.zzc() + this.zza + this.zzb;
    }

    @Override // com.google.android.gms.internal.consent_sdk.zzdb
    public final int zzc() {
        return this.zzc.zzc() + this.zza;
    }

    @Override // com.google.android.gms.internal.consent_sdk.zzdb
    public final Object[] zze() {
        return this.zzc.zze();
    }

    @Override // com.google.android.gms.internal.consent_sdk.zzde, java.util.List
    /* JADX INFO: renamed from: zzf, reason: merged with bridge method [inline-methods] */
    public final zzde subList(int i2, int i8) {
        zzcx.zzc(i2, i8, this.zzb);
        int i9 = this.zza;
        return this.zzc.subList(i2 + i9, i8 + i9);
    }
}
