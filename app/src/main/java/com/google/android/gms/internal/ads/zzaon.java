package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzaon implements zzada {
    private zzadd zza;
    private zzaem zzb;
    private zzaok zze;
    private int zzc = 0;
    private long zzd = -1;
    private int zzf = -1;
    private long zzg = -1;

    @Override // com.google.android.gms.internal.ads.zzada
    public final boolean zza(zzadb zzadbVar) throws IOException {
        return zzaoq.zza(zzadbVar);
    }

    @Override // com.google.android.gms.internal.ads.zzada
    public final /* synthetic */ List zzb() {
        return d.a(this);
    }

    @Override // com.google.android.gms.internal.ads.zzada
    public final void zzc(zzadd zzaddVar) {
        this.zza = zzaddVar;
        this.zzb = zzaddVar.zzu(0, 1);
        zzaddVar.zzv();
    }

    /* JADX WARN: Code restructure failed: missing block: B:42:0x00f4, code lost:
    
        if (r1 != 65534) goto L43;
     */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0119  */
    @Override // com.google.android.gms.internal.ads.zzada
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int zzd(com.google.android.gms.internal.ads.zzadb r19, com.google.android.gms.internal.ads.zzaea r20) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 420
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaon.zzd(com.google.android.gms.internal.ads.zzadb, com.google.android.gms.internal.ads.zzaea):int");
    }

    @Override // com.google.android.gms.internal.ads.zzada
    public final void zze(long j, long j3) {
        this.zzc = j == 0 ? 0 : 4;
        zzaok zzaokVar = this.zze;
        if (zzaokVar != null) {
            zzaokVar.zza(j3);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzada
    public final /* synthetic */ zzada zzf() {
        return d.b(this);
    }
}
