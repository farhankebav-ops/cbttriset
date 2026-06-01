package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzctj implements zzifh {
    private final zzctg zza;

    private zzctj(zzctg zzctgVar) {
        this.zza = zzctgVar;
    }

    public static zzctj zzc(zzctg zzctgVar) {
        return new zzctj(zzctgVar);
    }

    public static zzdbp zzd(zzctg zzctgVar) {
        return zzctgVar.zza();
    }

    public final zzdbp zza() {
        return zzd(this.zza);
    }

    @Override // com.google.android.gms.internal.ads.zzifw, com.google.android.gms.internal.ads.zzifv
    public final /* synthetic */ Object zzb() {
        return zzd(this.zza);
    }
}
