package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzawt implements Runnable {
    final /* synthetic */ zzawu zza;

    public zzawt(zzawu zzawuVar) {
        Objects.requireNonNull(zzawuVar);
        this.zza = zzawuVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean zBooleanValue;
        zzawu zzawuVar = this.zza;
        if (zzawuVar.zzb != null) {
            return;
        }
        synchronized (zzawu.zzd) {
            if (zzawuVar.zzb != null) {
                return;
            }
            boolean z2 = false;
            try {
                zBooleanValue = ((Boolean) zzbeu.zzcU.zze()).booleanValue();
            } catch (IllegalStateException unused) {
                zBooleanValue = false;
            }
            if (zBooleanValue) {
                try {
                    zzawu.zza = zzfto.zzb(this.zza.zzb().zza, "ADSHIELD", null);
                    z2 = zBooleanValue;
                } catch (Throwable unused2) {
                }
            } else {
                z2 = zBooleanValue;
            }
            this.zza.zzb = Boolean.valueOf(z2);
            zzawu.zzd.open();
        }
    }
}
