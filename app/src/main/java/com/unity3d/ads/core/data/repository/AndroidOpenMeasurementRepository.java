package com.unity3d.ads.core.data.repository;

import android.content.Context;
import android.webkit.WebView;
import com.google.protobuf.ByteString;
import com.iab.omid.library.unity3d.adsession.AdEvents;
import com.iab.omid.library.unity3d.adsession.AdSession;
import com.iab.omid.library.unity3d.adsession.AdSessionConfiguration;
import com.iab.omid.library.unity3d.adsession.AdSessionContext;
import com.iab.omid.library.unity3d.adsession.CreativeType;
import com.iab.omid.library.unity3d.adsession.ImpressionType;
import com.iab.omid.library.unity3d.adsession.Owner;
import com.iab.omid.library.unity3d.adsession.Partner;
import com.unity3d.ads.core.data.manager.OmidManager;
import com.unity3d.ads.core.data.model.OMData;
import com.unity3d.ads.core.data.model.OMResult;
import com.unity3d.ads.core.data.model.OmidOptions;
import com.unity3d.ads.core.extensions.ExceptionExtensionsKt;
import com.unity3d.services.UnityAdsConstants;
import e6.p;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.k;
import q5.x;
import q6.a0;
import q6.c0;
import q6.w;
import r2.q;
import r5.s;
import r5.t;
import t6.d1;
import t6.q0;
import t6.x0;
import v5.c;
import w5.a;
import x5.e;
import x5.i;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class AndroidOpenMeasurementRepository implements OpenMeasurementRepository {
    private final q0 _isOMActive;
    private final q0 activeSessions;
    private final q0 finishedSessions;
    private final w mainDispatcher;
    private final OmidManager omidManager;
    private final Partner partner;

    /* JADX INFO: renamed from: com.unity3d.ads.core.data.repository.AndroidOpenMeasurementRepository$activateOM$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.unity3d.ads.core.data.repository.AndroidOpenMeasurementRepository$activateOM$2", f = "AndroidOpenMeasurementRepository.kt", l = {}, m = "invokeSuspend")
    public static final class AnonymousClass2 extends i implements p {
        final /* synthetic */ Context $context;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(Context context, c<? super AnonymousClass2> cVar) {
            super(2, cVar);
            this.$context = context;
        }

        @Override // x5.a
        public final c<x> create(Object obj, c<?> cVar) {
            return AndroidOpenMeasurementRepository.this.new AnonymousClass2(this.$context, cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            a aVar = a.f17774a;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            q.z0(obj);
            int i2 = 2;
            String str = null;
            byte b8 = 0;
            byte b9 = 0;
            byte b10 = 0;
            if (AndroidOpenMeasurementRepository.this.isOMActive()) {
                return new OMResult.Failure("om_already_active", str, i2, b10 == true ? 1 : 0);
            }
            try {
                AndroidOpenMeasurementRepository.this.omidManager.activate(this.$context);
                AndroidOpenMeasurementRepository androidOpenMeasurementRepository = AndroidOpenMeasurementRepository.this;
                androidOpenMeasurementRepository.setOMActive(androidOpenMeasurementRepository.omidManager.isActive());
                return AndroidOpenMeasurementRepository.this.isOMActive() ? OMResult.Success.INSTANCE : new OMResult.Failure("om_activate_failure_time", b9 == true ? 1 : 0, i2, b8 == true ? 1 : 0);
            } catch (Throwable th) {
                return new OMResult.Failure("uncaught_exception", ExceptionExtensionsKt.getShortenedStackTrace$default(th, 0, 1, null));
            }
        }

        @Override // e6.p
        public final Object invoke(a0 a0Var, c<? super OMResult> cVar) {
            return ((AnonymousClass2) create(a0Var, cVar)).invokeSuspend(x.f13520a);
        }
    }

    /* JADX INFO: renamed from: com.unity3d.ads.core.data.repository.AndroidOpenMeasurementRepository$finishSession$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.unity3d.ads.core.data.repository.AndroidOpenMeasurementRepository$finishSession$2", f = "AndroidOpenMeasurementRepository.kt", l = {}, m = "invokeSuspend")
    public static final class C28932 extends i implements p {
        final /* synthetic */ ByteString $opportunityId;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C28932(ByteString byteString, c<? super C28932> cVar) {
            super(2, cVar);
            this.$opportunityId = byteString;
        }

        @Override // x5.a
        public final c<x> create(Object obj, c<?> cVar) {
            return AndroidOpenMeasurementRepository.this.new C28932(this.$opportunityId, cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            a aVar = a.f17774a;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            q.z0(obj);
            int i2 = 2;
            String str = null;
            byte b8 = 0;
            byte b9 = 0;
            byte b10 = 0;
            if (!AndroidOpenMeasurementRepository.this.isOMActive()) {
                return new OMResult.Failure("om_not_active", str, i2, b10 == true ? 1 : 0);
            }
            AdSession session = AndroidOpenMeasurementRepository.this.getSession(this.$opportunityId);
            if (session == null) {
                return new OMResult.Failure("om_session_not_found", b9 == true ? 1 : 0, i2, b8 == true ? 1 : 0);
            }
            session.finish();
            AndroidOpenMeasurementRepository.this.sessionFinished(this.$opportunityId);
            return OMResult.Success.INSTANCE;
        }

        @Override // e6.p
        public final Object invoke(a0 a0Var, c<? super OMResult> cVar) {
            return ((C28932) create(a0Var, cVar)).invokeSuspend(x.f13520a);
        }
    }

    /* JADX INFO: renamed from: com.unity3d.ads.core.data.repository.AndroidOpenMeasurementRepository$impressionOccurred$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.unity3d.ads.core.data.repository.AndroidOpenMeasurementRepository$impressionOccurred$2", f = "AndroidOpenMeasurementRepository.kt", l = {}, m = "invokeSuspend")
    public static final class C28942 extends i implements p {
        final /* synthetic */ ByteString $opportunityId;
        final /* synthetic */ boolean $signalLoaded;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C28942(ByteString byteString, boolean z2, c<? super C28942> cVar) {
            super(2, cVar);
            this.$opportunityId = byteString;
            this.$signalLoaded = z2;
        }

        @Override // x5.a
        public final c<x> create(Object obj, c<?> cVar) {
            return AndroidOpenMeasurementRepository.this.new C28942(this.$opportunityId, this.$signalLoaded, cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            a aVar = a.f17774a;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            q.z0(obj);
            AdSession session = AndroidOpenMeasurementRepository.this.getSession(this.$opportunityId);
            if (session == null) {
                return new OMResult.Failure("om_session_not_found", null, 2, 0 == true ? 1 : 0);
            }
            AdEvents adEventsCreateAdEvents = AndroidOpenMeasurementRepository.this.omidManager.createAdEvents(session);
            if (this.$signalLoaded) {
                adEventsCreateAdEvents.loaded();
            }
            adEventsCreateAdEvents.impressionOccurred();
            return OMResult.Success.INSTANCE;
        }

        @Override // e6.p
        public final Object invoke(a0 a0Var, c<? super OMResult> cVar) {
            return ((C28942) create(a0Var, cVar)).invokeSuspend(x.f13520a);
        }
    }

    /* JADX INFO: renamed from: com.unity3d.ads.core.data.repository.AndroidOpenMeasurementRepository$startSession$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.unity3d.ads.core.data.repository.AndroidOpenMeasurementRepository$startSession$2", f = "AndroidOpenMeasurementRepository.kt", l = {}, m = "invokeSuspend")
    public static final class C28952 extends i implements p {
        final /* synthetic */ ByteString $opportunityId;
        final /* synthetic */ OmidOptions $options;
        final /* synthetic */ WebView $webView;
        int label;

        /* JADX INFO: renamed from: com.unity3d.ads.core.data.repository.AndroidOpenMeasurementRepository$startSession$2$WhenMappings */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[CreativeType.values().length];
                try {
                    iArr[CreativeType.HTML_DISPLAY.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[CreativeType.VIDEO.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C28952(ByteString byteString, OmidOptions omidOptions, WebView webView, c<? super C28952> cVar) {
            super(2, cVar);
            this.$opportunityId = byteString;
            this.$options = omidOptions;
            this.$webView = webView;
        }

        @Override // x5.a
        public final c<x> create(Object obj, c<?> cVar) {
            return AndroidOpenMeasurementRepository.this.new C28952(this.$opportunityId, this.$options, this.$webView, cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            AdSessionContext adSessionContextCreateHtmlAdSessionContext;
            a aVar = a.f17774a;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            q.z0(obj);
            String str = null;
            byte b8 = 0;
            byte b9 = 0;
            byte b10 = 0;
            byte b11 = 0;
            byte b12 = 0;
            byte b13 = 0;
            byte b14 = 0;
            try {
                int i2 = 2;
                if (!AndroidOpenMeasurementRepository.this.isOMActive()) {
                    return new OMResult.Failure("om_not_active", str, i2, b14 == true ? 1 : 0);
                }
                if (((Map) ((d1) AndroidOpenMeasurementRepository.this.activeSessions).getValue()).containsKey(this.$opportunityId.toStringUtf8())) {
                    return new OMResult.Failure("om_session_already_exists", b13 == true ? 1 : 0, i2, b12 == true ? 1 : 0);
                }
                CreativeType creativeType = this.$options.getCreativeType();
                if (creativeType == null) {
                    return new OMResult.Failure("om_creative_type_null", b11 == true ? 1 : 0, i2, b10 == true ? 1 : 0);
                }
                OmidManager omidManager = AndroidOpenMeasurementRepository.this.omidManager;
                ImpressionType impressionType = this.$options.getImpressionType();
                if (impressionType == null) {
                    impressionType = ImpressionType.DEFINED_BY_JAVASCRIPT;
                }
                ImpressionType impressionType2 = impressionType;
                Owner impressionOwner = this.$options.getImpressionOwner();
                if (impressionOwner == null) {
                    impressionOwner = Owner.JAVASCRIPT;
                }
                Owner owner = impressionOwner;
                Owner videoEventsOwner = this.$options.getVideoEventsOwner();
                if (videoEventsOwner == null) {
                    videoEventsOwner = Owner.JAVASCRIPT;
                }
                AdSessionConfiguration adSessionConfigurationCreateAdSessionConfiguration = omidManager.createAdSessionConfiguration(creativeType, impressionType2, owner, videoEventsOwner, this.$options.getIsolateVerificationScripts());
                int i8 = WhenMappings.$EnumSwitchMapping$0[creativeType.ordinal()];
                if (i8 == 1) {
                    adSessionContextCreateHtmlAdSessionContext = AndroidOpenMeasurementRepository.this.omidManager.createHtmlAdSessionContext(AndroidOpenMeasurementRepository.this.partner, this.$webView, null, this.$options.getCustomReferenceData());
                } else {
                    if (i8 != 2) {
                        return new OMResult.Failure("om_creative_type_invalid", b9 == true ? 1 : 0, i2, b8 == true ? 1 : 0);
                    }
                    adSessionContextCreateHtmlAdSessionContext = AndroidOpenMeasurementRepository.this.omidManager.createJavaScriptAdSessionContext(AndroidOpenMeasurementRepository.this.partner, this.$webView, null, this.$options.getCustomReferenceData());
                }
                AdSession adSessionCreateAdSession = AndroidOpenMeasurementRepository.this.omidManager.createAdSession(adSessionConfigurationCreateAdSessionConfiguration, adSessionContextCreateHtmlAdSessionContext);
                adSessionCreateAdSession.registerAdView(this.$webView);
                adSessionCreateAdSession.start();
                AndroidOpenMeasurementRepository.this.addSession(this.$opportunityId, adSessionCreateAdSession);
                return OMResult.Success.INSTANCE;
            } catch (Throwable th) {
                return new OMResult.Failure("uncaught_exception", ExceptionExtensionsKt.getShortenedStackTrace$default(th, 0, 1, null));
            }
        }

        @Override // e6.p
        public final Object invoke(a0 a0Var, c<? super OMResult> cVar) {
            return ((C28952) create(a0Var, cVar)).invokeSuspend(x.f13520a);
        }
    }

    public AndroidOpenMeasurementRepository(w mainDispatcher, OmidManager omidManager) {
        k.e(mainDispatcher, "mainDispatcher");
        k.e(omidManager, "omidManager");
        this.mainDispatcher = mainDispatcher;
        this.omidManager = omidManager;
        this.partner = Partner.createPartner(UnityAdsConstants.OpenMeasurement.OM_PARTNER_NAME, "4.16.3");
        this.activeSessions = x0.c(s.f13639a);
        this.finishedSessions = x0.c(t.f13640a);
        this._isOMActive = x0.c(Boolean.FALSE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void addSession(ByteString byteString, AdSession adSession) {
        d1 d1Var;
        Object value;
        q0 q0Var = this.activeSessions;
        do {
            d1Var = (d1) q0Var;
            value = d1Var.getValue();
        } while (!d1Var.g(value, r5.x.j0((Map) value, new q5.i(byteString.toStringUtf8(), adSession))));
    }

    private final OMData buildOmData() {
        return new OMData(this.omidManager.getVersion(), UnityAdsConstants.OpenMeasurement.OM_PARTNER_NAME, "1");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AdSession getSession(ByteString byteString) {
        return (AdSession) ((Map) ((d1) this.activeSessions).getValue()).get(byteString.toStringUtf8());
    }

    private final void removeSession(ByteString byteString) {
        d1 d1Var;
        Object value;
        LinkedHashMap linkedHashMapO0;
        q0 q0Var = this.activeSessions;
        do {
            d1Var = (d1) q0Var;
            value = d1Var.getValue();
            Map map = (Map) value;
            String stringUtf8 = byteString.toStringUtf8();
            k.d(stringUtf8, "opportunityId.toStringUtf8()");
            k.e(map, "<this>");
            linkedHashMapO0 = r5.x.o0(map);
            linkedHashMapO0.remove(stringUtf8);
        } while (!d1Var.g(value, r5.x.h0(linkedHashMapO0)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void sessionFinished(ByteString byteString) {
        d1 d1Var;
        Object value;
        LinkedHashSet linkedHashSet;
        q0 q0Var = this.finishedSessions;
        do {
            d1Var = (d1) q0Var;
            value = d1Var.getValue();
            Set set = (Set) value;
            String stringUtf8 = byteString.toStringUtf8();
            k.d(stringUtf8, "opportunityId.toStringUtf8()");
            k.e(set, "<this>");
            linkedHashSet = new LinkedHashSet(r5.x.d0(set.size() + 1));
            linkedHashSet.addAll(set);
            linkedHashSet.add(stringUtf8);
        } while (!d1Var.g(value, linkedHashSet));
        removeSession(byteString);
    }

    @Override // com.unity3d.ads.core.data.repository.OpenMeasurementRepository
    public Object activateOM(Context context, c<? super OMResult> cVar) {
        return c0.H(new AnonymousClass2(context, null), this.mainDispatcher, cVar);
    }

    @Override // com.unity3d.ads.core.data.repository.OpenMeasurementRepository
    public Object finishSession(ByteString byteString, c<? super OMResult> cVar) {
        return c0.H(new C28932(byteString, null), this.mainDispatcher, cVar);
    }

    @Override // com.unity3d.ads.core.data.repository.OpenMeasurementRepository
    public OMData getOmData() {
        return buildOmData();
    }

    @Override // com.unity3d.ads.core.data.repository.OpenMeasurementRepository
    public boolean hasSessionFinished(ByteString opportunityId) {
        k.e(opportunityId, "opportunityId");
        return ((Set) ((d1) this.finishedSessions).getValue()).contains(opportunityId.toStringUtf8());
    }

    @Override // com.unity3d.ads.core.data.repository.OpenMeasurementRepository
    public Object impressionOccurred(ByteString byteString, boolean z2, c<? super OMResult> cVar) {
        return c0.H(new C28942(byteString, z2, null), this.mainDispatcher, cVar);
    }

    @Override // com.unity3d.ads.core.data.repository.OpenMeasurementRepository
    public boolean isOMActive() {
        return ((Boolean) ((d1) this._isOMActive).getValue()).booleanValue();
    }

    @Override // com.unity3d.ads.core.data.repository.OpenMeasurementRepository
    public void setOMActive(boolean z2) {
        d1 d1Var;
        Object value;
        q0 q0Var = this._isOMActive;
        do {
            d1Var = (d1) q0Var;
            value = d1Var.getValue();
            ((Boolean) value).getClass();
        } while (!d1Var.g(value, Boolean.valueOf(z2)));
    }

    @Override // com.unity3d.ads.core.data.repository.OpenMeasurementRepository
    public Object startSession(ByteString byteString, WebView webView, OmidOptions omidOptions, c<? super OMResult> cVar) {
        return c0.H(new C28952(byteString, omidOptions, webView, null), this.mainDispatcher, cVar);
    }
}
