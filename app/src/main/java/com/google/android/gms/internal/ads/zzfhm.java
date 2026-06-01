package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.util.Deque;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingDeque;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzfhm {
    private final Deque zza = new LinkedBlockingDeque();
    private final Callable zzb;
    private final zzgus zzc;

    public zzfhm(Callable callable, zzgus zzgusVar) {
        this.zzb = callable;
        this.zzc = zzgusVar;
    }

    public final synchronized void zza(int i2) {
        Deque deque = this.zza;
        int size = i2 - deque.size();
        for (int i8 = 0; i8 < size; i8++) {
            deque.add(this.zzc.zzc(this.zzb));
        }
    }

    @Nullable
    public final synchronized j2.q zzb() {
        zza(1);
        return (j2.q) this.zza.poll();
    }

    public final synchronized void zzc(j2.q qVar) {
        this.zza.addFirst(qVar);
    }
}
