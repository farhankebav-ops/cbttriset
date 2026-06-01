package com.google.android.gms.internal.ads;

import java.util.Comparator;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzfof implements Comparator {
    final /* synthetic */ zzfom zza;

    public zzfof(zzfom zzfomVar) {
        Objects.requireNonNull(zzfomVar);
        this.zza = zzfomVar;
    }

    @Override // java.util.Comparator
    public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
        zzfod zzfodVar = (zzfod) obj;
        zzfod zzfodVar2 = (zzfod) obj2;
        Object objZza = zzfodVar2.zza();
        zzfom zzfomVar = this.zza;
        int iCompare = Double.compare(zzfom.zzD(zzfomVar.zzb(objZza)), zzfom.zzD(zzfomVar.zzb(zzfodVar.zza())));
        return iCompare == 0 ? Long.compare(zzfodVar.zzd(), zzfodVar2.zzd()) : iCompare;
    }
}
