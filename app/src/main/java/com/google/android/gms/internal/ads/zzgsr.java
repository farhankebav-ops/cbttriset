package com.google.android.gms.internal.ads;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.Serializable;
import java.util.Arrays;
import okhttp3.internal.url._UrlKt;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzgsr implements Serializable {
    private static final zzgsr zza = new zzgsr(new int[0], 0, 0);
    private final int[] zzb;
    private final int zzc;

    private zzgsr(int[] iArr, int i2, int i8) {
        this.zzb = iArr;
        this.zzc = i8;
    }

    public static zzgsr zza() {
        return zza;
    }

    public static zzgsr zzb(int[] iArr) {
        int[] iArrCopyOf = Arrays.copyOf(iArr, iArr.length);
        return new zzgsr(iArrCopyOf, 0, iArrCopyOf.length);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzgsr)) {
            return false;
        }
        zzgsr zzgsrVar = (zzgsr) obj;
        int i2 = this.zzc;
        if (i2 != zzgsrVar.zzc) {
            return false;
        }
        for (int i8 = 0; i8 < i2; i8++) {
            if (zzd(i8) != zzgsrVar.zzd(i8)) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        int i2 = 1;
        for (int i8 = 0; i8 < this.zzc; i8++) {
            i2 = (i2 * 31) + this.zzb[i8];
        }
        return i2;
    }

    public final String toString() {
        int i2 = this.zzc;
        if (i2 == 0) {
            return _UrlKt.PATH_SEGMENT_ENCODE_SET_URI;
        }
        StringBuilder sb = new StringBuilder(i2 * 5);
        sb.append('[');
        int[] iArr = this.zzb;
        sb.append(iArr[0]);
        for (int i8 = 1; i8 < i2; i8++) {
            sb.append(", ");
            sb.append(iArr[i8]);
        }
        sb.append(']');
        return sb.toString();
    }

    public final int zzc() {
        return this.zzc;
    }

    public final int zzd(int i2) {
        zzgmd.zzm(i2, this.zzc, FirebaseAnalytics.Param.INDEX);
        return this.zzb[i2];
    }
}
