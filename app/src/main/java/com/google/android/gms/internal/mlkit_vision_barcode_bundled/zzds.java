package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzds {
    static final zzds zza = new zzds(true);
    public static final /* synthetic */ int zzb = 0;
    private static volatile boolean zzc = false;
    private final Map zzd;

    public zzds() {
        this.zzd = new HashMap();
    }

    public static zzds zza() {
        int i2 = zzfu.zza;
        return zza;
    }

    public final zzef zzb(zzfm zzfmVar, int i2) {
        return (zzef) this.zzd.get(new zzdr(zzfmVar, i2));
    }

    public zzds(boolean z2) {
        this.zzd = Collections.EMPTY_MAP;
    }
}
