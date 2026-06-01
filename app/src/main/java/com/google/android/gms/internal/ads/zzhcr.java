package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzhcr {
    public static final /* synthetic */ int zza = 0;
    private static final zzhsz zzb;
    private static final zzhfi zzc;
    private static final zzhff zzd;
    private static final zzhec zze;
    private static final zzhdz zzf;

    static {
        zzhsz zzhszVarZza = zzhgi.zza("type.googleapis.com/google.crypto.tink.XChaCha20Poly1305Key");
        zzb = zzhszVarZza;
        zzc = zzhfi.zzd(zzhcq.zza, zzhar.class, zzhfx.class);
        zzd = zzhff.zzd(zzhcn.zza, zzhszVarZza, zzhfx.class);
        zze = zzhec.zzd(zzhco.zza, zzhal.class, zzhfw.class);
        zzf = zzhdz.zzd(zzhcp.zza, zzhszVarZza, zzhfw.class);
    }

    public static void zza(zzhfb zzhfbVar) throws GeneralSecurityException {
        zzhfbVar.zzd(zzc);
        zzhfbVar.zze(zzd);
        zzhfbVar.zzb(zze);
        zzhfbVar.zzc(zzf);
    }

    public static /* synthetic */ zzhfx zzb(zzhar zzharVar) {
        zzhkz zzhkzVarZze = zzhla.zze();
        zzhkzVarZze.zza("type.googleapis.com/google.crypto.tink.XChaCha20Poly1305Key");
        zzhkzVarZze.zzb(zzhmv.zzc().zzaM());
        zzhkzVarZze.zzc(zzf(zzharVar.zzc()));
        return zzhfx.zza((zzhla) zzhkzVarZze.zzbu());
    }

    public static /* synthetic */ zzhar zzc(zzhfx zzhfxVar) throws GeneralSecurityException {
        if (!zzhfxVar.zzc().zza().equals("type.googleapis.com/google.crypto.tink.XChaCha20Poly1305Key")) {
            throw new IllegalArgumentException("Wrong type URL in call to XChaCha20Poly1305ProtoSerialization.parseParameters: ".concat(String.valueOf(zzhfxVar.zzc().zza())));
        }
        try {
            if (zzhmv.zzb(zzhfxVar.zzc().zzb(), zzhvy.zza()).zza() == 0) {
                return zzhar.zzb(zzg(zzhfxVar.zzc().zzc()));
            }
            throw new GeneralSecurityException("Only version 0 parameters are accepted");
        } catch (zzhxd e) {
            throw new GeneralSecurityException("Parsing XChaCha20Poly1305Parameters failed: ", e);
        }
    }

    public static /* synthetic */ zzhfw zzd(zzhal zzhalVar, zzgwn zzgwnVar) {
        zzhms zzhmsVarZzd = zzhmt.zzd();
        byte[] bArrZzc = zzhalVar.zze().zzc(zzgwnVar);
        zzhmsVarZzd.zza(zzhvi.zzr(bArrZzc, 0, bArrZzc.length));
        return zzhfw.zza("type.googleapis.com/google.crypto.tink.XChaCha20Poly1305Key", ((zzhmt) zzhmsVarZzd.zzbu()).zzaM(), zzhkw.SYMMETRIC, zzf(zzhalVar.zzf().zzc()), zzhalVar.zzb());
    }

    public static /* synthetic */ zzhal zze(zzhfw zzhfwVar, zzgwn zzgwnVar) throws GeneralSecurityException {
        if (!zzhfwVar.zzg().equals("type.googleapis.com/google.crypto.tink.XChaCha20Poly1305Key")) {
            throw new IllegalArgumentException("Wrong type URL in call to XChaCha20Poly1305ProtoSerialization.parseKey");
        }
        try {
            zzhmt zzhmtVarZzc = zzhmt.zzc(zzhfwVar.zzb(), zzhvy.zza());
            if (zzhmtVarZzc.zza() == 0) {
                return zzhal.zzd(zzg(zzhfwVar.zzd()), zzhtb.zza(zzhmtVarZzc.zzb().zzv(), zzgwnVar), zzhfwVar.zze());
            }
            throw new GeneralSecurityException("Only version 0 keys are accepted");
        } catch (zzhxd unused) {
            throw new GeneralSecurityException("Parsing XChaCha20Poly1305Key failed");
        }
    }

    private static zzhlt zzf(zzhaq zzhaqVar) throws GeneralSecurityException {
        if (zzhaq.zza.equals(zzhaqVar)) {
            return zzhlt.TINK;
        }
        if (zzhaq.zzb.equals(zzhaqVar)) {
            return zzhlt.CRUNCHY;
        }
        if (zzhaq.zzc.equals(zzhaqVar)) {
            return zzhlt.RAW;
        }
        throw new GeneralSecurityException("Unable to serialize variant: ".concat(zzhaqVar.toString()));
    }

    private static zzhaq zzg(zzhlt zzhltVar) throws GeneralSecurityException {
        int iOrdinal = zzhltVar.ordinal();
        if (iOrdinal == 1) {
            return zzhaq.zza;
        }
        if (iOrdinal != 2) {
            if (iOrdinal == 3) {
                return zzhaq.zzc;
            }
            if (iOrdinal != 4) {
                int iZza = zzhltVar.zza();
                throw new GeneralSecurityException(androidx.camera.core.processing.util.a.m(new StringBuilder(String.valueOf(iZza).length() + 34), "Unable to parse OutputPrefixType: ", iZza));
            }
        }
        return zzhaq.zzb;
    }
}
