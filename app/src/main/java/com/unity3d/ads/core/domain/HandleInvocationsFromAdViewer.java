package com.unity3d.ads.core.domain;

import android.support.v4.media.g;
import com.unity3d.ads.adplayer.ExposedFunction;
import com.unity3d.ads.adplayer.ExposedFunctionLocation;
import com.unity3d.ads.adplayer.Invocation;
import com.unity3d.ads.core.data.model.AdData;
import com.unity3d.ads.core.data.model.AdDataRefreshToken;
import com.unity3d.ads.core.data.model.AdObject;
import com.unity3d.ads.core.data.model.ImpressionConfig;
import com.unity3d.services.core.di.IServiceComponent;
import com.unity3d.services.core.di.IServiceProvider;
import e6.l;
import e6.p;
import java.util.Map;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;
import q5.x;
import r2.q;
import t6.t0;
import v5.c;
import x5.e;
import x5.i;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class HandleInvocationsFromAdViewer implements IServiceComponent {
    public static final Companion Companion = new Companion(null);
    public static final String KEY_AD_DATA = "adData";
    public static final String KEY_AD_DATA_REFRESH_TOKEN = "adDataRefreshToken";
    public static final String KEY_AD_STRING = "adString";
    public static final String KEY_AD_TYPE = "type";
    public static final String KEY_AD_UNIT_ID = "adUnitId";
    public static final String KEY_DOWNLOAD_PRIORITY = "priority";
    public static final String KEY_DOWNLOAD_URL = "url";
    public static final String KEY_IMPRESSION_CONFIG = "impressionConfig";
    public static final String KEY_IS_HEADER_BIDDING = "isHeaderBidding";
    public static final String KEY_LOAD_OPTIONS = "loadOptions";
    public static final String KEY_NATIVE_CONTEXT = "nativeContext";
    public static final String KEY_OMID = "openMeasurement";
    public static final String KEY_OMJS_SERVICE = "serviceFilePath";
    public static final String KEY_OMJS_SESSION = "sessionFilePath";
    public static final String KEY_OM_PARTNER = "partnerName";
    public static final String KEY_OM_PARTNER_VERSION = "partnerVersion";
    public static final String KEY_OM_VERSION = "version";
    public static final String KEY_PACKAGE_NAME = "packageName";
    public static final String KEY_PLACEMENT_ID = "placementId";
    public static final String KEY_PLACEMENT_NAME = "placementName";
    public static final String KEY_PRIVACY_UPDATE_CONTENT = "content";
    public static final String KEY_PRIVACY_UPDATE_VERSION = "version";
    public static final String KEY_QUERY_ID = "queryId";
    public static final String KEY_TRACKING_TOKEN = "trackingToken";
    public static final String KEY_VIDEO_LENGTH = "videoLength";

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Companion {
        public /* synthetic */ Companion(f fVar) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: renamed from: com.unity3d.ads.core.domain.HandleInvocationsFromAdViewer$invoke$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.unity3d.ads.core.domain.HandleInvocationsFromAdViewer$invoke$1", f = "HandleInvocationsFromAdViewer.kt", l = {184}, m = "invokeSuspend")
    public static final class AnonymousClass1 extends i implements p {
        final /* synthetic */ l $onSubscription;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(l lVar, c<? super AnonymousClass1> cVar) {
            super(2, cVar);
            this.$onSubscription = lVar;
        }

        @Override // x5.a
        public final c<x> create(Object obj, c<?> cVar) {
            return new AnonymousClass1(this.$onSubscription, cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            w5.a aVar = w5.a.f17774a;
            int i2 = this.label;
            if (i2 == 0) {
                q.z0(obj);
                l lVar = this.$onSubscription;
                this.label = 1;
                if (lVar.invoke(this) == aVar) {
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
        public final Object invoke(t6.f fVar, c<? super x> cVar) {
            return ((AnonymousClass1) create(fVar, cVar)).invokeSuspend(x.f13520a);
        }
    }

    /* JADX INFO: renamed from: com.unity3d.ads.core.domain.HandleInvocationsFromAdViewer$invoke$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.unity3d.ads.core.domain.HandleInvocationsFromAdViewer$invoke$2", f = "HandleInvocationsFromAdViewer.kt", l = {188}, m = "invokeSuspend")
    public static final class AnonymousClass2 extends i implements p {
        final /* synthetic */ Map<String, e6.a> $definition;
        /* synthetic */ Object L$0;
        int label;

        /* JADX INFO: renamed from: com.unity3d.ads.core.domain.HandleInvocationsFromAdViewer$invoke$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        @e(c = "com.unity3d.ads.core.domain.HandleInvocationsFromAdViewer$invoke$2$1", f = "HandleInvocationsFromAdViewer.kt", l = {188}, m = "invokeSuspend")
        public static final class AnonymousClass1 extends i implements l {
            final /* synthetic */ ExposedFunction $exposedFunction;
            final /* synthetic */ Invocation $it;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(ExposedFunction exposedFunction, Invocation invocation, c<? super AnonymousClass1> cVar) {
                super(1, cVar);
                this.$exposedFunction = exposedFunction;
                this.$it = invocation;
            }

            @Override // x5.a
            public final c<x> create(c<?> cVar) {
                return new AnonymousClass1(this.$exposedFunction, this.$it, cVar);
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
                ExposedFunction exposedFunction = this.$exposedFunction;
                Object[] parameters = this.$it.getParameters();
                this.label = 1;
                Object objInvoke = exposedFunction.invoke(parameters, this);
                return objInvoke == aVar ? aVar : objInvoke;
            }

            @Override // e6.l
            public final Object invoke(c<Object> cVar) {
                return ((AnonymousClass1) create(cVar)).invokeSuspend(x.f13520a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass2(Map<String, ? extends e6.a> map, c<? super AnonymousClass2> cVar) {
            super(2, cVar);
            this.$definition = map;
        }

        @Override // x5.a
        public final c<x> create(Object obj, c<?> cVar) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$definition, cVar);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // e6.p
        public final Object invoke(Invocation invocation, c<? super x> cVar) {
            return ((AnonymousClass2) create(invocation, cVar)).invokeSuspend(x.f13520a);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            ExposedFunction exposedFunction;
            w5.a aVar = w5.a.f17774a;
            int i2 = this.label;
            x xVar = x.f13520a;
            if (i2 == 0) {
                q.z0(obj);
                Invocation invocation = (Invocation) this.L$0;
                e6.a aVar2 = this.$definition.get(invocation.getLocation());
                if (aVar2 != null && (exposedFunction = (ExposedFunction) aVar2.invoke()) != null) {
                    AnonymousClass1 anonymousClass1 = new AnonymousClass1(exposedFunction, invocation, null);
                    this.label = 1;
                    if (invocation.handle(anonymousClass1, this) == aVar) {
                        return aVar;
                    }
                }
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                q.z0(obj);
            }
            return xVar;
        }
    }

    @Override // com.unity3d.services.core.di.IServiceComponent
    public IServiceProvider getServiceProvider() {
        return IServiceComponent.DefaultImpls.getServiceProvider(this);
    }

    public final t6.e invoke(t0 onInvocations, String adData, String adDataRefreshToken, String impressionConfig, AdObject adObject, l onSubscription) {
        k.e(onInvocations, "onInvocations");
        k.e(adData, "adData");
        k.e(adDataRefreshToken, "adDataRefreshToken");
        k.e(impressionConfig, "impressionConfig");
        k.e(adObject, "adObject");
        k.e(onSubscription, "onSubscription");
        return new g(24, new g(onInvocations, new AnonymousClass1(onSubscription, null)), new AnonymousClass2(r5.x.f0(new q5.i(ExposedFunctionLocation.GET_AD_CONTEXT, new HandleInvocationsFromAdViewer$invoke$definition$1(this, AdData.m3186constructorimpl(adData), ImpressionConfig.m3200constructorimpl(impressionConfig), AdDataRefreshToken.m3193constructorimpl(adDataRefreshToken), adObject)), new q5.i(ExposedFunctionLocation.GET_CONNECTION_TYPE, new HandleInvocationsFromAdViewer$invoke$definition$2(this)), new q5.i(ExposedFunctionLocation.GET_DEVICE_VOLUME, new HandleInvocationsFromAdViewer$invoke$definition$3(this)), new q5.i(ExposedFunctionLocation.GET_DEVICE_MAX_VOLUME, new HandleInvocationsFromAdViewer$invoke$definition$4(this)), new q5.i(ExposedFunctionLocation.GET_SCREEN_HEIGHT, new HandleInvocationsFromAdViewer$invoke$definition$5(this)), new q5.i(ExposedFunctionLocation.GET_SCREEN_WIDTH, new HandleInvocationsFromAdViewer$invoke$definition$6(this)), new q5.i(ExposedFunctionLocation.OPEN_URL, new HandleInvocationsFromAdViewer$invoke$definition$7(this)), new q5.i(ExposedFunctionLocation.SET_ORIENTATION, new HandleInvocationsFromAdViewer$invoke$definition$8(adObject)), new q5.i(ExposedFunctionLocation.SEND_OPERATIVE_EVENT, new HandleInvocationsFromAdViewer$invoke$definition$9(this, adObject)), new q5.i(ExposedFunctionLocation.STORAGE_WRITE, HandleInvocationsFromAdViewer$invoke$definition$10.INSTANCE), new q5.i(ExposedFunctionLocation.STORAGE_READ, HandleInvocationsFromAdViewer$invoke$definition$11.INSTANCE), new q5.i(ExposedFunctionLocation.STORAGE_DELETE, HandleInvocationsFromAdViewer$invoke$definition$12.INSTANCE), new q5.i(ExposedFunctionLocation.STORAGE_CLEAR, HandleInvocationsFromAdViewer$invoke$definition$13.INSTANCE), new q5.i(ExposedFunctionLocation.STORAGE_GET_KEYS, HandleInvocationsFromAdViewer$invoke$definition$14.INSTANCE), new q5.i(ExposedFunctionLocation.STORAGE_GET, HandleInvocationsFromAdViewer$invoke$definition$15.INSTANCE), new q5.i(ExposedFunctionLocation.STORAGE_SET, HandleInvocationsFromAdViewer$invoke$definition$16.INSTANCE), new q5.i(ExposedFunctionLocation.GET_PRIVACY_FSM, new HandleInvocationsFromAdViewer$invoke$definition$17(this)), new q5.i(ExposedFunctionLocation.SET_PRIVACY_FSM, new HandleInvocationsFromAdViewer$invoke$definition$18(this)), new q5.i(ExposedFunctionLocation.GET_PRIVACY, new HandleInvocationsFromAdViewer$invoke$definition$19(this)), new q5.i(ExposedFunctionLocation.SET_PRIVACY, new HandleInvocationsFromAdViewer$invoke$definition$20(this)), new q5.i(ExposedFunctionLocation.GET_ALLOWED_PII, new HandleInvocationsFromAdViewer$invoke$definition$21(this)), new q5.i(ExposedFunctionLocation.SET_ALLOWED_PII, new HandleInvocationsFromAdViewer$invoke$definition$22(this)), new q5.i(ExposedFunctionLocation.GET_SESSION_TOKEN, new HandleInvocationsFromAdViewer$invoke$definition$23(this)), new q5.i(ExposedFunctionLocation.MARK_CAMPAIGN_STATE_SHOWN, new HandleInvocationsFromAdViewer$invoke$definition$24(this, adObject)), new q5.i(ExposedFunctionLocation.REFRESH_AD_DATA, new HandleInvocationsFromAdViewer$invoke$definition$25(this, adObject)), new q5.i(ExposedFunctionLocation.UPDATE_CAMPAIGN_STATE, new HandleInvocationsFromAdViewer$invoke$definition$26(this, adObject)), new q5.i(ExposedFunctionLocation.UPDATE_TRACKING_TOKEN, new HandleInvocationsFromAdViewer$invoke$definition$27(adObject)), new q5.i(ExposedFunctionLocation.SEND_PRIVACY_UPDATE_REQUEST, new HandleInvocationsFromAdViewer$invoke$definition$28(this)), new q5.i(ExposedFunctionLocation.SEND_DIAGNOSTIC_EVENT, new HandleInvocationsFromAdViewer$invoke$definition$29(this, adObject)), new q5.i(ExposedFunctionLocation.INCREMENT_BANNER_IMPRESSION_COUNT, new HandleInvocationsFromAdViewer$invoke$definition$30(this)), new q5.i(ExposedFunctionLocation.DOWNLOAD, new HandleInvocationsFromAdViewer$invoke$definition$31(this, adObject)), new q5.i(ExposedFunctionLocation.IS_FILE_CACHED, new HandleInvocationsFromAdViewer$invoke$definition$32(this)), new q5.i(ExposedFunctionLocation.OM_START_SESSION, new HandleInvocationsFromAdViewer$invoke$definition$33(this, adObject)), new q5.i(ExposedFunctionLocation.OM_FINISH_SESSION, new HandleInvocationsFromAdViewer$invoke$definition$34(this, adObject)), new q5.i(ExposedFunctionLocation.OM_IMPRESSION, new HandleInvocationsFromAdViewer$invoke$definition$35(this, adObject)), new q5.i(ExposedFunctionLocation.OM_GET_DATA, new HandleInvocationsFromAdViewer$invoke$definition$36(this)), new q5.i(ExposedFunctionLocation.IS_ATTRIBUTION_AVAILABLE, new HandleInvocationsFromAdViewer$invoke$definition$37(this)), new q5.i(ExposedFunctionLocation.ATTRIBUTION_REGISTER_VIEW, new HandleInvocationsFromAdViewer$invoke$definition$38(this, adObject)), new q5.i(ExposedFunctionLocation.ATTRIBUTION_REGISTER_CLICK, new HandleInvocationsFromAdViewer$invoke$definition$39(this, adObject)), new q5.i(ExposedFunctionLocation.LOAD_SCAR_AD, new HandleInvocationsFromAdViewer$invoke$definition$40(this, adObject)), new q5.i(ExposedFunctionLocation.SHOW_SCAR_AD, HandleInvocationsFromAdViewer$invoke$definition$41.INSTANCE), new q5.i(ExposedFunctionLocation.HEADER_BIDDING_TOKEN_INCREMENT_WINS, new HandleInvocationsFromAdViewer$invoke$definition$42(this)), new q5.i(ExposedFunctionLocation.HEADER_BIDDING_TOKEN_INCREMENT_STARTS, new HandleInvocationsFromAdViewer$invoke$definition$43(this)), new q5.i(ExposedFunctionLocation.HEADER_BIDDING_TOKEN_RESET, new HandleInvocationsFromAdViewer$invoke$definition$44(this)), new q5.i(ExposedFunctionLocation.LOAD_OFFERWALL_AD, new HandleInvocationsFromAdViewer$invoke$definition$45(this, adObject)), new q5.i(ExposedFunctionLocation.SHOW_OFFERWALL_AD, HandleInvocationsFromAdViewer$invoke$definition$46.INSTANCE), new q5.i(ExposedFunctionLocation.IS_OFFERWALL_AD_READY, new HandleInvocationsFromAdViewer$invoke$definition$47(this)), new q5.i(ExposedFunctionLocation.REQUEST_GET, new HandleInvocationsFromAdViewer$invoke$definition$48(this)), new q5.i(ExposedFunctionLocation.REQUEST_POST, new HandleInvocationsFromAdViewer$invoke$definition$49(this)), new q5.i(ExposedFunctionLocation.REQUEST_HEAD, new HandleInvocationsFromAdViewer$invoke$definition$50(this)), new q5.i(ExposedFunctionLocation.SET_OPPORTUNITY_TTL, new HandleInvocationsFromAdViewer$invoke$definition$51(adObject))), null));
    }
}
