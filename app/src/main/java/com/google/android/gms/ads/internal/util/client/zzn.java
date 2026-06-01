package com.google.android.gms.ads.internal.util.client;

import com.google.android.gms.ads.internal.client.a;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
final class zzn extends zzx {
    private final int zza;
    private final int zzb;
    private final double zzc;
    private final boolean zzd;

    public zzn(int i2, int i8, double d8, boolean z2) {
        this.zza = i2;
        this.zzb = i8;
        this.zzc = d8;
        this.zzd = z2;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzx) {
            zzx zzxVar = (zzx) obj;
            if (this.zza == zzxVar.zza() && this.zzb == zzxVar.zzb() && Double.doubleToLongBits(this.zzc) == Double.doubleToLongBits(zzxVar.zzc()) && this.zzd == zzxVar.zzd()) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        double d8 = this.zzc;
        return ((((int) (Double.doubleToLongBits(d8) ^ (Double.doubleToLongBits(d8) >>> 32))) ^ ((((this.zza ^ 1000003) * 1000003) ^ this.zzb) * 1000003)) * 1000003) ^ (true != this.zzd ? 1237 : 1231);
    }

    public final String toString() {
        int i2 = this.zza;
        int length = String.valueOf(i2).length();
        int i8 = this.zzb;
        int length2 = String.valueOf(i8).length();
        double d8 = this.zzc;
        int length3 = String.valueOf(d8).length();
        boolean z2 = this.zzd;
        StringBuilder sb = new StringBuilder(length + 44 + length2 + 20 + length3 + 25 + String.valueOf(z2).length() + 1);
        a.k(i2, i8, "PingStrategy{maxAttempts=", ", initialBackoffMs=", sb);
        sb.append(", backoffMultiplier=");
        sb.append(d8);
        sb.append(", bufferAfterMaxAttempts=");
        return a1.a.u(sb, z2, "}");
    }

    @Override // com.google.android.gms.ads.internal.util.client.zzx
    public final int zza() {
        return this.zza;
    }

    @Override // com.google.android.gms.ads.internal.util.client.zzx
    public final int zzb() {
        return this.zzb;
    }

    @Override // com.google.android.gms.ads.internal.util.client.zzx
    public final double zzc() {
        return this.zzc;
    }

    @Override // com.google.android.gms.ads.internal.util.client.zzx
    public final boolean zzd() {
        return this.zzd;
    }
}
