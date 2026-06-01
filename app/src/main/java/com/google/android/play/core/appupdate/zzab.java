package com.google.android.play.core.appupdate;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzab {
    private zzi zza;

    private zzab() {
    }

    public final zza zza() {
        zzi zziVar = this.zza;
        if (zziVar != null) {
            return new zzz(zziVar, null);
        }
        throw new IllegalStateException(String.valueOf(zzi.class.getCanonicalName()).concat(" must be set"));
    }

    public final zzab zzb(zzi zziVar) {
        this.zza = zziVar;
        return this;
    }

    public /* synthetic */ zzab(zzaa zzaaVar) {
    }
}
