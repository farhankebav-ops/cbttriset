package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzamv implements zzamq {
    private static final float[] zza = {1.0f, 1.0f, 1.0909091f, 0.90909094f, 1.4545455f, 1.2121212f, 1.0f};

    @Nullable
    private final zzaoi zzb;
    private zzamu zzg;
    private long zzh;
    private String zzi;
    private zzaem zzj;
    private boolean zzk;
    private final boolean[] zzd = new boolean[4];
    private final zzamt zze = new zzamt(128);
    private long zzl = -9223372036854775807L;

    @Nullable
    private final zzanh zzf = new zzanh(178, 128);

    @Nullable
    private final zzeg zzc = new zzeg();

    public zzamv(@Nullable zzaoi zzaoiVar, String str) {
        this.zzb = zzaoiVar;
    }

    @Override // com.google.android.gms.internal.ads.zzamq
    public final void zza() {
        zzfm.zzi(this.zzd);
        this.zze.zza();
        zzamu zzamuVar = this.zzg;
        if (zzamuVar != null) {
            zzamuVar.zza();
        }
        this.zzf.zza();
        this.zzh = 0L;
        this.zzl = -9223372036854775807L;
    }

    @Override // com.google.android.gms.internal.ads.zzamq
    public final void zzb(zzadd zzaddVar, zzaoe zzaoeVar) {
        zzaoeVar.zza();
        this.zzi = zzaoeVar.zzc();
        zzaem zzaemVarZzu = zzaddVar.zzu(zzaoeVar.zzb(), 2);
        this.zzj = zzaemVarZzu;
        this.zzg = new zzamu(zzaemVarZzu);
        this.zzb.zza(zzaddVar, zzaoeVar);
    }

    @Override // com.google.android.gms.internal.ads.zzamq
    public final void zzc(long j, int i2) {
        this.zzl = j;
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0185  */
    @Override // com.google.android.gms.internal.ads.zzamq
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void zzd(com.google.android.gms.internal.ads.zzeg r19) {
        /*
            Method dump skipped, instruction units count: 480
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzamv.zzd(com.google.android.gms.internal.ads.zzeg):void");
    }

    @Override // com.google.android.gms.internal.ads.zzamq
    public final void zze(boolean z2) {
        zzamu zzamuVar = this.zzg;
        zzamuVar.getClass();
        if (z2) {
            zzamuVar.zzd(this.zzh, 0, this.zzk);
            this.zzg.zza();
        }
    }
}
