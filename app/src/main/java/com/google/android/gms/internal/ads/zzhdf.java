package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzhdf extends zzhde {
    private final long[] zzd;

    public zzhdf() {
        super(new long[10], new long[10], new long[10]);
        this.zzd = new long[10];
    }

    @Override // com.google.android.gms.internal.ads.zzhde
    public final void zza(long[] jArr, long[] jArr2) {
        zzhdq.zze(jArr, jArr2, this.zzd);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzhdf(zzhdi zzhdiVar) {
        super(new long[10], new long[10], new long[10]);
        long[] jArr = new long[10];
        this.zzd = jArr;
        long[] jArr2 = this.zza;
        zzhdh zzhdhVar = zzhdiVar.zza;
        zzhdq.zza(jArr2, zzhdhVar.zzb, zzhdhVar.zza);
        long[] jArr3 = this.zzb;
        zzhdh zzhdhVar2 = zzhdiVar.zza;
        zzhdq.zzb(jArr3, zzhdhVar2.zzb, zzhdhVar2.zza);
        System.arraycopy(zzhdiVar.zza.zzc, 0, jArr, 0, 10);
        zzhdq.zze(this.zzc, zzhdiVar.zzb, zzhdl.zzb);
    }
}
