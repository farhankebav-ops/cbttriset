package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.net.Uri;
import android.os.Looper;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.webkit.DownloadListener;
import android.webkit.ValueCallback;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.annotation.VisibleForTesting;
import androidx.webkit.WebViewCompat;
import androidx.webkit.WebViewFeature;
import com.bumptech.glide.load.Key;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.util.Predicate;
import com.google.android.gms.internal.ads.zzbdz;
import com.ironsource.C2393j8;
import com.unity3d.ads.adplayer.AndroidWebViewClient;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
@VisibleForTesting
final class zzcib extends WebView implements DownloadListener, ViewTreeObserver.OnGlobalLayoutListener, zzcgy {
    public static final /* synthetic */ int zza = 0;
    private final String zzA;
    private zzcie zzB;
    private boolean zzC;
    private boolean zzD;
    private zzbhv zzE;
    private zzbhs zzF;
    private zzbch zzG;
    private int zzH;
    private int zzI;
    private zzbfg zzJ;
    private final zzbfg zzK;
    private zzbfg zzL;
    private final zzbfh zzM;
    private int zzN;
    private com.google.android.gms.ads.internal.overlay.zzm zzO;
    private boolean zzP;
    private final com.google.android.gms.ads.internal.util.zzci zzQ;
    private int zzR;
    private int zzS;
    private int zzT;
    private int zzU;
    private int zzV;
    private Map zzW;
    private final WindowManager zzX;
    private final zzbdt zzY;
    private boolean zzZ;
    private final zzcja zzb;
    private final zzaxa zzc;
    private final zzfgr zzd;
    private final zzbgb zze;
    private final VersionInfoParcel zzf;
    private com.google.android.gms.ads.internal.zzn zzg;
    private final com.google.android.gms.ads.internal.zza zzh;
    private final DisplayMetrics zzi;
    private final float zzj;
    private zzffu zzk;
    private zzffx zzl;
    private boolean zzm;
    private boolean zzn;
    private zzchj zzo;
    private com.google.android.gms.ads.internal.overlay.zzm zzp;
    private zzehf zzq;
    private zzehd zzr;
    private zzcji zzs;
    private final String zzt;
    private boolean zzu;
    private boolean zzv;
    private boolean zzw;
    private boolean zzx;
    private Boolean zzy;
    private boolean zzz;

