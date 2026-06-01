package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzafy {
    private static final String[] zza = {"Camera:MotionPhoto", "GCamera:MotionPhoto", "Camera:MicroVideo", "GCamera:MicroVideo"};
    private static final String[] zzb = {"Camera:MotionPhotoPresentationTimestampUs", "GCamera:MotionPhotoPresentationTimestampUs", "Camera:MicroVideoPresentationTimestampUs", "GCamera:MicroVideoPresentationTimestampUs"};
    private static final String[] zzc = {"Camera:MicroVideoOffset", "GCamera:MicroVideoOffset"};

    /* JADX WARN: Code restructure failed: missing block: B:27:0x0084, code lost:
    
        r7 = -9223372036854775807L;
     */
    @androidx.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.google.android.gms.internal.ads.zzafx zza(java.lang.String r22) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 231
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzafy.zza(java.lang.String):com.google.android.gms.internal.ads.zzafx");
    }

    public static boolean zzb(@Nullable String str) {
        if (str == null) {
            return false;
        }
        String[] strArr = zza;
        for (int i2 = 0; i2 < 4; i2++) {
            if (str.contains(String.valueOf(strArr[i2]).concat("=\"1\""))) {
                return true;
            }
        }
        return false;
    }

    private static zzgpe zzc(XmlPullParser xmlPullParser, String str, String str2) throws XmlPullParserException, IOException {
        int i2 = zzgpe.zzd;
        zzgpb zzgpbVar = new zzgpb();
        do {
            String strConcat = str.concat(":Item");
            xmlPullParser.next();
            if (zzeq.zzb(xmlPullParser, strConcat)) {
                String strConcat2 = str2.concat(":Mime");
                String strConcat3 = str2.concat(":Semantic");
                String strConcat4 = str2.concat(":Length");
                String strConcat5 = str2.concat(":Padding");
                String strZzc = zzeq.zzc(xmlPullParser, strConcat2);
                String strZzc2 = zzeq.zzc(xmlPullParser, strConcat3);
                String strZzc3 = zzeq.zzc(xmlPullParser, strConcat4);
                String strZzc4 = zzeq.zzc(xmlPullParser, strConcat5);
                if (strZzc == null || strZzc2 == null) {
                    return zzgpe.zzi();
                }
                zzgpbVar.zzf(new zzafw(strZzc, strZzc2, strZzc3 != null ? Long.parseLong(strZzc3) : 0L, strZzc4 != null ? Long.parseLong(strZzc4) : 0L));
            }
        } while (!zzeq.zza(xmlPullParser, str.concat(":Directory")));
        return zzgpbVar.zzi();
    }
}
