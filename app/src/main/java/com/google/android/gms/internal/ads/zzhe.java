package com.google.android.gms.internal.ads;

import android.media.MediaCodec;
import android.os.Build;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzhe {

    @Nullable
    public byte[] zza;

    @Nullable
    public byte[] zzb;
    public int zzc;

    @Nullable
    public int[] zzd;

    @Nullable
    public int[] zze;
    public int zzf;
    public int zzg;
    public int zzh;
    private final MediaCodec.CryptoInfo zzi;

    @Nullable
    private final zzhd zzj;

    public zzhe() {
        MediaCodec.CryptoInfo cryptoInfo = new MediaCodec.CryptoInfo();
        this.zzi = cryptoInfo;
        this.zzj = Build.VERSION.SDK_INT >= 24 ? new zzhd(cryptoInfo, null) : null;
    }

    public final void zza(int i2, int[] iArr, int[] iArr2, byte[] bArr, byte[] bArr2, int i8, int i9, int i10) {
        this.zzf = i2;
        this.zzd = iArr;
        this.zze = iArr2;
        this.zzb = bArr;
        this.zza = bArr2;
        this.zzc = i8;
        this.zzg = i9;
        this.zzh = i10;
        MediaCodec.CryptoInfo cryptoInfo = this.zzi;
        cryptoInfo.numSubSamples = i2;
        cryptoInfo.numBytesOfClearData = iArr;
        cryptoInfo.numBytesOfEncryptedData = iArr2;
        cryptoInfo.key = bArr;
        cryptoInfo.iv = bArr2;
        cryptoInfo.mode = i8;
        if (Build.VERSION.SDK_INT >= 24) {
            zzhd zzhdVar = this.zzj;
            zzhdVar.getClass();
            zzhdVar.zza(i9, i10);
        }
    }

    public final MediaCodec.CryptoInfo zzb() {
        return this.zzi;
    }

    public final void zzc(int i2) {
        if (i2 == 0) {
            return;
        }
        if (this.zzd == null) {
            int[] iArr = new int[1];
            this.zzd = iArr;
            this.zzi.numBytesOfClearData = iArr;
        }
        int[] iArr2 = this.zzd;
        iArr2[0] = iArr2[0] + i2;
    }
}
