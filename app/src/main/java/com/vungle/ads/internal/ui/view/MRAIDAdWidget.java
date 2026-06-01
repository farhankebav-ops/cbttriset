package com.vungle.ads.internal.ui.view;

import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.RelativeLayout;
import androidx.annotation.VisibleForTesting;
import com.unity3d.ads.adplayer.AndroidWebViewClient;
import com.unity3d.services.core.device.MimeTypes;
import com.vungle.ads.internal.model.AdPayload;
import com.vungle.ads.internal.platform.WebViewUtil;
import com.vungle.ads.internal.presenter.WebViewManager;
import com.vungle.ads.internal.ui.view.MRAIDAdWidget;
import com.vungle.ads.internal.util.HandlerScheduler;
import com.vungle.ads.internal.util.Logger;
import com.vungle.ads.internal.util.ViewUtility;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;
import r2.q;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class MRAIDAdWidget extends RelativeLayout {
    public static final Companion Companion = new Companion(null);
    private static final String TAG = "MRAIDAdWidget";
    private CloseDelegate closeDelegate;
    private final String eventId;
    private OnViewTouchListener onViewTouchListener;
    private OrientationDelegate orientationDelegate;
    private WebView webView;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @Retention(RetentionPolicy.RUNTIME)
    public @interface AdStopReason {
        public static final Companion Companion = Companion.$$INSTANCE;
        public static final int IS_AD_FINISHED_BY_API = 4;
        public static final int IS_AD_FINISHING = 2;
        public static final int IS_CHANGING_CONFIGURATION = 1;

        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = new Companion();
            public static final int IS_AD_FINISHED_BY_API = 4;
            public static final int IS_AD_FINISHING = 2;
            public static final int IS_CHANGING_CONFIGURATION = 1;

            private Companion() {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class AudioContextWrapper extends ContextWrapper {
        public AudioContextWrapper(Context context) {
            super(context);
        }

        @Override // android.content.ContextWrapper, android.content.Context
        public Object getSystemService(String name) {
            k.e(name, "name");
            Object systemService = MimeTypes.BASE_TYPE_AUDIO.equals(name) ? getApplicationContext().getSystemService(name) : super.getSystemService(name);
            k.d(systemService, "if (AUDIO_SERVICE == nam…rvice(name)\n            }");
            return systemService;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public interface CloseDelegate {
        void close();
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Companion {
        public /* synthetic */ Companion(f fVar) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class DestroyRunnable implements Runnable {
        private final boolean isMaliBuggy;
        private final MRAIDAdWidget widget;

        public DestroyRunnable(MRAIDAdWidget widget, boolean z2) {
            k.e(widget, "widget");
            this.widget = widget;
            this.isMaliBuggy = z2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX INFO: renamed from: run$lambda-0, reason: not valid java name */
        public static final void m3375run$lambda0(DestroyRunnable this$0) {
            k.e(this$0, "this$0");
            this$0.run();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX INFO: renamed from: run$lambda-10, reason: not valid java name */
        public static final void m3376run$lambda10(WebView wv, DestroyRunnable this$0) {
            k.e(wv, "$wv");
            k.e(this$0, "this$0");
            try {
                wv.destroy();
                String eventId = this$0.widget.getEventId();
                if (eventId != null) {
                    WebViewManager.INSTANCE.destroyWebView(eventId);
                }
                this$0.widget.webView = null;
            } catch (Throwable th) {
                Logger.Companion.e(MRAIDAdWidget.TAG, "Destroy webview " + th.getMessage());
            }
        }

        public final boolean isMaliBuggy() {
            return this.isMaliBuggy;
        }

        @Override // java.lang.Runnable
        public void run() {
            final WebView webView = this.widget.webView;
            if (webView == null) {
                return;
            }
            if (!k.a(Looper.myLooper(), Looper.getMainLooper())) {
                new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.vungle.ads.internal.ui.view.b
                    @Override // java.lang.Runnable
                    public final void run() {
                        MRAIDAdWidget.DestroyRunnable.m3375run$lambda0(this.f11019a);
                    }
                });
                return;
            }
            try {
                try {
                    webView.onPause();
                } catch (Throwable th) {
                    q.M(th);
                }
                try {
                    webView.stopLoading();
                } catch (Throwable th2) {
                    q.M(th2);
                }
                try {
                    webView.setWebChromeClient(null);
                } catch (Throwable th3) {
                    q.M(th3);
                }
                try {
                    webView.setWebViewClient(new WebViewClient());
                } catch (Throwable th4) {
                    q.M(th4);
                }
                if (Build.VERSION.SDK_INT >= 29) {
                    try {
                        webView.setWebViewRenderProcessClient(null);
                    } catch (Throwable th5) {
                        q.M(th5);
                    }
                }
                webView.setVisibility(8);
                if (this.isMaliBuggy) {
                    webView.setLayerType(1, null);
                }
                try {
                    webView.loadUrl(AndroidWebViewClient.BLANK_PAGE);
                } catch (Throwable th6) {
                    q.M(th6);
                }
                try {
                    webView.clearHistory();
                } catch (Throwable th7) {
                    q.M(th7);
                }
                try {
                    webView.removeAllViews();
                } catch (Throwable th8) {
                    q.M(th8);
                }
                new HandlerScheduler().schedule(new Runnable() { // from class: com.vungle.ads.internal.ui.view.c
                    @Override // java.lang.Runnable
                    public final void run() {
                        MRAIDAdWidget.DestroyRunnable.m3376run$lambda10(webView, this);
                    }
                }, this.isMaliBuggy ? 300L : 100L);
            } catch (Throwable th9) {
                Logger.Companion.e(MRAIDAdWidget.TAG, "Destroy webview: " + th9.getMessage());
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public interface OnViewTouchListener {
        boolean onTouch(MotionEvent motionEvent);
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public interface OrientationDelegate {
        void setOrientation(int i2);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MRAIDAdWidget(Context context) throws InstantiationException {
        this(context, null, 2, 0 == true ? 1 : 0);
        k.e(context, "context");
    }

    private final void bindListeners() {
        WebView webView = this.webView;
        if (webView != null) {
            webView.setOnTouchListener(new View.OnTouchListener() { // from class: com.vungle.ads.internal.ui.view.a
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    return MRAIDAdWidget.m3374bindListeners$lambda0(this.f11018a, view, motionEvent);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: bindListeners$lambda-0, reason: not valid java name */
    public static final boolean m3374bindListeners$lambda0(MRAIDAdWidget this$0, View view, MotionEvent motionEvent) {
        k.e(this$0, "this$0");
        OnViewTouchListener onViewTouchListener = this$0.onViewTouchListener;
        if (onViewTouchListener != null) {
            return onViewTouchListener.onTouch(motionEvent);
        }
        return false;
    }

    public static /* synthetic */ void destroyWebView$default(MRAIDAdWidget mRAIDAdWidget, long j, boolean z2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z2 = false;
        }
        mRAIDAdWidget.destroyWebView(j, z2);
    }

    private final void prepare() {
        WebView webView = this.webView;
        if (webView != null) {
            webView.setLayerType(2, null);
            webView.setBackgroundColor(0);
            webView.setVisibility(8);
        }
    }

    public final void close() {
        CloseDelegate closeDelegate = this.closeDelegate;
        if (closeDelegate != null) {
            closeDelegate.close();
        }
    }

    public final void destroyWebView(long j, boolean z2) {
        try {
            ViewParent parent = getParent();
            ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
            if (viewGroup != null) {
                viewGroup.removeView(this);
            }
        } catch (Throwable th) {
            q.M(th);
        }
        try {
            removeAllViews();
        } catch (Throwable th2) {
            q.M(th2);
        }
        if (j <= 0) {
            new DestroyRunnable(this, z2).run();
        } else {
            new HandlerScheduler().schedule(new DestroyRunnable(this, z2), j);
        }
    }

    public final CloseDelegate getCloseDelegate$vungle_ads_release() {
        return this.closeDelegate;
    }

    public final String getEventId() {
        return this.eventId;
    }

    public final OnViewTouchListener getOnViewTouchListener$vungle_ads_release() {
        return this.onViewTouchListener;
    }

    public final OrientationDelegate getOrientationDelegate$vungle_ads_release() {
        return this.orientationDelegate;
    }

    public final String getUrl() {
        WebView webView = this.webView;
        if (webView != null) {
            return webView.getUrl();
        }
        return null;
    }

    public final void linkWebView(WebViewClient vngWebViewClient, AdPayload.WebViewSettings webViewSettings) {
        k.e(vngWebViewClient, "vngWebViewClient");
        WebView webView = this.webView;
        if (webView != null) {
            WebViewUtil.INSTANCE.applyWebSettings(webView, webViewSettings);
            webView.setWebViewClient(vngWebViewClient);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        ViewGroup.LayoutParams layoutParams;
        super.onAttachedToWindow();
        ViewGroup.LayoutParams layoutParams2 = getLayoutParams();
        if (layoutParams2 != null) {
            layoutParams2.height = -1;
            layoutParams2.width = -1;
        }
        WebView webView = this.webView;
        if (webView == null || (layoutParams = webView.getLayoutParams()) == null) {
            return;
        }
        layoutParams.height = -1;
        layoutParams.width = -1;
    }

    public final void pauseWeb() {
        WebView webView = this.webView;
        if (webView != null) {
            webView.onPause();
        }
    }

    public final void resumeWeb() {
        WebView webView = this.webView;
        if (webView != null) {
            webView.setVisibility(0);
        }
        WebView webView2 = this.webView;
        if (webView2 != null) {
            webView2.onResume();
        }
    }

    public final void setCloseDelegate(CloseDelegate closeDelegate) {
        k.e(closeDelegate, "closeDelegate");
        this.closeDelegate = closeDelegate;
    }

    public final void setCloseDelegate$vungle_ads_release(CloseDelegate closeDelegate) {
        this.closeDelegate = closeDelegate;
    }

    public final void setOnViewTouchListener(OnViewTouchListener onViewTouchListener) {
        this.onViewTouchListener = onViewTouchListener;
    }

    public final void setOnViewTouchListener$vungle_ads_release(OnViewTouchListener onViewTouchListener) {
        this.onViewTouchListener = onViewTouchListener;
    }

    public final void setOrientation(int i2) {
        OrientationDelegate orientationDelegate = this.orientationDelegate;
        if (orientationDelegate != null) {
            orientationDelegate.setOrientation(i2);
        }
    }

    public final void setOrientationDelegate(OrientationDelegate orientationDelegate) {
        this.orientationDelegate = orientationDelegate;
    }

    public final void setOrientationDelegate$vungle_ads_release(OrientationDelegate orientationDelegate) {
        this.orientationDelegate = orientationDelegate;
    }

    public final void showWebsite(String url) {
        k.e(url, "url");
        Logger.Companion.d(TAG, "loadUrl: ".concat(url));
        WebView webView = this.webView;
        if (webView != null) {
            webView.loadUrl(url);
        }
    }

    public /* synthetic */ MRAIDAdWidget(Context context, String str, int i2, f fVar) throws InstantiationException {
        this(context, (i2 & 2) != 0 ? null : str);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MRAIDAdWidget(Context context, String str) throws InstantiationException {
        super(context);
        k.e(context, "context");
        this.eventId = str;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        setLayoutParams(layoutParams);
        WebView webView = ViewUtility.INSTANCE.getWebView(context, str);
        this.webView = webView;
        if (webView != null) {
            webView.setLayoutParams(layoutParams);
        }
        WebView webView2 = this.webView;
        if (webView2 != null) {
            webView2.setTag("VungleWebView");
        }
        addView(this.webView, layoutParams);
        bindListeners();
        prepare();
    }

    @VisibleForTesting
    public static /* synthetic */ void getCloseDelegate$vungle_ads_release$annotations() {
    }

    @VisibleForTesting
    public static /* synthetic */ void getOnViewTouchListener$vungle_ads_release$annotations() {
    }

    @VisibleForTesting
    public static /* synthetic */ void getOrientationDelegate$vungle_ads_release$annotations() {
    }
}
