package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.webkit.WebView;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.ironsource.C2300e4;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzfpz {
    private static final zzfpz zza = new zzfpz();

    private zzfpz() {
    }

    public static final zzfpz zza() {
        return zza;
    }

    public static final boolean zzk(WebView webView, String str) {
        if (webView != null && !TextUtils.isEmpty(str)) {
            try {
                try {
                    webView.evaluateJavascript(str, null);
                    return true;
                } catch (IllegalStateException unused) {
                    StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 12);
                    sb.append("javascript: ");
                    sb.append(str);
                    webView.loadUrl(sb.toString());
                    return true;
                }
            } catch (Exception e) {
                e.getMessage();
                zzfor.zza.getClass();
            }
        }
        return false;
    }

    public final void zzb(WebView webView, String str, JSONObject jSONObject) {
        zzj(webView, C2300e4.a.f8295f, jSONObject, str);
    }

    public final void zzc(WebView webView, String str, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3) {
        zzj(webView, "startSession", str, jSONObject, jSONObject2, jSONObject3);
    }

    public final void zzd(WebView webView, String str) {
        zzj(webView, "finishSession", str);
    }

    public final void zze(WebView webView, String str, String str2) {
        zzj(webView, "setNativeViewHierarchy", str2, str);
    }

    public final void zzf(WebView webView, String str, String str2) {
        zzj(webView, "setState", str2, str);
    }

    public final void zzg(WebView webView, String str, String str2) {
        zzj(webView, "setDeviceLockState", str2);
    }

    public final void zzh(WebView webView, String str, float f4) {
        zzj(webView, "setDeviceVolume", Float.valueOf(f4), str);
    }

    public final void zzi(WebView webView, @NonNull JSONObject jSONObject) {
        zzj(webView, "setLastActivity", jSONObject);
    }

    @VisibleForTesting
    public final void zzj(WebView webView, String str, Object... objArr) {
        if (webView == null) {
            zzfor.zza.getClass();
            return;
        }
        StringBuilder sb = new StringBuilder(128);
        sb.append("if(window.omidBridge!==undefined){omidBridge.");
        sb.append(str);
        sb.append("(");
        for (Object obj : objArr) {
            if (obj == null) {
                sb.append("null");
            } else if (obj instanceof String) {
                String string = obj.toString();
                if (string.startsWith("{")) {
                    sb.append(string);
                } else {
                    sb.append('\"');
                    sb.append(string);
                    sb.append('\"');
                }
            } else {
                sb.append(obj);
            }
            sb.append(",");
        }
        sb.setLength(sb.length() - 1);
        sb.append(")}");
        String string2 = sb.toString();
        Handler handler = webView.getHandler();
        if (handler == null) {
            handler = new Handler(Looper.getMainLooper());
        }
        if (Looper.myLooper() == handler.getLooper()) {
            zzk(webView, string2);
        } else {
            handler.post(new zzfpy(this, webView, string2));
        }
    }
}
