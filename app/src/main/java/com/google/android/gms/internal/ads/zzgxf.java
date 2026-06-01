package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzgxf implements zzhfv {
    private static final zzgxf zza = new zzgxf();
    private static final zzhfp zzb = zzhfp.zzd(zzgxd.zza, zzhei.class, zzgvm.class);

    public static void zzc() throws GeneralSecurityException {
        zzhey.zza().zzc(zza);
        zzhey.zza().zzb(zzb);
    }

    public static void zzd(zzhfq zzhfqVar) throws GeneralSecurityException {
        zzhfqVar.zzb(zza);
    }

    @Override // com.google.android.gms.internal.ads.zzhfv
    public final Class zza() {
        return zzgvm.class;
    }

    @Override // com.google.android.gms.internal.ads.zzhfv
    public final Class zzb() {
        return zzgvm.class;
    }

    @Override // com.google.android.gms.internal.ads.zzhfv
    public final /* bridge */ /* synthetic */ Object zze(zzhed zzhedVar, zzhel zzhelVar, zzhfu zzhfuVar) throws GeneralSecurityException {
        zzhem zzhemVar;
        zzhem zzhemVarZza;
        zzhsz zzhszVarZzd;
        zzhfk zzhfkVar = new zzhfk();
        for (int i2 = 0; i2 < zzhedVar.zzd(); i2++) {
            zzgwc zzgwcVarZze = ((zzgwe) zzhedVar).zze(i2);
            if (zzgwcVarZze.zzb().equals(zzgvv.zza)) {
                zzgvt zzgvtVarZza = zzgwcVarZze.zza();
                if (zzgvtVarZza instanceof zzgxa) {
                    zzhszVarZzd = ((zzgxa) zzgvtVarZza).zzc();
                } else {
                    if (!(zzgvtVarZza instanceof zzhei)) {
                        String name = zzgvtVarZza.getClass().getName();
                        String strValueOf = String.valueOf(zzgvtVarZza.zza());
                        throw new GeneralSecurityException(androidx.camera.core.processing.util.a.n(new StringBuilder(name.length() + 59 + strValueOf.length()), "Cannot get output prefix for key of class ", name, " with parameters ", strValueOf));
                    }
                    zzhszVarZzd = ((zzhei) zzgvtVarZza).zzd();
                }
                zzhfkVar.zza(zzhszVarZzd, new zzgxc((zzgvm) zzhfuVar.zza(zzgwcVarZze), zzgwcVarZze.zzc()));
            }
        }
        if (zzhelVar.zza()) {
            zzhemVar = zzhep.zza;
            zzhemVarZza = zzhemVar;
        } else {
            zzhen zzhenVarZzb = zzhew.zza().zzb();
            zzhem zzhemVarZza2 = zzhenVarZzb.zza(zzhedVar, zzhelVar, "aead", "encrypt");
            zzhemVarZza = zzhenVarZzb.zza(zzhedVar, zzhelVar, "aead", "decrypt");
            zzhemVar = zzhemVarZza2;
        }
        zzgwe zzgweVar = (zzgwe) zzhedVar;
        return new zzgxe(new zzgxc((zzgvm) zzhfuVar.zza(zzgweVar.zzc()), zzgweVar.zzc().zzc()), zzhfkVar.zzb(), zzhemVar, zzhemVarZza, null);
    }
}
