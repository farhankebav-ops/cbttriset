package com.google.android.gms.internal.ads;

import android.os.SystemClock;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzaqf {
    public static final boolean zza = zzaqg.zzb;
    private final List zzb = new ArrayList();
    private boolean zzc = false;

    public final void finalize() throws Throwable {
        if (this.zzc) {
            return;
        }
        zzb("Request on the loose");
        zzaqg.zzc("Marker log finalized without finish() - uncaught exit point for request", new Object[0]);
    }

    public final synchronized void zza(String str, long j) {
        if (this.zzc) {
            throw new IllegalStateException("Marker added to finished log");
        }
        this.zzb.add(new zzaqe(str, j, SystemClock.elapsedRealtime()));
    }

    public final synchronized void zzb(String str) {
        this.zzc = true;
        List<zzaqe> list = this.zzb;
        long j = list.size() == 0 ? 0L : ((zzaqe) list.get(list.size() - 1)).zzc - ((zzaqe) list.get(0)).zzc;
        if (j > 0) {
            long j3 = ((zzaqe) list.get(0)).zzc;
            zzaqg.zzb("(%-4d ms) %s", Long.valueOf(j), str);
            for (zzaqe zzaqeVar : list) {
                long j8 = zzaqeVar.zzc;
                zzaqg.zzb("(+%-4d) [%2d] %s", Long.valueOf(j8 - j3), Long.valueOf(zzaqeVar.zzb), zzaqeVar.zza);
                j3 = j8;
            }
        }
    }
}
