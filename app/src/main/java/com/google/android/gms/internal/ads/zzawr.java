package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzawr implements Runnable {
    final /* synthetic */ zzaws zza;

    public zzawr(zzaws zzawsVar) {
        Objects.requireNonNull(zzawsVar);
        this.zza = zzawsVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzaws zzawsVar = this.zza;
        synchronized (zzawsVar.zzp()) {
            if (zzawsVar.zzq()) {
                return;
            }
            zzawsVar.zzr(true);
            try {
                zzawsVar.zzn();
            } catch (Exception e) {
                this.zza.zzo().zzc(2023, -1L, e);
            }
            zzaws zzawsVar2 = this.zza;
            synchronized (zzawsVar2.zzp()) {
                zzawsVar2.zzr(false);
            }
        }
    }
}
