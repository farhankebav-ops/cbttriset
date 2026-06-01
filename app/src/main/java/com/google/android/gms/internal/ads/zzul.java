package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzul {
    private static final AtomicLong zza = new AtomicLong();

    public zzul(long j, zzgf zzgfVar, Uri uri, Map map, long j3, long j8, long j9) {
    }

    public static long zza() {
        return zza.getAndIncrement();
    }

    public zzul(long j, zzgf zzgfVar, long j3) {
        Uri uri = zzgfVar.zza;
    }
}
