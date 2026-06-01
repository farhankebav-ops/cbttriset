package com.google.android.gms.internal.mlkit_vision_barcode;

import android.graphics.Point;
import androidx.annotation.NonNull;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class zzxn {
    public static zzxn zzg(@NonNull Iterable iterable, int i2, int i8, float f4) {
        Iterator it = iterable.iterator();
        int iMax = 0;
        int iMin = i2;
        int iMin2 = i8;
        int iMax2 = 0;
        while (it.hasNext()) {
            Point point = (Point) it.next();
            iMin = Math.min(iMin, point.x);
            iMin2 = Math.min(iMin2, point.y);
            iMax = Math.max(iMax, point.x);
            iMax2 = Math.max(iMax2, point.y);
        }
        float f8 = i2;
        float f9 = i8;
        return new zzxg((iMin + 0.0f) / f8, (iMin2 + 0.0f) / f9, (iMax + 0.0f) / f8, (iMax2 + 0.0f) / f9, 0.0f);
    }

    public abstract float zza();

    public abstract float zzb();

    public abstract float zzc();

    public abstract float zzd();

    public abstract float zze();

    public final float zzf() {
        if (!zzh()) {
            return 0.0f;
        }
        return (zzd() - zze()) * (zzb() - zzc());
    }

    public final boolean zzh() {
        return zzc() >= 0.0f && zzc() < zzb() && zzb() <= 1.0f && zze() >= 0.0f && zze() < zzd() && zzd() <= 1.0f;
    }
}
