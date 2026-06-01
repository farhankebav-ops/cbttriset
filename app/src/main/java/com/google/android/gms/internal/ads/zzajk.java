package com.google.android.gms.internal.ads;

import java.math.BigInteger;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzajk implements zzaed {
    final /* synthetic */ zzajl zza;

    public /* synthetic */ zzajk(zzajl zzajlVar, byte[] bArr) {
        Objects.requireNonNull(zzajlVar);
        this.zza = zzajlVar;
    }

    @Override // com.google.android.gms.internal.ads.zzaed
    public final long zza() {
        zzajl zzajlVar = this.zza;
        return zzajlVar.zzf().zzh(zzajlVar.zzg());
    }

    @Override // com.google.android.gms.internal.ads.zzaed
    public final boolean zzb() {
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzaed
    public final zzaeb zzc(long j) {
        zzajl zzajlVar = this.zza;
        long jZzd = zzajlVar.zzd() + BigInteger.valueOf(zzajlVar.zzf().zzi(j)).multiply(BigInteger.valueOf(zzajlVar.zze() - zzajlVar.zzd())).divide(BigInteger.valueOf(zzajlVar.zzg())).longValue();
        String str = zzep.zza;
        zzaee zzaeeVar = new zzaee(j, Math.max(zzajlVar.zzd(), Math.min(jZzd - 30000, zzajlVar.zze() - 1)));
        return new zzaeb(zzaeeVar, zzaeeVar);
    }
}
