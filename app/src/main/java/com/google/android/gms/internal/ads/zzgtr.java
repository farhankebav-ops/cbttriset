package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzgtr extends zzgtt {
    public zzgtr(zzgpa zzgpaVar, boolean z2) {
        super(zzgpaVar, z2);
        zze();
    }

    @Override // com.google.android.gms.internal.ads.zzgtt
    public final /* bridge */ /* synthetic */ Object zzD(List list) {
        ArrayList arrayListZzb = zzgqe.zzb(list.size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            zzgts zzgtsVar = (zzgts) it.next();
            arrayListZzb.add(zzgtsVar != null ? zzgtsVar.zza : null);
        }
        return Collections.unmodifiableList(arrayListZzb);
    }
}
