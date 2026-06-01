package com.google.android.gms.internal.ads;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Build;
import android.os.Bundle;
import android.os.HandlerThread;
import android.os.Trace;
import android.view.Surface;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzsg implements zzsv {
    private final MediaCodec zza;
    private final zzsl zzb;
    private final zzsw zzc;

    @Nullable
    private final zzsr zzd;
    private boolean zze;
    private int zzf = 0;

    public /* synthetic */ zzsg(MediaCodec mediaCodec, HandlerThread handlerThread, zzsw zzswVar, zzsr zzsrVar, byte[] bArr) {
        this.zza = mediaCodec;
        this.zzb = new zzsl(handlerThread);
        this.zzc = zzswVar;
        this.zzd = zzsrVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String zzt(int i2, String str) {
        StringBuilder sb = new StringBuilder(str);
        if (i2 == 1) {
            sb.append("Audio");
        } else if (i2 == 2) {
            sb.append("Video");
        } else {
            sb.append("Unknown(");
            sb.append(i2);
            sb.append(")");
        }
        return sb.toString();
    }

    @Override // com.google.android.gms.internal.ads.zzsv
    public final void zza(int i2, int i8, int i9, long j, int i10) {
        this.zzc.zzb(i2, 0, i9, j, i10);
    }

    @Override // com.google.android.gms.internal.ads.zzsv
    public final void zzb(int i2, int i8, zzhe zzheVar, long j, int i9) {
        this.zzc.zzc(i2, 0, zzheVar, j, i9);
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
        this.zzc.zzg();
        return this.zzb.zzc();
    }

    @Override // com.google.android.gms.internal.ads.zzsv
    public final int zzf(MediaCodec.BufferInfo bufferInfo) {
        this.zzc.zzg();
        return this.zzb.zzd(bufferInfo);
    }

    @Override // com.google.android.gms.internal.ads.zzsv
    public final MediaFormat zzg() {
        return this.zzb.zze();
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
        this.zzc.zze();
        MediaCodec mediaCodec = this.zza;
        mediaCodec.flush();
        this.zzb.zzf();
        mediaCodec.start();
    }

    @Override // com.google.android.gms.internal.ads.zzsv
    public final void zzk() {
        zzsr zzsrVar;
        zzsr zzsrVar2;
        zzsr zzsrVar3;
        try {
            try {
                if (this.zzf == 1) {
                    this.zzc.zzf();
                    this.zzb.zzb();
                }
                this.zzf = 2;
                if (this.zze) {
                    return;
                }
                int i2 = Build.VERSION.SDK_INT;
                if (i2 >= 30 && i2 < 33) {
                    this.zza.stop();
                }
                if (i2 >= 35 && (zzsrVar3 = this.zzd) != null) {
                    zzsrVar3.zzc(this.zza);
                }
                this.zza.release();
                this.zze = true;
            } catch (Throwable th) {
                if (!this.zze) {
                    int i8 = Build.VERSION.SDK_INT;
                    if (i8 >= 30 && i8 < 33) {
                        this.zza.stop();
                    }
                    if (i8 >= 35 && (zzsrVar2 = this.zzd) != null) {
                        zzsrVar2.zzc(this.zza);
                    }
                    this.zza.release();
                    this.zze = true;
                }
                throw th;
            }
        } catch (Throwable th2) {
            if (Build.VERSION.SDK_INT >= 35 && (zzsrVar = this.zzd) != null) {
                zzsrVar.zzc(this.zza);
            }
            this.zza.release();
            this.zze = true;
            throw th2;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzsv
    public final boolean zzl(zzsu zzsuVar) {
        this.zzb.zzg(zzsuVar);
        return true;
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
        this.zzc.zzd(bundle);
    }

    @Override // com.google.android.gms.internal.ads.zzsv
    public final void zzp(int i2) {
        this.zza.setVideoScalingMode(i2);
    }

    public final /* synthetic */ void zzq(MediaFormat mediaFormat, Surface surface, MediaCrypto mediaCrypto, int i2) {
        zzsr zzsrVar;
        zzsl zzslVar = this.zzb;
        MediaCodec mediaCodec = this.zza;
        zzslVar.zza(mediaCodec);
        Trace.beginSection("configureCodec");
        mediaCodec.configure(mediaFormat, surface, (MediaCrypto) null, i2);
        Trace.endSection();
        this.zzc.zza();
        Trace.beginSection("startCodec");
        mediaCodec.start();
        Trace.endSection();
        if (Build.VERSION.SDK_INT >= 35 && (zzsrVar = this.zzd) != null) {
            zzsrVar.zzb(mediaCodec);
        }
        this.zzf = 1;
    }
}
