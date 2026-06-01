package com.google.android.gms.internal.common;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
class zzaa extends zzab {
    Object[] zza = new Object[4];
    int zzb = 0;
    boolean zzc;

    public zzaa(int i2) {
    }

    public final zzaa zza(Object obj) {
        int i2;
        obj.getClass();
        int length = this.zza.length;
        int i8 = this.zzb;
        int i9 = i8 + 1;
        if (i9 < 0) {
            throw new IllegalArgumentException("cannot store more than Integer.MAX_VALUE elements");
        }
        if (i9 <= length) {
            i2 = length;
        } else {
            i2 = (length >> 1) + length + 1;
            if (i2 < i9) {
                int iHighestOneBit = Integer.highestOneBit(i8);
                i2 = iHighestOneBit + iHighestOneBit;
            }
            if (i2 < 0) {
                i2 = Integer.MAX_VALUE;
            }
        }
        if (i2 > length || this.zzc) {
            this.zza = Arrays.copyOf(this.zza, i2);
            this.zzc = false;
        }
        Object[] objArr = this.zza;
        int i10 = this.zzb;
        this.zzb = i10 + 1;
        objArr[i10] = obj;
        return this;
    }
}
