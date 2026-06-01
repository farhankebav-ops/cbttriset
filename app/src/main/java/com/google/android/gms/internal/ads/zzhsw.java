package com.google.android.gms.internal.ads;

import com.unity3d.ads.core.data.datasource.AndroidStaticDeviceInfoDataSource;
import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzhsw {
    public static String zza(zzhsi zzhsiVar) throws GeneralSecurityException {
        zzhsx.zzb(zzhsiVar);
        return zzhsiVar.toString().concat("withECDSA");
    }

    public static String zzb(zzhsi zzhsiVar) throws GeneralSecurityException {
        int iOrdinal = zzhsiVar.ordinal();
        if (iOrdinal == 0) {
            return AndroidStaticDeviceInfoDataSource.ALGORITHM_SHA1;
        }
        if (iOrdinal == 1) {
            return "SHA-224";
        }
        if (iOrdinal == 2) {
            return "SHA-256";
        }
        if (iOrdinal == 3) {
            return "SHA-384";
        }
        if (iOrdinal == 4) {
            return "SHA-512";
        }
        throw new GeneralSecurityException("Unsupported hash ".concat(zzhsiVar.toString()));
    }
}
