package com.google.android.gms.measurement.internal;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
abstract class zzos extends zzol {
    private boolean zza;

    public zzos(zzpg zzpgVar) {
        super(zzpgVar);
        this.zzg.zzae();
    }

    public final boolean zzav() {
        return this.zza;
    }

    public final void zzaw() {
        if (!zzav()) {
            throw new IllegalStateException("Not initialized");
        }
    }

    public final void zzax() {
        if (this.zza) {
            throw new IllegalStateException("Can't initialize twice");
        }
        zzbb();
        this.zzg.zzaf();
        this.zza = true;
    }

    public abstract boolean zzbb();
}
