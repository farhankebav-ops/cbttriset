package com.unity3d.ads.adplayer;

import android.content.Context;
import android.content.Intent;
import com.unity3d.ads.adplayer.DisplayMessage;
import com.unity3d.ads.core.data.datasource.VolumeSettingsChange;
import com.unity3d.ads.core.data.manager.OfferwallManager;
import com.unity3d.ads.core.data.manager.ScarManager;
import com.unity3d.ads.core.data.model.AdObject;
import com.unity3d.ads.core.data.model.OfferwallShowEvent;
import com.unity3d.ads.core.data.model.ScarEvent;
import com.unity3d.ads.core.data.model.SessionChange;
import com.unity3d.ads.core.data.model.ShowEvent;
import com.unity3d.ads.core.data.repository.AdRepository;
import com.unity3d.ads.core.data.repository.DeviceInfoRepository;
import com.unity3d.ads.core.data.repository.OpenMeasurementRepository;
import com.unity3d.ads.core.data.repository.OrientationRepository;
import com.unity3d.ads.core.data.repository.SessionRepository;
import com.unity3d.ads.core.domain.SendDiagnosticEvent;
import com.unity3d.services.ads.offerwall.OfferwallEvent;
import com.unity3d.services.banners.bridge.BannerBridge;
import com.vungle.ads.internal.protos.Sdk;
import e6.p;
import java.util.Map;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.j;
import kotlin.jvm.internal.k;
import n7.b;
import org.json.JSONObject;
import q5.f;
import q5.x;
import q6.a0;
import q6.c0;
import q6.f1;
import q6.q;
import q6.r;
import s6.a;
import t6.p0;
import t6.t0;
import t6.x0;
import x5.c;
import x5.e;
import x5.i;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class AndroidFullscreenWebViewAdPlayer implements AdPlayer, FullscreenAdPlayer {
    public static final Companion Companion = new Companion(null);
    private static final p0 displayMessages = x0.a((7 & 1) != 0 ? 0 : 100, (7 & 2) == 0 ? 64 : 0, a.f13718a);
    private final f adObject$delegate;
    private final AdRepository adRepository;
    private final Context context;
    private final DeviceInfoRepository deviceInfoRepository;
    private final OfferwallManager offerwallManager;
    private final OpenMeasurementRepository openMeasurementRepository;
    private final String opportunityId;
    private final OrientationRepository orientationRepository;
    private final ScarManager scarManager;
    private final SendDiagnosticEvent sendDiagnosticEvent;
    private final SessionRepository sessionRepository;
    private final WebViewAdPlayer webViewAdPlayer;
    private final AndroidWebViewContainer webViewContainer;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.f fVar) {
            this();
        }

        public final p0 getDisplayMessages() {
            return AndroidFullscreenWebViewAdPlayer.displayMessages;
        }

        private Companion() {
        }
    }

    /* JADX INFO: renamed from: com.unity3d.ads.adplayer.AndroidFullscreenWebViewAdPlayer$destroy$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.unity3d.ads.adplayer.AndroidFullscreenWebViewAdPlayer", f = "AndroidFullscreenWebViewAdPlayer.kt", l = {173, 178, 182, 184}, m = "destroy")
    public static final class AnonymousClass1 extends c {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(v5.c<? super AnonymousClass1> cVar) {
            super(cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AndroidFullscreenWebViewAdPlayer.this.destroy(this);
        }
    }

    /* JADX INFO: renamed from: com.unity3d.ads.adplayer.AndroidFullscreenWebViewAdPlayer$displayEventsRouter$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.unity3d.ads.adplayer.AndroidFullscreenWebViewAdPlayer$displayEventsRouter$1", f = "AndroidFullscreenWebViewAdPlayer.kt", l = {198, 199, 200, 201, 202, 204}, m = "invokeSuspend")
    public static final class C28461 extends i implements p {
        final /* synthetic */ DisplayMessage $displayMessage;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C28461(DisplayMessage displayMessage, v5.c<? super C28461> cVar) {
            super(2, cVar);
            this.$displayMessage = displayMessage;
        }

        @Override // x5.a
        public final v5.c<x> create(Object obj, v5.c<?> cVar) {
            return AndroidFullscreenWebViewAdPlayer.this.new C28461(this.$displayMessage, cVar);
        }

        /* JADX WARN: Code restructure failed: missing block: B:17:0x0097, code lost:
        
            if (r12.requestShow(r1, r11) == r0) goto L43;
         */
        /* JADX WARN: Code restructure failed: missing block: B:22:0x00c0, code lost:
        
            if (r1.emit(r2, r11) == r0) goto L43;
         */
        /* JADX WARN: Code restructure failed: missing block: B:27:0x00dc, code lost:
        
            if (r12.sendVisibilityChange(r1, r11) == r0) goto L43;
         */
        /* JADX WARN: Code restructure failed: missing block: B:32:0x00f8, code lost:
        
            if (r12.sendFocusChange(r1, r11) == r0) goto L43;
         */
        /* JADX WARN: Code restructure failed: missing block: B:37:0x010c, code lost:
        
            if (r12.sendActivityDestroyed(r11) == r0) goto L43;
         */
        /* JADX WARN: Code restructure failed: missing block: B:42:0x011c, code lost:
        
            if (r12.destroy(r11) == r0) goto L43;
         */
        /* JADX WARN: Code restructure failed: missing block: B:43:0x011e, code lost:
        
            return r0;
         */
        @Override // x5.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r12) throws java.lang.Throwable {
            /*
                Method dump skipped, instruction units count: 308
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.unity3d.ads.adplayer.AndroidFullscreenWebViewAdPlayer.C28461.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // e6.p
        public final Object invoke(a0 a0Var, v5.c<? super x> cVar) {
            return ((C28461) create(a0Var, cVar)).invokeSuspend(x.f13520a);
        }
    }

    /* JADX INFO: renamed from: com.unity3d.ads.adplayer.AndroidFullscreenWebViewAdPlayer$show$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.unity3d.ads.adplayer.AndroidFullscreenWebViewAdPlayer$show$1", f = "AndroidFullscreenWebViewAdPlayer.kt", l = {}, m = "invokeSuspend")
    public static final class C28471 extends i implements p {
        final /* synthetic */ q $listenerStarted;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C28471(q qVar, v5.c<? super C28471> cVar) {
            super(2, cVar);
            this.$listenerStarted = qVar;
        }

        @Override // x5.a
        public final v5.c<x> create(Object obj, v5.c<?> cVar) {
            return new C28471(this.$listenerStarted, cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            w5.a aVar = w5.a.f17774a;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            r2.q.z0(obj);
            r rVar = (r) this.$listenerStarted;
            x xVar = x.f13520a;
            rVar.N(xVar);
            return xVar;
        }

        @Override // e6.p
        public final Object invoke(t6.f fVar, v5.c<? super x> cVar) {
            return ((C28471) create(fVar, cVar)).invokeSuspend(x.f13520a);
        }
    }

    /* JADX INFO: renamed from: com.unity3d.ads.adplayer.AndroidFullscreenWebViewAdPlayer$show$10, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.unity3d.ads.adplayer.AndroidFullscreenWebViewAdPlayer$show$10", f = "AndroidFullscreenWebViewAdPlayer.kt", l = {147, 152}, m = "invokeSuspend")
    public static final class AnonymousClass10 extends i implements p {
        final /* synthetic */ ShowOptions $showOptions;
        int label;

        /* JADX INFO: renamed from: com.unity3d.ads.adplayer.AndroidFullscreenWebViewAdPlayer$show$10$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        @e(c = "com.unity3d.ads.adplayer.AndroidFullscreenWebViewAdPlayer$show$10$1", f = "AndroidFullscreenWebViewAdPlayer.kt", l = {146}, m = "invokeSuspend")
        public static final class AnonymousClass1 extends i implements p {
            final /* synthetic */ ShowOptions $showOptions;
            int label;
            final /* synthetic */ AndroidFullscreenWebViewAdPlayer this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(AndroidFullscreenWebViewAdPlayer androidFullscreenWebViewAdPlayer, ShowOptions showOptions, v5.c<? super AnonymousClass1> cVar) {
                super(2, cVar);
                this.this$0 = androidFullscreenWebViewAdPlayer;
                this.$showOptions = showOptions;
            }

            @Override // x5.a
            public final v5.c<x> create(Object obj, v5.c<?> cVar) {
                return new AnonymousClass1(this.this$0, this.$showOptions, cVar);
            }

            @Override // x5.a
            public final Object invokeSuspend(Object obj) throws Throwable {
                w5.a aVar = w5.a.f17774a;
                int i2 = this.label;
                if (i2 == 0) {
                    r2.q.z0(obj);
                    p0 displayMessages = AndroidFullscreenWebViewAdPlayer.Companion.getDisplayMessages();
                    DisplayMessage.DisplayReady displayReady = new DisplayMessage.DisplayReady(this.this$0.opportunityId, ((AndroidShowOptions) this.$showOptions).getUnityAdsShowOptions());
                    this.label = 1;
                    if (displayMessages.emit(displayReady, this) == aVar) {
                        return aVar;
                    }
                } else {
                    if (i2 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    r2.q.z0(obj);
                }
                return x.f13520a;
            }

            @Override // e6.p
            public final Object invoke(t6.f fVar, v5.c<? super x> cVar) {
                return ((AnonymousClass1) create(fVar, cVar)).invokeSuspend(x.f13520a);
            }
        }

        /* JADX INFO: renamed from: com.unity3d.ads.adplayer.AndroidFullscreenWebViewAdPlayer$show$10$2, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        @e(c = "com.unity3d.ads.adplayer.AndroidFullscreenWebViewAdPlayer$show$10$2", f = "AndroidFullscreenWebViewAdPlayer.kt", l = {}, m = "invokeSuspend")
        public static final class AnonymousClass2 extends i implements p {
            /* synthetic */ Object L$0;
            int label;

            public AnonymousClass2(v5.c<? super AnonymousClass2> cVar) {
                super(2, cVar);
            }

            @Override // x5.a
            public final v5.c<x> create(Object obj, v5.c<?> cVar) {
                AnonymousClass2 anonymousClass2 = new AnonymousClass2(cVar);
                anonymousClass2.L$0 = obj;
                return anonymousClass2;
            }

            @Override // e6.p
            public final Object invoke(OfferwallShowEvent offerwallShowEvent, v5.c<? super Boolean> cVar) {
                return ((AnonymousClass2) create(offerwallShowEvent, cVar)).invokeSuspend(x.f13520a);
            }

            @Override // x5.a
            public final Object invokeSuspend(Object obj) throws Throwable {
                w5.a aVar = w5.a.f17774a;
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                r2.q.z0(obj);
                return Boolean.valueOf(k.a((OfferwallShowEvent) this.L$0, OfferwallShowEvent.Show.INSTANCE));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.ads.adplayer.AndroidFullscreenWebViewAdPlayer$show$10$4, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public /* synthetic */ class AnonymousClass4 implements t6.f, g {
            final /* synthetic */ WebViewAdPlayer $tmp0;

            public AnonymousClass4(WebViewAdPlayer webViewAdPlayer) {
                this.$tmp0 = webViewAdPlayer;
            }

            public final Object emit(OfferwallEvent offerwallEvent, v5.c<? super x> cVar) throws Throwable {
                Object objSendOfferwallEvent = this.$tmp0.sendOfferwallEvent(offerwallEvent, cVar);
                return objSendOfferwallEvent == w5.a.f17774a ? objSendOfferwallEvent : x.f13520a;
            }

            public final boolean equals(Object obj) {
                if ((obj instanceof t6.f) && (obj instanceof g)) {
                    return k.a(getFunctionDelegate(), ((g) obj).getFunctionDelegate());
                }
                return false;
            }

            @Override // kotlin.jvm.internal.g
            public final q5.c getFunctionDelegate() {
                return new j(2, this.$tmp0, WebViewAdPlayer.class, "sendOfferwallEvent", "sendOfferwallEvent(Lcom/unity3d/services/ads/offerwall/OfferwallEvent;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
            }

            public final int hashCode() {
                return getFunctionDelegate().hashCode();
            }

            @Override // t6.f
            public /* bridge */ /* synthetic */ Object emit(Object obj, v5.c cVar) {
                return emit((OfferwallEvent) obj, (v5.c<? super x>) cVar);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass10(ShowOptions showOptions, v5.c<? super AnonymousClass10> cVar) {
            super(2, cVar);
            this.$showOptions = showOptions;
        }

        @Override // x5.a
        public final v5.c<x> create(Object obj, v5.c<?> cVar) {
            return AndroidFullscreenWebViewAdPlayer.this.new AnonymousClass10(this.$showOptions, cVar);
        }

        /* JADX WARN: Code restructure failed: missing block: B:17:0x0079, code lost:
        
            if (r1.collect(r3, r7) == r0) goto L18;
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
                goto L7c
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
                com.unity3d.ads.adplayer.AndroidFullscreenWebViewAdPlayer r8 = com.unity3d.ads.adplayer.AndroidFullscreenWebViewAdPlayer.this
                t6.e r8 = r8.getOnOfferwallEvent()
                com.unity3d.ads.adplayer.AndroidFullscreenWebViewAdPlayer$show$10$1 r1 = new com.unity3d.ads.adplayer.AndroidFullscreenWebViewAdPlayer$show$10$1
                com.unity3d.ads.adplayer.AndroidFullscreenWebViewAdPlayer r4 = com.unity3d.ads.adplayer.AndroidFullscreenWebViewAdPlayer.this
                com.unity3d.ads.adplayer.ShowOptions r5 = r7.$showOptions
                r6 = 0
                r1.<init>(r4, r5, r6)
                t6.s r4 = new t6.s
                r4.<init>(r1, r8)
                com.unity3d.ads.adplayer.AndroidFullscreenWebViewAdPlayer$show$10$2 r8 = new com.unity3d.ads.adplayer.AndroidFullscreenWebViewAdPlayer$show$10$2
                r8.<init>(r6)
                r7.label = r3
                java.lang.Object r8 = t6.x0.k(r4, r8, r7)
                if (r8 != r0) goto L42
                goto L7b
            L42:
                com.unity3d.ads.adplayer.AndroidFullscreenWebViewAdPlayer r8 = com.unity3d.ads.adplayer.AndroidFullscreenWebViewAdPlayer.this
                com.unity3d.ads.core.data.manager.OfferwallManager r8 = com.unity3d.ads.adplayer.AndroidFullscreenWebViewAdPlayer.access$getOfferwallManager$p(r8)
                com.unity3d.ads.adplayer.ShowOptions r1 = r7.$showOptions
                com.unity3d.ads.adplayer.AndroidShowOptions r1 = (com.unity3d.ads.adplayer.AndroidShowOptions) r1
                java.lang.String r1 = r1.getOfferwallPlacementName()
                if (r1 != 0) goto L54
                java.lang.String r1 = ""
            L54:
                t6.e r8 = r8.showAd(r1)
                com.unity3d.ads.adplayer.AndroidFullscreenWebViewAdPlayer r1 = com.unity3d.ads.adplayer.AndroidFullscreenWebViewAdPlayer.this
                q6.a0 r1 = r1.getScope()
                r3 = 5
                t6.r0 r8 = t6.x0.p(r8, r1, r3)
                com.unity3d.ads.adplayer.AndroidFullscreenWebViewAdPlayer$show$10$invokeSuspend$$inlined$mapNotNull$1 r1 = new com.unity3d.ads.adplayer.AndroidFullscreenWebViewAdPlayer$show$10$invokeSuspend$$inlined$mapNotNull$1
                r1.<init>()
                com.unity3d.ads.adplayer.AndroidFullscreenWebViewAdPlayer r8 = com.unity3d.ads.adplayer.AndroidFullscreenWebViewAdPlayer.this
                com.unity3d.ads.adplayer.WebViewAdPlayer r8 = com.unity3d.ads.adplayer.AndroidFullscreenWebViewAdPlayer.access$getWebViewAdPlayer$p(r8)
                com.unity3d.ads.adplayer.AndroidFullscreenWebViewAdPlayer$show$10$4 r3 = new com.unity3d.ads.adplayer.AndroidFullscreenWebViewAdPlayer$show$10$4
                r3.<init>(r8)
                r7.label = r2
                java.lang.Object r8 = r1.collect(r3, r7)
                if (r8 != r0) goto L7c
            L7b:
                return r0
            L7c:
                q5.x r8 = q5.x.f13520a
                return r8
            */
            throw new UnsupportedOperationException("Method not decompiled: com.unity3d.ads.adplayer.AndroidFullscreenWebViewAdPlayer.AnonymousClass10.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // e6.p
        public final Object invoke(a0 a0Var, v5.c<? super x> cVar) {
            return ((AnonymousClass10) create(a0Var, cVar)).invokeSuspend(x.f13520a);
        }
    }

    /* JADX INFO: renamed from: com.unity3d.ads.adplayer.AndroidFullscreenWebViewAdPlayer$show$3, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public /* synthetic */ class AnonymousClass3 extends kotlin.jvm.internal.a implements p {
        public AnonymousClass3(Object obj) {
            super(2, obj, AndroidFullscreenWebViewAdPlayer.class, "displayEventsRouter", "displayEventsRouter(Lcom/unity3d/ads/adplayer/DisplayMessage;)Lkotlinx/coroutines/Job;", 12);
        }

        @Override // e6.p
        public final Object invoke(DisplayMessage displayMessage, v5.c<? super x> cVar) {
            return AndroidFullscreenWebViewAdPlayer.show$displayEventsRouter((AndroidFullscreenWebViewAdPlayer) this.receiver, displayMessage, cVar);
        }
    }

    /* JADX INFO: renamed from: com.unity3d.ads.adplayer.AndroidFullscreenWebViewAdPlayer$show$4, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public /* synthetic */ class AnonymousClass4 extends j implements p {
        public AnonymousClass4(Object obj) {
            super(2, obj, AndroidFullscreenWebViewAdPlayer.class, "handleVolumeSettingsChange", "handleVolumeSettingsChange(Lcom/unity3d/ads/core/data/datasource/VolumeSettingsChange;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
        }

        @Override // e6.p
        public final Object invoke(VolumeSettingsChange volumeSettingsChange, v5.c<? super x> cVar) {
            return ((AndroidFullscreenWebViewAdPlayer) this.receiver).handleVolumeSettingsChange(volumeSettingsChange, cVar);
        }
    }

    /* JADX INFO: renamed from: com.unity3d.ads.adplayer.AndroidFullscreenWebViewAdPlayer$show$6, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.unity3d.ads.adplayer.AndroidFullscreenWebViewAdPlayer$show$6", f = "AndroidFullscreenWebViewAdPlayer.kt", l = {96}, m = "invokeSuspend")
    public static final class AnonymousClass6 extends i implements p {
        int label;

        public AnonymousClass6(v5.c<? super AnonymousClass6> cVar) {
            super(2, cVar);
        }

        @Override // x5.a
        public final v5.c<x> create(Object obj, v5.c<?> cVar) {
            return AndroidFullscreenWebViewAdPlayer.this.new AnonymousClass6(cVar);
        }

        @Override // e6.p
        public final Object invoke(ShowEvent showEvent, v5.c<? super x> cVar) {
            return ((AnonymousClass6) create(showEvent, cVar)).invokeSuspend(x.f13520a);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            w5.a aVar = w5.a.f17774a;
            int i2 = this.label;
            if (i2 == 0) {
                r2.q.z0(obj);
                AndroidFullscreenWebViewAdPlayer androidFullscreenWebViewAdPlayer = AndroidFullscreenWebViewAdPlayer.this;
                this.label = 1;
                if (androidFullscreenWebViewAdPlayer.destroy(this) == aVar) {
                    return aVar;
                }
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                r2.q.z0(obj);
            }
            return x.f13520a;
        }
    }

    /* JADX INFO: renamed from: com.unity3d.ads.adplayer.AndroidFullscreenWebViewAdPlayer$show$7, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public /* synthetic */ class AnonymousClass7 extends j implements p {
        public AnonymousClass7(Object obj) {
            super(2, obj, AndroidFullscreenWebViewAdPlayer.class, "handleSessionChange", "handleSessionChange(Lcom/unity3d/ads/core/data/model/SessionChange;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
        }

        @Override // e6.p
        public final Object invoke(SessionChange sessionChange, v5.c<? super x> cVar) {
            return ((AndroidFullscreenWebViewAdPlayer) this.receiver).handleSessionChange(sessionChange, cVar);
        }
    }

    /* JADX INFO: renamed from: com.unity3d.ads.adplayer.AndroidFullscreenWebViewAdPlayer$show$8, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.unity3d.ads.adplayer.AndroidFullscreenWebViewAdPlayer$show$8", f = "AndroidFullscreenWebViewAdPlayer.kt", l = {116}, m = "invokeSuspend")
    public static final class AnonymousClass8 extends i implements p {
        final /* synthetic */ Intent $intent;
        final /* synthetic */ q $listenerStarted;
        int label;
        final /* synthetic */ AndroidFullscreenWebViewAdPlayer this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass8(q qVar, AndroidFullscreenWebViewAdPlayer androidFullscreenWebViewAdPlayer, Intent intent, v5.c<? super AnonymousClass8> cVar) {
            super(2, cVar);
            this.$listenerStarted = qVar;
            this.this$0 = androidFullscreenWebViewAdPlayer;
            this.$intent = intent;
        }

        @Override // x5.a
        public final v5.c<x> create(Object obj, v5.c<?> cVar) {
            return new AnonymousClass8(this.$listenerStarted, this.this$0, this.$intent, cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            w5.a aVar = w5.a.f17774a;
            int i2 = this.label;
            if (i2 == 0) {
                r2.q.z0(obj);
                q qVar = this.$listenerStarted;
                this.label = 1;
                if (((r) qVar).t(this) == aVar) {
                    return aVar;
                }
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                r2.q.z0(obj);
            }
            this.this$0.context.startActivity(this.$intent);
            SendDiagnosticEvent.DefaultImpls.invoke$default(this.this$0.sendDiagnosticEvent, "native_show_ad_viewer_fullscreen_intent", null, null, null, this.this$0.getAdObject(), null, 46, null);
            return x.f13520a;
        }

        @Override // e6.p
        public final Object invoke(a0 a0Var, v5.c<? super x> cVar) {
            return ((AnonymousClass8) create(a0Var, cVar)).invokeSuspend(x.f13520a);
        }
    }

    /* JADX INFO: renamed from: com.unity3d.ads.adplayer.AndroidFullscreenWebViewAdPlayer$show$9, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.unity3d.ads.adplayer.AndroidFullscreenWebViewAdPlayer$show$9", f = "AndroidFullscreenWebViewAdPlayer.kt", l = {Sdk.SDKError.Reason.STORE_REGION_CODE_ERROR_VALUE, Sdk.SDKError.Reason.CONFIG_REFRESH_FAILED_VALUE}, m = "invokeSuspend")
    public static final class AnonymousClass9 extends i implements p {
        final /* synthetic */ t0 $scarEvents;
        final /* synthetic */ ShowOptions $showOptions;
        int label;

        /* JADX INFO: renamed from: com.unity3d.ads.adplayer.AndroidFullscreenWebViewAdPlayer$show$9$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        @e(c = "com.unity3d.ads.adplayer.AndroidFullscreenWebViewAdPlayer$show$9$1", f = "AndroidFullscreenWebViewAdPlayer.kt", l = {Sdk.SDKError.Reason.OMSDK_JS_WRITE_FAILED_VALUE}, m = "invokeSuspend")
        public static final class AnonymousClass1 extends i implements p {
            final /* synthetic */ ShowOptions $showOptions;
            int label;
            final /* synthetic */ AndroidFullscreenWebViewAdPlayer this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(AndroidFullscreenWebViewAdPlayer androidFullscreenWebViewAdPlayer, ShowOptions showOptions, v5.c<? super AnonymousClass1> cVar) {
                super(2, cVar);
                this.this$0 = androidFullscreenWebViewAdPlayer;
                this.$showOptions = showOptions;
            }

            @Override // x5.a
            public final v5.c<x> create(Object obj, v5.c<?> cVar) {
                return new AnonymousClass1(this.this$0, this.$showOptions, cVar);
            }

            @Override // x5.a
            public final Object invokeSuspend(Object obj) throws Throwable {
                w5.a aVar = w5.a.f17774a;
                int i2 = this.label;
                if (i2 == 0) {
                    r2.q.z0(obj);
                    p0 displayMessages = AndroidFullscreenWebViewAdPlayer.Companion.getDisplayMessages();
                    DisplayMessage.DisplayReady displayReady = new DisplayMessage.DisplayReady(this.this$0.opportunityId, ((AndroidShowOptions) this.$showOptions).getUnityAdsShowOptions());
                    this.label = 1;
                    if (displayMessages.emit(displayReady, this) == aVar) {
                        return aVar;
                    }
                } else {
                    if (i2 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    r2.q.z0(obj);
                }
                return x.f13520a;
            }

            @Override // e6.p
            public final Object invoke(t6.f fVar, v5.c<? super x> cVar) {
                return ((AnonymousClass1) create(fVar, cVar)).invokeSuspend(x.f13520a);
            }
        }

        /* JADX INFO: renamed from: com.unity3d.ads.adplayer.AndroidFullscreenWebViewAdPlayer$show$9$2, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        @e(c = "com.unity3d.ads.adplayer.AndroidFullscreenWebViewAdPlayer$show$9$2", f = "AndroidFullscreenWebViewAdPlayer.kt", l = {}, m = "invokeSuspend")
        public static final class AnonymousClass2 extends i implements p {
            /* synthetic */ Object L$0;
            int label;

            public AnonymousClass2(v5.c<? super AnonymousClass2> cVar) {
                super(2, cVar);
            }

            @Override // x5.a
            public final v5.c<x> create(Object obj, v5.c<?> cVar) {
                AnonymousClass2 anonymousClass2 = new AnonymousClass2(cVar);
                anonymousClass2.L$0 = obj;
                return anonymousClass2;
            }

            @Override // e6.p
            public final Object invoke(ScarEvent scarEvent, v5.c<? super Boolean> cVar) {
                return ((AnonymousClass2) create(scarEvent, cVar)).invokeSuspend(x.f13520a);
            }

            @Override // x5.a
            public final Object invokeSuspend(Object obj) throws Throwable {
                w5.a aVar = w5.a.f17774a;
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                r2.q.z0(obj);
                return Boolean.valueOf(k.a((ScarEvent) this.L$0, ScarEvent.Show.INSTANCE));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.ads.adplayer.AndroidFullscreenWebViewAdPlayer$show$9$4, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public /* synthetic */ class AnonymousClass4 implements t6.f, g {
            final /* synthetic */ WebViewAdPlayer $tmp0;

            public AnonymousClass4(WebViewAdPlayer webViewAdPlayer) {
                this.$tmp0 = webViewAdPlayer;
            }

            public final Object emit(com.unity3d.scar.adapter.common.c cVar, v5.c<? super x> cVar2) throws Throwable {
                Object objSendGmaEvent = this.$tmp0.sendGmaEvent(cVar, cVar2);
                return objSendGmaEvent == w5.a.f17774a ? objSendGmaEvent : x.f13520a;
            }

            public final boolean equals(Object obj) {
                if ((obj instanceof t6.f) && (obj instanceof g)) {
                    return k.a(getFunctionDelegate(), ((g) obj).getFunctionDelegate());
                }
                return false;
            }

            @Override // kotlin.jvm.internal.g
            public final q5.c getFunctionDelegate() {
                return new j(2, this.$tmp0, WebViewAdPlayer.class, "sendGmaEvent", "sendGmaEvent(Lcom/unity3d/scar/adapter/common/GMAEvent;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
            }

            public final int hashCode() {
                return getFunctionDelegate().hashCode();
            }

            @Override // t6.f
            public /* bridge */ /* synthetic */ Object emit(Object obj, v5.c cVar) {
                return emit((com.unity3d.scar.adapter.common.c) obj, (v5.c<? super x>) cVar);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass9(t0 t0Var, ShowOptions showOptions, v5.c<? super AnonymousClass9> cVar) {
            super(2, cVar);
            this.$scarEvents = t0Var;
            this.$showOptions = showOptions;
        }

        @Override // x5.a
        public final v5.c<x> create(Object obj, v5.c<?> cVar) {
            return AndroidFullscreenWebViewAdPlayer.this.new AnonymousClass9(this.$scarEvents, this.$showOptions, cVar);
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
                com.unity3d.ads.adplayer.AndroidFullscreenWebViewAdPlayer r8 = com.unity3d.ads.adplayer.AndroidFullscreenWebViewAdPlayer.this
                t6.e r8 = r8.getOnScarEvent()
                com.unity3d.ads.adplayer.AndroidFullscreenWebViewAdPlayer$show$9$1 r1 = new com.unity3d.ads.adplayer.AndroidFullscreenWebViewAdPlayer$show$9$1
                com.unity3d.ads.adplayer.AndroidFullscreenWebViewAdPlayer r4 = com.unity3d.ads.adplayer.AndroidFullscreenWebViewAdPlayer.this
                com.unity3d.ads.adplayer.ShowOptions r5 = r7.$showOptions
                r6 = 0
                r1.<init>(r4, r5, r6)
                t6.s r4 = new t6.s
                r4.<init>(r1, r8)
                com.unity3d.ads.adplayer.AndroidFullscreenWebViewAdPlayer$show$9$2 r8 = new com.unity3d.ads.adplayer.AndroidFullscreenWebViewAdPlayer$show$9$2
                r8.<init>(r6)
                r7.label = r3
                java.lang.Object r8 = t6.x0.k(r4, r8, r7)
                if (r8 != r0) goto L42
                goto L5c
            L42:
                t6.t0 r8 = r7.$scarEvents
                com.unity3d.ads.adplayer.AndroidFullscreenWebViewAdPlayer$show$9$invokeSuspend$$inlined$mapNotNull$1 r1 = new com.unity3d.ads.adplayer.AndroidFullscreenWebViewAdPlayer$show$9$invokeSuspend$$inlined$mapNotNull$1
                r1.<init>()
                com.unity3d.ads.adplayer.AndroidFullscreenWebViewAdPlayer r8 = com.unity3d.ads.adplayer.AndroidFullscreenWebViewAdPlayer.this
                com.unity3d.ads.adplayer.WebViewAdPlayer r8 = com.unity3d.ads.adplayer.AndroidFullscreenWebViewAdPlayer.access$getWebViewAdPlayer$p(r8)
                com.unity3d.ads.adplayer.AndroidFullscreenWebViewAdPlayer$show$9$4 r3 = new com.unity3d.ads.adplayer.AndroidFullscreenWebViewAdPlayer$show$9$4
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
            throw new UnsupportedOperationException("Method not decompiled: com.unity3d.ads.adplayer.AndroidFullscreenWebViewAdPlayer.AnonymousClass9.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // e6.p
        public final Object invoke(a0 a0Var, v5.c<? super x> cVar) {
            return ((AnonymousClass9) create(a0Var, cVar)).invokeSuspend(x.f13520a);
        }
    }

    public AndroidFullscreenWebViewAdPlayer(WebViewAdPlayer webViewAdPlayer, String opportunityId, AndroidWebViewContainer webViewContainer, DeviceInfoRepository deviceInfoRepository, SessionRepository sessionRepository, OpenMeasurementRepository openMeasurementRepository, ScarManager scarManager, OfferwallManager offerwallManager, SendDiagnosticEvent sendDiagnosticEvent, AdRepository adRepository, OrientationRepository orientationRepository, Context context) {
        k.e(webViewAdPlayer, "webViewAdPlayer");
        k.e(opportunityId, "opportunityId");
        k.e(webViewContainer, "webViewContainer");
        k.e(deviceInfoRepository, "deviceInfoRepository");
        k.e(sessionRepository, "sessionRepository");
        k.e(openMeasurementRepository, "openMeasurementRepository");
        k.e(scarManager, "scarManager");
        k.e(offerwallManager, "offerwallManager");
        k.e(sendDiagnosticEvent, "sendDiagnosticEvent");
        k.e(adRepository, "adRepository");
        k.e(orientationRepository, "orientationRepository");
        k.e(context, "context");
        this.webViewAdPlayer = webViewAdPlayer;
        this.opportunityId = opportunityId;
        this.webViewContainer = webViewContainer;
        this.deviceInfoRepository = deviceInfoRepository;
        this.sessionRepository = sessionRepository;
        this.openMeasurementRepository = openMeasurementRepository;
        this.scarManager = scarManager;
        this.offerwallManager = offerwallManager;
        this.sendDiagnosticEvent = sendDiagnosticEvent;
        this.adRepository = adRepository;
        this.orientationRepository = orientationRepository;
        this.context = context;
        this.adObject$delegate = b.C(new AndroidFullscreenWebViewAdPlayer$adObject$2(this));
    }

    private final f1 displayEventsRouter(DisplayMessage displayMessage) {
        return c0.u(getScope(), null, new C28461(displayMessage, null), 3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AdObject getAdObject() {
        return (AdObject) this.adObject$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object handleSessionChange(SessionChange sessionChange, v5.c<? super x> cVar) throws Throwable {
        boolean z2 = sessionChange instanceof SessionChange.UserConsentChange;
        x xVar = x.f13520a;
        if (z2) {
            WebViewAdPlayer webViewAdPlayer = this.webViewAdPlayer;
            byte[] byteArray = ((SessionChange.UserConsentChange) sessionChange).getValue().toByteArray();
            k.d(byteArray, "change.value.toByteArray()");
            Object objSendUserConsentChange = webViewAdPlayer.sendUserConsentChange(byteArray, cVar);
            return objSendUserConsentChange == w5.a.f17774a ? objSendUserConsentChange : xVar;
        }
        if (sessionChange instanceof SessionChange.PrivacyFsmChange) {
            WebViewAdPlayer webViewAdPlayer2 = this.webViewAdPlayer;
            byte[] byteArray2 = ((SessionChange.PrivacyFsmChange) sessionChange).getValue().toByteArray();
            k.d(byteArray2, "change.value.toByteArray()");
            Object objSendPrivacyFsmChange = webViewAdPlayer2.sendPrivacyFsmChange(byteArray2, cVar);
            if (objSendPrivacyFsmChange == w5.a.f17774a) {
                return objSendPrivacyFsmChange;
            }
        }
        return xVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object handleVolumeSettingsChange(VolumeSettingsChange volumeSettingsChange, v5.c<? super x> cVar) throws Throwable {
        Object objSendVolumeChange;
        boolean z2 = volumeSettingsChange instanceof VolumeSettingsChange.MuteChange;
        x xVar = x.f13520a;
        if (!z2) {
            return ((volumeSettingsChange instanceof VolumeSettingsChange.VolumeChange) && (objSendVolumeChange = this.webViewAdPlayer.sendVolumeChange(((VolumeSettingsChange.VolumeChange) volumeSettingsChange).getVolume(), cVar)) == w5.a.f17774a) ? objSendVolumeChange : xVar;
        }
        Object objSendMuteChange = this.webViewAdPlayer.sendMuteChange(((VolumeSettingsChange.MuteChange) volumeSettingsChange).isMuted(), cVar);
        return objSendMuteChange == w5.a.f17774a ? objSendMuteChange : xVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ Object show$displayEventsRouter(AndroidFullscreenWebViewAdPlayer androidFullscreenWebViewAdPlayer, DisplayMessage displayMessage, v5.c cVar) {
        androidFullscreenWebViewAdPlayer.displayEventsRouter(displayMessage);
        return x.f13520a;
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x009c, code lost:
    
        if (com.unity3d.ads.adplayer.AdPlayer.DefaultImpls.destroy(r2, r0) != r1) goto L35;
     */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0093 A[PHI: r2
  0x0093: PHI (r2v5 com.unity3d.ads.adplayer.AndroidFullscreenWebViewAdPlayer) = 
  (r2v4 com.unity3d.ads.adplayer.AndroidFullscreenWebViewAdPlayer)
  (r2v11 com.unity3d.ads.adplayer.AndroidFullscreenWebViewAdPlayer)
 binds: [B:30:0x0090, B:17:0x0039] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.unity3d.ads.adplayer.AdPlayer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object destroy(v5.c<? super q5.x> r9) throws java.lang.Throwable {
        /*
            r8 = this;
            boolean r0 = r9 instanceof com.unity3d.ads.adplayer.AndroidFullscreenWebViewAdPlayer.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r9
            com.unity3d.ads.adplayer.AndroidFullscreenWebViewAdPlayer$destroy$1 r0 = (com.unity3d.ads.adplayer.AndroidFullscreenWebViewAdPlayer.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.unity3d.ads.adplayer.AndroidFullscreenWebViewAdPlayer$destroy$1 r0 = new com.unity3d.ads.adplayer.AndroidFullscreenWebViewAdPlayer$destroy$1
            r0.<init>(r9)
        L18:
            java.lang.Object r9 = r0.result
            w5.a r1 = w5.a.f17774a
            int r2 = r0.label
            r3 = 4
            r4 = 3
            r5 = 2
            r6 = 1
            if (r2 == 0) goto L51
            if (r2 == r6) goto L49
            if (r2 == r5) goto L41
            if (r2 == r4) goto L39
            if (r2 != r3) goto L31
            r2.q.z0(r9)
            goto L9f
        L31:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L39:
            java.lang.Object r2 = r0.L$0
            com.unity3d.ads.adplayer.AndroidFullscreenWebViewAdPlayer r2 = (com.unity3d.ads.adplayer.AndroidFullscreenWebViewAdPlayer) r2
            r2.q.z0(r9)
            goto L93
        L41:
            java.lang.Object r2 = r0.L$0
            com.unity3d.ads.adplayer.AndroidFullscreenWebViewAdPlayer r2 = (com.unity3d.ads.adplayer.AndroidFullscreenWebViewAdPlayer) r2
            r2.q.z0(r9)
            goto L84
        L49:
            java.lang.Object r2 = r0.L$0
            com.unity3d.ads.adplayer.AndroidFullscreenWebViewAdPlayer r2 = (com.unity3d.ads.adplayer.AndroidFullscreenWebViewAdPlayer) r2
            r2.q.z0(r9)
            goto L69
        L51:
            r2.q.z0(r9)
            t6.p0 r9 = com.unity3d.ads.adplayer.AndroidFullscreenWebViewAdPlayer.displayMessages
            com.unity3d.ads.adplayer.DisplayMessage$DisplayFinishRequest r2 = new com.unity3d.ads.adplayer.DisplayMessage$DisplayFinishRequest
            java.lang.String r7 = r8.opportunityId
            r2.<init>(r7)
            r0.L$0 = r8
            r0.label = r6
            java.lang.Object r9 = r9.emit(r2, r0)
            if (r9 != r1) goto L68
            goto L9e
        L68:
            r2 = r8
        L69:
            com.unity3d.ads.core.data.repository.OpenMeasurementRepository r9 = r2.openMeasurementRepository
            java.lang.String r6 = r2.opportunityId
            com.google.protobuf.ByteString r6 = com.google.protobuf.kotlin.ByteStringsKt.toByteStringUtf8(r6)
            boolean r9 = r9.hasSessionFinished(r6)
            if (r9 == 0) goto L84
            r0.L$0 = r2
            r0.label = r5
            r5 = 1000(0x3e8, double:4.94E-321)
            java.lang.Object r9 = q6.c0.k(r5, r0)
            if (r9 != r1) goto L84
            goto L9e
        L84:
            com.unity3d.ads.adplayer.AndroidWebViewContainer r9 = r2.getWebViewContainer()
            r0.L$0 = r2
            r0.label = r4
            java.lang.Object r9 = r9.destroy(r0)
            if (r9 != r1) goto L93
            goto L9e
        L93:
            r9 = 0
            r0.L$0 = r9
            r0.label = r3
            java.lang.Object r9 = com.unity3d.ads.adplayer.AdPlayer.DefaultImpls.destroy(r2, r0)
            if (r9 != r1) goto L9f
        L9e:
            return r1
        L9f:
            q5.x r9 = q5.x.f13520a
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.ads.adplayer.AndroidFullscreenWebViewAdPlayer.destroy(v5.c):java.lang.Object");
    }

    @Override // com.unity3d.ads.adplayer.AdPlayer
    public void dispatchShowCompleted() {
        this.webViewAdPlayer.dispatchShowCompleted();
    }

    @Override // com.unity3d.ads.adplayer.AdPlayer
    public t6.e getOnLoadEvent() {
        return this.webViewAdPlayer.getOnLoadEvent();
    }

    @Override // com.unity3d.ads.adplayer.AdPlayer
    public t6.e getOnOfferwallEvent() {
        return this.webViewAdPlayer.getOnOfferwallEvent();
    }

    @Override // com.unity3d.ads.adplayer.AdPlayer
    public t6.e getOnScarEvent() {
        return this.webViewAdPlayer.getOnScarEvent();
    }

    @Override // com.unity3d.ads.adplayer.AdPlayer
    public t6.e getOnShowEvent() {
        return this.webViewAdPlayer.getOnShowEvent();
    }

    @Override // com.unity3d.ads.adplayer.AdPlayer
    public a0 getScope() {
        return this.webViewAdPlayer.getScope();
    }

    @Override // com.unity3d.ads.adplayer.AdPlayer
    public Object onAllowedPiiChange(byte[] bArr, v5.c<? super x> cVar) {
        return this.webViewAdPlayer.onAllowedPiiChange(bArr, cVar);
    }

    @Override // com.unity3d.ads.adplayer.AdPlayer
    public Object onBroadcastEvent(String str, v5.c<? super x> cVar) {
        return this.webViewAdPlayer.onBroadcastEvent(str, cVar);
    }

    @Override // com.unity3d.ads.adplayer.AdPlayer
    public Object requestShow(Map<String, ? extends Object> map, v5.c<? super x> cVar) {
        return this.webViewAdPlayer.requestShow(map, cVar);
    }

    @Override // com.unity3d.ads.adplayer.AdPlayer
    public Object sendActivityDestroyed(v5.c<? super x> cVar) {
        return this.webViewAdPlayer.sendActivityDestroyed(cVar);
    }

    @Override // com.unity3d.ads.adplayer.AdPlayer
    public Object sendFocusChange(boolean z2, v5.c<? super x> cVar) {
        return this.webViewAdPlayer.sendFocusChange(z2, cVar);
    }

    @Override // com.unity3d.ads.adplayer.AdPlayer
    public Object sendGmaEvent(com.unity3d.scar.adapter.common.c cVar, v5.c<? super x> cVar2) {
        return this.webViewAdPlayer.sendGmaEvent(cVar, cVar2);
    }

    @Override // com.unity3d.ads.adplayer.AdPlayer
    public Object sendMuteChange(boolean z2, v5.c<? super x> cVar) {
        return this.webViewAdPlayer.sendMuteChange(z2, cVar);
    }

    @Override // com.unity3d.ads.adplayer.AdPlayer
    public Object sendOfferwallEvent(OfferwallEvent offerwallEvent, v5.c<? super x> cVar) {
        return this.webViewAdPlayer.sendOfferwallEvent(offerwallEvent, cVar);
    }

    @Override // com.unity3d.ads.adplayer.AdPlayer
    public Object sendPrivacyFsmChange(byte[] bArr, v5.c<? super x> cVar) {
        return this.webViewAdPlayer.sendPrivacyFsmChange(bArr, cVar);
    }

    @Override // com.unity3d.ads.adplayer.AdPlayer
    public Object sendScarBannerEvent(BannerBridge.BannerEvent bannerEvent, v5.c<? super x> cVar) {
        return this.webViewAdPlayer.sendScarBannerEvent(bannerEvent, cVar);
    }

    @Override // com.unity3d.ads.adplayer.AdPlayer
    public Object sendUserConsentChange(byte[] bArr, v5.c<? super x> cVar) {
        return this.webViewAdPlayer.sendUserConsentChange(bArr, cVar);
    }

    @Override // com.unity3d.ads.adplayer.AdPlayer
    public Object sendVisibilityChange(boolean z2, v5.c<? super x> cVar) {
        return this.webViewAdPlayer.sendVisibilityChange(z2, cVar);
    }

    @Override // com.unity3d.ads.adplayer.AdPlayer
    public Object sendVolumeChange(double d8, v5.c<? super x> cVar) {
        return this.webViewAdPlayer.sendVolumeChange(d8, cVar);
    }

    @Override // com.unity3d.ads.adplayer.AdPlayer
    public void show(ShowOptions showOptions) {
        k.e(showOptions, "showOptions");
        if (!(showOptions instanceof AndroidShowOptions)) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        AndroidShowOptions androidShowOptions = (AndroidShowOptions) showOptions;
        boolean zIsScarAd = androidShowOptions.isScarAd();
        boolean zIsOfferwallAd = androidShowOptions.isOfferwallAd();
        r rVarA = c0.a();
        final android.support.v4.media.g gVar = new android.support.v4.media.g(displayMessages, new C28471(rVarA, null));
        int i2 = 24;
        x0.o(new android.support.v4.media.g(i2, new t6.e() { // from class: com.unity3d.ads.adplayer.AndroidFullscreenWebViewAdPlayer$show$$inlined$filter$1

            /* JADX INFO: renamed from: com.unity3d.ads.adplayer.AndroidFullscreenWebViewAdPlayer$show$$inlined$filter$1$2, reason: invalid class name */
            /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
            public static final class AnonymousClass2<T> implements t6.f {
                final /* synthetic */ t6.f $this_unsafeFlow;
                final /* synthetic */ AndroidFullscreenWebViewAdPlayer this$0;

                /* JADX INFO: renamed from: com.unity3d.ads.adplayer.AndroidFullscreenWebViewAdPlayer$show$$inlined$filter$1$2$1, reason: invalid class name */
                /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
                @e(c = "com.unity3d.ads.adplayer.AndroidFullscreenWebViewAdPlayer$show$$inlined$filter$1$2", f = "AndroidFullscreenWebViewAdPlayer.kt", l = {Sdk.SDKError.Reason.STALE_CACHED_RESPONSE_VALUE}, m = "emit")
                public static final class AnonymousClass1 extends c {
                    Object L$0;
                    Object L$1;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(v5.c cVar) {
                        super(cVar);
                    }

                    @Override // x5.a
                    public final Object invokeSuspend(Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(t6.f fVar, AndroidFullscreenWebViewAdPlayer androidFullscreenWebViewAdPlayer) {
                    this.$this_unsafeFlow = fVar;
                    this.this$0 = androidFullscreenWebViewAdPlayer;
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
                        boolean r0 = r7 instanceof com.unity3d.ads.adplayer.AndroidFullscreenWebViewAdPlayer$show$$inlined$filter$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r7
                        com.unity3d.ads.adplayer.AndroidFullscreenWebViewAdPlayer$show$$inlined$filter$1$2$1 r0 = (com.unity3d.ads.adplayer.AndroidFullscreenWebViewAdPlayer$show$$inlined$filter$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.label = r1
                        goto L18
                    L13:
                        com.unity3d.ads.adplayer.AndroidFullscreenWebViewAdPlayer$show$$inlined$filter$1$2$1 r0 = new com.unity3d.ads.adplayer.AndroidFullscreenWebViewAdPlayer$show$$inlined$filter$1$2$1
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
                        com.unity3d.ads.adplayer.AndroidFullscreenWebViewAdPlayer r4 = r5.this$0
                        java.lang.String r4 = com.unity3d.ads.adplayer.AndroidFullscreenWebViewAdPlayer.access$getOpportunityId$p(r4)
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
                    throw new UnsupportedOperationException("Method not decompiled: com.unity3d.ads.adplayer.AndroidFullscreenWebViewAdPlayer$show$$inlined$filter$1.AnonymousClass2.emit(java.lang.Object, v5.c):java.lang.Object");
                }
            }

            @Override // t6.e
            public Object collect(t6.f fVar, v5.c cVar) {
                Object objCollect = gVar.collect(new AnonymousClass2(fVar, this), cVar);
                return objCollect == w5.a.f17774a ? objCollect : x.f13520a;
            }
        }, new AnonymousClass3(this)), getScope());
        x0.o(new android.support.v4.media.g(i2, this.deviceInfoRepository.getVolumeSettingsChange(), new AnonymousClass4(this)), getScope());
        final t6.e onShowEvent = this.webViewAdPlayer.getOnShowEvent();
        x0.o(new android.support.v4.media.g(i2, new t6.e() { // from class: com.unity3d.ads.adplayer.AndroidFullscreenWebViewAdPlayer$show$$inlined$filter$2

            /* JADX INFO: renamed from: com.unity3d.ads.adplayer.AndroidFullscreenWebViewAdPlayer$show$$inlined$filter$2$2, reason: invalid class name */
            /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
            public static final class AnonymousClass2<T> implements t6.f {
                final /* synthetic */ t6.f $this_unsafeFlow;

                /* JADX INFO: renamed from: com.unity3d.ads.adplayer.AndroidFullscreenWebViewAdPlayer$show$$inlined$filter$2$2$1, reason: invalid class name */
                /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
                @e(c = "com.unity3d.ads.adplayer.AndroidFullscreenWebViewAdPlayer$show$$inlined$filter$2$2", f = "AndroidFullscreenWebViewAdPlayer.kt", l = {Sdk.SDKError.Reason.STALE_CACHED_RESPONSE_VALUE}, m = "emit")
                public static final class AnonymousClass1 extends c {
                    Object L$0;
                    Object L$1;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(v5.c cVar) {
                        super(cVar);
                    }

                    @Override // x5.a
                    public final Object invokeSuspend(Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(t6.f fVar) {
                    this.$this_unsafeFlow = fVar;
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
                        boolean r0 = r7 instanceof com.unity3d.ads.adplayer.AndroidFullscreenWebViewAdPlayer$show$$inlined$filter$2.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r7
                        com.unity3d.ads.adplayer.AndroidFullscreenWebViewAdPlayer$show$$inlined$filter$2$2$1 r0 = (com.unity3d.ads.adplayer.AndroidFullscreenWebViewAdPlayer$show$$inlined$filter$2.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.label = r1
                        goto L18
                    L13:
                        com.unity3d.ads.adplayer.AndroidFullscreenWebViewAdPlayer$show$$inlined$filter$2$2$1 r0 = new com.unity3d.ads.adplayer.AndroidFullscreenWebViewAdPlayer$show$$inlined$filter$2$2$1
                        r0.<init>(r7)
                    L18:
                        java.lang.Object r7 = r0.result
                        w5.a r1 = w5.a.f17774a
                        int r2 = r0.label
                        r3 = 1
                        if (r2 == 0) goto L2f
                        if (r2 != r3) goto L27
                        r2.q.z0(r7)
                        goto L48
                    L27:
                        java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                        java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                        r6.<init>(r7)
                        throw r6
                    L2f:
                        r2.q.z0(r7)
                        t6.f r7 = r5.$this_unsafeFlow
                        r2 = r6
                        com.unity3d.ads.core.data.model.ShowEvent r2 = (com.unity3d.ads.core.data.model.ShowEvent) r2
                        boolean r4 = r2 instanceof com.unity3d.ads.core.data.model.ShowEvent.Completed
                        if (r4 != 0) goto L3f
                        boolean r2 = r2 instanceof com.unity3d.ads.core.data.model.ShowEvent.Error
                        if (r2 == 0) goto L48
                    L3f:
                        r0.label = r3
                        java.lang.Object r6 = r7.emit(r6, r0)
                        if (r6 != r1) goto L48
                        return r1
                    L48:
                        q5.x r6 = q5.x.f13520a
                        return r6
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.unity3d.ads.adplayer.AndroidFullscreenWebViewAdPlayer$show$$inlined$filter$2.AnonymousClass2.emit(java.lang.Object, v5.c):java.lang.Object");
                }
            }

            @Override // t6.e
            public Object collect(t6.f fVar, v5.c cVar) {
                Object objCollect = onShowEvent.collect(new AnonymousClass2(fVar), cVar);
                return objCollect == w5.a.f17774a ? objCollect : x.f13520a;
            }
        }, new AnonymousClass6(null)), getScope());
        x0.o(new android.support.v4.media.g(i2, this.sessionRepository.getOnChange(), new AnonymousClass7(this)), getScope());
        if (zIsScarAd || zIsOfferwallAd) {
            if (!zIsScarAd) {
                c0.u(getScope(), null, new AnonymousClass10(showOptions, null), 3);
                return;
            }
            ScarManager scarManager = this.scarManager;
            String placementId = androidShowOptions.getPlacementId();
            if (placementId == null) {
                placementId = "";
            }
            String scarQueryId = androidShowOptions.getScarQueryId();
            c0.u(getScope(), null, new AnonymousClass9(x0.p(scarManager.show(placementId, scarQueryId != null ? scarQueryId : ""), getScope(), 10), showOptions, null), 3);
            return;
        }
        SendDiagnosticEvent.DefaultImpls.invoke$default(this.sendDiagnosticEvent, "native_show_ad_viewer_fullscreen", null, null, null, getAdObject(), null, 46, null);
        Intent intent = new Intent(this.context, (Class<?>) FullScreenWebViewDisplay.class);
        intent.putExtra("opportunityId", this.opportunityId);
        Map<String, Object> unityAdsShowOptions = androidShowOptions.getUnityAdsShowOptions();
        if (unityAdsShowOptions != null) {
            intent.putExtra("showOptions", new JSONObject(unityAdsShowOptions).toString());
        }
        intent.addFlags(268500992);
        intent.putExtra("orientation", ((Number) this.orientationRepository.getResumedActivityOrientation().getValue()).intValue());
        c0.u(getScope(), null, new AnonymousClass8(rVarA, this, intent, null), 3);
    }

    @Override // com.unity3d.ads.adplayer.AdPlayer
    public AndroidWebViewContainer getWebViewContainer() {
        return this.webViewContainer;
    }
}
