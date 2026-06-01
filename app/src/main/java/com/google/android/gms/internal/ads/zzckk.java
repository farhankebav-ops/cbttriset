package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzckk implements zzifh {
    private final zzcjp zza;

    private zzckk(zzcjp zzcjpVar) {
        this.zza = zzcjpVar;
    }

    public static zzckk zzc(zzcjp zzcjpVar) {
        return new zzckk(zzcjpVar);
    }

    public static VersionInfoParcel zzd(zzcjp zzcjpVar) {
        VersionInfoParcel versionInfoParcelZzd = zzcjpVar.zzd();
        zzifp.zzb(versionInfoParcelZzd);
        return versionInfoParcelZzd;
    }

    public final VersionInfoParcel zza() {
        return zzd(this.zza);
    }

    @Override // com.google.android.gms.internal.ads.zzifw, com.google.android.gms.internal.ads.zzifv
    public final /* synthetic */ Object zzb() {
        return zzd(this.zza);
    }
}
