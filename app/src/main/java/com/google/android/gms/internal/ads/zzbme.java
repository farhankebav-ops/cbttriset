package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.CollectionUtils;
import com.ironsource.C2300e4;
import com.onesignal.inAppMessages.internal.display.impl.WebViewManager;
import com.vungle.ads.internal.presenter.MRAIDPresenter;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzbme implements zzblx {
    static final Map zza = CollectionUtils.mapOfKeyValueArrays(new String[]{WebViewManager.EVENT_TYPE_RESIZE, "playVideo", "storePicture", "createCalendarEvent", MRAIDPresenter.SET_ORIENTATION_PROPERTIES, "closeResizedAd", "unload"}, new Integer[]{1, 2, 3, 4, 5, 6, 7});
    private final com.google.android.gms.ads.internal.zzb zzb;
    private final zzbuh zzc;
    private final zzbuo zzd;

    public zzbme(com.google.android.gms.ads.internal.zzb zzbVar, zzbuh zzbuhVar, zzbuo zzbuoVar) {
        this.zzb = zzbVar;
        this.zzc = zzbuhVar;
        this.zzd = zzbuoVar;
    }

    @Override // com.google.android.gms.internal.ads.zzblx
    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        zzcgy zzcgyVar = (zzcgy) obj;
        int iIntValue = ((Integer) zza.get((String) map.get("a"))).intValue();
        int i2 = 6;
        if (iIntValue != 5) {
            if (iIntValue != 7) {
                com.google.android.gms.ads.internal.zzb zzbVar = this.zzb;
                if (!zzbVar.zzb()) {
                    zzbVar.zzc(null);
                    return;
                }
                if (iIntValue == 1) {
                    this.zzc.zza(map);
                    return;
                }
                if (iIntValue == 3) {
                    new zzbuk(zzcgyVar, map).zza();
                    return;
                }
                if (iIntValue == 4) {
                    new zzbue(zzcgyVar, map).zza();
                    return;
                }
                if (iIntValue != 5) {
                    if (iIntValue == 6) {
                        this.zzc.zzb(true);
                        return;
                    } else if (iIntValue != 7) {
                        int i8 = com.google.android.gms.ads.internal.util.zze.zza;
                        com.google.android.gms.ads.internal.util.client.zzo.zzh("Unknown MRAID command called.");
                        return;
                    }
                }
            }
            this.zzd.zzc();
            return;
        }
        String str = (String) map.get("forceOrientation");
        boolean z2 = map.containsKey("allowOrientationChange") ? Boolean.parseBoolean((String) map.get("allowOrientationChange")) : true;
        if (zzcgyVar == null) {
            int i9 = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzi("AdWebView is null");
            return;
        }
        if (C2300e4.h.D.equalsIgnoreCase(str)) {
            i2 = 7;
        } else if (!C2300e4.h.C.equalsIgnoreCase(str)) {
            i2 = z2 ? -1 : 14;
        }
        zzcgyVar.zzam(i2);
    }
}
