package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzift implements zzifh {
    private final List zza;
    private final List zzb;

    static {
        zzifi.zza(Collections.EMPTY_SET);
    }

    public /* synthetic */ zzift(List list, List list2, zzifr zzifrVar) {
        this.zza = list;
        this.zzb = list2;
    }

    public static zzifs zza(int i2, int i8) {
        return new zzifs(i2, i8, null);
    }

    @Override // com.google.android.gms.internal.ads.zzifw, com.google.android.gms.internal.ads.zzifv
    /* JADX INFO: renamed from: zzc, reason: merged with bridge method [inline-methods] */
    public final Set zzb() {
        List list = this.zza;
        int size = list.size();
        List list2 = this.zzb;
        ArrayList arrayList = new ArrayList(list2.size());
        int size2 = list2.size();
        for (int i2 = 0; i2 < size2; i2++) {
            Collection collection = (Collection) ((zzifq) list2.get(i2)).zzb();
            size += collection.size();
            arrayList.add(collection);
        }
        HashSet hashSetZzb = zzife.zzb(size);
        int size3 = list.size();
        for (int i8 = 0; i8 < size3; i8++) {
            Object objZzb = ((zzifq) list.get(i8)).zzb();
            objZzb.getClass();
            hashSetZzb.add(objZzb);
        }
        int size4 = arrayList.size();
        for (int i9 = 0; i9 < size4; i9++) {
            for (Object obj : (Collection) arrayList.get(i9)) {
                obj.getClass();
                hashSetZzb.add(obj);
            }
        }
        return Collections.unmodifiableSet(hashSetZzb);
    }
}
