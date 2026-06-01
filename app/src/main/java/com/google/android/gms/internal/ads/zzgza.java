package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final /* synthetic */ class zzgza implements zzhfo {
    static final /* synthetic */ zzgza zza = new zzgza();

    private /* synthetic */ zzgza() {
    }

    @Override // com.google.android.gms.internal.ads.zzhfo
    public final /* synthetic */ Object zza(zzgvt zzgvtVar) throws GeneralSecurityException {
        zzgzl zzgzlVar = (zzgzl) zzgvtVar;
        int i2 = zzgzc.zza;
        String strZzb = zzgzlVar.zze().zzb();
        zzgxb zzgxbVarZzd = zzgzlVar.zze().zzd();
        zzgvm zzgvmVarZzb = zzgwh.zza(strZzb).zzb();
        int i8 = zzgyz.zza;
        try {
            return zzhce.zzc(new zzgyz(zzhla.zzd(zzgwp.zza(zzgxbVarZzd), zzhvy.zza()), zzgvmVarZzb), zzgzlVar.zzc());
        } catch (zzhxd e) {
            throw new GeneralSecurityException(e);
        }
    }
}
