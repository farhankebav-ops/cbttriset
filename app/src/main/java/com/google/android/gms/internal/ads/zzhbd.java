package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzhbd {
    private static final ThreadLocal zza = new zzhbc();

    public static Cipher zza() {
        return (Cipher) zza.get();
    }

    public static SecretKey zzb(byte[] bArr) throws GeneralSecurityException {
        zzhsx.zza(bArr.length);
        return new SecretKeySpec(bArr, "AES");
    }

    public static AlgorithmParameterSpec zzc(byte[] bArr, int i2, int i8) {
        zzhgi.zzd();
        return new GCMParameterSpec(128, bArr, i2, 12);
    }
}
