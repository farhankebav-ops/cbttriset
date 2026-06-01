package com.google.android.gms.internal.ads;

import java.util.Comparator;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class zzgqy implements Comparator {
    public static zzgqy zzb() {
        return zzgqw.zza;
    }

    public static zzgqy zzc(Comparator comparator) {
        return new zzgop(comparator);
    }

    @Override // java.util.Comparator
    public abstract int compare(Object obj, Object obj2);

    public zzgqy zza() {
        return new zzgrh(this);
    }

    public final zzgqy zzd(zzglu zzgluVar) {
        return new zzgob(zzgluVar, this);
    }
}
