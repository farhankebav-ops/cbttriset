package com.unity3d.ads.adplayer;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.WebView;
import androidx.activity.ComponentActivity;
import androidx.lifecycle.LifecycleOwnerKt;
import com.unity3d.ads.adplayer.DisplayMessage;
import com.unity3d.ads.core.data.model.AdObject;
import com.unity3d.ads.core.domain.SendDiagnosticEvent;
import com.unity3d.ads.core.extensions.JSONObjectExtensionsKt;
import com.unity3d.services.core.di.IServiceComponent;
import com.unity3d.services.core.di.IServiceProvider;
import com.unity3d.services.core.domain.ISDKDispatchers;
import com.vungle.ads.internal.protos.Sdk;
import e6.p;
import java.util.Map;
import java.util.concurrent.CancellationException;
import kotlin.jvm.internal.k;
import n7.b;
import org.json.JSONObject;
import q5.f;
import q5.g;
import q5.j;
import q5.x;
import q6.a0;
import q6.c0;
import q6.l;
import r2.q;
import t6.p0;
import t6.x0;
import v5.c;
import w5.a;
import x5.e;
import x5.i;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class FullScreenWebViewDisplay extends ComponentActivity implements IServiceComponent {
    private final f adObject$delegate;
    private final f dispatchers$delegate;
    private String opportunityId = "";
    private final f sendDiagnosticEvent$delegate;
    private Map<String, ? extends Object> showOptions;

    /* JADX INFO: renamed from: com.unity3d.ads.adplayer.FullScreenWebViewDisplay$loadWebView$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.unity3d.ads.adplayer.FullScreenWebViewDisplay$loadWebView$1", f = "FullScreenWebViewDisplay.kt", l = {}, m = "invokeSuspend")
    public static final class AnonymousClass1 extends i implements p {
        final /* synthetic */ WebView $webView;
        int label;
        final /* synthetic */ FullScreenWebViewDisplay this$0;

        /* JADX INFO: renamed from: com.unity3d.ads.adplayer.FullScreenWebViewDisplay$loadWebView$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        @e(c = "com.unity3d.ads.adplayer.FullScreenWebViewDisplay$loadWebView$1$1", f = "FullScreenWebViewDisplay.kt", l = {Sdk.SDKError.Reason.INVALID_METRICS_ENDPOINT_VALUE}, m = "invokeSuspend")
        public static final class C02121 extends i implements p {
            int label;
            final /* synthetic */ FullScreenWebViewDisplay this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C02121(FullScreenWebViewDisplay fullScreenWebViewDisplay, c<? super C02121> cVar) {
                super(2, cVar);
                this.this$0 = fullScreenWebViewDisplay;
            }

            @Override // x5.a
            public final c<x> create(Object obj, c<?> cVar) {
                return new C02121(this.this$0, cVar);
            }

            @Override // x5.a
            public final Object invokeSuspend(Object obj) throws Throwable {
                a aVar = a.f17774a;
                int i2 = this.label;
                if (i2 == 0) {
                    q.z0(obj);
                    p0 displayMessages = AndroidFullscreenWebViewAdPlayer.Companion.getDisplayMessages();
                    DisplayMessage.DisplayReady displayReady = new DisplayMessage.DisplayReady(this.this$0.opportunityId, this.this$0.showOptions);
                    this.label = 1;
                    if (displayMessages.emit(displayReady, this) == aVar) {
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

            @Override // e6.p
            public final Object invoke(a0 a0Var, c<? super x> cVar) {
                return ((C02121) create(a0Var, cVar)).invokeSuspend(x.f13520a);
            }
        }

        /* JADX INFO: renamed from: com.unity3d.ads.adplayer.FullScreenWebViewDisplay$loadWebView$1$2, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        @e(c = "com.unity3d.ads.adplayer.FullScreenWebViewDisplay$loadWebView$1$2", f = "FullScreenWebViewDisplay.kt", l = {Sdk.SDKError.Reason.MRAID_JS_WRITE_FAILED_VALUE}, m = "invokeSuspend")
        public static final class AnonymousClass2 extends i implements p {
            int label;
            final /* synthetic */ FullScreenWebViewDisplay this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass2(FullScreenWebViewDisplay fullScreenWebViewDisplay, c<? super AnonymousClass2> cVar) {
                super(2, cVar);
                this.this$0 = fullScreenWebViewDisplay;
            }

            @Override // x5.a
            public final c<x> create(Object obj, c<?> cVar) {
                return new AnonymousClass2(this.this$0, cVar);
            }

            @Override // x5.a
            public final Object invokeSuspend(Object obj) throws Throwable {
                a aVar = a.f17774a;
                int i2 = this.label;
                if (i2 == 0) {
                    q.z0(obj);
                    p0 displayMessages = AndroidFullscreenWebViewAdPlayer.Companion.getDisplayMessages();
                    DisplayMessage.DisplayError displayError = new DisplayMessage.DisplayError(this.this$0.opportunityId, "WebView failed to attach to FullScreenWebViewDisplay.");
                    this.label = 1;
                    if (displayMessages.emit(displayError, this) == aVar) {
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

            @Override // e6.p
            public final Object invoke(a0 a0Var, c<? super x> cVar) {
                return ((AnonymousClass2) create(a0Var, cVar)).invokeSuspend(x.f13520a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(WebView webView, FullScreenWebViewDisplay fullScreenWebViewDisplay, c<? super AnonymousClass1> cVar) {
            super(2, cVar);
            this.$webView = webView;
            this.this$0 = fullScreenWebViewDisplay;
        }

        @Override // x5.a
        public final c<x> create(Object obj, c<?> cVar) {
            return new AnonymousClass1(this.$webView, this.this$0, cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            x xVar = x.f13520a;
            a aVar = a.f17774a;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            q.z0(obj);
            try {
                ViewParent parent = this.$webView.getParent();
                ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
                if (viewGroup != null) {
                    viewGroup.removeView(this.$webView);
                }
                this.this$0.setContentView(this.$webView);
                c0.u(c0.b(this.this$0.getDispatchers().getDefault()), null, new C02121(this.this$0, null), 3);
                return xVar;
            } catch (Throwable th) {
                if (th instanceof CancellationException) {
                    return xVar;
                }
                c0.u(c0.b(this.this$0.getDispatchers().getDefault()), null, new AnonymousClass2(this.this$0, null), 3);
                String message = th.getMessage();
                if (message == null) {
                    message = "Unknown";
                }
                SendDiagnosticEvent.DefaultImpls.invoke$default(this.this$0.getSendDiagnosticEvent(), "native_show_ad_viewer_fullscreen_intent_failed_to_attach_webview", null, r5.x.e0(new q5.i("reason", message)), null, this.this$0.getAdObject(), null, 42, null);
                this.this$0.setResult(0);
                this.this$0.finish();
                return xVar;
            }
        }

        @Override // e6.p
        public final Object invoke(a0 a0Var, c<? super x> cVar) {
            return ((AnonymousClass1) create(a0Var, cVar)).invokeSuspend(x.f13520a);
        }
    }

    /* JADX INFO: renamed from: com.unity3d.ads.adplayer.FullScreenWebViewDisplay$onCreate$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.unity3d.ads.adplayer.FullScreenWebViewDisplay$onCreate$1", f = "FullScreenWebViewDisplay.kt", l = {62}, m = "invokeSuspend")
    public static final class C28571 extends i implements p {
        int label;

        public C28571(c<? super C28571> cVar) {
            super(2, cVar);
        }

        @Override // x5.a
        public final c<x> create(Object obj, c<?> cVar) {
            return FullScreenWebViewDisplay.this.new C28571(cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            a aVar = a.f17774a;
            int i2 = this.label;
            if (i2 == 0) {
                q.z0(obj);
                p0 displayMessages = AndroidFullscreenWebViewAdPlayer.Companion.getDisplayMessages();
                DisplayMessage.DisplayError displayError = new DisplayMessage.DisplayError(FullScreenWebViewDisplay.this.opportunityId, "Opportunity ID not found");
                this.label = 1;
                if (displayMessages.emit(displayError, this) == aVar) {
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

        @Override // e6.p
        public final Object invoke(a0 a0Var, c<? super x> cVar) {
            return ((C28571) create(a0Var, cVar)).invokeSuspend(x.f13520a);
        }
    }

    /* JADX INFO: renamed from: com.unity3d.ads.adplayer.FullScreenWebViewDisplay$onCreate$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.unity3d.ads.adplayer.FullScreenWebViewDisplay$onCreate$2", f = "FullScreenWebViewDisplay.kt", l = {75}, m = "invokeSuspend")
    public static final class AnonymousClass2 extends i implements p {
        int label;

        public AnonymousClass2(c<? super AnonymousClass2> cVar) {
            super(2, cVar);
        }

        @Override // x5.a
        public final c<x> create(Object obj, c<?> cVar) {
            return FullScreenWebViewDisplay.this.new AnonymousClass2(cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            a aVar = a.f17774a;
            int i2 = this.label;
            if (i2 == 0) {
                q.z0(obj);
                p0 displayMessages = AndroidFullscreenWebViewAdPlayer.Companion.getDisplayMessages();
                DisplayMessage.DisplayError displayError = new DisplayMessage.DisplayError(FullScreenWebViewDisplay.this.opportunityId, "AdPlayer is not active. Could be because show was called while the app was in background.");
                this.label = 1;
                if (displayMessages.emit(displayError, this) == aVar) {
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

        @Override // e6.p
        public final Object invoke(a0 a0Var, c<? super x> cVar) {
            return ((AnonymousClass2) create(a0Var, cVar)).invokeSuspend(x.f13520a);
        }
    }

    /* JADX INFO: renamed from: com.unity3d.ads.adplayer.FullScreenWebViewDisplay$onCreate$6, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.unity3d.ads.adplayer.FullScreenWebViewDisplay$onCreate$6", f = "FullScreenWebViewDisplay.kt", l = {93}, m = "invokeSuspend")
    public static final class AnonymousClass6 extends i implements p {
        int label;

        public AnonymousClass6(c<? super AnonymousClass6> cVar) {
            super(2, cVar);
        }

        @Override // x5.a
        public final c<x> create(Object obj, c<?> cVar) {
            return FullScreenWebViewDisplay.this.new AnonymousClass6(cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            a aVar = a.f17774a;
            int i2 = this.label;
            if (i2 == 0) {
                q.z0(obj);
                FullScreenWebViewDisplay fullScreenWebViewDisplay = FullScreenWebViewDisplay.this;
                this.label = 1;
                if (fullScreenWebViewDisplay.listenToAdPlayerEvents(this) == aVar) {
                    return aVar;
                }
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                q.z0(obj);
            }
            SendDiagnosticEvent.DefaultImpls.invoke$default(FullScreenWebViewDisplay.this.getSendDiagnosticEvent(), "native_show_ad_viewer_fullscreen_intent_creation_success_time", null, null, null, FullScreenWebViewDisplay.this.getAdObject(), null, 46, null);
            return x.f13520a;
        }

        @Override // e6.p
        public final Object invoke(a0 a0Var, c<? super x> cVar) {
            return ((AnonymousClass6) create(a0Var, cVar)).invokeSuspend(x.f13520a);
        }
    }

    /* JADX INFO: renamed from: com.unity3d.ads.adplayer.FullScreenWebViewDisplay$onDestroy$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.unity3d.ads.adplayer.FullScreenWebViewDisplay$onDestroy$1", f = "FullScreenWebViewDisplay.kt", l = {174}, m = "invokeSuspend")
    public static final class C28581 extends i implements p {
        int label;

        public C28581(c<? super C28581> cVar) {
            super(2, cVar);
        }

        @Override // x5.a
        public final c<x> create(Object obj, c<?> cVar) {
            return FullScreenWebViewDisplay.this.new C28581(cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            a aVar = a.f17774a;
            int i2 = this.label;
            if (i2 == 0) {
                q.z0(obj);
                p0 displayMessages = AndroidFullscreenWebViewAdPlayer.Companion.getDisplayMessages();
                DisplayMessage.DisplayDestroyed displayDestroyed = new DisplayMessage.DisplayDestroyed(FullScreenWebViewDisplay.this.opportunityId);
                this.label = 1;
                if (displayMessages.emit(displayDestroyed, this) == aVar) {
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

        @Override // e6.p
        public final Object invoke(a0 a0Var, c<? super x> cVar) {
            return ((C28581) create(a0Var, cVar)).invokeSuspend(x.f13520a);
        }
    }

    /* JADX INFO: renamed from: com.unity3d.ads.adplayer.FullScreenWebViewDisplay$onPause$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.unity3d.ads.adplayer.FullScreenWebViewDisplay$onPause$1", f = "FullScreenWebViewDisplay.kt", l = {158}, m = "invokeSuspend")
    public static final class C28591 extends i implements p {
        int label;

        public C28591(c<? super C28591> cVar) {
            super(2, cVar);
        }

        @Override // x5.a
        public final c<x> create(Object obj, c<?> cVar) {
            return FullScreenWebViewDisplay.this.new C28591(cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            a aVar = a.f17774a;
            int i2 = this.label;
            if (i2 == 0) {
                q.z0(obj);
                p0 displayMessages = AndroidFullscreenWebViewAdPlayer.Companion.getDisplayMessages();
                DisplayMessage.VisibilityChanged visibilityChanged = new DisplayMessage.VisibilityChanged(FullScreenWebViewDisplay.this.opportunityId, false);
                this.label = 1;
                if (displayMessages.emit(visibilityChanged, this) == aVar) {
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

        @Override // e6.p
        public final Object invoke(a0 a0Var, c<? super x> cVar) {
            return ((C28591) create(a0Var, cVar)).invokeSuspend(x.f13520a);
        }
    }

    /* JADX INFO: renamed from: com.unity3d.ads.adplayer.FullScreenWebViewDisplay$onPause$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.unity3d.ads.adplayer.FullScreenWebViewDisplay$onPause$2", f = "FullScreenWebViewDisplay.kt", l = {163}, m = "invokeSuspend")
    public static final class C28602 extends i implements p {
        int label;

        public C28602(c<? super C28602> cVar) {
            super(2, cVar);
        }

        @Override // x5.a
        public final c<x> create(Object obj, c<?> cVar) {
            return FullScreenWebViewDisplay.this.new C28602(cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            a aVar = a.f17774a;
            int i2 = this.label;
            if (i2 == 0) {
                q.z0(obj);
                p0 displayMessages = AndroidFullscreenWebViewAdPlayer.Companion.getDisplayMessages();
                DisplayMessage.DisplayDestroyed displayDestroyed = new DisplayMessage.DisplayDestroyed(FullScreenWebViewDisplay.this.opportunityId);
                this.label = 1;
                if (displayMessages.emit(displayDestroyed, this) == aVar) {
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

        @Override // e6.p
        public final Object invoke(a0 a0Var, c<? super x> cVar) {
            return ((C28602) create(a0Var, cVar)).invokeSuspend(x.f13520a);
        }
    }

    /* JADX INFO: renamed from: com.unity3d.ads.adplayer.FullScreenWebViewDisplay$onResume$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.unity3d.ads.adplayer.FullScreenWebViewDisplay$onResume$1", f = "FullScreenWebViewDisplay.kt", l = {150}, m = "invokeSuspend")
    public static final class C28611 extends i implements p {
        int label;

        public C28611(c<? super C28611> cVar) {
            super(2, cVar);
        }

        @Override // x5.a
        public final c<x> create(Object obj, c<?> cVar) {
            return FullScreenWebViewDisplay.this.new C28611(cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            a aVar = a.f17774a;
            int i2 = this.label;
            if (i2 == 0) {
                q.z0(obj);
                p0 displayMessages = AndroidFullscreenWebViewAdPlayer.Companion.getDisplayMessages();
                DisplayMessage.VisibilityChanged visibilityChanged = new DisplayMessage.VisibilityChanged(FullScreenWebViewDisplay.this.opportunityId, true);
                this.label = 1;
                if (displayMessages.emit(visibilityChanged, this) == aVar) {
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

        @Override // e6.p
        public final Object invoke(a0 a0Var, c<? super x> cVar) {
            return ((C28611) create(a0Var, cVar)).invokeSuspend(x.f13520a);
        }
    }

    /* JADX INFO: renamed from: com.unity3d.ads.adplayer.FullScreenWebViewDisplay$onWindowFocusChanged$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.unity3d.ads.adplayer.FullScreenWebViewDisplay$onWindowFocusChanged$1", f = "FullScreenWebViewDisplay.kt", l = {186}, m = "invokeSuspend")
    public static final class C28621 extends i implements p {
        final /* synthetic */ boolean $hasFocus;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C28621(boolean z2, c<? super C28621> cVar) {
            super(2, cVar);
            this.$hasFocus = z2;
        }

        @Override // x5.a
        public final c<x> create(Object obj, c<?> cVar) {
            return FullScreenWebViewDisplay.this.new C28621(this.$hasFocus, cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            a aVar = a.f17774a;
            int i2 = this.label;
            if (i2 == 0) {
                q.z0(obj);
                p0 displayMessages = AndroidFullscreenWebViewAdPlayer.Companion.getDisplayMessages();
                DisplayMessage.FocusChanged focusChanged = new DisplayMessage.FocusChanged(FullScreenWebViewDisplay.this.opportunityId, this.$hasFocus);
                this.label = 1;
                if (displayMessages.emit(focusChanged, this) == aVar) {
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

        @Override // e6.p
        public final Object invoke(a0 a0Var, c<? super x> cVar) {
            return ((C28621) create(a0Var, cVar)).invokeSuspend(x.f13520a);
        }
    }

    public FullScreenWebViewDisplay() {
        g gVar = g.f13496c;
        this.sendDiagnosticEvent$delegate = b.B(gVar, new FullScreenWebViewDisplay$special$$inlined$inject$default$1(this, ""));
        this.adObject$delegate = b.C(new FullScreenWebViewDisplay$adObject$2(this));
        this.dispatchers$delegate = b.B(gVar, new FullScreenWebViewDisplay$special$$inlined$inject$default$2(this, ""));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AdObject getAdObject() {
        return (AdObject) this.adObject$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ISDKDispatchers getDispatchers() {
        return (ISDKDispatchers) this.dispatchers$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SendDiagnosticEvent getSendDiagnosticEvent() {
        return (SendDiagnosticEvent) this.sendDiagnosticEvent$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object listenToAdPlayerEvents(c<? super x> cVar) {
        l lVar = new l(1, a.a.I(cVar));
        lVar.r();
        final android.support.v4.media.g gVar = new android.support.v4.media.g(AndroidFullscreenWebViewAdPlayer.Companion.getDisplayMessages(), new FullScreenWebViewDisplay$listenToAdPlayerEvents$2$1(this, lVar, null));
        x0.o(new android.support.v4.media.g(24, new t6.e() { // from class: com.unity3d.ads.adplayer.FullScreenWebViewDisplay$listenToAdPlayerEvents$lambda$5$$inlined$filter$1

            /* JADX INFO: renamed from: com.unity3d.ads.adplayer.FullScreenWebViewDisplay$listenToAdPlayerEvents$lambda$5$$inlined$filter$1$2, reason: invalid class name */
            /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
            public static final class AnonymousClass2<T> implements t6.f {
                final /* synthetic */ t6.f $this_unsafeFlow;
                final /* synthetic */ FullScreenWebViewDisplay this$0;

                /* JADX INFO: renamed from: com.unity3d.ads.adplayer.FullScreenWebViewDisplay$listenToAdPlayerEvents$lambda$5$$inlined$filter$1$2$1, reason: invalid class name */
                /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
                @e(c = "com.unity3d.ads.adplayer.FullScreenWebViewDisplay$listenToAdPlayerEvents$lambda$5$$inlined$filter$1$2", f = "FullScreenWebViewDisplay.kt", l = {Sdk.SDKError.Reason.STALE_CACHED_RESPONSE_VALUE}, m = "emit")
                public static final class AnonymousClass1 extends x5.c {
                    Object L$0;
                    Object L$1;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(c cVar) {
                        super(cVar);
                    }

                    @Override // x5.a
                    public final Object invokeSuspend(Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(t6.f fVar, FullScreenWebViewDisplay fullScreenWebViewDisplay) {
                    this.$this_unsafeFlow = fVar;
                    this.this$0 = fullScreenWebViewDisplay;
                }

                /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                @Override // t6.f
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final java.lang.Object emit(java.lang.Object r6, v5.c r7) throws java.lang.Throwable {
                    /*
                        r5 = this;
                        boolean r0 = r7 instanceof com.unity3d.ads.adplayer.FullScreenWebViewDisplay$listenToAdPlayerEvents$lambda$5$$inlined$filter$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r7
                        com.unity3d.ads.adplayer.FullScreenWebViewDisplay$listenToAdPlayerEvents$lambda$5$$inlined$filter$1$2$1 r0 = (com.unity3d.ads.adplayer.FullScreenWebViewDisplay$listenToAdPlayerEvents$lambda$5$$inlined$filter$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.label = r1
                        goto L18
                    L13:
                        com.unity3d.ads.adplayer.FullScreenWebViewDisplay$listenToAdPlayerEvents$lambda$5$$inlined$filter$1$2$1 r0 = new com.unity3d.ads.adplayer.FullScreenWebViewDisplay$listenToAdPlayerEvents$lambda$5$$inlined$filter$1$2$1
                        r0.<init>(r7)
                    L18:
                        java.lang.Object r7 = r0.result
                        w5.a r1 = w5.a.f17774a
                        int r2 = r0.label
                        r3 = 1
                        if (r2 == 0) goto L2f
                        if (r2 != r3) goto L27
                        r2.q.z0(r7)
                        goto L50
                    L27:
                        java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                        java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                        r6.<init>(r7)
                        throw r6
                    L2f:
                        r2.q.z0(r7)
                        t6.f r7 = r5.$this_unsafeFlow
                        r2 = r6
                        com.unity3d.ads.adplayer.DisplayMessage r2 = (com.unity3d.ads.adplayer.DisplayMessage) r2
                        java.lang.String r2 = r2.getOpportunityId()
                        com.unity3d.ads.adplayer.FullScreenWebViewDisplay r4 = r5.this$0
                        java.lang.String r4 = com.unity3d.ads.adplayer.FullScreenWebViewDisplay.access$getOpportunityId$p(r4)
                        boolean r2 = kotlin.jvm.internal.k.a(r2, r4)
                        if (r2 == 0) goto L50
                        r0.label = r3
                        java.lang.Object r6 = r7.emit(r6, r0)
                        if (r6 != r1) goto L50
                        return r1
                    L50:
                        q5.x r6 = q5.x.f13520a
                        return r6
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.unity3d.ads.adplayer.FullScreenWebViewDisplay$listenToAdPlayerEvents$lambda$5$$inlined$filter$1.AnonymousClass2.emit(java.lang.Object, v5.c):java.lang.Object");
                }
            }

            @Override // t6.e
            public Object collect(t6.f fVar, c cVar2) {
                Object objCollect = gVar.collect(new AnonymousClass2(fVar, this), cVar2);
                return objCollect == a.f17774a ? objCollect : x.f13520a;
            }
        }, new FullScreenWebViewDisplay$listenToAdPlayerEvents$2$3(this, null)), LifecycleOwnerKt.getLifecycleScope(this));
        Object objP = lVar.p();
        return objP == a.f17774a ? objP : x.f13520a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void loadWebView(WebView webView) {
        c0.u(c0.b(getDispatchers().getMain()), null, new AnonymousClass1(webView, this, null), 3);
    }

    @Override // com.unity3d.services.core.di.IServiceComponent
    public IServiceProvider getServiceProvider() {
        return IServiceComponent.DefaultImpls.getServiceProvider(this);
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        a0 scope;
        Object objM;
        Map<String, ? extends Object> map;
        super.onCreate(bundle);
        String stringExtra = getIntent().getStringExtra("opportunityId");
        if (stringExtra == null) {
            stringExtra = "not_provided";
        }
        this.opportunityId = stringExtra;
        SendDiagnosticEvent.DefaultImpls.invoke$default(getSendDiagnosticEvent(), "native_show_ad_viewer_fullscreen_intent_creation_starts", null, r5.x.e0(new q5.i("intentOpportunityId", this.opportunityId)), null, getAdObject(), null, 42, null);
        if (k.a(this.opportunityId, "not_provided")) {
            setResult(0);
            c0.u(c0.b(getDispatchers().getDefault()), null, new C28571(null), 3);
            SendDiagnosticEvent.DefaultImpls.invoke$default(getSendDiagnosticEvent(), "native_show_ad_viewer_fullscreen_intent_creation_fails", null, r5.x.e0(new q5.i("reason_debug", "no_opportunity_id")), null, null, null, 58, null);
            finish();
            return;
        }
        AdObject adObject = getAdObject();
        AdPlayer adPlayer = adObject != null ? adObject.getAdPlayer() : null;
        if (adPlayer == null || (scope = adPlayer.getScope()) == null || !c0.t(scope)) {
            setResult(0);
            c0.u(c0.b(getDispatchers().getDefault()), null, new AnonymousClass2(null), 3);
            finish();
            SendDiagnosticEvent.DefaultImpls.invoke$default(getSendDiagnosticEvent(), "native_show_ad_viewer_fullscreen_intent_creation_fails", null, r5.x.e0(new q5.i("reason_debug", "ad_player_scope_not_active")), null, null, null, 58, null);
            return;
        }
        boolean zHasExtra = getIntent().hasExtra("orientation");
        Boolean boolValueOf = Boolean.valueOf(zHasExtra);
        if (!zHasExtra) {
            boolValueOf = null;
        }
        if (boolValueOf != null) {
            setRequestedOrientation(getIntent().getIntExtra("orientation", -1));
        }
        String stringExtra2 = getIntent().getStringExtra("showOptions");
        if (stringExtra2 != null) {
            try {
                objM = JSONObjectExtensionsKt.toBuiltInMap(new JSONObject(stringExtra2));
            } catch (Throwable th) {
                objM = q.M(th);
            }
            if (objM instanceof j) {
                objM = null;
            }
            map = (Map) objM;
        } else {
            map = null;
        }
        this.showOptions = map;
        c0.u(LifecycleOwnerKt.getLifecycleScope(this), null, new AnonymousClass6(null), 3);
    }

    @Override // android.app.Activity
    public void onDestroy() {
        SendDiagnosticEvent.DefaultImpls.invoke$default(getSendDiagnosticEvent(), "native_show_ad_viewer_fullscreen_intent_destroyed", null, null, null, getAdObject(), null, 46, null);
        if (isFinishing()) {
            c0.u(c0.b(getDispatchers().getDefault()), null, new C28581(null), 3);
            SendDiagnosticEvent.DefaultImpls.invoke$default(getSendDiagnosticEvent(), "native_show_ad_viewer_fullscreen_intent_finishing_on_destroy", null, null, null, getAdObject(), null, 46, null);
        }
        super.onDestroy();
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        return i2 == 4;
    }

    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        c0.u(c0.b(getDispatchers().getDefault()), null, new C28591(null), 3);
        if (isFinishing()) {
            c0.u(c0.b(getDispatchers().getDefault()), null, new C28602(null), 3);
            SendDiagnosticEvent.DefaultImpls.invoke$default(getSendDiagnosticEvent(), "native_show_ad_viewer_fullscreen_intent_finishing_on_pause", null, null, null, getAdObject(), null, 46, null);
        }
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        c0.u(c0.b(getDispatchers().getDefault()), null, new C28611(null), 3);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z2) {
        super.onWindowFocusChanged(z2);
        c0.u(c0.b(getDispatchers().getDefault()), null, new C28621(z2, null), 3);
    }
}
