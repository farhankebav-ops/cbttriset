package com.google.android.gms.internal.ads;

import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzdhr extends zzdem {
    private boolean zzb;

    public zzdhr(Set set) {
        super(set);
    }

    public final void zza() {
        zzs(zzdhq.zza);
    }

    public final void zzb() {
        zzs(zzdhm.zza);
    }

    public final synchronized void zzc() {
        zzs(zzdhn.zza);
        this.zzb = true;
    }

    public final synchronized void zzd() {
        try {
            if (!this.zzb) {
                zzs(zzdhp.zza);
                this.zzb = true;
            }
            zzs(zzdho.zza);
        } catch (Throwable th) {
            throw th;
        }
    }
}
