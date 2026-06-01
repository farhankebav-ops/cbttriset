package com.google.android.gms.ads.nonagon.util.logging.csi;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.exifinterface.media.ExifInterface;
import com.google.android.gms.ads.internal.client.zzbd;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.zzs;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.internal.ads.zzbel;
import com.google.android.gms.internal.ads.zzbeu;
import com.google.android.gms.internal.ads.zzgmu;
import com.ironsource.C2300e4;
import com.ironsource.Q6;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class CsiParamDefaults {
    private final Context zza;
    private final String zzb;
    private final String zzc;

    public CsiParamDefaults(@NonNull Context context, @NonNull VersionInfoParcel versionInfoParcel) {
        this.zza = context;
        this.zzb = context.getPackageName();
        this.zzc = versionInfoParcel.afmaVersion;
    }

    public void set(@NonNull Map<String, String> map) {
        map.put("s", "gmob_sdk");
        map.put("v", ExifInterface.GPS_MEASUREMENT_3D);
        map.put(Q6.F, Build.VERSION.RELEASE);
        map.put("api_v", Build.VERSION.SDK);
        zzt.zzc();
        map.put(C2300e4.h.G, zzs.zzv());
        map.put("app", this.zzb);
        zzt.zzc();
        Context context = this.zza;
        map.put("is_lite_sdk", true != zzs.zzI(context) ? "0" : "1");
        zzbel zzbelVar = zzbeu.zza;
        List listZzf = zzbd.zzb().zzf();
        if (((Boolean) zzbd.zzc().zzd(zzbeu.zzhs)).booleanValue()) {
            listZzf.addAll(zzt.zzh().zzo().zzi().zzh());
        }
        map.put("e", TextUtils.join(",", listZzf));
        map.put("sdkVersion", this.zzc);
        if (((Boolean) zzbd.zzc().zzd(zzbeu.zzmq)).booleanValue()) {
            zzt.zzc();
            map.put("is_bstar", true != zzs.zzF(context) ? "0" : "1");
        }
        if (((Boolean) zzbd.zzc().zzd(zzbeu.zzku)).booleanValue()) {
            if (((Boolean) zzbd.zzc().zzd(zzbeu.zzcI)).booleanValue()) {
                map.put(Q6.L, zzgmu.zza(zzt.zzh().zzu()));
            }
        }
    }
}
