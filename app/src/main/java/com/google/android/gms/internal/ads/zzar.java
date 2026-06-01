package com.google.android.gms.internal.ads;

import androidx.annotation.VisibleForTesting;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
@VisibleForTesting
final class zzar {
    public final int zza;
    public final int zzb;

    public zzar(int i2, int i8) {
        this.zza = i2;
        this.zzb = i8;
    }

    public final int zza() {
        int i2 = this.zzb;
        if (i2 == 2) {
            return 10;
        }
        if (i2 == 5) {
            return 11;
        }
        if (i2 == 29) {
            return 12;
        }
        if (i2 != 42) {
            return i2 != 22 ? i2 != 23 ? 0 : 15 : BasicMeasure.EXACTLY;
        }
        return 16;
    }
}
