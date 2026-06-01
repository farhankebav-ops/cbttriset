package com.google.android.gms.internal.ads;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.os.Build;
import android.os.Bundle;
import android.view.Surface;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zztr implements zzsv {
    private final MediaCodec zza;

    @Nullable
    private final zzsr zzb;

    public /* synthetic */ zztr(MediaCodec mediaCodec, zzsr zzsrVar, byte[] bArr) {
        this.zza = mediaCodec;
        this.zzb = zzsrVar;
        if (Build.VERSION.SDK_INT < 35 || zzsrVar == null) {
            return;
        }
        zzsrVar.zzb(mediaCodec);
    }

    @Override // com.google.android.gms.internal.ads.zzsv
    public final void zza(int i2, int i8, int i9, long j, int i10) {
        this.zza.queueInputBuffer(i2, 0, i9, j, i10);
    }

    @Override // com.google.android.gms.internal.ads.zzsv
    public final void zzb(int i2, int i8, zzhe zzheVar, long j, int i9) {
        this.zza.queueSecureInputBuffer(i2, 0, zzheVar.zzb(), j, i9);
    }

    @Override // com.google.android.gms.internal.ads.zzsv
    public final void zzc(int i2, boolean z2) {
        this.zza.releaseOutputBuffer(i2, false);
    }

    @Override // com.google.android.gms.internal.ads.zzsv
    public final void zzd(int i2, long j) {
        this.zza.releaseOutputBuffer(i2, j);
    }

    @Override // com.google.android.gms.internal.ads.zzsv
    public final int zze() {
        return this.zza.dequeueInputBuffer(0L);
    }

    @Override // com.google.android.gms.internal.ads.zzsv
    public final int zzf(MediaCodec.BufferInfo bufferInfo) {
        int iDequeueOutputBuffer;
        do {
            iDequeueOutputBuffer = this.zza.dequeueOutputBuffer(bufferInfo, 0L);
        } while (iDequeueOutputBuffer == -3);
        return iDequeueOutputBuffer;
    }

    @Override // com.google.android.gms.internal.ads.zzsv
    public final MediaFormat zzg() {
        return this.zza.getOutputFormat();
    }

    @Override // com.google.android.gms.internal.ads.zzsv
    @Nullable
    public final ByteBuffer zzh(int i2) {
        return this.zza.getInputBuffer(i2);
    }

    @Override // com.google.android.gms.internal.ads.zzsv
    @Nullable
    public final ByteBuffer zzi(int i2) {
        return this.zza.getOutputBuffer(i2);
    }

    @Override // com.google.android.gms.internal.ads.zzsv
    public final void zzj() {
        this.zza.flush();
    }

    @Override // com.google.android.gms.internal.ads.zzsv
    public final void zzk() {
        zzsr zzsrVar;
        zzsr zzsrVar2;
        try {
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 30 && i2 < 33) {
                this.zza.stop();
            }
            if (i2 >= 35 && (zzsrVar2 = this.zzb) != null) {
                zzsrVar2.zzc(this.zza);
            }
            this.zza.release();
        } catch (Throwable th) {
            if (Build.VERSION.SDK_INT >= 35 && (zzsrVar = this.zzb) != null) {
                zzsrVar.zzc(this.zza);
            }
            this.zza.release();
            throw th;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzsv
    public final /* synthetic */ boolean zzl(zzsu zzsuVar) {
        return o0.a(this, zzsuVar);
    }

    @Override // com.google.android.gms.internal.ads.zzsv
    public final void zzm(Surface surface) {
        this.zza.setOutputSurface(surface);
    }

    @Override // com.google.android.gms.internal.ads.zzsv
    @RequiresApi(35)
    public final void zzn() {
        this.zza.detachOutputSurface();
    }

    @Override // com.google.android.gms.internal.ads.zzsv
    public final void zzo(Bundle bundle) {
        this.zza.setParameters(bundle);
    }

    @Override // com.google.android.gms.internal.ads.zzsv
    public final void zzp(int i2) {
        this.zza.setVideoScalingMode(i2);
    }
}
