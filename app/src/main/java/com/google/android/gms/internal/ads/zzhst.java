package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.NoSuchProviderException;
import java.security.interfaces.RSAPrivateCrtKey;
import java.security.spec.RSAPrivateCrtKeySpec;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzhst implements zzgwl {
    private static final byte[] zza = new byte[0];
    private static final byte[] zzb = {0};

    public static zzgwl zzb(zzhph zzhphVar) throws GeneralSecurityException {
        try {
            return zzhrc.zzb(zzhphVar);
        } catch (NoSuchProviderException unused) {
            RSAPrivateCrtKey rSAPrivateCrtKey = (RSAPrivateCrtKey) ((KeyFactory) zzhrz.zzf.zzb("RSA")).generatePrivate(new RSAPrivateCrtKeySpec(zzhphVar.zze().zzd(), zzhphVar.zzd().zzd(), zzhphVar.zzh().zzb(zzgvr.zza()), zzhphVar.zzf().zzb(zzgvr.zza()), zzhphVar.zzg().zzb(zzgvr.zza()), zzhphVar.zzi().zzb(zzgvr.zza()), zzhphVar.zzj().zzb(zzgvr.zza()), zzhphVar.zzk().zzb(zzgvr.zza())));
            zzhpf zzhpfVarZzd = zzhphVar.zzd();
            zzhdp zzhdpVar = zzhsv.zza;
            return new zzhss(rSAPrivateCrtKey, (zzhsi) zzhdpVar.zzb(zzhpfVarZzd.zzf()), (zzhsi) zzhdpVar.zzb(zzhpfVarZzd.zzg()), zzhpfVarZzd.zzh(), zzhphVar.zze().zze().zzc(), zzhphVar.zzd().zze().equals(zzhpe.zzc) ? zzb : zza, null);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgwl
    public final byte[] zza(byte[] bArr) throws GeneralSecurityException {
        throw null;
    }
}
