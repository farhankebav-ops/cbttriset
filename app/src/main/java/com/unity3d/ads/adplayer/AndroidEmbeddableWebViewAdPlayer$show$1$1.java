package com.unity3d.ads.adplayer;

import com.unity3d.ads.core.data.model.ScarEvent;
import com.unity3d.services.banners.bridge.BannerBridge;
import e6.p;
import java.util.Map;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.j;
import kotlin.jvm.internal.k;
import q5.x;
import q6.a0;
import r2.q;
import t6.f;
import t6.t0;
import v5.c;
import w5.a;
import x5.e;
import x5.i;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
@e(c = "com.unity3d.ads.adplayer.AndroidEmbeddableWebViewAdPlayer$show$1$1", f = "AndroidEmbeddableWebViewAdPlayer.kt", l = {75, 79}, m = "invokeSuspend")
public final class AndroidEmbeddableWebViewAdPlayer$show$1$1 extends i implements p {
    final /* synthetic */ t0 $scarEvents;
    final /* synthetic */ ShowOptions $showOptions;
    int label;
    final /* synthetic */ AndroidEmbeddableWebViewAdPlayer this$0;

    /* JADX INFO: renamed from: com.unity3d.ads.adplayer.AndroidEmbeddableWebViewAdPlayer$show$1$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.unity3d.ads.adplayer.AndroidEmbeddableWebViewAdPlayer$show$1$1$1", f = "AndroidEmbeddableWebViewAdPlayer.kt", l = {73}, m = "invokeSuspend")
    public static final class AnonymousClass1 extends i implements p {
        final /* synthetic */ ShowOptions $showOptions;
        int label;
        final /* synthetic */ AndroidEmbeddableWebViewAdPlayer this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(AndroidEmbeddableWebViewAdPlayer androidEmbeddableWebViewAdPlayer, ShowOptions showOptions, c<? super AnonymousClass1> cVar) {
            super(2, cVar);
            this.this$0 = androidEmbeddableWebViewAdPlayer;
            this.$showOptions = showOptions;
        }

