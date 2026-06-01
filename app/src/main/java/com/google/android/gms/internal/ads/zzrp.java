package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzrp extends zzch {
    private int zzd;
    private int zze;
    private boolean zzf;
    private int zzg;
    private byte[] zzh = zzep.zzb;
    private int zzi;
    private long zzj;

    @Override // com.google.android.gms.internal.ads.zzch, com.google.android.gms.internal.ads.zzcg
    public final long zza(long j) {
        return Math.max(0L, j - zzep.zzr(this.zze + this.zzd, this.zzb.zzb));
    }

    @Override // com.google.android.gms.internal.ads.zzcg
    public final void zzd(ByteBuffer byteBuffer) {
        int iPosition = byteBuffer.position();
        int iLimit = byteBuffer.limit();
        int i2 = iLimit - iPosition;
        if (i2 == 0) {
            return;
        }
        int iMin = Math.min(i2, this.zzg);
        this.zzj += (long) (iMin / this.zzb.zze);
        this.zzg -= iMin;
        byteBuffer.position(iPosition + iMin);
        if (this.zzg <= 0) {
            int i8 = i2 - iMin;
            int length = (this.zzi + i8) - this.zzh.length;
            ByteBuffer byteBufferZzk = zzk(length);
            int i9 = this.zzi;
            String str = zzep.zza;
            int iMax = Math.max(0, Math.min(length, i9));
            byteBufferZzk.put(this.zzh, 0, iMax);
            int iMax2 = Math.max(0, Math.min(length - iMax, i8));
            byteBuffer.limit(byteBuffer.position() + iMax2);
            byteBufferZzk.put(byteBuffer);
            byteBuffer.limit(iLimit);
            int i10 = i8 - iMax2;
            int i11 = this.zzi - iMax;
            this.zzi = i11;
            byte[] bArr = this.zzh;
            System.arraycopy(bArr, iMax, bArr, 0, i11);
            byteBuffer.get(this.zzh, this.zzi, i10);
            this.zzi += i10;
            byteBufferZzk.flip();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzch, com.google.android.gms.internal.ads.zzcg
    public final ByteBuffer zzf() {
        int i2;
        if (super.zzg() && (i2 = this.zzi) > 0) {
            zzk(i2).put(this.zzh, 0, this.zzi).flip();
            this.zzi = 0;
        }
        return super.zzf();
    }

    @Override // com.google.android.gms.internal.ads.zzch, com.google.android.gms.internal.ads.zzcg
    public final boolean zzg() {
        return super.zzg() && this.zzi == 0;
    }

    @Override // com.google.android.gms.internal.ads.zzch
    public final zzcd zzm(zzcd zzcdVar) throws zzcf {
        if (!zzep.zzA(zzcdVar.zzd)) {
            throw new zzcf("Unhandled input format:", zzcdVar);
        }
        this.zzf = true;
        return (this.zzd == 0 && this.zze == 0) ? zzcd.zza : zzcdVar;
    }

    @Override // com.google.android.gms.internal.ads.zzch
    public final void zzn() {
        if (this.zzf) {
            int i2 = this.zzi;
            if (i2 > 0) {
                this.zzj += (long) (i2 / this.zzb.zze);
            }
            this.zzi = 0;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzch
    public final void zzo() {
        if (this.zzf) {
            this.zzf = false;
            int i2 = this.zze;
            int i8 = this.zzb.zze;
            this.zzh = new byte[i2 * i8];
            this.zzg = this.zzd * i8;
        }
        this.zzi = 0;
    }

    @Override // com.google.android.gms.internal.ads.zzch
    public final void zzp() {
        this.zzh = zzep.zzb;
    }

    public final void zzq(int i2, int i8) {
        this.zzd = i2;
        this.zze = i8;
    }

    public final void zzr() {
        this.zzj = 0L;
    }

    public final long zzs() {
        return this.zzj;
    }
}
