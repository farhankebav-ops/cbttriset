package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final /* synthetic */ class zzxj implements Comparator {
    static final /* synthetic */ zzxj zza = new zzxj();

    private /* synthetic */ zzxj() {
    }

    @Override // java.util.Comparator
    public final /* synthetic */ int compare(Object obj, Object obj2) {
        List list = (List) obj2;
        List list2 = (List) obj;
        return zzgot.zzg().zza((zzyh) Collections.max(list2, zzyg.zza), (zzyh) Collections.max(list, zzyb.zza), zzyc.zza).zzb(list2.size(), list.size()).zza((zzyh) Collections.max(list2, zzyd.zza), (zzyh) Collections.max(list, zzye.zza), zzyf.zza).zze();
    }
}
