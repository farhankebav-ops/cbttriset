package com.google.android.gms.internal.ads;

import android.util.SparseArray;
import androidx.annotation.Nullable;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzahi implements zzaed {

    @Nullable
    private final zzaco zza;
    private final SparseArray zzb;
    private final long zzc;
    private final int zzd;

    public zzahi(SparseArray sparseArray, long j, int i2, long j3, long j8) {
        int i8;
        this.zzb = sparseArray;
        this.zzc = j;
        this.zzd = i2;
        List list = (List) sparseArray.get(i2);
        zzaco zzacoVar = null;
        if (list != null && !list.isEmpty()) {
            int size = list.size();
            int[] iArrCopyOf = new int[size];
            long[] jArrCopyOf = new long[size];
            long[] jArrCopyOf2 = new long[size];
            long[] jArrCopyOf3 = new long[size];
            int i9 = 0;
            for (int i10 = 0; i10 < size; i10++) {
                zzahh zzahhVar = (zzahh) list.get(i10);
                jArrCopyOf3[i10] = zzahhVar.zza;
                jArrCopyOf[i10] = zzahhVar.zzb;
            }
            while (true) {
                i8 = size - 1;
                if (i9 >= i8) {
                    break;
                }
                int i11 = i9 + 1;
                iArrCopyOf[i9] = (int) (jArrCopyOf[i11] - jArrCopyOf[i9]);
                jArrCopyOf2[i9] = jArrCopyOf3[i11] - jArrCopyOf3[i9];
                i9 = i11;
            }
            int i12 = i8;
            while (i12 > 0 && jArrCopyOf3[i12] >= j) {
                i12--;
            }
            iArrCopyOf[i12] = (int) ((j3 + j8) - jArrCopyOf[i12]);
            jArrCopyOf2[i12] = j - jArrCopyOf3[i12];
            if (i12 < i8) {
                zzdt.zzc("MatroskaExtractor", "Discarding trailing cue points with timestamps greater than total duration.");
                int i13 = i12 + 1;
                iArrCopyOf = Arrays.copyOf(iArrCopyOf, i13);
                jArrCopyOf = Arrays.copyOf(jArrCopyOf, i13);
                jArrCopyOf2 = Arrays.copyOf(jArrCopyOf2, i13);
                jArrCopyOf3 = Arrays.copyOf(jArrCopyOf3, i13);
            }
            zzacoVar = new zzaco(iArrCopyOf, jArrCopyOf, jArrCopyOf2, jArrCopyOf3);
        }
        this.zza = zzacoVar;
    }

    @Override // com.google.android.gms.internal.ads.zzaed
    public final long zza() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.ads.zzaed
    public final boolean zzb() {
        List list = (List) this.zzb.get(this.zzd);
        return (list == null || list.isEmpty()) ? false : true;
    }

    @Override // com.google.android.gms.internal.ads.zzaed
    public final zzaeb zzc(long j) {
        zzaco zzacoVar = this.zza;
        if (zzacoVar != null) {
            return zzacoVar.zzc(j);
        }
        zzaee zzaeeVar = zzaee.zza;
        return new zzaeb(zzaeeVar, zzaeeVar);
    }
}
