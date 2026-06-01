package com.onesignal.session.internal.outcomes.impl;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.onesignal.common.exceptions.BackendException;
import com.onesignal.common.threading.ThreadUtilsKt;
import com.onesignal.core.internal.config.ConfigModelStore;
import com.onesignal.core.internal.device.IDeviceService;
import com.onesignal.core.internal.startup.IStartableService;
import com.onesignal.core.internal.time.ITime;
import com.onesignal.debug.internal.logging.Logging;
import com.onesignal.session.internal.influence.IInfluenceManager;
import com.onesignal.session.internal.influence.Influence;
import com.onesignal.session.internal.influence.InfluenceChannel;
import com.onesignal.session.internal.influence.InfluenceType;
import com.onesignal.session.internal.outcomes.IOutcomeEventsController;
import com.onesignal.session.internal.session.ISessionLifecycleHandler;
import com.onesignal.session.internal.session.ISessionService;
import com.onesignal.user.internal.backend.SubscriptionObjectType;
import com.onesignal.user.internal.identity.IdentityModelStore;
import com.onesignal.user.internal.subscriptions.ISubscriptionManager;
import com.vungle.ads.internal.protos.Sdk;
import e6.l;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.jvm.internal.k;
import q5.x;
import r2.q;
import w5.a;
import x5.c;
import x5.e;
import x5.i;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class OutcomeEventsController implements IOutcomeEventsController, IStartableService, ISessionLifecycleHandler {
    private final ConfigModelStore _configModelStore;
    private final IDeviceService _deviceService;
    private final IdentityModelStore _identityModelStore;
    private final IInfluenceManager _influenceManager;
    private final IOutcomeEventsBackendService _outcomeEventsBackend;
    private final IOutcomeEventsRepository _outcomeEventsCache;
    private final IOutcomeEventsPreferences _outcomeEventsPreferences;
    private final ISessionService _session;
    private final ISubscriptionManager _subscriptionManager;
    private final ITime _time;
    private Set<String> unattributedUniqueOutcomeEventsSentOnSession;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[InfluenceType.values().length];
            iArr[InfluenceType.DIRECT.ordinal()] = 1;
            iArr[InfluenceType.INDIRECT.ordinal()] = 2;
            iArr[InfluenceType.UNATTRIBUTED.ordinal()] = 3;
            iArr[InfluenceType.DISABLED.ordinal()] = 4;
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[InfluenceChannel.values().length];
            iArr2[InfluenceChannel.IAM.ordinal()] = 1;
            iArr2[InfluenceChannel.NOTIFICATION.ordinal()] = 2;
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    /* JADX INFO: renamed from: com.onesignal.session.internal.outcomes.impl.OutcomeEventsController$getUniqueIds$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.onesignal.session.internal.outcomes.impl.OutcomeEventsController", f = "OutcomeEventsController.kt", l = {295}, m = "getUniqueIds")
    public static final class AnonymousClass1 extends c {
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(v5.c<? super AnonymousClass1> cVar) {
            super(cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return OutcomeEventsController.this.getUniqueIds(null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.onesignal.session.internal.outcomes.impl.OutcomeEventsController$saveAttributedUniqueOutcomeNotifications$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.onesignal.session.internal.outcomes.impl.OutcomeEventsController$saveAttributedUniqueOutcomeNotifications$1", f = "OutcomeEventsController.kt", l = {276}, m = "invokeSuspend")
    public static final class C28211 extends i implements l {
        final /* synthetic */ OutcomeEventParams $eventParams;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C28211(OutcomeEventParams outcomeEventParams, v5.c<? super C28211> cVar) {
            super(1, cVar);
            this.$eventParams = outcomeEventParams;
        }

        @Override // x5.a
        public final v5.c<x> create(v5.c<?> cVar) {
            return OutcomeEventsController.this.new C28211(this.$eventParams, cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            a aVar = a.f17774a;
            int i2 = this.label;
            if (i2 == 0) {
                q.z0(obj);
                IOutcomeEventsRepository iOutcomeEventsRepository = OutcomeEventsController.this._outcomeEventsCache;
                OutcomeEventParams outcomeEventParams = this.$eventParams;
                this.label = 1;
                if (iOutcomeEventsRepository.saveUniqueOutcomeEventParams(outcomeEventParams, this) == aVar) {
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
        public final Object invoke(v5.c<? super x> cVar) {
            return ((C28211) create(cVar)).invokeSuspend(x.f13520a);
        }
    }

    /* JADX INFO: renamed from: com.onesignal.session.internal.outcomes.impl.OutcomeEventsController$sendAndCreateOutcomeEvent$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.onesignal.session.internal.outcomes.impl.OutcomeEventsController", f = "OutcomeEventsController.kt", l = {Sdk.SDKError.Reason.AD_RESPONSE_INVALID_TEMPLATE_TYPE_VALUE, 230}, m = "sendAndCreateOutcomeEvent")
    public static final class C28221 extends c {
        long J$0;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public C28221(v5.c<? super C28221> cVar) {
            super(cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return OutcomeEventsController.this.sendAndCreateOutcomeEvent(null, 0.0f, 0L, null, this);
        }
    }

    /* JADX INFO: renamed from: com.onesignal.session.internal.outcomes.impl.OutcomeEventsController$sendSavedOutcomeEvent$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.onesignal.session.internal.outcomes.impl.OutcomeEventsController", f = "OutcomeEventsController.kt", l = {74, 76}, m = "sendSavedOutcomeEvent")
    public static final class C28231 extends c {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public C28231(v5.c<? super C28231> cVar) {
            super(cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return OutcomeEventsController.this.sendSavedOutcomeEvent(null, this);
        }
    }

    /* JADX INFO: renamed from: com.onesignal.session.internal.outcomes.impl.OutcomeEventsController$sendSavedOutcomes$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.onesignal.session.internal.outcomes.impl.OutcomeEventsController", f = "OutcomeEventsController.kt", l = {ConstraintLayout.LayoutParams.Table.LAYOUT_WRAP_BEHAVIOR_IN_PARENT, 68}, m = "sendSavedOutcomes")
    public static final class C28241 extends c {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public C28241(v5.c<? super C28241> cVar) {
            super(cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return OutcomeEventsController.this.sendSavedOutcomes(this);
        }
    }

    /* JADX INFO: renamed from: com.onesignal.session.internal.outcomes.impl.OutcomeEventsController$sendUniqueOutcomeEvent$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.onesignal.session.internal.outcomes.impl.OutcomeEventsController", f = "OutcomeEventsController.kt", l = {140, 153, 169}, m = "sendUniqueOutcomeEvent")
    public static final class AnonymousClass2 extends c {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass2(v5.c<? super AnonymousClass2> cVar) {
            super(cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return OutcomeEventsController.this.sendUniqueOutcomeEvent(null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.onesignal.session.internal.outcomes.impl.OutcomeEventsController$start$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.onesignal.session.internal.outcomes.impl.OutcomeEventsController$start$1", f = "OutcomeEventsController.kt", l = {45, 46}, m = "invokeSuspend")
    public static final class C28251 extends i implements l {
        int label;

        public C28251(v5.c<? super C28251> cVar) {
            super(1, cVar);
        }

        @Override // x5.a
        public final v5.c<x> create(v5.c<?> cVar) {
            return OutcomeEventsController.this.new C28251(cVar);
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x0036, code lost:
        
            if (r5.cleanCachedUniqueOutcomeEventNotifications(r4) == r0) goto L15;
         */
        @Override // x5.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r5) throws java.lang.Throwable {
            /*
                r4 = this;
                w5.a r0 = w5.a.f17774a
                int r1 = r4.label
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L1c
                if (r1 == r3) goto L18
                if (r1 != r2) goto L10
                r2.q.z0(r5)
                goto L39
            L10:
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r5.<init>(r0)
                throw r5
            L18:
                r2.q.z0(r5)
                goto L2a
            L1c:
                r2.q.z0(r5)
                com.onesignal.session.internal.outcomes.impl.OutcomeEventsController r5 = com.onesignal.session.internal.outcomes.impl.OutcomeEventsController.this
                r4.label = r3
                java.lang.Object r5 = com.onesignal.session.internal.outcomes.impl.OutcomeEventsController.access$sendSavedOutcomes(r5, r4)
                if (r5 != r0) goto L2a
                goto L38
            L2a:
                com.onesignal.session.internal.outcomes.impl.OutcomeEventsController r5 = com.onesignal.session.internal.outcomes.impl.OutcomeEventsController.this
                com.onesignal.session.internal.outcomes.impl.IOutcomeEventsRepository r5 = com.onesignal.session.internal.outcomes.impl.OutcomeEventsController.access$get_outcomeEventsCache$p(r5)
                r4.label = r2
                java.lang.Object r5 = r5.cleanCachedUniqueOutcomeEventNotifications(r4)
                if (r5 != r0) goto L39
            L38:
                return r0
            L39:
                q5.x r5 = q5.x.f13520a
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: com.onesignal.session.internal.outcomes.impl.OutcomeEventsController.C28251.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // e6.l
        public final Object invoke(v5.c<? super x> cVar) {
            return ((C28251) create(cVar)).invokeSuspend(x.f13520a);
        }
    }

    public OutcomeEventsController(ISessionService _session, IInfluenceManager _influenceManager, IOutcomeEventsRepository _outcomeEventsCache, IOutcomeEventsPreferences _outcomeEventsPreferences, IOutcomeEventsBackendService _outcomeEventsBackend, ConfigModelStore _configModelStore, IdentityModelStore _identityModelStore, ISubscriptionManager _subscriptionManager, IDeviceService _deviceService, ITime _time) {
        k.e(_session, "_session");
        k.e(_influenceManager, "_influenceManager");
        k.e(_outcomeEventsCache, "_outcomeEventsCache");
        k.e(_outcomeEventsPreferences, "_outcomeEventsPreferences");
        k.e(_outcomeEventsBackend, "_outcomeEventsBackend");
        k.e(_configModelStore, "_configModelStore");
        k.e(_identityModelStore, "_identityModelStore");
        k.e(_subscriptionManager, "_subscriptionManager");
        k.e(_deviceService, "_deviceService");
        k.e(_time, "_time");
        this._session = _session;
        this._influenceManager = _influenceManager;
        this._outcomeEventsCache = _outcomeEventsCache;
        this._outcomeEventsPreferences = _outcomeEventsPreferences;
        this._outcomeEventsBackend = _outcomeEventsBackend;
        this._configModelStore = _configModelStore;
        this._identityModelStore = _identityModelStore;
        this._subscriptionManager = _subscriptionManager;
        this._deviceService = _deviceService;
        this._time = _time;
        this.unattributedUniqueOutcomeEventsSentOnSession = new LinkedHashSet();
        Set<String> unattributedUniqueOutcomeEventsSentByChannel = _outcomeEventsPreferences.getUnattributedUniqueOutcomeEventsSentByChannel();
        this.unattributedUniqueOutcomeEventsSentOnSession = unattributedUniqueOutcomeEventsSentByChannel != null ? r5.l.q1(unattributedUniqueOutcomeEventsSentByChannel) : new LinkedHashSet<>();
        _session.subscribe(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object getUniqueIds(java.lang.String r5, java.util.List<com.onesignal.session.internal.influence.Influence> r6, v5.c<? super java.util.List<com.onesignal.session.internal.influence.Influence>> r7) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r7 instanceof com.onesignal.session.internal.outcomes.impl.OutcomeEventsController.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r7
            com.onesignal.session.internal.outcomes.impl.OutcomeEventsController$getUniqueIds$1 r0 = (com.onesignal.session.internal.outcomes.impl.OutcomeEventsController.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.onesignal.session.internal.outcomes.impl.OutcomeEventsController$getUniqueIds$1 r0 = new com.onesignal.session.internal.outcomes.impl.OutcomeEventsController$getUniqueIds$1
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.result
            w5.a r1 = w5.a.f17774a
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L2f
            if (r2 != r3) goto L27
            r2.q.z0(r7)
            goto L3d
        L27:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L2f:
            r2.q.z0(r7)
            com.onesignal.session.internal.outcomes.impl.IOutcomeEventsRepository r7 = r4._outcomeEventsCache
            r0.label = r3
            java.lang.Object r7 = r7.getNotCachedUniqueInfluencesForOutcome(r5, r6, r0)
            if (r7 != r1) goto L3d
            return r1
        L3d:
            java.util.List r7 = (java.util.List) r7
            boolean r5 = r7.isEmpty()
            if (r5 == 0) goto L47
            r5 = 0
            return r5
        L47:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.session.internal.outcomes.impl.OutcomeEventsController.getUniqueIds(java.lang.String, java.util.List, v5.c):java.lang.Object");
    }

    private final List<Influence> removeDisabledInfluences(List<Influence> list) {
        ArrayList arrayListO1 = r5.l.o1(list);
        for (Influence influence : list) {
            if (influence.getInfluenceType().isDisabled()) {
                Logging.debug$default("OutcomeEventsController.removeDisabledInfluences: Outcomes disabled for channel: " + influence.getInfluenceChannel(), null, 2, null);
                arrayListO1.remove(influence);
            }
        }
        return arrayListO1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object requestMeasureOutcomeEvent(OutcomeEventParams outcomeEventParams, v5.c<? super x> cVar) throws BackendException {
        String appId = this._configModelStore.getModel().getAppId();
        String id = this._subscriptionManager.getSubscriptions().getPush().getId();
        String value = SubscriptionObjectType.Companion.fromDeviceType(this._deviceService.getDeviceType()).getValue();
        if (id.length() == 0 || value.length() == 0) {
            throw new BackendException(0, null, null, 6, null);
        }
        OutcomeEvent outcomeEventFromOutcomeEventParamstoOutcomeEvent = OutcomeEvent.Companion.fromOutcomeEventParamstoOutcomeEvent(outcomeEventParams);
        int i2 = WhenMappings.$EnumSwitchMapping$0[outcomeEventFromOutcomeEventParamstoOutcomeEvent.getSession().ordinal()];
        Object objSendOutcomeEvent = this._outcomeEventsBackend.sendOutcomeEvent(appId, this._identityModelStore.getModel().getOnesignalId(), id, value, i2 != 1 ? i2 != 2 ? null : Boolean.FALSE : Boolean.TRUE, outcomeEventFromOutcomeEventParamstoOutcomeEvent, cVar);
        return objSendOutcomeEvent == a.f17774a ? objSendOutcomeEvent : x.f13520a;
    }

    private final void saveAttributedUniqueOutcomeNotifications(OutcomeEventParams outcomeEventParams) {
        ThreadUtilsKt.suspendifyOnThread(10, new C28211(outcomeEventParams, null));
    }

    private final void saveUnattributedUniqueOutcomeEvents() {
        this._outcomeEventsPreferences.setUnattributedUniqueOutcomeEventsSentByChannel(this.unattributedUniqueOutcomeEventsSentOnSession);
    }

    private final void saveUniqueOutcome(OutcomeEventParams outcomeEventParams) {
        if (outcomeEventParams.isUnattributed()) {
            saveUnattributedUniqueOutcomeEvents();
        } else {
            saveAttributedUniqueOutcomeNotifications(outcomeEventParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0139 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object sendAndCreateOutcomeEvent(java.lang.String r19, float r20, long r21, java.util.List<com.onesignal.session.internal.influence.Influence> r23, v5.c<? super com.onesignal.session.internal.outcomes.impl.OutcomeEvent> r24) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 314
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.session.internal.outcomes.impl.OutcomeEventsController.sendAndCreateOutcomeEvent(java.lang.String, float, long, java.util.List, v5.c):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0062, code lost:
    
        if (r8.deleteOldOutcomeEvent(r7, r0) == r1) goto L29;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object sendSavedOutcomeEvent(com.onesignal.session.internal.outcomes.impl.OutcomeEventParams r7, v5.c<? super q5.x> r8) throws java.lang.Throwable {
        /*
            r6 = this;
            boolean r0 = r8 instanceof com.onesignal.session.internal.outcomes.impl.OutcomeEventsController.C28231
            if (r0 == 0) goto L13
            r0 = r8
            com.onesignal.session.internal.outcomes.impl.OutcomeEventsController$sendSavedOutcomeEvent$1 r0 = (com.onesignal.session.internal.outcomes.impl.OutcomeEventsController.C28231) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.onesignal.session.internal.outcomes.impl.OutcomeEventsController$sendSavedOutcomeEvent$1 r0 = new com.onesignal.session.internal.outcomes.impl.OutcomeEventsController$sendSavedOutcomeEvent$1
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.result
            w5.a r1 = w5.a.f17774a
            int r2 = r0.label
            r3 = 1
            r4 = 0
            r5 = 2
            if (r2 == 0) goto L45
            if (r2 == r3) goto L39
            if (r2 != r5) goto L31
            java.lang.Object r7 = r0.L$0
            com.onesignal.session.internal.outcomes.impl.OutcomeEventParams r7 = (com.onesignal.session.internal.outcomes.impl.OutcomeEventParams) r7
            r2.q.z0(r8)     // Catch: com.onesignal.common.exceptions.BackendException -> L2f
            goto L97
        L2f:
            r8 = move-exception
            goto L65
        L31:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L39:
            java.lang.Object r7 = r0.L$1
            com.onesignal.session.internal.outcomes.impl.OutcomeEventParams r7 = (com.onesignal.session.internal.outcomes.impl.OutcomeEventParams) r7
            java.lang.Object r2 = r0.L$0
            com.onesignal.session.internal.outcomes.impl.OutcomeEventsController r2 = (com.onesignal.session.internal.outcomes.impl.OutcomeEventsController) r2
            r2.q.z0(r8)     // Catch: com.onesignal.common.exceptions.BackendException -> L2f
            goto L56
        L45:
            r2.q.z0(r8)
            r0.L$0 = r6     // Catch: com.onesignal.common.exceptions.BackendException -> L2f
            r0.L$1 = r7     // Catch: com.onesignal.common.exceptions.BackendException -> L2f
            r0.label = r3     // Catch: com.onesignal.common.exceptions.BackendException -> L2f
            java.lang.Object r8 = r6.requestMeasureOutcomeEvent(r7, r0)     // Catch: com.onesignal.common.exceptions.BackendException -> L2f
            if (r8 != r1) goto L55
            goto L64
        L55:
            r2 = r6
        L56:
            com.onesignal.session.internal.outcomes.impl.IOutcomeEventsRepository r8 = r2._outcomeEventsCache     // Catch: com.onesignal.common.exceptions.BackendException -> L2f
            r0.L$0 = r7     // Catch: com.onesignal.common.exceptions.BackendException -> L2f
            r0.L$1 = r4     // Catch: com.onesignal.common.exceptions.BackendException -> L2f
            r0.label = r5     // Catch: com.onesignal.common.exceptions.BackendException -> L2f
            java.lang.Object r7 = r8.deleteOldOutcomeEvent(r7, r0)     // Catch: com.onesignal.common.exceptions.BackendException -> L2f
            if (r7 != r1) goto L97
        L64:
            return r1
        L65:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "OutcomeEventsController.sendSavedOutcomeEvent: Sending outcome with name: "
            r0.<init>(r1)
            java.lang.String r7 = r7.getOutcomeId()
            r0.append(r7)
            java.lang.String r7 = " failed with status code: "
            r0.append(r7)
            int r7 = r8.getStatusCode()
            r0.append(r7)
            java.lang.String r7 = " and response: "
            r0.append(r7)
            java.lang.String r7 = r8.getResponse()
            r0.append(r7)
            java.lang.String r7 = "\nOutcome event was cached and will be reattempted on app cold start"
            r0.append(r7)
            java.lang.String r7 = r0.toString()
            com.onesignal.debug.internal.logging.Logging.warn$default(r7, r4, r5, r4)
        L97:
            q5.x r7 = q5.x.f13520a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.session.internal.outcomes.impl.OutcomeEventsController.sendSavedOutcomeEvent(com.onesignal.session.internal.outcomes.impl.OutcomeEventParams, v5.c):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object sendSavedOutcomes(v5.c<? super q5.x> r6) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r6 instanceof com.onesignal.session.internal.outcomes.impl.OutcomeEventsController.C28241
            if (r0 == 0) goto L13
            r0 = r6
            com.onesignal.session.internal.outcomes.impl.OutcomeEventsController$sendSavedOutcomes$1 r0 = (com.onesignal.session.internal.outcomes.impl.OutcomeEventsController.C28241) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.onesignal.session.internal.outcomes.impl.OutcomeEventsController$sendSavedOutcomes$1 r0 = new com.onesignal.session.internal.outcomes.impl.OutcomeEventsController$sendSavedOutcomes$1
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.result
            w5.a r1 = w5.a.f17774a
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L42
            if (r2 == r4) goto L3a
            if (r2 != r3) goto L32
            java.lang.Object r2 = r0.L$1
            java.util.Iterator r2 = (java.util.Iterator) r2
            java.lang.Object r4 = r0.L$0
            com.onesignal.session.internal.outcomes.impl.OutcomeEventsController r4 = (com.onesignal.session.internal.outcomes.impl.OutcomeEventsController) r4
            r2.q.z0(r6)
            goto L5b
        L32:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L3a:
            java.lang.Object r2 = r0.L$0
            com.onesignal.session.internal.outcomes.impl.OutcomeEventsController r2 = (com.onesignal.session.internal.outcomes.impl.OutcomeEventsController) r2
            r2.q.z0(r6)
            goto L53
        L42:
            r2.q.z0(r6)
            com.onesignal.session.internal.outcomes.impl.IOutcomeEventsRepository r6 = r5._outcomeEventsCache
            r0.L$0 = r5
            r0.label = r4
            java.lang.Object r6 = r6.getAllEventsToSend(r0)
            if (r6 != r1) goto L52
            goto L73
        L52:
            r2 = r5
        L53:
            java.util.List r6 = (java.util.List) r6
            java.util.Iterator r6 = r6.iterator()
            r4 = r2
            r2 = r6
        L5b:
            boolean r6 = r2.hasNext()
            if (r6 == 0) goto L74
            java.lang.Object r6 = r2.next()
            com.onesignal.session.internal.outcomes.impl.OutcomeEventParams r6 = (com.onesignal.session.internal.outcomes.impl.OutcomeEventParams) r6
            r0.L$0 = r4
            r0.L$1 = r2
            r0.label = r3
            java.lang.Object r6 = r4.sendSavedOutcomeEvent(r6, r0)
            if (r6 != r1) goto L5b
        L73:
            return r1
        L74:
            q5.x r6 = q5.x.f13520a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.session.internal.outcomes.impl.OutcomeEventsController.sendSavedOutcomes(v5.c):java.lang.Object");
    }

    private final OutcomeSourceBody setSourceChannelIds(Influence influence, OutcomeSourceBody outcomeSourceBody) {
        int i2 = WhenMappings.$EnumSwitchMapping$1[influence.getInfluenceChannel().ordinal()];
        if (i2 == 1) {
            outcomeSourceBody.setInAppMessagesIds(influence.getIds());
            return outcomeSourceBody;
        }
        if (i2 != 2) {
            return outcomeSourceBody;
        }
        outcomeSourceBody.setNotificationIds(influence.getIds());
        return outcomeSourceBody;
    }

    @Override // com.onesignal.session.internal.session.ISessionLifecycleHandler
    public void onSessionStarted() {
        Logging.debug$default("OutcomeEventsController.sessionStarted: Cleaning outcomes for new session", null, 2, null);
        this.unattributedUniqueOutcomeEventsSentOnSession = new LinkedHashSet();
        saveUnattributedUniqueOutcomeEvents();
    }

    @Override // com.onesignal.session.internal.outcomes.IOutcomeEventsController
    public Object sendOutcomeEvent(String str, v5.c<? super OutcomeEvent> cVar) {
        return sendAndCreateOutcomeEvent(str, 0.0f, 0L, this._influenceManager.getInfluences(), cVar);
    }

    @Override // com.onesignal.session.internal.outcomes.IOutcomeEventsController
    public Object sendOutcomeEventWithValue(String str, float f4, v5.c<? super OutcomeEvent> cVar) {
        return sendAndCreateOutcomeEvent(str, f4, 0L, this._influenceManager.getInfluences(), cVar);
    }

    @Override // com.onesignal.session.internal.outcomes.IOutcomeEventsController
    public Object sendSessionEndOutcomeEvent(long j, v5.c<? super OutcomeEvent> cVar) {
        List<Influence> influences = this._influenceManager.getInfluences();
        Iterator<Influence> it = influences.iterator();
        while (it.hasNext()) {
            if (it.next().getIds() != null) {
                return sendAndCreateOutcomeEvent("os__session_duration", 0.0f, j, influences, cVar);
            }
        }
        return null;
    }

    @Override // com.onesignal.session.internal.outcomes.IOutcomeEventsController
    public Object sendUniqueOutcomeEvent(String str, v5.c<? super OutcomeEvent> cVar) {
        return sendUniqueOutcomeEvent(str, this._influenceManager.getInfluences(), cVar);
    }

    @Override // com.onesignal.core.internal.startup.IStartableService
    public void start() {
        ThreadUtilsKt.suspendifyOnThread$default(0, new C28251(null), 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object sendUniqueOutcomeEvent(java.lang.String r11, java.util.List<com.onesignal.session.internal.influence.Influence> r12, v5.c<? super com.onesignal.session.internal.outcomes.impl.OutcomeEvent> r13) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 263
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.session.internal.outcomes.impl.OutcomeEventsController.sendUniqueOutcomeEvent(java.lang.String, java.util.List, v5.c):java.lang.Object");
    }

    @Override // com.onesignal.session.internal.session.ISessionLifecycleHandler
    public void onSessionActive() {
    }

    @Override // com.onesignal.session.internal.session.ISessionLifecycleHandler
    public void onSessionEnded(long j) {
    }
}
