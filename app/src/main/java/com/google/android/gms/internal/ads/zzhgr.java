package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzhgr extends zzhhi {
    private final int zza;
    private final int zzb;
    private final zzhgq zzc;

    public /* synthetic */ zzhgr(int i2, int i8, zzhgq zzhgqVar, byte[] bArr) {
        this.zza = i2;
        this.zzb = i8;
        this.zzc = zzhgqVar;
    }

    public static zzhgp zzb() {
        return new zzhgp(null);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzhgr)) {
            return false;
        }
        zzhgr zzhgrVar = (zzhgr) obj;
        return zzhgrVar.zza == this.zza && zzhgrVar.zze() == zze() && zzhgrVar.zzc == this.zzc;
    }

    public final int hashCode() {
        return Objects.hash(zzhgr.class, Integer.valueOf(this.zza), Integer.valueOf(this.zzb), this.zzc);
    }

    public final String toString() {
        String strValueOf = String.valueOf(this.zzc);
        int length = strValueOf.length();
        int i2 = this.zzb;
        int length2 = String.valueOf(i2).length();
        int i8 = this.zza;
        StringBuilder sb = new StringBuilder(length + 32 + length2 + 16 + String.valueOf(i8).length() + 10);
        sb.append("AES-CMAC Parameters (variant: ");
        sb.append(strValueOf);
        sb.append(", ");
        sb.append(i2);
        return com.google.android.gms.ads.internal.client.a.j(sb, "-byte tags, and ", i8, "-byte key)");
    }

    @Override // com.google.android.gms.internal.ads.zzgwj
    public final boolean zza() {
        return this.zzc != zzhgq.zzd;
    }

    public final int zzc() {
        return this.zza;
    }

    public final int zzd() {
        return this.zzb;
    }

    public final int zze() {
        zzhgq zzhgqVar = this.zzc;
        if (zzhgqVar == zzhgq.zzd) {
            return this.zzb;
        }
        if (zzhgqVar == zzhgq.zza || zzhgqVar == zzhgq.zzb || zzhgqVar == zzhgq.zzc) {
            return this.zzb + 5;
        }
        throw new IllegalStateException("Unknown variant");
    }

    public final zzhgq zzf() {
        return this.zzc;
    }
}
