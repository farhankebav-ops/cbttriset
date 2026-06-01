package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzgxx extends zzgxb {
    private final int zza;
    private final int zzb;
    private final int zzc = 16;
    private final zzgxw zzd;

    public /* synthetic */ zzgxx(int i2, int i8, int i9, zzgxw zzgxwVar, byte[] bArr) {
        this.zza = i2;
        this.zzb = i8;
        this.zzd = zzgxwVar;
    }

    public static zzgxv zzb() {
        return new zzgxv(null);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzgxx)) {
            return false;
        }
        zzgxx zzgxxVar = (zzgxx) obj;
        return zzgxxVar.zza == this.zza && zzgxxVar.zzb == this.zzb && zzgxxVar.zzd == this.zzd;
    }

    public final int hashCode() {
        return Objects.hash(zzgxx.class, Integer.valueOf(this.zza), Integer.valueOf(this.zzb), 16, this.zzd);
    }

    public final String toString() {
        String strValueOf = String.valueOf(this.zzd);
        int length = strValueOf.length();
        int i2 = this.zzb;
        int length2 = String.valueOf(i2).length();
        int length3 = String.valueOf(16).length();
        int i8 = this.zza;
        StringBuilder sb = new StringBuilder(a1.a.b(length + 30 + length2 + 10 + length3, 15, String.valueOf(i8).length(), 10));
        sb.append("AesEax Parameters (variant: ");
        sb.append(strValueOf);
        sb.append(", ");
        sb.append(i2);
        return com.google.android.gms.ads.internal.client.a.j(sb, "-byte IV, 16-byte tag, and ", i8, "-byte key)");
    }

    @Override // com.google.android.gms.internal.ads.zzgwj
    public final boolean zza() {
        return this.zzd != zzgxw.zzc;
    }

    public final int zzc() {
        return this.zza;
    }

    public final int zzd() {
        return this.zzb;
    }

    public final zzgxw zze() {
        return this.zzd;
    }
}
