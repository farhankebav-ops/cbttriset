package com.google.android.gms.internal.ads;

import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzgrw extends zzgry {
    private zzgrw(zzgru zzgruVar, Character ch) {
        super(zzgruVar, ch);
        zzgmd.zza(zzgruVar.zzf().length == 64);
    }

    @Override // com.google.android.gms.internal.ads.zzgry, com.google.android.gms.internal.ads.zzgrz
    public final void zza(Appendable appendable, byte[] bArr, int i2, int i8) throws IOException {
        int i9 = 0;
        zzgmd.zzo(0, i8, bArr.length);
        for (int i10 = i8; i10 >= 3; i10 -= 3) {
            int i11 = bArr[i9] & 255;
            int i12 = bArr[i9 + 1] & 255;
            int i13 = bArr[i9 + 2] & 255;
            zzgru zzgruVar = this.zzb;
            int i14 = (i12 << 8) | (i11 << 16) | i13;
            appendable.append(zzgruVar.zza(i14 >>> 18));
            appendable.append(zzgruVar.zza((i14 >>> 12) & 63));
            appendable.append(zzgruVar.zza((i14 >>> 6) & 63));
            appendable.append(zzgruVar.zza(i14 & 63));
            i9 += 3;
        }
        if (i9 < i8) {
            zze(appendable, bArr, i9, i8 - i9);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgry, com.google.android.gms.internal.ads.zzgrz
    public final int zzb(byte[] bArr, CharSequence charSequence) throws zzgrx {
        CharSequence charSequenceZzg = zzg(charSequence);
        int length = charSequenceZzg.length();
        zzgru zzgruVar = this.zzb;
        if (!zzgruVar.zzb(length)) {
            int length2 = charSequenceZzg.length();
            throw new zzgrx(androidx.camera.core.processing.util.a.m(new StringBuilder(String.valueOf(length2).length() + 21), "Invalid input length ", length2));
        }
        int i2 = 0;
        int i8 = 0;
        while (i2 < charSequenceZzg.length()) {
            int i9 = i8 + 1;
            int iZzc = (zzgruVar.zzc(charSequenceZzg.charAt(i2 + 1)) << 12) | (zzgruVar.zzc(charSequenceZzg.charAt(i2)) << 18);
            bArr[i8] = (byte) (iZzc >>> 16);
            int i10 = i2 + 2;
            if (i10 < charSequenceZzg.length()) {
                int i11 = i2 + 3;
                int iZzc2 = iZzc | (zzgruVar.zzc(charSequenceZzg.charAt(i10)) << 6);
                int i12 = i8 + 2;
                bArr[i9] = (byte) ((iZzc2 >>> 8) & 255);
                if (i11 < charSequenceZzg.length()) {
                    i2 += 4;
                    i8 += 3;
                    bArr[i12] = (byte) ((iZzc2 | zzgruVar.zzc(charSequenceZzg.charAt(i11))) & 255);
                } else {
                    i8 = i12;
                    i2 = i11;
                }
            } else {
                i2 = i10;
                i8 = i9;
            }
        }
        return i8;
    }

    @Override // com.google.android.gms.internal.ads.zzgry
    public final zzgrz zzc(zzgru zzgruVar, Character ch) {
        return new zzgrw(zzgruVar, ch);
    }

    public zzgrw(String str, String str2, Character ch) {
        this(new zzgru(str, str2.toCharArray()), ch);
    }
}
