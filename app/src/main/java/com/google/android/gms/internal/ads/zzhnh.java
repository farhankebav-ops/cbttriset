package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECParameterSpec;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final /* synthetic */ class zzhnh implements zzheq {
    static final /* synthetic */ zzhnh zza = new zzhnh();

    private /* synthetic */ zzhnh() {
    }

    @Override // com.google.android.gms.internal.ads.zzheq
    public final /* synthetic */ zzgvt zza(zzgwj zzgwjVar, Integer num) throws GeneralSecurityException {
        zzhnb zzhnbVar = (zzhnb) zzgwjVar;
        int i2 = zzhnj.zza;
        ECParameterSpec eCParameterSpecZza = zzhnbVar.zzd().zza();
        KeyPairGenerator keyPairGenerator = (KeyPairGenerator) zzhrz.zze.zzb("EC");
        keyPairGenerator.initialize(eCParameterSpecZza);
        KeyPair keyPairGenerateKeyPair = keyPairGenerator.generateKeyPair();
        ECPublicKey eCPublicKey = (ECPublicKey) keyPairGenerateKeyPair.getPublic();
        ECPrivateKey eCPrivateKey = (ECPrivateKey) keyPairGenerateKeyPair.getPrivate();
        zzhne zzhneVar = new zzhne(null);
        zzhneVar.zza(zzhnbVar);
        zzhneVar.zzc(num);
        zzhneVar.zzb(eCPublicKey.getW());
        zzhnf zzhnfVarZzd = zzhneVar.zzd();
        zzhnc zzhncVar = new zzhnc(null);
        zzhncVar.zza(zzhnfVarZzd);
        zzhncVar.zzb(zzhta.zza(eCPrivateKey.getS(), zzgvr.zza()));
        return zzhncVar.zzc();
    }
}
