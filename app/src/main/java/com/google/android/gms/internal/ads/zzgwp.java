package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzgwp {
    public static byte[] zza(zzgwj zzgwjVar) throws GeneralSecurityException {
        return ((zzhfx) zzhfb.zza().zzk(zzgwjVar, zzhfx.class)).zzc().zzaN();
    }

    public static zzgwj zzb(byte[] bArr) throws GeneralSecurityException {
        try {
            zzhla zzhlaVarZzd = zzhla.zzd(bArr, zzhvy.zza());
            zzhfb zzhfbVarZza = zzhfb.zza();
            zzhfx zzhfxVarZzb = zzhfx.zzb(zzhlaVarZzd);
            return !zzhfbVarZza.zzi(zzhfxVarZzb) ? new zzhej(zzhfxVarZzb) : zzhfbVarZza.zzj(zzhfxVarZzb);
        } catch (IOException e) {
            throw new GeneralSecurityException("Failed to parse proto", e);
        }
    }
}
