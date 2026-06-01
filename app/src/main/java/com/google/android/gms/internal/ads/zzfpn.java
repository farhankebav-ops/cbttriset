package com.google.android.gms.internal.ads;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzfpn implements Runnable {
    final /* synthetic */ zzfpo zza;

    public zzfpn(zzfpo zzfpoVar) {
        Objects.requireNonNull(zzfpoVar);
        this.zza = zzfpoVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzfpo zzfpoVar = this.zza;
        AtomicBoolean atomicBooleanZzf = zzfpoVar.zzf();
        float fZzc = zzfpoVar.zzc();
        atomicBooleanZzf.set(false);
        if (((Float) zzfpoVar.zze().getAndSet(Float.valueOf(fZzc))).floatValue() != fZzc) {
            zzfpoVar.zzd().post(new zzfpm(this, fZzc));
        }
    }
}
