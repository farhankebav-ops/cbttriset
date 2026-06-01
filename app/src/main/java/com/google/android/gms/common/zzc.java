package com.google.android.gms.common;

import com.google.android.gms.common.internal.ShowFirstParty;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
@ShowFirstParty
public final class zzc {
    public static int zza(int i2) {
        int[] iArr = {1, 2, 3};
        for (int i8 = 0; i8 < 3; i8++) {
            int i9 = iArr[i8];
            int i10 = i9 - 1;
            if (i9 == 0) {
                throw null;
            }
            if (i10 == i2) {
                return i9;
            }
        }
        return 1;
    }
}
