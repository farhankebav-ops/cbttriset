package com.unity3d.ads.core.data.manager;

import android.content.Context;
import android.support.v4.media.g;
import com.unity3d.ads.core.domain.scar.CommonScarEventReceiver;
import com.unity3d.ads.core.domain.scar.GmaEventData;
import com.unity3d.ads.core.domain.scar.ScarTimeHackFixer;
import com.unity3d.ads.core.extensions.AdFormatExtensions;
import com.unity3d.services.ads.gmascar.GMAScarAdapterBridge;
import com.unity3d.services.ads.gmascar.handlers.BiddingSignalsHandler;
import com.unity3d.services.ads.gmascar.listeners.IBiddingSignalsListener;
import com.unity3d.services.ads.gmascar.models.BiddingSignals;
import com.unity3d.services.banners.BannerView;
import com.unity3d.services.banners.UnityBannerSize;
import com.unity3d.services.core.di.ServiceProvider;
import com.vungle.ads.internal.protos.Sdk;
import e6.p;
import gatewayprotocol.v1.AdFormatOuterClass;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.k;
import q5.x;
import q6.a0;
import q6.c0;
import q6.l;
import r2.q;
import r5.j;
import r5.m;
import t6.f;
import t6.s;
import t6.x0;
import u3.d;
import v5.c;
import x5.e;
import x5.i;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class AndroidScarManager implements ScarManager {
    private final GMAScarAdapterBridge gmaBridge;
    private final CommonScarEventReceiver scarEventReceiver;
    private final ScarTimeHackFixer scarTimeHackFixer;

    /* JADX INFO: renamed from: com.unity3d.ads.core.data.manager.AndroidScarManager$getSignals$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.unity3d.ads.core.data.manager.AndroidScarManager$getSignals$2", f = "AndroidScarManager.kt", l = {Sdk.SDKError.Reason.STORE_REGION_CODE_ERROR_VALUE}, m = "invokeSuspend")
    public static final class AnonymousClass2 extends i implements p {
        final /* synthetic */ List<AdFormatOuterClass.AdFormat> $adFormat;
        Object L$0;
        Object L$1;
        int label;
        final /* synthetic */ AndroidScarManager this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass2(List<? extends AdFormatOuterClass.AdFormat> list, AndroidScarManager androidScarManager, c<? super AnonymousClass2> cVar) {
            super(2, cVar);
            this.$adFormat = list;
            this.this$0 = androidScarManager;
        }

        @Override // x5.a
        public final c<x> create(Object obj, c<?> cVar) {
            return new AnonymousClass2(this.$adFormat, this.this$0, cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            ArrayList arrayList;
            w5.a aVar = w5.a.f17774a;
            int i2 = this.label;
            if (i2 != 0) {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                q.z0(obj);
                return obj;
            }
            q.z0(obj);
            List<AdFormatOuterClass.AdFormat> list = this.$adFormat;
            AndroidScarManager androidScarManager = this.this$0;
            this.L$0 = list;
            this.L$1 = androidScarManager;
            this.label = 1;
            final l lVar = new l(1, a.a.I(this));
            lVar.r();
            if (list != null) {
                arrayList = new ArrayList();
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    d unityAdFormat = AdFormatExtensions.toUnityAdFormat((AdFormatOuterClass.AdFormat) it.next());
                    if (unityAdFormat == d.f17531a) {
                        unityAdFormat = null;
                    }
                    if (unityAdFormat != null) {
                        arrayList.add(unityAdFormat);
                    }
                }
            } else {
                arrayList = null;
            }
            if (arrayList == null || arrayList.isEmpty()) {
                lVar.resumeWith(null);
            } else {
                androidScarManager.gmaBridge.getSCARBiddingSignals(arrayList, new BiddingSignalsHandler(true, new IBiddingSignalsListener() { // from class: com.unity3d.ads.core.data.manager.AndroidScarManager$getSignals$2$1$1
                    @Override // com.unity3d.services.ads.gmascar.listeners.IBiddingSignalsListener
                    public void onSignalsFailure(String str) {
                        lVar.resumeWith(q.M(new Exception(str)));
                    }

                    @Override // com.unity3d.services.ads.gmascar.listeners.IBiddingSignalsListener
                    public void onSignalsReady(BiddingSignals biddingSignals) {
                        lVar.resumeWith(biddingSignals);
                    }
                }));
            }
            Object objP = lVar.p();
            w5.a aVar2 = w5.a.f17774a;
            return objP == aVar ? aVar : objP;
        }

        @Override // e6.p
        public final Object invoke(a0 a0Var, c<? super BiddingSignals> cVar) {
            return ((AnonymousClass2) create(a0Var, cVar)).invokeSuspend(x.f13520a);
        }
    }

    /* JADX INFO: renamed from: com.unity3d.ads.core.data.manager.AndroidScarManager$getVersion$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.unity3d.ads.core.data.manager.AndroidScarManager$getVersion$2", f = "AndroidScarManager.kt", l = {42}, m = "invokeSuspend")
    public static final class C28842 extends i implements p {
        int label;

        /* JADX INFO: renamed from: com.unity3d.ads.core.data.manager.AndroidScarManager$getVersion$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        @e(c = "com.unity3d.ads.core.data.manager.AndroidScarManager$getVersion$2$1", f = "AndroidScarManager.kt", l = {}, m = "invokeSuspend")
        public static final class AnonymousClass1 extends i implements p {
            int label;
            final /* synthetic */ AndroidScarManager this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(AndroidScarManager androidScarManager, c<? super AnonymousClass1> cVar) {
                super(2, cVar);
                this.this$0 = androidScarManager;
            }

            @Override // x5.a
            public final c<x> create(Object obj, c<?> cVar) {
                return new AnonymousClass1(this.this$0, cVar);
            }

            @Override // x5.a
            public final Object invokeSuspend(Object obj) throws Throwable {
                w5.a aVar = w5.a.f17774a;
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                q.z0(obj);
                this.this$0.gmaBridge.getVersion();
                return x.f13520a;
            }

            @Override // e6.p
            public final Object invoke(f fVar, c<? super x> cVar) {
                return ((AnonymousClass1) create(fVar, cVar)).invokeSuspend(x.f13520a);
            }
        }

        public C28842(c<? super C28842> cVar) {
            super(2, cVar);
        }

        @Override // x5.a
        public final c<x> create(Object obj, c<?> cVar) {
            return AndroidScarManager.this.new C28842(cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            w5.a aVar = w5.a.f17774a;
            int i2 = this.label;
            if (i2 != 0) {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                q.z0(obj);
                return obj;
            }
            q.z0(obj);
            g gVar = new g(AndroidScarManager.this.scarEventReceiver.getVersionFlow(), new AnonymousClass1(AndroidScarManager.this, null));
            this.label = 1;
            Object objL = x0.l(gVar, this);
            return objL == aVar ? aVar : objL;
        }

        @Override // e6.p
        public final Object invoke(a0 a0Var, c<? super String> cVar) {
            return ((C28842) create(a0Var, cVar)).invokeSuspend(x.f13520a);
        }
    }

    /* JADX INFO: renamed from: com.unity3d.ads.core.data.manager.AndroidScarManager$loadAd$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.unity3d.ads.core.data.manager.AndroidScarManager", f = "AndroidScarManager.kt", l = {93}, m = "loadAd")
    public static final class AnonymousClass1 extends x5.c {
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(c<? super AnonymousClass1> cVar) {
            super(cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AndroidScarManager.this.loadAd(null, null, null, null, null, 0, this);
        }
    }

    /* JADX INFO: renamed from: com.unity3d.ads.core.data.manager.AndroidScarManager$loadAd$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.unity3d.ads.core.data.manager.AndroidScarManager$loadAd$2", f = "AndroidScarManager.kt", l = {}, m = "invokeSuspend")
    public static final class C28852 extends i implements p {
        final /* synthetic */ String $adString;
        final /* synthetic */ String $adUnitId;
        final /* synthetic */ boolean $canSkip;
        final /* synthetic */ String $placementId;
        final /* synthetic */ String $queryId;
        final /* synthetic */ int $videoLength;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C28852(boolean z2, String str, String str2, String str3, String str4, int i2, c<? super C28852> cVar) {
            super(2, cVar);
            this.$canSkip = z2;
            this.$placementId = str;
            this.$queryId = str2;
            this.$adString = str3;
            this.$adUnitId = str4;
            this.$videoLength = i2;
        }

        @Override // x5.a
        public final c<x> create(Object obj, c<?> cVar) {
            return AndroidScarManager.this.new C28852(this.$canSkip, this.$placementId, this.$queryId, this.$adString, this.$adUnitId, this.$videoLength, cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            w5.a aVar = w5.a.f17774a;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            q.z0(obj);
            AndroidScarManager.this.gmaBridge.load(this.$canSkip, this.$placementId, this.$queryId, this.$adString, this.$adUnitId, AndroidScarManager.this.scarTimeHackFixer.invoke(this.$videoLength));
            return x.f13520a;
        }

        @Override // e6.p
        public final Object invoke(f fVar, c<? super x> cVar) {
            return ((C28852) create(fVar, cVar)).invokeSuspend(x.f13520a);
        }
    }

    /* JADX INFO: renamed from: com.unity3d.ads.core.data.manager.AndroidScarManager$loadAd$3, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.unity3d.ads.core.data.manager.AndroidScarManager$loadAd$3", f = "AndroidScarManager.kt", l = {}, m = "invokeSuspend")
    public static final class AnonymousClass3 extends i implements p {
        final /* synthetic */ String $placementId;
        /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(String str, c<? super AnonymousClass3> cVar) {
            super(2, cVar);
            this.$placementId = str;
        }

        @Override // x5.a
        public final c<x> create(Object obj, c<?> cVar) {
            AnonymousClass3 anonymousClass3 = new AnonymousClass3(this.$placementId, cVar);
            anonymousClass3.L$0 = obj;
            return anonymousClass3;
        }

        @Override // e6.p
        public final Object invoke(GmaEventData gmaEventData, c<? super Boolean> cVar) {
            return ((AnonymousClass3) create(gmaEventData, cVar)).invokeSuspend(x.f13520a);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            w5.a aVar = w5.a.f17774a;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            q.z0(obj);
            GmaEventData gmaEventData = (GmaEventData) this.L$0;
            return Boolean.valueOf((m.H0(com.unity3d.scar.adapter.common.c.k, com.unity3d.scar.adapter.common.c.f10967o).contains(gmaEventData.getGmaEvent()) && k.a(gmaEventData.getPlacementId(), this.$placementId)) || m.H0(com.unity3d.scar.adapter.common.c.E, com.unity3d.scar.adapter.common.c.f10961b, com.unity3d.scar.adapter.common.c.f10966n).contains(gmaEventData.getGmaEvent()));
        }
    }

    /* JADX INFO: renamed from: com.unity3d.ads.core.data.manager.AndroidScarManager$loadBannerAd$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.unity3d.ads.core.data.manager.AndroidScarManager$loadBannerAd$1", f = "AndroidScarManager.kt", l = {}, m = "invokeSuspend")
    public static final class C28861 extends i implements p {
        final /* synthetic */ UnityBannerSize $bannerSize;
        final /* synthetic */ BannerView $bannerView;
        final /* synthetic */ Context $context;
        final /* synthetic */ String $opportunityId;
        final /* synthetic */ u3.c $scarAdMetadata;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C28861(Context context, BannerView bannerView, String str, u3.c cVar, UnityBannerSize unityBannerSize, c<? super C28861> cVar2) {
            super(2, cVar2);
            this.$context = context;
            this.$bannerView = bannerView;
            this.$opportunityId = str;
            this.$scarAdMetadata = cVar;
            this.$bannerSize = unityBannerSize;
        }

        @Override // x5.a
        public final c<x> create(Object obj, c<?> cVar) {
            return AndroidScarManager.this.new C28861(this.$context, this.$bannerView, this.$opportunityId, this.$scarAdMetadata, this.$bannerSize, cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            w5.a aVar = w5.a.f17774a;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            q.z0(obj);
            AndroidScarManager.this.gmaBridge.loadBanner(this.$context, this.$bannerView, this.$opportunityId, this.$scarAdMetadata, this.$bannerSize);
            return x.f13520a;
        }

        @Override // e6.p
        public final Object invoke(f fVar, c<? super x> cVar) {
            return ((C28861) create(fVar, cVar)).invokeSuspend(x.f13520a);
        }
    }

    /* JADX INFO: renamed from: com.unity3d.ads.core.data.manager.AndroidScarManager$show$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.unity3d.ads.core.data.manager.AndroidScarManager$show$1", f = "AndroidScarManager.kt", l = {}, m = "invokeSuspend")
    public static final class C28871 extends i implements p {
        final /* synthetic */ String $placementId;
        final /* synthetic */ String $queryId;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C28871(String str, String str2, c<? super C28871> cVar) {
            super(2, cVar);
            this.$placementId = str;
            this.$queryId = str2;
        }

        @Override // x5.a
        public final c<x> create(Object obj, c<?> cVar) {
            return AndroidScarManager.this.new C28871(this.$placementId, this.$queryId, cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            w5.a aVar = w5.a.f17774a;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            q.z0(obj);
            AndroidScarManager.this.gmaBridge.show(this.$placementId, this.$queryId);
            return x.f13520a;
        }

        @Override // e6.p
        public final Object invoke(f fVar, c<? super x> cVar) {
            return ((C28871) create(fVar, cVar)).invokeSuspend(x.f13520a);
        }
    }

    /* JADX INFO: renamed from: com.unity3d.ads.core.data.manager.AndroidScarManager$show$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.unity3d.ads.core.data.manager.AndroidScarManager$show$2", f = "AndroidScarManager.kt", l = {127}, m = "invokeSuspend")
    public static final class C28882 extends i implements e6.q {
        private /* synthetic */ Object L$0;
        /* synthetic */ Object L$1;
        int label;

        public C28882(c<? super C28882> cVar) {
            super(3, cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            GmaEventData gmaEventData;
            w5.a aVar = w5.a.f17774a;
            int i2 = this.label;
            if (i2 == 0) {
                q.z0(obj);
                f fVar = (f) this.L$0;
                GmaEventData gmaEventData2 = (GmaEventData) this.L$1;
                this.L$0 = gmaEventData2;
                this.label = 1;
                if (fVar.emit(gmaEventData2, this) == aVar) {
                    return aVar;
                }
                gmaEventData = gmaEventData2;
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                gmaEventData = (GmaEventData) this.L$0;
                q.z0(obj);
            }
            return Boolean.valueOf(!j.Y(new com.unity3d.scar.adapter.common.c[]{com.unity3d.scar.adapter.common.c.D, com.unity3d.scar.adapter.common.c.p, com.unity3d.scar.adapter.common.c.f10972u, com.unity3d.scar.adapter.common.c.f10971t}, gmaEventData.getGmaEvent()));
        }

        @Override // e6.q
        public final Object invoke(f fVar, GmaEventData gmaEventData, c<? super Boolean> cVar) {
            C28882 c28882 = new C28882(cVar);
            c28882.L$0 = fVar;
            c28882.L$1 = gmaEventData;
            return c28882.invokeSuspend(x.f13520a);
        }
    }

    public AndroidScarManager(CommonScarEventReceiver scarEventReceiver, GMAScarAdapterBridge gmaBridge, ScarTimeHackFixer scarTimeHackFixer) {
        k.e(scarEventReceiver, "scarEventReceiver");
        k.e(gmaBridge, "gmaBridge");
        k.e(scarTimeHackFixer, "scarTimeHackFixer");
        this.scarEventReceiver = scarEventReceiver;
        this.gmaBridge = gmaBridge;
        this.scarTimeHackFixer = scarTimeHackFixer;
    }

    @Override // com.unity3d.ads.core.data.manager.ScarManager
    public Object getSignals(List<? extends AdFormatOuterClass.AdFormat> list, c<? super BiddingSignals> cVar) {
        return c0.J(ServiceProvider.SCAR_SIGNALS_FETCH_TIMEOUT, new AnonymousClass2(list, this, null), cVar);
    }

    @Override // com.unity3d.ads.core.data.manager.ScarManager
    public Object getVersion(c<? super String> cVar) {
        return c0.J(5000L, new C28842(null), cVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0016  */
    @Override // com.unity3d.ads.core.data.manager.ScarManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object loadAd(java.lang.String r15, java.lang.String r16, java.lang.String r17, java.lang.String r18, java.lang.String r19, int r20, v5.c<? super q5.x> r21) throws java.lang.Throwable {
        /*
            r14 = this;
            r0 = r21
            boolean r2 = r0 instanceof com.unity3d.ads.core.data.manager.AndroidScarManager.AnonymousClass1
            if (r2 == 0) goto L16
            r2 = r0
            com.unity3d.ads.core.data.manager.AndroidScarManager$loadAd$1 r2 = (com.unity3d.ads.core.data.manager.AndroidScarManager.AnonymousClass1) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L16
            int r3 = r3 - r4
            r2.label = r3
        L14:
            r9 = r2
            goto L1c
        L16:
            com.unity3d.ads.core.data.manager.AndroidScarManager$loadAd$1 r2 = new com.unity3d.ads.core.data.manager.AndroidScarManager$loadAd$1
            r2.<init>(r0)
            goto L14
        L1c:
            java.lang.Object r0 = r9.result
            w5.a r10 = w5.a.f17774a
            int r2 = r9.label
            r11 = 0
            r12 = 1
            if (r2 == 0) goto L34
            if (r2 != r12) goto L2c
            r2.q.z0(r0)
            goto L67
        L2c:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r2)
            throw r0
        L34:
            r2.q.z0(r0)
            java.lang.String r0 = "INTERSTITIAL"
            boolean r2 = n6.t.g0(r15, r0)
            com.unity3d.ads.core.domain.scar.CommonScarEventReceiver r0 = r14.scarEventReceiver
            t6.t0 r13 = r0.getGmaEventFlow()
            com.unity3d.ads.core.data.manager.AndroidScarManager$loadAd$2 r0 = new com.unity3d.ads.core.data.manager.AndroidScarManager$loadAd$2
            r8 = 0
            r1 = r14
            r3 = r16
            r5 = r17
            r6 = r18
            r4 = r19
            r7 = r20
            r0.<init>(r2, r3, r4, r5, r6, r7, r8)
            android.support.v4.media.g r1 = new android.support.v4.media.g
            r1.<init>(r13, r0)
            com.unity3d.ads.core.data.manager.AndroidScarManager$loadAd$3 r0 = new com.unity3d.ads.core.data.manager.AndroidScarManager$loadAd$3
            r0.<init>(r3, r11)
            r9.label = r12
            java.lang.Object r0 = t6.x0.k(r1, r0, r9)
            if (r0 != r10) goto L67
            return r10
        L67:
            r1 = r0
            com.unity3d.ads.core.domain.scar.GmaEventData r1 = (com.unity3d.ads.core.domain.scar.GmaEventData) r1
            com.unity3d.scar.adapter.common.c r1 = r1.getGmaEvent()
            com.unity3d.scar.adapter.common.c r2 = com.unity3d.scar.adapter.common.c.k
            if (r1 == r2) goto L73
            r11 = r0
        L73:
            com.unity3d.ads.core.domain.scar.GmaEventData r11 = (com.unity3d.ads.core.domain.scar.GmaEventData) r11
            if (r11 == 0) goto L96
            com.unity3d.ads.core.data.model.exception.LoadException r0 = new com.unity3d.ads.core.data.model.exception.LoadException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "Error loading SCAR ad: "
            r1.<init>(r2)
            java.lang.String r2 = r11.getErrorMessage()
            if (r2 != 0) goto L8a
            com.unity3d.scar.adapter.common.c r2 = r11.getGmaEvent()
        L8a:
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r2 = 0
            r0.<init>(r2, r1)
            throw r0
        L96:
            q5.x r0 = q5.x.f13520a
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.ads.core.data.manager.AndroidScarManager.loadAd(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, v5.c):java.lang.Object");
    }

    @Override // com.unity3d.ads.core.data.manager.ScarManager
    public t6.e loadBannerAd(Context context, BannerView bannerView, u3.c scarAdMetadata, UnityBannerSize bannerSize, final String opportunityId) {
        k.e(context, "context");
        k.e(bannerView, "bannerView");
        k.e(scarAdMetadata, "scarAdMetadata");
        k.e(bannerSize, "bannerSize");
        k.e(opportunityId, "opportunityId");
        final s sVar = new s(new C28861(context, bannerView, opportunityId, scarAdMetadata, bannerSize, null), this.scarEventReceiver.getGmaEventFlow());
        return new t6.e() { // from class: com.unity3d.ads.core.data.manager.AndroidScarManager$loadBannerAd$$inlined$filter$1

            /* JADX INFO: renamed from: com.unity3d.ads.core.data.manager.AndroidScarManager$loadBannerAd$$inlined$filter$1$2, reason: invalid class name */
            /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
            public static final class AnonymousClass2<T> implements f {
                final /* synthetic */ String $opportunityId$inlined;
                final /* synthetic */ f $this_unsafeFlow;

                /* JADX INFO: renamed from: com.unity3d.ads.core.data.manager.AndroidScarManager$loadBannerAd$$inlined$filter$1$2$1, reason: invalid class name */
                /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
                @e(c = "com.unity3d.ads.core.data.manager.AndroidScarManager$loadBannerAd$$inlined$filter$1$2", f = "AndroidScarManager.kt", l = {Sdk.SDKError.Reason.STALE_CACHED_RESPONSE_VALUE}, m = "emit")
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

                public AnonymousClass2(f fVar, String str) {
                    this.$this_unsafeFlow = fVar;
                    this.$opportunityId$inlined = str;
                }

                /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                @Override // t6.f
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final java.lang.Object emit(java.lang.Object r7, v5.c r8) throws java.lang.Throwable {
                    /*
                        r6 = this;
                        boolean r0 = r8 instanceof com.unity3d.ads.core.data.manager.AndroidScarManager$loadBannerAd$$inlined$filter$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r8
                        com.unity3d.ads.core.data.manager.AndroidScarManager$loadBannerAd$$inlined$filter$1$2$1 r0 = (com.unity3d.ads.core.data.manager.AndroidScarManager$loadBannerAd$$inlined$filter$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.label = r1
                        goto L18
                    L13:
                        com.unity3d.ads.core.data.manager.AndroidScarManager$loadBannerAd$$inlined$filter$1$2$1 r0 = new com.unity3d.ads.core.data.manager.AndroidScarManager$loadBannerAd$$inlined$filter$1$2$1
                        r0.<init>(r8)
                    L18:
                        java.lang.Object r8 = r0.result
                        w5.a r1 = w5.a.f17774a
                        int r2 = r0.label
                        r3 = 1
                        if (r2 == 0) goto L2f
                        if (r2 != r3) goto L27
                        r2.q.z0(r8)
                        goto L54
                    L27:
                        java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                        java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                        r7.<init>(r8)
                        throw r7
                    L2f:
                        r2.q.z0(r8)
                        t6.f r8 = r6.$this_unsafeFlow
                        r2 = r7
                        com.unity3d.ads.core.domain.scar.GmaEventData r2 = (com.unity3d.ads.core.domain.scar.GmaEventData) r2
                        com.unity3d.scar.adapter.common.c r4 = r2.getGmaEvent()
                        com.unity3d.scar.adapter.common.c r5 = com.unity3d.scar.adapter.common.c.F
                        if (r4 != r5) goto L54
                        java.lang.String r2 = r2.getOpportunityId()
                        java.lang.String r4 = r6.$opportunityId$inlined
                        boolean r2 = kotlin.jvm.internal.k.a(r2, r4)
                        if (r2 == 0) goto L54
                        r0.label = r3
                        java.lang.Object r7 = r8.emit(r7, r0)
                        if (r7 != r1) goto L54
                        return r1
                    L54:
                        q5.x r7 = q5.x.f13520a
                        return r7
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.unity3d.ads.core.data.manager.AndroidScarManager$loadBannerAd$$inlined$filter$1.AnonymousClass2.emit(java.lang.Object, v5.c):java.lang.Object");
                }
            }

            @Override // t6.e
            public Object collect(f fVar, c cVar) {
                Object objCollect = sVar.collect(new AnonymousClass2(fVar, opportunityId), cVar);
                return objCollect == w5.a.f17774a ? objCollect : x.f13520a;
            }
        };
    }

    @Override // com.unity3d.ads.core.data.manager.ScarManager
    public t6.e show(String placementId, String queryId) {
        k.e(placementId, "placementId");
        k.e(queryId, "queryId");
        return new a4.a(new s6.q(new g(this.scarEventReceiver.getGmaEventFlow(), new C28871(placementId, queryId, null)), new C28882(null), (c) null));
    }
}
