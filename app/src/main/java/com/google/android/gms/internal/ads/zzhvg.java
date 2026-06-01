package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
class zzhvg extends zzhvf {
    protected final byte[] zza;

    public zzhvg(byte[] bArr) {
        super(null);
        bArr.getClass();
        this.zza = bArr;
    }

    @Override // com.google.android.gms.internal.ads.zzhvi
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzhvi) || zzc() != ((zzhvi) obj).zzc()) {
            return false;
        }
        if (zzc() == 0) {
            return true;
        }
        if (!(obj instanceof zzhvg)) {
            return obj.equals(this);
        }
        zzhvg zzhvgVar = (zzhvg) obj;
        int iZzy = zzy();
        int iZzy2 = zzhvgVar.zzy();
        if (iZzy == 0 || iZzy2 == 0 || iZzy == iZzy2) {
            return zzh(zzhvgVar, 0, zzc());
        }
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzhvi
    public byte zza(int i2) {
        return this.zza[i2];
    }

    @Override // com.google.android.gms.internal.ads.zzhvi
    public byte zzb(int i2) {
        return this.zza[i2];
    }

    @Override // com.google.android.gms.internal.ads.zzhvi
    public int zzc() {
        return this.zza.length;
    }

    public int zzd() {
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzhvi
    public void zze(byte[] bArr, int i2, int i8, int i9) {
        System.arraycopy(this.zza, i2, bArr, i8, i9);
    }

    @Override // com.google.android.gms.internal.ads.zzhvf
    public final boolean zzh(zzhvi zzhviVar, int i2, int i8) {
        if (i8 > zzhviVar.zzc()) {
            int iZzc = zzc();
            StringBuilder sb = new StringBuilder(String.valueOf(i8).length() + 18 + String.valueOf(iZzc).length());
            sb.append("Length too large: ");
            sb.append(i8);
            sb.append(iZzc);
            throw new IllegalArgumentException(sb.toString());
        }
        int i9 = i2 + i8;
        if (i9 > zzhviVar.zzc()) {
            int iZzc2 = zzhviVar.zzc();
            int length = String.valueOf(i2).length();
            StringBuilder sb2 = new StringBuilder(length + 24 + String.valueOf(i8).length() + 2 + String.valueOf(iZzc2).length());
            com.google.android.gms.ads.internal.client.a.k(i2, i8, "Ran off end of other: ", ", ", sb2);
            throw new IllegalArgumentException(androidx.camera.core.processing.util.a.m(sb2, ", ", iZzc2));
        }
        if (!(zzhviVar instanceof zzhvg)) {
            return zzhviVar.zzi(i2, i9).equals(zzi(0, i8));
        }
        zzhvg zzhvgVar = (zzhvg) zzhviVar;
        byte[] bArr = this.zza;
        byte[] bArr2 = zzhvgVar.zza;
        int iZzd = zzd() + i8;
        int iZzd2 = zzd();
        int iZzd3 = zzhvgVar.zzd() + i2;
        while (iZzd2 < iZzd) {
            if (bArr[iZzd2] != bArr2[iZzd3]) {
                return false;
            }
            iZzd2++;
            iZzd3++;
        }
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzhvi
    public final zzhvi zzi(int i2, int i8) {
        int iZzA = zzhvi.zzA(i2, i8, zzc());
        return iZzA == 0 ? zzhvi.zzb : new zzhvc(this.zza, zzd() + i2, iZzA);
    }

    @Override // com.google.android.gms.internal.ads.zzhvi
    public final ByteBuffer zzj() {
        return ByteBuffer.wrap(this.zza, zzd(), zzc()).asReadOnlyBuffer();
    }

    @Override // com.google.android.gms.internal.ads.zzhvi
    public final void zzk(zzhuz zzhuzVar) throws IOException {
        zzhuzVar.zza(this.zza, zzd(), zzc());
    }

    @Override // com.google.android.gms.internal.ads.zzhvi
    public final String zzl(Charset charset) {
        return new String(this.zza, zzd(), zzc(), charset);
    }

    @Override // com.google.android.gms.internal.ads.zzhvi
    public final boolean zzm() {
        int iZzd = zzd();
        return zzhzo.zza(this.zza, iZzd, zzc() + iZzd);
    }

    @Override // com.google.android.gms.internal.ads.zzhvi
    public final int zzn(int i2, int i8, int i9) {
        int iZzd = zzd() + i8;
        return zzhzo.zzb(i2, this.zza, iZzd, i9 + iZzd);
    }

    @Override // com.google.android.gms.internal.ads.zzhvi
    public final int zzo(int i2, int i8, int i9) {
        return zzhxb.zzc(i2, this.zza, zzd() + i8, i9);
    }

    @Override // com.google.android.gms.internal.ads.zzhvi
    public final zzhvn zzp() {
        return zzhvn.zzG(this.zza, zzd(), zzc(), true);
    }
}
