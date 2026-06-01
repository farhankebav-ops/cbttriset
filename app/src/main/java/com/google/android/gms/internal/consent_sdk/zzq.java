package com.google.android.gms.internal.consent_sdk;

import android.app.Application;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzq implements zzdo {
    private final zzdr zza;
    private final zzdr zzb;

    public zzq(zzdr zzdrVar, zzdr zzdrVar2) {
        this.zza = zzdrVar;
        this.zzb = zzdrVar2;
    }

    @Override // com.google.android.gms.internal.consent_sdk.zzdt, com.google.android.gms.internal.consent_sdk.zzds
    /* JADX INFO: renamed from: zzb, reason: merged with bridge method [inline-methods] */
    public final zzn zza() {
        return new zzn((Application) this.zza.zza(), (zzaq) this.zzb.zza());
    }
}