        @Override // x5.a
        public final c<x> create(Object obj, c<?> cVar) {
            return new AnonymousClass1(this.this$0, this.$showOptions, cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            a aVar = a.f17774a;
            int i2 = this.label;
            if (i2 == 0) {
                q.z0(obj);
                WebViewAdPlayer webViewAdPlayer = this.this$0.webViewAdPlayer;
                Map<String, Object> unityAdsShowOptions = ((AndroidShowOptions) this.$showOptions).getUnityAdsShowOptions();
                this.label = 1;
                if (webViewAdPlayer.requestShow(unityAdsShowOptions, this) == aVar) {
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
        public final Object invoke(f fVar, c<? super x> cVar) {
            return ((AnonymousClass1) create(fVar, cVar)).invokeSuspend(x.f13520a);
        }
    }

    /* JADX INFO: renamed from: com.unity3d.ads.adplayer.AndroidEmbeddableWebViewAdPlayer$show$1$1$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.unity3d.ads.adplayer.AndroidEmbeddableWebViewAdPlayer$show$1$1$2", f = "AndroidEmbeddableWebViewAdPlayer.kt", l = {}, m = "invokeSuspend")
    public static final class AnonymousClass2 extends i implements p {
        /* synthetic */ Object L$0;
        int label;

        public AnonymousClass2(c<? super AnonymousClass2> cVar) {
            super(2, cVar);
        }

        @Override // x5.a
        public final c<x> create(Object obj, c<?> cVar) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(cVar);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // e6.p
        public final Object invoke(ScarEvent scarEvent, c<? super Boolean> cVar) {
            return ((AnonymousClass2) create(scarEvent, cVar)).invokeSuspend(x.f13520a);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            a aVar = a.f17774a;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            q.z0(obj);
            return Boolean.valueOf(k.a((ScarEvent) this.L$0, ScarEvent.Show.INSTANCE));
        }
    }

    /* JADX INFO: renamed from: com.unity3d.ads.adplayer.AndroidEmbeddableWebViewAdPlayer$show$1$1$4, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public /* synthetic */ class AnonymousClass4 implements f, g {
        final /* synthetic */ WebViewAdPlayer $tmp0;

        public AnonymousClass4(WebViewAdPlayer webViewAdPlayer) {
            this.$tmp0 = webViewAdPlayer;
        }

        public final Object emit(BannerBridge.BannerEvent bannerEvent, c<? super x> cVar) throws Throwable {
            Object objSendScarBannerEvent = this.$tmp0.sendScarBannerEvent(bannerEvent, cVar);
            return objSendScarBannerEvent == a.f17774a ? objSendScarBannerEvent : x.f13520a;
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof f) && (obj instanceof g)) {
                return k.a(getFunctionDelegate(), ((g) obj).getFunctionDelegate());
            }
            return false;
        }

        @Override // kotlin.jvm.internal.g
        public final q5.c getFunctionDelegate() {
            return new j(2, this.$tmp0, WebViewAdPlayer.class, "sendScarBannerEvent", "sendScarBannerEvent(Lcom/unity3d/services/banners/bridge/BannerBridge$BannerEvent;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // t6.f
        public /* bridge */ /* synthetic */ Object emit(Object obj, c cVar) {
            return emit((BannerBridge.BannerEvent) obj, (c<? super x>) cVar);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AndroidEmbeddableWebViewAdPlayer$show$1$1(AndroidEmbeddableWebViewAdPlayer androidEmbeddableWebViewAdPlayer, t0 t0Var, ShowOptions showOptions, c<? super AndroidEmbeddableWebViewAdPlayer$show$1$1> cVar) {
        super(2, cVar);
        this.this$0 = androidEmbeddableWebViewAdPlayer;
        this.$scarEvents = t0Var;
        this.$showOptions = showOptions;
    }

    @Override // x5.a
    public final c<x> create(Object obj, c<?> cVar) {
        return new AndroidEmbeddableWebViewAdPlayer$show$1$1(this.this$0, this.$scarEvents, this.$showOptions, cVar);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x005a, code lost:
    
        if (r1.collect(r3, r7) == r0) goto L15;
     */
    @Override // x5.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r8) throws java.lang.Throwable {
        /*
            r7 = this;
            w5.a r0 = w5.a.f17774a
            int r1 = r7.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L1c
            if (r1 == r3) goto L18
            if (r1 != r2) goto L10
            r2.q.z0(r8)
            goto L5d
        L10:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L18:
            r2.q.z0(r8)
            goto L42
        L1c:
            r2.q.z0(r8)
            com.unity3d.ads.adplayer.AndroidEmbeddableWebViewAdPlayer r8 = r7.this$0
            t6.e r8 = r8.getOnScarEvent()
            com.unity3d.ads.adplayer.AndroidEmbeddableWebViewAdPlayer$show$1$1$1 r1 = new com.unity3d.ads.adplayer.AndroidEmbeddableWebViewAdPlayer$show$1$1$1
            com.unity3d.ads.adplayer.AndroidEmbeddableWebViewAdPlayer r4 = r7.this$0
            com.unity3d.ads.adplayer.ShowOptions r5 = r7.$showOptions
            r6 = 0
            r1.<init>(r4, r5, r6)
            t6.s r4 = new t6.s
            r4.<init>(r1, r8)
            com.unity3d.ads.adplayer.AndroidEmbeddableWebViewAdPlayer$show$1$1$2 r8 = new com.unity3d.ads.adplayer.AndroidEmbeddableWebViewAdPlayer$show$1$1$2
            r8.<init>(r6)
            r7.label = r3
            java.lang.Object r8 = t6.x0.k(r4, r8, r7)
            if (r8 != r0) goto L42
            goto L5c
        L42:
            t6.t0 r8 = r7.$scarEvents
            com.unity3d.ads.adplayer.AndroidEmbeddableWebViewAdPlayer$show$1$1$invokeSuspend$$inlined$mapNotNull$1 r1 = new com.unity3d.ads.adplayer.AndroidEmbeddableWebViewAdPlayer$show$1$1$invokeSuspend$$inlined$mapNotNull$1
            r1.<init>()
            com.unity3d.ads.adplayer.AndroidEmbeddableWebViewAdPlayer r8 = r7.this$0
            com.unity3d.ads.adplayer.WebViewAdPlayer r8 = com.unity3d.ads.adplayer.AndroidEmbeddableWebViewAdPlayer.access$getWebViewAdPlayer$p(r8)
            com.unity3d.ads.adplayer.AndroidEmbeddableWebViewAdPlayer$show$1$1$4 r3 = new com.unity3d.ads.adplayer.AndroidEmbeddableWebViewAdPlayer$show$1$1$4
            r3.<init>(r8)
            r7.label = r2
            java.lang.Object r8 = r1.collect(r3, r7)
            if (r8 != r0) goto L5d
        L5c:
            return r0
        L5d:
            q5.x r8 = q5.x.f13520a
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.ads.adplayer.AndroidEmbeddableWebViewAdPlayer$show$1$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // e6.p
    public final Object invoke(a0 a0Var, c<? super x> cVar) {
        return ((AndroidEmbeddableWebViewAdPlayer$show$1$1) create(a0Var, cVar)).invokeSuspend(x.f13520a);
    }
}
