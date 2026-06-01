package com.google.firebase.inappmessaging.internal;

import android.text.TextUtils;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.tasks.Task;
import com.google.firebase.annotations.concurrent.Blocking;
import com.google.firebase.inappmessaging.CommonTypesProto;
import com.google.firebase.inappmessaging.MessagesProto;
import com.google.firebase.inappmessaging.internal.injection.qualifiers.AppForeground;
import com.google.firebase.inappmessaging.internal.injection.qualifiers.ProgrammaticTrigger;
import com.google.firebase.inappmessaging.internal.injection.scopes.FirebaseAppScope;
import com.google.firebase.inappmessaging.internal.time.Clock;
import com.google.firebase.inappmessaging.model.InAppMessage;
import com.google.firebase.inappmessaging.model.MessageType;
import com.google.firebase.inappmessaging.model.ProtoMarshallerClient;
import com.google.firebase.inappmessaging.model.RateLimit;
import com.google.firebase.inappmessaging.model.TriggeredInAppMessage;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.protobuf.Internal;
import d5.b0;
import d5.x;
import java.util.Locale;
import java.util.Objects;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
@FirebaseAppScope
public class InAppMessageStreamManager {
    public static final String ON_FOREGROUND = "ON_FOREGROUND";
    private final AbtIntegrationHelper abtIntegrationHelper;
    private final AnalyticsEventsManager analyticsEventsManager;
    private final ApiClient apiClient;
    private final w4.a appForegroundEventFlowable;
    private final RateLimit appForegroundRateLimit;

    @Blocking
    private final Executor blockingExecutor;
    private final CampaignCacheClient campaignCacheClient;
    private final Clock clock;
    private final DataCollectionHelper dataCollectionHelper;
    private final FirebaseInstallationsApi firebaseInstallations;
    private final ImpressionStorageClient impressionStorageClient;
    private final w4.a programmaticTriggerEventFlowable;
    private final RateLimiterClient rateLimiterClient;
    private final Schedulers schedulers;
    private final TestDeviceHelper testDeviceHelper;

