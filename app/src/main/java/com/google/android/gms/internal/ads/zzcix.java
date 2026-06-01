package com.google.android.gms.internal.ads;

import android.webkit.WebView;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.UiThread;
import androidx.webkit.Profile;
import androidx.webkit.ProfileStore;
import androidx.webkit.WebViewCompat;
import androidx.webkit.WebViewFeature;
import com.unity3d.services.core.fid.Constants;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzcix {

    @Nullable
    private Profile zza = null;

    public final void zza(WebView webView) {
        if (this.zza != null) {
            try {
                WebViewCompat.setProfile(webView, "GMA_WEBVIEW_PROFILE");
                com.google.android.gms.ads.internal.util.zze.zza("WebViewCompat Profile is defined");
            } catch (IllegalStateException e) {
                String strConcat = "WebViewCompat error: ".concat(e.toString());
                int i2 = com.google.android.gms.ads.internal.util.zze.zza;
                com.google.android.gms.ads.internal.util.client.zzo.zzi(strConcat);
                if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzoO)).booleanValue()) {
                    com.google.android.gms.ads.internal.zzt.zzh().zzg(e, "WebViewCompat.setProfile");
                }
            }
        }
    }

    @RequiresApi(api = 24)
    @UiThread
    public final void zzb(zzcjb zzcjbVar) {
        ProfileStore profileStore;
        if (!WebViewFeature.isFeatureSupported(WebViewFeature.MULTI_PROFILE)) {
            int i2 = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzd("WebViewFeature.MULTI_PROFILE is not supported");
            return;
        }
        try {
            profileStore = (ProfileStore) zzfve.zza("androidx.webkit.ProfileStore", Constants.GET_INSTANCE, new zzfvd[0]);
        } catch (ClassCastException | ClassNotFoundException | IllegalAccessException | IllegalStateException | NoSuchMethodException | InvocationTargetException e) {
            String strValueOf = String.valueOf(e.getMessage());
            int i8 = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzd("Unable to get ProfileStore instance: ".concat(strValueOf));
            try {
                profileStore = (ProfileStore) zzfve.zza("androidx.webkit.ProfileStore$-CC", Constants.GET_INSTANCE, new zzfvd[0]);
            } catch (ClassCastException | ClassNotFoundException | IllegalAccessException | IllegalStateException | NoSuchMethodException | InvocationTargetException e4) {
                com.google.android.gms.ads.internal.util.client.zzo.zzd("Unable to get ProfileStore instance: ".concat(String.valueOf(e4.getMessage())));
                profileStore = null;
            }
        }
        if (profileStore != null) {
            this.zza = profileStore.getOrCreateProfile("GMA_WEBVIEW_PROFILE");
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzoN)).booleanValue()) {
                long jElapsedRealtime = com.google.android.gms.ads.internal.zzt.zzk().elapsedRealtime() - zzcjbVar.zza;
                zzdvh zzdvhVarZza = zzcjbVar.zzb.zzd().zza();
                zzdvhVarZza.zzc("action", "webview_p_l");
                zzdvhVarZza.zzc("webview_p_l", Long.toString(jElapsedRealtime));
                zzdvhVarZza.zzd();
                return;
            }
            return;
        }
        int i9 = com.google.android.gms.ads.internal.util.zze.zza;
        com.google.android.gms.ads.internal.util.client.zzo.zzi("WebViewCompat failure: No instance");
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzoN)).booleanValue()) {
            zzdvh zzdvhVarZza2 = zzcjbVar.zzb.zzd().zza();
            zzdvhVarZza2.zzc("action", "webview_p_f");
            zzdvhVarZza2.zzc("webview_p_f", "No instance");
            zzdvhVarZza2.zzd();
        }
    }
}
