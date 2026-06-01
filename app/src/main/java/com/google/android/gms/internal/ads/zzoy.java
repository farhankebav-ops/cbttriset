package com.google.android.gms.internal.ads;

import android.content.Context;
import android.media.metrics.LogSessionId;
import android.media.metrics.MediaMetricsManager;
import android.media.metrics.NetworkEvent;
import android.media.metrics.PlaybackErrorEvent;
import android.media.metrics.PlaybackMetrics;
import android.media.metrics.PlaybackSession;
import android.media.metrics.PlaybackStateEvent;
import android.media.metrics.TrackChangeEvent;
import android.os.SystemClock;
import android.util.Pair;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.facebook.ads.AdError;
import java.io.IOException;
import java.util.HashMap;
import java.util.Objects;
import java.util.concurrent.Executor;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
@RequiresApi(31)
public final class zzoy implements zzml, zzoz {
    private boolean zzA;
    private final Context zza;
    private final zzpa zzc;
    private final PlaybackSession zzd;

    @Nullable
    private String zzj;

    @Nullable
    private PlaybackMetrics.Builder zzk;
    private int zzl;

    @Nullable
    private zzau zzo;

    @Nullable
    private zzox zzp;

    @Nullable
    private zzox zzq;

    @Nullable
    private zzox zzr;

    @Nullable
    private zzv zzs;

    @Nullable
    private zzv zzt;

    @Nullable
    private zzv zzu;
    private boolean zzv;
    private boolean zzw;
    private int zzx;
    private int zzy;
    private int zzz;
    private final Executor zzb = zzcw.zza();
    private final zzbe zzf = new zzbe();
    private final zzbd zzg = new zzbd();
    private final HashMap zzi = new HashMap();
    private final HashMap zzh = new HashMap();
    private final long zze = SystemClock.elapsedRealtime();
    private int zzm = 0;
    private int zzn = 0;

    private zzoy(Context context, PlaybackSession playbackSession) {
        this.zza = context.getApplicationContext();
        this.zzd = playbackSession;
        zzor zzorVar = new zzor(zzor.zza);
        this.zzc = zzorVar;
        zzorVar.zza(this);
    }

