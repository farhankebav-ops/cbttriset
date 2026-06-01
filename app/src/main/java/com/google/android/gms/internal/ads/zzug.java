package com.google.android.gms.internal.ads;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzug {
    private final Map zza = new HashMap();
    private final Map zzb = new HashMap();
    private zzga zzc;

    public zzug(zzadg zzadgVar, zzakg zzakgVar) {
    }

    public final void zza(zzga zzgaVar) {
        if (zzgaVar != this.zzc) {
            this.zzc = zzgaVar;
            this.zza.clear();
            this.zzb.clear();
        }
    }
}
