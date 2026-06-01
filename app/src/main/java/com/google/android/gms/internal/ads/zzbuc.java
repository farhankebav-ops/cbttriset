package com.google.android.gms.internal.ads;

import android.content.DialogInterface;
import android.content.Intent;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzbuc implements DialogInterface.OnClickListener {
    final /* synthetic */ zzbue zza;

    public zzbuc(zzbue zzbueVar) {
        Objects.requireNonNull(zzbueVar);
        this.zza = zzbueVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i2) {
        zzbue zzbueVar = this.zza;
        Intent intentZzb = zzbueVar.zzb();
        com.google.android.gms.ads.internal.zzt.zzc();
        com.google.android.gms.ads.internal.util.zzs.zzZ(zzbueVar.zzc(), intentZzb);
    }
}
