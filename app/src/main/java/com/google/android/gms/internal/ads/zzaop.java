package com.google.android.gms.internal.ads;

import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzaop {
    public final int zza;
    public final long zzb;

    private zzaop(int i2, long j) {
        this.zza = i2;
        this.zzb = j;
    }

    public static zzaop zza(zzadb zzadbVar, zzeg zzegVar) throws IOException {
        zzadbVar.zzi(zzegVar.zzi(), 0, 8);
        zzegVar.zzh(0);
        return new zzaop(zzegVar.zzB(), zzegVar.zzA());
    }
}
