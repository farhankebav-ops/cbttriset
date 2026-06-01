package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzfrx extends zzfru {
    private final String zza;
    private final boolean zzb;
    private final boolean zzc;
    private final long zzd;
    private final long zze;

    public /* synthetic */ zzfrx(String str, boolean z2, boolean z7, boolean z8, long j, boolean z9, long j3, byte[] bArr) {
        this.zza = str;
        this.zzb = z2;
        this.zzc = z7;
        this.zzd = j;
        this.zze = j3;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzfru) {
            zzfru zzfruVar = (zzfru) obj;
            if (this.zza.equals(zzfruVar.zza()) && this.zzb == zzfruVar.zzb() && this.zzc == zzfruVar.zzc()) {
                zzfruVar.zzd();
                if (this.zzd == zzfruVar.zze()) {
                    zzfruVar.zzf();
                    if (this.zze == zzfruVar.zzg()) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((((((((((((this.zza.hashCode() ^ 1000003) * 1000003) ^ (true != this.zzb ? 1237 : 1231)) * 1000003) ^ (true != this.zzc ? 1237 : 1231)) * 1000003) ^ 1237) * 1000003) ^ ((int) this.zzd)) * 1000003) ^ 1237) * 1000003) ^ ((int) this.zze);
    }

    public final String toString() {
        boolean z2 = this.zzb;
        int length = String.valueOf(z2).length();
        boolean z7 = this.zzc;
        int length2 = String.valueOf(z7).length();
        long j = this.zzd;
        int length3 = String.valueOf(j).length();
        long j3 = this.zze;
        int length4 = String.valueOf(j3).length();
        String str = this.zza;
        StringBuilder sb = new StringBuilder(str.length() + 56 + length + 32 + length2 + 57 + length3 + 61 + length4 + 1);
        sb.append("AdShield2Options{clientVersion=");
        sb.append(str);
        sb.append(", shouldGetAdvertisingId=");
        sb.append(z2);
        sb.append(", isGooglePlayServicesAvailable=");
        sb.append(z7);
        sb.append(", enableQuerySignalsTimeout=false, querySignalsTimeoutMs=");
        sb.append(j);
        sb.append(", enableQuerySignalsCache=false, querySignalsCacheTtlSeconds=");
        sb.append(j3);
        sb.append("}");
        return sb.toString();
    }

    @Override // com.google.android.gms.internal.ads.zzfru
    public final String zza() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzfru
    public final boolean zzb() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzfru
    public final boolean zzc() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.ads.zzfru
    public final boolean zzd() {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzfru
    public final long zze() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.ads.zzfru
    public final boolean zzf() {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzfru
    public final long zzg() {
        return this.zze;
    }
}
