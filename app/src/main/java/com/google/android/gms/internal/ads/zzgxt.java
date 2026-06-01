package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final /* synthetic */ class zzgxt implements zzheq {
    static final /* synthetic */ zzgxt zza = new zzgxt();

    private /* synthetic */ zzgxt() {
    }

    @Override // com.google.android.gms.internal.ads.zzheq
    public final /* synthetic */ zzgvt zza(zzgwj zzgwjVar, Integer num) throws GeneralSecurityException {
        zzgxx zzgxxVar = (zzgxx) zzgwjVar;
        int i2 = zzgxu.zza;
        if (zzgxxVar.zzc() == 24) {
            throw new GeneralSecurityException("192 bit AES GCM Parameters are not valid");
        }
        zzgxq zzgxqVar = new zzgxq(null);
        zzgxqVar.zza(zzgxxVar);
        zzgxqVar.zzc(num);
        zzgxqVar.zzb(zzhtb.zzb(zzgxxVar.zzc()));
        return zzgxqVar.zzd();
    }
}
