package com.google.android.gms.internal.ads;

import android.webkit.ValueCallback;
import android.webkit.WebView;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzbbs implements Runnable {
    final ValueCallback zza;
    final /* synthetic */ zzbbk zzb;
    final /* synthetic */ WebView zzc;
    final /* synthetic */ boolean zzd;
    final /* synthetic */ zzbbu zze;

    public zzbbs(zzbbu zzbbuVar, final zzbbk zzbbkVar, final WebView webView, final boolean z2) {
        this.zzb = zzbbkVar;
        this.zzc = webView;
        this.zzd = z2;
        Objects.requireNonNull(zzbbuVar);
        this.zze = zzbbuVar;
        this.zza = new ValueCallback() { // from class: com.google.android.gms.internal.ads.zzbbr
            @Override // android.webkit.ValueCallback
            public final /* synthetic */ void onReceiveValue(Object obj) {
                this.zza.zze.zzd(zzbbkVar, webView, (String) obj, z2);
            }
        };
    }

    @Override // java.lang.Runnable
    public final void run() {
        WebView webView = this.zzc;
        if (webView.getSettings().getJavaScriptEnabled()) {
            try {
                webView.evaluateJavascript("(function() { return  {text:document.body.innerText}})();", this.zza);
            } catch (Throwable unused) {
                this.zza.onReceiveValue("");
            }
        }
    }
}
