package com.google.android.gms.internal.ads;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzbhm {
    private static final AtomicReference zza = new AtomicReference();
    private static final AtomicReference zzb = new AtomicReference();

    static {
        new AtomicBoolean();
    }

    public static zzbhk zza() {
        return (zzbhk) zza.get();
    }

    public static zzbhl zzb() {
        return (zzbhl) zzb.get();
    }

    public static void zzc(zzbhk zzbhkVar) {
        zza.set(zzbhkVar);
    }
}
