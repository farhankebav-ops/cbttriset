package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzrn extends zzch {
    private int zzd;
    private boolean zze;
    private int zzf;
    private long zzg;
    private byte[] zzi;
    private byte[] zzl;
    private int zzh = 0;
    private int zzj = 0;
    private int zzk = 0;

    public zzrn() {
        byte[] bArr = zzep.zzb;
        this.zzi = bArr;
        this.zzl = bArr;
    }

    private final void zzs(boolean z2) {
        int i2;
        int length;
        int i8 = this.zzk;
        int length2 = this.zzi.length;
        if (i8 != length2) {
            if (!z2) {
                return;
            } else {
                z2 = true;
            }
        }
        if (this.zzh == 0) {
            if (z2) {
                zzu(i8, 3);
                length = i8;
            } else {
                zzgmd.zzh(i8 >= (length2 >> 1));
                length = this.zzi.length >> 1;
                zzu(length, 0);
            }
            i2 = length;
        } else {
            int i9 = length2 >> 1;
            int i10 = i8 - i9;
            if (z2) {
                int iZzt = zzt(i10) + (this.zzi.length >> 1);
                zzu(iZzt, 2);
                int i11 = i9 + i10;
                i2 = iZzt;
                length = i11;
            } else {
                int iZzt2 = zzt(i10);
                zzu(iZzt2, 1);
                i2 = iZzt2;
                length = i10;
            }
        }
        if (length % this.zzd != 0) {
            throw new IllegalStateException(zzgmu.zzd("bytesConsumed is not aligned to frame size: %s", Integer.valueOf(length)));
        }
        zzgmd.zzh(i8 >= i2);
        this.zzk -= length;
        int i12 = this.zzj + length;
        this.zzj = i12;
        this.zzj = i12 % this.zzi.length;
        int i13 = this.zzh;
        int i14 = this.zzd;
        this.zzh = (i2 / i14) + i13;
        this.zzg += (long) ((length - i2) / i14);
    }

    private final int zzt(int i2) {
        int iZzw = ((zzw(2000000L) - this.zzh) * this.zzd) - (this.zzi.length >> 1);
        zzgmd.zzh(iZzw >= 0);
        int iMin = (int) Math.min((i2 * 0.2f) + 0.5f, iZzw);
        int i8 = this.zzd;
        return (iMin / i8) * i8;
    }

    private final void zzu(int i2, int i8) {
        int i9;
        if (i2 == 0) {
            return;
        }
        zzgmd.zza(this.zzk >= i2);
        if (i8 == 2) {
            int i10 = this.zzj;
            int i11 = this.zzk;
            int i12 = i10 + i11;
            byte[] bArr = this.zzi;
            int length = bArr.length;
            if (i12 <= length) {
                System.arraycopy(bArr, i12 - i2, this.zzl, 0, i2);
            } else {
                int i13 = i11 - (length - i10);
                if (i13 >= i2) {
                    System.arraycopy(bArr, i13 - i2, this.zzl, 0, i2);
                } else {
                    int i14 = i2 - i13;
                    System.arraycopy(bArr, length - i14, this.zzl, 0, i14);
                    System.arraycopy(this.zzi, 0, this.zzl, i14, i13);
                }
            }
        } else {
            int i15 = this.zzj;
            int i16 = i15 + i2;
            byte[] bArr2 = this.zzi;
            int length2 = bArr2.length;
            if (i16 <= length2) {
                System.arraycopy(bArr2, i15, this.zzl, 0, i2);
            } else {
                int i17 = length2 - i15;
                System.arraycopy(bArr2, i15, this.zzl, 0, i17);
                System.arraycopy(this.zzi, 0, this.zzl, i17, i2 - i17);
            }
        }
        zzgmd.zzd(i2 % this.zzd == 0, "sizeToOutput is not aligned to frame size: %s", i2);
        zzgmd.zzh(this.zzj < this.zzi.length);
        byte[] bArr3 = this.zzl;
        zzgmd.zzd(i2 % this.zzd == 0, "byteOutput size is not aligned to frame size %s", i2);
        if (i8 != 3) {
            for (int i18 = 0; i18 < i2; i18 += 2) {
                int i19 = i18 + 1;
                int iZzv = zzv(bArr3[i19], bArr3[i18]);
                if (i8 == 0) {
                    i9 = ((((i18 * 1000) / (i2 - 1)) * (-90)) / 1000) + 100;
                } else {
                    i9 = 10;
                    if (i8 == 2) {
                        i9 = 10 + (((90000 * i18) / (i2 - 1)) / 1000);
                    }
                }
                int i20 = (iZzv * i9) / 100;
                if (i20 >= 32767) {
                    bArr3[i18] = -1;
                    bArr3[i19] = 127;
                } else if (i20 <= -32768) {
                    bArr3[i18] = 0;
                    bArr3[i19] = -128;
                } else {
                    bArr3[i18] = (byte) (i20 & 255);
                    bArr3[i19] = (byte) (i20 >> 8);
                }
            }
        }
        zzk(i2).put(bArr3, 0, i2).flip();
    }

    private static int zzv(byte b8, byte b9) {
        return (b8 << 8) | (b9 & 255);
    }

    private final int zzw(long j) {
        return (int) ((j * ((long) this.zzb.zzb)) / 1000000);
    }

    private static final boolean zzx(byte b8, byte b9) {
        return Math.abs(zzv(b8, b9)) > 1024;
    }

    @Override // com.google.android.gms.internal.ads.zzch, com.google.android.gms.internal.ads.zzcg
    public final boolean zzc() {
        return super.zzc() && this.zze;
    }

    @Override // com.google.android.gms.internal.ads.zzcg
    public final void zzd(ByteBuffer byteBuffer) {
        int iLimit;
        int i2;
        int iPosition;
        while (byteBuffer.hasRemaining() && !zzl()) {
            if (this.zzf != 0) {
                zzgmd.zzh(this.zzj < this.zzi.length);
                int iLimit2 = byteBuffer.limit();
                int iPosition2 = byteBuffer.position() + 1;
                while (true) {
                    if (iPosition2 >= byteBuffer.limit()) {
                        iLimit = byteBuffer.limit();
                        break;
                    } else {
                        if (zzx(byteBuffer.get(iPosition2), byteBuffer.get(iPosition2 - 1))) {
                            int i8 = this.zzd;
                            iLimit = (iPosition2 / i8) * i8;
                            break;
                        }
                        iPosition2 += 2;
                    }
                }
                int iPosition3 = iLimit - byteBuffer.position();
                int i9 = this.zzj;
                int i10 = this.zzk;
                int i11 = i9 + i10;
                int length = this.zzi.length;
                if (i11 < length) {
                    i2 = length - i11;
                } else {
                    i11 = i10 - (length - i9);
                    i2 = i9 - i11;
                }
                int iMin = Math.min(iPosition3, i2);
                byteBuffer.limit(byteBuffer.position() + iMin);
                byteBuffer.get(this.zzi, i11, iMin);
                int i12 = this.zzk + iMin;
                this.zzk = i12;
                zzgmd.zzh(i12 <= this.zzi.length);
                boolean z2 = iLimit < iLimit2 && iPosition3 < i2;
                zzs(z2);
                if (z2) {
                    this.zzf = 0;
                    this.zzh = 0;
                }
                byteBuffer.limit(iLimit2);
            } else {
                int iLimit3 = byteBuffer.limit();
                byteBuffer.limit(Math.min(iLimit3, byteBuffer.position() + this.zzi.length));
                int iLimit4 = byteBuffer.limit() - 1;
                while (true) {
                    if (iLimit4 < byteBuffer.position()) {
                        iPosition = byteBuffer.position();
                        break;
                    } else {
                        if (zzx(byteBuffer.get(iLimit4), byteBuffer.get(iLimit4 - 1))) {
                            int i13 = this.zzd;
                            iPosition = ((iLimit4 / i13) * i13) + i13;
                            break;
                        }
                        iLimit4 -= 2;
                    }
                }
                if (iPosition == byteBuffer.position()) {
                    this.zzf = 1;
                } else {
                    byteBuffer.limit(Math.min(iPosition, byteBuffer.capacity()));
                    zzk(byteBuffer.remaining()).put(byteBuffer).flip();
                }
                byteBuffer.limit(iLimit3);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzch
    public final zzcd zzm(zzcd zzcdVar) throws zzcf {
        if (zzcdVar.zzd == 2) {
            return zzcdVar.zzb == -1 ? zzcd.zza : zzcdVar;
        }
        throw new zzcf("Unhandled input format:", zzcdVar);
    }

    @Override // com.google.android.gms.internal.ads.zzch
    public final void zzn() {
        if (this.zzk > 0) {
            zzs(true);
            this.zzh = 0;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzch
    public final void zzo() {
        if (zzc()) {
            int i2 = this.zzb.zzc;
            this.zzd = i2 + i2;
            int iZzw = zzw(100000L) / 2;
            int i8 = this.zzd;
            int i9 = (iZzw / i8) * i8;
            int i10 = i9 + i9;
            if (this.zzi.length != i10) {
                this.zzi = new byte[i10];
                this.zzl = new byte[i10];
            }
        }
        this.zzf = 0;
        this.zzg = 0L;
        this.zzh = 0;
        this.zzj = 0;
        this.zzk = 0;
    }

    @Override // com.google.android.gms.internal.ads.zzch
    public final void zzp() {
        this.zze = false;
        byte[] bArr = zzep.zzb;
        this.zzi = bArr;
        this.zzl = bArr;
    }

    public final void zzq(boolean z2) {
        this.zze = z2;
    }

    public final long zzr() {
        return this.zzg;
    }
}
