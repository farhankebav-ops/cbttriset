package com.google.android.gms.internal.consent_sdk;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzbw implements zzdo {
    private final zzdr zza;
    private final zzdr zzb;

    public zzbw(zzdr zzdrVar, zzdr zzdrVar2, zzdr zzdrVar3) {
        this.zza = zzdrVar;
        this.zzb = zzdrVar3;
    }

    @Override // com.google.android.gms.internal.consent_sdk.zzdt, com.google.android.gms.internal.consent_sdk.zzds
    /* JADX INFO: renamed from: zzb, reason: merged with bridge method [inline-methods] */
    public final zzbv zza() {
        return new zzbv((zzbx) this.zza.zza(), zzat.zzb(), ((zzcc) this.zzb).zza());
    }
}
