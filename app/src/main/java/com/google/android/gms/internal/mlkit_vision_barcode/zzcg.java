package com.google.android.gms.internal.mlkit_vision_barcode;

import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzcg extends zzbs {
    final /* synthetic */ zzci zza;
    private final Object zzb;
    private int zzc;

    public zzcg(zzci zzciVar, int i2) {
        this.zza = zzciVar;
        this.zzb = zzci.zzg(zzciVar, i2);
        this.zzc = i2;
    }

    private final void zza() {
        int i2 = this.zzc;
        if (i2 == -1 || i2 >= this.zza.size() || !zzax.zza(this.zzb, zzci.zzg(this.zza, this.zzc))) {
            this.zzc = this.zza.zzw(this.zzb);
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzbs, java.util.Map.Entry
    public final Object getKey() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzbs, java.util.Map.Entry
    public final Object getValue() {
        Map mapZzl = this.zza.zzl();
        if (mapZzl != null) {
            return mapZzl.get(this.zzb);
        }
        zza();
        int i2 = this.zzc;
        if (i2 == -1) {
            return null;
        }
        return zzci.zzj(this.zza, i2);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzbs, java.util.Map.Entry
    public final Object setValue(Object obj) {
        Map mapZzl = this.zza.zzl();
        if (mapZzl != null) {
            return mapZzl.put(this.zzb, obj);
        }
        zza();
        int i2 = this.zzc;
        if (i2 == -1) {
            this.zza.put(this.zzb, obj);
            return null;
        }
        zzci zzciVar = this.zza;
        Object objZzj = zzci.zzj(zzciVar, i2);
        zzci.zzn(zzciVar, this.zzc, obj);
        return objZzj;
    }
}
