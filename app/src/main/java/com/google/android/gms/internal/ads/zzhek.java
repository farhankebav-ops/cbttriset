package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzhek {
    private HashMap zza = new HashMap();

    public final zzhel zza() {
        if (this.zza == null) {
            throw new IllegalStateException("cannot call build() twice");
        }
        zzhel zzhelVar = new zzhel(Collections.unmodifiableMap(this.zza), null);
        this.zza = null;
        return zzhelVar;
    }
}
