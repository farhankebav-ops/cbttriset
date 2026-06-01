package com.google.android.gms.internal.ads;

import com.ironsource.G5;
import java.io.IOException;
import java.math.RoundingMode;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
class zzgry extends zzgrz {
    private volatile zzgrz zza;
    final zzgru zzb;
    final Character zzc;

    public zzgry(zzgru zzgruVar, Character ch) {
        this.zzb = zzgruVar;
        boolean z2 = true;
        if (ch != null && zzgruVar.zze(G5.T)) {
            z2 = false;
        }
        zzgmd.zzf(z2, "Padding character %s was already in alphabet", ch);
        this.zzc = ch;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zzgry) {
            zzgry zzgryVar = (zzgry) obj;
            if (this.zzb.equals(zzgryVar.zzb) && Objects.equals(this.zzc, zzgryVar.zzc)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        Character ch = this.zzc;
        return Objects.hashCode(ch) ^ this.zzb.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("BaseEncoding.");
        zzgru zzgruVar = this.zzb;
        sb.append(zzgruVar);
        if (8 % zzgruVar.zzb != 0) {
            Character ch = this.zzc;
            if (ch == null) {
                sb.append(".omitPadding()");
            } else {
                sb.append(".withPadChar('");
                sb.append(ch);
                sb.append("')");
            }
        }
        return sb.toString();
    }

    @Override // com.google.android.gms.internal.ads.zzgrz
    public void zza(Appendable appendable, byte[] bArr, int i2, int i8) throws IOException {
        int i9 = 0;
        zzgmd.zzo(0, i8, bArr.length);
        while (i9 < i8) {
            int i10 = this.zzb.zzd;
            zze(appendable, bArr, i9, Math.min(i10, i8 - i9));
            i9 += i10;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgrz
    public int zzb(byte[] bArr, CharSequence charSequence) throws zzgrx {
        int i2;
        CharSequence charSequenceZzg = zzg(charSequence);
        int length = charSequenceZzg.length();
        zzgru zzgruVar = this.zzb;
        if (!zzgruVar.zzb(length)) {
            int length2 = charSequenceZzg.length();
            throw new zzgrx(androidx.camera.core.processing.util.a.m(new StringBuilder(String.valueOf(length2).length() + 21), "Invalid input length ", length2));
        }
        int i8 = 0;
        int i9 = 0;
        while (i8 < charSequenceZzg.length()) {
            long jZzc = 0;
            int i10 = 0;
            int i11 = 0;
            while (true) {
                i2 = zzgruVar.zzc;
                if (i10 >= i2) {
                    break;
                }
                jZzc <<= zzgruVar.zzb;
                if (i8 + i10 < charSequenceZzg.length()) {
                    jZzc |= (long) zzgruVar.zzc(charSequenceZzg.charAt(i11 + i8));
                    i11++;
                }
                i10++;
            }
            int i12 = zzgruVar.zzd;
            int i13 = i11 * zzgruVar.zzb;
            int i14 = (i12 - 1) * 8;
            while (i14 >= (i12 * 8) - i13) {
                bArr[i9] = (byte) ((jZzc >>> i14) & 255);
                i14 -= 8;
                i9++;
            }
            i8 += i2;
        }
        return i9;
    }

    public zzgrz zzc(zzgru zzgruVar, Character ch) {
        return new zzgry(zzgruVar, ch);
    }

    @Override // com.google.android.gms.internal.ads.zzgrz
    public final int zzd(int i2) {
        zzgru zzgruVar = this.zzb;
        return zzgruVar.zzc * zzgsm.zzb(i2, zzgruVar.zzd, RoundingMode.CEILING);
    }

    public final void zze(Appendable appendable, byte[] bArr, int i2, int i8) throws IOException {
        zzgmd.zzo(i2, i2 + i8, bArr.length);
        zzgru zzgruVar = this.zzb;
        int i9 = zzgruVar.zzd;
        int i10 = 0;
        zzgmd.zza(i8 <= i9);
        long j = 0;
        for (int i11 = 0; i11 < i8; i11++) {
            j = (j | ((long) (bArr[i2 + i11] & 255))) << 8;
        }
        int i12 = (i8 + 1) * 8;
        int i13 = zzgruVar.zzb;
        while (i10 < i8 * 8) {
            appendable.append(zzgruVar.zza(zzgruVar.zza & ((int) (j >>> ((i12 - i13) - i10)))));
            i10 += i13;
        }
        if (this.zzc != null) {
            while (i10 < i9 * 8) {
                appendable.append(G5.T);
                i10 += i13;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgrz
    public final int zzf(int i2) {
        return (int) (((((long) this.zzb.zzb) * ((long) i2)) + 7) / 8);
    }

    @Override // com.google.android.gms.internal.ads.zzgrz
    public final CharSequence zzg(CharSequence charSequence) {
        charSequence.getClass();
        if (this.zzc == null) {
            return charSequence;
        }
        int length = charSequence.length();
        do {
            length--;
            if (length < 0) {
                break;
            }
        } while (charSequence.charAt(length) == '=');
        return charSequence.subSequence(0, length + 1);
    }

    @Override // com.google.android.gms.internal.ads.zzgrz
    public final zzgrz zzh() {
        return this.zzc == null ? this : zzc(this.zzb, null);
    }

    @Override // com.google.android.gms.internal.ads.zzgrz
    public final zzgrz zzi() {
        zzgrz zzgrzVarZzc = this.zza;
        if (zzgrzVarZzc == null) {
            zzgru zzgruVar = this.zzb;
            zzgru zzgruVarZzd = zzgruVar.zzd();
            zzgrzVarZzc = zzgruVarZzd == zzgruVar ? this : zzc(zzgruVarZzd, this.zzc);
            this.zza = zzgrzVarZzc;
        }
        return zzgrzVarZzc;
    }

    public zzgry(String str, String str2, Character ch) {
        this(new zzgru(str, str2.toCharArray()), ch);
    }
}
