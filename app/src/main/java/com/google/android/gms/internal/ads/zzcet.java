package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzcet implements zzblx {
    @Override // com.google.android.gms.internal.ads.zzblx
    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        zzcdr zzcdrVar = (zzcdr) obj;
        zzcie zzcieVarZzh = zzcdrVar.zzh();
        if (zzcieVarZzh == null) {
            try {
                zzcie zzcieVar = new zzcie(zzcdrVar, Float.parseFloat((String) map.get("duration")), "1".equals(map.get("customControlsAllowed")), "1".equals(map.get("clickToExpandAllowed")));
                zzcdrVar.zzw(zzcieVar);
                zzcieVarZzh = zzcieVar;
            } catch (NullPointerException e) {
                e = e;
                Throwable th = e;
                int i2 = com.google.android.gms.ads.internal.util.zze.zza;
                com.google.android.gms.ads.internal.util.client.zzo.zzg("Unable to parse videoMeta message.", th);
                com.google.android.gms.ads.internal.zzt.zzh().zzg(th, "VideoMetaGmsgHandler.onGmsg");
                return;
            } catch (NumberFormatException e4) {
                e = e4;
                Throwable th2 = e;
                int i22 = com.google.android.gms.ads.internal.util.zze.zza;
                com.google.android.gms.ads.internal.util.client.zzo.zzg("Unable to parse videoMeta message.", th2);
                com.google.android.gms.ads.internal.zzt.zzh().zzg(th2, "VideoMetaGmsgHandler.onGmsg");
                return;
            }
        }
        float f4 = Float.parseFloat((String) map.get("duration"));
        boolean zEquals = "1".equals(map.get("muted"));
        float f8 = Float.parseFloat((String) map.get("currentTime"));
        int i8 = Integer.parseInt((String) map.get("playbackState"));
        if (i8 < 0 || i8 > 3) {
            i8 = 0;
        }
        String str = (String) map.get("aspectRatio");
        float f9 = TextUtils.isEmpty(str) ? 0.0f : Float.parseFloat(str);
        if (com.google.android.gms.ads.internal.util.client.zzo.zzm(3)) {
            StringBuilder sb = new StringBuilder(String.valueOf(f8).length() + 45 + String.valueOf(f4).length() + 13 + String.valueOf(zEquals).length() + 19 + String.valueOf(i8).length() + 17 + String.valueOf(str).length());
            sb.append("Video Meta GMSG: currentTime : ");
            sb.append(f8);
            sb.append(" , duration : ");
            sb.append(f4);
            sb.append(" , isMuted : ");
            sb.append(zEquals);
            sb.append(" , playbackState : ");
            sb.append(i8);
            sb.append(" , aspectRatio : ");
            sb.append(str);
            com.google.android.gms.ads.internal.util.client.zzo.zzd(sb.toString());
        }
        zzcieVarZzh.zzs(f8, f4, i8, zEquals, f9);
    }
}
