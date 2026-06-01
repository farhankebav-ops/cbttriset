package com.google.android.gms.internal.ads;

import android.os.Bundle;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzewq implements zzeya {

    @Nullable
    private final Bundle zza;

    public zzewq(@Nullable Bundle bundle) {
        this.zza = bundle;
    }

    @Override // com.google.android.gms.internal.ads.zzeya
    public final j2.q zza() {
        return zzgui.zza(new zzewr(this.zza));
    }

    @Override // com.google.android.gms.internal.ads.zzeya
    public final int zzb() {
        return 30;
    }
}