    @VisibleForTesting
    public zzcib(zzcja zzcjaVar, zzcji zzcjiVar, String str, boolean z2, boolean z7, zzaxa zzaxaVar, zzbgb zzbgbVar, VersionInfoParcel versionInfoParcel, zzbfj zzbfjVar, com.google.android.gms.ads.internal.zzn zznVar, com.google.android.gms.ads.internal.zza zzaVar, zzbdt zzbdtVar, zzffu zzffuVar, zzffx zzffxVar, zzfgr zzfgrVar) {
        zzffx zzffxVar2;
        super(zzcjaVar);
        this.zzm = false;
        this.zzn = false;
        this.zzz = true;
        this.zzA = "";
        this.zzR = -1;
        this.zzS = -1;
        this.zzT = -1;
        this.zzU = -1;
        this.zzV = -1;
        this.zzb = zzcjaVar;
        this.zzs = zzcjiVar;
        this.zzt = str;
        this.zzw = z2;
        this.zzc = zzaxaVar;
        this.zzd = zzfgrVar;
        this.zze = zzbgbVar;
        this.zzf = versionInfoParcel;
        this.zzg = zznVar;
        this.zzh = zzaVar;
        WindowManager windowManager = (WindowManager) getContext().getSystemService("window");
        this.zzX = windowManager;
        com.google.android.gms.ads.internal.zzt.zzc();
        DisplayMetrics displayMetricsZzx = com.google.android.gms.ads.internal.util.zzs.zzx(windowManager);
        this.zzi = displayMetricsZzx;
        this.zzj = displayMetricsZzx.density;
        this.zzY = zzbdtVar;
        this.zzk = zzffuVar;
        this.zzl = zzffxVar;
        this.zzQ = new com.google.android.gms.ads.internal.util.zzci(zzcjaVar.zzb(), this, this, null);
        this.zzZ = false;
        setBackgroundColor(0);
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzmD)).booleanValue()) {
            setSoundEffectsEnabled(false);
        }
        WebSettings settings = getSettings();
        settings.setAllowFileAccess(false);
        try {
            settings.setJavaScriptEnabled(true);
        } catch (NullPointerException e) {
            int i2 = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzg("Unable to enable Javascript.", e);
        }
        settings.setSavePassword(false);
        settings.setSupportMultipleWindows(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzmC)).booleanValue()) {
            settings.setMixedContentMode(1);
        } else {
            settings.setMixedContentMode(2);
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzoj)).booleanValue()) {
            settings.setGeolocationEnabled(false);
        }
        settings.setUserAgentString(com.google.android.gms.ads.internal.zzt.zzc().zze(zzcjaVar, versionInfoParcel.afmaVersion));
        com.google.android.gms.ads.internal.zzt.zzc();
        com.google.android.gms.ads.internal.util.zzs.zzr(getContext(), settings);
        setDownloadListener(this);
        zzbc();
        addJavascriptInterface(new zzcij(this, new zzcii() { // from class: com.google.android.gms.internal.ads.zzcih
            @Override // com.google.android.gms.internal.ads.zzcii
            public final /* synthetic */ void zza(Uri uri) {
                zzchj zzchjVarZzaS = ((zzcib) this).zzaS();
                if (zzchjVarZzaS != null) {
                    zzchjVarZzaS.zzO(uri);
                } else {
                    int i8 = com.google.android.gms.ads.internal.util.zze.zza;
                    com.google.android.gms.ads.internal.util.client.zzo.zzf("Unable to pass GMSG, no AdWebViewClient for AdWebView!");
                }
            }
        }), "googleAdsJsInterface");
        removeJavascriptInterface("accessibility");
        removeJavascriptInterface("accessibilityTraversal");
        zzbh();
        zzbfh zzbfhVar = new zzbfh(new zzbfj(true, "make_wv", this.zzt));
        this.zzM = zzbfhVar;
        zzbfhVar.zzc().zza(null);
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzch)).booleanValue() && (zzffxVar2 = this.zzl) != null && zzffxVar2.zzb != null) {
            zzbfhVar.zzc().zzd("gqi", this.zzl.zzb);
        }
        zzbfhVar.zzc();
        zzbfg zzbfgVarZzf = zzbfj.zzf();
        this.zzK = zzbfgVarZzf;
        zzbfhVar.zza("native:view_create", zzbfgVarZzf);
        this.zzL = null;
        this.zzJ = null;
        com.google.android.gms.ads.internal.util.zzce.zza().zzb(zzcjaVar);
        com.google.android.gms.ads.internal.zzt.zzh().zzj();
    }

    private final synchronized void zzaZ(String str) {
        final String str2 = AndroidWebViewClient.BLANK_PAGE;
        try {
            com.google.android.gms.ads.internal.util.zzs.zza.post(new Runnable(str2) { // from class: com.google.android.gms.internal.ads.zzchy
                private final /* synthetic */ String zzb = AndroidWebViewClient.BLANK_PAGE;

                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    this.zza.zzaW(this.zzb);
                }
            });
        } catch (Throwable th) {
            com.google.android.gms.ads.internal.zzt.zzh().zzg(th, "AdWebViewImpl.loadUrlUnsafe");
            int i2 = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzj("Could not call loadUrl in destroy(). ", th);
        }
    }

    private final synchronized void zzba() {
        Boolean boolZzc = com.google.android.gms.ads.internal.zzt.zzh().zzc();
        this.zzy = boolZzc;
        if (boolZzc == null) {
            try {
                evaluateJavascript("(function(){})()", null);
                zzaQ(Boolean.TRUE);
            } catch (IllegalStateException unused) {
                zzaQ(Boolean.FALSE);
            }
        }
    }

    private final void zzbb() {
        zzbfb.zza(this.zzM.zzc(), this.zzK, "aeh2");
    }

    private final synchronized void zzbc() {
        zzffu zzffuVar = this.zzk;
        if (zzffuVar != null && zzffuVar.zzam) {
            int i2 = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzd("Disabling hardware acceleration on an overlay.");
            zzbd();
            return;
        }
        if (!this.zzw && !this.zzs.zzg()) {
            int i8 = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzd("Enabling hardware acceleration on an AdView.");
            zzbe();
            return;
        }
        int i9 = com.google.android.gms.ads.internal.util.zze.zza;
        com.google.android.gms.ads.internal.util.client.zzo.zzd("Enabling hardware acceleration on an overlay.");
        zzbe();
    }

    private final synchronized void zzbd() {
        try {
            if (!this.zzx) {
                setLayerType(1, null);
            }
            this.zzx = true;
        } catch (Throwable th) {
            throw th;
        }
    }

    private final synchronized void zzbe() {
        try {
            if (this.zzx) {
                setLayerType(0, null);
            }
            this.zzx = false;
        } catch (Throwable th) {
            throw th;
        }
    }

    private final synchronized void zzbf() {
        if (this.zzP) {
            return;
        }
        this.zzP = true;
        com.google.android.gms.ads.internal.zzt.zzh().zzk();
    }

    private final synchronized void zzbg() {
        try {
            Map map = this.zzW;
            if (map != null) {
                Iterator it = map.values().iterator();
                while (it.hasNext()) {
                    ((zzcfe) it.next()).release();
                }
            }
            this.zzW = null;
        } catch (Throwable th) {
            throw th;
        }
    }

    private final void zzbh() {
        zzbfh zzbfhVar = this.zzM;
        if (zzbfhVar == null) {
            return;
        }
        zzbfj zzbfjVarZzc = zzbfhVar.zzc();
        zzbez zzbezVarZza = com.google.android.gms.ads.internal.zzt.zzh().zza();
        if (zzbezVarZza != null) {
            zzbezVarZza.zzb(zzbfjVarZzc);
        }
    }

    private final void zzbi(boolean z2) {
        HashMap map = new HashMap();
        map.put(C2393j8.k, true != z2 ? "0" : "1");
        zze("onAdVisibilityChanged", map);
    }

    @Override // android.webkit.WebView, com.google.android.gms.internal.ads.zzcgy
    public final synchronized void destroy() {
        try {
            zzbh();
            this.zzQ.zzc();
            com.google.android.gms.ads.internal.overlay.zzm zzmVar = this.zzp;
            if (zzmVar != null) {
                zzmVar.zzb();
                this.zzp.zzq();
                this.zzp = null;
            }
            this.zzq = null;
            this.zzr = null;
            this.zzo.zzF();
            this.zzG = null;
            this.zzg = null;
            setOnClickListener(null);
            setOnTouchListener(null);
            if (this.zzv) {
                return;
            }
            com.google.android.gms.ads.internal.zzt.zzB().zza(this);
            zzbg();
            this.zzv = true;
            if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzlN)).booleanValue()) {
                com.google.android.gms.ads.internal.util.zze.zza("Destroying the WebView immediately...");
                zzY();
                return;
            }
            Activity activityZzb = this.zzb.zzb();
            if (activityZzb != null && activityZzb.isDestroyed()) {
                com.google.android.gms.ads.internal.util.zze.zza("Destroying the WebView immediately...");
                zzY();
            } else {
                com.google.android.gms.ads.internal.util.zze.zza("Initiating WebView self destruct sequence in 3...");
                com.google.android.gms.ads.internal.util.zze.zza("Loading blank page in WebView, 2...");
                zzaZ(AndroidWebViewClient.BLANK_PAGE);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // android.webkit.WebView
    public final synchronized void evaluateJavascript(final String str, final ValueCallback valueCallback) {
        if (zzX()) {
            int i2 = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzl("#004 The webview is destroyed. Ignoring action.", null);
            if (valueCallback != null) {
                valueCallback.onReceiveValue(null);
                return;
            }
            return;
        }
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzlO)).booleanValue() || Looper.getMainLooper().getThread() == Thread.currentThread()) {
            super.evaluateJavascript(str, valueCallback);
        } else {
            zzcbv.zzf.zza(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcia
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    this.zza.zzaU(str, valueCallback);
                }
            });
        }
    }

    public final void finalize() throws Throwable {
        try {
            synchronized (this) {
                try {
                    if (!this.zzv) {
                        this.zzo.zzF();
                        com.google.android.gms.ads.internal.zzt.zzB().zza(this);
                        zzbg();
                        zzbf();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        } finally {
            super.finalize();
        }
    }

    @Override // android.webkit.WebView, com.google.android.gms.internal.ads.zzcgy
    public final synchronized void loadData(String str, String str2, String str3) {
        if (!zzX()) {
            super.loadData(str, str2, str3);
        } else {
            int i2 = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzi("#004 The webview is destroyed. Ignoring action.");
        }
    }

    @Override // android.webkit.WebView, com.google.android.gms.internal.ads.zzcgy
    public final synchronized void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) throws Throwable {
        try {
            try {
                if (!zzX()) {
                    super.loadDataWithBaseURL(str, str2, str3, str4, str5);
                    return;
                } else {
                    int i2 = com.google.android.gms.ads.internal.util.zze.zza;
                    com.google.android.gms.ads.internal.util.client.zzo.zzi("#004 The webview is destroyed. Ignoring action.");
                    return;
                }
            } catch (Throwable th) {
                th = th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
        throw th;
    }

    @Override // android.webkit.WebView, com.google.android.gms.internal.ads.zzcgy
    public final synchronized void loadUrl(final String str) {
        if (zzX()) {
            int i2 = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzi("#004 The webview is destroyed. Ignoring action.");
            return;
        }
        try {
            com.google.android.gms.ads.internal.util.zzs.zza.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzchx
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    this.zza.zzaV(str);
                }
            });
        } catch (Throwable th) {
            com.google.android.gms.ads.internal.zzt.zzh().zzg(th, "AdWebViewImpl.loadUrl");
            int i8 = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzj("Could not call loadUrl. ", th);
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zza
    public final void onAdClicked() {
        zzchj zzchjVar = this.zzo;
        if (zzchjVar != null) {
            zzchjVar.onAdClicked();
        }
    }

    @Override // android.webkit.WebView, android.view.ViewGroup, android.view.View
    public final synchronized void onAttachedToWindow() {
        try {
            super.onAttachedToWindow();
            if (!zzX()) {
                this.zzQ.zzd();
            }
            if (this.zzZ) {
                onResume();
                this.zzZ = false;
            }
            boolean z2 = this.zzC;
            zzchj zzchjVar = this.zzo;
            if (zzchjVar != null && zzchjVar.zzl()) {
                if (!this.zzD) {
                    this.zzo.zzo();
                    this.zzo.zzp();
                    this.zzD = true;
                }
                zzaM();
                z2 = true;
            }
            zzbi(z2);
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        zzchj zzchjVar;
        synchronized (this) {
            try {
                if (!zzX()) {
                    this.zzQ.zze();
                }
                super.onDetachedFromWindow();
                if (this.zzD && (zzchjVar = this.zzo) != null && zzchjVar.zzl() && getViewTreeObserver() != null && getViewTreeObserver().isAlive()) {
                    this.zzo.zzo();
                    this.zzo.zzp();
                    this.zzD = false;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        zzbi(false);
    }

    @Override // android.webkit.DownloadListener
    public final void onDownloadStart(String str, String str2, String str3, String str4, long j) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setDataAndType(Uri.parse(str), str4);
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzmc)).booleanValue() && getContext() != null) {
                intent.setPackage(getContext().getPackageName());
            }
            com.google.android.gms.ads.internal.zzt.zzc();
            com.google.android.gms.ads.internal.util.zzs.zzZ(getContext(), intent);
        } catch (ActivityNotFoundException e) {
            String strN = androidx.camera.core.processing.util.a.n(new StringBuilder(String.valueOf(str).length() + 51 + String.valueOf(str4).length()), "Couldn't find an Activity to view url/mimetype: ", str, " / ", str4);
            int i2 = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzd(strN);
            com.google.android.gms.ads.internal.zzt.zzh().zzg(e, "AdWebViewImpl.onDownloadStart: ".concat(String.valueOf(str)));
        }
    }

    @Override // android.webkit.WebView, android.view.View
    public final void onDraw(Canvas canvas) {
        if (zzX()) {
            return;
        }
        super.onDraw(canvas);
    }

    @Override // android.webkit.WebView, android.view.View
    public final boolean onGenericMotionEvent(MotionEvent motionEvent) {
        float axisValue = motionEvent.getAxisValue(9);
        float axisValue2 = motionEvent.getAxisValue(10);
        if (motionEvent.getActionMasked() == 8) {
            if (axisValue > 0.0f && !canScrollVertically(-1)) {
                return false;
            }
            if (axisValue < 0.0f && !canScrollVertically(1)) {
                return false;
            }
            if (axisValue2 > 0.0f && !canScrollHorizontally(-1)) {
                return false;
            }
            if (axisValue2 < 0.0f && !canScrollHorizontally(1)) {
                return false;
            }
        }
        return super.onGenericMotionEvent(motionEvent);
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        boolean zZzaM = zzaM();
        com.google.android.gms.ads.internal.overlay.zzm zzmVarZzL = zzL();
        if (zzmVarZzL == null || !zZzaM) {
            return;
        }
        zzmVarZzL.zzC();
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x008d  */
    @Override // android.webkit.WebView, android.widget.AbsoluteLayout, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final synchronized void onMeasure(int r9, int r10) {
        /*
            Method dump skipped, instruction units count: 527
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcib.onMeasure(int, int):void");
    }

    @Override // android.webkit.WebView, com.google.android.gms.internal.ads.zzcgy
    public final void onPause() {
        if (zzX()) {
            return;
        }
        try {
            super.onPause();
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zznD)).booleanValue() && WebViewFeature.isFeatureSupported(WebViewFeature.MUTE_AUDIO)) {
                int i2 = com.google.android.gms.ads.internal.util.zze.zza;
                com.google.android.gms.ads.internal.util.client.zzo.zzd("Muting webview");
                WebViewCompat.setAudioMuted(this, true);
            }
        } catch (Exception e) {
            int i8 = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzg("Could not pause webview.", e);
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zznG)).booleanValue()) {
                com.google.android.gms.ads.internal.zzt.zzh().zzg(e, "AdWebViewImpl.onPause");
            }
        }
    }

    @Override // android.webkit.WebView, com.google.android.gms.internal.ads.zzcgy
    public final void onResume() {
        if (zzX()) {
            return;
        }
        try {
            super.onResume();
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zznD)).booleanValue() && WebViewFeature.isFeatureSupported(WebViewFeature.MUTE_AUDIO)) {
                int i2 = com.google.android.gms.ads.internal.util.zze.zza;
                com.google.android.gms.ads.internal.util.client.zzo.zzd("Unmuting webview");
                WebViewCompat.setAudioMuted(this, false);
            }
        } catch (Exception e) {
            int i8 = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzg("Could not resume webview.", e);
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zznG)).booleanValue()) {
                com.google.android.gms.ads.internal.zzt.zzh().zzg(e, "AdWebViewImpl.onResume");
            }
        }
    }

    @Override // android.webkit.WebView, android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z2 = ((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzea)).booleanValue() && this.zzo.zzm();
        if ((!this.zzo.zzl() || this.zzo.zzn()) && !z2) {
            zzaxa zzaxaVar = this.zzc;
            if (zzaxaVar != null) {
                zzaxaVar.zzc(motionEvent);
            }
            zzbgb zzbgbVar = this.zze;
            if (zzbgbVar != null) {
                zzbgbVar.zza(motionEvent);
            }
        } else {
            synchronized (this) {
                try {
                    zzbhv zzbhvVar = this.zzE;
                    if (zzbhvVar != null) {
                        zzbhvVar.zzb(motionEvent);
                    }
                } finally {
                }
            }
        }
        if (zzX()) {
            return false;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.webkit.WebView, com.google.android.gms.internal.ads.zzcgy
    public final void setWebViewClient(WebViewClient webViewClient) {
        super.setWebViewClient(webViewClient);
        if (webViewClient instanceof zzchj) {
            this.zzo = (zzchj) webViewClient;
        }
    }

    @Override // android.webkit.WebView
    public final void stopLoading() {
        if (zzX()) {
            return;
        }
        try {
            super.stopLoading();
        } catch (Exception e) {
            int i2 = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzg("Could not stop loading webview.", e);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcgy, com.google.android.gms.internal.ads.zzcgp
    public final zzffu zzC() {
        return this.zzk;
    }

    @Override // com.google.android.gms.internal.ads.zzcgy
    public final List zzF() {
        return new ArrayList();
    }

    @Override // com.google.android.gms.internal.ads.zzcgy
    public final void zzG() {
        zzbb();
        HashMap map = new HashMap(1);
        map.put("version", this.zzf.afmaVersion);
        zze("onhide", map);
    }

    @Override // com.google.android.gms.internal.ads.zzcgy
    public final void zzH(int i2) {
        if (i2 == 0) {
            zzbfh zzbfhVar = this.zzM;
            zzbfb.zza(zzbfhVar.zzc(), this.zzK, "aebb2");
        }
        zzbb();
        zzbfh zzbfhVar2 = this.zzM;
        zzbfhVar2.zzc();
        zzbfhVar2.zzc().zzd("close_type", String.valueOf(i2));
        HashMap map = new HashMap(2);
        map.put("closetype", String.valueOf(i2));
        map.put("version", this.zzf.afmaVersion);
        zze("onhide", map);
    }

    @Override // com.google.android.gms.internal.ads.zzcgy
    public final void zzI() {
        if (this.zzJ == null) {
            zzbfh zzbfhVar = this.zzM;
            zzbfb.zza(zzbfhVar.zzc(), this.zzK, "aes2");
            zzbfhVar.zzc();
            zzbfg zzbfgVarZzf = zzbfj.zzf();
            this.zzJ = zzbfgVarZzf;
            zzbfhVar.zza("native:view_show", zzbfgVarZzf);
        }
        HashMap map = new HashMap(1);
        map.put("version", this.zzf.afmaVersion);
        zze("onshow", map);
    }

    @Override // com.google.android.gms.internal.ads.zzcgy
    public final void zzJ() {
        HashMap map = new HashMap(3);
        map.put("app_muted", String.valueOf(com.google.android.gms.ads.internal.zzt.zzi().zzd()));
        map.put("app_volume", String.valueOf(com.google.android.gms.ads.internal.zzt.zzi().zzb()));
        map.put("device_volume", String.valueOf(com.google.android.gms.ads.internal.util.zzaa.zze(getContext())));
        zze("volume", map);
    }

    @Override // com.google.android.gms.internal.ads.zzcgy
    public final Context zzK() {
        return this.zzb.zzc();
    }

    @Override // com.google.android.gms.internal.ads.zzcgy
    public final synchronized com.google.android.gms.ads.internal.overlay.zzm zzL() {
        return this.zzp;
    }

    @Override // com.google.android.gms.internal.ads.zzcgy
    public final synchronized com.google.android.gms.ads.internal.overlay.zzm zzM() {
        return this.zzO;
    }

    @Override // com.google.android.gms.internal.ads.zzcgy, com.google.android.gms.internal.ads.zzciq
    public final synchronized zzcji zzN() {
        return this.zzs;
    }

    @Override // com.google.android.gms.internal.ads.zzcgy
    public final synchronized String zzO() {
        return this.zzt;
    }

    @Override // com.google.android.gms.internal.ads.zzcgy
    public final /* synthetic */ zzciw zzP() {
        return this.zzo;
    }

    @Override // com.google.android.gms.internal.ads.zzcgy
    public final WebViewClient zzQ() {
        return this.zzo;
    }

    @Override // com.google.android.gms.internal.ads.zzcgy
    public final synchronized boolean zzR() {
        return this.zzu;
    }

    @Override // com.google.android.gms.internal.ads.zzcgy, com.google.android.gms.internal.ads.zzcir
    public final zzaxa zzS() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.ads.zzcgy
    public final zzfgr zzT() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.ads.zzcgy
    public final synchronized zzehf zzU() {
        return this.zzq;
    }

    @Override // com.google.android.gms.internal.ads.zzcgy
    public final synchronized zzehd zzV() {
        return this.zzr;
    }

    @Override // com.google.android.gms.internal.ads.zzcgy
    public final synchronized boolean zzW() {
        return this.zzw;
    }

    @Override // com.google.android.gms.internal.ads.zzcgy
    public final synchronized boolean zzX() {
        return this.zzv;
    }

    @Override // com.google.android.gms.internal.ads.zzcgy
    public final synchronized void zzY() {
        com.google.android.gms.ads.internal.util.zze.zza("Destroying WebView!");
        zzbf();
        com.google.android.gms.ads.internal.util.zzs.zza.post(new zzchw(this));
    }

    @Override // com.google.android.gms.internal.ads.zzcgy
    public final synchronized boolean zzZ() {
        return this.zzz;
    }

    @Override // com.google.android.gms.internal.ads.zzbpf
    public final void zza(String str) {
        zzaP(str);
    }

    @Override // com.google.android.gms.internal.ads.zzcgy
    public final boolean zzaA(final boolean z2, final int i2) {
        destroy();
        zzbds zzbdsVar = new zzbds() { // from class: com.google.android.gms.internal.ads.zzchz
            @Override // com.google.android.gms.internal.ads.zzbds
            public final /* synthetic */ void zza(zzbdz.zzt.zza zzaVar) {
                int i8 = zzcib.zza;
                zzbdz.zzbl.zza zzaVarZzq = zzbdz.zzbl.zzq();
                boolean zZzb = zzaVarZzq.zzb();
                boolean z7 = z2;
                if (zZzb != z7) {
                    zzaVarZzq.zzc(z7);
                }
                zzaVarZzq.zzg(i2);
                zzaVar.zzal(zzaVarZzq.zzbu());
            }
        };
        zzbdt zzbdtVar = this.zzY;
        zzbdtVar.zzb(zzbdsVar);
        zzbdtVar.zzc(10003);
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzcgy
    public final boolean zzaB() {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzcgy, com.google.android.gms.internal.ads.zzcif
    public final zzffx zzaC() {
        return this.zzl;
    }

    @Override // com.google.android.gms.internal.ads.zzcgy
    public final void zzaD(zzffu zzffuVar, zzffx zzffxVar) {
        this.zzk = zzffuVar;
        this.zzl = zzffxVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcgy
    public final synchronized void zzaE(boolean z2) {
        if (z2) {
            try {
                setBackgroundColor(0);
            } catch (Throwable th) {
                throw th;
            }
        }
        com.google.android.gms.ads.internal.overlay.zzm zzmVar = this.zzp;
        if (zzmVar != null) {
            zzmVar.zzu(z2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcgy
    public final j2.q zzaF() {
        zzbgb zzbgbVar = this.zze;
        return zzbgbVar == null ? zzgui.zza(null) : zzbgbVar.zzb();
    }

    @Override // com.google.android.gms.internal.ads.zzcgy
    public final void zzaG(boolean z2) {
        this.zzZ = true;
    }

    @Override // com.google.android.gms.internal.ads.zzcio
    public final void zzaH(com.google.android.gms.ads.internal.overlay.zzc zzcVar, boolean z2, boolean z7, String str) {
        this.zzo.zzv(zzcVar, z2, z7, str);
    }

    @Override // com.google.android.gms.internal.ads.zzcio
    public final void zzaI(boolean z2, int i2, boolean z7) {
        this.zzo.zzx(z2, i2, z7);
    }

    @Override // com.google.android.gms.internal.ads.zzcio
    public final void zzaJ(boolean z2, int i2, String str, boolean z7, boolean z8) {
        this.zzo.zzy(z2, i2, str, z7, z8);
    }

    @Override // com.google.android.gms.internal.ads.zzcio
    public final void zzaK(boolean z2, int i2, String str, String str2, boolean z7) {
        this.zzo.zzz(z2, i2, str, str2, z7);
    }

    @Override // com.google.android.gms.internal.ads.zzcio
    public final void zzaL(String str, String str2, int i2) {
        this.zzo.zzw(str, str2, 14);
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0083, code lost:
    
        if (r10.zzV != r9) goto L27;
     */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00a5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean zzaM() {
        /*
            r10 = this;
            com.google.android.gms.internal.ads.zzchj r0 = r10.zzo
            boolean r0 = r0.zzk()
            r1 = 0
            if (r0 != 0) goto L11
            com.google.android.gms.internal.ads.zzchj r0 = r10.zzo
            boolean r0 = r0.zzl()
            if (r0 == 0) goto L86
        L11:
            com.google.android.gms.ads.internal.client.zzbb.zza()
            android.util.DisplayMetrics r0 = r10.zzi
            int r2 = r0.widthPixels
            int r4 = com.google.android.gms.ads.internal.util.client.zzf.zzA(r0, r2)
            com.google.android.gms.ads.internal.client.zzbb.zza()
            int r2 = r0.heightPixels
            int r5 = com.google.android.gms.ads.internal.util.client.zzf.zzA(r0, r2)
            com.google.android.gms.internal.ads.zzcja r2 = r10.zzb
            android.app.Activity r2 = r2.zzb()
            r3 = 1
            if (r2 == 0) goto L50
            android.view.Window r6 = r2.getWindow()
            if (r6 != 0) goto L35
            goto L50
        L35:
            com.google.android.gms.ads.internal.zzt.zzc()
            int[] r2 = com.google.android.gms.ads.internal.util.zzs.zzW(r2)
            com.google.android.gms.ads.internal.client.zzbb.zza()
            r6 = r2[r1]
            int r6 = com.google.android.gms.ads.internal.util.client.zzf.zzA(r0, r6)
            com.google.android.gms.ads.internal.client.zzbb.zza()
            r2 = r2[r3]
            int r2 = com.google.android.gms.ads.internal.util.client.zzf.zzA(r0, r2)
            r7 = r2
            goto L52
        L50:
            r6 = r4
            r7 = r5
        L52:
            com.google.android.gms.ads.internal.zzt.zzc()
            android.view.WindowManager r2 = r10.zzX
            android.view.Display r2 = r2.getDefaultDisplay()
            int r9 = r2.getRotation()
            int r2 = r10.zzS
            if (r2 != r4) goto L87
            int r2 = r10.zzR
            if (r2 != r5) goto L87
            int r2 = r10.zzT
            if (r2 != r6) goto L87
            int r2 = r10.zzU
            if (r2 != r7) goto L87
            com.google.android.gms.internal.ads.zzbel r2 = com.google.android.gms.internal.ads.zzbeu.zzam
            com.google.android.gms.internal.ads.zzbes r8 = com.google.android.gms.ads.internal.client.zzbd.zzc()
            java.lang.Object r2 = r8.zzd(r2)
            java.lang.Boolean r2 = (java.lang.Boolean) r2
            boolean r2 = r2.booleanValue()
            if (r2 == 0) goto L86
            int r2 = r10.zzV
            if (r2 == r9) goto L86
            goto L87
        L86:
            return r1
        L87:
            int r2 = r10.zzS
            if (r2 != r4) goto La5
            int r2 = r10.zzR
            if (r2 != r5) goto La5
            com.google.android.gms.internal.ads.zzbel r2 = com.google.android.gms.internal.ads.zzbeu.zzam
            com.google.android.gms.internal.ads.zzbes r8 = com.google.android.gms.ads.internal.client.zzbd.zzc()
            java.lang.Object r2 = r8.zzd(r2)
            java.lang.Boolean r2 = (java.lang.Boolean) r2
            boolean r2 = r2.booleanValue()
            if (r2 == 0) goto La6
            int r2 = r10.zzV
            if (r2 == r9) goto La6
        La5:
            r1 = r3
        La6:
            r10.zzS = r4
            r10.zzR = r5
            r10.zzT = r6
            r10.zzU = r7
            r10.zzV = r9
            com.google.android.gms.internal.ads.zzbun r3 = new com.google.android.gms.internal.ads.zzbun
            java.lang.String r2 = ""
            r3.<init>(r10, r2)
            float r8 = r0.density
            r3.zzl(r4, r5, r6, r7, r8, r9)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcib.zzaM():boolean");
    }

    public final synchronized void zzaN(String str) {
        if (!zzX()) {
            loadUrl(str);
        } else {
            int i2 = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzi("#004 The webview is destroyed. Ignoring action.");
        }
    }

    public final synchronized void zzaO(String str, ValueCallback valueCallback) {
        if (!zzX()) {
            evaluateJavascript(str, null);
        } else {
            int i2 = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzi("#004 The webview is destroyed. Ignoring action.");
        }
    }

    public final void zzaP(String str) {
        if (zzaR() == null) {
            zzba();
        }
        if (zzaR().booleanValue()) {
            zzaO(str, null);
        } else {
            zzaN("javascript:".concat(str));
        }
    }

    @VisibleForTesting
    public final void zzaQ(Boolean bool) {
        synchronized (this) {
            this.zzy = bool;
        }
        com.google.android.gms.ads.internal.zzt.zzh().zzb(bool);
    }

    @VisibleForTesting
    public final synchronized Boolean zzaR() {
        return this.zzy;
    }

    public final zzchj zzaS() {
        return this.zzo;
    }

    public final /* synthetic */ void zzaU(String str, ValueCallback valueCallback) {
        super.evaluateJavascript(str, valueCallback);
    }

    public final /* synthetic */ void zzaV(String str) {
        super.loadUrl(str);
    }

    public final /* synthetic */ void zzaW(String str) {
        super.loadUrl(AndroidWebViewClient.BLANK_PAGE);
    }

    public final /* synthetic */ int zzaX() {
        return this.zzI;
    }

    public final /* synthetic */ void zzaY(int i2) {
        this.zzI = i2;
    }

    @Override // com.google.android.gms.internal.ads.zzcgy
    public final synchronized boolean zzaa() {
        return this.zzH > 0;
    }

    @Override // com.google.android.gms.internal.ads.zzcgy
    public final void zzab(String str, zzblx zzblxVar) {
        zzchj zzchjVar = this.zzo;
        if (zzchjVar != null) {
            zzchjVar.zzB(str, zzblxVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcgy
    public final void zzac(String str, zzblx zzblxVar) {
        zzchj zzchjVar = this.zzo;
        if (zzchjVar != null) {
            zzchjVar.zzC(str, zzblxVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcgy
    public final void zzad(String str, Predicate predicate) {
        zzchj zzchjVar = this.zzo;
        if (zzchjVar != null) {
            zzchjVar.zzE(str, predicate);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcgy
    public final synchronized void zzae(com.google.android.gms.ads.internal.overlay.zzm zzmVar) {
        this.zzp = zzmVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcgy
    public final synchronized void zzaf(zzcji zzcjiVar) {
        this.zzs = zzcjiVar;
        requestLayout();
    }

    @Override // com.google.android.gms.internal.ads.zzcgy
    public final synchronized void zzag(boolean z2) {
        try {
            boolean z7 = this.zzw;
            this.zzw = z2;
            zzbc();
            if (z2 != z7) {
                if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzak)).booleanValue()) {
                    if (!this.zzs.zzg()) {
                    }
                }
                new zzbun(this, "").zzk(true != z2 ? "default" : "expanded");
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcgy
    public final void zzah() {
        this.zzQ.zzb();
    }

    @Override // com.google.android.gms.internal.ads.zzcgy
    public final void zzai(Context context) {
        zzcja zzcjaVar = this.zzb;
        zzcjaVar.setBaseContext(context);
        this.zzQ.zza(zzcjaVar.zzb());
    }

    @Override // com.google.android.gms.internal.ads.zzcgy
    public final synchronized void zzaj(boolean z2) {
        com.google.android.gms.ads.internal.overlay.zzm zzmVar = this.zzp;
        if (zzmVar != null) {
            zzmVar.zzt(this.zzo.zzk(), z2);
        } else {
            this.zzu = z2;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcgy
    public final synchronized void zzak(zzehf zzehfVar) {
        this.zzq = zzehfVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcgy
    public final synchronized void zzal(zzehd zzehdVar) {
        this.zzr = zzehdVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcgy
    public final synchronized void zzam(int i2) {
        com.google.android.gms.ads.internal.overlay.zzm zzmVar = this.zzp;
        if (zzmVar != null) {
            zzmVar.zzw(i2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcgy
    public final synchronized void zzan(com.google.android.gms.ads.internal.overlay.zzm zzmVar) {
        this.zzO = zzmVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcgy
    public final synchronized void zzao(boolean z2) {
        this.zzz = z2;
    }

    @Override // com.google.android.gms.internal.ads.zzcgy
    public final void zzap() {
        if (this.zzL == null) {
            zzbfh zzbfhVar = this.zzM;
            zzbfhVar.zzc();
            zzbfg zzbfgVarZzf = zzbfj.zzf();
            this.zzL = zzbfgVarZzf;
            zzbfhVar.zza("native:view_load", zzbfgVarZzf);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcgy
    public final synchronized void zzaq(zzbhv zzbhvVar) {
        this.zzE = zzbhvVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcgy
    public final synchronized zzbhv zzar() {
        return this.zzE;
    }

    @Override // com.google.android.gms.internal.ads.zzcgy
    public final synchronized void zzas(boolean z2) {
        com.google.android.gms.ads.internal.overlay.zzm zzmVar;
        int i2 = this.zzH + (true != z2 ? -1 : 1);
        this.zzH = i2;
        if (i2 > 0 || (zzmVar = this.zzp) == null) {
            return;
        }
        zzmVar.zzF();
    }

    @Override // com.google.android.gms.internal.ads.zzcgy
    public final void zzat() {
        setBackgroundColor(0);
    }

    @Override // com.google.android.gms.internal.ads.zzcgy
    public final synchronized void zzau(String str, String str2, String str3) throws Throwable {
        Throwable th;
        String str4;
        try {
            try {
                if (zzX()) {
                    int i2 = com.google.android.gms.ads.internal.util.zze.zza;
                    com.google.android.gms.ads.internal.util.client.zzo.zzi("#004 The webview is destroyed. Ignoring action.");
                    return;
                }
                String str5 = (String) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzaj);
                JSONObject jSONObject = new JSONObject();
                try {
                    try {
                        jSONObject.put("version", str5);
                        jSONObject.put("sdk", "Google Mobile Ads");
                        jSONObject.put("sdkVersion", "12.4.51-000");
                        str4 = "<script>Object.defineProperty(window,'MRAID_ENV',{get:function(){return " + jSONObject.toString() + "}});</script>";
                    } catch (JSONException e) {
                        int i8 = com.google.android.gms.ads.internal.util.zze.zza;
                        com.google.android.gms.ads.internal.util.client.zzo.zzj("Unable to build MRAID_ENV", e);
                        str4 = null;
                    }
                    super.loadDataWithBaseURL(str, zzcip.zza(str2, str4), "text/html", Key.STRING_CHARSET_NAME, null);
                    return;
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable th3) {
                th = th3;
                th = th;
            }
        } catch (Throwable th4) {
            th = th4;
            th = th;
            throw th;
        }
        throw th;
    }

    @Override // com.google.android.gms.internal.ads.zzcgy
    public final void zzav() {
        com.google.android.gms.ads.internal.util.zze.zza("Cannot add text view to inner AdWebView");
    }

    @Override // com.google.android.gms.internal.ads.zzcgy
    public final void zzaw(boolean z2) {
        this.zzo.zzM(z2);
    }

    @Override // com.google.android.gms.internal.ads.zzcgy
    public final synchronized void zzax(zzbhs zzbhsVar) {
        this.zzF = zzbhsVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcgy
    public final synchronized void zzay(zzbch zzbchVar) {
        this.zzG = zzbchVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcgy
    public final synchronized zzbch zzaz() {
        return this.zzG;
    }

    @Override // com.google.android.gms.internal.ads.zzbpf
    public final void zzb(String str, JSONObject jSONObject) {
        zzc(str, jSONObject.toString());
    }

    @Override // com.google.android.gms.internal.ads.zzbpf
    public final void zzc(String str, String str2) {
        zzaP(androidx.camera.core.processing.util.a.n(new StringBuilder(androidx.camera.core.processing.util.a.D(1, String.valueOf(str2).length(), str) + 2), str, "(", str2, ");"));
    }

    @Override // com.google.android.gms.internal.ads.zzbot
    public final void zzd(String str, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        StringBuilder sbZ = a1.a.z("(window.AFMA_ReceiveMessage || function() {})('", str, "',", jSONObject.toString(), ");");
        String string = sbZ.toString();
        int i2 = com.google.android.gms.ads.internal.util.zze.zza;
        com.google.android.gms.ads.internal.util.client.zzo.zzd("Dispatching AFMA event: ".concat(string));
        zzaP(sbZ.toString());
    }

    @Override // com.google.android.gms.internal.ads.zzdgv
    public final void zzdV() {
        zzchj zzchjVar = this.zzo;
        if (zzchjVar != null) {
            zzchjVar.zzdV();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbau
    public final void zzdo(zzbat zzbatVar) {
        boolean z2;
        synchronized (this) {
            z2 = zzbatVar.zzj;
            this.zzC = z2;
        }
        zzbi(z2);
    }

    @Override // com.google.android.gms.ads.internal.zzn
    public final synchronized void zzdp() {
        com.google.android.gms.ads.internal.zzn zznVar = this.zzg;
        if (zznVar != null) {
            zznVar.zzdp();
        }
    }

    @Override // com.google.android.gms.ads.internal.zzn
    public final synchronized void zzdq() {
        com.google.android.gms.ads.internal.zzn zznVar = this.zzg;
        if (zznVar != null) {
            zznVar.zzdq();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcdr
    public final zzcdg zzdr() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzcdr
    public final void zzds(boolean z2) {
        this.zzo.zzK(false);
    }

    @Override // com.google.android.gms.internal.ads.zzdgv
    public final void zzdz() {
        zzchj zzchjVar = this.zzo;
        if (zzchjVar != null) {
            zzchjVar.zzdz();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbot
    public final void zze(String str, Map map) {
        try {
            zzd(str, com.google.android.gms.ads.internal.client.zzbb.zza().zzk(map));
        } catch (JSONException unused) {
            int i2 = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzi("Could not convert parameters to JSON.");
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcgy, com.google.android.gms.internal.ads.zzcdr
    public final synchronized zzcie zzh() {
        return this.zzB;
    }

    @Override // com.google.android.gms.internal.ads.zzcdr
    public final zzbfg zzi() {
        return this.zzK;
    }

    @Override // com.google.android.gms.internal.ads.zzcgy, com.google.android.gms.internal.ads.zzcik, com.google.android.gms.internal.ads.zzcdr
    public final Activity zzj() {
        return this.zzb.zzb();
    }

    @Override // com.google.android.gms.internal.ads.zzcgy, com.google.android.gms.internal.ads.zzcdr
    public final com.google.android.gms.ads.internal.zza zzk() {
        return this.zzh;
    }

    @Override // com.google.android.gms.internal.ads.zzcdr
    public final void zzl() {
        com.google.android.gms.ads.internal.overlay.zzm zzmVarZzL = zzL();
        if (zzmVarZzL != null) {
            zzmVarZzL.zzE();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcdr
    public final synchronized String zzm() {
        return this.zzA;
    }

    @Override // com.google.android.gms.internal.ads.zzcdr
    public final synchronized String zzn() {
        zzffx zzffxVar = this.zzl;
        if (zzffxVar == null) {
            return null;
        }
        return zzffxVar.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzcdr
    public final synchronized void zzo(int i2) {
        this.zzN = i2;
    }

    @Override // com.google.android.gms.internal.ads.zzcdr
    public final synchronized int zzp() {
        return this.zzN;
    }

    @Override // com.google.android.gms.internal.ads.zzcgy, com.google.android.gms.internal.ads.zzcdr
    public final zzbfh zzq() {
        return this.zzM;
    }

    @Override // com.google.android.gms.internal.ads.zzcdr
    public final synchronized zzcfe zzr(String str) {
        Map map = this.zzW;
        if (map == null) {
            return null;
        }
        return (zzcfe) map.get(str);
    }

    @Override // com.google.android.gms.internal.ads.zzcgy, com.google.android.gms.internal.ads.zzcis, com.google.android.gms.internal.ads.zzcdr
    public final VersionInfoParcel zzs() {
        return this.zzf;
    }

    @Override // com.google.android.gms.internal.ads.zzcgy, com.google.android.gms.internal.ads.zzcdr
    public final synchronized void zzt(String str, zzcfe zzcfeVar) {
        try {
            if (this.zzW == null) {
                this.zzW = new HashMap();
            }
            this.zzW.put(str, zzcfeVar);
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcdr
    public final void zzu(boolean z2, long j) {
        HashMap map = new HashMap(2);
        map.put("success", true != z2 ? "0" : "1");
        map.put("duration", Long.toString(j));
        zze("onCacheAccessComplete", map);
    }

    @Override // com.google.android.gms.internal.ads.zzcgy, com.google.android.gms.internal.ads.zzcdr
    public final synchronized void zzw(zzcie zzcieVar) {
        if (this.zzB == null) {
            this.zzB = zzcieVar;
        } else {
            int i2 = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzf("Attempt to create multiple AdWebViewVideoControllers.");
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcdr
    public final int zzx() {
        return getMeasuredHeight();
    }

    @Override // com.google.android.gms.internal.ads.zzcdr
    public final int zzy() {
        return getMeasuredWidth();
    }

    @Override // com.google.android.gms.internal.ads.zzcdr
    public final synchronized void zzz() {
        zzbhs zzbhsVar = this.zzF;
        if (zzbhsVar != null) {
            zzbhsVar.zza();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcgy
    public final WebView zzD() {
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzcgy, com.google.android.gms.internal.ads.zzcit
    public final View zzE() {
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzcdr
    public final void zzA(int i2) {
    }

    @Override // com.google.android.gms.internal.ads.zzcdr
    public final void zzB(int i2) {
    }

    @Override // com.google.android.gms.internal.ads.zzcdr
    public final void zzv(int i2) {
    }
}
