package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzgl extends zzgov {
    private final Map zza;

    public zzgl(Map map) {
        this.zza = map;
    }

    @Override // com.google.android.gms.internal.ads.zzgov, java.util.Map
    public final boolean containsKey(@Nullable Object obj) {
        return obj != null && super.containsKey(obj);
    }

    @Override // com.google.android.gms.internal.ads.zzgov, java.util.Map
    public final boolean containsValue(@Nullable Object obj) {
        return zzc(obj);
    }

    @Override // com.google.android.gms.internal.ads.zzgov, java.util.Map
    public final Set entrySet() {
        return zzgro.zzb(this.zza.entrySet(), zzgj.zza);
    }

    @Override // com.google.android.gms.internal.ads.zzgov, java.util.Map
    public final boolean equals(@Nullable Object obj) {
        return obj != null && zzd(obj);
    }

    @Override // com.google.android.gms.internal.ads.zzgov, java.util.Map
    @Nullable
    public final /* synthetic */ Object get(@Nullable Object obj) {
        if (obj == null) {
            return null;
        }
        return (List) this.zza.get(obj);
    }

    @Override // com.google.android.gms.internal.ads.zzgov, java.util.Map
    public final int hashCode() {
        return zze();
    }

    @Override // com.google.android.gms.internal.ads.zzgov, java.util.Map
    public final boolean isEmpty() {
        if (this.zza.isEmpty()) {
            return true;
        }
        return super.size() == 1 && super.containsKey(null);
    }

    @Override // com.google.android.gms.internal.ads.zzgov, java.util.Map
    public final Set keySet() {
        return zzgro.zzb(this.zza.keySet(), zzgk.zza);
    }

    @Override // com.google.android.gms.internal.ads.zzgov, java.util.Map
    public final int size() {
        return super.size() - (super.containsKey(null) ? 1 : 0);
    }

    @Override // com.google.android.gms.internal.ads.zzgov
    public final Map zza() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzgov, com.google.android.gms.internal.ads.zzgow
    public final /* synthetic */ Object zzb() {
        return this.zza;
    }
}
