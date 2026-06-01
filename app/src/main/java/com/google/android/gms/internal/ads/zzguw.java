package com.google.android.gms.internal.ads;

import java.util.concurrent.Delayed;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzguw extends zzgud implements zzgur {
    private final ScheduledFuture zza;

    public zzguw(j2.q qVar, ScheduledFuture scheduledFuture) {
        super(qVar);
        this.zza = scheduledFuture;
    }

    @Override // com.google.android.gms.internal.ads.zzguc, java.util.concurrent.Future
    public final boolean cancel(boolean z2) {
        boolean zCancel = zza().cancel(z2);
        if (zCancel) {
            this.zza.cancel(z2);
        }
        return zCancel;
    }

    @Override // java.lang.Comparable
    public final /* bridge */ /* synthetic */ int compareTo(Delayed delayed) {
        return this.zza.compareTo(delayed);
    }

    @Override // java.util.concurrent.Delayed
    public final long getDelay(TimeUnit timeUnit) {
        return this.zza.getDelay(timeUnit);
    }
}
