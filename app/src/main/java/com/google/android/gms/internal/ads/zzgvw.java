package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzgvw {
    public static final zzhla zza(zzgwj zzgwjVar) {
        try {
            return ((zzhfx) zzhfb.zza().zzk(null, zzhfx.class)).zzc();
        } catch (GeneralSecurityException e) {
            throw new zzhgh("Parsing parameters failed in getProto(). You probably want to call some Tink register function for ".concat("null"), e);
        }
    }

    public static final zzgwj zzb(zzgwj zzgwjVar) throws GeneralSecurityException {
        return zzgwjVar != null ? zzgwjVar : zzgwp.zzb(zza(null).zzaN());
    }
}
