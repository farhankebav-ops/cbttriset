package com.google.android.gms.internal.ads;

import java.util.Map;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzgol extends zzgnx {
    final /* synthetic */ zzgon zza;
    private final Object zzb;
    private int zzc;

    public zzgol(zzgon zzgonVar, int i2) {
        Objects.requireNonNull(zzgonVar);
        this.zza = zzgonVar;
        this.zzb = zzgonVar.zzo(i2);
        this.zzc = i2;
    }

    private final void zza() {
        int i2 = this.zzc;
        if (i2 != -1) {
            zzgon zzgonVar = this.zza;
            if (i2 < zzgonVar.size() && Objects.equals(this.zzb, zzgonVar.zzo(this.zzc))) {
                return;
            }
        }
        this.zzc = this.zza.zzi(this.zzb);
    }

    @Override // com.google.android.gms.internal.ads.zzgnx, java.util.Map.Entry
    public final Object getKey() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzgnx, java.util.Map.Entry
    public final Object getValue() {
        zzgon zzgonVar = this.zza;
        Map mapZzc = zzgonVar.zzc();
        if (mapZzc != null) {
            return mapZzc.get(this.zzb);
        }
        zza();
        int i2 = this.zzc;
        if (i2 == -1) {
            return null;
        }
        return zzgonVar.zzp(i2);
    }

    @Override // com.google.android.gms.internal.ads.zzgnx, java.util.Map.Entry
    public final Object setValue(Object obj) {
        zzgon zzgonVar = this.zza;
        Map mapZzc = zzgonVar.zzc();
        if (mapZzc != null) {
            return mapZzc.put(this.zzb, obj);
        }
        zza();
        int i2 = this.zzc;
        if (i2 == -1) {
            zzgonVar.put(this.zzb, obj);
            return null;
        }
        Object objZzp = zzgonVar.zzp(i2);
        zzgonVar.zzq(this.zzc, obj);
        return objZzp;
    }
}
