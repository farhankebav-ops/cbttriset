package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzacp {
    private final Map zza = new LinkedHashMap();

    public final void zza(zzaco zzacoVar) {
        long[] jArr = zzacoVar.zze;
        if (jArr.length > 0) {
            Map map = this.zza;
            if (map.containsKey(Long.valueOf(jArr[0]))) {
                return;
            }
            map.put(Long.valueOf(jArr[0]), zzacoVar);
        }
    }

    public final zzaco zzb() {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        for (zzaco zzacoVar : this.zza.values()) {
            arrayList.add(zzacoVar.zzb);
            arrayList2.add(zzacoVar.zzc);
            arrayList3.add(zzacoVar.zzd);
            arrayList4.add(zzacoVar.zze);
        }
        int[][] iArr = (int[][]) arrayList.toArray(new int[arrayList.size()][]);
        long length = 0;
        for (int[] iArr2 : iArr) {
            length += (long) iArr2.length;
        }
        int i2 = (int) length;
        zzgmd.zze(length == ((long) i2), "the total number of elements (%s) in the arrays must fit in an int", length);
        int[] iArr3 = new int[i2];
        int i8 = 0;
        for (int[] iArr4 : iArr) {
            int length2 = iArr4.length;
            System.arraycopy(iArr4, 0, iArr3, i8, length2);
            i8 += length2;
        }
        return new zzaco(iArr3, zzgsw.zza((long[][]) arrayList2.toArray(new long[arrayList2.size()][])), zzgsw.zza((long[][]) arrayList3.toArray(new long[arrayList3.size()][])), zzgsw.zza((long[][]) arrayList4.toArray(new long[arrayList4.size()][])));
    }
}
