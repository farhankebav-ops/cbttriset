package com.google.android.gms.internal.ads;

import android.media.MediaCodecInfo;
import android.os.Build;
import androidx.annotation.RequiresApi;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
@RequiresApi(29)
final class zzsz {
    public static int zza(MediaCodecInfo.VideoCapabilities videoCapabilities, int i2, int i8, double d8) {
        List supportedPerformancePoints = videoCapabilities.getSupportedPerformancePoints();
        if (supportedPerformancePoints != null && !supportedPerformancePoints.isEmpty()) {
            int iZzc = zzc(supportedPerformancePoints, p0.i(i2, i8, (int) d8));
            boolean z2 = true;
            if (iZzc == 1 && zzta.zza == null) {
                if (Build.VERSION.SDK_INT < 35) {
                    int iZzb = zzb(false);
                    int iZzb2 = zzb(true);
                    if (iZzb != 0 && (iZzb2 != 0 ? !(iZzb != 2 || iZzb2 != 2) : iZzb == 2)) {
                    }
                    zzta.zza = Boolean.valueOf(z2);
                    if (!zzta.zza.booleanValue()) {
                    }
                }
                z2 = false;
                zzta.zza = Boolean.valueOf(z2);
                if (!zzta.zza.booleanValue()) {
                }
            }
            return iZzc;
        }
        return 0;
    }

    private static int zzb(boolean z2) {
        MediaCodecInfo.VideoCapabilities videoCapabilities;
        List supportedPerformancePoints;
        try {
            zzt zztVar = new zzt();
            zztVar.zzm("video/avc");
            zzv zzvVarZzM = zztVar.zzM();
            if (zzvVarZzM.zzo != null) {
                List listZzc = zztq.zzc(zztg.zzb, zzvVarZzM, z2, false);
                for (int i2 = 0; i2 < listZzc.size(); i2++) {
                    if (((zzsy) listZzc.get(i2)).zzd != null && (videoCapabilities = ((zzsy) listZzc.get(i2)).zzd.getVideoCapabilities()) != null && (supportedPerformancePoints = videoCapabilities.getSupportedPerformancePoints()) != null && !supportedPerformancePoints.isEmpty()) {
                        androidx.transition.e.j();
                        return zzc(supportedPerformancePoints, androidx.transition.e.c());
                    }
                }
            }
        } catch (zzti unused) {
        }
        return 0;
    }

    private static int zzc(List list, MediaCodecInfo.VideoCapabilities.PerformancePoint performancePoint) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            if (androidx.transition.e.d(list.get(i2)).covers(performancePoint)) {
                return 2;
            }
        }
        return 1;
    }
}
