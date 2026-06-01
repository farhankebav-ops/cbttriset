package com.google.android.gms.internal.ads;

import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzacr implements zzadb {
    private final zzj zzb;
    private final long zzc;
    private long zzd;
    private int zzf;
    private int zzg;
    private byte[] zze = new byte[65536];
    private final byte[] zza = new byte[4096];

    static {
        zzal.zzb("media3.extractor");
    }

    public zzacr(zzj zzjVar, long j, long j3) {
        this.zzb = zzjVar;
        this.zzd = j;
        this.zzc = j3;
    }

    private final void zzp(int i2) {
        int i8 = this.zzf + i2;
        int length = this.zze.length;
        if (i8 > length) {
            String str = zzep.zza;
            this.zze = Arrays.copyOf(this.zze, Math.max(65536 + i8, Math.min(length + length, i8 + 524288)));
        }
    }

    private final int zzq(int i2) {
        int iMin = Math.min(this.zzg, i2);
        zzs(iMin);
        return iMin;
    }

    private final int zzr(byte[] bArr, int i2, int i8) {
        int i9 = this.zzg;
        if (i9 == 0) {
            return 0;
        }
        int iMin = Math.min(i9, i8);
        System.arraycopy(this.zze, 0, bArr, i2, iMin);
        zzs(iMin);
        return iMin;
    }

    private final void zzs(int i2) {
        int i8 = this.zzg - i2;
        this.zzg = i8;
        this.zzf = 0;
        byte[] bArr = this.zze;
        byte[] bArr2 = i8 < bArr.length + (-524288) ? new byte[65536 + i8] : bArr;
        System.arraycopy(bArr, i2, bArr2, 0, i8);
        this.zze = bArr2;
    }

    private final int zzt(byte[] bArr, int i2, int i8, int i9, boolean z2) throws IOException {
        if (Thread.interrupted()) {
            throw new InterruptedIOException();
        }
        int iZza = this.zzb.zza(bArr, i2 + i9, i8 - i9);
        if (iZza != -1) {
            return i9 + iZza;
        }
        if (i9 == 0 && z2) {
            return -1;
        }
        throw new EOFException();
    }

    private final void zzu(int i2) {
        if (i2 != -1) {
            this.zzd += (long) i2;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzadb, com.google.android.gms.internal.ads.zzj
    public final int zza(byte[] bArr, int i2, int i8) throws IOException {
        int iZzr = zzr(bArr, i2, i8);
        if (iZzr == 0) {
            iZzr = zzt(bArr, i2, i8, 0, true);
        }
        zzu(iZzr);
        return iZzr;
    }

    @Override // com.google.android.gms.internal.ads.zzadb
    public final boolean zzb(byte[] bArr, int i2, int i8, boolean z2) throws IOException {
        int iZzr = zzr(bArr, i2, i8);
        while (iZzr < i8 && iZzr != -1) {
            iZzr = zzt(bArr, i2, i8, iZzr, z2);
        }
        zzu(iZzr);
        return iZzr != -1;
    }

    @Override // com.google.android.gms.internal.ads.zzadb
    public final void zzc(byte[] bArr, int i2, int i8) throws IOException {
        zzb(bArr, i2, i8, false);
    }

    @Override // com.google.android.gms.internal.ads.zzadb
    public final int zzd(int i2) throws IOException {
        int iZzq = zzq(1);
        if (iZzq == 0) {
            iZzq = zzt(this.zza, 0, Math.min(1, 4096), 0, true);
        }
        zzu(iZzq);
        return iZzq;
    }

    @Override // com.google.android.gms.internal.ads.zzadb
    public final boolean zze(int i2, boolean z2) throws IOException {
        int iZzq = zzq(i2);
        while (iZzq < i2 && iZzq != -1) {
            iZzq = zzt(this.zza, -iZzq, Math.min(i2, iZzq + 4096), iZzq, z2);
        }
        zzu(iZzq);
        return iZzq != -1;
    }

    @Override // com.google.android.gms.internal.ads.zzadb
    public final void zzf(int i2) throws IOException {
        zze(i2, false);
    }

    @Override // com.google.android.gms.internal.ads.zzadb
    public final int zzg(byte[] bArr, int i2, int i8) throws IOException {
        zzacr zzacrVar;
        int iMin;
        zzp(i8);
        int i9 = this.zzg;
        int i10 = this.zzf;
        int i11 = i9 - i10;
        if (i11 == 0) {
            zzacrVar = this;
            iMin = zzacrVar.zzt(this.zze, i10, i8, 0, true);
            if (iMin == -1) {
                return -1;
            }
            zzacrVar.zzg += iMin;
        } else {
            zzacrVar = this;
            iMin = Math.min(i8, i11);
        }
        System.arraycopy(zzacrVar.zze, zzacrVar.zzf, bArr, i2, iMin);
        zzacrVar.zzf += iMin;
        return iMin;
    }

    @Override // com.google.android.gms.internal.ads.zzadb
    public final boolean zzh(byte[] bArr, int i2, int i8, boolean z2) throws IOException {
        if (!zzj(i8, z2)) {
            return false;
        }
        System.arraycopy(this.zze, this.zzf - i8, bArr, i2, i8);
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzadb
    public final void zzi(byte[] bArr, int i2, int i8) throws IOException {
        zzh(bArr, i2, i8, false);
    }

    public final boolean zzj(int i2, boolean z2) throws IOException {
        zzp(i2);
        int iZzt = this.zzg - this.zzf;
        while (iZzt < i2) {
            int i8 = i2;
            boolean z7 = z2;
            iZzt = zzt(this.zze, this.zzf, i8, iZzt, z7);
            if (iZzt == -1) {
                return false;
            }
            this.zzg = this.zzf + iZzt;
            i2 = i8;
            z2 = z7;
        }
        this.zzf += i2;
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzadb
    public final void zzk(int i2) throws IOException {
        zzj(i2, false);
    }

    @Override // com.google.android.gms.internal.ads.zzadb
    public final void zzl() {
        this.zzf = 0;
    }

    @Override // com.google.android.gms.internal.ads.zzadb
    public final long zzm() {
        return this.zzd + ((long) this.zzf);
    }

    @Override // com.google.android.gms.internal.ads.zzadb
    public final long zzn() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.ads.zzadb
    public final long zzo() {
        return this.zzc;
    }
}
