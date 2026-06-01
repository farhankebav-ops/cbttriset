package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzhvk extends zzhvn {
    private final Iterable zza;
    private final Iterator zzg;
    private ByteBuffer zzh;
    private int zzi;
    private int zzj;
    private int zzk;
    private int zzl;
    private int zzm;
    private long zzn;
    private long zzo;
    private long zzp;

    public /* synthetic */ zzhvk(Iterable iterable, int i2, boolean z2, byte[] bArr) {
        super(null);
        this.zzk = Integer.MAX_VALUE;
        this.zzi = i2;
        this.zza = iterable;
        this.zzg = iterable.iterator();
        this.zzm = 0;
        if (i2 != 0) {
            zzO();
            return;
        }
        this.zzh = zzhxb.zzc;
        this.zzn = 0L;
        this.zzo = 0L;
        this.zzp = 0L;
    }

    private final void zzN() throws zzhxd {
        if (!this.zzg.hasNext()) {
            throw new zzhxd("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
        zzO();
    }

    private final void zzO() {
        ByteBuffer byteBuffer = (ByteBuffer) this.zzg.next();
        this.zzh = byteBuffer;
        this.zzm += (int) (this.zzn - this.zzo);
        long jPosition = byteBuffer.position();
        this.zzn = jPosition;
        this.zzo = jPosition;
        this.zzp = this.zzh.limit();
        long jZzs = zzhzj.zzs(this.zzh);
        this.zzn += jZzs;
        this.zzo += jZzs;
        this.zzp += jZzs;
    }

    private final void zzP() {
        int i2 = this.zzi + this.zzj;
        this.zzi = i2;
        int i8 = this.zzk;
        if (i2 <= i8) {
            this.zzj = 0;
            return;
        }
        int i9 = i2 - i8;
        this.zzj = i9;
        this.zzi = i2 - i9;
    }

    private final void zzQ(byte[] bArr, int i2, int i8) throws IOException {
        if (i8 > zzR()) {
            if (i8 > 0) {
                throw new zzhxd("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
            }
            return;
        }
        int i9 = i8;
        while (i9 > 0) {
            if (this.zzp - this.zzn == 0) {
                zzN();
            }
            int iMin = Math.min(i9, (int) (this.zzp - this.zzn));
            long j = iMin;
            zzhzj.zzq(this.zzn, bArr, i8 - i9, j);
            i9 -= iMin;
            this.zzn += j;
        }
    }

    private final int zzR() {
        return (int) ((((long) (this.zzi - this.zzm)) - this.zzn) + this.zzo);
    }

    @Override // com.google.android.gms.internal.ads.zzhvn
    public final void zzA(int i2) {
        this.zzk = i2;
        zzP();
    }

    @Override // com.google.android.gms.internal.ads.zzhvn
    public final boolean zzB() throws IOException {
        return (((long) this.zzm) + this.zzn) - this.zzo == ((long) this.zzi);
    }

    @Override // com.google.android.gms.internal.ads.zzhvn
    public final int zzC() {
        return (int) ((((long) this.zzm) + this.zzn) - this.zzo);
    }

    public final byte zzD() throws IOException {
        if (this.zzp - this.zzn == 0) {
            zzN();
        }
        long j = this.zzn;
        this.zzn = 1 + j;
        return zzhzj.zzr(j);
    }

    public final void zzE(int i2) throws IOException {
        if (i2 >= 0) {
            if (i2 <= (((long) (this.zzi - this.zzm)) - this.zzn) + this.zzo) {
                while (i2 > 0) {
                    if (this.zzp - this.zzn == 0) {
                        zzN();
                    }
                    int iMin = Math.min(i2, (int) (this.zzp - this.zzn));
                    i2 -= iMin;
                    this.zzn += (long) iMin;
                }
                return;
            }
        }
        if (i2 >= 0) {
            throw new zzhxd("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
        throw new zzhxd("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    @Override // com.google.android.gms.internal.ads.zzhvn
    public final int zza() throws IOException {
        if (zzB()) {
            this.zzl = 0;
            return 0;
        }
        int iZzu = zzu();
        this.zzl = iZzu;
        if ((iZzu >>> 3) != 0) {
            return iZzu;
        }
        throw new zzhxd("Protocol message contained an invalid tag (zero).");
    }

    @Override // com.google.android.gms.internal.ads.zzhvn
    public final void zzb(int i2) throws zzhxd {
        if (this.zzl != i2) {
            throw new zzhxd("Protocol message end-group tag did not match expected tag.");
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhvn
    public final boolean zzc(int i2) throws IOException {
        int i8 = i2 & 7;
        if (i8 == 0) {
            for (int i9 = 0; i9 < 10; i9++) {
                if (zzD() >= 0) {
                    return true;
                }
            }
            throw new zzhxd("CodedInputStream encountered a malformed varint.");
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
            long j = this.zzp;
            long j3 = this.zzn;
            long j8 = iZzu;
            if (j8 <= j - j3) {
                byte[] bArr = new byte[iZzu];
                zzhzj.zzq(j3, bArr, 0L, j8);
                String str = new String(bArr, zzhxb.zza);
                this.zzn += j8;
                return str;
            }
        }
        if (iZzu > 0 && iZzu <= zzR()) {
            byte[] bArr2 = new byte[iZzu];
            zzQ(bArr2, 0, iZzu);
            return new String(bArr2, zzhxb.zza);
        }
        if (iZzu == 0) {
            return "";
        }
        if (iZzu < 0) {
            throw new zzhxd("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        }
        throw new zzhxd("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    @Override // com.google.android.gms.internal.ads.zzhvn
    public final String zzm() throws IOException {
        int iZzu = zzu();
        if (iZzu > 0) {
            long j = this.zzp;
            long j3 = this.zzn;
            long j8 = iZzu;
            if (j8 <= j - j3) {
                String strZze = zzhzo.zze(this.zzh, (int) (j3 - this.zzo), iZzu);
                this.zzn += j8;
                return strZze;
            }
        }
        if (iZzu >= 0 && iZzu <= zzR()) {
            byte[] bArr = new byte[iZzu];
            zzQ(bArr, 0, iZzu);
            return zzhzo.zzf(bArr, 0, iZzu);
        }
        if (iZzu == 0) {
            return "";
        }
        if (iZzu <= 0) {
            throw new zzhxd("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        }
        throw new zzhxd("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    @Override // com.google.android.gms.internal.ads.zzhvn
    public final zzhvi zzn() throws IOException {
        int iZzu = zzu();
        if (iZzu > 0) {
            long j = this.zzp;
            long j3 = this.zzn;
            long j8 = iZzu;
            if (j8 <= j - j3) {
                byte[] bArr = new byte[iZzu];
                zzhzj.zzq(j3, bArr, 0L, j8);
                this.zzn += j8;
                zzhvi zzhviVar = zzhvi.zzb;
                return new zzhvg(bArr);
            }
        }
        if (iZzu > 0 && iZzu <= zzR()) {
            byte[] bArr2 = new byte[iZzu];
            zzQ(bArr2, 0, iZzu);
            zzhvi zzhviVar2 = zzhvi.zzb;
            return new zzhvg(bArr2);
        }
        if (iZzu == 0) {
            return zzhvi.zzb;
        }
        if (iZzu < 0) {
            throw new zzhxd("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        }
        throw new zzhxd("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
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
        long j = this.zzn;
        if (this.zzp != j) {
            long j3 = j + 1;
            byte bZzr = zzhzj.zzr(j);
            if (bZzr >= 0) {
                this.zzn++;
                return bZzr;
            }
            if (this.zzp - this.zzn >= 10) {
                long j8 = 2 + j;
                int iZzr = (zzhzj.zzr(j3) << 7) ^ bZzr;
                if (iZzr < 0) {
                    i2 = iZzr ^ (-128);
                } else {
                    long j9 = 3 + j;
                    int iZzr2 = (zzhzj.zzr(j8) << 14) ^ iZzr;
                    if (iZzr2 >= 0) {
                        i2 = iZzr2 ^ 16256;
                    } else {
                        long j10 = 4 + j;
                        int iZzr3 = iZzr2 ^ (zzhzj.zzr(j9) << 21);
                        if (iZzr3 < 0) {
                            i2 = (-2080896) ^ iZzr3;
                        } else {
                            j9 = 5 + j;
                            byte bZzr2 = zzhzj.zzr(j10);
                            int i8 = (iZzr3 ^ (bZzr2 << 28)) ^ 266354560;
                            if (bZzr2 < 0) {
                                j10 = 6 + j;
                                if (zzhzj.zzr(j9) < 0) {
                                    j9 = 7 + j;
                                    if (zzhzj.zzr(j10) < 0) {
                                        j10 = 8 + j;
                                        if (zzhzj.zzr(j9) < 0) {
                                            j9 = 9 + j;
                                            if (zzhzj.zzr(j10) < 0) {
                                                long j11 = j + 10;
                                                if (zzhzj.zzr(j9) >= 0) {
                                                    i2 = i8;
                                                    j8 = j11;
                                                }
                                            }
                                        }
                                    }
                                }
                                i2 = i8;
                            }
                            i2 = i8;
                        }
                        j8 = j10;
                    }
                    j8 = j9;
                }
                this.zzn = j8;
                return i2;
            }
        }
        return (int) zzw();
    }

    public final long zzv() throws IOException {
        long j;
        long j3;
        long j8 = this.zzn;
        if (this.zzp != j8) {
            long j9 = j8 + 1;
            byte bZzr = zzhzj.zzr(j8);
            if (bZzr >= 0) {
                this.zzn++;
                return bZzr;
            }
            if (this.zzp - this.zzn >= 10) {
                long j10 = 2 + j8;
                int iZzr = (zzhzj.zzr(j9) << 7) ^ bZzr;
                if (iZzr < 0) {
                    j = iZzr ^ (-128);
                } else {
                    long j11 = 3 + j8;
                    int iZzr2 = (zzhzj.zzr(j10) << 14) ^ iZzr;
                    if (iZzr2 >= 0) {
                        j = iZzr2 ^ 16256;
                    } else {
                        long j12 = 4 + j8;
                        int iZzr3 = iZzr2 ^ (zzhzj.zzr(j11) << 21);
                        if (iZzr3 < 0) {
                            j = (-2080896) ^ iZzr3;
                            j10 = j12;
                        } else {
                            j11 = 5 + j8;
                            long jZzr = (((long) zzhzj.zzr(j12)) << 28) ^ ((long) iZzr3);
                            if (jZzr >= 0) {
                                j = 266354560 ^ jZzr;
                            } else {
                                long j13 = 6 + j8;
                                long jZzr2 = jZzr ^ (((long) zzhzj.zzr(j11)) << 35);
                                if (jZzr2 < 0) {
                                    j3 = -34093383808L;
                                } else {
                                    long j14 = 7 + j8;
                                    long jZzr3 = jZzr2 ^ (((long) zzhzj.zzr(j13)) << 42);
                                    if (jZzr3 >= 0) {
                                        j = 4363953127296L ^ jZzr3;
                                    } else {
                                        j13 = 8 + j8;
                                        jZzr2 = jZzr3 ^ (((long) zzhzj.zzr(j14)) << 49);
                                        if (jZzr2 < 0) {
                                            j3 = -558586000294016L;
                                        } else {
                                            j14 = 9 + j8;
                                            long jZzr4 = (jZzr2 ^ (((long) zzhzj.zzr(j13)) << 56)) ^ 71499008037633920L;
                                            if (jZzr4 < 0) {
                                                long j15 = j8 + 10;
                                                if (zzhzj.zzr(j14) >= 0) {
                                                    j10 = j15;
                                                    j = jZzr4;
                                                }
                                            } else {
                                                j = jZzr4;
                                            }
                                        }
                                    }
                                    j10 = j14;
                                }
                                j = j3 ^ jZzr2;
                                j10 = j13;
                            }
                        }
                    }
                    j10 = j11;
                }
                this.zzn = j10;
                return j;
            }
        }
        return zzw();
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
        long j = this.zzp;
        long j3 = this.zzn;
        if (j - j3 < 4) {
            int iZzD = zzD() & 255;
            int iZzD2 = (zzD() & 255) << 8;
            return iZzD | iZzD2 | ((zzD() & 255) << 16) | ((zzD() & 255) << 24);
        }
        this.zzn = 4 + j3;
        int iZzr = zzhzj.zzr(j3) & 255;
        int iZzr2 = (zzhzj.zzr(1 + j3) & 255) << 8;
        return iZzr | iZzr2 | ((zzhzj.zzr(2 + j3) & 255) << 16) | ((zzhzj.zzr(j3 + 3) & 255) << 24);
    }

    public final long zzy() throws IOException {
        long j = this.zzp;
        long j3 = this.zzn;
        if (j - j3 < 8) {
            long jZzD = ((long) zzD()) & 255;
            long jZzD2 = (((long) zzD()) & 255) << 8;
            long jZzD3 = (((long) zzD()) & 255) << 16;
            long jZzD4 = (((long) zzD()) & 255) << 24;
            long jZzD5 = (((long) zzD()) & 255) << 32;
            long jZzD6 = (((long) zzD()) & 255) << 40;
            return ((((long) zzD()) & 255) << 56) | jZzD | jZzD2 | jZzD3 | jZzD4 | jZzD5 | jZzD6 | ((((long) zzD()) & 255) << 48);
        }
        this.zzn = 8 + j3;
        long jZzr = ((long) zzhzj.zzr(j3)) & 255;
        long jZzr2 = (((long) zzhzj.zzr(1 + j3)) & 255) << 8;
        long jZzr3 = (((long) zzhzj.zzr(j3 + 2)) & 255) << 16;
        long jZzr4 = (((long) zzhzj.zzr(3 + j3)) & 255) << 24;
        long jZzr5 = (((long) zzhzj.zzr(j3 + 4)) & 255) << 32;
        long jZzr6 = (((long) zzhzj.zzr(j3 + 5)) & 255) << 40;
        return jZzr | jZzr2 | jZzr3 | jZzr4 | jZzr5 | jZzr6 | ((((long) zzhzj.zzr(j3 + 6)) & 255) << 48) | ((((long) zzhzj.zzr(j3 + 7)) & 255) << 56);
    }

    @Override // com.google.android.gms.internal.ads.zzhvn
    public final int zzz(int i2) throws zzhxd {
        if (i2 < 0) {
            throw new zzhxd("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        }
        int iZzC = i2 + zzC();
        int i8 = this.zzk;
        if (iZzC > i8) {
            throw new zzhxd("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
        this.zzk = iZzC;
        zzP();
        return i8;
    }
}
