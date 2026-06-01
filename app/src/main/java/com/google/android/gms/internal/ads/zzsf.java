package com.google.android.gms.internal.ads;

import android.media.MediaCodec;
import android.os.Build;
import android.os.HandlerThread;
import android.os.Trace;
import android.view.Surface;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzsf implements zzst {
    private final zzgmv zza;
    private final zzgmv zzb;

    public zzsf(final int i2) {
        zzgmv zzgmvVar = new zzgmv() { // from class: com.google.android.gms.internal.ads.zzse
            @Override // com.google.android.gms.internal.ads.zzgmv
            public final /* synthetic */ Object zza() {
                return new HandlerThread(zzsg.zzt(i2, "ExoPlayer:MediaCodecAsyncAdapter:"));
            }
        };
        zzgmv zzgmvVar2 = new zzgmv() { // from class: com.google.android.gms.internal.ads.zzsd
            @Override // com.google.android.gms.internal.ads.zzgmv
            public final /* synthetic */ Object zza() {
                return new HandlerThread(zzsg.zzt(i2, "ExoPlayer:MediaCodecQueueingThread:"));
            }
        };
        this.zza = zzgmvVar;
        this.zzb = zzgmvVar2;
    }

    public final zzsg zza(zzss zzssVar) throws Exception {
        Exception exc;
        MediaCodec mediaCodecCreateByCodecName;
        zzsg zzsgVar;
        zzsy zzsyVar = zzssVar.zza;
        String str = zzsyVar.zza;
        zzsg zzsgVar2 = null;
        try {
            StringBuilder sb = new StringBuilder(str.length() + 12);
            sb.append("createCodec:");
            sb.append(str);
            Trace.beginSection(sb.toString());
            mediaCodecCreateByCodecName = MediaCodec.createByCodecName(str);
            try {
                zzsgVar = new zzsg(mediaCodecCreateByCodecName, (HandlerThread) this.zza.zza(), new zzsj(mediaCodecCreateByCodecName, (HandlerThread) this.zzb.zza()), zzssVar.zzf, null);
            } catch (Exception e) {
                exc = e;
            }
        } catch (Exception e4) {
            exc = e4;
            mediaCodecCreateByCodecName = null;
        }
        try {
            Trace.endSection();
            Surface surface = zzssVar.zzd;
            int i2 = 0;
            if (surface == null && zzsyVar.zzh && Build.VERSION.SDK_INT >= 35) {
                i2 = 8;
            }
            zzsgVar.zzq(zzssVar.zzb, surface, null, i2);
            return zzsgVar;
        } catch (Exception e8) {
            exc = e8;
            zzsgVar2 = zzsgVar;
            if (zzsgVar2 != null) {
                zzsgVar2.zzk();
                throw exc;
            }
            if (mediaCodecCreateByCodecName == null) {
                throw exc;
            }
            mediaCodecCreateByCodecName.release();
            throw exc;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzst
    public final /* bridge */ /* synthetic */ zzsv zzb(zzss zzssVar) throws IOException {
        throw null;
    }
}
