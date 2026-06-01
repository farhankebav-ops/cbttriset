package com.google.android.gms.internal.ads;

import android.view.View;
import java.util.Collections;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzemp extends zzcrn {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzemp(zzemt zzemtVar, View view, zzcgy zzcgyVar, zzctm zzctmVar, zzffv zzffvVar) {
        super(view, null, zzctmVar, zzffvVar);
        Objects.requireNonNull(zzemtVar);
    }

    @Override // com.google.android.gms.internal.ads.zzcrn
    public final zzdaa zze(Set set) {
        return new zzdaa(Collections.EMPTY_SET);
    }
}
