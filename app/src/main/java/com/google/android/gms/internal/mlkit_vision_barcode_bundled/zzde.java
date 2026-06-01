package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import a1.a;
import java.io.IOException;
import java.nio.charset.Charset;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
class zzde extends zzdd {
    protected final byte[] zza;

    public zzde(byte[] bArr) {
        super(null);
        bArr.getClass();
        this.zza = bArr;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdf
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzdf) || zzd() != ((zzdf) obj).zzd()) {
            return false;
        }
        if (zzd() == 0) {
            return true;
        }
        if (!(obj instanceof zzde)) {
            return obj.equals(this);
        }
        zzde zzdeVar = (zzde) obj;
        int iZzp = zzp();
        int iZzp2 = zzdeVar.zzp();
        if (iZzp == 0 || iZzp2 == 0 || iZzp == iZzp2) {
            return zzg(zzdeVar, 0, zzd());
        }
        return false;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdf
    public byte zza(int i2) {
        return this.zza[i2];
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdf
    public byte zzb(int i2) {
        return this.zza[i2];
    }

    public int zzc() {
        return 0;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdf
    public int zzd() {
        return this.zza.length;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdf
    public void zze(byte[] bArr, int i2, int i8, int i9) {
        System.arraycopy(this.zza, i2, bArr, i8, i9);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdd
    public final boolean zzg(zzdf zzdfVar, int i2, int i8) {
        if (i8 > zzdfVar.zzd()) {
            throw new IllegalArgumentException("Length too large: " + i8 + zzd());
        }
        int i9 = i2 + i8;
        if (i9 > zzdfVar.zzd()) {
            int iZzd = zzdfVar.zzd();
            StringBuilder sbW = a.w(i2, "Ran off end of other: ", ", ", i8, ", ");
            sbW.append(iZzd);
            throw new IllegalArgumentException(sbW.toString());
        }
        if (!(zzdfVar instanceof zzde)) {
            return zzdfVar.zzk(i2, i9).equals(zzk(0, i8));
        }
        zzde zzdeVar = (zzde) zzdfVar;
        byte[] bArr = this.zza;
        byte[] bArr2 = zzdeVar.zza;
        int iZzc = zzc() + i8;
        int iZzc2 = zzc();
        int iZzc3 = zzdeVar.zzc() + i2;
        while (iZzc2 < iZzc) {
            if (bArr[iZzc2] != bArr2[iZzc3]) {
                return false;
            }
            iZzc2++;
            iZzc3++;
        }
        return true;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdf
    public final int zzi(int i2, int i8, int i9) {
        return zzep.zzb(i2, this.zza, zzc() + i8, i9);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdf
    public final int zzj(int i2, int i8, int i9) {
        int iZzc = zzc() + i8;
        return zzhe.zzf(i2, this.zza, iZzc, i9 + iZzc);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdf
    public final zzdf zzk(int i2, int i8) {
        int iZzo = zzdf.zzo(i2, i8, zzd());
        return iZzo == 0 ? zzdf.zzb : new zzda(this.zza, zzc() + i2, iZzo);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdf
    public final String zzl(Charset charset) {
        return new String(this.zza, zzc(), zzd(), charset);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdf
    public final void zzm(zzcx zzcxVar) throws IOException {
        ((zzdk) zzcxVar).zzc(this.zza, zzc(), zzd());
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdf
    public final boolean zzn() {
        int iZzc = zzc();
        return zzhe.zzg(this.zza, iZzc, zzd() + iZzc);
    }
}
