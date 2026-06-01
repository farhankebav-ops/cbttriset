package com.google.android.gms.internal.ads;

import android.media.MediaCodecInfo;
import android.os.Build;
import android.util.Pair;
import androidx.annotation.CheckResult;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import com.unity3d.services.core.device.MimeTypes;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zztq {
    public static final /* synthetic */ int zza = 0;

    @GuardedBy("MediaCodecUtil.class")
    private static final HashMap zzb = new HashMap();

    @Nullable
    public static zzsy zza() throws zzti {
        List listZzb = zzb("audio/raw", false, false);
        if (listZzb.isEmpty()) {
            return null;
        }
        return (zzsy) listZzb.get(0);
    }

    public static synchronized List zzb(String str, boolean z2, boolean z7) throws zzti {
        try {
            zzth zzthVar = new zzth(str, z2, z7);
            HashMap map = zzb;
            List list = (List) map.get(zzthVar);
            if (list != null) {
                return list;
            }
            ArrayList arrayListZzh = zzh(zzthVar, new zztl(z2, z7, str.equals("video/mv-hevc")));
            if (z2 && arrayListZzh.isEmpty() && Build.VERSION.SDK_INT == 23) {
                arrayListZzh = zzh(zzthVar, new zztk(null));
                if (!arrayListZzh.isEmpty()) {
                    String str2 = ((zzsy) arrayListZzh.get(0)).zza;
                    StringBuilder sb = new StringBuilder(str.length() + 63 + str2.length());
                    sb.append("MediaCodecList API didn't list secure decoder for: ");
                    sb.append(str);
                    sb.append(". Assuming: ");
                    sb.append(str2);
                    zzdt.zzc("MediaCodecUtil", sb.toString());
                }
            }
            if ("audio/raw".equals(str)) {
                if (Build.VERSION.SDK_INT < 26 && Build.DEVICE.equals("R9") && arrayListZzh.size() == 1 && ((zzsy) arrayListZzh.get(0)).zza.equals("OMX.MTK.AUDIO.DECODER.RAW")) {
                    arrayListZzh.add(zzsy.zza("OMX.google.raw.decoder", "audio/raw", "audio/raw", null, false, true, false, false, false));
                }
                zzj(arrayListZzh, zztm.zza);
            }
            if (Build.VERSION.SDK_INT < 32 && arrayListZzh.size() > 1 && "OMX.qti.audio.decoder.flac".equals(((zzsy) arrayListZzh.get(0)).zza)) {
                arrayListZzh.add((zzsy) arrayListZzh.remove(0));
            }
            zzgpe zzgpeVarZzq = zzgpe.zzq(arrayListZzh);
            map.put(zzthVar, zzgpeVarZzq);
            return zzgpeVarZzq;
        } catch (Throwable th) {
            throw th;
        }
    }

    @RequiresNonNull({"#2.sampleMimeType"})
    public static List zzc(zztg zztgVar, zzv zzvVar, boolean z2, boolean z7) throws zzti {
        List listZza = zztgVar.zza(zzvVar.zzo, z2, z7);
        List listZzd = zzd(zztgVar, zzvVar, z2, z7);
        int i2 = zzgpe.zzd;
        zzgpb zzgpbVar = new zzgpb();
        zzgpbVar.zzh(listZza);
        zzgpbVar.zzh(listZzd);
        return zzgpbVar.zzi();
    }

    public static List zzd(zztg zztgVar, zzv zzvVar, boolean z2, boolean z7) throws zzti {
        String strZzg = zzg(zzvVar);
        return strZzg == null ? zzgpe.zzi() : zztgVar.zza(strZzg, z2, z7);
    }

    @CheckResult
    public static List zze(List list, final zzv zzvVar) {
        ArrayList arrayList = new ArrayList(list);
        zzj(arrayList, new zztp() { // from class: com.google.android.gms.internal.ads.zzto
            @Override // com.google.android.gms.internal.ads.zztp
            public final /* synthetic */ int zza(Object obj) {
                int i2 = zztq.zza;
                return ((zzsy) obj).zzd(zzvVar) ? 1 : 0;
            }
        });
        return arrayList;
    }

    public static MediaCodecInfo.CodecProfileLevel zzf(int i2, int i8) {
        MediaCodecInfo.CodecProfileLevel codecProfileLevel = new MediaCodecInfo.CodecProfileLevel();
        codecProfileLevel.profile = i2;
        codecProfileLevel.level = i8;
        return codecProfileLevel;
    }

    @Nullable
    public static String zzg(zzv zzvVar) {
        Pair pairZzd;
        String str = zzvVar.zzo;
        if ("audio/eac3-joc".equals(str)) {
            return "audio/eac3";
        }
        if ("video/dolby-vision".equals(str) && (pairZzd = zzdd.zzd(zzvVar)) != null) {
            int iIntValue = ((Integer) pairZzd.first).intValue();
            if (iIntValue == 16 || iIntValue == 256) {
                return MimeTypes.VIDEO_H265;
            }
            if (iIntValue == 512) {
                return "video/avc";
            }
            if (iIntValue == 1024) {
                return MimeTypes.VIDEO_AV1;
            }
        }
        if ("video/mv-hevc".equals(str)) {
            return MimeTypes.VIDEO_H265;
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:110:0x01ad  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x01af  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x01ca A[Catch: Exception -> 0x01c2, TryCatch #3 {Exception -> 0x01c2, blocks: (B:116:0x01bb, B:124:0x01d6, B:126:0x01e0, B:127:0x01e5, B:129:0x01f5, B:131:0x01fd, B:120:0x01ca), top: B:175:0x01bb }] */
    /* JADX WARN: Removed duplicated region for block: B:126:0x01e0 A[Catch: Exception -> 0x01c2, TryCatch #3 {Exception -> 0x01c2, blocks: (B:116:0x01bb, B:124:0x01d6, B:126:0x01e0, B:127:0x01e5, B:129:0x01f5, B:131:0x01fd, B:120:0x01ca), top: B:175:0x01bb }] */
    /* JADX WARN: Removed duplicated region for block: B:127:0x01e5 A[Catch: Exception -> 0x01c2, TryCatch #3 {Exception -> 0x01c2, blocks: (B:116:0x01bb, B:124:0x01d6, B:126:0x01e0, B:127:0x01e5, B:129:0x01f5, B:131:0x01fd, B:120:0x01ca), top: B:175:0x01bb }] */
    /* JADX WARN: Removed duplicated region for block: B:136:0x020c  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x0210 A[PHI: r7
  0x0210: PHI (r7v44 boolean) = (r7v43 boolean), (r7v46 boolean) binds: [B:135:0x020a, B:137:0x020e] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:160:0x0279 A[Catch: Exception -> 0x0041, TRY_ENTER, TryCatch #5 {Exception -> 0x0041, blocks: (B:3:0x0012, B:5:0x0027, B:7:0x0031, B:13:0x0044, B:17:0x0052, B:23:0x0067, B:25:0x0071, B:53:0x00dd, B:55:0x00e5, B:57:0x00ed, B:59:0x00f6, B:157:0x0271, B:160:0x0279, B:162:0x027f, B:163:0x02a0, B:164:0x02ce, B:62:0x0103, B:63:0x0106, B:65:0x010e, B:68:0x0119, B:70:0x0121, B:75:0x012f, B:77:0x0137, B:79:0x013f, B:82:0x014a, B:84:0x0152, B:87:0x015d, B:89:0x0165, B:92:0x0170, B:94:0x0178, B:29:0x007d, B:31:0x0089, B:33:0x0093, B:35:0x009b, B:37:0x00a3, B:39:0x00ab, B:41:0x00b3, B:43:0x00bb, B:45:0x00c3), top: B:179:0x0012 }] */
    /* JADX WARN: Removed duplicated region for block: B:175:0x01bb A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:183:0x02a0 A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00cc A[PHI: r18
  0x00cc: PHI (r18v0 int) = 
  (r18v1 int)
  (r18v1 int)
  (r18v1 int)
  (r18v1 int)
  (r18v1 int)
  (r18v1 int)
  (r18v5 int)
  (r18v5 int)
  (r18v5 int)
  (r18v5 int)
  (r18v5 int)
  (r18v5 int)
  (r18v5 int)
  (r18v5 int)
 binds: [B:98:0x0184, B:106:0x019d, B:111:0x01af, B:109:0x01ab, B:103:0x0198, B:56:0x00eb, B:32:0x0091, B:34:0x0099, B:36:0x00a1, B:38:0x00a9, B:40:0x00b1, B:42:0x00b9, B:44:0x00c1, B:46:0x00c9] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.util.ArrayList zzh(com.google.android.gms.internal.ads.zzth r27, com.google.android.gms.internal.ads.zztj r28) throws com.google.android.gms.internal.ads.zzti {
        /*
            Method dump skipped, instruction units count: 739
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zztq.zzh(com.google.android.gms.internal.ads.zzth, com.google.android.gms.internal.ads.zztj):java.util.ArrayList");
    }

    private static boolean zzi(MediaCodecInfo mediaCodecInfo, String str) {
        if (Build.VERSION.SDK_INT >= 29) {
            return mediaCodecInfo.isSoftwareOnly();
        }
        if (zzas.zza(str)) {
            return true;
        }
        String strZza = zzglm.zza(mediaCodecInfo.getName());
        if (strZza.startsWith("arc.")) {
            return false;
        }
        if (strZza.startsWith("omx.google.") || strZza.startsWith("omx.ffmpeg.")) {
            return true;
        }
        if ((strZza.startsWith("omx.sec.") && strZza.contains(".sw.")) || strZza.equals("omx.qcom.video.decoder.hevcswvdec") || strZza.startsWith("c2.android.") || strZza.startsWith("c2.google.")) {
            return true;
        }
        return (strZza.startsWith("omx.") || strZza.startsWith("c2.")) ? false : true;
    }

    private static void zzj(List list, final zztp zztpVar) {
        Collections.sort(list, new Comparator() { // from class: com.google.android.gms.internal.ads.zztn
            @Override // java.util.Comparator
            public final /* synthetic */ int compare(Object obj, Object obj2) {
                int i2 = zztq.zza;
                zztp zztpVar2 = zztpVar;
                return zztpVar2.zza(obj2) - zztpVar2.zza(obj);
            }
        });
    }
}
