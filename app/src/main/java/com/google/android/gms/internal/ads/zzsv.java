package com.google.android.gms.internal.ads;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.os.Bundle;
import android.view.Surface;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public interface zzsv {
    void zza(int i2, int i8, int i9, long j, int i10);

    void zzb(int i2, int i8, zzhe zzheVar, long j, int i9);

    void zzc(int i2, boolean z2);

    void zzd(int i2, long j);

    int zze();

    int zzf(MediaCodec.BufferInfo bufferInfo);

    MediaFormat zzg();

    @Nullable
    ByteBuffer zzh(int i2);

    @Nullable
    ByteBuffer zzi(int i2);

    void zzj();

    void zzk();

    boolean zzl(zzsu zzsuVar);

    void zzm(Surface surface);

    @RequiresApi(35)
    void zzn();

    void zzo(Bundle bundle);

    void zzp(int i2);
}
