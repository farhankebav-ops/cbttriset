package com.google.android.gms.internal.mlkit_common;

import a1.a;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzak {
    public static Object[] zza(Object[] objArr, int i2) {
        for (int i8 = 0; i8 < i2; i8++) {
            if (objArr[i8] == null) {
                throw new NullPointerException(a.g(i8, "at index "));
            }
        }
        return objArr;
    }
}
