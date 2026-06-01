package com.google.android.gms.internal.mlkit_vision_barcode;

import com.google.firebase.analytics.FirebaseAnalytics;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzcr extends zzcs {
    final transient int zza;
    final transient int zzb;
    final /* synthetic */ zzcs zzc;

    public zzcr(zzcs zzcsVar, int i2, int i8) {
        this.zzc = zzcsVar;
        this.zza = i2;
        this.zzb = i8;
    }

    @Override // java.util.List
    public final Object get(int i2) {
        zzaz.zza(i2, this.zzb, FirebaseAnalytics.Param.INDEX);
        return this.zzc.get(i2 + this.zza);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzcn
    public final int zzb() {
        return this.zzc.zzc() + this.zza + this.zzb;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzcn
    public final int zzc() {
        return this.zzc.zzc() + this.zza;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzcn
    public final Object[] zze() {
        return this.zzc.zze();
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzcs, java.util.List
    /* JADX INFO: renamed from: zzf, reason: merged with bridge method [inline-methods] */
    public final zzcs subList(int i2, int i8) {
        zzaz.zze(i2, i8, this.zzb);
        int i9 = this.zza;
        return this.zzc.subList(i2 + i9, i8 + i9);
    }
}
