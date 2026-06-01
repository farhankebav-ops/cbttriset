package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzhvc extends zzhvg {
    private final int zzc;
    private final int zzd;

    public zzhvc(byte[] bArr, int i2, int i8) {
        super(bArr);
        zzhvi.zzA(i2, i2 + i8, bArr.length);
        this.zzc = i2;
        this.zzd = i8;
    }

    @Override // com.google.android.gms.internal.ads.zzhvg, com.google.android.gms.internal.ads.zzhvi
    public final byte zza(int i2) {
        zzhvi.zzz(i2, this.zzd);
        return ((zzhvg) this).zza[this.zzc + i2];
    }

    @Override // com.google.android.gms.internal.ads.zzhvg, com.google.android.gms.internal.ads.zzhvi
    public final byte zzb(int i2) {
        return ((zzhvg) this).zza[this.zzc + i2];
    }

    @Override // com.google.android.gms.internal.ads.zzhvg, com.google.android.gms.internal.ads.zzhvi
    public final int zzc() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.ads.zzhvg
    public final int zzd() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.ads.zzhvg, com.google.android.gms.internal.ads.zzhvi
    public final void zze(byte[] bArr, int i2, int i8, int i9) {
        System.arraycopy(((zzhvg) this).zza, this.zzc + i2, bArr, i8, i9);
    }
}
