package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzhbb {
    public static final /* synthetic */ int zza = 0;
    private static final zzhsz zzb;
    private static final zzhfi zzc;
    private static final zzhff zzd;
    private static final zzhec zze;
    private static final zzhdz zzf;

    static {
        zzhsz zzhszVarZza = zzhgi.zza("type.googleapis.com/google.crypto.tink.AesEaxKey");
        zzb = zzhszVarZza;
        zzc = zzhfi.zzd(zzhba.zza, zzgxx.class, zzhfx.class);
        zzd = zzhff.zzd(zzhax.zza, zzhszVarZza, zzhfx.class);
        zze = zzhec.zzd(zzhay.zza, zzgxr.class, zzhfw.class);
        zzf = zzhdz.zzd(zzhaz.zza, zzhszVarZza, zzhfw.class);
    }

    public static void zza(zzhfb zzhfbVar) throws GeneralSecurityException {
        zzhfbVar.zzd(zzc);
        zzhfbVar.zze(zzd);
        zzhfbVar.zzb(zze);
        zzhfbVar.zzc(zzf);
    }

    public static /* synthetic */ zzhfx zzb(zzgxx zzgxxVar) {
        zzhkz zzhkzVarZze = zzhla.zze();
        zzhkzVarZze.zza("type.googleapis.com/google.crypto.tink.AesEaxKey");
        zzhji zzhjiVarZzd = zzhjj.zzd();
        zzhjiVarZzd.zza(zzh(zzgxxVar));
        zzhjiVarZzd.zzb(zzgxxVar.zzc());
        zzhkzVarZze.zzb(((zzhjj) zzhjiVarZzd.zzbu()).zzaM());
        zzhkzVarZze.zzc(zzf(zzgxxVar.zze()));
        return zzhfx.zza((zzhla) zzhkzVarZze.zzbu());
    }

    public static /* synthetic */ zzgxx zzc(zzhfx zzhfxVar) throws GeneralSecurityException {
        if (!zzhfxVar.zzc().zza().equals("type.googleapis.com/google.crypto.tink.AesEaxKey")) {
            throw new IllegalArgumentException("Wrong type URL in call to AesEaxProtoSerialization.parseParameters: ".concat(String.valueOf(zzhfxVar.zzc().zza())));
        }
        try {
            zzhjj zzhjjVarZzc = zzhjj.zzc(zzhfxVar.zzc().zzb(), zzhvy.zza());
            zzgxv zzgxvVarZzb = zzgxx.zzb();
            zzgxvVarZzb.zza(zzhjjVarZzc.zzb());
            zzgxvVarZzb.zzb(zzhjjVarZzc.zza().zza());
            zzgxvVarZzb.zzc(16);
            zzgxvVarZzb.zzd(zzg(zzhfxVar.zzc().zzc()));
            return zzgxvVarZzb.zze();
        } catch (zzhxd e) {
            throw new GeneralSecurityException("Parsing AesEaxParameters failed: ", e);
        }
    }

    public static /* synthetic */ zzhfw zzd(zzgxr zzgxrVar, zzgwn zzgwnVar) {
        zzhjg zzhjgVarZze = zzhjh.zze();
        zzhjgVarZze.zza(zzh(zzgxrVar.zzf()));
        byte[] bArrZzc = zzgxrVar.zze().zzc(zzgwnVar);
        zzhjgVarZze.zzb(zzhvi.zzr(bArrZzc, 0, bArrZzc.length));
        return zzhfw.zza("type.googleapis.com/google.crypto.tink.AesEaxKey", ((zzhjh) zzhjgVarZze.zzbu()).zzaM(), zzhkw.SYMMETRIC, zzf(zzgxrVar.zzf().zze()), zzgxrVar.zzb());
    }

    public static /* synthetic */ zzgxr zze(zzhfw zzhfwVar, zzgwn zzgwnVar) throws GeneralSecurityException {
        if (!zzhfwVar.zzg().equals("type.googleapis.com/google.crypto.tink.AesEaxKey")) {
            throw new IllegalArgumentException("Wrong type URL in call to AesEaxProtoSerialization.parseKey");
        }
        try {
            zzhjh zzhjhVarZzd = zzhjh.zzd(zzhfwVar.zzb(), zzhvy.zza());
            if (zzhjhVarZzd.zza() != 0) {
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            }
            zzgxv zzgxvVarZzb = zzgxx.zzb();
            zzgxvVarZzb.zza(zzhjhVarZzd.zzc().zzc());
            zzgxvVarZzb.zzb(zzhjhVarZzd.zzb().zza());
            zzgxvVarZzb.zzc(16);
            zzgxvVarZzb.zzd(zzg(zzhfwVar.zzd()));
            zzgxx zzgxxVarZze = zzgxvVarZzb.zze();
            zzgxq zzgxqVarZzd = zzgxr.zzd();
            zzgxqVarZzd.zza(zzgxxVarZze);
            zzgxqVarZzd.zzb(zzhtb.zza(zzhjhVarZzd.zzc().zzv(), zzgwnVar));
            zzgxqVarZzd.zzc(zzhfwVar.zze());
            return zzgxqVarZzd.zzd();
        } catch (zzhxd unused) {
            throw new GeneralSecurityException("Parsing AesEaxcKey failed");
        }
    }

    private static zzhlt zzf(zzgxw zzgxwVar) throws GeneralSecurityException {
        if (zzgxw.zza.equals(zzgxwVar)) {
            return zzhlt.TINK;
        }
        if (zzgxw.zzb.equals(zzgxwVar)) {
            return zzhlt.CRUNCHY;
        }
        if (zzgxw.zzc.equals(zzgxwVar)) {
            return zzhlt.RAW;
        }
        throw new GeneralSecurityException("Unable to serialize variant: ".concat(String.valueOf(zzgxwVar)));
    }

    private static zzgxw zzg(zzhlt zzhltVar) throws GeneralSecurityException {
        int iOrdinal = zzhltVar.ordinal();
        if (iOrdinal == 1) {
            return zzgxw.zza;
        }
        if (iOrdinal != 2) {
            if (iOrdinal == 3) {
                return zzgxw.zzc;
            }
            if (iOrdinal != 4) {
                int iZza = zzhltVar.zza();
                throw new GeneralSecurityException(androidx.camera.core.processing.util.a.m(new StringBuilder(String.valueOf(iZza).length() + 34), "Unable to parse OutputPrefixType: ", iZza));
            }
        }
        return zzgxw.zzb;
    }

    private static zzhjl zzh(zzgxx zzgxxVar) throws GeneralSecurityException {
        zzhjk zzhjkVarZzb = zzhjl.zzb();
        zzhjkVarZzb.zza(zzgxxVar.zzd());
        return (zzhjl) zzhjkVarZzb.zzbu();
    }
}
