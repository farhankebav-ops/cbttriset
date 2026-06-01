package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzamd implements zzakd {
    private final List zza;
    private final long[] zzb;
    private final long[] zzc;

    public zzamd(List list) {
        this.zza = Collections.unmodifiableList(new ArrayList(list));
        int size = list.size();
        this.zzb = new long[size + size];
        for (int i2 = 0; i2 < list.size(); i2++) {
            zzalt zzaltVar = (zzalt) list.get(i2);
            long[] jArr = this.zzb;
            int i8 = i2 + i2;
            jArr[i8] = zzaltVar.zzb;
            jArr[i8 + 1] = zzaltVar.zzc;
        }
        long[] jArr2 = this.zzb;
        long[] jArrCopyOf = Arrays.copyOf(jArr2, jArr2.length);
        this.zzc = jArrCopyOf;
        Arrays.sort(jArrCopyOf);
    }

    @Override // com.google.android.gms.internal.ads.zzakd
    public final int zza() {
        return this.zzc.length;
    }

    @Override // com.google.android.gms.internal.ads.zzakd
    public final long zzb(int i2) {
        zzgmd.zza(i2 >= 0);
        long[] jArr = this.zzc;
        zzgmd.zza(i2 < jArr.length);
        return jArr[i2];
    }

    @Override // com.google.android.gms.internal.ads.zzakd
    public final List zzc(long j) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        int i2 = 0;
        while (true) {
            List list = this.zza;
            if (i2 >= list.size()) {
                break;
            }
            long[] jArr = this.zzb;
            int i8 = i2 + i2;
            if (jArr[i8] <= j && j < jArr[i8 + 1]) {
                zzalt zzaltVar = (zzalt) list.get(i2);
                zzcm zzcmVar = zzaltVar.zza;
                if (zzcmVar.zze == -3.4028235E38f) {
                    arrayList2.add(zzaltVar);
                } else {
                    arrayList.add(zzcmVar);
                }
            }
            i2++;
        }
        Collections.sort(arrayList2, zzamc.zza);
        for (int i9 = 0; i9 < arrayList2.size(); i9++) {
            zzcl zzclVarZza = ((zzalt) arrayList2.get(i9)).zza.zza();
            zzclVarZza.zzf((-1) - i9, 1);
            arrayList.add(zzclVarZza.zzr());
        }
        return arrayList;
    }
}
