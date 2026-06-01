package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzda extends zzde {
    private final int zzc;
    private final int zzd;

    public zzda(byte[] bArr, int i2, int i8) {
        super(bArr);
        zzdf.zzo(i2, i2 + i8, bArr.length);
        this.zzc = i2;
        this.zzd = i8;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzde, com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdf
    public final byte zza(int i2) {
        zzdf.zzu(i2, this.zzd);
        return ((zzde) this).zza[this.zzc + i2];
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzde, com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdf
    public final byte zzb(int i2) {
        return ((zzde) this).zza[this.zzc + i2];
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzde
    public final int zzc() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzde, com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdf
    public final int zzd() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzde, com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdf
    public final void zze(byte[] bArr, int i2, int i8, int i9) {
        System.arraycopy(((zzde) this).zza, this.zzc + i2, bArr, i8, i9);
    }
}
