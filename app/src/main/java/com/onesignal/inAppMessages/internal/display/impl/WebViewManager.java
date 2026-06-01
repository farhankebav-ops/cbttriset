package com.onesignal.inAppMessages.internal.display.impl;

import android.app.Activity;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import com.ironsource.C2300e4;
import com.onesignal.common.AndroidUtils;
import com.onesignal.common.JSONObjectExtensionsKt;
import com.onesignal.common.ViewUtils;
import com.onesignal.common.threading.ThreadUtilsKt;
import com.onesignal.core.internal.application.IActivityLifecycleHandler;
import com.onesignal.core.internal.application.IApplicationService;
import com.onesignal.debug.LogLevel;
import com.onesignal.debug.internal.logging.Logging;
import com.onesignal.inAppMessages.internal.InAppMessage;
import com.onesignal.inAppMessages.internal.InAppMessageClickResult;
import com.onesignal.inAppMessages.internal.InAppMessageContent;
import com.onesignal.inAppMessages.internal.InAppMessagePage;
import com.onesignal.inAppMessages.internal.display.impl.InAppMessageView;
import com.onesignal.inAppMessages.internal.lifecycle.IInAppLifecycleService;
import com.onesignal.inAppMessages.internal.prompt.IInAppMessagePromptFactory;
import com.vungle.ads.internal.presenter.MRAIDPresenter;
import com.vungle.ads.internal.protos.Sdk;
import e6.l;
import e6.p;
import java.util.Arrays;
import java.util.Locale;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;
import org.json.JSONException;
import org.json.JSONObject;
import q5.x;
import q6.a0;
import q6.c0;
import q6.m0;
import r2.q;
import v5.c;
import v6.n;
import x5.e;
import x5.i;
import z6.d;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class WebViewManager implements IActivityLifecycleHandler {
    public static final String EVENT_TYPE_ACTION_TAKEN = "action_taken";
    public static final String EVENT_TYPE_KEY = "type";
    public static final String EVENT_TYPE_PAGE_CHANGE = "page_change";
    public static final String EVENT_TYPE_RENDERING_COMPLETE = "rendering_complete";
    public static final String EVENT_TYPE_RESIZE = "resize";
    public static final String GET_PAGE_META_DATA_JS_FUNCTION = "getPageMetaData()";
    public static final String IAM_DISPLAY_LOCATION_KEY = "displayLocation";
    public static final String IAM_DRAG_TO_DISMISS_DISABLED_KEY = "dragToDismissDisabled";
    public static final String IAM_PAGE_META_DATA_KEY = "pageMetaData";
    public static final String JS_OBJ_NAME = "OSAndroid";
    public static final String SAFE_AREA_JS_OBJECT = "{\n   top: %d,\n   bottom: %d,\n   right: %d,\n   left: %d,\n}";
    public static final String SET_SAFE_AREA_INSETS_JS_FUNCTION = "setSafeAreaInsets(%s)";
    public static final String SET_SAFE_AREA_INSETS_SCRIPT = "\n\n<script>\n    setSafeAreaInsets(%s);\n</script>";
    private final IApplicationService _applicationService;
    private final IInAppLifecycleService _lifecycle;
    private final IInAppMessagePromptFactory _promptFactory;
    private Activity activity;
    private boolean closing;
    private String currentActivityName;
    private boolean dismissFired;
    private Integer lastPageHeight;
    private final InAppMessage message;
    private final InAppMessageContent messageContent;
    private InAppMessageView messageView;
    private final z6.a messageViewMutex;
    private OSWebView webView;
    public static final Companion Companion = new Companion(null);
    private static final int MARGIN_PX_SIZE = ViewUtils.INSTANCE.dpToPx(24);

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Companion {
        public /* synthetic */ Companion(f fVar) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public final class OSJavaScriptInterface {
        public OSJavaScriptInterface() {
        }

        private final Position getDisplayLocation(JSONObject jSONObject) {
            Position position = Position.FULL_SCREEN;
            try {
                if (jSONObject.has(WebViewManager.IAM_DISPLAY_LOCATION_KEY) && !k.a(jSONObject.get(WebViewManager.IAM_DISPLAY_LOCATION_KEY), "")) {
                    String strOptString = jSONObject.optString(WebViewManager.IAM_DISPLAY_LOCATION_KEY, "FULL_SCREEN");
                    k.d(strOptString, "jsonObject.optString(\n  …                        )");
                    Locale locale = Locale.getDefault();
                    k.d(locale, "getDefault()");
                    String upperCase = strOptString.toUpperCase(locale);
                    k.d(upperCase, "this as java.lang.String).toUpperCase(locale)");
                    return Position.valueOf(upperCase);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return position;
        }

        private final boolean getDragToDismissDisabled(JSONObject jSONObject) {
            try {
                return jSONObject.getBoolean(WebViewManager.IAM_DRAG_TO_DISMISS_DISABLED_KEY);
            } catch (JSONException unused) {
                return false;
            }
        }

        private final int getPageHeightData(JSONObject jSONObject) {
            try {
                WebViewManager webViewManager = WebViewManager.this;
                Activity activity = webViewManager.activity;
                JSONObject jSONObject2 = jSONObject.getJSONObject(WebViewManager.IAM_PAGE_META_DATA_KEY);
                k.d(jSONObject2, "jsonObject.getJSONObject(IAM_PAGE_META_DATA_KEY)");
                return webViewManager.pageRectToViewHeight(activity, jSONObject2);
            } catch (JSONException unused) {
                return -1;
            }
        }

        private final void handleActionTaken(JSONObject jSONObject) throws JSONException {
            JSONObject body = jSONObject.getJSONObject(C2300e4.h.E0);
            k.d(body, "body");
            String strSafeString = JSONObjectExtensionsKt.safeString(body, "id");
            WebViewManager.this.closing = body.getBoolean(MRAIDPresenter.CLOSE);
            if (WebViewManager.this.message.isPreview()) {
                WebViewManager.this._lifecycle.messageActionOccurredOnPreview(WebViewManager.this.message, new InAppMessageClickResult(body, WebViewManager.this._promptFactory));
            } else if (strSafeString != null) {
                WebViewManager.this._lifecycle.messageActionOccurredOnMessage(WebViewManager.this.message, new InAppMessageClickResult(body, WebViewManager.this._promptFactory));
            }
            if (WebViewManager.this.closing) {
                WebViewManager.this.backgroundDismissAndAwaitNextMessage();
            }
        }

        private final void handlePageChange(JSONObject jSONObject) throws JSONException {
            WebViewManager.this._lifecycle.messagePageChanged(WebViewManager.this.message, new InAppMessagePage(jSONObject));
        }

        private final void handleRenderComplete(JSONObject jSONObject) {
            Position displayLocation = getDisplayLocation(jSONObject);
            int pageHeightData = displayLocation == Position.FULL_SCREEN ? -1 : getPageHeightData(jSONObject);
            boolean dragToDismissDisabled = getDragToDismissDisabled(jSONObject);
            WebViewManager.this.messageContent.setDisplayLocation(displayLocation);
            WebViewManager.this.messageContent.setPageHeight(pageHeightData);
            WebViewManager.this.createNewInAppMessageView(dragToDismissDisabled);
        }

        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
        @JavascriptInterface
        public final void postMessage(String message) {
            InAppMessageView inAppMessageView;
            k.e(message, "message");
            try {
                Logging.debug$default("OSJavaScriptInterface:postMessage: ".concat(message), null, 2, null);
                JSONObject jSONObject = new JSONObject(message);
                String string = jSONObject.getString("type");
                if (string != null) {
                    switch (string.hashCode()) {
                        case -1484226720:
                            if (string.equals(WebViewManager.EVENT_TYPE_PAGE_CHANGE)) {
                                handlePageChange(jSONObject);
                            }
                            break;
                        case -934437708:
                            string.equals(WebViewManager.EVENT_TYPE_RESIZE);
                            break;
                        case 42998156:
                            if (string.equals(WebViewManager.EVENT_TYPE_RENDERING_COMPLETE)) {
                                handleRenderComplete(jSONObject);
                            }
                            break;
                        case 1851145598:
                            if (string.equals(WebViewManager.EVENT_TYPE_ACTION_TAKEN) && (inAppMessageView = WebViewManager.this.messageView) != null && !inAppMessageView.isDragging()) {
                                handleActionTaken(jSONObject);
                            }
                            break;
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public enum Position {
        TOP_BANNER,
        BOTTOM_BANNER,
        CENTER_MODAL,
        FULL_SCREEN;

        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[Position.values().length];
                iArr[Position.TOP_BANNER.ordinal()] = 1;
                iArr[Position.BOTTOM_BANNER.ordinal()] = 2;
                $EnumSwitchMapping$0 = iArr;
            }
        }

        public final boolean isBanner() {
            int i2 = WhenMappings.$EnumSwitchMapping$0[ordinal()];
            return i2 == 1 || i2 == 2;
        }
    }

    /* JADX INFO: renamed from: com.onesignal.inAppMessages.internal.display.impl.WebViewManager$backgroundDismissAndAwaitNextMessage$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.onesignal.inAppMessages.internal.display.impl.WebViewManager$backgroundDismissAndAwaitNextMessage$1", f = "WebViewManager.kt", l = {387}, m = "invokeSuspend")
    public static final class AnonymousClass1 extends i implements l {
        int label;

        public AnonymousClass1(c<? super AnonymousClass1> cVar) {
            super(1, cVar);
        }

        @Override // x5.a
        public final c<x> create(c<?> cVar) {
            return WebViewManager.this.new AnonymousClass1(cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            w5.a aVar = w5.a.f17774a;
            int i2 = this.label;
            if (i2 == 0) {
                q.z0(obj);
                WebViewManager webViewManager = WebViewManager.this;
                this.label = 1;
                if (webViewManager.dismissAndAwaitNextMessage(this) == aVar) {
                    return aVar;
                }
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                q.z0(obj);
            }
            return x.f13520a;
        }

        @Override // e6.l
        public final Object invoke(c<? super x> cVar) {
            return ((AnonymousClass1) create(cVar)).invokeSuspend(x.f13520a);
        }
    }

    /* JADX INFO: renamed from: com.onesignal.inAppMessages.internal.display.impl.WebViewManager$calculateHeightAndShowWebViewAfterNewActivity$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.onesignal.inAppMessages.internal.display.impl.WebViewManager", f = "WebViewManager.kt", l = {Sdk.SDKError.Reason.MRAID_JS_COPY_FAILED_VALUE, Sdk.SDKError.Reason.AD_LOAD_FAIL_EMPTY_BID_PAYLOAD_VALUE, 230}, m = "calculateHeightAndShowWebViewAfterNewActivity")
    public static final class C27401 extends x5.c {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C27401(c<? super C27401> cVar) {
            super(cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return WebViewManager.this.calculateHeightAndShowWebViewAfterNewActivity(this);
        }
    }

    /* JADX INFO: renamed from: com.onesignal.inAppMessages.internal.display.impl.WebViewManager$dismissAndAwaitNextMessage$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.onesignal.inAppMessages.internal.display.impl.WebViewManager", f = "WebViewManager.kt", l = {403}, m = "dismissAndAwaitNextMessage")
    public static final class C27421 extends x5.c {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C27421(c<? super C27421> cVar) {
            super(cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return WebViewManager.this.dismissAndAwaitNextMessage(this);
        }
    }

    /* JADX INFO: renamed from: com.onesignal.inAppMessages.internal.display.impl.WebViewManager$onActivityAvailable$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.onesignal.inAppMessages.internal.display.impl.WebViewManager$onActivityAvailable$1", f = "WebViewManager.kt", l = {254, 261, 265}, m = "invokeSuspend")
    public static final class C27431 extends i implements l {
        final /* synthetic */ String $lastActivityName;
        int label;
        final /* synthetic */ WebViewManager this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C27431(String str, WebViewManager webViewManager, c<? super C27431> cVar) {
            super(1, cVar);
            this.$lastActivityName = str;
            this.this$0 = webViewManager;
        }

        @Override // x5.a
        public final c<x> create(c<?> cVar) {
            return new C27431(this.$lastActivityName, this.this$0, cVar);
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x002c, code lost:
        
            if (r6.showMessageView(null, r5) == r0) goto L28;
         */
        /* JADX WARN: Code restructure failed: missing block: B:24:0x0063, code lost:
        
            if (r6.showMessageView(r1, r5) == r0) goto L28;
         */
        /* JADX WARN: Code restructure failed: missing block: B:27:0x006e, code lost:
        
            if (r6.calculateHeightAndShowWebViewAfterNewActivity(r5) == r0) goto L28;
         */
        /* JADX WARN: Code restructure failed: missing block: B:28:0x0070, code lost:
        
            return r0;
         */
        @Override // x5.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r6) throws java.lang.Throwable {
            /*
                r5 = this;
                w5.a r0 = w5.a.f17774a
                int r1 = r5.label
                r2 = 3
                r3 = 2
                r4 = 1
                if (r1 == 0) goto L1c
                if (r1 == r4) goto L18
                if (r1 == r3) goto L18
                if (r1 != r2) goto L10
                goto L18
            L10:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r0)
                throw r6
            L18:
                r2.q.z0(r6)
                goto L71
            L1c:
                r2.q.z0(r6)
                java.lang.String r6 = r5.$lastActivityName
                if (r6 != 0) goto L2f
                com.onesignal.inAppMessages.internal.display.impl.WebViewManager r6 = r5.this$0
                r5.label = r4
                r1 = 0
                java.lang.Object r6 = com.onesignal.inAppMessages.internal.display.impl.WebViewManager.access$showMessageView(r6, r1, r5)
                if (r6 != r0) goto L71
                goto L70
            L2f:
                com.onesignal.inAppMessages.internal.display.impl.WebViewManager r1 = r5.this$0
                java.lang.String r1 = com.onesignal.inAppMessages.internal.display.impl.WebViewManager.access$getCurrentActivityName$p(r1)
                boolean r6 = kotlin.jvm.internal.k.a(r6, r1)
                if (r6 != 0) goto L66
                com.onesignal.inAppMessages.internal.display.impl.WebViewManager r6 = r5.this$0
                boolean r6 = com.onesignal.inAppMessages.internal.display.impl.WebViewManager.access$getClosing$p(r6)
                if (r6 != 0) goto L71
                com.onesignal.inAppMessages.internal.display.impl.WebViewManager r6 = r5.this$0
                com.onesignal.inAppMessages.internal.display.impl.InAppMessageView r6 = com.onesignal.inAppMessages.internal.display.impl.WebViewManager.access$getMessageView$p(r6)
                if (r6 == 0) goto L57
                com.onesignal.inAppMessages.internal.display.impl.WebViewManager r6 = r5.this$0
                com.onesignal.inAppMessages.internal.display.impl.InAppMessageView r6 = com.onesignal.inAppMessages.internal.display.impl.WebViewManager.access$getMessageView$p(r6)
                kotlin.jvm.internal.k.b(r6)
                r6.removeAllViews()
            L57:
                com.onesignal.inAppMessages.internal.display.impl.WebViewManager r6 = r5.this$0
                java.lang.Integer r1 = com.onesignal.inAppMessages.internal.display.impl.WebViewManager.access$getLastPageHeight$p(r6)
                r5.label = r3
                java.lang.Object r6 = com.onesignal.inAppMessages.internal.display.impl.WebViewManager.access$showMessageView(r6, r1, r5)
                if (r6 != r0) goto L71
                goto L70
            L66:
                com.onesignal.inAppMessages.internal.display.impl.WebViewManager r6 = r5.this$0
                r5.label = r2
                java.lang.Object r6 = com.onesignal.inAppMessages.internal.display.impl.WebViewManager.access$calculateHeightAndShowWebViewAfterNewActivity(r6, r5)
                if (r6 != r0) goto L71
            L70:
                return r0
            L71:
                q5.x r6 = q5.x.f13520a
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: com.onesignal.inAppMessages.internal.display.impl.WebViewManager.C27431.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // e6.l
        public final Object invoke(c<? super x> cVar) {
            return ((C27431) create(cVar)).invokeSuspend(x.f13520a);
        }
    }

    /* JADX INFO: renamed from: com.onesignal.inAppMessages.internal.display.impl.WebViewManager$setupWebView$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.onesignal.inAppMessages.internal.display.impl.WebViewManager", f = "WebViewManager.kt", l = {327}, m = "setupWebView")
    public static final class C27441 extends x5.c {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public C27441(c<? super C27441> cVar) {
            super(cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return WebViewManager.this.setupWebView(null, null, false, this);
        }
    }

    /* JADX INFO: renamed from: com.onesignal.inAppMessages.internal.display.impl.WebViewManager$showMessageView$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.onesignal.inAppMessages.internal.display.impl.WebViewManager", f = "WebViewManager.kt", l = {469, 294, 297, 298}, m = "showMessageView")
    public static final class C27451 extends x5.c {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public C27451(c<? super C27451> cVar) {
            super(cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return WebViewManager.this.showMessageView(null, this);
        }
    }

    /* JADX INFO: renamed from: com.onesignal.inAppMessages.internal.display.impl.WebViewManager$updateSafeAreaInsets$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.onesignal.inAppMessages.internal.display.impl.WebViewManager$updateSafeAreaInsets$2", f = "WebViewManager.kt", l = {}, m = "invokeSuspend")
    public static final class AnonymousClass2 extends i implements p {
        int label;

        public AnonymousClass2(c<? super AnonymousClass2> cVar) {
            super(2, cVar);
        }

        @Override // x5.a
        public final c<x> create(Object obj, c<?> cVar) {
            return WebViewManager.this.new AnonymousClass2(cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            w5.a aVar = w5.a.f17774a;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            q.z0(obj);
            int[] cutoutAndStatusBarInsets = ViewUtils.INSTANCE.getCutoutAndStatusBarInsets(WebViewManager.this.activity);
            String str = String.format(WebViewManager.SET_SAFE_AREA_INSETS_JS_FUNCTION, Arrays.copyOf(new Object[]{String.format(WebViewManager.SAFE_AREA_JS_OBJECT, Arrays.copyOf(new Object[]{new Integer(cutoutAndStatusBarInsets[0]), new Integer(cutoutAndStatusBarInsets[1]), new Integer(cutoutAndStatusBarInsets[2]), new Integer(cutoutAndStatusBarInsets[3])}, 4))}, 1));
            OSWebView oSWebView = WebViewManager.this.webView;
            k.b(oSWebView);
            oSWebView.evaluateJavascript(str, null);
            return x.f13520a;
        }

        @Override // e6.p
        public final Object invoke(a0 a0Var, c<? super x> cVar) {
            return ((AnonymousClass2) create(a0Var, cVar)).invokeSuspend(x.f13520a);
        }
    }

    public WebViewManager(InAppMessage message, Activity activity, InAppMessageContent messageContent, IInAppLifecycleService _lifecycle, IApplicationService _applicationService, IInAppMessagePromptFactory _promptFactory) {
        k.e(message, "message");
        k.e(activity, "activity");
        k.e(messageContent, "messageContent");
        k.e(_lifecycle, "_lifecycle");
        k.e(_applicationService, "_applicationService");
        k.e(_promptFactory, "_promptFactory");
        this.message = message;
        this.activity = activity;
        this.messageContent = messageContent;
        this._lifecycle = _lifecycle;
        this._applicationService = _applicationService;
        this._promptFactory = _promptFactory;
        this.messageViewMutex = d.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object calculateHeightAndShowWebViewAfterNewActivity(v5.c<? super q5.x> r9) throws java.lang.Throwable {
        /*
            r8 = this;
            boolean r0 = r9 instanceof com.onesignal.inAppMessages.internal.display.impl.WebViewManager.C27401
            if (r0 == 0) goto L13
            r0 = r9
            com.onesignal.inAppMessages.internal.display.impl.WebViewManager$calculateHeightAndShowWebViewAfterNewActivity$1 r0 = (com.onesignal.inAppMessages.internal.display.impl.WebViewManager.C27401) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.onesignal.inAppMessages.internal.display.impl.WebViewManager$calculateHeightAndShowWebViewAfterNewActivity$1 r0 = new com.onesignal.inAppMessages.internal.display.impl.WebViewManager$calculateHeightAndShowWebViewAfterNewActivity$1
            r0.<init>(r9)
        L18:
            java.lang.Object r9 = r0.result
            w5.a r1 = w5.a.f17774a
            int r2 = r0.label
            r3 = 3
            r4 = 1
            q5.x r5 = q5.x.f13520a
            r6 = 2
            if (r2 == 0) goto L47
            if (r2 == r4) goto L43
            if (r2 == r6) goto L3b
            if (r2 != r3) goto L33
            java.lang.Object r0 = r0.L$0
            com.onesignal.inAppMessages.internal.display.impl.WebViewManager r0 = (com.onesignal.inAppMessages.internal.display.impl.WebViewManager) r0
            r2.q.z0(r9)
            goto L96
        L33:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L3b:
            java.lang.Object r2 = r0.L$0
            com.onesignal.inAppMessages.internal.display.impl.WebViewManager r2 = (com.onesignal.inAppMessages.internal.display.impl.WebViewManager) r2
            r2.q.z0(r9)
            goto L7d
        L43:
            r2.q.z0(r9)
            return r5
        L47:
            r2.q.z0(r9)
            com.onesignal.inAppMessages.internal.display.impl.InAppMessageView r9 = r8.messageView
            if (r9 != 0) goto L4f
            goto L69
        L4f:
            com.onesignal.inAppMessages.internal.display.impl.WebViewManager$Position r9 = r9.getDisplayPosition()
            com.onesignal.inAppMessages.internal.display.impl.WebViewManager$Position r2 = com.onesignal.inAppMessages.internal.display.impl.WebViewManager.Position.FULL_SCREEN
            r7 = 0
            if (r9 != r2) goto L6a
            com.onesignal.inAppMessages.internal.InAppMessageContent r9 = r8.messageContent
            boolean r9 = r9.isFullBleed()
            if (r9 != 0) goto L6a
            r0.label = r4
            java.lang.Object r9 = r8.showMessageView(r7, r0)
            if (r9 != r1) goto L69
            goto L94
        L69:
            return r5
        L6a:
            java.lang.String r9 = "In app message new activity, calculate height and show "
            com.onesignal.debug.internal.logging.Logging.debug$default(r9, r7, r6, r7)
            com.onesignal.core.internal.application.IApplicationService r9 = r8._applicationService
            r0.L$0 = r8
            r0.label = r6
            java.lang.Object r9 = r9.waitUntilActivityReady(r0)
            if (r9 != r1) goto L7c
            goto L94
        L7c:
            r2 = r8
        L7d:
            android.app.Activity r9 = r2.activity
            r2.setWebViewToMaxSize(r9)
            com.onesignal.inAppMessages.internal.InAppMessageContent r9 = r2.messageContent
            boolean r9 = r9.isFullBleed()
            if (r9 == 0) goto L97
            r0.L$0 = r2
            r0.label = r3
            java.lang.Object r9 = r2.updateSafeAreaInsets(r0)
            if (r9 != r1) goto L95
        L94:
            return r1
        L95:
            r0 = r2
        L96:
            r2 = r0
        L97:
            com.onesignal.inAppMessages.internal.display.impl.OSWebView r9 = r2.webView
            kotlin.jvm.internal.k.b(r9)
            com.onesignal.inAppMessages.internal.display.impl.b r0 = new com.onesignal.inAppMessages.internal.display.impl.b
            r0.<init>()
            java.lang.String r1 = "getPageMetaData()"
            r9.evaluateJavascript(r1, r0)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.inAppMessages.internal.display.impl.WebViewManager.calculateHeightAndShowWebViewAfterNewActivity(v5.c):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: calculateHeightAndShowWebViewAfterNewActivity$lambda-0, reason: not valid java name */
    public static final void m3156calculateHeightAndShowWebViewAfterNewActivity$lambda0(WebViewManager this$0, String str) {
        k.e(this$0, "this$0");
        try {
            ThreadUtilsKt.suspendifyOnThread$default(0, new WebViewManager$calculateHeightAndShowWebViewAfterNewActivity$2$1(this$0, this$0.pageRectToViewHeight(this$0.activity, new JSONObject(str)), null), 1, null);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private final void enableWebViewRemoteDebugging() {
        if (Logging.atLogLevel(LogLevel.DEBUG)) {
            WebView.setWebContentsDebuggingEnabled(true);
        }
    }

    private final int getWebViewMaxSizeX(Activity activity) {
        if (this.messageContent.isFullBleed()) {
            return ViewUtils.INSTANCE.getFullbleedWindowWidth(activity);
        }
        return ViewUtils.INSTANCE.getWindowWidth(activity) - (MARGIN_PX_SIZE * 2);
    }

    private final int getWebViewMaxSizeY(Activity activity) {
        return ViewUtils.INSTANCE.getWindowHeight(activity) - (this.messageContent.isFullBleed() ? 0 : MARGIN_PX_SIZE * 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int pageRectToViewHeight(Activity activity, JSONObject jSONObject) {
        try {
            int iDpToPx = ViewUtils.INSTANCE.dpToPx(jSONObject.getJSONObject("rect").getInt("height"));
            Logging.debug$default("getPageHeightData:pxHeight: " + iDpToPx, null, 2, null);
            int webViewMaxSizeY = getWebViewMaxSizeY(activity);
            if (iDpToPx <= webViewMaxSizeY) {
                return iDpToPx;
            }
            Logging.debug$default("getPageHeightData:pxHeight is over screen max: " + webViewMaxSizeY, null, 2, null);
            return webViewMaxSizeY;
        } catch (JSONException e) {
            Logging.error("pageRectToViewHeight could not get page height", e);
            return -1;
        }
    }

    private final void setMessageView(InAppMessageView inAppMessageView) {
        this.messageView = inAppMessageView;
    }

    private final void setWebViewToMaxSize(Activity activity) {
        OSWebView oSWebView = this.webView;
        k.b(oSWebView);
        oSWebView.layout(0, 0, getWebViewMaxSizeX(activity), getWebViewMaxSizeY(activity));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00f3, code lost:
    
        if (r12.checkIfShouldDismiss(r1) == r2) goto L56;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00d2 A[Catch: all -> 0x0039, TryCatch #0 {all -> 0x0039, blocks: (B:15:0x0035, B:22:0x004c, B:52:0x00e3, B:54:0x00e7, B:25:0x0059, B:47:0x00ce, B:49:0x00d2, B:32:0x0088, B:34:0x008c, B:37:0x0097, B:39:0x00aa, B:41:0x00b4, B:43:0x00ba), top: B:60:0x0027 }] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00e7 A[Catch: all -> 0x0039, TRY_LEAVE, TryCatch #0 {all -> 0x0039, blocks: (B:15:0x0035, B:22:0x004c, B:52:0x00e3, B:54:0x00e7, B:25:0x0059, B:47:0x00ce, B:49:0x00d2, B:32:0x0088, B:34:0x008c, B:37:0x0097, B:39:0x00aa, B:41:0x00b4, B:43:0x00ba), top: B:60:0x0027 }] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object showMessageView(java.lang.Integer r11, v5.c<? super q5.x> r12) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 254
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.inAppMessages.internal.display.impl.WebViewManager.showMessageView(java.lang.Integer, v5.c):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object updateSafeAreaInsets(c<? super x> cVar) throws Throwable {
        x6.e eVar = m0.f13566a;
        Object objH = c0.H(new AnonymousClass2(null), n.f17641a, cVar);
        return objH == w5.a.f17774a ? objH : x.f13520a;
    }

    public final void backgroundDismissAndAwaitNextMessage() {
        ThreadUtilsKt.suspendifyOnThread$default(0, new AnonymousClass1(null), 1, null);
    }

    public final void createNewInAppMessageView(boolean z2) {
        this.lastPageHeight = Integer.valueOf(this.messageContent.getPageHeight());
        boolean manifestMetaBoolean = AndroidUtils.INSTANCE.getManifestMetaBoolean(this._applicationService.getAppContext(), "com.onesignal.inAppMessageHideGrayOverlay");
        OSWebView oSWebView = this.webView;
        k.b(oSWebView);
        setMessageView(new InAppMessageView(oSWebView, this.messageContent, z2, manifestMetaBoolean));
        InAppMessageView inAppMessageView = this.messageView;
        k.b(inAppMessageView);
        inAppMessageView.setMessageController(new InAppMessageView.InAppMessageViewListener() { // from class: com.onesignal.inAppMessages.internal.display.impl.WebViewManager.createNewInAppMessageView.1
            @Override // com.onesignal.inAppMessages.internal.display.impl.InAppMessageView.InAppMessageViewListener
            public void onMessageWasDismissed() {
                WebViewManager.this._lifecycle.messageWasDismissed(WebViewManager.this.message);
                WebViewManager.this._applicationService.removeActivityLifecycleHandler(this);
            }

            @Override // com.onesignal.inAppMessages.internal.display.impl.InAppMessageView.InAppMessageViewListener
            public void onMessageWasDisplayed() {
                WebViewManager.this._lifecycle.messageWasDisplayed(WebViewManager.this.message);
            }

            @Override // com.onesignal.inAppMessages.internal.display.impl.InAppMessageView.InAppMessageViewListener
            public void onMessageWillDismiss() {
                WebViewManager.this._lifecycle.messageWillDismiss(WebViewManager.this.message);
            }
        });
        this._applicationService.addActivityLifecycleHandler(this);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object dismissAndAwaitNextMessage(v5.c<? super q5.x> r7) throws java.lang.Throwable {
        /*
            r6 = this;
            boolean r0 = r7 instanceof com.onesignal.inAppMessages.internal.display.impl.WebViewManager.C27421
            if (r0 == 0) goto L13
            r0 = r7
            com.onesignal.inAppMessages.internal.display.impl.WebViewManager$dismissAndAwaitNextMessage$1 r0 = (com.onesignal.inAppMessages.internal.display.impl.WebViewManager.C27421) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.onesignal.inAppMessages.internal.display.impl.WebViewManager$dismissAndAwaitNextMessage$1 r0 = new com.onesignal.inAppMessages.internal.display.impl.WebViewManager$dismissAndAwaitNextMessage$1
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.result
            w5.a r1 = w5.a.f17774a
            int r2 = r0.label
            q5.x r3 = q5.x.f13520a
            r4 = 1
            if (r2 == 0) goto L35
            if (r2 != r4) goto L2d
            java.lang.Object r0 = r0.L$0
            com.onesignal.inAppMessages.internal.display.impl.WebViewManager r0 = (com.onesignal.inAppMessages.internal.display.impl.WebViewManager) r0
            r2.q.z0(r7)
            goto L56
        L2d:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L35:
            r2.q.z0(r7)
            com.onesignal.inAppMessages.internal.display.impl.InAppMessageView r7 = r6.messageView
            if (r7 == 0) goto L5d
            boolean r2 = r6.dismissFired
            if (r2 == 0) goto L41
            goto L5d
        L41:
            r6.dismissFired = r4
            com.onesignal.inAppMessages.internal.lifecycle.IInAppLifecycleService r2 = r6._lifecycle
            com.onesignal.inAppMessages.internal.InAppMessage r5 = r6.message
            r2.messageWillDismiss(r5)
            r0.L$0 = r6
            r0.label = r4
            java.lang.Object r7 = r7.dismissAndAwaitNextMessage(r0)
            if (r7 != r1) goto L55
            return r1
        L55:
            r0 = r6
        L56:
            r7 = 0
            r0.dismissFired = r7
            r7 = 0
            r0.setMessageView(r7)
        L5d:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.inAppMessages.internal.display.impl.WebViewManager.dismissAndAwaitNextMessage(v5.c):java.lang.Object");
    }

    @Override // com.onesignal.core.internal.application.IActivityLifecycleHandler
    public void onActivityAvailable(Activity activity) {
        k.e(activity, "activity");
        String str = this.currentActivityName;
        this.activity = activity;
        this.currentActivityName = activity.getLocalClassName();
        Logging.debug$default(a1.a.s(new StringBuilder("In app message activity available currentActivityName: "), this.currentActivityName, " lastActivityName: ", str), null, 2, null);
        ThreadUtilsKt.suspendifyOnMain(new C27431(str, this, null));
    }

    @Override // com.onesignal.core.internal.application.IActivityLifecycleHandler
    public void onActivityStopped(Activity activity) {
        k.e(activity, "activity");
        Logging.debug$default(n6.n.b0("\n            In app message activity stopped, cleaning views, currentActivityName: " + this.currentActivityName + "\n            activity: " + this.activity + "\n            messageView: " + this.messageView + "\n            "), null, 2, null);
        if (this.messageView == null || !k.a(activity.getLocalClassName(), this.currentActivityName)) {
            return;
        }
        InAppMessageView inAppMessageView = this.messageView;
        k.b(inAppMessageView);
        inAppMessageView.removeAllViews();
    }

    public final void setContentSafeAreaInsets(InAppMessageContent content, Activity activity) {
        k.e(content, "content");
        k.e(activity, "activity");
        String contentHtml = content.getContentHtml();
        int[] cutoutAndStatusBarInsets = ViewUtils.INSTANCE.getCutoutAndStatusBarInsets(activity);
        content.setContentHtml(contentHtml + String.format(SET_SAFE_AREA_INSETS_SCRIPT, Arrays.copyOf(new Object[]{String.format(SAFE_AREA_JS_OBJECT, Arrays.copyOf(new Object[]{Integer.valueOf(cutoutAndStatusBarInsets[0]), Integer.valueOf(cutoutAndStatusBarInsets[1]), Integer.valueOf(cutoutAndStatusBarInsets[2]), Integer.valueOf(cutoutAndStatusBarInsets[3])}, 4))}, 1)));
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object setupWebView(android.app.Activity r7, java.lang.String r8, boolean r9, v5.c<? super q5.x> r10) throws java.lang.Throwable {
        /*
            r6 = this;
            boolean r0 = r10 instanceof com.onesignal.inAppMessages.internal.display.impl.WebViewManager.C27441
            if (r0 == 0) goto L13
            r0 = r10
            com.onesignal.inAppMessages.internal.display.impl.WebViewManager$setupWebView$1 r0 = (com.onesignal.inAppMessages.internal.display.impl.WebViewManager.C27441) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.onesignal.inAppMessages.internal.display.impl.WebViewManager$setupWebView$1 r0 = new com.onesignal.inAppMessages.internal.display.impl.WebViewManager$setupWebView$1
            r0.<init>(r10)
        L18:
            java.lang.Object r10 = r0.result
            w5.a r1 = w5.a.f17774a
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3d
            if (r2 != r3) goto L35
            java.lang.Object r7 = r0.L$2
            r8 = r7
            java.lang.String r8 = (java.lang.String) r8
            java.lang.Object r7 = r0.L$1
            android.app.Activity r7 = (android.app.Activity) r7
            java.lang.Object r9 = r0.L$0
            com.onesignal.inAppMessages.internal.display.impl.WebViewManager r9 = (com.onesignal.inAppMessages.internal.display.impl.WebViewManager) r9
            r2.q.z0(r10)
            goto Lad
        L35:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L3d:
            r2.q.z0(r10)
            r6.enableWebViewRemoteDebugging()
            com.onesignal.inAppMessages.internal.display.impl.OSWebView r10 = new com.onesignal.inAppMessages.internal.display.impl.OSWebView
            r10.<init>(r7)
            r6.webView = r10
            r2 = 2
            r10.setOverScrollMode(r2)
            com.onesignal.inAppMessages.internal.display.impl.OSWebView r10 = r6.webView
            kotlin.jvm.internal.k.b(r10)
            r2 = 0
            r10.setVerticalScrollBarEnabled(r2)
            com.onesignal.inAppMessages.internal.display.impl.OSWebView r10 = r6.webView
            kotlin.jvm.internal.k.b(r10)
            r10.setHorizontalScrollBarEnabled(r2)
            com.onesignal.inAppMessages.internal.display.impl.OSWebView r10 = r6.webView
            kotlin.jvm.internal.k.b(r10)
            android.webkit.WebSettings r10 = r10.getSettings()
            r10.setJavaScriptEnabled(r3)
            com.onesignal.inAppMessages.internal.display.impl.OSWebView r10 = r6.webView
            kotlin.jvm.internal.k.b(r10)
            com.onesignal.inAppMessages.internal.display.impl.WebViewManager$OSJavaScriptInterface r4 = new com.onesignal.inAppMessages.internal.display.impl.WebViewManager$OSJavaScriptInterface
            r4.<init>()
            java.lang.String r5 = "OSAndroid"
            r10.addJavascriptInterface(r4, r5)
            if (r9 == 0) goto L94
            com.onesignal.inAppMessages.internal.display.impl.OSWebView r9 = r6.webView
            kotlin.jvm.internal.k.b(r9)
            r10 = 3074(0xc02, float:4.308E-42)
            r9.setSystemUiVisibility(r10)
            int r9 = android.os.Build.VERSION.SDK_INT
            r10 = 30
            if (r9 < r10) goto L94
            com.onesignal.inAppMessages.internal.display.impl.OSWebView r9 = r6.webView
            kotlin.jvm.internal.k.b(r9)
            r9.setFitsSystemWindows(r2)
        L94:
            com.onesignal.inAppMessages.internal.lifecycle.IInAppLifecycleService r9 = r6._lifecycle
            com.onesignal.inAppMessages.internal.InAppMessage r10 = r6.message
            r9.messageWillDisplay(r10)
            com.onesignal.core.internal.application.IApplicationService r9 = r6._applicationService
            r0.L$0 = r6
            r0.L$1 = r7
            r0.L$2 = r8
            r0.label = r3
            java.lang.Object r9 = r9.waitUntilActivityReady(r0)
            if (r9 != r1) goto Lac
            return r1
        Lac:
            r9 = r6
        Lad:
            r9.setWebViewToMaxSize(r7)
            com.onesignal.inAppMessages.internal.display.impl.OSWebView r7 = r9.webView
            kotlin.jvm.internal.k.b(r7)
            java.lang.String r9 = "text/html; charset=utf-8"
            java.lang.String r10 = "base64"
            r7.loadData(r8, r9, r10)
            q5.x r7 = q5.x.f13520a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.inAppMessages.internal.display.impl.WebViewManager.setupWebView(android.app.Activity, java.lang.String, boolean, v5.c):java.lang.Object");
    }
}
