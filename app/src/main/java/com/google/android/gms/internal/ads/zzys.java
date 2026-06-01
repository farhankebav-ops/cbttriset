package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzys {
    public final int zza;
    public final zzlq[] zzb;
    public final zzyk[] zzc;
    public final zzbn zzd;

    @Nullable
    public final Object zze;

    public zzys(zzlq[] zzlqVarArr, zzyk[] zzykVarArr, zzbn zzbnVar, @Nullable Object obj) {
        int length = zzlqVarArr.length;
        zzgmd.zza(length == zzykVarArr.length);
        this.zzb = zzlqVarArr;
        this.zzc = (zzyk[]) zzykVarArr.clone();
        this.zzd = zzbnVar;
        this.zze = obj;
        this.zza = length;
    }

    public final boolean zza(int i2) {
        return this.zzb[i2] != null;
    }

    public final boolean zzb(@Nullable zzys zzysVar, int i2) {
        return zzysVar != null && Objects.equals(this.zzb[i2], zzysVar.zzb[i2]) && Objects.equals(this.zzc[i2], zzysVar.zzc[i2]);
    }
}
