package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.zip.Inflater;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzalp implements zzaki {
    private final zzeg zza = new zzeg();
    private final zzeg zzb = new zzeg();
    private final zzalo zzc;

    @Nullable
    private Inflater zzd;

    public zzalp(List list) {
        zzalo zzaloVar = new zzalo();
        this.zzc = zzaloVar;
        zzaloVar.zza(new String((byte[]) list.get(0), StandardCharsets.UTF_8));
    }

    @Override // com.google.android.gms.internal.ads.zzaki
    public final void zza(byte[] bArr, int i2, int i8, zzakh zzakhVar, zzdg zzdgVar) {
        zzeg zzegVar = this.zza;
        zzegVar.zzb(bArr, i8 + i2);
        zzegVar.zzh(i2);
        if (this.zzd == null) {
            this.zzd = new Inflater();
        }
        zzeg zzegVar2 = this.zzb;
        if (zzep.zzM(zzegVar, zzegVar2, this.zzd)) {
            zzegVar.zzb(zzegVar2.zzi(), zzegVar2.zze());
        }
        zzalo zzaloVar = this.zzc;
        zzaloVar.zzd();
        int iZzd = zzegVar.zzd();
        zzcm zzcmVarZzc = null;
        if (iZzd >= 2 && zzegVar.zzt() == iZzd) {
            zzaloVar.zzb(zzegVar);
            zzcmVarZzc = zzaloVar.zzc(zzegVar);
        }
        zzdgVar.zza(new zzaka(zzcmVarZzc != null ? zzgpe.zzj(zzcmVarZzc) : zzgpe.zzi(), -9223372036854775807L, 5000000L));
    }
}
