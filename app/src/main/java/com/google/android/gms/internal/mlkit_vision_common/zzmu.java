package com.google.android.gms.internal.mlkit_vision_common;

import android.os.SystemClock;
import androidx.annotation.WorkerThread;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzmu {
    @WorkerThread
    public static void zza(zzmj zzmjVar, int i2, int i8, long j, int i9, int i10, int i11, int i12) {
        zzmjVar.zzc(zzc(i2, i8, j, i9, i10, i11, i12), zziv.INPUT_IMAGE_CONSTRUCTION);
    }

    @WorkerThread
    public static void zzb(zzmj zzmjVar, int i2, int i8, long j, int i9, int i10, int i11, int i12) {
        zzmjVar.zzc(zzc(i2, i8, j, i9, i10, i11, i12), zziv.ODML_IMAGE);
    }

    private static zzmt zzc(int i2, int i8, long j, int i9, int i10, int i11, int i12) {
        return new zzmt(i2, i8, i11, i9, i10, SystemClock.elapsedRealtime() - j, i12);
    }
}
