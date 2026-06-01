package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzgqe {
    public static ArrayList zza(Iterator it) {
        ArrayList arrayList = new ArrayList();
        it.getClass();
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        return arrayList;
    }

    public static ArrayList zzb(int i2) {
        zzgoc.zzb(i2, "initialArraySize");
        return new ArrayList(i2);
    }

    public static List zzc(List list, zzglu zzgluVar) {
        return list instanceof RandomAccess ? new zzgqb(list, zzgluVar) : new zzgqd(list, zzgluVar);
    }
}
