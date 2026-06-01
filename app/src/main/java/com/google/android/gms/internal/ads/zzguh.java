package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzguh {
    private final boolean zza;
    private final zzgpe zzb;

    public /* synthetic */ zzguh(boolean z2, zzgpe zzgpeVar, byte[] bArr) {
        this.zza = z2;
        this.zzb = zzgpeVar;
    }

    public final j2.q zza(Callable callable, Executor executor) {
        return new zzgtw(this.zzb, this.zza, executor, callable);
    }
}
