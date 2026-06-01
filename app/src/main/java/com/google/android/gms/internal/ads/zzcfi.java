package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzcfi extends zzcfe {
    public zzcfi(zzcdr zzcdrVar) {
        super(zzcdrVar);
    }

    @Override // com.google.android.gms.internal.ads.zzcfe
    public final boolean zze(String str) {
        String strZzf = com.google.android.gms.ads.internal.util.client.zzf.zzf(str);
        zzcdr zzcdrVar = (zzcdr) this.zzc.get();
        if (zzcdrVar != null && strZzf != null) {
            zzcdrVar.zzt(strZzf, this);
        }
        int i2 = com.google.android.gms.ads.internal.util.zze.zza;
        com.google.android.gms.ads.internal.util.client.zzo.zzi("VideoStreamNoopCache is doing nothing.");
        zzq(str, strZzf, "noop", "Noop cache is a noop.");
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzcfe
    public final void zzl() {
    }
}
