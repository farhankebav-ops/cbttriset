package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.camera.video.internal.workaround.DefaultEncoderProfilesProvider;
import com.ironsource.C2300e4;
import com.unity3d.services.core.device.MimeTypes;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzas {
    public static final /* synthetic */ int zza = 0;
    private static final ArrayList zzb = new ArrayList();
    private static final Pattern zzc = Pattern.compile("^mp4a\\.([a-zA-Z0-9]{2})(?:\\.([0-9]{1,2}))?$");

    public static boolean zza(@Nullable String str) {
        return MimeTypes.BASE_TYPE_AUDIO.equals(zzk(str));
    }

    public static boolean zzb(@Nullable String str) {
        return MimeTypes.BASE_TYPE_VIDEO.equals(zzk(str));
    }

    public static boolean zzc(@Nullable String str) {
        return "image".equals(zzk(str)) || "application/x-image-uri".equals(str);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static boolean zzd(@Nullable String str, @Nullable String str2) {
        zzar zzarVarZzj;
        int iZza;
        if (str == null) {
            return false;
        }
        switch (str.hashCode()) {
            case -2123537834:
                if (str.equals("audio/eac3-joc")) {
                }
                break;
            case -432837260:
                if (str.equals("audio/mpeg-L1")) {
                }
                break;
            case -432837259:
                if (str.equals("audio/mpeg-L2")) {
                }
                break;
            case -53558318:
                if (!str.equals(DefaultEncoderProfilesProvider.DEFAULT_AUDIO_MIME_TYPE) || str2 == null || (zzarVarZzj = zzj(str2)) == null || (iZza = zzarVarZzj.zza()) == 0 || iZza == 16) {
                }
                break;
            case 187078296:
                if (str.equals("audio/ac3")) {
                }
                break;
            case 187094639:
                if (str.equals("audio/raw")) {
                }
                break;
            case 1504578661:
                if (str.equals("audio/eac3")) {
                }
                break;
            case 1504619009:
                if (str.equals("audio/flac")) {
                }
                break;
            case 1504831518:
                if (str.equals("audio/mpeg")) {
                }
                break;
            case 1903231877:
                if (str.equals("audio/g711-alaw")) {
                }
                break;
            case 1903589369:
                if (str.equals("audio/g711-mlaw")) {
                }
                break;
        }
        return false;
    }

    public static boolean zze(@Nullable String str, String str2) {
        String strZzf;
        zzar zzarVarZzj;
        String string = null;
        if (str != null) {
            String str3 = zzep.zza;
            String[] strArrSplit = TextUtils.isEmpty(str) ? new String[0] : str.trim().split("(\\s*,\\s*)", -1);
            StringBuilder sb = new StringBuilder();
            for (String str4 : strArrSplit) {
                if (str4 == null) {
                    strZzf = null;
                } else {
                    String strZza = zzglm.zza(str4.trim());
                    if (strZza.startsWith("avc1") || strZza.startsWith("avc3")) {
                        strZzf = "video/avc";
                    } else if (strZza.startsWith("hev1") || strZza.startsWith("hvc1")) {
                        strZzf = MimeTypes.VIDEO_H265;
                    } else if (strZza.startsWith("dvav") || strZza.startsWith("dva1") || strZza.startsWith("dvhe") || strZza.startsWith("dvh1")) {
                        strZzf = "video/dolby-vision";
                    } else if (strZza.startsWith("av01")) {
                        strZzf = MimeTypes.VIDEO_AV1;
                    } else if (strZza.startsWith("vp9") || strZza.startsWith("vp09")) {
                        strZzf = "video/x-vnd.on2.vp9";
                    } else if (strZza.startsWith("vp8") || strZza.startsWith("vp08")) {
                        strZzf = "video/x-vnd.on2.vp8";
                    } else if (strZza.startsWith("mp4a")) {
                        strZzf = (!strZza.startsWith("mp4a.") || (zzarVarZzj = zzj(strZza)) == null) ? null : zzf(zzarVarZzj.zza);
                        if (strZzf == null) {
                            strZzf = DefaultEncoderProfilesProvider.DEFAULT_AUDIO_MIME_TYPE;
                        }
                    } else if (strZza.startsWith("mha1")) {
                        strZzf = "audio/mha1";
                    } else if (strZza.startsWith("mhm1")) {
                        strZzf = "audio/mhm1";
                    } else if (strZza.startsWith("ac-3") || strZza.startsWith("dac3")) {
                        strZzf = "audio/ac3";
                    } else if (strZza.startsWith("ec-3") || strZza.startsWith("dec3")) {
                        strZzf = "audio/eac3";
                    } else if (strZza.startsWith("ec+3")) {
                        strZzf = "audio/eac3-joc";
                    } else if (strZza.startsWith("ac-4") || strZza.startsWith("dac4")) {
                        strZzf = "audio/ac4";
                    } else if (strZza.startsWith("dtsc")) {
                        strZzf = "audio/vnd.dts";
                    } else if (strZza.startsWith("dtse")) {
                        strZzf = "audio/vnd.dts.hd;profile=lbr";
                    } else if (strZza.startsWith("dtsh") || strZza.startsWith("dtsl")) {
                        strZzf = "audio/vnd.dts.hd";
                    } else if (strZza.startsWith("dtsx")) {
                        strZzf = "audio/vnd.dts.uhd;profile=p2";
                    } else if (strZza.startsWith("opus")) {
                        strZzf = "audio/opus";
                    } else if (strZza.startsWith("vorbis")) {
                        strZzf = "audio/vorbis";
                    } else if (strZza.startsWith("flac")) {
                        strZzf = "audio/flac";
                    } else if (strZza.startsWith("stpp")) {
                        strZzf = "application/ttml+xml";
                    } else if (strZza.startsWith("wvtt")) {
                        strZzf = "text/vtt";
                    } else if (strZza.contains("cea708")) {
                        strZzf = "application/cea-708";
                    } else if (strZza.contains("eia608") || strZza.contains("cea608")) {
                        strZzf = "application/cea-608";
                    } else {
                        ArrayList arrayList = zzb;
                        int size = arrayList.size();
                        for (int i2 = 0; i2 < size; i2++) {
                            String str5 = ((zzaq) arrayList.get(i2)).zzb;
                            if (strZza.startsWith(null)) {
                                break;
                            }
                        }
                        strZzf = null;
                    }
                }
                if (str2.equals(strZzf)) {
                    if (sb.length() > 0) {
                        sb.append(",");
                    }
                    sb.append(str4);
                }
            }
            if (sb.length() > 0) {
                string = sb.toString();
            }
        }
        return string != null;
    }

    @Nullable
    public static String zzf(int i2) {
        if (i2 == 32) {
            return "video/mp4v-es";
        }
        if (i2 == 33) {
            return "video/avc";
        }
        if (i2 == 35) {
            return MimeTypes.VIDEO_H265;
        }
        if (i2 == 64) {
            return DefaultEncoderProfilesProvider.DEFAULT_AUDIO_MIME_TYPE;
        }
        if (i2 == 163) {
            return "video/wvc1";
        }
        if (i2 == 177) {
            return "video/x-vnd.on2.vp9";
        }
        if (i2 == 221) {
            return "audio/vorbis";
        }
        if (i2 == 165) {
            return "audio/ac3";
        }
        if (i2 == 166) {
            return "audio/eac3";
        }
        switch (i2) {
            case 96:
            case 97:
            case 98:
            case 99:
            case 100:
            case 101:
                return "video/mpeg2";
            case 102:
            case 103:
            case 104:
                return DefaultEncoderProfilesProvider.DEFAULT_AUDIO_MIME_TYPE;
            case 105:
            case 107:
                return "audio/mpeg";
            case 106:
                return "video/mpeg";
            case 108:
                return "image/jpeg";
            default:
                switch (i2) {
                    case 169:
                    case 172:
                        return "audio/vnd.dts";
                    case 170:
                    case 171:
                        return "audio/vnd.dts.hd";
                    case 173:
                        return "audio/opus";
                    case 174:
                        return "audio/ac4";
                    default:
                        return null;
                }
        }
    }

    public static int zzg(@Nullable String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        if (zza(str)) {
            return 1;
        }
        if (zzb(str)) {
            return 2;
        }
        if (C2300e4.h.K0.equals(zzk(str)) || "application/x-media3-cues".equals(str) || "application/cea-608".equals(str) || "application/cea-708".equals(str) || "application/x-mp4-cea-608".equals(str) || "application/x-subrip".equals(str) || "application/ttml+xml".equals(str) || "application/x-quicktime-tx3g".equals(str) || "application/x-mp4-vtt".equals(str) || "application/x-rawcc".equals(str) || "application/vobsub".equals(str) || "application/pgs".equals(str) || "application/dvbsubs".equals(str)) {
            return 3;
        }
        if (zzc(str)) {
            return 4;
        }
        if ("application/id3".equals(str) || "application/x-emsg".equals(str) || "application/x-scte35".equals(str) || "application/x-icy".equals(str) || "application/vnd.dvb.ait".equals(str) || "application/meta".equals(str)) {
            return 5;
        }
        if ("application/x-camera-motion".equals(str)) {
            return 6;
        }
        ArrayList arrayList = zzb;
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            String str2 = ((zzaq) arrayList.get(i2)).zza;
            if (str.equals(null)) {
                return 0;
            }
        }
        return -1;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0095 A[ADDED_TO_REGION, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0095 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int zzh(java.lang.String r3, @androidx.annotation.Nullable java.lang.String r4) {
        /*
            int r0 = r3.hashCode()
            r1 = 8
            r2 = 0
            switch(r0) {
                case -2123537834: goto L8a;
                case -1365340241: goto L81;
                case -1095064472: goto L77;
                case -53558318: goto L60;
                case 187078296: goto L56;
                case 187078297: goto L4b;
                case 550520934: goto L40;
                case 1504578661: goto L36;
                case 1504831518: goto L2b;
                case 1504891608: goto L20;
                case 1505942594: goto L17;
                case 1556697186: goto Lc;
                default: goto La;
            }
        La:
            goto L95
        Lc:
            java.lang.String r4 = "audio/true-hd"
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L95
            r3 = 14
            return r3
        L17:
            java.lang.String r4 = "audio/vnd.dts.hd"
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L95
            return r1
        L20:
            java.lang.String r4 = "audio/opus"
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L95
            r3 = 20
            return r3
        L2b:
            java.lang.String r4 = "audio/mpeg"
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L95
            r3 = 9
            return r3
        L36:
            java.lang.String r4 = "audio/eac3"
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L95
            r3 = 6
            return r3
        L40:
            java.lang.String r4 = "audio/vnd.dts.uhd;profile=p2"
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L95
            r3 = 30
            return r3
        L4b:
            java.lang.String r4 = "audio/ac4"
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L95
            r3 = 17
            return r3
        L56:
            java.lang.String r4 = "audio/ac3"
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L95
            r3 = 5
            return r3
        L60:
            java.lang.String r0 = "audio/mp4a-latm"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L95
            if (r4 != 0) goto L6b
            return r2
        L6b:
            com.google.android.gms.internal.ads.zzar r3 = zzj(r4)
            if (r3 != 0) goto L72
            return r2
        L72:
            int r3 = r3.zza()
            return r3
        L77:
            java.lang.String r4 = "audio/vnd.dts"
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L95
            r3 = 7
            return r3
        L81:
            java.lang.String r4 = "audio/vnd.dts.hd;profile=lbr"
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L95
            return r1
        L8a:
            java.lang.String r4 = "audio/eac3-joc"
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L95
            r3 = 18
            return r3
        L95:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzas.zzh(java.lang.String, java.lang.String):int");
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static String zzi(String str) {
        if (str == null) {
            return null;
        }
        String strZza = zzglm.zza(str);
        switch (strZza.hashCode()) {
            case -1833600100:
                return strZza.equals("video/x-mvhevc") ? "video/mv-hevc" : strZza;
            case -1007807498:
                return strZza.equals("audio/x-flac") ? "audio/flac" : strZza;
            case -979095690:
                return strZza.equals("application/x-mpegurl") ? "application/x-mpegURL" : strZza;
            case -586683234:
                return strZza.equals("audio/x-wav") ? "audio/wav" : strZza;
            case -432836268:
                return strZza.equals("audio/mpeg-l1") ? "audio/mpeg-L1" : strZza;
            case -432836267:
                return strZza.equals("audio/mpeg-l2") ? "audio/mpeg-L2" : strZza;
            case 187090231:
                return strZza.equals("audio/mp3") ? "audio/mpeg" : strZza;
            default:
                return strZza;
        }
    }

    @Nullable
    @VisibleForTesting
    public static zzar zzj(String str) {
        Matcher matcher = zzc.matcher(str);
        if (!matcher.matches()) {
            return null;
        }
        String strGroup = matcher.group(1);
        strGroup.getClass();
        String strGroup2 = matcher.group(2);
        try {
            return new zzar(Integer.parseInt(strGroup, 16), strGroup2 != null ? Integer.parseInt(strGroup2) : 0);
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    @Nullable
    private static String zzk(@Nullable String str) {
        int iIndexOf;
        if (str == null || (iIndexOf = str.indexOf(47)) == -1) {
            return null;
        }
        return str.substring(0, iIndexOf);
    }
}
