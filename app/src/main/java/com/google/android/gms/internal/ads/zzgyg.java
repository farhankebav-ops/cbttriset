package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzgyg extends zzgxb {
    private final int zza;
    private final int zzb = 12;
    private final int zzc = 16;
    private final zzgyf zzd;

    public /* synthetic */ zzgyg(int i2, int i8, int i9, zzgyf zzgyfVar, byte[] bArr) {
        this.zza = i2;
        this.zzd = zzgyfVar;
    }

    public static zzgye zzb() {
        return new zzgye(null);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzgyg)) {
            return false;
        }
        zzgyg zzgygVar = (zzgyg) obj;
        return zzgygVar.zza == this.zza && zzgygVar.zzd == this.zzd;
    }

    public final int hashCode() {
        return Objects.hash(zzgyg.class, Integer.valueOf(this.zza), 12, 16, this.zzd);
    }

    public final String toString() {
        String strValueOf = String.valueOf(this.zzd);
        int length = strValueOf.length();
        int length2 = String.valueOf(12).length();
        int length3 = String.valueOf(16).length();
        int i2 = this.zza;
        StringBuilder sb = new StringBuilder(a1.a.b(length + 30 + length2 + 10 + length3, 15, String.valueOf(i2).length(), 10));
        sb.append("AesGcm Parameters (variant: ");
        sb.append(strValueOf);
        sb.append(", 12-byte IV, 16-byte tag, and ");
        sb.append(i2);
        sb.append("-byte key)");
        return sb.toString();
    }

    @Override // com.google.android.gms.internal.ads.zzgwj
    public final boolean zza() {
        return this.zzd != zzgyf.zzc;
    }

    public final int zzc() {
        return this.zza;
    }

    public final zzgyf zzd() {
        return this.zzd;
    }
}
