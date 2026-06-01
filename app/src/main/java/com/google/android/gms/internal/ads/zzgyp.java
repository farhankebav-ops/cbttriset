package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzgyp extends zzgxb {
    private final int zza;
    private final zzgyo zzb;

    public /* synthetic */ zzgyp(int i2, zzgyo zzgyoVar, byte[] bArr) {
        this.zza = i2;
        this.zzb = zzgyoVar;
    }

    public static zzgyn zzb() {
        return new zzgyn(null);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzgyp)) {
            return false;
        }
        zzgyp zzgypVar = (zzgyp) obj;
        return zzgypVar.zza == this.zza && zzgypVar.zzb == this.zzb;
    }

    public final int hashCode() {
        return Objects.hash(zzgyp.class, Integer.valueOf(this.zza), this.zzb);
    }

    public final String toString() {
        String strValueOf = String.valueOf(this.zzb);
        int length = strValueOf.length();
        int i2 = this.zza;
        StringBuilder sb = new StringBuilder(length + 33 + String.valueOf(i2).length() + 10);
        sb.append("AesGcmSiv Parameters (variant: ");
        sb.append(strValueOf);
        sb.append(", ");
        sb.append(i2);
        sb.append("-byte key)");
        return sb.toString();
    }

    @Override // com.google.android.gms.internal.ads.zzgwj
    public final boolean zza() {
        return this.zzb != zzgyo.zzc;
    }

    public final int zzc() {
        return this.zza;
    }

    public final zzgyo zzd() {
        return this.zzb;
    }
}
