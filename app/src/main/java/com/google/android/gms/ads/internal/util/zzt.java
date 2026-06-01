package com.google.android.gms.ads.internal.util;

import android.content.Context;
import android.webkit.CookieManager;
import android.webkit.WebResourceResponse;
import androidx.annotation.Nullable;
import com.google.android.gms.internal.ads.zzbdt;
import com.google.android.gms.internal.ads.zzcgy;
import com.google.android.gms.internal.ads.zzchj;
import com.google.android.gms.internal.ads.zzcim;
import com.google.android.gms.internal.ads.zzegj;
import java.io.InputStream;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class zzt extends zzz {
    public zzt() {
        super(null);
    }

    @Override // com.google.android.gms.ads.internal.util.zzz
    @Nullable
    public final CookieManager zza(Context context) {
        com.google.android.gms.ads.internal.zzt.zzc();
        if (zzs.zzJ()) {
            return null;
        }
        try {
            return CookieManager.getInstance();
        } catch (Throwable th) {
            int i2 = zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzg("Failed to obtain CookieManager.", th);
            com.google.android.gms.ads.internal.zzt.zzh().zzh(th, "ApiLevelUtil.getCookieManager");
            return null;
        }
    }

    @Override // com.google.android.gms.ads.internal.util.zzz
    public zzchj zzb(zzcgy zzcgyVar, zzbdt zzbdtVar, boolean z2, @Nullable zzegj zzegjVar) {
        return new zzcim(zzcgyVar, zzbdtVar, z2, zzegjVar);
    }

    @Override // com.google.android.gms.ads.internal.util.zzz
    public final WebResourceResponse zzc(String str, String str2, int i2, String str3, Map map, InputStream inputStream) {
        return new WebResourceResponse(str, str2, i2, str3, map, inputStream);
    }
}
