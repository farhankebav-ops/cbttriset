package com.google.android.gms.ads.internal.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.media.AudioManager;
import android.telephony.TelephonyManager;
import android.webkit.CookieManager;
import android.webkit.WebResourceResponse;
import androidx.annotation.Nullable;
import com.google.android.gms.internal.ads.zzbdt;
import com.google.android.gms.internal.ads.zzbdz;
import com.google.android.gms.internal.ads.zzcgy;
import com.google.android.gms.internal.ads.zzchj;
import com.google.android.gms.internal.ads.zzegj;
import java.io.InputStream;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class zzz {
    public /* synthetic */ zzz(byte[] bArr) {
    }

    @Nullable
    public CookieManager zza(Context context) {
        throw null;
    }

    public zzchj zzb(zzcgy zzcgyVar, zzbdt zzbdtVar, boolean z2, @Nullable zzegj zzegjVar) {
        throw null;
    }

    public WebResourceResponse zzc(String str, String str2, int i2, String str3, Map map, InputStream inputStream) {
        throw null;
    }

    public boolean zzd(Activity activity, Configuration configuration) {
        return false;
    }

    public zzbdz.zzq zzf(Context context, TelephonyManager telephonyManager) {
        return zzbdz.zzq.ENUM_UNKNOWN;
    }

    public boolean zzh(Context context, String str) {
        return false;
    }

    @Nullable
    public Intent zzi(Activity activity) {
        Intent intent = new Intent();
        intent.setAction("android.settings.APP_NOTIFICATION_SETTINGS");
        intent.putExtra("app_package", activity.getPackageName());
        intent.putExtra("app_uid", activity.getApplicationInfo().uid);
        return intent;
    }

    public int zzk(AudioManager audioManager) {
        return 0;
    }

    public int zzm(Context context) {
        return ((TelephonyManager) context.getSystemService("phone")).getNetworkType();
    }

    public void zzj(Activity activity) {
    }

    public void zzg(Context context, String str, String str2) {
    }
}
