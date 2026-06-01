package sg.bigo.ads.core.landing;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.URLUtil;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.IntRange;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.ironsource.adqualitysdk.sdk.i.a0;
import java.util.concurrent.atomic.AtomicBoolean;
import sg.bigo.ads.R;
import sg.bigo.ads.api.core.BaseAdActivityImpl;
import sg.bigo.ads.api.core.e;
import sg.bigo.ads.common.e.a;
import sg.bigo.ads.common.utils.q;
import sg.bigo.ads.common.utils.u;
import sg.bigo.ads.core.h.c;
import sg.bigo.ads.core.h.d;
import sg.bigo.ads.core.h.e;

/* JADX INFO: loaded from: classes6.dex */
public class WebViewActivityImpl extends BaseAdActivityImpl implements View.OnClickListener {

    @Nullable
    protected ImageView A;

    @Nullable
    protected WebView B;
    protected String C;
    protected long D;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f17118a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f17119b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private AtomicBoolean f17120c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    private FileChooser f17121d;
    private a.AbstractC0283a e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final b f17122f;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    @Nullable
    protected TextView f17123x;

    @Nullable
    protected ProgressBar y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    @Nullable
    public ImageView f17124z;

    public class CustomWebChromeClient extends c {
        private CustomWebChromeClient() {
        }

        @Override // android.webkit.WebChromeClient
        public void onProgressChanged(WebView webView, int i2) {
            super.onProgressChanged(webView, i2);
            WebViewActivityImpl webViewActivityImpl = WebViewActivityImpl.this;
            if (webViewActivityImpl.y != null && !webViewActivityImpl.c()) {
                WebViewActivityImpl.this.y.setProgress(i2);
            }
            WebViewActivityImpl.this.a(i2);
        }

        @Override // android.webkit.WebChromeClient
        public void onReceivedTitle(WebView webView, String str) {
            super.onReceivedTitle(webView, str);
            WebViewActivityImpl.this.b(str);
        }

        @Override // android.webkit.WebChromeClient
        public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
            if (WebViewActivityImpl.this.f17121d == null) {
                WebViewActivityImpl webViewActivityImpl = WebViewActivityImpl.this;
                webViewActivityImpl.f17121d = new FileChooser(webViewActivityImpl.I);
            }
            FileChooser fileChooser = WebViewActivityImpl.this.f17121d;
            sg.bigo.ads.common.t.a.a(0, 3, "FileChooser", "onShowFileChooser");
            ValueCallback<Uri[]> valueCallback2 = fileChooser.f17117c;
            if (valueCallback2 != null) {
                valueCallback2.onReceiveValue(null);
            }
            fileChooser.f17117c = valueCallback;
            fileChooser.a(fileChooserParams.getAcceptTypes());
            return true;
        }

        @Keep
        public void openFileChooser(ValueCallback<Uri> valueCallback, String str, String str2) {
            if (WebViewActivityImpl.this.f17121d == null) {
                WebViewActivityImpl webViewActivityImpl = WebViewActivityImpl.this;
                webViewActivityImpl.f17121d = new FileChooser(webViewActivityImpl.I);
            }
            WebViewActivityImpl.this.f17121d.openFileChooser(valueCallback, str, str2);
        }

