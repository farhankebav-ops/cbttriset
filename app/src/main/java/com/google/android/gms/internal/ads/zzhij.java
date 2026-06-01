package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzhij extends zzhim {
    private final int zza;

    private zzhij(int i2) {
        this.zza = i2;
    }

    public static zzhij zzb(int i2) throws GeneralSecurityException {
        if (i2 == 16 || i2 == 32) {
            return new zzhij(i2);
        }
        throw new InvalidAlgorithmParameterException(String.format("Invalid key size %d; only 128-bit and 256-bit are supported", Integer.valueOf(i2 * 8)));
    }

    public final boolean equals(Object obj) {
        return (obj instanceof zzhij) && ((zzhij) obj).zza == this.zza;
    }

    public final int hashCode() {
        return Objects.hash(zzhij.class, Integer.valueOf(this.zza));
    }

    public final String toString() {
        int i2 = this.zza;
        return com.google.android.gms.ads.internal.client.a.j(new StringBuilder(String.valueOf(i2).length() + 34), "AesCmac PRF Parameters (", i2, "-byte key)");
    }

    @Override // com.google.android.gms.internal.ads.zzgwj
    public final boolean zza() {
        return false;
    }

    public final int zzc() {
        return this.zza;
    }
}
