package com.unity3d.ads.core.data.repository;

import com.unity3d.ads.core.domain.events.GetDiagnosticEventRequest;
import com.unity3d.ads.core.utils.CoroutineTimer;
import com.unity3d.services.core.log.DeviceLog;
import e6.a;
import e6.p;
import gatewayprotocol.v1.DiagnosticEventRequestOuterClass;
import gatewayprotocol.v1.NativeConfigurationOuterClass;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.l;
import q5.x;
import q6.a0;
import q6.c0;
import q6.w;
import q6.z;
import r2.q;
import r5.r;
import t6.d1;
import t6.p0;
import t6.q0;
import t6.r0;
import t6.t0;
import t6.w0;
import t6.x0;
import v5.c;
import x5.e;
import x5.i;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class AndroidDiagnosticEventRepository implements DiagnosticEventRepository {
    private final p0 _diagnosticEvents;
    private final Set<DiagnosticEventRequestOuterClass.DiagnosticEventType> allowedEvents;
    private final q0 batch;
    private final Set<DiagnosticEventRequestOuterClass.DiagnosticEventType> blockedEvents;
    private final q0 configured;
    private final a0 coroutineScope;
    private final t0 diagnosticEvents;
    private final q0 enabled;
    private final CoroutineTimer flushTimer;
    private final GetDiagnosticEventRequest getDiagnosticEventRequest;
    private int maxBatchSize;

    /* JADX INFO: renamed from: com.unity3d.ads.core.data.repository.AndroidDiagnosticEventRepository$configure$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class AnonymousClass1 extends l implements a {
        public AnonymousClass1() {
            super(0);
        }

        @Override // e6.a
        public /* bridge */ /* synthetic */ Object invoke() {
            m3206invoke();
            return x.f13520a;
        }

        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public final void m3206invoke() {
            AndroidDiagnosticEventRepository.this.flush();
        }
    }

    /* JADX INFO: renamed from: com.unity3d.ads.core.data.repository.AndroidDiagnosticEventRepository$flush$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.unity3d.ads.core.data.repository.AndroidDiagnosticEventRepository$flush$1", f = "AndroidDiagnosticEventRepository.kt", l = {68}, m = "invokeSuspend")
    public static final class C28921 extends i implements p {
        final /* synthetic */ List<DiagnosticEventRequestOuterClass.DiagnosticEvent> $events;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C28921(List<DiagnosticEventRequestOuterClass.DiagnosticEvent> list, c<? super C28921> cVar) {
            super(2, cVar);
            this.$events = list;
        }

        @Override // x5.a
        public final c<x> create(Object obj, c<?> cVar) {
            return AndroidDiagnosticEventRepository.this.new C28921(this.$events, cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            w5.a aVar = w5.a.f17774a;
            int i2 = this.label;
            if (i2 == 0) {
                q.z0(obj);
                p0 p0Var = AndroidDiagnosticEventRepository.this._diagnosticEvents;
                List<DiagnosticEventRequestOuterClass.DiagnosticEvent> list = this.$events;
                this.label = 1;
                if (p0Var.emit(list, this) == aVar) {
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
            return ((C28921) create(a0Var, cVar)).invokeSuspend(x.f13520a);
        }
    }

    public AndroidDiagnosticEventRepository(CoroutineTimer flushTimer, GetDiagnosticEventRequest getDiagnosticEventRequest, w dispatcher) {
        k.e(flushTimer, "flushTimer");
        k.e(getDiagnosticEventRequest, "getDiagnosticEventRequest");
        k.e(dispatcher, "dispatcher");
        this.flushTimer = flushTimer;
        this.getDiagnosticEventRequest = getDiagnosticEventRequest;
        this.coroutineScope = c0.x(c0.b(dispatcher), new z("DiagnosticEventRepository"));
        this.batch = x0.c(r.f13638a);
        this.maxBatchSize = Integer.MAX_VALUE;
        this.allowedEvents = Collections.synchronizedSet(new LinkedHashSet());
        this.blockedEvents = Collections.synchronizedSet(new LinkedHashSet());
        Boolean bool = Boolean.FALSE;
        this.enabled = x0.c(bool);
        this.configured = x0.c(bool);
        w0 w0VarA = x0.a((7 & 1) != 0 ? 0 : 100, (7 & 2) == 0 ? 64 : 0, s6.a.f13718a);
        this._diagnosticEvents = w0VarA;
        this.diagnosticEvents = new r0(w0VarA);
    }

    @Override // com.unity3d.ads.core.data.repository.DiagnosticEventRepository
    public void addDiagnosticEvent(DiagnosticEventRequestOuterClass.DiagnosticEvent diagnosticEvent) {
        d1 d1Var;
        Object value;
        d1 d1Var2;
        Object value2;
        k.e(diagnosticEvent, "diagnosticEvent");
        if (!((Boolean) ((d1) this.configured).getValue()).booleanValue()) {
            q0 q0Var = this.batch;
            do {
                d1Var2 = (d1) q0Var;
                value2 = d1Var2.getValue();
            } while (!d1Var2.g(value2, r5.l.g1((List) value2, diagnosticEvent)));
            return;
        }
        if (((Boolean) ((d1) this.enabled).getValue()).booleanValue()) {
            q0 q0Var2 = this.batch;
            do {
                d1Var = (d1) q0Var2;
                value = d1Var.getValue();
            } while (!d1Var.g(value, r5.l.g1((List) value, diagnosticEvent)));
            if (((List) ((d1) this.batch).getValue()).size() >= this.maxBatchSize) {
                flush();
            }
        }
    }

    @Override // com.unity3d.ads.core.data.repository.DiagnosticEventRepository
    public void clear() {
        d1 d1Var;
        Object value;
        q0 q0Var = this.batch;
        do {
            d1Var = (d1) q0Var;
            value = d1Var.getValue();
        } while (!d1Var.g(value, r.f13638a));
    }

    @Override // com.unity3d.ads.core.data.repository.DiagnosticEventRepository
    public void configure(NativeConfigurationOuterClass.DiagnosticEventsConfiguration diagnosticsEventsConfiguration) {
        k.e(diagnosticsEventsConfiguration, "diagnosticsEventsConfiguration");
        q0 q0Var = this.configured;
        Boolean bool = Boolean.TRUE;
        d1 d1Var = (d1) q0Var;
        d1Var.getClass();
        d1Var.i(null, bool);
        q0 q0Var2 = this.enabled;
        Boolean boolValueOf = Boolean.valueOf(diagnosticsEventsConfiguration.getEnabled());
        d1 d1Var2 = (d1) q0Var2;
        d1Var2.getClass();
        d1Var2.i(null, boolValueOf);
        if (!((Boolean) ((d1) this.enabled).getValue()).booleanValue()) {
            clear();
            return;
        }
        this.maxBatchSize = diagnosticsEventsConfiguration.getMaxBatchSize();
        Set<DiagnosticEventRequestOuterClass.DiagnosticEventType> set = this.allowedEvents;
        List<DiagnosticEventRequestOuterClass.DiagnosticEventType> allowedEventsList = diagnosticsEventsConfiguration.getAllowedEventsList();
        k.d(allowedEventsList, "diagnosticsEventsConfiguration.allowedEventsList");
        set.addAll(allowedEventsList);
        Set<DiagnosticEventRequestOuterClass.DiagnosticEventType> set2 = this.blockedEvents;
        List<DiagnosticEventRequestOuterClass.DiagnosticEventType> blockedEventsList = diagnosticsEventsConfiguration.getBlockedEventsList();
        k.d(blockedEventsList, "diagnosticsEventsConfiguration.blockedEventsList");
        set2.addAll(blockedEventsList);
        this.flushTimer.start(0L, diagnosticsEventsConfiguration.getMaxBatchIntervalMs(), new AnonymousClass1());
    }

    @Override // com.unity3d.ads.core.data.repository.DiagnosticEventRepository
    public void flush() {
        d1 d1Var;
        Object value;
        if (((Boolean) ((d1) this.enabled).getValue()).booleanValue()) {
            q0 q0Var = this.batch;
            do {
                d1Var = (d1) q0Var;
                value = d1Var.getValue();
            } while (!d1Var.g(value, r.f13638a));
            List listK0 = m6.k.K0(m6.k.H0(m6.k.H0(m6.k.J0(r5.l.S0((Iterable) value), new AndroidDiagnosticEventRepository$flush$events$2(this)), new AndroidDiagnosticEventRepository$flush$events$3(this)), new AndroidDiagnosticEventRepository$flush$events$4(this)));
            if (listK0.isEmpty()) {
                return;
            }
            DeviceLog.debug("Unity Ads Sending diagnostic batch enabled: " + ((Boolean) ((d1) this.enabled).getValue()).booleanValue() + " size: " + listK0.size() + " :: " + listK0);
            c0.u(this.coroutineScope, null, new C28921(listK0, null), 3);
        }
    }

    @Override // com.unity3d.ads.core.data.repository.DiagnosticEventRepository
    public t0 getDiagnosticEvents() {
        return this.diagnosticEvents;
    }
}