    /* JADX INFO: renamed from: com.google.firebase.inappmessaging.internal.InAppMessageStreamManager$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$firebase$inappmessaging$MessagesProto$Content$MessageDetailsCase;

        static {
            int[] iArr = new int[MessagesProto.Content.MessageDetailsCase.values().length];
            $SwitchMap$com$google$firebase$inappmessaging$MessagesProto$Content$MessageDetailsCase = iArr;
            try {
                iArr[MessagesProto.Content.MessageDetailsCase.BANNER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$firebase$inappmessaging$MessagesProto$Content$MessageDetailsCase[MessagesProto.Content.MessageDetailsCase.IMAGE_ONLY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$firebase$inappmessaging$MessagesProto$Content$MessageDetailsCase[MessagesProto.Content.MessageDetailsCase.MODAL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$google$firebase$inappmessaging$MessagesProto$Content$MessageDetailsCase[MessagesProto.Content.MessageDetailsCase.CARD.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public InAppMessageStreamManager(@AppForeground w4.a aVar, @ProgrammaticTrigger w4.a aVar2, CampaignCacheClient campaignCacheClient, Clock clock, ApiClient apiClient, AnalyticsEventsManager analyticsEventsManager, Schedulers schedulers, ImpressionStorageClient impressionStorageClient, RateLimiterClient rateLimiterClient, @AppForeground RateLimit rateLimit, TestDeviceHelper testDeviceHelper, FirebaseInstallationsApi firebaseInstallationsApi, DataCollectionHelper dataCollectionHelper, AbtIntegrationHelper abtIntegrationHelper, @Blocking Executor executor) {
        this.appForegroundEventFlowable = aVar;
        this.programmaticTriggerEventFlowable = aVar2;
        this.campaignCacheClient = campaignCacheClient;
        this.clock = clock;
        this.apiClient = apiClient;
        this.analyticsEventsManager = analyticsEventsManager;
        this.schedulers = schedulers;
        this.impressionStorageClient = impressionStorageClient;
        this.rateLimiterClient = rateLimiterClient;
        this.appForegroundRateLimit = rateLimit;
        this.testDeviceHelper = testDeviceHelper;
        this.dataCollectionHelper = dataCollectionHelper;
        this.firebaseInstallations = firebaseInstallationsApi;
        this.abtIntegrationHelper = abtIntegrationHelper;
        this.blockingExecutor = executor;
    }

    @VisibleForTesting
    public static r2.o cacheExpiringResponse() {
        r2.n nVarF = r2.o.f();
        nVarF.a(1L);
        return (r2.o) nVarF.build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int compareByPriority(q2.f fVar, q2.f fVar2) {
        if (fVar.d() && !fVar2.d()) {
            return -1;
        }
        if (!fVar2.d() || fVar.d()) {
            return Integer.compare(fVar.f().getValue(), fVar2.f().getValue());
        }
        return 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean containsTriggeringCondition(String str, q2.f fVar) {
        if (isAppForegroundEvent(str) && fVar.d()) {
            return true;
        }
        for (CommonTypesProto.TriggeringCondition triggeringCondition : fVar.g()) {
            if (hasFiamTrigger(triggeringCondition, str) || hasAnalyticsTrigger(triggeringCondition, str)) {
                Logging.logd("The event " + str + " is contained in the list of triggers");
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: getContentIfNotRateLimited, reason: merged with bridge method [inline-methods] */
    public s4.h lambda$createFirebaseInAppMessageStream$12(String str, q2.f fVar) {
        if (fVar.d() || !isAppForegroundEvent(str)) {
            return s4.h.a(fVar);
        }
        s4.q qVarIsRateLimited = this.rateLimiterClient.isRateLimited(this.appForegroundRateLimit);
        androidx.camera.camera2.internal.compat.workaround.c cVar = new androidx.camera.camera2.internal.compat.workaround.c(27);
        qVarIsRateLimited.getClass();
        e5.h hVar = new e5.h(0, new g5.b(new g5.b(qVarIsRateLimited, cVar, 0), new z4.a(new g5.c()), 1), new j(2));
        int i2 = 1;
        return new e5.k(hVar, new m(fVar, i2), i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: getTriggeredInAppMessageMaybe, reason: merged with bridge method [inline-methods] */
    public s4.h lambda$createFirebaseInAppMessageStream$14(String str, x4.c cVar, x4.c cVar2, x4.c cVar3, r2.o oVar) {
        Internal.ProtobufList protobufListE = oVar.e();
        int i2 = s4.d.f13683a;
        z4.b.a(protobufListE, "source is null");
        int i8 = 2;
        int i9 = 0;
        int i10 = 1;
        x xVar = new x(new x(new x(new x(new d5.m(protobufListE, i8), new k(this, i8), i9), new androidx.constraintlayout.core.state.a(str, i10), i9).b(cVar).b(cVar2).b(cVar3)), new w3.a(new androidx.constraintlayout.core.utils.a(3), 4), i10);
        int i11 = s4.d.f13683a;
        z4.b.b(i11, "bufferSize");
        return new e5.k(new d5.t(new b0(xVar, i11)), new n(this, str, i9), i9);
    }

    private static boolean hasAnalyticsTrigger(CommonTypesProto.TriggeringCondition triggeringCondition, String str) {
        return triggeringCondition.getEvent().getName().equals(str);
    }

    private static boolean hasFiamTrigger(CommonTypesProto.TriggeringCondition triggeringCondition, String str) {
        return triggeringCondition.getFiamTrigger().toString().equals(str);
    }

    private static boolean isActive(Clock clock, q2.f fVar) {
        long jD;
        long jB;
        if (q0.c.a(fVar.e(), 1)) {
            jD = fVar.h().d();
            jB = fVar.h().b();
        } else {
            if (!q0.c.a(fVar.e(), 2)) {
                return false;
            }
            jD = fVar.c().d();
            jB = fVar.c().b();
        }
        long jNow = clock.now();
        return jNow > jD && jNow < jB;
    }

    public static boolean isAppForegroundEvent(CommonTypesProto.TriggeringCondition triggeringCondition) {
        return triggeringCondition.getFiamTrigger().toString().equals(ON_FOREGROUND);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$createFirebaseInAppMessageStream$0(String str) throws Exception {
        Logging.logd("Event Triggered: " + str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public s4.h lambda$createFirebaseInAppMessageStream$11(q2.f fVar) throws Exception {
        if (fVar.d()) {
            return s4.h.a(fVar);
        }
        s4.q qVarIsImpressed = this.impressionStorageClient.isImpressed(fVar);
        j jVar = new j(8);
        qVarIsImpressed.getClass();
        int i2 = 0;
        return new e5.k(new e5.h(i2, new g5.b(new g5.b(new g5.a(qVarIsImpressed, jVar), new z4.a(new g5.c()), 1), new m(fVar, 0), i2), new j(9)), new m(fVar, 2), 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ s4.h lambda$createFirebaseInAppMessageStream$13(q2.f fVar) throws Exception {
        int i2 = AnonymousClass1.$SwitchMap$com$google$firebase$inappmessaging$MessagesProto$Content$MessageDetailsCase[fVar.getContent().getMessageDetailsCase().ordinal()];
        if (i2 == 1 || i2 == 2 || i2 == 3 || i2 == 4) {
            return s4.h.a(fVar);
        }
        Logging.logd("Filtering non-displayable message");
        return e5.e.f11264a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$createFirebaseInAppMessageStream$15(Throwable th) throws Exception {
        Logging.logw("Impressions store read fail: " + th.getMessage());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ r2.o lambda$createFirebaseInAppMessageStream$16(r2.f fVar, InstallationIdResult installationIdResult) throws Exception {
        return this.apiClient.getFiams(installationIdResult, fVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$createFirebaseInAppMessageStream$17(r2.o oVar) throws Exception {
        Locale locale = Locale.US;
        Logging.logi("Successfully fetched " + oVar.e().size() + " messages from backend");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lambda$createFirebaseInAppMessageStream$18(r2.o oVar) throws Exception {
        s4.a aVarClearImpressions = this.impressionStorageClient.clearImpressions(oVar);
        aVarClearImpressions.getClass();
        aVarClearImpressions.d(new b5.b(0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$createFirebaseInAppMessageStream$19(Throwable th) throws Exception {
        Logging.logw("Service fetch error: " + th.getMessage());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$createFirebaseInAppMessageStream$2(Throwable th) throws Exception {
        Logging.logw("Cache read error: " + th.getMessage());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public s4.h lambda$createFirebaseInAppMessageStream$20(s4.h hVar, r2.f fVar) throws Exception {
        if (!this.dataCollectionHelper.isAutomaticDataCollectionEnabled()) {
            Logging.logi("Automatic data collection is disabled, not attempting campaign fetch from service.");
            return s4.h.a(cacheExpiringResponse());
        }
        j jVar = new j(0);
        hVar.getClass();
        e5.g gVar = new e5.g(new e5.k(new e5.g(hVar, jVar, 0), new a(8, this, fVar), 1), s4.h.a(cacheExpiringResponse()), 2);
        j jVar2 = new j(1);
        w1.f fVar2 = z4.b.f17984d;
        e5.s sVar = new e5.s(new e5.s(gVar, jVar2, fVar2), new k(this, 0), fVar2);
        AnalyticsEventsManager analyticsEventsManager = this.analyticsEventsManager;
        Objects.requireNonNull(analyticsEventsManager);
        e5.s sVar2 = new e5.s(sVar, new androidx.camera.core.impl.b(analyticsEventsManager, 19), fVar2);
        TestDeviceHelper testDeviceHelper = this.testDeviceHelper;
        Objects.requireNonNull(testDeviceHelper);
        return new e5.k(new e5.s(new e5.s(sVar2, new androidx.camera.core.impl.b(testDeviceHelper, 20), fVar2), fVar2, new j(3)), new z4.a(e5.e.f11264a), 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public o7.a lambda$createFirebaseInAppMessageStream$21(String str) throws Exception {
        s4.h hVar = this.campaignCacheClient.get();
        j jVar = new j(10);
        hVar.getClass();
        w1.f fVar = z4.b.f17984d;
        int i2 = 2;
        e5.k kVar = new e5.k(new e5.s(new e5.s(hVar, jVar, fVar), fVar, new j(11)), new z4.a(e5.e.f11264a), i2);
        k kVar2 = new k(this, 3);
        int i8 = 4;
        int i9 = 1;
        o oVar = new o(this, str, new k(this, i8), new n(this, str, i9), new j(12));
        s4.h allImpressions = this.impressionStorageClient.getAllImpressions();
        androidx.camera.camera2.internal.compat.workaround.c cVar = new androidx.camera.camera2.internal.compat.workaround.c(28);
        allImpressions.getClass();
        e5.s sVar = new e5.s(allImpressions, fVar, cVar);
        r2.f fVarD = r2.f.d();
        z4.b.a(fVarD, "item is null");
        e5.k kVar3 = new e5.k(new e5.g(sVar, s4.h.a(fVarD), i2), new z4.a(s4.h.a(r2.f.d())), i2);
        s4.h hVarTaskToMaybe = taskToMaybe(this.firebaseInstallations.getId(), this.blockingExecutor);
        int i10 = 0;
        s4.h hVarTaskToMaybe2 = taskToMaybe(this.firebaseInstallations.getToken(false), this.blockingExecutor);
        androidx.camera.camera2.internal.compat.workaround.c cVar2 = new androidx.camera.camera2.internal.compat.workaround.c(29);
        z4.b.a(hVarTaskToMaybe, "source1 is null");
        z4.b.a(hVarTaskToMaybe2, "source2 is null");
        e5.h hVar2 = new e5.h(i9, new s4.k[]{hVarTaskToMaybe, hVarTaskToMaybe2}, new w1.f(cVar2));
        s4.p pVarIo = this.schedulers.io();
        z4.b.a(pVarIo, "scheduler is null");
        a aVar = new a(6, this, new e5.g(hVar2, pVarIo, i9));
        if (!shouldIgnoreCache(str)) {
            Logging.logd("Attempting to fetch campaigns using cache");
            return new d5.m(new e5.k(new e5.g(kVar, new e5.s(new e5.k(kVar3, aVar, i10), kVar2, fVar), i2), oVar, i10), i8);
        }
        Logging.logi("Forcing fetch from service rather than cache. Test Device: " + this.testDeviceHelper.isDeviceInTestMode() + " | App Fresh Install: " + this.testDeviceHelper.isAppInstallFresh());
        return new d5.m(new e5.k(new e5.k(kVar3, aVar, i10), oVar, i10), i8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$createFirebaseInAppMessageStream$4(Throwable th) throws Exception {
        Logging.logw("Cache write error: " + th.getMessage());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ s4.c lambda$createFirebaseInAppMessageStream$5(Throwable th) throws Exception {
        return c5.c.f4209a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lambda$createFirebaseInAppMessageStream$6(r2.o oVar) throws Exception {
        new c5.d(new c5.f(this.campaignCacheClient.put(oVar).c(new j(5)), new j(6), z4.b.f17983c), new j(7)).d(new b5.b(0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$createFirebaseInAppMessageStream$7(Throwable th) throws Exception {
        Logging.logw("Impression store read fail: " + th.getMessage());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$createFirebaseInAppMessageStream$9(Boolean bool) throws Exception {
        return !bool.booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$getContentIfNotRateLimited$22(Boolean bool) throws Exception {
        Logging.logi("App foreground rate limited ? : " + bool);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$getContentIfNotRateLimited$23(Boolean bool) throws Exception {
        return !bool.booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$getTriggeredInAppMessageMaybe$25(q2.f fVar) throws Exception {
        return this.testDeviceHelper.isDeviceInTestMode() || isActive(this.clock, fVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void lambda$taskToMaybe$28(s4.i iVar, Object obj) {
        u4.b bVar;
        e5.c cVar = (e5.c) iVar;
        s4.j jVar = (s4.j) cVar.f11261b;
        Object obj2 = cVar.get();
        y4.a aVar = y4.a.f17847a;
        if (obj2 != aVar && (bVar = (u4.b) cVar.getAndSet(aVar)) != aVar) {
            try {
                if (obj == null) {
                    jVar.onError(new NullPointerException("onSuccess called with null. Null values are generally not allowed in 2.x operators and sources."));
                } else {
                    jVar.onSuccess(obj);
                }
                if (bVar != null) {
                    bVar.dispose();
                }
            } catch (Throwable th) {
                if (bVar != null) {
                    bVar.dispose();
                }
                throw th;
            }
        }
        cVar.onComplete();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$taskToMaybe$29(s4.i iVar, Exception exc) {
        e5.c cVar = (e5.c) iVar;
        cVar.onError(exc);
        cVar.onComplete();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$taskToMaybe$30(Task task, Executor executor, s4.i iVar) throws Exception {
        task.addOnSuccessListener(executor, new l(iVar));
        task.addOnFailureListener(executor, new l(iVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void logImpressionStatus(q2.f fVar, Boolean bool) {
        if (q0.c.a(fVar.e(), 1)) {
            Logging.logi("Already impressed campaign " + fVar.h().c() + " ? : " + bool);
            return;
        }
        if (q0.c.a(fVar.e(), 2)) {
            Logging.logi("Already impressed experiment " + fVar.c().c() + " ? : " + bool);
        }
    }

    private boolean shouldIgnoreCache(String str) {
        return this.testDeviceHelper.isAppInstallFresh() ? isAppForegroundEvent(str) : this.testDeviceHelper.isDeviceInTestMode();
    }

    private static <T> s4.h taskToMaybe(Task<T> task, @Blocking Executor executor) {
        return new e5.d(new a(7, task, executor), 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: triggeredInAppMessage, reason: merged with bridge method [inline-methods] */
    public s4.h lambda$getTriggeredInAppMessageMaybe$27(q2.f fVar, String str) {
        String campaignId;
        String strC;
        if (!q0.c.a(fVar.e(), 1)) {
            if (q0.c.a(fVar.e(), 2)) {
                campaignId = fVar.c().getCampaignId();
                strC = fVar.c().c();
                if (!fVar.d()) {
                    this.abtIntegrationHelper.setExperimentActive(fVar.c().f());
                }
            }
            return e5.e.f11264a;
        }
        campaignId = fVar.h().getCampaignId();
        strC = fVar.h().c();
        InAppMessage inAppMessageDecode = ProtoMarshallerClient.decode(fVar.getContent(), campaignId, strC, fVar.d(), fVar.b());
        if (!inAppMessageDecode.getMessageType().equals(MessageType.UNSUPPORTED)) {
            return s4.h.a(new TriggeredInAppMessage(inAppMessageDecode, str));
        }
        return e5.e.f11264a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean validIID(InstallationIdResult installationIdResult) {
        return (TextUtils.isEmpty(installationIdResult.installationId()) || TextUtils.isEmpty(installationIdResult.installationTokenResult().getToken())) ? false : true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0094  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public s4.d createFirebaseInAppMessageStream() throws java.lang.Exception {
        /*
            r8 = this;
            w4.a r0 = r8.appForegroundEventFlowable
            com.google.firebase.inappmessaging.internal.AnalyticsEventsManager r1 = r8.analyticsEventsManager
            w4.a r1 = r1.getAnalyticsEventsFlowable()
            w4.a r2 = r8.programmaticTriggerEventFlowable
            int r3 = s4.d.f13683a
            java.lang.String r3 = "source1 is null"
            z4.b.a(r0, r3)
            java.lang.String r3 = "source2 is null"
            z4.b.a(r1, r3)
            java.lang.String r3 = "source3 is null"
            z4.b.a(r2, r3)
            r3 = 3
            o7.a[] r4 = new o7.a[r3]
            r5 = 0
            r4[r5] = r0
            r0 = 1
            r4[r0] = r1
            r1 = 2
            r4[r1] = r2
            d5.m r2 = new d5.m
            r2.<init>(r4, r0)
            int r4 = s4.d.f13683a
            java.lang.String r5 = "maxConcurrency"
            z4.b.b(r3, r5)
            java.lang.String r3 = "bufferSize"
            z4.b.b(r4, r3)
            boolean r5 = r2 instanceof a5.f
            if (r5 == 0) goto L50
            a5.f r2 = (a5.f) r2
            java.lang.Object r2 = r2.call()
            if (r2 != 0) goto L47
            d5.u r2 = d5.u.f11153b
            goto L56
        L47:
            d5.r0 r5 = new d5.r0
            r4.c r6 = z4.b.f17981a
            r5.<init>(r2, r6)
        L4e:
            r2 = r5
            goto L56
        L50:
            d5.h r5 = new d5.h
            r5.<init>(r2, r4)
            goto L4e
        L56:
            com.google.firebase.inappmessaging.internal.j r5 = new com.google.firebase.inappmessaging.internal.j
            r6 = 4
            r5.<init>(r6)
            d5.p r6 = new d5.p
            r6.<init>(r2, r5)
            com.google.firebase.inappmessaging.internal.Schedulers r2 = r8.schedulers
            s4.p r2 = r2.io()
            java.lang.String r5 = "scheduler is null"
            z4.b.a(r2, r5)
            z4.b.b(r4, r3)
            d5.b0 r7 = new d5.b0
            r7.<init>(r6, r2, r4)
            com.google.firebase.inappmessaging.internal.k r2 = new com.google.firebase.inappmessaging.internal.k
            r2.<init>(r8, r0)
            java.lang.String r0 = "prefetch"
            z4.b.b(r1, r0)
            boolean r0 = r7 instanceof a5.f
            if (r0 == 0) goto L94
            a5.f r7 = (a5.f) r7
            java.lang.Object r0 = r7.call()
            if (r0 != 0) goto L8d
            d5.u r0 = d5.u.f11153b
            goto L99
        L8d:
            d5.r0 r1 = new d5.r0
            r1.<init>(r0, r2)
            r0 = r1
            goto L99
        L94:
            d5.h r0 = new d5.h
            r0.<init>(r7, r2)
        L99:
            com.google.firebase.inappmessaging.internal.Schedulers r1 = r8.schedulers
            s4.p r1 = r1.mainThread()
            z4.b.a(r1, r5)
            z4.b.b(r4, r3)
            d5.b0 r2 = new d5.b0
            r2.<init>(r0, r1, r4)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.inappmessaging.internal.InAppMessageStreamManager.createFirebaseInAppMessageStream():s4.d");
    }

    public static boolean isAppForegroundEvent(String str) {
        return str.equals(ON_FOREGROUND);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ q2.f lambda$createFirebaseInAppMessageStream$10(q2.f fVar, Boolean bool) throws Exception {
        return fVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ q2.f lambda$getContentIfNotRateLimited$24(q2.f fVar, Boolean bool) throws Exception {
        return fVar;
    }
}
