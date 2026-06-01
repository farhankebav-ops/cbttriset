package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final /* synthetic */ class zzher implements zzheq {
    static final /* synthetic */ zzher zza = new zzher();

    private /* synthetic */ zzher() {
    }

    @Override // com.google.android.gms.internal.ads.zzheq
    public final /* synthetic */ zzgvt zza(zzgwj zzgwjVar, Integer num) throws GeneralSecurityException {
        int i2 = zzhes.zza;
        zzhla zzhlaVarZzc = ((zzhej) zzgwjVar).zzb().zzc();
        zzgvu zzgvuVarZzd = zzhdw.zza().zzd(zzhlaVarZzc.zza());
        if (!zzhdw.zza().zze(zzhlaVarZzc.zza())) {
            throw new GeneralSecurityException("Creating new keys is not allowed.");
        }
        zzhkx zzhkxVarZzd = zzgvuVarZzd.zzd(zzhlaVarZzc.zzb());
        return new zzhei(zzhfw.zza(zzhkxVarZzd.zza(), zzhkxVarZzd.zzb(), zzhkxVarZzd.zzc(), zzhlaVarZzc.zzc(), num), zzgvr.zza());
    }
}
