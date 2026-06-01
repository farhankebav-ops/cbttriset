package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzeg {
    private static final char[] zza = {'\r', '\n'};
    private static final char[] zzb = {'\n'};
    private static final zzgpo zzc = zzgpo.zzl(StandardCharsets.US_ASCII, StandardCharsets.UTF_8, StandardCharsets.UTF_16, StandardCharsets.UTF_16BE, StandardCharsets.UTF_16LE);
    private static final AtomicBoolean zzd = new AtomicBoolean();
    private byte[] zze;
    private int zzf;
    private int zzg;

    public zzeg(byte[] bArr, int i2) {
        this.zze = bArr;
        this.zzg = i2;
    }

    private final char zzS(ByteOrder byteOrder, int i2) {
        zzW(2);
        if (byteOrder == ByteOrder.BIG_ENDIAN) {
            byte[] bArr = this.zze;
            int i8 = this.zzf + i2;
            return zzgsq.zza(bArr[i8], bArr[i8 + 1]);
        }
        byte[] bArr2 = this.zze;
        int i9 = this.zzf + i2;
        return zzgsq.zza(bArr2[i9 + 1], bArr2[i9]);
    }

    private final char zzT(Charset charset, char[] cArr) {
        int iZzU;
        if (zzd() >= zzV(charset) && (iZzU = zzU(charset)) != 0) {
            if (!Character.isSupplementaryCodePoint(i)) {
                long j = i;
                char c7 = (char) j;
                zzgmd.zze(((long) c7) == j, "Out of range: %s", j);
                for (char c8 : cArr) {
                    if (c8 == c7) {
                        this.zzf = zzgst.zza(iZzU & 255) + this.zzf;
                        return c7;
                    }
                }
            }
        }
        return (char) 0;
    }

    private final int zzU(Charset charset) {
        int codePoint;
        int i2;
        int iZzY;
        zzgmd.zzf(zzc.contains(charset), "Unsupported charset: %s", charset);
        if (zzd() < zzV(charset)) {
            int i8 = this.zzf;
            int i9 = this.zzg;
            throw new IndexOutOfBoundsException(a1.a.f(i8, i9, "position=", ", limit=", new StringBuilder(String.valueOf(i8).length() + 17 + String.valueOf(i9).length())));
        }
        int i10 = 1;
        if (charset.equals(StandardCharsets.US_ASCII)) {
            byte b8 = this.zze[this.zzf];
            if ((b8 & 128) == 0) {
                codePoint = b8 & 255;
                return (codePoint << 8) | i10;
            }
            return 0;
        }
        if (charset.equals(StandardCharsets.UTF_8)) {
            byte b9 = this.zze[this.zzf];
            if ((b9 & 128) == 0) {
                i2 = 1;
            } else if ((b9 & 224) == 192 && zzd() >= 2 && zzX(this.zze[this.zzf + 1])) {
                i2 = 2;
            } else {
                if ((this.zze[this.zzf] & 240) == 224 && zzd() >= 3) {
                    byte[] bArr = this.zze;
                    int i11 = this.zzf;
                    if (zzX(bArr[i11 + 1]) && zzX(bArr[i11 + 2])) {
                        i2 = 3;
                    }
                }
                if ((this.zze[this.zzf] & 248) == 240 && zzd() >= 4) {
                    byte[] bArr2 = this.zze;
                    int i12 = this.zzf;
                    if (zzX(bArr2[i12 + 1]) && zzX(bArr2[i12 + 2]) && zzX(bArr2[i12 + 3])) {
                        i2 = 4;
                    }
                }
                i2 = 0;
            }
            if (i2 == 1) {
                iZzY = this.zze[this.zzf] & 255;
            } else if (i2 == 2) {
                byte[] bArr3 = this.zze;
                int i13 = this.zzf;
                iZzY = zzY(0, 0, bArr3[i13], bArr3[i13 + 1]);
            } else {
                if (i2 != 3) {
                    if (i2 == 4) {
                        byte[] bArr4 = this.zze;
                        int i14 = this.zzf;
                        iZzY = zzY(bArr4[i14], bArr4[i14 + 1], bArr4[i14 + 2], bArr4[i14 + 3]);
                    }
                    return 0;
                }
                byte[] bArr5 = this.zze;
                int i15 = this.zzf;
                iZzY = zzY(0, bArr5[i15] & 15, bArr5[i15 + 1], bArr5[i15 + 2]);
            }
            i10 = i2;
            codePoint = iZzY;
        } else {
            ByteOrder byteOrder = charset.equals(StandardCharsets.UTF_16LE) ? ByteOrder.LITTLE_ENDIAN : ByteOrder.BIG_ENDIAN;
            char cZzS = zzS(byteOrder, 0);
            if (!Character.isHighSurrogate(cZzS) || zzd() < 4) {
                codePoint = cZzS;
                i10 = 2;
            } else {
                codePoint = Character.toCodePoint(cZzS, zzS(byteOrder, 2));
                i10 = 4;
            }
        }
        return (codePoint << 8) | i10;
    }

    private static int zzV(Charset charset) {
        zzgmd.zzf(zzc.contains(charset), "Unsupported charset: %s", charset);
        return (charset.equals(StandardCharsets.UTF_8) || charset.equals(StandardCharsets.US_ASCII)) ? 1 : 2;
    }

    private final void zzW(int i2) {
        if (!zzd.get() || zzd() >= i2) {
            return;
        }
        int iZzd = zzd();
        throw new IndexOutOfBoundsException(a1.a.f(i2, iZzd, "bytesNeeded= ", ", bytesLeft=", new StringBuilder(String.valueOf(i2).length() + 25 + String.valueOf(iZzd).length())));
    }

    private static boolean zzX(byte b8) {
        return (b8 & 192) == 128;
    }

    private static int zzY(int i2, int i8, int i9, int i10) {
        return zzgst.zze((byte) 0, zzgsx.zza(((i2 & 7) << 2) | ((i8 & 48) >> 4)), zzgsx.zza(((i9 & 60) >> 2) | ((i8 & 15) << 4)), zzgsx.zza((i10 & 63) | ((i9 & 3) << 6)));
    }

    public final long zzA() {
        zzW(4);
        byte[] bArr = this.zze;
        int i2 = this.zzf;
        int i8 = i2 + 1;
        this.zzf = i8;
        long j = bArr[i2];
        int i9 = i2 + 2;
        this.zzf = i9;
        long j3 = bArr[i8];
        int i10 = i2 + 3;
        this.zzf = i10;
        long j8 = bArr[i9];
        this.zzf = i2 + 4;
        return ((((long) bArr[i10]) & 255) << 24) | (255 & j) | ((j3 & 255) << 8) | ((j8 & 255) << 16);
    }

    public final int zzB() {
        zzW(4);
        byte[] bArr = this.zze;
        int i2 = this.zzf;
        int i8 = i2 + 1;
        this.zzf = i8;
        int i9 = bArr[i2] & 255;
        int i10 = i2 + 2;
        this.zzf = i10;
        int i11 = bArr[i8] & 255;
        int i12 = i2 + 3;
        this.zzf = i12;
        int i13 = bArr[i10] & 255;
        this.zzf = i2 + 4;
        return (bArr[i12] & 255) | (i9 << 24) | (i11 << 16) | (i13 << 8);
    }

    public final int zzC() {
        zzW(4);
        byte[] bArr = this.zze;
        int i2 = this.zzf;
        int i8 = i2 + 1;
        this.zzf = i8;
        int i9 = bArr[i2] & 255;
        int i10 = i2 + 2;
        this.zzf = i10;
        int i11 = bArr[i8] & 255;
        int i12 = i2 + 3;
        this.zzf = i12;
        int i13 = bArr[i10] & 255;
        this.zzf = i2 + 4;
        return ((bArr[i12] & 255) << 24) | (i11 << 8) | i9 | (i13 << 16);
    }

    public final long zzD() {
        zzW(8);
        byte[] bArr = this.zze;
        int i2 = this.zzf;
        int i8 = i2 + 1;
        this.zzf = i8;
        long j = bArr[i2];
        int i9 = i2 + 2;
        this.zzf = i9;
        long j3 = bArr[i8];
        int i10 = i2 + 3;
        this.zzf = i10;
        long j8 = bArr[i9];
        int i11 = i2 + 4;
        this.zzf = i11;
        long j9 = bArr[i10];
        int i12 = i2 + 5;
        this.zzf = i12;
        long j10 = bArr[i11];
        int i13 = i2 + 6;
        this.zzf = i13;
        long j11 = bArr[i12];
        int i14 = i2 + 7;
        this.zzf = i14;
        long j12 = bArr[i13];
        this.zzf = i2 + 8;
        return ((j12 & 255) << 8) | ((j & 255) << 56) | ((j3 & 255) << 48) | ((j8 & 255) << 40) | ((j9 & 255) << 32) | ((j10 & 255) << 24) | ((j11 & 255) << 16) | (((long) bArr[i14]) & 255);
    }

    public final long zzE() {
        zzW(8);
        byte[] bArr = this.zze;
        int i2 = this.zzf;
        int i8 = i2 + 1;
        this.zzf = i8;
        long j = bArr[i2];
        int i9 = i2 + 2;
        this.zzf = i9;
        long j3 = bArr[i8];
        int i10 = i2 + 3;
        this.zzf = i10;
        long j8 = bArr[i9];
        int i11 = i2 + 4;
        this.zzf = i11;
        long j9 = bArr[i10];
        int i12 = i2 + 5;
        this.zzf = i12;
        long j10 = bArr[i11];
        int i13 = i2 + 6;
        this.zzf = i13;
        long j11 = bArr[i12];
        int i14 = i2 + 7;
        this.zzf = i14;
        long j12 = bArr[i13];
        this.zzf = i2 + 8;
        return ((j12 & 255) << 48) | (j & 255) | ((j3 & 255) << 8) | ((j8 & 255) << 16) | ((j9 & 255) << 24) | ((j10 & 255) << 32) | ((j11 & 255) << 40) | ((((long) bArr[i14]) & 255) << 56);
    }

    public final int zzF() {
        zzW(4);
        byte[] bArr = this.zze;
        int i2 = this.zzf;
        int i8 = i2 + 1;
        this.zzf = i8;
        int i9 = bArr[i2] & 255;
        this.zzf = i2 + 2;
        int i10 = bArr[i8] & 255;
        this.zzf = i2 + 4;
        return (i9 << 8) | i10;
    }

    public final int zzG() {
        return (zzs() << 21) | (zzs() << 14) | (zzs() << 7) | zzs();
    }

    public final int zzH() {
        int iZzB = zzB();
        if (iZzB >= 0) {
            return iZzB;
        }
        throw new IllegalStateException(androidx.camera.core.processing.util.a.m(new StringBuilder(String.valueOf(iZzB).length() + 18), "Top bit not zero: ", iZzB));
    }

    public final int zzI() {
        int iZzC = zzC();
        if (iZzC >= 0) {
            return iZzC;
        }
        throw new IllegalStateException(androidx.camera.core.processing.util.a.m(new StringBuilder(String.valueOf(iZzC).length() + 18), "Top bit not zero: ", iZzC));
    }

    public final long zzJ() {
        long jZzD = zzD();
        if (jZzD >= 0) {
            return jZzD;
        }
        StringBuilder sb = new StringBuilder(String.valueOf(jZzD).length() + 18);
        sb.append("Top bit not zero: ");
        sb.append(jZzD);
        throw new IllegalStateException(sb.toString());
    }

    public final String zzK(int i2, Charset charset) {
        zzW(i2);
        byte[] bArr = this.zze;
        int i8 = this.zzf;
        String str = new String(bArr, i8, i2, charset);
        this.zzf = i8 + i2;
        return str;
    }

    public final String zzL(int i2) {
        zzW(i2);
        if (i2 == 0) {
            return "";
        }
        int i8 = this.zzf;
        int i9 = (i8 + i2) - 1;
        String strZzj = zzep.zzj(this.zze, i8, (i9 >= this.zzg || this.zze[i9] != 0) ? i2 : i2 - 1);
        this.zzf += i2;
        return strZzj;
    }

    @Nullable
    public final String zzM(char c7) {
        if (zzd() == 0) {
            return null;
        }
        int i2 = this.zzf;
        while (i2 < this.zzg && this.zze[i2] != 0) {
            i2++;
        }
        byte[] bArr = this.zze;
        int i8 = this.zzf;
        String strZzj = zzep.zzj(bArr, i8, i2 - i8);
        this.zzf = i2;
        if (i2 < this.zzg) {
            this.zzf = i2 + 1;
        }
        return strZzj;
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x009c  */
    @androidx.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String zzN(java.nio.charset.Charset r5) {
        /*
            Method dump skipped, instruction units count: 213
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzeg.zzN(java.nio.charset.Charset):java.lang.String");
    }

    public final long zzO() {
        int i2;
        zzW(1);
        long j = this.zze[this.zzf];
        int i8 = 7;
        while (true) {
            i2 = 0;
            if (i8 < 0) {
                break;
            }
            int i9 = 1 << i8;
            if ((((long) i9) & j) != 0) {
                i8--;
            } else if (i8 < 6) {
                j &= (long) (i9 - 1);
                i2 = 7 - i8;
            } else if (i8 == 7) {
                i2 = 1;
            }
        }
        if (i2 == 0) {
            StringBuilder sb = new StringBuilder(String.valueOf(j).length() + 35);
            sb.append("Invalid UTF-8 sequence first byte: ");
            sb.append(j);
            throw new NumberFormatException(sb.toString());
        }
        zzW(i2);
        for (int i10 = 1; i10 < i2; i10++) {
            byte b8 = this.zze[this.zzf + i10];
            if ((b8 & 192) != 128) {
                StringBuilder sb2 = new StringBuilder(String.valueOf(j).length() + 42);
                sb2.append("Invalid UTF-8 sequence continuation byte: ");
                sb2.append(j);
                throw new NumberFormatException(sb2.toString());
            }
            j = (j << 6) | ((long) (b8 & 63));
        }
        this.zzf += i2;
        return j;
    }

    public final long zzP() {
        long j = 0;
        for (int i2 = 0; i2 < 9; i2++) {
            if (this.zzf == this.zzg) {
                throw new IllegalStateException("Attempting to read a byte over the limit.");
            }
            long jZzs = zzs();
            j |= (127 & jZzs) << (i2 * 7);
            if ((jZzs & 128) == 0) {
                return j;
            }
        }
        return j;
    }

    public final void zzQ() {
        while ((zzs() & 128) != 0) {
        }
    }

    @Nullable
    public final Charset zzR() {
        if (zzd() >= 3) {
            byte[] bArr = this.zze;
            int i2 = this.zzf;
            if (bArr[i2] == -17 && bArr[i2 + 1] == -69 && bArr[i2 + 2] == -65) {
                this.zzf = i2 + 3;
                return StandardCharsets.UTF_8;
            }
        }
        if (zzd() < 2) {
            return null;
        }
        byte[] bArr2 = this.zze;
        int i8 = this.zzf;
        byte b8 = bArr2[i8];
        if (b8 == -2) {
            if (bArr2[i8 + 1] != -1) {
                return null;
            }
            this.zzf = i8 + 2;
            return StandardCharsets.UTF_16BE;
        }
        if (b8 != -1 || bArr2[i8 + 1] != -2) {
            return null;
        }
        this.zzf = i8 + 2;
        return StandardCharsets.UTF_16LE;
    }

    public final void zza(int i2) {
        byte[] bArr = this.zze;
        if (bArr.length < i2) {
            bArr = new byte[i2];
        }
        zzb(bArr, i2);
    }

    public final void zzb(byte[] bArr, int i2) {
        this.zze = bArr;
        this.zzg = i2;
        this.zzf = 0;
    }

    public final void zzc(int i2) {
        byte[] bArr = this.zze;
        if (i2 > bArr.length) {
            this.zze = Arrays.copyOf(bArr, i2);
        }
    }

    public final int zzd() {
        return Math.max(this.zzg - this.zzf, 0);
    }

    public final int zze() {
        return this.zzg;
    }

    public final void zzf(int i2) {
        boolean z2 = false;
        if (i2 >= 0 && i2 <= this.zze.length) {
            z2 = true;
        }
        zzgmd.zza(z2);
        this.zzg = i2;
    }

    public final int zzg() {
        return this.zzf;
    }

    public final void zzh(int i2) {
        boolean z2 = false;
        if (i2 >= 0 && i2 <= this.zzg) {
            z2 = true;
        }
        zzgmd.zza(z2);
        this.zzf = i2;
    }

    public final byte[] zzi() {
        return this.zze;
    }

    public final int zzj() {
        return this.zze.length;
    }

    public final void zzk(int i2) {
        zzh(this.zzf + i2);
    }

    public final void zzl(zzef zzefVar, int i2) {
        zzm(zzefVar.zza, 0, i2);
        zzefVar.zzf(0);
    }

    public final void zzm(byte[] bArr, int i2, int i8) {
        zzW(i8);
        System.arraycopy(this.zze, this.zzf, bArr, i2, i8);
        this.zzf += i8;
    }

    public final int zzn() {
        zzW(1);
        return this.zze[this.zzf] & 255;
    }

    public final char zzo() {
        return zzS(ByteOrder.BIG_ENDIAN, 0);
    }

    public final int zzp(Charset charset) {
        if (zzU(charset) != 0) {
            return zzgst.zza(r3 >>> 8);
        }
        return 1114112;
    }

    public final int zzq() {
        if (zzd() >= 3) {
            this.zzf -= 3;
            return zzx();
        }
        int i2 = this.zzf;
        int i8 = this.zzg;
        throw new IndexOutOfBoundsException(a1.a.f(i2, i8, "position=", ", limit=", new StringBuilder(String.valueOf(i2).length() + 17 + String.valueOf(i8).length())));
    }

    public final int zzr() {
        if (zzd() >= 4) {
            this.zzf -= 4;
            return zzB();
        }
        int i2 = this.zzf;
        int i8 = this.zzg;
        throw new IndexOutOfBoundsException(a1.a.f(i2, i8, "position=", ", limit=", new StringBuilder(String.valueOf(i2).length() + 17 + String.valueOf(i8).length())));
    }

    public final int zzs() {
        zzW(1);
        byte[] bArr = this.zze;
        int i2 = this.zzf;
        this.zzf = i2 + 1;
        return bArr[i2] & 255;
    }

    public final int zzt() {
        zzW(2);
        byte[] bArr = this.zze;
        int i2 = this.zzf;
        int i8 = i2 + 1;
        this.zzf = i8;
        int i9 = bArr[i2] & 255;
        this.zzf = i2 + 2;
        return (bArr[i8] & 255) | (i9 << 8);
    }

    public final int zzu() {
        zzW(2);
        byte[] bArr = this.zze;
        int i2 = this.zzf;
        int i8 = i2 + 1;
        this.zzf = i8;
        int i9 = bArr[i2] & 255;
        this.zzf = i2 + 2;
        return ((bArr[i8] & 255) << 8) | i9;
    }

    public final short zzv() {
        zzW(2);
        byte[] bArr = this.zze;
        int i2 = this.zzf;
        int i8 = i2 + 1;
        this.zzf = i8;
        int i9 = bArr[i2] & 255;
        this.zzf = i2 + 2;
        return (short) ((bArr[i8] & 255) | (i9 << 8));
    }

    public final short zzw() {
        zzW(2);
        byte[] bArr = this.zze;
        int i2 = this.zzf;
        int i8 = i2 + 1;
        this.zzf = i8;
        int i9 = bArr[i2] & 255;
        this.zzf = i2 + 2;
        return (short) (((bArr[i8] & 255) << 8) | i9);
    }

    public final int zzx() {
        zzW(3);
        byte[] bArr = this.zze;
        int i2 = this.zzf;
        int i8 = i2 + 1;
        this.zzf = i8;
        int i9 = bArr[i2] & 255;
        int i10 = i2 + 2;
        this.zzf = i10;
        int i11 = bArr[i8] & 255;
        this.zzf = i2 + 3;
        return (bArr[i10] & 255) | (i9 << 16) | (i11 << 8);
    }

    public final int zzy() {
        zzW(3);
        byte[] bArr = this.zze;
        int i2 = this.zzf;
        int i8 = i2 + 1;
        this.zzf = i8;
        int i9 = bArr[i2] & 255;
        int i10 = i2 + 2;
        this.zzf = i10;
        int i11 = bArr[i8] & 255;
        this.zzf = i2 + 3;
        return (bArr[i10] & 255) | ((i9 << 24) >> 8) | (i11 << 8);
    }

    public final long zzz() {
        zzW(4);
        byte[] bArr = this.zze;
        int i2 = this.zzf;
        int i8 = i2 + 1;
        this.zzf = i8;
        long j = bArr[i2];
        int i9 = i2 + 2;
        this.zzf = i9;
        long j3 = bArr[i8];
        int i10 = i2 + 3;
        this.zzf = i10;
        long j8 = bArr[i9];
        this.zzf = i2 + 4;
        return (((long) bArr[i10]) & 255) | ((j & 255) << 24) | ((j3 & 255) << 16) | ((j8 & 255) << 8);
    }

    public zzeg() {
        this.zze = zzep.zzb;
    }

    public zzeg(int i2) {
        this.zze = new byte[i2];
        this.zzg = i2;
    }

    public zzeg(byte[] bArr) {
        this.zze = bArr;
        this.zzg = bArr.length;
    }
}
