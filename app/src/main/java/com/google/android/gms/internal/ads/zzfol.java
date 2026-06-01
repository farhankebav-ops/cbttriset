package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzfol implements Runnable {
    final /* synthetic */ zzfom zza;

    public zzfol(zzfom zzfomVar) {
        Objects.requireNonNull(zzfomVar);
        this.zza = zzfomVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzfom zzfomVar = this.zza;
        if (zzfomVar.zzA() != null) {
            zzfnv zzfnvVarZzA = zzfomVar.zzA();
            Clock clockZzB = zzfomVar.zzB();
            zzfnvVarZzA.zzj(clockZzB.currentTimeMillis(), zzfomVar.zzC(), zzfomVar.zze.zzd, zzfomVar.zzz());
        }
    }
}
