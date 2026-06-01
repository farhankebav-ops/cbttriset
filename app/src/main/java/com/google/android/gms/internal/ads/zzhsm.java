package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzhsm implements zzhik {
    public static zzhik zzb(zzhii zzhiiVar) throws GeneralSecurityException {
        zzhik zzhikVarZzb = zzhio.zzb(zzhiiVar);
        try {
            return new zzhsl(zzhikVarZzb, zzhip.zzb(zzhiiVar), null);
        } catch (GeneralSecurityException unused) {
            return zzhikVarZzb;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhik
    public final byte[] zza(byte[] bArr, int i2) throws GeneralSecurityException {
        throw null;
    }
}
