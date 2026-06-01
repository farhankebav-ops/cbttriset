package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzhyl implements zzhxw {
    private final zzhxz zza;
    private final String zzb;
    private final Object[] zzc;
    private final int zzd;

    public zzhyl(zzhxz zzhxzVar, String str, Object[] objArr) {
        this.zza = zzhxzVar;
        this.zzb = str;
        this.zzc = objArr;
        char cCharAt = str.charAt(0);
        if (cCharAt < 55296) {
            this.zzd = cCharAt;
            return;
        }
        int i2 = cCharAt & 8191;
        int i8 = 1;
        int i9 = 13;
        while (true) {
            int i10 = i8 + 1;
            char cCharAt2 = str.charAt(i8);
            if (cCharAt2 < 55296) {
                this.zzd = i2 | (cCharAt2 << i9);
                return;
            } else {
                i2 |= (cCharAt2 & 8191) << i9;
                i9 += 13;
                i8 = i10;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhxw
    public final boolean zza() {
        return (this.zzd & 2) == 2;
    }

    @Override // com.google.android.gms.internal.ads.zzhxw
    public final zzhxz zzb() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzhxw
    public final int zzc() {
        int i2 = this.zzd;
        if ((i2 & 1) != 0) {
            return 1;
        }
        return (i2 & 4) == 4 ? 3 : 2;
    }

    public final String zzd() {
        return this.zzb;
    }

    public final Object[] zze() {
        return this.zzc;
    }
}
