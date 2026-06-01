package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzhih implements zzgwi {
    private zzhih(zzgwi zzgwiVar, zzhlt zzhltVar, byte[] bArr) {
    }

    public static zzgwi zza(zzhei zzheiVar) throws GeneralSecurityException {
        byte[] bArrZzc;
        zzhfw zzhfwVarZzc = zzheiVar.zzc(zzgvr.zza());
        zzgwi zzgwiVar = (zzgwi) zzhdw.zza().zzc(zzhfwVarZzc.zzg(), zzgwi.class).zza(zzhfwVarZzc.zzb());
        zzhlt zzhltVarZzd = zzhfwVarZzc.zzd();
        int iOrdinal = zzhltVarZzd.ordinal();
        if (iOrdinal == 1) {
            bArrZzc = zzhfc.zzb(zzheiVar.zzb().intValue()).zzc();
        } else if (iOrdinal == 2) {
            bArrZzc = zzhfc.zza(zzheiVar.zzb().intValue()).zzc();
        } else if (iOrdinal != 3) {
            if (iOrdinal != 4) {
                throw new GeneralSecurityException("unknown output prefix type");
            }
            bArrZzc = zzhfc.zza(zzheiVar.zzb().intValue()).zzc();
        } else {
            bArrZzc = zzhfc.zza.zzc();
        }
        return new zzhih(zzgwiVar, zzhltVarZzd, bArrZzc);
    }
}
