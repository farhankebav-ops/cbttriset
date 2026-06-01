package com.unity3d.ads.core.domain;

import androidx.core.app.NotificationCompat;
import com.google.protobuf.ByteString;
import com.unity3d.ads.UnityAdsShowOptions;
import com.unity3d.ads.adplayer.AdPlayer;
import com.unity3d.ads.core.configuration.GameServerIdReader;
import com.unity3d.ads.core.data.model.AdObject;
import com.unity3d.ads.core.data.model.AdObjectState;
import com.unity3d.ads.core.data.model.ShowEvent;
import com.unity3d.ads.core.data.repository.AdRepository;
import com.unity3d.ads.core.domain.SendDiagnosticEvent;
import com.vungle.ads.internal.protos.Sdk;
import e6.p;
import e6.q;
import kotlin.jvm.internal.k;
import q5.x;
import t6.d1;
import t6.f;
import t6.s;
import v5.c;
import x5.e;
import x5.i;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class AndroidShow implements Show {
    private final AdRepository adRepository;
    private final GameServerIdReader gameServerIdReader;
    private final SendDiagnosticEvent sendDiagnosticEvent;

    /* JADX INFO: renamed from: com.unity3d.ads.core.domain.AndroidShow$invoke$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.unity3d.ads.core.domain.AndroidShow$invoke$1", f = "AndroidShow.kt", l = {Sdk.SDKMetric.SDKMetricType.APP_BACKGROUND_DURING_AD_LOAD_VALUE}, m = "invokeSuspend")
    public static final class AnonymousClass1 extends i implements p {
        final /* synthetic */ AdObject $adObject;
        final /* synthetic */ UnityAdsShowOptions $showOptions;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ AndroidShow this$0;

        /* JADX INFO: renamed from: com.unity3d.ads.core.domain.AndroidShow$invoke$1$2, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        @e(c = "com.unity3d.ads.core.domain.AndroidShow$invoke$1$2", f = "AndroidShow.kt", l = {}, m = "invokeSuspend")
        public static final class AnonymousClass2 extends i implements p {
            final /* synthetic */ AdObject $ad;
            final /* synthetic */ AdObject $adObject;
            final /* synthetic */ UnityAdsShowOptions $showOptions;
            int label;
            final /* synthetic */ AndroidShow this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass2(AdObject adObject, AndroidShow androidShow, AdObject adObject2, UnityAdsShowOptions unityAdsShowOptions, c<? super AnonymousClass2> cVar) {
                super(2, cVar);
                this.$ad = adObject;
                this.this$0 = androidShow;
                this.$adObject = adObject2;
                this.$showOptions = unityAdsShowOptions;
            }

            @Override // x5.a
            public final c<x> create(Object obj, c<?> cVar) {
                return new AnonymousClass2(this.$ad, this.this$0, this.$adObject, this.$showOptions, cVar);
            }

            /* JADX WARN: Removed duplicated region for block: B:11:0x0028  */
            @Override // x5.a
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final java.lang.Object invokeSuspend(java.lang.Object r13) throws java.lang.Throwable {
                /*
                    r12 = this;
                    w5.a r0 = w5.a.f17774a
                    int r0 = r12.label
                    if (r0 != 0) goto Lb2
                    r2.q.z0(r13)
                    com.unity3d.ads.core.data.model.AdObject r13 = r12.$ad
                    com.unity3d.ads.core.domain.AndroidShow r0 = r12.this$0
                    com.unity3d.ads.core.configuration.GameServerIdReader r0 = com.unity3d.ads.core.domain.AndroidShow.access$getGameServerIdReader$p(r0)
                    com.unity3d.services.core.misc.JsonStorage r1 = r0.getJsonStorage()
                    java.lang.String r2 = r0.getKey()
                    java.lang.Object r1 = r1.get(r2)
                    r2 = 0
                    if (r1 == 0) goto L28
                    boolean r3 = r1 instanceof java.lang.String
                    if (r3 == 0) goto L25
                    goto L26
                L25:
                    r1 = r2
                L26:
                    if (r1 != 0) goto L29
                L28:
                    r1 = r2
                L29:
                    com.unity3d.services.core.misc.JsonStorage r3 = r0.getJsonStorage()
                    java.lang.String r4 = r0.getKey()
                    java.lang.Object r3 = r3.get(r4)
                    if (r3 == 0) goto L42
                    com.unity3d.services.core.misc.JsonStorage r3 = r0.getJsonStorage()
                    java.lang.String r0 = r0.getKey()
                    r3.delete(r0)
                L42:
                    java.lang.String r1 = (java.lang.String) r1
                    r13.setPlayerServerId(r1)
                    com.unity3d.ads.core.data.model.AdObject r13 = r12.$adObject
                    t6.q0 r13 = r13.getState()
                    com.unity3d.ads.core.data.model.AdObjectState r0 = com.unity3d.ads.core.data.model.AdObjectState.SHOWING
                    t6.d1 r13 = (t6.d1) r13
                    r13.h(r0)
                    com.unity3d.ads.core.domain.AndroidShow r13 = r12.this$0
                    com.unity3d.ads.core.domain.SendDiagnosticEvent r3 = com.unity3d.ads.core.domain.AndroidShow.access$getSendDiagnosticEvent$p(r13)
                    com.unity3d.ads.core.data.model.AdObject r8 = r12.$adObject
                    r10 = 46
                    r11 = 0
                    java.lang.String r4 = "native_show_event_flow_started"
                    r5 = 0
                    r6 = 0
                    r7 = 0
                    r9 = 0
                    com.unity3d.ads.core.domain.SendDiagnosticEvent.DefaultImpls.invoke$default(r3, r4, r5, r6, r7, r8, r9, r10, r11)
                    com.unity3d.ads.core.data.model.AdObject r13 = r12.$ad
                    com.unity3d.ads.adplayer.AdPlayer r13 = r13.getAdPlayer()
                    com.unity3d.ads.UnityAdsShowOptions r0 = r12.$showOptions
                    if (r0 == 0) goto L7c
                    org.json.JSONObject r0 = r0.getData()
                    if (r0 == 0) goto L7c
                    java.util.Map r2 = com.unity3d.ads.core.extensions.JSONObjectExtensionsKt.toBuiltInMap(r0)
                L7c:
                    r4 = r2
                    com.unity3d.ads.core.data.model.AdObject r0 = r12.$ad
                    boolean r6 = r0.isScarAd()
                    com.unity3d.ads.core.data.model.AdObject r0 = r12.$ad
                    java.lang.String r8 = r0.getScarAdString()
                    com.unity3d.ads.core.data.model.AdObject r0 = r12.$ad
                    java.lang.String r7 = r0.getScarQueryId()
                    com.unity3d.ads.core.data.model.AdObject r0 = r12.$ad
                    java.lang.String r9 = r0.getScarAdUnitId()
                    com.unity3d.ads.core.data.model.AdObject r0 = r12.$ad
                    boolean r10 = r0.isOfferwallAd()
                    com.unity3d.ads.core.data.model.AdObject r0 = r12.$ad
                    java.lang.String r11 = r0.getOfferwallPlacementName()
                    com.unity3d.ads.core.data.model.AdObject r0 = r12.$ad
                    java.lang.String r5 = r0.getPlacementId()
                    com.unity3d.ads.adplayer.AndroidShowOptions r3 = new com.unity3d.ads.adplayer.AndroidShowOptions
                    r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11)
                    r13.show(r3)
                    q5.x r13 = q5.x.f13520a
                    return r13
                Lb2:
                    java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
                    java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                    r13.<init>(r0)
                    throw r13
                */
                throw new UnsupportedOperationException("Method not decompiled: com.unity3d.ads.core.domain.AndroidShow.AnonymousClass1.AnonymousClass2.invokeSuspend(java.lang.Object):java.lang.Object");
            }

            @Override // e6.p
            public final Object invoke(f fVar, c<? super x> cVar) {
                return ((AnonymousClass2) create(fVar, cVar)).invokeSuspend(x.f13520a);
            }
        }

        /* JADX INFO: renamed from: com.unity3d.ads.core.domain.AndroidShow$invoke$1$3, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        @e(c = "com.unity3d.ads.core.domain.AndroidShow$invoke$1$3", f = "AndroidShow.kt", l = {}, m = "invokeSuspend")
        public static final class AnonymousClass3 extends i implements q {
            final /* synthetic */ AdObject $adObject;
            final /* synthetic */ ByteString $opportunityId;
            int label;
            final /* synthetic */ AndroidShow this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass3(AndroidShow androidShow, AdObject adObject, ByteString byteString, c<? super AnonymousClass3> cVar) {
                super(3, cVar);
                this.this$0 = androidShow;
                this.$adObject = adObject;
                this.$opportunityId = byteString;
            }

            @Override // x5.a
            public final Object invokeSuspend(Object obj) throws Throwable {
                w5.a aVar = w5.a.f17774a;
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                r2.q.z0(obj);
                SendDiagnosticEvent.DefaultImpls.invoke$default(this.this$0.sendDiagnosticEvent, "native_show_event_flow_completed", null, null, null, this.$adObject, null, 46, null);
                ((d1) this.$adObject.getState()).h(AdObjectState.COMPLETED);
                this.this$0.adRepository.removeAd(this.$opportunityId);
                return x.f13520a;
            }

            @Override // e6.q
            public final Object invoke(f fVar, Throwable th, c<? super x> cVar) {
                return new AnonymousClass3(this.this$0, this.$adObject, this.$opportunityId, cVar).invokeSuspend(x.f13520a);
            }
        }

        /* JADX INFO: renamed from: com.unity3d.ads.core.domain.AndroidShow$invoke$1$4, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        @e(c = "com.unity3d.ads.core.domain.AndroidShow$invoke$1$4", f = "AndroidShow.kt", l = {Sdk.SDKMetric.SDKMetricType.INIT_TO_FAIL_CALLBACK_DURATION_MS_VALUE}, m = "invokeSuspend")
        public static final class AnonymousClass4 extends i implements q {
            private /* synthetic */ Object L$0;
            /* synthetic */ Object L$1;
            int label;

            public AnonymousClass4(c<? super AnonymousClass4> cVar) {
                super(3, cVar);
            }

            @Override // x5.a
            public final Object invokeSuspend(Object obj) throws Throwable {
                ShowEvent showEvent;
                w5.a aVar = w5.a.f17774a;
                int i2 = this.label;
                if (i2 == 0) {
                    r2.q.z0(obj);
                    f fVar = (f) this.L$0;
                    ShowEvent showEvent2 = (ShowEvent) this.L$1;
                    this.L$0 = showEvent2;
                    this.label = 1;
                    if (fVar.emit(showEvent2, this) == aVar) {
                        return aVar;
                    }
                    showEvent = showEvent2;
                } else {
                    if (i2 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    showEvent = (ShowEvent) this.L$0;
                    r2.q.z0(obj);
                }
                return Boolean.valueOf(((showEvent instanceof ShowEvent.Completed) || (showEvent instanceof ShowEvent.Error)) ? false : true);
            }

            @Override // e6.q
            public final Object invoke(f fVar, ShowEvent showEvent, c<? super Boolean> cVar) {
                AnonymousClass4 anonymousClass4 = new AnonymousClass4(cVar);
                anonymousClass4.L$0 = fVar;
                anonymousClass4.L$1 = showEvent;
                return anonymousClass4.invokeSuspend(x.f13520a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(AdObject adObject, AndroidShow androidShow, UnityAdsShowOptions unityAdsShowOptions, c<? super AnonymousClass1> cVar) {
            super(2, cVar);
            this.$adObject = adObject;
            this.this$0 = androidShow;
            this.$showOptions = unityAdsShowOptions;
        }

        @Override // x5.a
        public final c<x> create(Object obj, c<?> cVar) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$adObject, this.this$0, this.$showOptions, cVar);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            w5.a aVar = w5.a.f17774a;
            int i2 = this.label;
            if (i2 == 0) {
                r2.q.z0(obj);
                final f fVar = (f) this.L$0;
                if (this.$adObject.getOpportunityId().isEmpty()) {
                    throw new IllegalArgumentException("No opportunityId");
                }
                ByteString opportunityId = this.$adObject.getOpportunityId();
                AdObject ad = this.this$0.adRepository.getAd(opportunityId);
                if (ad == null) {
                    throw new IllegalStateException("No ad associated with opportunityId");
                }
                SendDiagnosticEvent.DefaultImpls.invoke$default(this.this$0.sendDiagnosticEvent, "native_show_started_ad_viewer", null, null, null, this.$adObject, null, 46, null);
                AdPlayer adPlayer = ad.getAdPlayer();
                if (adPlayer == null) {
                    throw new IllegalStateException("No adPlayer associated with ad");
                }
                a4.a aVar2 = new a4.a(new s6.q(new t6.q(new s(new AnonymousClass2(ad, this.this$0, this.$adObject, this.$showOptions, null), adPlayer.getOnShowEvent()), new AnonymousClass3(this.this$0, this.$adObject, opportunityId, null)), new AnonymousClass4(null), (c) null));
                final AndroidShow androidShow = this.this$0;
                final AdObject adObject = this.$adObject;
                f fVar2 = new f() { // from class: com.unity3d.ads.core.domain.AndroidShow.invoke.1.5
                    @Override // t6.f
                    public /* bridge */ /* synthetic */ Object emit(Object obj2, c cVar) {
                        return emit((ShowEvent) obj2, (c<? super x>) cVar);
                    }

                    public final Object emit(ShowEvent showEvent, c<? super x> cVar) {
                        SendDiagnosticEvent.DefaultImpls.invoke$default(androidShow.sendDiagnosticEvent, "native_show_event_flow_collected", null, r5.x.e0(new q5.i(NotificationCompat.CATEGORY_EVENT, showEvent.getClass().getSimpleName())), null, adObject, null, 42, null);
                        Object objEmit = fVar.emit(showEvent, cVar);
                        return objEmit == w5.a.f17774a ? objEmit : x.f13520a;
                    }
                };
                this.label = 1;
                if (aVar2.collect(fVar2, this) == aVar) {
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
        public final Object invoke(f fVar, c<? super x> cVar) {
            return ((AnonymousClass1) create(fVar, cVar)).invokeSuspend(x.f13520a);
        }
    }

    public AndroidShow(AdRepository adRepository, GameServerIdReader gameServerIdReader, SendDiagnosticEvent sendDiagnosticEvent) {
        k.e(adRepository, "adRepository");
        k.e(gameServerIdReader, "gameServerIdReader");
        k.e(sendDiagnosticEvent, "sendDiagnosticEvent");
        this.adRepository = adRepository;
        this.gameServerIdReader = gameServerIdReader;
        this.sendDiagnosticEvent = sendDiagnosticEvent;
    }

    @Override // com.unity3d.ads.core.domain.Show
    public t6.e invoke(AdObject adObject, UnityAdsShowOptions unityAdsShowOptions) {
        k.e(adObject, "adObject");
        return new a4.a(new AnonymousClass1(adObject, this, unityAdsShowOptions, null));
    }

    @Override // com.unity3d.ads.core.domain.Show
    public Object terminate(AdObject adObject, c<? super x> cVar) {
        Object objDestroy;
        AdPlayer adPlayer = adObject.getAdPlayer();
        return (adPlayer == null || (objDestroy = adPlayer.destroy(cVar)) != w5.a.f17774a) ? x.f13520a : objDestroy;
    }
}
