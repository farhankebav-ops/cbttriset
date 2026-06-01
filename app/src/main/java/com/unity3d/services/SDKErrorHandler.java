package com.unity3d.services;

import com.unity3d.ads.core.configuration.AlternativeFlowReader;
import com.unity3d.ads.core.domain.SendDiagnosticEvent;
import com.unity3d.ads.core.extensions.ExceptionExtensionsKt;
import com.unity3d.services.core.log.DeviceLog;
import com.unity3d.services.core.request.metrics.Metric;
import com.unity3d.services.core.request.metrics.SDKMetricsSender;
import e6.p;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;
import q6.a0;
import q6.c0;
import q6.w;
import q6.x;
import q6.y;
import q6.z;
import r2.q;
import v5.c;
import v5.g;
import v5.h;
import w5.a;
import x5.e;
import x5.i;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class SDKErrorHandler implements y {
    public static final Companion Companion = new Companion(null);
    public static final String UNITY_PACKAGE = "com.unity3d";
    public static final String UNKNOWN_FILE = "unknown";
    private final AlternativeFlowReader alternativeFlowReader;
    private final w ioDispatcher;
    private final x key;
    private final a0 scope;
    private final SDKMetricsSender sdkMetricsSender;
    private final SendDiagnosticEvent sendDiagnosticEvent;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Companion {
        public /* synthetic */ Companion(f fVar) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: renamed from: com.unity3d.services.SDKErrorHandler$sendDiagnostic$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.unity3d.services.SDKErrorHandler$sendDiagnostic$1", f = "SDKErrorHandler.kt", l = {}, m = "invokeSuspend")
    public static final class AnonymousClass1 extends i implements p {
        final /* synthetic */ String $name;
        final /* synthetic */ String $reason;
        final /* synthetic */ String $scopeName;
        final /* synthetic */ String $stackTrace;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(String str, String str2, String str3, String str4, c<? super AnonymousClass1> cVar) {
            super(2, cVar);
            this.$name = str;
            this.$reason = str2;
            this.$stackTrace = str3;
            this.$scopeName = str4;
        }

        @Override // x5.a
        public final c<q5.x> create(Object obj, c<?> cVar) {
            return SDKErrorHandler.this.new AnonymousClass1(this.$name, this.$reason, this.$stackTrace, this.$scopeName, cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            a aVar = a.f17774a;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            q.z0(obj);
            SendDiagnosticEvent.DefaultImpls.invoke$default(SDKErrorHandler.this.sendDiagnosticEvent, this.$name, null, r5.x.f0(new q5.i("reason", this.$reason), new q5.i("reason_debug", this.$stackTrace), new q5.i("coroutine_name", this.$scopeName)), null, null, null, 58, null);
            return q5.x.f13520a;
        }

        @Override // e6.p
        public final Object invoke(a0 a0Var, c<? super q5.x> cVar) {
            return ((AnonymousClass1) create(a0Var, cVar)).invokeSuspend(q5.x.f13520a);
        }
    }

    public SDKErrorHandler(w ioDispatcher, AlternativeFlowReader alternativeFlowReader, SendDiagnosticEvent sendDiagnosticEvent, SDKMetricsSender sdkMetricsSender) {
        k.e(ioDispatcher, "ioDispatcher");
        k.e(alternativeFlowReader, "alternativeFlowReader");
        k.e(sendDiagnosticEvent, "sendDiagnosticEvent");
        k.e(sdkMetricsSender, "sdkMetricsSender");
        this.ioDispatcher = ioDispatcher;
        this.alternativeFlowReader = alternativeFlowReader;
        this.sendDiagnosticEvent = sendDiagnosticEvent;
        this.sdkMetricsSender = sdkMetricsSender;
        this.scope = c0.x(c0.b(ioDispatcher), new z("SDKErrorHandler"));
        this.key = x.f13600a;
    }

    private final String retrieveCoroutineName(h hVar) {
        String str;
        z zVar = (z) hVar.get(z.f13604b);
        return (zVar == null || (str = zVar.f13605a) == null) ? "unknown" : str;
    }

    private final void sendDiagnostic(String str, String str2, String str3, String str4) {
        c0.u(this.scope, null, new AnonymousClass1(str, str2, str4, str3, null), 3);
    }

    private final void sendMetric(Metric metric) {
        this.sdkMetricsSender.sendMetric(metric);
    }

    @Override // v5.h
    public <R> R fold(R r7, p operation) {
        k.e(operation, "operation");
        return (R) operation.invoke(r7, this);
    }

    @Override // v5.h
    public <E extends v5.f> E get(g gVar) {
        return (E) a.a.A(this, gVar);
    }

    @Override // q6.y
    public void handleException(h context, Throwable exception) {
        k.e(context, "context");
        k.e(exception, "exception");
        String strRetrieveCoroutineName = retrieveCoroutineName(context);
        String str = exception instanceof NullPointerException ? "native_exception_npe" : exception instanceof OutOfMemoryError ? "native_exception_oom" : exception instanceof IllegalStateException ? "native_exception_ise" : exception instanceof SecurityException ? "native_exception_se" : exception instanceof RuntimeException ? "native_exception_re" : "native_exception";
        boolean zInvoke = this.alternativeFlowReader.invoke();
        String strRetrieveUnityCrashValue = ExceptionExtensionsKt.retrieveUnityCrashValue(exception);
        DeviceLog.error("Unity Ads SDK encountered an exception: " + strRetrieveUnityCrashValue);
        if (zInvoke) {
            sendDiagnostic(str, strRetrieveUnityCrashValue, strRetrieveCoroutineName, ExceptionExtensionsKt.getShortenedStackTrace(exception, 15));
        } else {
            sendMetric(new Metric(str, strRetrieveUnityCrashValue, null, 4, null));
        }
    }

    @Override // v5.h
    public h minusKey(g gVar) {
        return a.a.N(this, gVar);
    }

    @Override // v5.h
    public h plus(h hVar) {
        return a.a.O(this, hVar);
    }

    @Override // v5.f
    public x getKey() {
        return this.key;
    }
}
