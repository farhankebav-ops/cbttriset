package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzhvl extends zzhvn {
    private final InputStream zza;
    private final byte[] zzg;
    private int zzh;
    private int zzi;
    private int zzj;
    private int zzk;
    private int zzl;
    private int zzm;

    public /* synthetic */ zzhvl(InputStream inputStream, int i2, byte[] bArr) {
        super(null);
        this.zzm = Integer.MAX_VALUE;
        byte[] bArr2 = zzhxb.zzb;
        this.zza = inputStream;
        this.zzg = new byte[4096];
        this.zzh = 0;
        this.zzj = 0;
        this.zzl = 0;
    }

    private final void zzN() {
        int i2 = this.zzh + this.zzi;
        this.zzh = i2;
        int i8 = this.zzl + i2;
        int i9 = this.zzm;
        if (i8 <= i9) {
            this.zzi = 0;
            return;
        }
        int i10 = i8 - i9;
        this.zzi = i10;
        this.zzh = i2 - i10;
    }

    private final void zzO(int i2) throws IOException {
        if (zzP(i2)) {
            return;
        }
        if (i2 <= (Integer.MAX_VALUE - this.zzl) - this.zzj) {
            throw new zzhxd("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
        throw new zzhxd("Protocol message was too large.  May be malicious.  Use CodedInputStream.setSizeLimit() to increase the size limit. If reading multiple messages, consider resetting the counter between each message using CodedInputStream.resetSizeCounter().");
    }

    private final boolean zzP(int i2) throws IOException {
        int i8 = this.zzj;
        int i9 = i8 + i2;
        int i10 = this.zzh;
        if (i9 <= i10) {
            throw new IllegalStateException(com.google.android.gms.ads.internal.client.a.j(new StringBuilder(String.valueOf(i2).length() + 66), "refillBuffer() called when ", i2, " bytes were already available in buffer"));
        }
        int i11 = this.zzl;
        if (i2 > (Integer.MAX_VALUE - i11) - i8 || i11 + i8 + i2 > this.zzm) {
            return false;
        }
        if (i8 > 0) {
            if (i10 > i8) {
                byte[] bArr = this.zzg;
                System.arraycopy(bArr, i8, bArr, 0, i10 - i8);
            }
            i11 = this.zzl + i8;
            this.zzl = i11;
            i10 = this.zzh - i8;
            this.zzh = i10;
            this.zzj = 0;
        }
        try {
            int i12 = this.zza.read(this.zzg, i10, Math.min(4096 - i10, (Integer.MAX_VALUE - i11) - i10));
            if (i12 != 0 && i12 >= -1 && i12 <= 4096) {
                if (i12 <= 0) {
                    return false;
                }
                this.zzh += i12;
                zzN();
                return this.zzh >= i2 || zzP(i2);
            }
            String strValueOf = String.valueOf(this.zza.getClass());
            StringBuilder sb = new StringBuilder(String.valueOf(i12).length() + strValueOf.length() + 39 + 41);
            sb.append(strValueOf);
            sb.append("#read(byte[]) returned invalid result: ");
            sb.append(i12);
            sb.append("\nThe InputStream implementation is buggy.");
            throw new IllegalStateException(sb.toString());
        } catch (zzhxd e) {
            e.zza();
            throw e;
        }
    }

    private final byte[] zzQ(int i2, boolean z2) throws IOException {
        byte[] bArrZzR = zzR(i2);
        if (bArrZzR != null) {
            return bArrZzR;
        }
        int i8 = this.zzj;
        int i9 = this.zzh;
        int i10 = i9 - i8;
        this.zzl += i9;
        this.zzj = 0;
        this.zzh = 0;
        List<byte[]> listZzS = zzS(i2 - i10);
        byte[] bArr = new byte[i2];
        System.arraycopy(this.zzg, i8, bArr, 0, i10);
        for (byte[] bArr2 : listZzS) {
            int length = bArr2.length;
            System.arraycopy(bArr2, 0, bArr, i10, length);
            i10 += length;
        }
        return bArr;
    }

    private final byte[] zzR(int i2) throws IOException {
        if (i2 == 0) {
            return zzhxb.zzb;
        }
        int i8 = this.zzl;
        int i9 = this.zzj;
        int i10 = i8 + i9 + i2;
        if ((-2147483647) + i10 > 0) {
            throw new zzhxd("Protocol message was too large.  May be malicious.  Use CodedInputStream.setSizeLimit() to increase the size limit. If reading multiple messages, consider resetting the counter between each message using CodedInputStream.resetSizeCounter().");
        }
        int i11 = this.zzm;
        if (i10 > i11) {
            zzE((i11 - i8) - i9);
            throw new zzhxd("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
        int i12 = this.zzh - i9;
        int i13 = i2 - i12;
        if (i13 >= 4096) {
            try {
                if (i13 > this.zza.available()) {
                    return null;
                }
            } catch (zzhxd e) {
                e.zza();
                throw e;
            }
        }
        byte[] bArr = new byte[i2];
        System.arraycopy(this.zzg, this.zzj, bArr, 0, i12);
        this.zzl += this.zzh;
        this.zzj = 0;
        this.zzh = 0;
        while (i12 < i2) {
            try {
                int i14 = this.zza.read(bArr, i12, i2 - i12);
                if (i14 == -1) {
                    throw new zzhxd("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                }
                this.zzl += i14;
                i12 += i14;
            } catch (zzhxd e4) {
                e4.zza();
                throw e4;
            }
        }
        return bArr;
    }

    private final List zzS(int i2) throws IOException {
        ArrayList arrayList = new ArrayList();
        while (i2 > 0) {
            int iMin = Math.min(i2, 4096);
            byte[] bArr = new byte[iMin];
            int i8 = 0;
            while (i8 < iMin) {
                int i9 = this.zza.read(bArr, i8, iMin - i8);
                if (i9 == -1) {
                    throw new zzhxd("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                }
                this.zzl += i9;
                i8 += i9;
            }
            i2 -= iMin;
            arrayList.add(bArr);
        }
        return arrayList;
    }

    @Override // com.google.android.gms.internal.ads.zzhvn
    public final void zzA(int i2) {
        this.zzm = i2;
        zzN();
    }

    @Override // com.google.android.gms.internal.ads.zzhvn
    public final boolean zzB() throws IOException {
        return this.zzj == this.zzh && !zzP(1);
    }

    @Override // com.google.android.gms.internal.ads.zzhvn
    public final int zzC() {
        return this.zzl + this.zzj;
    }

    public final byte zzD() throws IOException {
        if (this.zzj == this.zzh) {
            zzO(1);
        }
        byte[] bArr = this.zzg;
        int i2 = this.zzj;
        this.zzj = i2 + 1;
        return bArr[i2];
    }

    public final void zzE(int i2) throws IOException {
        int i8 = this.zzh;
        int i9 = this.zzj;
        int i10 = i8 - i9;
        if (i2 <= i10 && i2 >= 0) {
            this.zzj = i9 + i2;
            return;
        }
        if (i2 < 0) {
            throw new zzhxd("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        }
        int i11 = this.zzl;
        int i12 = i11 + i9;
        int i13 = this.zzm;
        if (i12 + i2 > i13) {
            zzE((i13 - i11) - i9);
            throw new zzhxd("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
        this.zzl = i12;
        this.zzh = 0;
        this.zzj = 0;
        while (i10 < i2) {
            try {
                long j = i2 - i10;
                try {
                    long jSkip = this.zza.skip(j);
                    if (jSkip < 0 || jSkip > j) {
                        String strValueOf = String.valueOf(this.zza.getClass());
                        StringBuilder sb = new StringBuilder(strValueOf.length() + 31 + String.valueOf(jSkip).length() + 41);
                        sb.append(strValueOf);
                        sb.append("#skip returned invalid result: ");
                        sb.append(jSkip);
                        sb.append("\nThe InputStream implementation is buggy.");
                        throw new IllegalStateException(sb.toString());
                    }
                    if (jSkip == 0) {
                        break;
                    } else {
                        i10 += (int) jSkip;
                    }
                } catch (zzhxd e) {
                    e.zza();
                    throw e;
                }
            } catch (Throwable th) {
                this.zzl += i10;
                zzN();
                throw th;
            }
        }
        this.zzl += i10;
        zzN();
        if (i10 >= i2) {
            return;
        }
        int i14 = this.zzh;
        int i15 = i14 - this.zzj;
        this.zzj = i14;
        zzO(1);
        while (true) {
            int i16 = i2 - i15;
            int i17 = this.zzh;
            if (i16 <= i17) {
                this.zzj = i16;
                return;
            } else {
                i15 += i17;
                this.zzj = i17;
                zzO(1);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhvn
    public final int zza() throws IOException {
        if (zzB()) {
            this.zzk = 0;
            return 0;
        }
        int iZzu = zzu();
        this.zzk = iZzu;
        if ((iZzu >>> 3) != 0) {
            return iZzu;
        }
        throw new zzhxd("Protocol message contained an invalid tag (zero).");
    }

    @Override // com.google.android.gms.internal.ads.zzhvn
    public final void zzb(int i2) throws zzhxd {
        if (this.zzk != i2) {
            throw new zzhxd("Protocol message end-group tag did not match expected tag.");
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhvn
    public final boolean zzc(int i2) throws IOException {
        int i8 = i2 & 7;
        int i9 = 0;
        if (i8 == 0) {
            if (this.zzh - this.zzj < 10) {
                while (i9 < 10) {
                    if (zzD() < 0) {
                        i9++;
                    }
                }
                throw new zzhxd("CodedInputStream encountered a malformed varint.");
            }
            while (i9 < 10) {
                byte[] bArr = this.zzg;
                int i10 = this.zzj;
                this.zzj = i10 + 1;
                if (bArr[i10] < 0) {
                    i9++;
                }
            }
            throw new zzhxd("CodedInputStream encountered a malformed varint.");
            return true;
        }
        if (i8 == 1) {
            zzE(8);
            return true;
        }
        if (i8 == 2) {
            zzE(zzu());
            return true;
        }
        if (i8 == 3) {
            zzJ();
            zzb(((i2 >>> 3) << 3) | 4);
            return true;
        }
        if (i8 == 4) {
            zzI();
            return false;
        }
        if (i8 != 5) {
            throw new zzhxc("Protocol message tag had invalid wire type.");
        }
        zzE(4);
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzhvn
    public final double zzd() throws IOException {
        return Double.longBitsToDouble(zzy());
    }

    @Override // com.google.android.gms.internal.ads.zzhvn
    public final float zze() throws IOException {
        return Float.intBitsToFloat(zzx());
    }

    @Override // com.google.android.gms.internal.ads.zzhvn
    public final long zzf() throws IOException {
        return zzv();
    }

    @Override // com.google.android.gms.internal.ads.zzhvn
    public final long zzg() throws IOException {
        return zzv();
    }

    @Override // com.google.android.gms.internal.ads.zzhvn
    public final int zzh() throws IOException {
        return zzu();
    }

    @Override // com.google.android.gms.internal.ads.zzhvn
    public final long zzi() throws IOException {
        return zzy();
    }

    @Override // com.google.android.gms.internal.ads.zzhvn
    public final int zzj() throws IOException {
        return zzx();
    }

    @Override // com.google.android.gms.internal.ads.zzhvn
    public final boolean zzk() throws IOException {
        return zzv() != 0;
    }

    @Override // com.google.android.gms.internal.ads.zzhvn
    public final String zzl() throws IOException {
        int iZzu = zzu();
        if (iZzu > 0) {
            int i2 = this.zzh;
            int i8 = this.zzj;
            if (iZzu <= i2 - i8) {
                String str = new String(this.zzg, i8, iZzu, zzhxb.zza);
                this.zzj += iZzu;
                return str;
            }
        }
        if (iZzu == 0) {
            return "";
        }
        if (iZzu < 0) {
            throw new zzhxd("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        }
        if (iZzu > this.zzh) {
            return new String(zzQ(iZzu, false), zzhxb.zza);
        }
        zzO(iZzu);
        String str2 = new String(this.zzg, this.zzj, iZzu, zzhxb.zza);
        this.zzj += iZzu;
        return str2;
    }

    @Override // com.google.android.gms.internal.ads.zzhvn
    public final String zzm() throws IOException {
        byte[] bArrZzQ;
        int iZzu = zzu();
        int i2 = this.zzj;
        int i8 = this.zzh;
        if (iZzu <= i8 - i2 && iZzu > 0) {
            bArrZzQ = this.zzg;
            this.zzj = i2 + iZzu;
        } else {
            if (iZzu == 0) {
                return "";
            }
            if (iZzu < 0) {
                throw new zzhxd("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
            }
            i2 = 0;
            if (iZzu <= i8) {
                zzO(iZzu);
                bArrZzQ = this.zzg;
                this.zzj = iZzu;
            } else {
                bArrZzQ = zzQ(iZzu, false);
            }
        }
        return zzhzo.zzf(bArrZzQ, i2, iZzu);
    }

    @Override // com.google.android.gms.internal.ads.zzhvn
    public final zzhvi zzn() throws IOException {
        int iZzu = zzu();
        int i2 = this.zzh;
        int i8 = this.zzj;
        if (iZzu <= i2 - i8 && iZzu > 0) {
            zzhvi zzhviVarZzr = zzhvi.zzr(this.zzg, i8, iZzu);
            this.zzj += iZzu;
            return zzhviVarZzr;
        }
        if (iZzu == 0) {
            return zzhvi.zzb;
        }
        if (iZzu < 0) {
            throw new zzhxd("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        }
        byte[] bArrZzR = zzR(iZzu);
        if (bArrZzR != null) {
            return zzhvi.zzr(bArrZzR, 0, bArrZzR.length);
        }
        int i9 = this.zzj;
        int i10 = this.zzh;
        int i11 = i10 - i9;
        this.zzl += i10;
        this.zzj = 0;
        this.zzh = 0;
        List<byte[]> listZzS = zzS(iZzu - i11);
        byte[] bArr = new byte[iZzu];
        System.arraycopy(this.zzg, i9, bArr, 0, i11);
        for (byte[] bArr2 : listZzS) {
            int length = bArr2.length;
            System.arraycopy(bArr2, 0, bArr, i11, length);
            i11 += length;
        }
        zzhvi zzhviVar = zzhvi.zzb;
        return new zzhvg(bArr);
    }

    @Override // com.google.android.gms.internal.ads.zzhvn
    public final int zzo() throws IOException {
        return zzu();
    }

    @Override // com.google.android.gms.internal.ads.zzhvn
    public final int zzp() throws IOException {
        return zzu();
    }

    @Override // com.google.android.gms.internal.ads.zzhvn
    public final int zzq() throws IOException {
        return zzx();
    }

    @Override // com.google.android.gms.internal.ads.zzhvn
    public final long zzr() throws IOException {
        return zzy();
    }

    @Override // com.google.android.gms.internal.ads.zzhvn
    public final int zzs() throws IOException {
        return zzhvn.zzK(zzu());
    }

    @Override // com.google.android.gms.internal.ads.zzhvn
    public final long zzt() throws IOException {
        return zzhvn.zzL(zzv());
    }

    public final int zzu() throws IOException {
        int i2;
        int i8 = this.zzj;
        int i9 = this.zzh;
        if (i9 != i8) {
            byte[] bArr = this.zzg;
            int i10 = i8 + 1;
            byte b8 = bArr[i8];
            if (b8 >= 0) {
                this.zzj = i10;
                return b8;
            }
            if (i9 - i10 >= 9) {
                int i11 = i8 + 2;
                int i12 = (bArr[i10] << 7) ^ b8;
                if (i12 < 0) {
                    i2 = i12 ^ (-128);
                } else {
                    int i13 = i8 + 3;
                    int i14 = (bArr[i11] << 14) ^ i12;
                    if (i14 >= 0) {
                        i2 = i14 ^ 16256;
                    } else {
                        int i15 = i8 + 4;
                        int i16 = i14 ^ (bArr[i13] << 21);
                        if (i16 < 0) {
                            i2 = (-2080896) ^ i16;
                        } else {
                            i13 = i8 + 5;
                            byte b9 = bArr[i15];
                            int i17 = (i16 ^ (b9 << 28)) ^ 266354560;
                            if (b9 < 0) {
                                i15 = i8 + 6;
                                if (bArr[i13] < 0) {
                                    i13 = i8 + 7;
                                    if (bArr[i15] < 0) {
                                        i15 = i8 + 8;
                                        if (bArr[i13] < 0) {
                                            i13 = i8 + 9;
                                            if (bArr[i15] < 0) {
                                                int i18 = i8 + 10;
                                                if (bArr[i13] >= 0) {
                                                    i11 = i18;
                                                    i2 = i17;
                                                }
                                            }
                                        }
                                    }
                                }
                                i2 = i17;
                            }
                            i2 = i17;
                        }
                        i11 = i15;
                    }
                    i11 = i13;
                }
                this.zzj = i11;
                return i2;
            }
        }
        return (int) zzw();
    }

    /* JADX WARN: Code restructure failed: missing block: B:39:0x00b7, code lost:
    
        if (r2[r5] >= 0) goto L28;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final long zzv() throws java.io.IOException {
        /*
            r13 = this;
            int r0 = r13.zzj
            int r1 = r13.zzh
            if (r1 != r0) goto L8
            goto Lbf
        L8:
            byte[] r2 = r13.zzg
            int r3 = r0 + 1
            r4 = r2[r0]
            if (r4 < 0) goto L14
            r13.zzj = r3
            long r0 = (long) r4
            return r0
        L14:
            int r1 = r1 - r3
            r5 = 9
            if (r1 < r5) goto Lbf
            int r1 = r0 + 2
            r3 = r2[r3]
            int r3 = r3 << 7
            r3 = r3 ^ r4
            if (r3 >= 0) goto L27
            r0 = r3 ^ (-128(0xffffffffffffff80, float:NaN))
            long r2 = (long) r0
            goto Lbc
        L27:
            int r4 = r0 + 3
            r1 = r2[r1]
            int r1 = r1 << 14
            r1 = r1 ^ r3
            if (r1 < 0) goto L36
            r0 = r1 ^ 16256(0x3f80, float:2.278E-41)
            long r2 = (long) r0
        L33:
            r1 = r4
            goto Lbc
        L36:
            int r3 = r0 + 4
            r4 = r2[r4]
            int r4 = r4 << 21
            r1 = r1 ^ r4
            if (r1 >= 0) goto L49
            r0 = -2080896(0xffffffffffe03f80, float:NaN)
            r0 = r0 ^ r1
            long r0 = (long) r0
            r11 = r0
            r1 = r3
            r2 = r11
            goto Lbc
        L49:
            int r4 = r0 + 5
            r3 = r2[r3]
            long r5 = (long) r3
            long r7 = (long) r1
            r1 = 28
            long r5 = r5 << r1
            long r5 = r5 ^ r7
            r7 = 0
            int r1 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r1 < 0) goto L5f
            r0 = 266354560(0xfe03f80, double:1.315966377E-315)
            long r2 = r5 ^ r0
            goto L33
        L5f:
            int r1 = r0 + 6
            r3 = r2[r4]
            long r3 = (long) r3
            r9 = 35
            long r3 = r3 << r9
            long r3 = r3 ^ r5
            int r5 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
            if (r5 >= 0) goto L74
            r5 = -34093383808(0xfffffff80fe03f80, double:NaN)
        L71:
            long r3 = r3 ^ r5
        L72:
            r2 = r3
            goto Lbc
        L74:
            int r5 = r0 + 7
            r1 = r2[r1]
            long r9 = (long) r1
            r1 = 42
            long r9 = r9 << r1
            long r3 = r3 ^ r9
            int r1 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
            if (r1 < 0) goto L8a
            r0 = 4363953127296(0x3f80fe03f80, double:2.1560793202584E-311)
            long r0 = r0 ^ r3
            r2 = r0
        L88:
            r1 = r5
            goto Lbc
        L8a:
            int r1 = r0 + 8
            r5 = r2[r5]
            long r5 = (long) r5
            r9 = 49
            long r5 = r5 << r9
            long r3 = r3 ^ r5
            int r5 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
            if (r5 >= 0) goto L9d
            r5 = -558586000294016(0xfffe03f80fe03f80, double:NaN)
            goto L71
        L9d:
            int r5 = r0 + 9
            r1 = r2[r1]
            long r9 = (long) r1
            r1 = 56
            long r9 = r9 << r1
            long r3 = r3 ^ r9
            r9 = 71499008037633920(0xfe03f80fe03f80, double:6.838959413692434E-304)
            long r3 = r3 ^ r9
            int r1 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
            if (r1 >= 0) goto Lba
            int r1 = r0 + 10
            r0 = r2[r5]
            long r5 = (long) r0
            int r0 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r0 < 0) goto Lbf
            goto L72
        Lba:
            r2 = r3
            goto L88
        Lbc:
            r13.zzj = r1
            return r2
        Lbf:
            long r0 = r13.zzw()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzhvl.zzv():long");
    }

    public final long zzw() throws IOException {
        long j = 0;
        for (int i2 = 0; i2 < 64; i2 += 7) {
            byte bZzD = zzD();
            j |= ((long) (bZzD & 127)) << i2;
            if ((bZzD & 128) == 0) {
                return j;
            }
        }
        throw new zzhxd("CodedInputStream encountered a malformed varint.");
    }

    public final int zzx() throws IOException {
        int i2 = this.zzj;
        if (this.zzh - i2 < 4) {
            zzO(4);
            i2 = this.zzj;
        }
        byte[] bArr = this.zzg;
        this.zzj = i2 + 4;
        int i8 = bArr[i2] & 255;
        int i9 = bArr[i2 + 1] & 255;
        int i10 = bArr[i2 + 2] & 255;
        return ((bArr[i2 + 3] & 255) << 24) | (i9 << 8) | i8 | (i10 << 16);
    }

    public final long zzy() throws IOException {
        int i2 = this.zzj;
        if (this.zzh - i2 < 8) {
            zzO(8);
            i2 = this.zzj;
        }
        byte[] bArr = this.zzg;
        this.zzj = i2 + 8;
        long j = bArr[i2];
        long j3 = (((long) bArr[i2 + 1]) & 255) << 8;
        long j8 = bArr[i2 + 2];
        long j9 = bArr[i2 + 3];
        return ((((long) bArr[i2 + 6]) & 255) << 48) | (j & 255) | j3 | ((j8 & 255) << 16) | ((j9 & 255) << 24) | ((bArr[i2 + 4] & 255) << 32) | ((bArr[i2 + 5] & 255) << 40) | ((((long) bArr[i2 + 7]) & 255) << 56);
    }

    @Override // com.google.android.gms.internal.ads.zzhvn
    public final int zzz(int i2) throws zzhxd {
        if (i2 < 0) {
            throw new zzhxd("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        }
        int i8 = this.zzl + this.zzj + i2;
        if (i8 < 0) {
            throw new zzhxd("Protocol message was too large.  May be malicious.  Use CodedInputStream.setSizeLimit() to increase the size limit. If reading multiple messages, consider resetting the counter between each message using CodedInputStream.resetSizeCounter().");
        }
        int i9 = this.zzm;
        if (i8 > i9) {
            throw new zzhxd("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
        this.zzm = i8;
        zzN();
        return i9;
    }
}
