package com.google.android.gms.internal.ads;

import java.util.Comparator;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzbbx implements Comparator {
    public zzbbx(zzbbz zzbbzVar) {
        Objects.requireNonNull(zzbbzVar);
    }

    @Override // java.util.Comparator
    public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
        zzbcc zzbccVar = (zzbcc) obj;
        zzbcc zzbccVar2 = (zzbcc) obj2;
        int i2 = zzbccVar.zzc - zzbccVar2.zzc;
        return i2 != 0 ? i2 : Long.compare(zzbccVar.zza, zzbccVar2.zza);
    }
}
