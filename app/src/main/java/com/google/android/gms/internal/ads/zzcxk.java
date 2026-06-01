package com.google.android.gms.internal.ads;

import android.content.Context;
import androidx.annotation.Nullable;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzcxk implements zzdac, zzczj {
    private final zzffu zza;

    public zzcxk(Context context, zzffu zzffuVar, zzbvn zzbvnVar) {
        this.zza = zzffuVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdac
    public final void zzg() {
        zzbvo zzbvoVar = this.zza.zzad;
        if (zzbvoVar == null || !zzbvoVar.zza) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        String str = zzbvoVar.zzb;
        if (str.isEmpty()) {
            return;
        }
        arrayList.add(str);
    }

    @Override // com.google.android.gms.internal.ads.zzczj
    public final void zza(@Nullable Context context) {
    }

    @Override // com.google.android.gms.internal.ads.zzczj
    public final void zzb(@Nullable Context context) {
    }

    @Override // com.google.android.gms.internal.ads.zzczj
    public final void zzc(@Nullable Context context) {
    }
}
