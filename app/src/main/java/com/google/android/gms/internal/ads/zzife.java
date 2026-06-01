package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzife {
    public static List zza(int i2) {
        return i2 == 0 ? Collections.EMPTY_LIST : new ArrayList(i2);
    }

    public static HashSet zzb(int i2) {
        return new HashSet(zzd(i2));
    }

    public static LinkedHashMap zzc(int i2) {
        return new LinkedHashMap(zzd(i2));
    }

    private static int zzd(int i2) {
        if (i2 < 3) {
            return i2 + 1;
        }
        if (i2 < 1073741824) {
            return (int) ((i2 / 0.75f) + 1.0f);
        }
        return Integer.MAX_VALUE;
    }
}
