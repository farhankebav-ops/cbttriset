package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzhro {
    private final byte[] zza;
    private final byte[] zzb;

    private zzhro(byte[] bArr, byte[] bArr2) {
        this.zza = bArr;
        this.zzb = bArr2;
    }

    public static zzhro zzc() throws GeneralSecurityException {
        byte[] bArrZza = zzhfz.zza(32);
        if (bArrZza.length == 32) {
            return new zzhro(zzhdj.zza(zzhdj.zzb(bArrZza)), bArrZza);
        }
        throw new IllegalArgumentException("Given secret seed length is not 32");
    }

    public final byte[] zza() {
        return Arrays.copyOf(this.zza, 32);
    }

    public final byte[] zzb() {
        byte[] bArr = this.zzb;
        return Arrays.copyOf(bArr, bArr.length);
    }
}
