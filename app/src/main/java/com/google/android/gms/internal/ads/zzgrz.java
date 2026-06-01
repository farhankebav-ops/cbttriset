package com.google.android.gms.internal.ads;

import com.ironsource.G5;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class zzgrz {
    private static final zzgrz zza;
    private static final zzgrz zzb;
    private static final zzgrz zzc;

    static {
        Character chValueOf = Character.valueOf(G5.T);
        zza = new zzgrw("base64()", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/", chValueOf);
        zzb = new zzgrw("base64Url()", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_", chValueOf);
        new zzgry("base32()", "ABCDEFGHIJKLMNOPQRSTUVWXYZ234567", chValueOf);
        new zzgry("base32Hex()", "0123456789ABCDEFGHIJKLMNOPQRSTUV", chValueOf);
        zzc = new zzgrv("base16()", "0123456789ABCDEF");
    }

    public static zzgrz zzl() {
        return zza;
    }

    public static zzgrz zzm() {
        return zzb;
    }

    public static zzgrz zzn() {
        return zzc;
    }

    public abstract void zza(Appendable appendable, byte[] bArr, int i2, int i8) throws IOException;

    public abstract int zzb(byte[] bArr, CharSequence charSequence) throws zzgrx;

    public abstract int zzd(int i2);

    public abstract int zzf(int i2);

    public CharSequence zzg(CharSequence charSequence) {
        throw null;
    }

    public abstract zzgrz zzh();

    public abstract zzgrz zzi();

    public final String zzj(byte[] bArr, int i2, int i8) {
        zzgmd.zzo(0, i8, bArr.length);
        StringBuilder sb = new StringBuilder(zzd(i8));
        try {
            zza(sb, bArr, 0, i8);
            return sb.toString();
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }

    public final byte[] zzk(CharSequence charSequence) {
        try {
            CharSequence charSequenceZzg = zzg(charSequence);
            int iZzf = zzf(charSequenceZzg.length());
            byte[] bArr = new byte[iZzf];
            int iZzb = zzb(bArr, charSequenceZzg);
            if (iZzb == iZzf) {
                return bArr;
            }
            byte[] bArr2 = new byte[iZzb];
            System.arraycopy(bArr, 0, bArr2, 0, iZzb);
            return bArr2;
        } catch (zzgrx e) {
            throw new IllegalArgumentException(e);
        }
    }
}
