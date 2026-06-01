package com.ironsource.sdk.controller;

import android.R;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import com.ironsource.C2300e4;
import com.ironsource.C2306ea;
import com.ironsource.C2366hg;
import com.ironsource.C2531r4;
import com.ironsource.InterfaceC2349h;
import com.ironsource.Je;
import com.ironsource.Q9;
import com.ironsource.R3;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.sdk.utils.Logger;
import com.ironsource.sdk.utils.SDKUtils;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class OpenUrlActivity extends Activity {
    private static final String j = "OpenUrlActivity";
    private static final int k = SDKUtils.generateViewId();
    private static final int l = SDKUtils.generateViewId();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private v f9855b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ProgressBar f9856c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    boolean f9857d;
    private RelativeLayout e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f9858f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private WebView f9854a = null;
    private final Handler g = new Handler(Looper.getMainLooper());
    private boolean h = false;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Runnable f9859i = new b();

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class a implements View.OnSystemUiVisibilityChangeListener {
        public a() {
        }

        @Override // android.view.View.OnSystemUiVisibilityChangeListener
        public void onSystemUiVisibilityChange(int i2) {
            if ((i2 & InputDeviceCompat.SOURCE_TOUCHSCREEN) == 0) {
                OpenUrlActivity openUrlActivity = OpenUrlActivity.this;
                openUrlActivity.g.removeCallbacks(openUrlActivity.f9859i);
                OpenUrlActivity openUrlActivity2 = OpenUrlActivity.this;
                openUrlActivity2.g.postDelayed(openUrlActivity2.f9859i, 500L);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            OpenUrlActivity.this.getWindow().getDecorView().setSystemUiVisibility(SDKUtils.getActivityUIFlags(OpenUrlActivity.this.h));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class c extends WebViewClient {
        public /* synthetic */ c(OpenUrlActivity openUrlActivity, int i2) {
            this();
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            OpenUrlActivity.this.f9856c.setVisibility(4);
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
            OpenUrlActivity.this.f9856c.setVisibility(0);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i2, String str, String str2) {
            v vVar;
            super.onReceivedError(webView, i2, str, str2);
            try {
                R3 featureFlagCatchUrlError = FeaturesManager.getInstance().getFeatureFlagCatchUrlError();
                if (featureFlagCatchUrlError.b()) {
                    if (featureFlagCatchUrlError.e() && (vVar = OpenUrlActivity.this.f9855b) != null) {
                        vVar.d(str, str2);
                    }
                    if (featureFlagCatchUrlError.d()) {
                        OpenUrlActivity.this.finish();
                    }
                }
            } catch (Throwable th) {
                C2531r4.d().a(th);
            }
        }

        @Override // android.webkit.WebViewClient
        public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
            Logger.e(OpenUrlActivity.j, "Chromium process crashed - detail.didCrash():" + renderProcessGoneDetail.didCrash());
            OpenUrlActivity.this.finish();
            return true;
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            if (!new Je(str, C2306ea.e().d(), FeaturesManager.getInstance().getFeatureFlagClickCheck().b()).a()) {
                return super.shouldOverrideUrlLoading(webView, str);
            }
            try {
                C2366hg.a(OpenUrlActivity.this, str);
                OpenUrlActivity.this.f9855b.y();
            } catch (Exception e) {
                C2531r4.d().a(e);
                StringBuilder sb = new StringBuilder();
                if (e instanceof ActivityNotFoundException) {
                    sb.append(C2300e4.c.f8323x);
                } else {
                    sb.append(C2300e4.c.y);
                }
                v vVar = OpenUrlActivity.this.f9855b;
                if (vVar != null) {
                    vVar.d(sb.toString(), str);
                }
            }
            OpenUrlActivity.this.finish();
            return true;
        }

        private c() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final String f9863a = "is_store";

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        static final String f9864b = "external_url";

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        static final String f9865c = "secondary_web_view";

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        static final String f9866d = "immersive";
        static final String e = "no activity to handle url";

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        static final String f9867f = "activity failed to open with unspecified reason";

        private d() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final InterfaceC2349h f9868a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f9869b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private String f9870c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f9871d = false;
        private boolean e = false;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private boolean f9872f = false;

        public e(InterfaceC2349h interfaceC2349h) {
            this.f9868a = interfaceC2349h;
        }

        public e a(int i2) {
            this.f9869b = i2;
            return this;
        }

        public e b(boolean z2) {
            this.f9871d = z2;
            return this;
        }

        public e c(boolean z2) {
            this.e = z2;
            return this;
        }

        public e a(String str) {
            this.f9870c = str;
            return this;
        }

        public e a(boolean z2) {
            this.f9872f = z2;
            return this;
        }

        public Intent a(Context context) {
            Intent intentA = this.f9868a.a(context);
            intentA.putExtra("external_url", this.f9870c);
            intentA.putExtra("secondary_web_view", this.f9871d);
            intentA.putExtra("is_store", this.e);
            intentA.putExtra(C2300e4.h.f8388v, this.f9872f);
            if (!(context instanceof Activity)) {
                intentA.setFlags(this.f9869b);
            }
            return intentA;
        }
    }

    private void f() {
        getWindow().setFlags(1024, 1024);
    }

    private void g() {
        ViewGroup viewGroup;
        v vVar = this.f9855b;
        if (vVar != null) {
            vVar.a(false, C2300e4.h.Y);
            if (this.e == null || (viewGroup = (ViewGroup) this.f9854a.getParent()) == null) {
                return;
            }
            if (viewGroup.findViewById(k) != null) {
                viewGroup.removeView(this.f9854a);
            }
            if (viewGroup.findViewById(l) != null) {
                viewGroup.removeView(this.f9856c);
            }
        }
    }

    @Override // android.app.Activity
    public void finish() {
        v vVar;
        if (this.f9857d && (vVar = this.f9855b) != null) {
            vVar.c(C2300e4.h.j);
        }
        super.finish();
    }

    public void loadUrl(String str) {
        this.f9854a.stopLoading();
        this.f9854a.clearHistory();
        try {
            this.f9854a.loadUrl(str);
        } catch (Throwable th) {
            C2531r4.d().a(th);
            Logger.e(j, "OpenUrlActivity:: loadUrl: " + th.toString());
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.f9854a.canGoBack()) {
            this.f9854a.goBack();
        } else {
            super.onBackPressed();
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Logger.i(j, "onCreate()");
        try {
            this.f9855b = (v) Q9.b((Context) this).a().k();
            e();
            f();
            Bundle extras = getIntent().getExtras();
            this.f9858f = extras.getString("external_url");
            this.f9857d = extras.getBoolean("secondary_web_view");
            boolean booleanExtra = getIntent().getBooleanExtra(C2300e4.h.f8388v, false);
            this.h = booleanExtra;
            if (booleanExtra) {
                getWindow().getDecorView().setOnSystemUiVisibilityChangeListener(new a());
                runOnUiThread(this.f9859i);
            }
            RelativeLayout relativeLayout = new RelativeLayout(this);
            this.e = relativeLayout;
            setContentView(relativeLayout, new ViewGroup.LayoutParams(-1, -1));
        } catch (Exception e4) {
            C2531r4.d().a(e4);
            IronLog.INTERNAL.error(e4.toString());
            finish();
        }
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        c();
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (this.h && (i2 == 25 || i2 == 24)) {
            this.g.postDelayed(this.f9859i, 500L);
        }
        return super.onKeyDown(i2, keyEvent);
    }

    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        g();
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        b();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z2) {
        super.onWindowFocusChanged(z2);
        if (this.h && z2) {
            runOnUiThread(this.f9859i);
        }
    }

    private void a() {
        if (this.f9856c == null) {
            ProgressBar progressBar = new ProgressBar(new ContextThemeWrapper(this, R.style.Theme.Holo.Light.Dialog));
            this.f9856c = progressBar;
            progressBar.setId(l);
        }
        if (findViewById(l) == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(13);
            this.f9856c.setLayoutParams(layoutParams);
            this.f9856c.setVisibility(4);
            this.e.addView(this.f9856c);
        }
    }

    private void b() {
        if (this.f9854a == null) {
            WebView webView = new WebView(getApplicationContext());
            this.f9854a = webView;
            webView.setId(k);
            this.f9854a.getSettings().setJavaScriptEnabled(true);
            this.f9854a.setWebViewClient(new c(this, 0));
            loadUrl(this.f9858f);
        }
        if (findViewById(k) == null) {
            this.e.addView(this.f9854a, new RelativeLayout.LayoutParams(-1, -1));
        }
        a();
        v vVar = this.f9855b;
        if (vVar != null) {
            vVar.a(true, C2300e4.h.Y);
        }
    }

    private void c() {
        WebView webView = this.f9854a;
        if (webView != null) {
            webView.destroy();
        }
    }

    private void d() {
        getWindow().addFlags(16);
    }

    private void e() {
        requestWindowFeature(1);
    }
}
