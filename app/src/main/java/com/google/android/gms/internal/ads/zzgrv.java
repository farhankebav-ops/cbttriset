package com.google.android.gms.internal.ads;

import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzgrv extends zzgry {
    final char[] zza;

    private zzgrv(zzgru zzgruVar) {
        super(zzgruVar, null);
        this.zza = new char[512];
        zzgmd.zza(zzgruVar.zzf().length == 16);
        for (int i2 = 0; i2 < 256; i2++) {
            this.zza[i2] = zzgruVar.zza(i2 >>> 4);
            this.zza[i2 | 256] = zzgruVar.zza(i2 & 15);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgry, com.google.android.gms.internal.ads.zzgrz
    public final void zza(Appendable appendable, byte[] bArr, int i2, int i8) throws IOException {
        zzgmd.zzo(0, i8, bArr.length);
        for (int i9 = 0; i9 < i8; i9++) {
            int i10 = bArr[i9] & 255;
            char[] cArr = this.zza;
            appendable.append(cArr[i10]);
            appendable.append(cArr[i10 | 256]);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgry, com.google.android.gms.internal.ads.zzgrz
    public final int zzb(byte[] bArr, CharSequence charSequence) throws zzgrx {
        if (charSequence.length() % 2 == 1) {
            int length = charSequence.length();
            throw new zzgrx(androidx.camera.core.processing.util.a.m(new StringBuilder(String.valueOf(length).length() + 21), "Invalid input length ", length));
        }
        int i2 = 0;
        int i8 = 0;
        while (i2 < charSequence.length()) {
            zzgru zzgruVar = this.zzb;
            bArr[i8] = (byte) (zzgruVar.zzc(charSequence.charAt(i2 + 1)) | (zzgruVar.zzc(charSequence.charAt(i2)) << 4));
            i2 += 2;
            i8++;
        }
        return i8;
    }

    @Override // com.google.android.gms.internal.ads.zzgry
    public final zzgrz zzc(zzgru zzgruVar, Character ch) {
        return new zzgrv(zzgruVar);
    }

    public zzgrv(String str, String str2) {
        this(new zzgru("base16()", "0123456789ABCDEF".toCharArray()));
    }
}
