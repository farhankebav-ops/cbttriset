package com.google.android.gms.internal.ads;

import java.util.ArrayDeque;
import java.util.Optional;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzasq {
    public final ArrayDeque zza = new ArrayDeque();

    public zzasq(int i2) {
    }

    public final void zza(long j, long j3, long j8) throws zzaso {
        int[] iArr = {1857962504, 67802545, 822753858, 1178641841, 1658857550, -1514359837, 393474692, 1520223205, 452867621};
        int i2 = iArr[0];
        int i8 = iArr[1];
        int i9 = iArr[2];
        int i10 = iArr[3];
        int i11 = iArr[4];
        int i12 = iArr[5];
        int i13 = iArr[6];
        int i14 = iArr[7];
        zzasn zzasnVar = new zzasn(j, j3, j8);
        ArrayDeque arrayDeque = this.zza;
        if (arrayDeque.size() >= (com.google.android.gms.ads.internal.client.a.c((i8 & (~i2)) | i9, (i2 & i10) | i11, i12, i13) ^ (i14 % 452867621))) {
            throw new zzaso();
        }
        arrayDeque.push(zzasnVar);
    }

    public final zzasn zzb() throws zzasp {
        return (zzasn) Optional.ofNullable((zzasn) this.zza.peek()).orElseThrow(zzasm.zza);
    }
}
