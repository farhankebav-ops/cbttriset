package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzctq implements zzctr {
    private final Map zza;

    public zzctq(Map map) {
        this.zza = map;
    }

    @Override // com.google.android.gms.internal.ads.zzctr
    @Nullable
    public final zzehk zza(int i2, String str) {
        return (zzehk) this.zza.get(str);
    }
}
