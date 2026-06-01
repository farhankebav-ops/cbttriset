package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzhdg {
    final zzhdh zza;
    final long[] zzb;

    public zzhdg(zzhdh zzhdhVar, long[] jArr) {
        this.zza = zzhdhVar;
        this.zzb = jArr;
    }

    public zzhdg() {
        this(new zzhdh(), new long[10]);
    }

    public zzhdg(zzhdg zzhdgVar) {
        this.zza = new zzhdh(zzhdgVar.zza);
        this.zzb = Arrays.copyOf(zzhdgVar.zzb, 10);
    }
}
