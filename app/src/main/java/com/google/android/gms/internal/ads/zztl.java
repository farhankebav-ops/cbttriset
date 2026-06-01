package com.google.android.gms.internal.ads;

import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import androidx.annotation.Nullable;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zztl implements zztj {
    private final int zza;

    @Nullable
    private MediaCodecInfo[] zzb;

    public zztl(boolean z2, boolean z7, boolean z8) {
        int i2 = 1;
        if (!z2 && !z7 && !z8) {
            i2 = 0;
        }
        this.zza = i2;
    }

    @EnsuresNonNull({"mediaCodecInfos"})
    private final void zzf() {
        if (this.zzb == null) {
            this.zzb = new MediaCodecList(this.zza).getCodecInfos();
        }
    }

    @Override // com.google.android.gms.internal.ads.zztj
    public final int zza() {
        zzf();
        return this.zzb.length;
    }

    @Override // com.google.android.gms.internal.ads.zztj
    public final MediaCodecInfo zzb(int i2) {
        zzf();
        return this.zzb[i2];
    }

    @Override // com.google.android.gms.internal.ads.zztj
    public final boolean zzc() {
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zztj
    public final boolean zzd(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return codecCapabilities.isFeatureSupported(str);
    }

    @Override // com.google.android.gms.internal.ads.zztj
    public final boolean zze(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return codecCapabilities.isFeatureRequired(str);
    }
}