    private final void zzA(int i2, long j, @Nullable zzv zzvVar, int i8) {
        TrackChangeEvent.Builder timeSinceCreatedMillis = k0.r(i2).setTimeSinceCreatedMillis(j - this.zze);
        if (zzvVar != null) {
            timeSinceCreatedMillis.setTrackState(1);
            timeSinceCreatedMillis.setTrackChangeReason(i8 != 1 ? 1 : 2);
            String str = zzvVar.zzn;
            if (str != null) {
                timeSinceCreatedMillis.setContainerMimeType(str);
            }
            String str2 = zzvVar.zzo;
            if (str2 != null) {
                timeSinceCreatedMillis.setSampleMimeType(str2);
            }
            String str3 = zzvVar.zzk;
            if (str3 != null) {
                timeSinceCreatedMillis.setCodecName(str3);
            }
            int i9 = zzvVar.zzj;
            if (i9 != -1) {
                timeSinceCreatedMillis.setBitrate(i9);
            }
            int i10 = zzvVar.zzv;
            if (i10 != -1) {
                timeSinceCreatedMillis.setWidth(i10);
            }
            int i11 = zzvVar.zzw;
            if (i11 != -1) {
                timeSinceCreatedMillis.setHeight(i11);
            }
            int i12 = zzvVar.zzG;
            if (i12 != -1) {
                timeSinceCreatedMillis.setChannelCount(i12);
            }
            int i13 = zzvVar.zzH;
            if (i13 != -1) {
                timeSinceCreatedMillis.setAudioSampleRate(i13);
            }
            String str4 = zzvVar.zzd;
            if (str4 != null) {
                String str5 = zzep.zza;
                String[] strArrSplit = str4.split("-", -1);
                Pair pairCreate = Pair.create(strArrSplit[0], strArrSplit.length >= 2 ? strArrSplit[1] : null);
                timeSinceCreatedMillis.setLanguage((String) pairCreate.first);
                Object obj = pairCreate.second;
                if (obj != null) {
                    timeSinceCreatedMillis.setLanguageRegion((String) obj);
                }
            }
            float f4 = zzvVar.zzz;
            if (f4 != -1.0f) {
                timeSinceCreatedMillis.setVideoFrameRate(f4);
            }
        } else {
            timeSinceCreatedMillis.setTrackState(0);
        }
        this.zzA = true;
        final TrackChangeEvent trackChangeEventBuild = timeSinceCreatedMillis.build();
        this.zzb.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzou
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                this.zza.zzu(trackChangeEventBuild);
            }
        });
    }

    @RequiresNonNull({"metricsBuilder"})
    private final void zzB(zzbf zzbfVar, @Nullable zzuu zzuuVar) {
        int iZze;
        PlaybackMetrics.Builder builder = this.zzk;
        if (zzuuVar == null || (iZze = zzbfVar.zze(zzuuVar.zza)) == -1) {
            return;
        }
        zzbd zzbdVar = this.zzg;
        int i2 = 0;
        zzbfVar.zzd(iZze, zzbdVar, false);
        zzbe zzbeVar = this.zzf;
        zzbfVar.zzb(zzbdVar.zzc, zzbeVar, 0L);
        zzag zzagVar = zzbeVar.zzd.zzb;
        if (zzagVar != null) {
            int iZzG = zzep.zzG(zzagVar.zza);
            i2 = iZzG != 0 ? iZzG != 1 ? iZzG != 2 ? 1 : 4 : 5 : 3;
        }
        builder.setStreamType(i2);
        long j = zzbeVar.zzm;
        if (j != -9223372036854775807L && !zzbeVar.zzk && !zzbeVar.zzi && !zzbeVar.zzb()) {
            builder.setMediaDurationMillis(zzep.zzp(j));
        }
        builder.setPlaybackType(true != zzbeVar.zzb() ? 1 : 2);
        this.zzA = true;
    }

    private final void zzC() {
        PlaybackMetrics.Builder builder = this.zzk;
        if (builder != null && this.zzA) {
            builder.setAudioUnderrunCount(this.zzz);
            this.zzk.setVideoFramesDropped(this.zzx);
            this.zzk.setVideoFramesPlayed(this.zzy);
            Long l = (Long) this.zzh.get(this.zzj);
            this.zzk.setNetworkTransferDurationMillis(l == null ? 0L : l.longValue());
            Long l8 = (Long) this.zzi.get(this.zzj);
            this.zzk.setNetworkBytesRead(l8 == null ? 0L : l8.longValue());
            this.zzk.setStreamSource((l8 == null || l8.longValue() <= 0) ? 0 : 1);
            final PlaybackMetrics playbackMetricsBuild = this.zzk.build();
            this.zzb.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzov
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    this.zza.zzv(playbackMetricsBuild);
                }
            });
        }
        this.zzk = null;
        this.zzj = null;
        this.zzz = 0;
        this.zzx = 0;
        this.zzy = 0;
        this.zzs = null;
        this.zzt = null;
        this.zzu = null;
        this.zzA = false;
    }

    private static int zzD(int i2) {
        switch (zzep.zzF(i2)) {
            case AdError.ICONVIEW_MISSING_ERROR_CODE /* 6002 */:
                return 24;
            case AdError.AD_ASSETS_UNSUPPORTED_TYPE_ERROR_CODE /* 6003 */:
                return 28;
            case 6004:
                return 25;
            case 6005:
                return 26;
            default:
                return 27;
        }
    }

    @Nullable
    public static zzoy zza(Context context) {
        MediaMetricsManager mediaMetricsManagerB = j0.b(context.getSystemService("media_metrics"));
        if (mediaMetricsManagerB == null) {
            return null;
        }
        return new zzoy(context, mediaMetricsManagerB.createPlaybackSession());
    }

    @EnsuresNonNullIf(expression = {"#1"}, result = true)
    private final boolean zzw(@Nullable zzox zzoxVar) {
        if (zzoxVar != null) {
            return zzoxVar.zzc.equals(this.zzc.zzf());
        }
        return false;
    }

    private final void zzx(long j, @Nullable zzv zzvVar, int i2) {
        if (Objects.equals(this.zzs, zzvVar)) {
            return;
        }
        int i8 = this.zzs == null ? 1 : 0;
        this.zzs = zzvVar;
        zzA(1, j, zzvVar, i8);
    }

    private final void zzy(long j, @Nullable zzv zzvVar, int i2) {
        if (Objects.equals(this.zzt, zzvVar)) {
            return;
        }
        int i8 = this.zzt == null ? 1 : 0;
        this.zzt = zzvVar;
        zzA(0, j, zzvVar, i8);
    }

    private final void zzz(long j, @Nullable zzv zzvVar, int i2) {
        if (Objects.equals(this.zzu, zzvVar)) {
            return;
        }
        int i8 = this.zzu == null ? 1 : 0;
        this.zzu = zzvVar;
        zzA(2, j, zzvVar, i8);
    }

    public final LogSessionId zzb() {
        return this.zzd.getSessionId();
    }

    @Override // com.google.android.gms.internal.ads.zzoz
    public final void zzc(zzmj zzmjVar, String str) {
        zzuu zzuuVar = zzmjVar.zzd;
        if (zzuuVar == null || !zzuuVar.zzb()) {
            zzC();
            this.zzj = str;
            this.zzk = k0.n().setPlayerName("AndroidXMedia3").setPlayerVersion("1.8.0");
            zzB(zzmjVar.zzb, zzuuVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzoz
    public final void zzd(zzmj zzmjVar, String str, boolean z2) {
        zzuu zzuuVar = zzmjVar.zzd;
        if ((zzuuVar == null || !zzuuVar.zzb()) && str.equals(this.zzj)) {
            zzC();
        }
        this.zzh.remove(str);
        this.zzi.remove(str);
    }

    @Override // com.google.android.gms.internal.ads.zzml
    public final void zzdj(zzmj zzmjVar, zzba zzbaVar, zzba zzbaVar2, int i2) {
        if (i2 == 1) {
            this.zzv = true;
            i2 = 1;
        }
        this.zzl = i2;
    }

    @Override // com.google.android.gms.internal.ads.zzml
    public final void zzdk(zzmj zzmjVar, zzuq zzuqVar) {
        zzuu zzuuVar = zzmjVar.zzd;
        if (zzuuVar == null) {
            return;
        }
        zzv zzvVar = zzuqVar.zzb;
        zzvVar.getClass();
        zzox zzoxVar = new zzox(zzvVar, 0, this.zzc.zzb(zzmjVar.zzb, zzuuVar));
        int i2 = zzuqVar.zza;
        if (i2 != 0) {
            if (i2 == 1) {
                this.zzq = zzoxVar;
                return;
            } else if (i2 != 2) {
                if (i2 != 3) {
                    return;
                }
                this.zzr = zzoxVar;
                return;
            }
        }
        this.zzp = zzoxVar;
    }

    @Override // com.google.android.gms.internal.ads.zzml
    public final void zzdl(zzmj zzmjVar, int i2, long j, long j3) {
        zzuu zzuuVar = zzmjVar.zzd;
        if (zzuuVar != null) {
            String strZzb = this.zzc.zzb(zzmjVar.zzb, zzuuVar);
            HashMap map = this.zzi;
            Long l = (Long) map.get(strZzb);
            HashMap map2 = this.zzh;
            Long l8 = (Long) map2.get(strZzb);
            map.put(strZzb, Long.valueOf((l == null ? 0L : l.longValue()) + j));
            map2.put(strZzb, Long.valueOf((l8 != null ? l8.longValue() : 0L) + ((long) i2)));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzml
    public final void zzdm(zzmj zzmjVar, zzhs zzhsVar) {
        this.zzx += zzhsVar.zzg;
        this.zzy += zzhsVar.zze;
    }

    /* JADX WARN: Removed duplicated region for block: B:137:0x01ef  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x0295  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x029a  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x029f  */
    @Override // com.google.android.gms.internal.ads.zzml
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void zzdn(com.google.android.gms.internal.ads.zzbb r20, com.google.android.gms.internal.ads.zzmk r21) {
        /*
            Method dump skipped, instruction units count: 1000
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzoy.zzdn(com.google.android.gms.internal.ads.zzbb, com.google.android.gms.internal.ads.zzmk):void");
    }

    @Override // com.google.android.gms.internal.ads.zzml
    public final /* synthetic */ void zze(zzmj zzmjVar, int i2) {
        i0.f(this, zzmjVar, i2);
    }

    @Override // com.google.android.gms.internal.ads.zzml
    public final void zzg(zzmj zzmjVar, zzau zzauVar) {
        this.zzo = zzauVar;
    }

    @Override // com.google.android.gms.internal.ads.zzml
    public final /* synthetic */ void zzk(zzmj zzmjVar, zzv zzvVar, zzht zzhtVar) {
        i0.i(this, zzmjVar, zzvVar, zzhtVar);
    }

    @Override // com.google.android.gms.internal.ads.zzml
    public final /* synthetic */ void zzl(zzmj zzmjVar, zzv zzvVar, zzht zzhtVar) {
        i0.j(this, zzmjVar, zzvVar, zzhtVar);
    }

    @Override // com.google.android.gms.internal.ads.zzml
    public final /* synthetic */ void zzm(zzmj zzmjVar, int i2, long j) {
        i0.k(this, zzmjVar, i2, j);
    }

    @Override // com.google.android.gms.internal.ads.zzml
    public final /* synthetic */ void zzo(zzmj zzmjVar, Object obj, long j) {
        i0.l(this, zzmjVar, obj, j);
    }

    @Override // com.google.android.gms.internal.ads.zzml
    public final void zzp(zzmj zzmjVar, zzbv zzbvVar) {
        zzox zzoxVar = this.zzp;
        if (zzoxVar != null) {
            zzv zzvVar = zzoxVar.zza;
            if (zzvVar.zzw == -1) {
                zzt zztVarZza = zzvVar.zza();
                zztVarZza.zzt(zzbvVar.zzb);
                zztVarZza.zzu(zzbvVar.zzc);
                this.zzp = new zzox(zztVarZza.zzM(), 0, zzoxVar.zzc);
            }
        }
    }

    public final /* synthetic */ void zzr(PlaybackErrorEvent playbackErrorEvent) {
        this.zzd.reportPlaybackErrorEvent(playbackErrorEvent);
    }

    public final /* synthetic */ void zzs(NetworkEvent networkEvent) {
        this.zzd.reportNetworkEvent(networkEvent);
    }

    public final /* synthetic */ void zzt(PlaybackStateEvent playbackStateEvent) {
        this.zzd.reportPlaybackStateEvent(playbackStateEvent);
    }

    public final /* synthetic */ void zzu(TrackChangeEvent trackChangeEvent) {
        this.zzd.reportTrackChangeEvent(trackChangeEvent);
    }

    public final /* synthetic */ void zzv(PlaybackMetrics playbackMetrics) {
        this.zzd.reportPlaybackMetrics(playbackMetrics);
    }

    @Override // com.google.android.gms.internal.ads.zzml
    public final void zzh(zzmj zzmjVar, zzul zzulVar, zzuq zzuqVar, IOException iOException, boolean z2) {
    }
}
