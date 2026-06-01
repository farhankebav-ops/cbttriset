package com.google.android.gms.internal.ads;

import android.util.Base64;
import androidx.annotation.Nullable;
import androidx.webkit.WebViewCompat;
import androidx.webkit.WebViewFeature;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzcjk {

    @Nullable
    private String zza;

    @Nullable
    private zziag zzb;

    @Nullable
    private zzied zzc;
    private final ScheduledExecutorService zzd;
    private final AtomicBoolean zze = new AtomicBoolean(false);

    public zzcjk(zzcix zzcixVar, ScheduledExecutorService scheduledExecutorService) {
        this.zzd = scheduledExecutorService;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: zzf, reason: merged with bridge method [inline-methods] */
    public final void zze() {
        try {
            String variationsHeader = WebViewFeature.isFeatureSupported(WebViewFeature.GET_VARIATIONS_HEADER) ? WebViewCompat.getVariationsHeader() : null;
            if (variationsHeader != null && !variationsHeader.isEmpty()) {
                this.zza = variationsHeader;
                byte[] bArrDecode = Base64.decode(variationsHeader, 10);
                this.zzb = zziag.zzc(bArrDecode, zzhvy.zzb());
                if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzjN)).booleanValue()) {
                    this.zzc = zzied.zzc(bArrDecode, zzhvy.zzb());
                }
                if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzjL)).booleanValue()) {
                    if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzjK)).booleanValue()) {
                        this.zzd.schedule(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcjj
                            @Override // java.lang.Runnable
                            public final /* synthetic */ void run() {
                                this.zza.zze();
                            }
                        }, ((Integer) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzjM)).intValue(), TimeUnit.MINUTES);
                    }
                }
            }
        } catch (zzhxd e) {
            e = e;
            com.google.android.gms.ads.internal.zzt.zzh().zzh(e, "ChromeVariations");
        } catch (IllegalArgumentException e4) {
            e = e4;
            com.google.android.gms.ads.internal.zzt.zzh().zzh(e, "ChromeVariations");
        }
    }

    public final void zza() {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzjK)).booleanValue() && !this.zze.getAndSet(true)) {
            zze();
        }
    }

    @Nullable
    public final String zzb() {
        zzied zziedVar = this.zzc;
        if (zziedVar != null) {
            return Base64.encodeToString(zziedVar.zzaN(), 10);
        }
        return null;
    }

    @Nullable
    public final String zzc() {
        return this.zza;
    }

    @Nullable
    public final zziag zzd() {
        return this.zzb;
    }
}
