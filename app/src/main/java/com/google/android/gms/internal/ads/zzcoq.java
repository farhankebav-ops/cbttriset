package com.google.android.gms.internal.ads;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.CookieManager;
import androidx.annotation.Nullable;
import com.ironsource.G5;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzcoq implements zzcnu {

    @Nullable
    private final CookieManager zza;

    public zzcoq(Context context) {
        this.zza = com.google.android.gms.ads.internal.zzt.zzf().zza(context);
    }

    @Override // com.google.android.gms.internal.ads.zzcnu
    public final void zza(Map map) {
        CookieManager cookieManager = this.zza;
        if (cookieManager == null) {
            return;
        }
        if (((String) map.get("clear")) == null) {
            String str = (String) map.get("cookie");
            if (TextUtils.isEmpty(str)) {
                return;
            }
            cookieManager.setCookie((String) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzbf), str);
            return;
        }
        String str2 = (String) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzbf);
        String cookie = cookieManager.getCookie(str2);
        if (cookie != null) {
            List listZze = zzgms.zza(zzglr.zzc(';')).zze(cookie);
            for (int i2 = 0; i2 < listZze.size(); i2++) {
                Iterator it = zzgms.zza(zzglr.zzc(G5.T)).zzd((String) listZze.get(i2)).iterator();
                it.getClass();
                if (!it.hasNext()) {
                    throw new IndexOutOfBoundsException(com.google.android.gms.ads.internal.client.a.j(new StringBuilder(String.valueOf(0).length() + 70), "position (0) must be less than the number of elements that remained (", 0, ")"));
                }
                cookieManager.setCookie(str2, String.valueOf((String) it.next()).concat(String.valueOf((String) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzaR))));
            }
        }
    }
}
