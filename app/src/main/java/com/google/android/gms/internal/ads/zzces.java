package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Color;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.MotionEvent;
import androidx.core.app.NotificationCompat;
import com.ironsource.C2300e4;
import com.ironsource.C2318f4;
import com.ironsource.C2461n2;
import com.onesignal.session.internal.influence.impl.InfluenceConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzces implements zzblx {
    private boolean zza;

    private static int zzb(Context context, Map map, String str, int i2) {
        String str2 = (String) map.get(str);
        if (str2 != null) {
            try {
                com.google.android.gms.ads.internal.client.zzbb.zza();
                i2 = com.google.android.gms.ads.internal.util.client.zzf.zzC(context, Integer.parseInt(str2));
            } catch (NumberFormatException unused) {
                String strN = androidx.camera.core.processing.util.a.n(new StringBuilder(str.length() + 34 + str2.length()), "Could not parse ", str, " in a video GMSG: ", str2);
                int i8 = com.google.android.gms.ads.internal.util.zze.zza;
                com.google.android.gms.ads.internal.util.client.zzo.zzi(strN);
            }
        }
        if (com.google.android.gms.ads.internal.util.zze.zzc()) {
            int length = str.length();
            StringBuilder sb = new StringBuilder(String.valueOf(i2).length() + length + 30 + String.valueOf(str2).length() + 6 + 1);
            androidx.camera.core.processing.util.a.A(sb, "Parse pixels for ", str, ", got string ", str2);
            sb.append(", int ");
            sb.append(i2);
            sb.append(".");
            com.google.android.gms.ads.internal.util.zze.zza(sb.toString());
        }
        return i2;
    }

    private static void zzc(zzcdf zzcdfVar, Map map) {
        String str = (String) map.get("minBufferMs");
        String str2 = (String) map.get("maxBufferMs");
        String str3 = (String) map.get("bufferForPlaybackMs");
        String str4 = (String) map.get("bufferForPlaybackAfterRebufferMs");
        String str5 = (String) map.get("socketReceiveBufferSize");
        if (str != null) {
            try {
                zzcdfVar.zzx(Integer.parseInt(str));
            } catch (NumberFormatException unused) {
                String strO = a1.a.o("Could not parse buffer parameters in loadControl video GMSG: (", str, ", ", str2, ")");
                int i2 = com.google.android.gms.ads.internal.util.zze.zza;
                com.google.android.gms.ads.internal.util.client.zzo.zzi(strO);
                return;
            }
        }
        if (str2 != null) {
            zzcdfVar.zzy(Integer.parseInt(str2));
        }
        if (str3 != null) {
            zzcdfVar.zzz(Integer.parseInt(str3));
        }
        if (str4 != null) {
            zzcdfVar.zzA(Integer.parseInt(str4));
        }
        if (str5 != null) {
            zzcdfVar.zzB(Integer.parseInt(str5));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzblx
    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        int iMin;
        int iMin2;
        int i2;
        Integer numValueOf;
        int i8;
        zzcdr zzcdrVar = (zzcdr) obj;
        String str = (String) map.get("action");
        if (str == null) {
            int i9 = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzi("Action missing from video GMSG.");
            return;
        }
        Integer numValueOf2 = map.containsKey("playerId") ? Integer.valueOf(Integer.parseInt((String) map.get("playerId"))) : null;
        Integer numZza = zzcdrVar.zzdr() != null ? zzcdrVar.zzdr().zza() : null;
        if (numValueOf2 != null && numZza != null && !numValueOf2.equals(numZza) && !str.equals("load")) {
            Locale locale = Locale.US;
            int i10 = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzh("Event intended for player " + numValueOf2 + ", but sent to player " + numZza + " - event ignored");
            return;
        }
        if (com.google.android.gms.ads.internal.util.client.zzo.zzm(3)) {
            JSONObject jSONObject = new JSONObject(map);
            jSONObject.remove("google.afma.Notify_dt");
            String string = jSONObject.toString();
            StringBuilder sb = new StringBuilder(str.length() + 13 + String.valueOf(string).length());
            sb.append("Video GMSG: ");
            sb.append(str);
            sb.append(" ");
            sb.append(string);
            com.google.android.gms.ads.internal.util.client.zzo.zzd(sb.toString());
        }
        if (str.equals("background")) {
            String str2 = (String) map.get("color");
            if (TextUtils.isEmpty(str2)) {
                com.google.android.gms.ads.internal.util.client.zzo.zzi("Color parameter missing from background video GMSG.");
                return;
            }
            try {
                zzcdrVar.setBackgroundColor(Color.parseColor(str2));
                return;
            } catch (IllegalArgumentException unused) {
                com.google.android.gms.ads.internal.util.client.zzo.zzi("Invalid color parameter in background video GMSG.");
                return;
            }
        }
        if (str.equals("playerBackground")) {
            String str3 = (String) map.get("color");
            if (TextUtils.isEmpty(str3)) {
                com.google.android.gms.ads.internal.util.client.zzo.zzi("Color parameter missing from playerBackground video GMSG.");
                return;
            }
            try {
                zzcdrVar.zzv(Color.parseColor(str3));
                return;
            } catch (IllegalArgumentException unused2) {
                com.google.android.gms.ads.internal.util.client.zzo.zzi("Invalid color parameter in playerBackground video GMSG.");
                return;
            }
        }
        if (str.equals("decoderProps")) {
            String str4 = (String) map.get("mimeTypes");
            if (str4 == null) {
                com.google.android.gms.ads.internal.util.client.zzo.zzi("No MIME types specified for decoder properties inspection.");
                HashMap map2 = new HashMap();
                map2.put(NotificationCompat.CATEGORY_EVENT, "decoderProps");
                map2.put("error", "missingMimeTypes");
                zzcdrVar.zze("onVideoEvent", map2);
                return;
            }
            HashMap map3 = new HashMap();
            for (String str5 : str4.split(",")) {
                map3.put(str5, com.google.android.gms.ads.internal.util.zzch.zza(str5.trim()));
            }
            HashMap map4 = new HashMap();
            map4.put(NotificationCompat.CATEGORY_EVENT, "decoderProps");
            map4.put("mimeTypes", map3);
            zzcdrVar.zze("onVideoEvent", map4);
            return;
        }
        zzcdg zzcdgVarZzdr = zzcdrVar.zzdr();
        if (zzcdgVarZzdr == null) {
            com.google.android.gms.ads.internal.util.client.zzo.zzi("Could not get underlay container for a video GMSG.");
            return;
        }
        boolean zEquals = str.equals("new");
        boolean zEquals2 = str.equals(C2300e4.h.L);
        if (zEquals || zEquals2) {
            Context context = zzcdrVar.getContext();
            int iZzb = zzb(context, map, "x", 0);
            int iZzb2 = zzb(context, map, "y", 0);
            int iZzb3 = zzb(context, map, "w", -1);
            zzbel zzbelVar = zzbeu.zzet;
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbelVar)).booleanValue()) {
                iMin = iZzb3 == -1 ? zzcdrVar.zzy() : Math.min(iZzb3, zzcdrVar.zzy());
            } else {
                if (com.google.android.gms.ads.internal.util.zze.zzc()) {
                    int iZzy = zzcdrVar.zzy();
                    StringBuilder sb2 = new StringBuilder(String.valueOf(iZzb).length() + androidx.camera.core.processing.util.a.D(String.valueOf(iZzb3).length() + 72, 4, String.valueOf(iZzy)) + 1);
                    sb2.append("Calculate width with original width ");
                    sb2.append(iZzb3);
                    sb2.append(", videoHost.getVideoBoundingWidth() ");
                    sb2.append(iZzy);
                    sb2.append(", x ");
                    sb2.append(iZzb);
                    sb2.append(".");
                    com.google.android.gms.ads.internal.util.zze.zza(sb2.toString());
                }
                iMin = Math.min(iZzb3, zzcdrVar.zzy() - iZzb);
            }
            int i11 = iMin;
            int iZzb4 = zzb(context, map, "h", -1);
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbelVar)).booleanValue()) {
                iMin2 = iZzb4 == -1 ? zzcdrVar.zzx() : Math.min(iZzb4, zzcdrVar.zzx());
            } else {
                if (com.google.android.gms.ads.internal.util.zze.zzc()) {
                    int iZzx = zzcdrVar.zzx();
                    StringBuilder sb3 = new StringBuilder(String.valueOf(iZzb2).length() + androidx.camera.core.processing.util.a.D(String.valueOf(iZzb4).length() + 75, 4, String.valueOf(iZzx)) + 1);
                    sb3.append("Calculate height with original height ");
                    sb3.append(iZzb4);
                    sb3.append(", videoHost.getVideoBoundingHeight() ");
                    sb3.append(iZzx);
                    sb3.append(", y ");
                    sb3.append(iZzb2);
                    sb3.append(".");
                    com.google.android.gms.ads.internal.util.zze.zza(sb3.toString());
                }
                iMin2 = Math.min(iZzb4, zzcdrVar.zzx() - iZzb2);
            }
            int i12 = iMin2;
            try {
                i2 = Integer.parseInt((String) map.get("player"));
            } catch (NumberFormatException unused3) {
                i2 = 0;
            }
            boolean z2 = Boolean.parseBoolean((String) map.get("spherical"));
            if (!zEquals || zzcdgVarZzdr.zzd() != null) {
                zzcdgVarZzdr.zzb(iZzb, iZzb2, i11, i12);
                return;
            }
            zzcdgVarZzdr.zzc(iZzb, iZzb2, i11, i12, i2, z2, new zzcdq((String) map.get("flags")));
            zzcdf zzcdfVarZzd = zzcdgVarZzdr.zzd();
            if (zzcdfVarZzd != null) {
                zzc(zzcdfVarZzd, map);
                return;
            }
            return;
        }
        zzcie zzcieVarZzh = zzcdrVar.zzh();
        if (zzcieVarZzh != null) {
            if (str.equals("timeupdate")) {
                String str6 = (String) map.get("currentTime");
                if (str6 == null) {
                    com.google.android.gms.ads.internal.util.client.zzo.zzi("currentTime parameter missing from timeupdate video GMSG.");
                    return;
                }
                try {
                    zzcieVarZzh.zzd(Float.parseFloat(str6));
                    return;
                } catch (NumberFormatException unused4) {
                    com.google.android.gms.ads.internal.util.client.zzo.zzi("Could not parse currentTime parameter from timeupdate video GMSG: ".concat(str6));
                    return;
                }
            }
            if (str.equals("skip")) {
                zzcieVarZzh.zzr();
                return;
            }
        }
        zzcdf zzcdfVarZzd2 = zzcdgVarZzdr.zzd();
        if (zzcdfVarZzd2 == null) {
            HashMap map5 = new HashMap();
            map5.put(NotificationCompat.CATEGORY_EVENT, "no_video_view");
            zzcdrVar.zze("onVideoEvent", map5);
            return;
        }
        if (str.equals(C2318f4.f8523d)) {
            Context context2 = zzcdrVar.getContext();
            int iZzb5 = zzb(context2, map, "x", 0);
            float fZzb = zzb(context2, map, "y", 0);
            long jUptimeMillis = SystemClock.uptimeMillis();
            MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 0, iZzb5, fZzb, 0);
            zzcdfVarZzd2.zzC(motionEventObtain);
            motionEventObtain.recycle();
            return;
        }
        if (str.equals("currentTime")) {
            String str7 = (String) map.get(InfluenceConstants.TIME);
            if (str7 == null) {
                com.google.android.gms.ads.internal.util.client.zzo.zzi("Time parameter missing from currentTime video GMSG.");
                return;
            }
            try {
                zzcdfVarZzd2.zzt((int) (Float.parseFloat(str7) * 1000.0f));
                return;
            } catch (NumberFormatException unused5) {
                com.google.android.gms.ads.internal.util.client.zzo.zzi("Could not parse time parameter from currentTime video GMSG: ".concat(str7));
                return;
            }
        }
        if (str.equals("hide")) {
            zzcdfVarZzd2.setVisibility(4);
            return;
        }
        if (str.equals("remove")) {
            zzcdfVarZzd2.setVisibility(8);
            return;
        }
        if (str.equals("load")) {
            zzcdfVarZzd2.zzq(numValueOf2);
            return;
        }
        if (str.equals("loadControl")) {
            zzc(zzcdfVarZzd2, map);
            return;
        }
        if (str.equals("muted")) {
            if (Boolean.parseBoolean((String) map.get("muted"))) {
                zzcdfVarZzd2.zzu();
                return;
            } else {
                zzcdfVarZzd2.zzv();
                return;
            }
        }
        if (str.equals("pause")) {
            zzcdfVarZzd2.zzr();
            return;
        }
        if (str.equals("play")) {
            zzcdfVarZzd2.zzs();
            return;
        }
        if (str.equals(C2461n2.f9471v)) {
            zzcdfVarZzd2.setVisibility(0);
            return;
        }
        if (!str.equals("src")) {
            if (str.equals("touchMove")) {
                Context context3 = zzcdrVar.getContext();
                zzcdfVarZzd2.zzp(zzb(context3, map, "dx", 0), zzb(context3, map, "dy", 0));
                if (this.zza) {
                    return;
                }
                zzcdrVar.zzl();
                this.zza = true;
                return;
            }
            if (!str.equals("volume")) {
                if (str.equals("watermark")) {
                    zzcdfVarZzd2.zzD();
                    return;
                } else {
                    com.google.android.gms.ads.internal.util.client.zzo.zzi("Unknown video action: ".concat(str));
                    return;
                }
            }
            String str8 = (String) map.get("volume");
            if (str8 == null) {
                com.google.android.gms.ads.internal.util.client.zzo.zzi("Level parameter missing from volume video GMSG.");
                return;
            }
            try {
                zzcdfVarZzd2.zzw(Float.parseFloat(str8));
                return;
            } catch (NumberFormatException unused6) {
                com.google.android.gms.ads.internal.util.client.zzo.zzi("Could not parse volume parameter from volume video GMSG: ".concat(str8));
                return;
            }
        }
        String str9 = (String) map.get("src");
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzcs)).booleanValue() && TextUtils.isEmpty(str9)) {
            com.google.android.gms.ads.internal.util.client.zzo.zzi("Src parameter missing from src video GMSG.");
            return;
        }
        if (map.containsKey("periodicReportIntervalMs")) {
            try {
                numValueOf = Integer.valueOf(Integer.parseInt((String) map.get("periodicReportIntervalMs")));
                i8 = 1;
            } catch (NumberFormatException unused7) {
                com.google.android.gms.ads.internal.util.client.zzo.zzi("Video gmsg invalid numeric parameter 'periodicReportIntervalMs': ".concat(String.valueOf((String) map.get("periodicReportIntervalMs"))));
                i8 = 1;
                numValueOf = null;
            }
        } else {
            i8 = 1;
            numValueOf = null;
        }
        String[] strArr = new String[i8];
        strArr[0] = str9;
        String str10 = (String) map.get("demuxed");
        if (str10 != null) {
            try {
                JSONArray jSONArray = new JSONArray(str10);
                ArrayList arrayList = new ArrayList();
                for (int i13 = 0; i13 < jSONArray.length(); i13++) {
                    String string2 = jSONArray.getString(i13);
                    if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzcs)).booleanValue() || !TextUtils.isEmpty(string2)) {
                        arrayList.add(string2);
                    }
                }
                if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzcs)).booleanValue() && arrayList.isEmpty()) {
                    StringBuilder sb4 = new StringBuilder(str10.length() + 41);
                    sb4.append("All demuxed URLs are empty for playback: ");
                    sb4.append(str10);
                    com.google.android.gms.ads.internal.util.client.zzo.zzi(sb4.toString());
                    return;
                }
                strArr = (String[]) arrayList.toArray(new String[arrayList.size()]);
            } catch (JSONException unused8) {
                com.google.android.gms.ads.internal.util.client.zzo.zzi("Malformed demuxed URL list for playback: ".concat(str10));
                strArr = new String[]{str9};
            }
        }
        if (numValueOf != null) {
            zzcdrVar.zzo(numValueOf.intValue());
        }
        zzcdfVarZzd2.zzo(str9, strArr);
    }
}
