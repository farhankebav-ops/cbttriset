package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzcdt implements Runnable {
    private final zzcdf zza;
    private boolean zzb = false;

    public zzcdt(zzcdf zzcdfVar) {
        this.zza = zzcdfVar;
    }

    private final void zzc() {
        zzfuz zzfuzVar = com.google.android.gms.ads.internal.util.zzs.zza;
        zzfuzVar.removeCallbacks(this);
        zzfuzVar.postDelayed(this, 250L);
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.zzb) {
            return;
        }
        this.zza.zzF();
        zzc();
    }

    public final void zza() {
        this.zzb = true;
        this.zza.zzF();
    }

    public final void zzb() {
        this.zzb = false;
        zzc();
    }
}
