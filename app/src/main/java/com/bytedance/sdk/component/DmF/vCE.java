package com.bytedance.sdk.component.DmF;

import android.content.Context;
import android.graphics.Paint;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.DownloadListener;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ScrollView;
import com.bytedance.sdk.component.DmF.IlO;
import com.bytedance.sdk.component.utils.tl;
import com.ironsource.C2300e4;
import com.vungle.ads.internal.model.AdPayload;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class vCE extends FrameLayout {
    private static EO BS;
    private boolean AXM;
    private boolean Bc;
    private String Cc;
    private AtomicBoolean DM;
    private float DmF;
    public int EO;
    private long EV;
    public int IlO;
    public int MY;
    private long NV;
    private float OOq;
    private AtomicBoolean YA;
    private volatile WebView bWL;
    private List<String> cL;
    private com.bytedance.sdk.component.DmF.IlO cl;
    private tl dY;
    private View ea;
    private com.bytedance.sdk.component.DmF.tV es;
    private long gQ;
    private boolean hp;
    private boolean kBB;
    private float lEW;
    private AttributeSet lMM;
    private AtomicBoolean mmj;
    private Context nvX;
    private int oc;
    private boolean oeT;
    private WebViewClient pP;
    private long rp;
    private long ssS;
    private com.bytedance.sdk.component.DmF.MY.IlO tV;
    private float tl;
    private boolean vAh;
    private JSONObject vCE;
    private MY vSq;
    private float wPn;
    private boolean xF;
    private tV zLG;
    private IlO.InterfaceC0045IlO zPa;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public interface EO {
        WebView createWebView(Context context, AttributeSet attributeSet, int i2);
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class IlO extends WebViewClient {
        @Override // android.webkit.WebViewClient
        public boolean onRenderProcessGone(final WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
            if (Build.VERSION.SDK_INT < 26) {
                return super.onRenderProcessGone(webView, renderProcessGoneDetail);
            }
            if (webView == null) {
                return true;
            }
            webView.post(new Runnable() { // from class: com.bytedance.sdk.component.DmF.vCE.IlO.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        ViewGroup viewGroup = (ViewGroup) webView.getParent();
                        if (viewGroup != null) {
                            viewGroup.removeView(webView);
                        }
                        webView.destroy();
                    } catch (Exception unused) {
                    }
                }
            });
            return true;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public interface MY {
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public interface tV {
    }

    public vCE(Context context) {
        this(IlO(context), false);
    }

    private void AXM() {
        if (this.dY == null) {
            this.DM.set(false);
            this.dY = new tl(getContext());
        }
        new Object() { // from class: com.bytedance.sdk.component.DmF.vCE.1
        };
        this.DM.set(true);
    }

    private static void EO(Context context) {
    }

    private static Context IlO(Context context) {
        return context;
    }

    private void es() {
        if (this.bWL == null) {
            return;
        }
        try {
            this.bWL.removeJavascriptInterface("searchBoxJavaBridge_");
            this.bWL.removeJavascriptInterface("accessibility");
            this.bWL.removeJavascriptInterface("accessibilityTraversal");
        } catch (Throwable unused) {
        }
    }

    public static void setDataDirectorySuffix(String str) {
        if (Build.VERSION.SDK_INT >= 28) {
            WebView.setDataDirectorySuffix(str);
        }
    }

    public static void setWebViewProvider(EO eo) {
        BS = eo;
    }

    private void xF() {
        try {
            WebSettings settings = this.bWL.getSettings();
            if (settings != null) {
                settings.setSavePassword(false);
            }
        } catch (Throwable unused) {
        }
    }

    public void Bc() {
        try {
            this.bWL.stopLoading();
        } catch (Throwable unused) {
        }
    }

    public void Cc() {
        try {
            this.bWL = IlO(this.lMM, 0);
            vCE();
            MY(IlO(this.nvX));
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    public boolean DmF() {
        if (this.bWL == null) {
            return false;
        }
        try {
            return this.bWL.canGoBack();
        } catch (Throwable unused) {
            return false;
        }
    }

    public boolean EV() {
        if (this.bWL == null) {
            return false;
        }
        try {
            return this.bWL.canGoForward();
        } catch (Throwable unused) {
            return false;
        }
    }

    public boolean MY() {
        return this.AXM;
    }

    public void NV() {
        try {
            this.bWL.goBack();
        } catch (Throwable unused) {
        }
    }

    public void a_(String str) {
        try {
            setJavaScriptEnabled(str);
            this.bWL.loadUrl(str);
        } catch (Throwable unused) {
        }
    }

    public void bWL() {
        try {
            this.bWL.clearHistory();
        } catch (Throwable unused) {
        }
    }

    public void b_(String str) {
        try {
            this.bWL.removeJavascriptInterface(str);
        } catch (Throwable unused) {
        }
    }

    public void cL() {
        try {
            this.bWL.pauseTimers();
        } catch (Throwable unused) {
        }
    }

    public void cl() {
        try {
            this.bWL.clearView();
        } catch (Throwable unused) {
        }
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.bWL == null) {
            return;
        }
        try {
            this.bWL.computeScroll();
        } catch (Throwable unused) {
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return super.dispatchTouchEvent(motionEvent);
    }

    public void ea() {
        if (this.bWL == null) {
            return;
        }
        try {
            this.bWL.onPause();
        } catch (Throwable unused) {
        }
    }

    public View getArbitrageLoadingView() {
        return this.ea;
    }

    public int getContentHeight() {
        if (this.bWL == null) {
            return 0;
        }
        try {
            return this.bWL.getContentHeight();
        } catch (Throwable unused) {
            return 1;
        }
    }

    public long getLandingPageClickBegin() {
        return this.ssS;
    }

    public long getLandingPageClickEnd() {
        return this.gQ;
    }

    public com.bytedance.sdk.component.DmF.MY.IlO getMaterialMeta() {
        return this.tV;
    }

    public String getOriginalUrl() {
        String url;
        if (this.bWL == null) {
            return null;
        }
        try {
            String originalUrl = this.bWL.getOriginalUrl();
            if (originalUrl != null && originalUrl.startsWith("data:text/html") && (url = this.bWL.getUrl()) != null) {
                if (url.startsWith(AdPayload.FILE_SCHEME)) {
                    return url;
                }
            }
            return originalUrl;
        } catch (Throwable unused) {
            return null;
        }
    }

    public int getProgress() {
        if (this.bWL == null) {
            return 0;
        }
        try {
            return this.bWL.getProgress();
        } catch (Throwable unused) {
            return 100;
        }
    }

    public String getUrl() {
        if (this.bWL == null) {
            return null;
        }
        try {
            return this.bWL.getUrl();
        } catch (Throwable unused) {
            return null;
        }
    }

    public String getUserAgentString() {
        if (this.bWL == null) {
            return "";
        }
        try {
            return this.bWL.getSettings().getUserAgentString();
        } catch (Throwable unused) {
            return "";
        }
    }

    public WebView getWebView() {
        return this.bWL;
    }

    public WebViewClient getWebViewClient() {
        return this.pP;
    }

    @Override // android.view.View
    public boolean hasOverlappingRendering() {
        return false;
    }

    public void hp() {
        if (this.bWL != null) {
            this.bWL.onResume();
        }
    }

    public boolean j_() {
        return this.xF;
    }

    public void lEW() {
        try {
            this.bWL.reload();
        } catch (Throwable unused) {
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.YA.set(true);
        if (!this.mmj.get() || this.DM.get()) {
            return;
        }
        AXM();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.YA.set(false);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        ViewParent viewParentIlO;
        try {
            IlO(motionEvent);
            boolean zOnInterceptTouchEvent = super.onInterceptTouchEvent(motionEvent);
            if ((motionEvent.getActionMasked() == 2 || motionEvent.getActionMasked() == 0) && this.hp && (viewParentIlO = IlO(this)) != null) {
                viewParentIlO.requestDisallowInterceptTouchEvent(true);
            }
            return zOnInterceptTouchEvent;
        } catch (Throwable unused) {
            return super.onInterceptTouchEvent(motionEvent);
        }
    }

    @Override // android.view.ViewGroup
    public void removeAllViews() {
        try {
            this.bWL.removeAllViews();
        } catch (Throwable unused) {
        }
    }

    public void rp() {
        try {
            this.bWL.goForward();
        } catch (Throwable unused) {
        }
    }

    public void setAllowFileAccess(boolean z2) {
        try {
            this.bWL.getSettings().setAllowFileAccess(z2);
        } catch (Throwable unused) {
        }
    }

    @Override // android.view.View
    public void setAlpha(float f4) {
        try {
            super.setAlpha(f4);
            this.bWL.setAlpha(f4);
        } catch (Throwable unused) {
        }
    }

    @Override // android.view.View
    public void setBackgroundColor(int i2) {
        try {
            this.bWL.setBackgroundColor(i2);
        } catch (Throwable unused) {
        }
    }

    public void setBuiltInZoomControls(boolean z2) {
        try {
            this.bWL.getSettings().setBuiltInZoomControls(z2);
        } catch (Throwable unused) {
        }
    }

    public void setCacheMode(int i2) {
        try {
            this.bWL.getSettings().setCacheMode(i2);
        } catch (Throwable unused) {
        }
    }

    public void setCalculationMethod(int i2) {
        this.oc = i2;
    }

    public void setDatabaseEnabled(boolean z2) {
        try {
            this.bWL.getSettings().setDatabaseEnabled(z2);
        } catch (Throwable unused) {
        }
    }

    public void setDeepShakeValue(float f4) {
        this.OOq = f4;
    }

    public void setDefaultFontSize(int i2) {
        try {
            this.bWL.getSettings().setDefaultFontSize(i2);
        } catch (Throwable unused) {
        }
    }

    public void setDefaultTextEncodingName(String str) {
        try {
            this.bWL.getSettings().setDefaultTextEncodingName(str);
        } catch (Throwable unused) {
        }
    }

    public void setDisplayZoomControls(boolean z2) {
        try {
            this.bWL.getSettings().setDisplayZoomControls(z2);
        } catch (Throwable unused) {
        }
    }

    public void setDomStorageEnabled(boolean z2) {
        try {
            this.bWL.getSettings().setDomStorageEnabled(z2);
        } catch (Throwable unused) {
        }
    }

    public void setDownloadListener(DownloadListener downloadListener) {
        try {
            this.bWL.setDownloadListener(downloadListener);
        } catch (Throwable unused) {
        }
    }

    public void setIsPreventTouchEvent(boolean z2) {
        this.hp = z2;
    }

    public void setJavaScriptCanOpenWindowsAutomatically(boolean z2) {
        try {
            this.bWL.getSettings().setJavaScriptCanOpenWindowsAutomatically(z2);
        } catch (Throwable unused) {
        }
    }

    public void setJavaScriptEnabled(boolean z2) {
        try {
            this.bWL.getSettings().setJavaScriptEnabled(z2);
        } catch (Throwable unused) {
        }
    }

    public void setLandingPage(boolean z2) {
        this.Bc = z2;
    }

    public void setLandingPageClickBegin(long j) {
        this.ssS = j;
    }

    public void setLandingPageClickEnd(long j) {
        this.gQ = j;
    }

    @Override // android.view.View
    public void setLayerType(int i2, Paint paint) {
        try {
            this.bWL.setLayerType(i2, paint);
        } catch (Throwable unused) {
        }
    }

    public void setLayoutAlgorithm(WebSettings.LayoutAlgorithm layoutAlgorithm) {
        try {
            this.bWL.getSettings().setLayoutAlgorithm(layoutAlgorithm);
        } catch (Throwable unused) {
        }
    }

    public void setLoadWithOverviewMode(boolean z2) {
        try {
            this.bWL.getSettings().setLoadWithOverviewMode(z2);
        } catch (Throwable unused) {
        }
    }

    public void setLpPreRender(boolean z2) {
        this.xF = z2;
    }

    public void setMaterialMeta(com.bytedance.sdk.component.DmF.MY.IlO ilO) {
        this.tV = ilO;
    }

    public void setMixedContentMode(int i2) {
        try {
            this.bWL.getSettings().setMixedContentMode(i2);
        } catch (Throwable unused) {
        }
    }

    public void setNetworkAvailable(boolean z2) {
        try {
            this.bWL.setNetworkAvailable(z2);
        } catch (Throwable unused) {
        }
    }

    public void setOnShakeListener(MY my) {
        this.vSq = my;
    }

    @Override // android.view.View
    public void setOverScrollMode(int i2) {
        try {
            this.bWL.setOverScrollMode(i2);
            super.setOverScrollMode(i2);
        } catch (Throwable unused) {
        }
    }

    public void setPreError(boolean z2) {
        this.kBB = z2;
    }

    public void setPreFinish(boolean z2) {
        this.oeT = z2;
    }

    public void setPreProgressHundred(boolean z2) {
        this.vAh = z2;
    }

    public void setPreStart(boolean z2) {
        this.AXM = z2;
    }

    public void setRecycler(boolean z2) {
        if (this.bWL == null || !(this.bWL instanceof Cc)) {
            return;
        }
        ((Cc) this.bWL).setRecycler(z2);
    }

    public void setShakeValue(float f4) {
        this.tl = f4;
    }

    public void setSupportZoom(boolean z2) {
        try {
            this.bWL.getSettings().setSupportZoom(z2);
        } catch (Throwable unused) {
        }
    }

    public void setTag(String str) {
        this.Cc = str;
        com.bytedance.sdk.component.DmF.IlO ilO = this.cl;
        if (ilO != null) {
            ilO.IlO(str);
        }
        com.bytedance.sdk.component.DmF.tV tVVar = this.es;
        if (tVVar != null) {
            tVVar.IlO(str);
        }
    }

    public void setTouchStateListener(tV tVVar) {
        this.zLG = tVVar;
    }

    public void setUseWideViewPort(boolean z2) {
        try {
            this.bWL.getSettings().setUseWideViewPort(z2);
        } catch (Throwable unused) {
        }
    }

    public void setUserAgentString(String str) {
        try {
            this.bWL.getSettings().setUserAgentString(str);
        } catch (Throwable unused) {
        }
    }

    @Override // android.view.View
    public void setVisibility(int i2) {
        try {
            super.setVisibility(i2);
            this.bWL.setVisibility(i2);
        } catch (Throwable unused) {
        }
    }

    public void setWebChromeClient(WebChromeClient webChromeClient) {
        try {
            this.bWL.setWebChromeClient(webChromeClient);
        } catch (Throwable unused) {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setWebViewClient(WebViewClient webViewClient) {
        try {
            if (webViewClient instanceof tV) {
                setTouchStateListener((tV) webViewClient);
            } else {
                setTouchStateListener(null);
            }
            if (webViewClient == 0) {
                webViewClient = new IlO();
            }
            this.pP = webViewClient;
            this.bWL.setWebViewClient(new Bc(this.zPa, webViewClient, this.cL));
        } catch (Throwable unused) {
        }
    }

    public void setWriggleValue(float f4) {
        this.wPn = f4;
    }

    public boolean tV() {
        return this.vAh;
    }

    public void vCE() {
        if (this.bWL != null) {
            removeAllViews();
            setBackground(null);
            try {
                this.bWL.setId(520093704);
            } catch (Throwable unused) {
            }
            addView(this.bWL, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    public void zPa() {
        if (this.bWL == null) {
            return;
        }
        try {
            this.bWL.destroy();
        } catch (Throwable unused) {
        }
    }

    public vCE(Context context, boolean z2) {
        super(IlO(context));
        this.lEW = 0.0f;
        this.DmF = 0.0f;
        this.NV = 0L;
        this.EV = 0L;
        this.rp = 0L;
        this.hp = false;
        this.tl = 20.0f;
        this.wPn = 50.0f;
        this.YA = new AtomicBoolean();
        this.mmj = new AtomicBoolean();
        this.DM = new AtomicBoolean();
        this.nvX = context;
        if (z2) {
            return;
        }
        try {
            this.bWL = IlO((AttributeSet) null, 0);
            vCE();
        } catch (Throwable unused) {
        }
        MY(IlO(context));
    }

    private void MY(Context context) {
        EO(context);
        xF();
        es();
    }

    private void setJavaScriptEnabled(String str) {
        WebSettings settings;
        try {
            if (!TextUtils.isEmpty(str) && (settings = this.bWL.getSettings()) != null) {
                if (Uri.parse(str).getScheme().equalsIgnoreCase(C2300e4.h.f8363b)) {
                    settings.setJavaScriptEnabled(false);
                } else {
                    settings.setJavaScriptEnabled(true);
                }
            }
        } catch (Throwable unused) {
        }
    }

    public boolean EO() {
        return this.oeT;
    }

    public void IlO(boolean z2, int i2, int i8, List<Integer> list, int i9, List<String> list2) {
        if (z2 && this.bWL != null && (this.bWL instanceof Cc)) {
            this.cl = new com.bytedance.sdk.component.DmF.IlO(this.nvX, i2, i8, list, i9);
            this.cL = list2;
            if (!TextUtils.isEmpty(this.Cc)) {
                this.cl.IlO(this.Cc);
            }
            ((Cc) this.bWL).setTouchListenerProxy(this.cl);
            this.zPa = this.cl.IlO();
        }
    }

    @Override // android.view.View
    public String getTag() {
        return this.Cc;
    }

    private static boolean EO(View view) {
        try {
            Class<?> clsLoadClass = view.getClass().getClassLoader().loadClass("android.support.v4.view.ScrollingView");
            if (clsLoadClass != null) {
                if (clsLoadClass.isInstance(view)) {
                    return true;
                }
            }
        } catch (Throwable unused) {
        }
        try {
            Class<?> clsLoadClass2 = view.getClass().getClassLoader().loadClass("androidx.core.view.ScrollingView");
            if (clsLoadClass2 != null) {
                return clsLoadClass2.isInstance(view);
            }
            return false;
        } catch (Throwable unused2) {
            return false;
        }
    }

    private static boolean MY(View view) {
        try {
            Class<?> clsLoadClass = view.getClass().getClassLoader().loadClass("android.support.v4.view.ViewPager");
            if (clsLoadClass != null) {
                if (clsLoadClass.isInstance(view)) {
                    return true;
                }
            }
        } catch (Throwable unused) {
        }
        try {
            Class<?> clsLoadClass2 = view.getClass().getClassLoader().loadClass("androidx.viewpager.widget.ViewPager");
            if (clsLoadClass2 != null) {
                return clsLoadClass2.isInstance(view);
            }
            return false;
        } catch (Throwable unused2) {
            return false;
        }
    }

    public void IlO(int i2, long j) {
        if (this.bWL == null || !(this.bWL instanceof Cc)) {
            return;
        }
        this.es = new com.bytedance.sdk.component.DmF.tV(this.nvX, this.cl, i2, j, this);
        if (!TextUtils.isEmpty(this.Cc)) {
            this.es.IlO(this.Cc);
        }
        ((Cc) this.bWL).setTouchListenerProxy(this.es);
    }

    public void IlO(boolean z2, View view) {
        if (z2) {
            this.ea = view;
            view.setVisibility(8);
            View view2 = this.ea;
            if (view2 == null || view2.getParent() != null) {
                return;
            }
            addView(this.ea, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    private WebView IlO(AttributeSet attributeSet, int i2) {
        EO eo = BS;
        if (eo != null) {
            return eo.createWebView(getContext(), attributeSet, i2);
        }
        if (attributeSet == null) {
            return new WebView(IlO(this.nvX));
        }
        return new WebView(IlO(this.nvX), attributeSet);
    }

    public void IlO(String str, Map<String, String> map) {
        try {
            setJavaScriptEnabled(str);
            this.bWL.loadUrl(str, map);
        } catch (Throwable unused) {
        }
    }

    public void IlO(String str, String str2, String str3, String str4, String str5) {
        try {
            setJavaScriptEnabled(str);
            this.bWL.loadDataWithBaseURL(str, str2, str3, str4, str5);
        } catch (Throwable unused) {
        }
    }

    public void IlO(boolean z2) {
        try {
            this.bWL.clearCache(z2);
        } catch (Throwable unused) {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ViewParent IlO(View view) {
        ViewParent parent = view.getParent();
        if ((parent instanceof AbsListView) || (parent instanceof ScrollView) || (parent instanceof HorizontalScrollView) || !(parent instanceof View)) {
            return parent;
        }
        View view2 = (View) parent;
        return (MY(view2) || EO(view2)) ? parent : IlO(view2);
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z2) {
    }

    public void IlO(Object obj, String str) {
        try {
            this.bWL.addJavascriptInterface(obj, str);
        } catch (Throwable unused) {
        }
    }

    private void IlO(MotionEvent motionEvent) {
        if (!this.Bc || this.tV == null) {
            return;
        }
        if ((this.Cc == null && this.vCE == null) || motionEvent == null) {
            return;
        }
        try {
            int action = motionEvent.getAction();
            if (action == 0) {
                this.lEW = motionEvent.getRawX();
                this.DmF = motionEvent.getRawY();
                this.NV = System.currentTimeMillis();
                this.vCE = new JSONObject();
                if (this.bWL != null) {
                    this.ssS = this.NV;
                    return;
                }
                return;
            }
            if (action == 1 || action == 3) {
                this.vCE.put("start_x", String.valueOf(this.lEW));
                this.vCE.put("start_y", String.valueOf(this.DmF));
                this.vCE.put("offset_x", String.valueOf(motionEvent.getRawX() - this.lEW));
                this.vCE.put("offset_y", String.valueOf(motionEvent.getRawY() - this.DmF));
                this.vCE.put("url", String.valueOf(getUrl()));
                this.vCE.put("tag", "");
                this.EV = System.currentTimeMillis();
                if (this.bWL != null) {
                    this.gQ = this.EV;
                }
                this.vCE.put("down_time", this.NV);
                this.vCE.put("up_time", this.EV);
                if (com.bytedance.sdk.component.DmF.IlO.IlO.IlO().MY() != null) {
                    long j = this.rp;
                    long j3 = this.NV;
                    if (j != j3) {
                        this.rp = j3;
                        com.bytedance.sdk.component.DmF.IlO.IlO.IlO().MY().IlO(this.tV, this.Cc, "in_web_click", this.vCE, this.EV - this.NV);
                    }
                }
            }
        } catch (Throwable unused) {
        }
    }
}
