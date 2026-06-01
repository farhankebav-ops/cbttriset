package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzhfj implements Iterable {
    final /* synthetic */ List zza;
    final /* synthetic */ List zzb;

    public zzhfj(zzhfm zzhfmVar, List list, List list2) {
        this.zza = list;
        this.zzb = list2;
        Objects.requireNonNull(zzhfmVar);
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return new zzhfl(this.zza.iterator(), this.zzb.iterator(), null);
    }
}
