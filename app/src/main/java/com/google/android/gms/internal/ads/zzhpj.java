package com.google.android.gms.internal.ads;

import java.math.BigInteger;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzhpj extends zzhpr {
    private final zzhpf zza;
    private final BigInteger zzb;
    private final zzhsz zzc;
    private final Integer zzd;

    public /* synthetic */ zzhpj(zzhpf zzhpfVar, BigInteger bigInteger, zzhsz zzhszVar, Integer num, byte[] bArr) {
        this.zza = zzhpfVar;
        this.zzb = bigInteger;
        this.zzc = zzhszVar;
        this.zzd = num;
    }

    public static zzhpi zzc() {
        return new zzhpi(null);
    }

    @Override // com.google.android.gms.internal.ads.zzhpr, com.google.android.gms.internal.ads.zzgvt
    public final /* synthetic */ zzgwj zza() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzgvt
    public final Integer zzb() {
        return this.zzd;
    }

    public final BigInteger zzd() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzhpr
    public final zzhsz zze() {
        return this.zzc;
    }

    public final zzhpf zzf() {
        return this.zza;
    }
}
