package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzalk {
    @Nullable
    public static zzall zza(@Nullable zzall zzallVar, @Nullable String[] strArr, Map map) {
        int length;
        int i2 = 0;
        if (zzallVar == null) {
            if (strArr == null) {
                return null;
            }
            int length2 = strArr.length;
            if (length2 == 1) {
                return (zzall) map.get(strArr[0]);
            }
            if (length2 > 1) {
                zzall zzallVar2 = new zzall();
                while (i2 < length2) {
                    zzallVar2.zzr((zzall) map.get(strArr[i2]));
                    i2++;
                }
                return zzallVar2;
            }
        } else {
            if (strArr != null && strArr.length == 1) {
                zzallVar.zzr((zzall) map.get(strArr[0]));
                return zzallVar;
            }
            if (strArr != null && (length = strArr.length) > 1) {
                while (i2 < length) {
                    zzallVar.zzr((zzall) map.get(strArr[i2]));
                    i2++;
                }
            }
        }
        return zzallVar;
    }
}
