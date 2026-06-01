package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Build;
import androidx.exifinterface.media.ExifInterface;
import com.ironsource.C2300e4;
import com.ironsource.Q6;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Future;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzbex {
    private final String zza = (String) zzbgo.zza.zze();
    private final Map zzb;
    private final Context zzc;
    private final String zzd;

    public zzbex(Context context, String str) {
        this.zzc = context;
        this.zzd = str;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        this.zzb = linkedHashMap;
        linkedHashMap.put("s", "gmob_sdk");
        linkedHashMap.put("v", ExifInterface.GPS_MEASUREMENT_3D);
        linkedHashMap.put(Q6.F, Build.VERSION.RELEASE);
        linkedHashMap.put("api_v", Build.VERSION.SDK);
        com.google.android.gms.ads.internal.zzt.zzc();
        linkedHashMap.put(C2300e4.h.G, com.google.android.gms.ads.internal.util.zzs.zzv());
        linkedHashMap.put("app", context.getApplicationContext() != null ? context.getApplicationContext().getPackageName() : context.getPackageName());
        com.google.android.gms.ads.internal.zzt.zzc();
        linkedHashMap.put("is_lite_sdk", true != com.google.android.gms.ads.internal.util.zzs.zzI(context) ? "0" : "1");
        Future futureZza = com.google.android.gms.ads.internal.zzt.zzp().zza(context);
        try {
            linkedHashMap.put("network_coarse", Integer.toString(((zzbxn) futureZza.get()).zzj));
            linkedHashMap.put("network_fine", Integer.toString(((zzbxn) futureZza.get()).zzk));
        } catch (Exception e) {
            com.google.android.gms.ads.internal.zzt.zzh().zzg(e, "CsiConfiguration.CsiConfiguration");
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzmq)).booleanValue()) {
            Map map = this.zzb;
            com.google.android.gms.ads.internal.zzt.zzc();
            map.put("is_bstar", true != com.google.android.gms.ads.internal.util.zzs.zzF(context) ? "0" : "1");
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzku)).booleanValue()) {
            if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzcI)).booleanValue() || zzgmu.zzc(com.google.android.gms.ads.internal.zzt.zzh().zzu())) {
                return;
            }
            this.zzb.put(Q6.L, com.google.android.gms.ads.internal.zzt.zzh().zzu());
        }
    }

    public final String zza() {
        return this.zza;
    }

    public final Context zzb() {
        return this.zzc;
    }

    public final String zzc() {
        return this.zzd;
    }

    public final Map zzd() {
        return this.zzb;
    }
}
