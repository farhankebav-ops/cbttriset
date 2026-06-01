package com.google.android.gms.internal.mlkit_common;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzap extends zzaf {
    private final transient Object[] zza;
    private final transient int zzb;
    private final transient int zzc;

    public zzap(Object[] objArr, int i2, int i8) {
        this.zza = objArr;
        this.zzb = i2;
        this.zzc = i8;
    }

    @Override // java.util.List
    public final Object get(int i2) {
        zzt.zza(i2, this.zzc, FirebaseAnalytics.Param.INDEX);
        Object obj = this.zza[i2 + i2 + this.zzb];
        Objects.requireNonNull(obj);
        return obj;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzc;
    }
}
