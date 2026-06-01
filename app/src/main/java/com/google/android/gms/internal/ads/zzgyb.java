package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final /* synthetic */ class zzgyb implements zzheq {
    static final /* synthetic */ zzgyb zza = new zzgyb();

    private /* synthetic */ zzgyb() {
    }

    @Override // com.google.android.gms.internal.ads.zzheq
    public final /* synthetic */ zzgvt zza(zzgwj zzgwjVar, Integer num) throws GeneralSecurityException {
        zzgyg zzgygVar = (zzgyg) zzgwjVar;
        int i2 = zzgyd.zza;
        if (zzgygVar.zzc() == 24) {
            throw new GeneralSecurityException("192 bit AES GCM Parameters are not valid");
        }
        zzgxy zzgxyVar = new zzgxy(null);
        zzgxyVar.zza(zzgygVar);
        zzgxyVar.zzc(num);
        zzgxyVar.zzb(zzhtb.zzb(zzgygVar.zzc()));
        return zzgxyVar.zzd();
    }
}
