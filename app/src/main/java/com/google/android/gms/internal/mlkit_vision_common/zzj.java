package com.google.android.gms.internal.mlkit_vision_common;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
class zzj extends zzk {
    Object[] zza = new Object[4];
    int zzb = 0;
    boolean zzc;

    public zzj(int i2) {
    }

    private final void zzb(int i2) {
        Object[] objArr = this.zza;
        int length = objArr.length;
        if (length >= i2) {
            if (this.zzc) {
                this.zza = (Object[]) objArr.clone();
                this.zzc = false;
                return;
            }
            return;
        }
        int i8 = length + (length >> 1) + 1;
        if (i8 < i2) {
            int iHighestOneBit = Integer.highestOneBit(i2 - 1);
            i8 = iHighestOneBit + iHighestOneBit;
        }
        if (i8 < 0) {
            i8 = Integer.MAX_VALUE;
        }
        this.zza = Arrays.copyOf(objArr, i8);
        this.zzc = false;
    }

    public final zzj zza(Object obj) {
        obj.getClass();
        zzb(this.zzb + 1);
        Object[] objArr = this.zza;
        int i2 = this.zzb;
        this.zzb = i2 + 1;
        objArr[i2] = obj;
        return this;
    }
}