        public /* synthetic */ CustomWebChromeClient(WebViewActivityImpl webViewActivityImpl, byte b8) {
            this();
        }
    }

    public class a extends d {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f17128b;

        private a() {
        }

        @Override // sg.bigo.ads.core.h.d
        public final void a(RenderProcessGoneDetail renderProcessGoneDetail) {
            sg.bigo.ads.core.d.b.a(3002, 10105, "The render process was gone.");
            WebViewActivityImpl.this.b(0);
        }

        @Override // sg.bigo.ads.core.h.d, android.webkit.WebViewClient
        public final void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            ProgressBar progressBar = WebViewActivityImpl.this.y;
            if (progressBar != null) {
                progressBar.setAlpha(0.0f);
            }
            a0.i(0, str, "onPageFinished  ", 3, "WebView");
            WebViewActivityImpl.this.a(str);
        }

        @Override // android.webkit.WebViewClient
        public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
            boolean z2 = false;
            a0.i(0, str, "onPageStarted ", 3, "WebView");
            ProgressBar progressBar = WebViewActivityImpl.this.y;
            if (progressBar != null) {
                progressBar.animate().alpha(1.0f).setDuration(100L).setListener(null);
                WebViewActivityImpl.this.y.setProgress(0);
            }
            WebViewActivityImpl webViewActivityImpl = WebViewActivityImpl.this;
            if (webViewActivityImpl.D < 0) {
                webViewActivityImpl.D = SystemClock.elapsedRealtime();
                z2 = true;
            }
            WebViewActivityImpl.this.a(str, z2);
        }

        @Override // android.webkit.WebViewClient
        public final void onReceivedError(WebView webView, int i2, String str, String str2) {
            super.onReceivedError(webView, i2, str, str2);
            sg.bigo.ads.common.t.a.b("WebView", "onReceivedError: " + i2 + " " + str);
            WebViewActivityImpl.this.a(i2, str, str2);
        }

        @Override // sg.bigo.ads.core.h.d, android.webkit.WebViewClient
        public final void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
            super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
            if (webResourceRequest.isForMainFrame()) {
                onReceivedError(webView, webResourceResponse.getStatusCode(), webResourceResponse.getReasonPhrase(), webResourceRequest.getUrl().toString());
            }
        }

        @Override // android.webkit.WebViewClient
        public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
            this.f17128b++;
            WebViewActivityImpl webViewActivityImpl = WebViewActivityImpl.this;
            return a(webView, str, !(webViewActivityImpl.D >= 0 && webViewActivityImpl.f17119b));
        }

        public /* synthetic */ a(WebViewActivityImpl webViewActivityImpl, byte b8) {
            this();
        }

        private void a(WebView webView, String str) {
            onPageFinished(webView, str);
            WebViewActivityImpl.this.b(0);
        }

        @Override // sg.bigo.ads.core.h.d, android.webkit.WebViewClient
        public final void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
            super.onReceivedError(webView, webResourceRequest, webResourceError);
            if (webResourceRequest.isForMainFrame()) {
                onReceivedError(webView, webResourceError.getErrorCode(), webResourceError.getDescription().toString(), webResourceRequest.getUrl().toString());
            }
        }

        private boolean a(WebView webView, String str, boolean z2) {
            boolean zA;
            if (WebViewActivityImpl.this.f17118a) {
                return true;
            }
            sg.bigo.ads.common.t.a.a(0, 3, "WebView", "shouldOverrideUrlLoading url= " + str + ", isRedirectOnStart=" + z2);
            if (z2 && this.f17128b > 1) {
                WebViewActivityImpl.this.c(str);
            }
            if (sg.bigo.ads.core.landing.a.a(str)) {
                boolean zA2 = a(str);
                if (zA2 && z2) {
                    a(webView, str);
                }
                return zA2;
            }
            if (str.startsWith("intent://")) {
                try {
                    Intent uri = Intent.parseUri(str, 1);
                    Uri data = uri.getData();
                    if (data != null && WebViewActivityImpl.this.a(data)) {
                        if (z2) {
                            a(webView, str);
                        }
                        return true;
                    }
                    uri.addCategory("android.intent.category.BROWSABLE");
                    uri.setComponent(null);
                    uri.setSelector(null);
                    if (WebViewActivityImpl.this.I.startActivityIfNeeded(uri, -1)) {
                        if (z2) {
                            a(webView, str);
                        }
                        return true;
                    }
                    sg.bigo.ads.common.t.a.b("WebView", "queryIntentActivities: null");
                    String stringExtra = uri.getStringExtra("browser_fallback_url");
                    if (!TextUtils.isEmpty(stringExtra)) {
                        if (sg.bigo.ads.core.landing.a.a(stringExtra)) {
                            zA = a(stringExtra);
                            if (zA && z2) {
                                a(webView, stringExtra);
                            }
                        } else {
                            zA = false;
                        }
                        if (!zA) {
                            webView.loadUrl(stringExtra);
                        }
                        return true;
                    }
                } catch (Exception e) {
                    sg.bigo.ads.common.t.a.a(0, "WebView", "shouldOverrideUrlLoading: " + e.getMessage());
                }
            } else if (!URLUtil.isValidUrl(str)) {
                if (WebViewActivityImpl.this.e(str) && z2) {
                    a(webView, str);
                }
                return true;
            }
            String strD = WebViewActivityImpl.this.d(str);
            if (str.equals(strD)) {
                return super.shouldOverrideUrlLoading(webView, str);
            }
            webView.loadUrl(strD);
            return true;
        }

        private boolean a(String str) {
            e eVar = new e();
            boolean zA = sg.bigo.ads.core.landing.a.a(Uri.parse(str), WebViewActivityImpl.this.I, eVar);
            WebViewActivityImpl.this.a(eVar);
            return zA;
        }
    }

    public class b implements View.OnTouchListener, e.a {
        private b() {
        }

        @Override // sg.bigo.ads.core.h.e.a
        public final void a(MotionEvent motionEvent) {
            onTouch(WebViewActivityImpl.this.B, motionEvent);
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 1) {
                WebViewActivityImpl.a(WebViewActivityImpl.this);
            }
            return WebViewActivityImpl.this.a(motionEvent);
        }

        public /* synthetic */ b(WebViewActivityImpl webViewActivityImpl, byte b8) {
            this();
        }
    }

    public WebViewActivityImpl(@NonNull Activity activity) {
        super(activity);
        this.D = -1L;
        this.f17118a = false;
        this.f17119b = false;
        this.f17120c = new AtomicBoolean(true);
        this.e = new a.AbstractC0283a() { // from class: sg.bigo.ads.core.landing.WebViewActivityImpl.1
            @Override // sg.bigo.ads.common.e.a.AbstractC0283a
            public final void a(boolean z2) {
                if (z2) {
                    WebViewActivityImpl.this.U();
                } else {
                    WebViewActivityImpl.this.V();
                }
            }
        };
        this.f17122f = new b(this, (byte) 0);
        Intent intent = this.I.getIntent();
        this.C = intent != null ? intent.getStringExtra("url") : "";
    }

    private void c(int i2) {
        if (this.B == null || !v()) {
            d(i2);
        } else {
            this.B.goBack();
        }
    }

    @Override // sg.bigo.ads.api.core.BaseAdActivityImpl
    @CallSuper
    public void D() {
        WebView webView = this.B;
        if (webView != null) {
            sg.bigo.ads.common.e.a.b(webView, this.e);
            WebView webView2 = this.B;
            if (webView2 instanceof sg.bigo.ads.core.h.e) {
                ((sg.bigo.ads.core.h.e) webView2).setOnWebViewTouchListener(null);
            } else {
                webView2.setOnTouchListener(null);
            }
            this.B.destroy();
            this.B = null;
        }
    }

    @Override // sg.bigo.ads.api.core.BaseAdActivityImpl
    @CallSuper
    public void N() {
        if (TextUtils.isEmpty(this.C)) {
            sg.bigo.ads.common.t.a.a(0, "WebView", "url is null.");
            b(0);
            return;
        }
        n(a());
        try {
            b();
        } catch (RuntimeException unused) {
        }
        s();
        if (q.a((CharSequence) this.C) || e(this.C)) {
            b(0);
        } else {
            t();
        }
    }

    @Override // sg.bigo.ads.api.core.BaseAdActivityImpl
    public final void U() {
        if (this.f17120c.compareAndSet(true, false)) {
            d();
        }
    }

    @Override // sg.bigo.ads.api.core.BaseAdActivityImpl
    public final void V() {
        if (this.f17120c.compareAndSet(false, true)) {
            e();
        }
    }

    @Override // sg.bigo.ads.api.core.BaseAdActivityImpl
    public final void W() {
        c(1);
    }

    public int a() {
        return R.layout.bigo_ad_activity_webview;
    }

    @Override // sg.bigo.ads.api.core.BaseAdActivityImpl
    @Deprecated
    public final void ap() {
        d(0);
    }

    public void b() {
        this.y = (ProgressBar) o(R.id.inter_webview_progress_bar);
        this.f17123x = (TextView) o(R.id.inter_webview_title);
        this.A = (ImageView) o(R.id.inter_webview_back);
        this.f17124z = (ImageView) o(R.id.inter_webview_close);
        ImageView imageView = this.A;
        if (imageView != null) {
            imageView.setOnClickListener(this);
        }
        ImageView imageView2 = this.f17124z;
        if (imageView2 != null) {
            imageView2.setOnClickListener(this);
        }
        WebView webViewR = r();
        this.B = webViewR;
        if (webViewR != null) {
            byte b8 = 0;
            webViewR.setWebViewClient(new a(this, b8));
            this.B.setWebChromeClient(new CustomWebChromeClient(this, b8));
            u.a(this.B, (ViewGroup) o(R.id.inter_webview_container), new ViewGroup.LayoutParams(-1, -1), -1);
            WebView webView = this.B;
            if (webView instanceof sg.bigo.ads.core.h.e) {
                ((sg.bigo.ads.core.h.e) webView).setOnWebViewTouchListener(this.f17122f);
            } else {
                webView.setOnTouchListener(this.f17122f);
            }
            sg.bigo.ads.common.e.a.a(this.B, this.e);
        }
    }

    @CallSuper
    public void e() {
        WebView webView = this.B;
        if (webView != null) {
            webView.onPause();
        }
    }

    public void onClick(View view) {
        Object tag = view.getTag();
        if (tag instanceof String) {
            if (tag.equals(sg.bigo.ads.common.utils.a.a(this.I, R.string.bigo_ad_tag_close, new Object[0]))) {
                d(3);
            } else if (tag.equals(sg.bigo.ads.common.utils.a.a(this.I, R.string.bigo_ad_tag_back, new Object[0]))) {
                c(2);
            }
        }
    }

    @Nullable
    public WebView r() {
        return sg.bigo.ads.core.h.e.a(this.I);
    }

    public void t() {
        WebView webView = this.B;
        if (webView != null) {
            webView.loadUrl(this.C);
        }
    }

    public boolean v() {
        WebView webView = this.B;
        return webView != null && webView.canGoBack();
    }

    public void b(int i2) {
        this.f17118a = true;
        e(i2);
        WebView webView = this.B;
        if (webView != null) {
            webView.stopLoading();
        }
        super.ap();
    }

    public void c(String str) {
        a0.i(0, str, "onAutoRedirectStart url= ", 3, "WebView");
    }

    public String d(String str) {
        return str;
    }

    public void e(int i2) {
    }

    @Override // sg.bigo.ads.api.core.BaseAdActivityImpl
    public void g(boolean z2) {
    }

    public void a(@IntRange(from = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_LONG, to = 100) int i2) {
    }

    public void b(String str) {
        TextView textView = this.f17123x;
        if (textView != null) {
            textView.setText(str);
        }
    }

    @CallSuper
    public void d() {
        WebView webView = this.B;
        if (webView != null) {
            webView.onResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean e(String str) {
        return a(Uri.parse(str));
    }

    @Override // sg.bigo.ads.api.core.BaseAdActivityImpl
    public final void a(int i2, int i8, Intent intent) {
        String dataString;
        FileChooser fileChooser = this.f17121d;
        if (fileChooser != null) {
            Uri[] uriArr = (i8 != -1 || i2 != 101 || intent == null || intent.getData() == null || (dataString = intent.getDataString()) == null) ? null : new Uri[]{Uri.parse(dataString)};
            ValueCallback<Uri[]> valueCallback = fileChooser.f17117c;
            if (valueCallback != null) {
                valueCallback.onReceiveValue(uriArr);
                fileChooser.f17117c = null;
            }
        }
    }

    public void d(int i2) {
        b(i2);
    }

    public void a(int i2, String str, String str2) {
    }

    public void a(String str) {
    }

    public boolean c() {
        return false;
    }

    public void a(String str, boolean z2) {
    }

    public void a(@NonNull sg.bigo.ads.api.core.e eVar) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(Uri uri) {
        sg.bigo.ads.api.core.e eVar = new sg.bigo.ads.api.core.e();
        boolean zA = sg.bigo.ads.core.landing.a.a(uri, this.I, eVar, "");
        if (eVar.f15487b == 0 && eVar.f15488c == 0) {
            return zA;
        }
        a(eVar);
        return zA;
    }

    public boolean a(MotionEvent motionEvent) {
        return false;
    }

    public static /* synthetic */ boolean a(WebViewActivityImpl webViewActivityImpl) {
        webViewActivityImpl.f17119b = true;
        return true;
    }

    @Override // sg.bigo.ads.api.core.BaseAdActivityImpl
    public void X() {
    }

    public void s() {
    }
}
