package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import com.ironsource.Y1;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzaqr {
    @Nullable
    public static zzapd zza(zzapq zzapqVar) {
        long j;
        boolean z2;
        long j3;
        long j8;
        long j9;
        long jZzb;
        long j10;
        long j11;
        long jCurrentTimeMillis = System.currentTimeMillis();
        Map map = zzapqVar.zzc;
        if (map == null) {
            return null;
        }
        String str = (String) map.get("Date");
        long jZzb2 = str != null ? zzb(str) : 0L;
        String str2 = (String) map.get("Cache-Control");
        int i2 = 0;
        if (str2 != null) {
            String[] strArrSplit = str2.split(",", 0);
            z2 = false;
            j3 = 0;
            j8 = 0;
            while (i2 < strArrSplit.length) {
                String strTrim = strArrSplit[i2].trim();
                if (strTrim.equals("no-cache") || strTrim.equals("no-store")) {
                    return null;
                }
                if (strTrim.startsWith("max-age=")) {
                    try {
                        j8 = Long.parseLong(strTrim.substring(8));
                    } catch (Exception unused) {
                    }
                } else if (strTrim.startsWith("stale-while-revalidate=")) {
                    j3 = Long.parseLong(strTrim.substring(23));
                } else if (strTrim.equals("must-revalidate") || strTrim.equals("proxy-revalidate")) {
                    z2 = true;
                }
                i2++;
            }
            j = 0;
            i2 = 1;
        } else {
            j = 0;
            z2 = false;
            j3 = 0;
            j8 = 0;
        }
        String str3 = (String) map.get("Expires");
        long jZzb3 = str3 != null ? zzb(str3) : j;
        String str4 = (String) map.get("Last-Modified");
        if (str4 != null) {
            j9 = jCurrentTimeMillis;
            jZzb = zzb(str4);
        } else {
            j9 = jCurrentTimeMillis;
            jZzb = j;
        }
        String str5 = (String) map.get("ETag");
        if (i2 != 0) {
            long j12 = (j8 * 1000) + j9;
            if (z2) {
                j11 = j12;
            } else {
                Long.signum(j3);
                j11 = (j3 * 1000) + j12;
            }
            j10 = j12;
        } else {
            j10 = (jZzb2 <= j || jZzb3 < jZzb2) ? j : (jZzb3 - jZzb2) + j9;
            j11 = j10;
        }
        zzapd zzapdVar = new zzapd();
        zzapdVar.zza = zzapqVar.zzb;
        zzapdVar.zzb = str5;
        zzapdVar.zzf = j10;
        zzapdVar.zze = j11;
        zzapdVar.zzc = jZzb2;
        zzapdVar.zzd = jZzb;
        zzapdVar.zzg = map;
        zzapdVar.zzh = zzapqVar.zzd;
        return zzapdVar;
    }

    public static long zzb(String str) {
        try {
            return zzd("EEE, dd MMM yyyy HH:mm:ss zzz").parse(str).getTime();
        } catch (ParseException e) {
            if ("0".equals(str) || Y1.f7808f.equals(str)) {
                zzaqg.zza("Unable to parse dateStr: %s, falling back to 0", str);
                return 0L;
            }
            zzaqg.zzd(e, "Unable to parse dateStr: %s, falling back to 0", str);
            return 0L;
        }
    }

    public static String zzc(long j) {
        return zzd("EEE, dd MMM yyyy HH:mm:ss 'GMT'").format(new Date(j));
    }

    private static SimpleDateFormat zzd(String str) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str, Locale.US);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        return simpleDateFormat;
    }
}
