package com.google.android.gms.internal.ads;

import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.spec.ECPoint;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzhpy {
    public static final /* synthetic */ int zza = 0;
    private static final zzhsz zzb;
    private static final zzhsz zzc;
    private static final zzhfi zzd;
    private static final zzhff zze;
    private static final zzhec zzf;
    private static final zzhdz zzg;
    private static final zzhec zzh;
    private static final zzhdz zzi;

    static {
        zzhsz zzhszVarZza = zzhgi.zza("type.googleapis.com/google.crypto.tink.EcdsaPrivateKey");
        zzb = zzhszVarZza;
        zzhsz zzhszVarZza2 = zzhgi.zza("type.googleapis.com/google.crypto.tink.EcdsaPublicKey");
        zzc = zzhszVarZza2;
        zzd = zzhfi.zzd(zzhpx.zza, zzhnb.class, zzhfx.class);
        zze = zzhff.zzd(zzhps.zza, zzhszVarZza, zzhfx.class);
        zzf = zzhec.zzd(zzhpt.zza, zzhnf.class, zzhfw.class);
        zzg = zzhdz.zzd(zzhpu.zza, zzhszVarZza2, zzhfw.class);
        zzh = zzhec.zzd(zzhpv.zza, zzhnd.class, zzhfw.class);
        zzi = zzhdz.zzd(zzhpw.zza, zzhszVarZza, zzhfw.class);
    }

    public static void zza(zzhfb zzhfbVar) throws GeneralSecurityException {
        zzhfbVar.zzd(zzd);
        zzhfbVar.zze(zze);
        zzhfbVar.zzb(zzf);
        zzhfbVar.zzc(zzg);
        zzhfbVar.zzb(zzh);
        zzhfbVar.zzc(zzi);
    }

    public static /* synthetic */ zzhfx zzb(zzhnb zzhnbVar) {
        zzhkz zzhkzVarZze = zzhla.zze();
        zzhkzVarZze.zza("type.googleapis.com/google.crypto.tink.EcdsaPrivateKey");
        zzhjy zzhjyVarZzc = zzhjz.zzc();
        zzhjyVarZzc.zza(zzl(zzhnbVar));
        zzhkzVarZze.zzb(((zzhjz) zzhjyVarZzc.zzbu()).zzaM());
        zzhkzVarZze.zzc(zzh(zzhnbVar.zzf()));
        return zzhfx.zza((zzhla) zzhkzVarZze.zzbu());
    }

    public static /* synthetic */ zzhnb zzc(zzhfx zzhfxVar) throws GeneralSecurityException {
        if (!zzhfxVar.zzc().zza().equals("type.googleapis.com/google.crypto.tink.EcdsaPrivateKey")) {
            throw new IllegalArgumentException("Wrong type URL in call to EcdsaProtoSerialization.parseParameters: ".concat(String.valueOf(zzhfxVar.zzc().zza())));
        }
        try {
            zzhjz zzhjzVarZzb = zzhjz.zzb(zzhfxVar.zzc().zzb(), zzhvy.zza());
            zzhmw zzhmwVarZzb = zzhnb.zzb();
            zzhmwVarZzb.zzc(zzi(zzhjzVarZzb.zza().zza()));
            zzhmwVarZzb.zza(zzo(zzhjzVarZzb.zza().zzh()));
            zzhmwVarZzb.zzb(zzn(zzhjzVarZzb.zza().zzg()));
            zzhmwVarZzb.zzd(zzj(zzhfxVar.zzc().zzc()));
            return zzhmwVarZzb.zze();
        } catch (zzhxd e) {
            throw new GeneralSecurityException("Parsing EcdsaParameters failed: ", e);
        }
    }

    public static /* synthetic */ zzhnf zze(zzhfw zzhfwVar, zzgwn zzgwnVar) throws GeneralSecurityException {
        if (!zzhfwVar.zzg().equals("type.googleapis.com/google.crypto.tink.EcdsaPublicKey")) {
            throw new IllegalArgumentException("Wrong type URL in call to EcdsaProtoSerialization.parsePublicKey: ".concat(String.valueOf(zzhfwVar.zzg())));
        }
        try {
            zzhkf zzhkfVarZze = zzhkf.zze(zzhfwVar.zzb(), zzhvy.zza());
            if (zzhkfVarZze.zza() != 0) {
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            }
            zzhmw zzhmwVarZzb = zzhnb.zzb();
            zzhmwVarZzb.zzc(zzi(zzhkfVarZze.zzb().zza()));
            zzhmwVarZzb.zza(zzo(zzhkfVarZze.zzb().zzh()));
            zzhmwVarZzb.zzb(zzn(zzhkfVarZze.zzb().zzg()));
            zzhmwVarZzb.zzd(zzj(zzhfwVar.zzd()));
            zzhnb zzhnbVarZze = zzhmwVarZzb.zze();
            zzhne zzhneVarZzc = zzhnf.zzc();
            zzhneVarZzc.zza(zzhnbVarZze);
            zzhneVarZzc.zzb(new ECPoint(new BigInteger(1, zzhkfVarZze.zzc().zzv()), new BigInteger(1, zzhkfVarZze.zzd().zzv())));
            zzhneVarZzc.zzc(zzhfwVar.zze());
            return zzhneVarZzc.zzd();
        } catch (zzhxd | IllegalArgumentException unused) {
            throw new GeneralSecurityException("Parsing EcdsaPublicKey failed");
        }
    }

    public static /* synthetic */ zzhfw zzf(zzhnd zzhndVar, zzgwn zzgwnVar) throws GeneralSecurityException {
        int iZzk = zzk(zzhndVar.zzd().zzd());
        zzhkc zzhkcVarZze = zzhkd.zze();
        zzhkcVarZze.zza(zzm(zzhndVar.zze()));
        byte[] bArrZzb = zzhdb.zzb(zzhndVar.zzf().zzb(zzgwnVar), iZzk);
        zzhvi zzhviVar = zzhvi.zzb;
        zzhkcVarZze.zzb(zzhvi.zzr(bArrZzb, 0, bArrZzb.length));
        return zzhfw.zza("type.googleapis.com/google.crypto.tink.EcdsaPrivateKey", ((zzhkd) zzhkcVarZze.zzbu()).zzaM(), zzhkw.ASYMMETRIC_PRIVATE, zzh(zzhndVar.zzd().zzf()), zzhndVar.zze().zzb());
    }

    public static /* synthetic */ zzhnd zzg(zzhfw zzhfwVar, zzgwn zzgwnVar) throws GeneralSecurityException {
        if (!zzhfwVar.zzg().equals("type.googleapis.com/google.crypto.tink.EcdsaPrivateKey")) {
            throw new IllegalArgumentException("Wrong type URL in call to EcdsaProtoSerialization.parsePrivateKey: ".concat(String.valueOf(zzhfwVar.zzg())));
        }
        try {
            zzhkd zzhkdVarZzd = zzhkd.zzd(zzhfwVar.zzb(), zzhvy.zza());
            if (zzhkdVarZzd.zza() != 0) {
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            }
            zzhkf zzhkfVarZzb = zzhkdVarZzd.zzb();
            if (zzhkfVarZzb.zza() != 0) {
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            }
            zzhmw zzhmwVarZzb = zzhnb.zzb();
            zzhmwVarZzb.zzc(zzi(zzhkfVarZzb.zzb().zza()));
            zzhmwVarZzb.zza(zzo(zzhkfVarZzb.zzb().zzh()));
            zzhmwVarZzb.zzb(zzn(zzhkfVarZzb.zzb().zzg()));
            zzhmwVarZzb.zzd(zzj(zzhfwVar.zzd()));
            zzhnb zzhnbVarZze = zzhmwVarZzb.zze();
            zzhne zzhneVarZzc = zzhnf.zzc();
            zzhneVarZzc.zza(zzhnbVarZze);
            zzhneVarZzc.zzb(new ECPoint(new BigInteger(1, zzhkfVarZzb.zzc().zzv()), new BigInteger(1, zzhkfVarZzb.zzd().zzv())));
            zzhneVarZzc.zzc(zzhfwVar.zze());
            zzhnf zzhnfVarZzd = zzhneVarZzc.zzd();
            zzhnc zzhncVarZzc = zzhnd.zzc();
            zzhncVarZzc.zza(zzhnfVarZzd);
            zzhncVarZzc.zzb(zzhta.zza(new BigInteger(1, zzhkdVarZzd.zzc().zzv()), zzgwnVar));
            return zzhncVarZzc.zzc();
        } catch (zzhxd | IllegalArgumentException unused) {
            throw new GeneralSecurityException("Parsing EcdsaPrivateKey failed");
        }
    }

    private static zzhlt zzh(zzhna zzhnaVar) throws GeneralSecurityException {
        if (zzhna.zza.equals(zzhnaVar)) {
            return zzhlt.TINK;
        }
        if (zzhna.zzb.equals(zzhnaVar)) {
            return zzhlt.CRUNCHY;
        }
        if (zzhna.zzd.equals(zzhnaVar)) {
            return zzhlt.RAW;
        }
        if (zzhna.zzc.equals(zzhnaVar)) {
            return zzhlt.LEGACY;
        }
        throw new GeneralSecurityException("Unable to serialize variant: ".concat(zzhnaVar.toString()));
    }

    private static zzhmy zzi(zzhko zzhkoVar) throws GeneralSecurityException {
        int iOrdinal = zzhkoVar.ordinal();
        if (iOrdinal == 2) {
            return zzhmy.zzb;
        }
        if (iOrdinal == 3) {
            return zzhmy.zza;
        }
        if (iOrdinal == 4) {
            return zzhmy.zzc;
        }
        int iZza = zzhkoVar.zza();
        throw new GeneralSecurityException(androidx.camera.core.processing.util.a.m(new StringBuilder(String.valueOf(iZza).length() + 26), "Unable to parse HashType: ", iZza));
    }

    private static zzhna zzj(zzhlt zzhltVar) throws GeneralSecurityException {
        int iOrdinal = zzhltVar.ordinal();
        if (iOrdinal == 1) {
            return zzhna.zza;
        }
        if (iOrdinal == 2) {
            return zzhna.zzc;
        }
        if (iOrdinal == 3) {
            return zzhna.zzd;
        }
        if (iOrdinal == 4) {
            return zzhna.zzb;
        }
        int iZza = zzhltVar.zza();
        throw new GeneralSecurityException(androidx.camera.core.processing.util.a.m(new StringBuilder(String.valueOf(iZza).length() + 34), "Unable to parse OutputPrefixType: ", iZza));
    }

    private static int zzk(zzhmx zzhmxVar) throws GeneralSecurityException {
        if (zzhmx.zza.equals(zzhmxVar)) {
            return 33;
        }
        if (zzhmx.zzb.equals(zzhmxVar)) {
            return 49;
        }
        if (zzhmx.zzc.equals(zzhmxVar)) {
            return 67;
        }
        throw new GeneralSecurityException("Unable to serialize CurveType ".concat(zzhmxVar.toString()));
    }

    private static zzhkb zzl(zzhnb zzhnbVar) throws GeneralSecurityException {
        zzhko zzhkoVar;
        int i2;
        zzhka zzhkaVarZzb = zzhkb.zzb();
        zzhmy zzhmyVarZze = zzhnbVar.zze();
        if (zzhmy.zza.equals(zzhmyVarZze)) {
            zzhkoVar = zzhko.SHA256;
        } else if (zzhmy.zzb.equals(zzhmyVarZze)) {
            zzhkoVar = zzhko.SHA384;
        } else {
            if (!zzhmy.zzc.equals(zzhmyVarZze)) {
                throw new GeneralSecurityException("Unable to serialize HashType ".concat(zzhmyVarZze.toString()));
            }
            zzhkoVar = zzhko.SHA512;
        }
        zzhkaVarZzb.zza(zzhkoVar);
        zzhmx zzhmxVarZzd = zzhnbVar.zzd();
        int i8 = 4;
        if (zzhmx.zza.equals(zzhmxVarZzd)) {
            i2 = 4;
        } else if (zzhmx.zzb.equals(zzhmxVarZzd)) {
            i2 = 5;
        } else {
            if (!zzhmx.zzc.equals(zzhmxVarZzd)) {
                throw new GeneralSecurityException("Unable to serialize CurveType ".concat(zzhmxVarZzd.toString()));
            }
            i2 = 6;
        }
        zzhkaVarZzb.zzb(i2);
        zzhmz zzhmzVarZzc = zzhnbVar.zzc();
        if (zzhmz.zza.equals(zzhmzVarZzc)) {
            i8 = 3;
        } else if (!zzhmz.zzb.equals(zzhmzVarZzc)) {
            throw new GeneralSecurityException("Unable to serialize SignatureEncoding ".concat(zzhmzVarZzc.toString()));
        }
        zzhkaVarZzb.zzc(i8);
        return (zzhkb) zzhkaVarZzb.zzbu();
    }

    private static zzhkf zzm(zzhnf zzhnfVar) throws GeneralSecurityException {
        int iZzk = zzk(zzhnfVar.zzf().zzd());
        ECPoint eCPointZzd = zzhnfVar.zzd();
        zzhke zzhkeVarZzg = zzhkf.zzg();
        zzhkeVarZzg.zza(zzl(zzhnfVar.zzf()));
        byte[] bArrZzb = zzhdb.zzb(eCPointZzd.getAffineX(), iZzk);
        zzhvi zzhviVar = zzhvi.zzb;
        zzhkeVarZzg.zzb(zzhvi.zzr(bArrZzb, 0, bArrZzb.length));
        byte[] bArrZzb2 = zzhdb.zzb(eCPointZzd.getAffineY(), iZzk);
        zzhkeVarZzg.zzc(zzhvi.zzr(bArrZzb2, 0, bArrZzb2.length));
        return (zzhkf) zzhkeVarZzg.zzbu();
    }

    private static zzhmx zzn(int i2) throws GeneralSecurityException {
        int i8 = i2 - 2;
        if (i8 == 2) {
            return zzhmx.zza;
        }
        if (i8 == 3) {
            return zzhmx.zzb;
        }
        if (i8 == 4) {
            return zzhmx.zzc;
        }
        int iZza = zzhkn.zza(i2);
        throw new GeneralSecurityException(androidx.camera.core.processing.util.a.m(new StringBuilder(String.valueOf(iZza).length() + 35), "Unable to parse EllipticCurveType: ", iZza));
    }

    private static zzhmz zzo(int i2) throws GeneralSecurityException {
        int i8 = i2 - 2;
        if (i8 == 1) {
            return zzhmz.zza;
        }
        if (i8 == 2) {
            return zzhmz.zzb;
        }
        int iZza = zzhkg.zza(i2);
        throw new GeneralSecurityException(androidx.camera.core.processing.util.a.m(new StringBuilder(String.valueOf(iZza).length() + 40), "Unable to parse EcdsaSignatureEncoding: ", iZza));
    }
}
