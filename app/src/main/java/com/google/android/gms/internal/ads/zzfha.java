package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzfha {
    private final zzffu zza;
    private final zzffx zzb;
    private final zzfng zzc;
    private final zzfmy zzd;
    private final zzflm zze;
    private final zzcpe zzf;

    @VisibleForTesting
    public zzfha(zzfng zzfngVar, zzfmy zzfmyVar, zzffu zzffuVar, zzffx zzffxVar, zzcpe zzcpeVar, zzflm zzflmVar) {
        this.zza = zzffuVar;
        this.zzb = zzffxVar;
        this.zzc = zzfngVar;
        this.zzd = zzfmyVar;
        this.zzf = zzcpeVar;
        this.zze = zzflmVar;
    }

    public final void zza(List list, @Nullable zzdbd zzdbdVar) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            zzc((String) it.next(), 2, zzdbdVar);
        }
    }

    public final void zzb(List list, int i2) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            zzgui.zzr((((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzlb)).booleanValue() && zzcpe.zzc(str)) ? this.zzf.zzb(str, com.google.android.gms.ads.internal.client.zzbb.zze()) : zzgui.zza(str), new zzfgz(this, i2), zzcbv.zza);
        }
    }

    public final void zzc(String str, int i2, @Nullable zzdbd zzdbdVar) {
        zzffu zzffuVar = this.zza;
        if (zzffuVar.zzai) {
            this.zzd.zza(str, this.zzb.zzb, i2);
            return;
        }
        this.zzc.zzb(str, zzffuVar.zzax, this.zze, zzdbdVar);
    }
}
