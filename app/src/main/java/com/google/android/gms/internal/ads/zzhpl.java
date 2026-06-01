package com.google.android.gms.internal.ads;

import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.interfaces.RSAPrivateCrtKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.RSAKeyGenParameterSpec;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final /* synthetic */ class zzhpl implements zzheq {
    static final /* synthetic */ zzhpl zza = new zzhpl();

    private /* synthetic */ zzhpl() {
    }

    @Override // com.google.android.gms.internal.ads.zzheq
    public final /* synthetic */ zzgvt zza(zzgwj zzgwjVar, Integer num) throws GeneralSecurityException {
        zzhpf zzhpfVar = (zzhpf) zzgwjVar;
        int i2 = zzhpn.zza;
        KeyPairGenerator keyPairGenerator = (KeyPairGenerator) zzhrz.zze.zzb("RSA");
        keyPairGenerator.initialize(new RSAKeyGenParameterSpec(zzhpfVar.zzc(), new BigInteger(1, zzhpfVar.zzd().toByteArray())));
        KeyPair keyPairGenerateKeyPair = keyPairGenerator.generateKeyPair();
        RSAPublicKey rSAPublicKey = (RSAPublicKey) keyPairGenerateKeyPair.getPublic();
        RSAPrivateCrtKey rSAPrivateCrtKey = (RSAPrivateCrtKey) keyPairGenerateKeyPair.getPrivate();
        zzhpi zzhpiVar = new zzhpi(null);
        zzhpiVar.zza(zzhpfVar);
        zzhpiVar.zzb(rSAPublicKey.getModulus());
        zzhpiVar.zzc(num);
        zzhpj zzhpjVarZzd = zzhpiVar.zzd();
        zzhpg zzhpgVar = new zzhpg(null);
        zzhpgVar.zza(zzhpjVarZzd);
        zzhpgVar.zzb(zzhta.zza(rSAPrivateCrtKey.getPrimeP(), zzgvr.zza()), zzhta.zza(rSAPrivateCrtKey.getPrimeQ(), zzgvr.zza()));
        zzhpgVar.zzc(zzhta.zza(rSAPrivateCrtKey.getPrivateExponent(), zzgvr.zza()));
        zzhpgVar.zzd(zzhta.zza(rSAPrivateCrtKey.getPrimeExponentP(), zzgvr.zza()), zzhta.zza(rSAPrivateCrtKey.getPrimeExponentQ(), zzgvr.zza()));
        zzhpgVar.zze(zzhta.zza(rSAPrivateCrtKey.getCrtCoefficient(), zzgvr.zza()));
        return zzhpgVar.zzf();
    }
}
