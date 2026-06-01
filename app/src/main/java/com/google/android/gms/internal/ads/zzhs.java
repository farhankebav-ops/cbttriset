package com.google.android.gms.internal.ads;

import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzhs {
    public int zza;
    public int zzb;
    public int zzc;
    public int zzd;
    public int zze;
    public int zzf;
    public int zzg;
    public int zzh;
    public int zzi;
    public int zzj;
    public long zzk;
    public int zzl;

    public final String toString() {
        int i2 = this.zza;
        int i8 = this.zzb;
        int i9 = this.zzc;
        int i10 = this.zzd;
        int i11 = this.zze;
        int i12 = this.zzf;
        int i13 = this.zzg;
        int i14 = this.zzh;
        int i15 = this.zzi;
        int i16 = this.zzj;
        long j = this.zzk;
        int i17 = this.zzl;
        String str = zzep.zza;
        Locale locale = Locale.US;
        StringBuilder sbW = a1.a.w(i2, "DecoderCounters {\n decoderInits=", ",\n decoderReleases=", i8, "\n queuedInputBuffers=");
        androidx.camera.core.processing.util.a.w(i9, i10, "\n skippedInputBuffers=", "\n renderedOutputBuffers=", sbW);
        androidx.camera.core.processing.util.a.w(i11, i12, "\n skippedOutputBuffers=", "\n droppedBuffers=", sbW);
        androidx.camera.core.processing.util.a.w(i13, i14, "\n droppedInputBuffers=", "\n maxConsecutiveDroppedBuffers=", sbW);
        androidx.camera.core.processing.util.a.w(i15, i16, "\n droppedToKeyframeEvents=", "\n totalVideoFrameProcessingOffsetUs=", sbW);
        sbW.append(j);
        sbW.append("\n videoFrameProcessingOffsetCount=");
        sbW.append(i17);
        sbW.append("\n}");
        return sbW.toString();
    }

    public final synchronized void zza() {
    }
}
