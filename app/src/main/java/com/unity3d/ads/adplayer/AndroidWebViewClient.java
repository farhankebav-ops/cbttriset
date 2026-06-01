package com.unity3d.ads.adplayer;

import android.net.Uri;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import androidx.annotation.RequiresApi;
import androidx.webkit.WebResourceErrorCompat;
import androidx.webkit.WebViewClientCompat;
import androidx.webkit.WebViewFeature;
import com.unity3d.ads.adplayer.model.ErrorReason;
import com.unity3d.ads.adplayer.model.WebViewClientError;
import com.unity3d.ads.core.domain.GetCachedAsset;
import com.unity3d.ads.core.domain.SendDiagnosticEvent;
import com.unity3d.ads.core.extensions.IntExtensionKt;
import com.unity3d.ads.core.extensions.ViewExtensionsKt;
import java.util.List;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;
import n6.m;
import q5.i;
import q5.j;
import q6.c0;
import q6.f0;
import q6.n1;
import q6.q;
import r5.l;
import r5.r;
import r5.s;
import r5.x;
import t6.b1;
import t6.d1;
import t6.q0;
import t6.s0;
import t6.x0;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class AndroidWebViewClient extends WebViewClientCompat {
    public static final String BLANK_PAGE = "about:blank";
    public static final Companion Companion = new Companion(null);
    private final q0 _isRenderProcessGone;
    private final q _onLoadFinished;
    private final GetCachedAsset getCachedAsset;
    private final b1 isRenderProcessGone;
    private final q0 loadErrors;
    private final f0 onLoadFinished;
    private final SendDiagnosticEvent sendDiagnosticEvent;
    private final q0 webviewType;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Companion {
        public /* synthetic */ Companion(f fVar) {
            this();
        }

        private Companion() {
        }
    }

    public AndroidWebViewClient(GetCachedAsset getCachedAsset, SendDiagnosticEvent sendDiagnosticEvent) {
        k.e(getCachedAsset, "getCachedAsset");
        k.e(sendDiagnosticEvent, "sendDiagnosticEvent");
        this.getCachedAsset = getCachedAsset;
        this.sendDiagnosticEvent = sendDiagnosticEvent;
        this.loadErrors = x0.c(r.f13638a);
        q6.r rVarA = c0.a();
        this._onLoadFinished = rVarA;
        this.onLoadFinished = rVarA;
        d1 d1VarC = x0.c(Boolean.FALSE);
        this._isRenderProcessGone = d1VarC;
        this.isRenderProcessGone = new s0(d1VarC);
        this.webviewType = x0.c("");
    }

    public final f0 getOnLoadFinished() {
        return this.onLoadFinished;
    }

    public final b1 isRenderProcessGone() {
        return this.isRenderProcessGone;
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView view, String url) {
        String str;
        k.e(view, "view");
        k.e(url, "url");
        if (url.equals(BLANK_PAGE)) {
            q0 q0Var = this.loadErrors;
            while (true) {
                d1 d1Var = (d1) q0Var;
                Object value = d1Var.getValue();
                str = url;
                if (d1Var.g(value, l.g1((List) value, new WebViewClientError(str, ErrorReason.REASON_WEB_BLANK, null, 4, null)))) {
                    break;
                } else {
                    url = str;
                }
            }
        } else {
            str = url;
        }
        super.onPageFinished(view, str);
        ((q6.r) this._onLoadFinished).N(((d1) this.loadErrors).getValue());
    }

    @Override // androidx.webkit.WebViewClientCompat
    @RequiresApi(21)
    public void onReceivedError(WebView view, WebResourceRequest request, WebResourceErrorCompat error) {
        d1 d1Var;
        Object value;
        k.e(view, "view");
        k.e(request, "request");
        k.e(error, "error");
        super.onReceivedError(view, request, error);
        ErrorReason errorReasonWebResourceToErrorReason = WebViewFeature.isFeatureSupported(WebViewFeature.WEB_RESOURCE_ERROR_GET_CODE) ? IntExtensionKt.webResourceToErrorReason(error.getErrorCode()) : ErrorReason.REASON_UNKNOWN;
        q0 q0Var = this.loadErrors;
        do {
            d1Var = (d1) q0Var;
            value = d1Var.getValue();
        } while (!d1Var.g(value, l.g1((List) value, new WebViewClientError(request.getUrl().toString(), errorReasonWebResourceToErrorReason, null, 4, null))));
    }

    @Override // androidx.webkit.WebViewClientCompat, android.webkit.WebViewClient, org.chromium.support_lib_boundary.WebViewClientBoundaryInterface
    public void onReceivedHttpError(WebView view, WebResourceRequest request, WebResourceResponse errorResponse) {
        d1 d1Var;
        Object value;
        k.e(view, "view");
        k.e(request, "request");
        k.e(errorResponse, "errorResponse");
        super.onReceivedHttpError(view, request, errorResponse);
        WebViewClientError webViewClientError = new WebViewClientError(request.getUrl().toString(), ErrorReason.REASON_WEB_ERROR_RECEIVED_HTTP, Integer.valueOf(errorResponse.getStatusCode()));
        q0 q0Var = this.loadErrors;
        do {
            d1Var = (d1) q0Var;
            value = d1Var.getValue();
        } while (!d1Var.g(value, l.g1((List) value, webViewClientError)));
    }

    @Override // android.webkit.WebViewClient
    public boolean onRenderProcessGone(WebView view, RenderProcessGoneDetail detail) {
        d1 d1Var;
        Object value;
        k.e(view, "view");
        k.e(detail, "detail");
        ViewExtensionsKt.removeViewFromParent(view);
        view.destroy();
        if (((n1) this._onLoadFinished).K()) {
            q0 q0Var = this._isRenderProcessGone;
            Boolean bool = Boolean.TRUE;
            d1 d1Var2 = (d1) q0Var;
            d1Var2.getClass();
            d1Var2.i(null, bool);
            return true;
        }
        q0 q0Var2 = this.loadErrors;
        do {
            d1Var = (d1) q0Var2;
            value = d1Var.getValue();
        } while (!d1Var.g(value, l.g1((List) value, new WebViewClientError(String.valueOf(view.getUrl()), ErrorReason.REASON_WEBVIEW_RENDER_PROCESS_GONE, null, 4, null))));
        ((q6.r) this._onLoadFinished).N(((d1) this.loadErrors).getValue());
        return true;
    }

    @Override // android.webkit.WebViewClient
    public WebResourceResponse shouldInterceptRequest(WebView view, WebResourceRequest request) {
        Object objM;
        k.e(view, "view");
        k.e(request, "request");
        Uri url = request.getUrl();
        if (url == null) {
            return super.shouldInterceptRequest(view, request);
        }
        try {
            try {
                objM = url.getQueryParameter("webviewType");
            } catch (Throwable th) {
                objM = r2.q.M(th);
            }
            if (objM instanceof j) {
                objM = null;
            }
            String str = (String) objM;
            if (str != null && !m.A0(str)) {
                d1 d1Var = (d1) this.webviewType;
                d1Var.getClass();
                d1Var.i(null, str);
            }
            if (k.a(url.getLastPathSegment(), "favicon.ico")) {
                return new WebResourceResponse("image/png", null, null);
            }
            GetCachedAsset getCachedAsset = this.getCachedAsset;
            Uri url2 = request.getUrl();
            k.d(url2, "request.url");
            return getCachedAsset.invoke(url2, (String) ((d1) this.webviewType).getValue());
        } catch (Throwable th2) {
            String message = th2.getMessage();
            SendDiagnosticEvent.DefaultImpls.invoke$default(this.sendDiagnosticEvent, "webview_could_not_handle_intercepted_url", null, message != null ? x.e0(new i("reason", message)) : s.f13639a, null, null, null, 58, null);
            return super.shouldInterceptRequest(view, request);
        }
    }
}
