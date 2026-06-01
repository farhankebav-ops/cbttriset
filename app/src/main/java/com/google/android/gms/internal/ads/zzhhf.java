package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzhhf extends zzhhi {
    private final int zza;
    private final int zzb;
    private final zzhhe zzc;
    private final zzhhd zzd;

    public /* synthetic */ zzhhf(int i2, int i8, zzhhe zzhheVar, zzhhd zzhhdVar, byte[] bArr) {
        this.zza = i2;
        this.zzb = i8;
        this.zzc = zzhheVar;
        this.zzd = zzhhdVar;
    }

    public static zzhhc zzb() {
        return new zzhhc(null);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzhhf)) {
            return false;
        }
        zzhhf zzhhfVar = (zzhhf) obj;
        return zzhhfVar.zza == this.zza && zzhhfVar.zze() == zze() && zzhhfVar.zzc == this.zzc && zzhhfVar.zzd == this.zzd;
    }

    public final int hashCode() {
        return Objects.hash(zzhhf.class, Integer.valueOf(this.zza), Integer.valueOf(this.zzb), this.zzc, this.zzd);
    }

    public final String toString() {
        zzhhd zzhhdVar = this.zzd;
        String strValueOf = String.valueOf(this.zzc);
        String strValueOf2 = String.valueOf(zzhhdVar);
        int length = strValueOf.length();
        int length2 = strValueOf2.length();
        int i2 = this.zzb;
        int length3 = String.valueOf(i2).length();
        int i8 = this.zza;
        StringBuilder sb = new StringBuilder(length + 38 + length2 + 2 + length3 + 16 + String.valueOf(i8).length() + 10);
        androidx.camera.core.processing.util.a.A(sb, "HMAC Parameters (variant: ", strValueOf, ", hashType: ", strValueOf2);
        com.google.android.gms.ads.internal.client.a.k(i2, i8, ", ", "-byte tags, and ", sb);
        sb.append("-byte key)");
        return sb.toString();
    }

    @Override // com.google.android.gms.internal.ads.zzgwj
    public final boolean zza() {
        return this.zzc != zzhhe.zzd;
    }

    public final int zzc() {
        return this.zza;
    }

    public final int zzd() {
        return this.zzb;
    }

    public final int zze() {
        zzhhe zzhheVar = this.zzc;
        if (zzhheVar == zzhhe.zzd) {
            return this.zzb;
        }
        if (zzhheVar == zzhhe.zza || zzhheVar == zzhhe.zzb || zzhheVar == zzhhe.zzc) {
            return this.zzb + 5;
        }
        throw new IllegalStateException("Unknown variant");
    }

    public final zzhhe zzf() {
        return this.zzc;
    }

    public final zzhhd zzg() {
        return this.zzd;
    }
}
