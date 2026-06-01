package com.unity3d.services.core.domain.task;

import com.unity3d.services.core.configuration.Configuration;
import com.unity3d.services.core.configuration.ErrorState;
import com.unity3d.services.core.domain.ISDKDispatchers;
import kotlin.jvm.internal.k;
import q5.x;
import v5.c;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class InitializeStateError extends MetricTask<Params, x> {
    private final ISDKDispatchers dispatchers;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Params implements BaseParams {
        private final Configuration config;
        private final ErrorState errorState;
        private final Exception exception;

        public Params(ErrorState errorState, Exception exception, Configuration config) {
            k.e(errorState, "errorState");
            k.e(exception, "exception");
            k.e(config, "config");
            this.errorState = errorState;
            this.exception = exception;
            this.config = config;
        }

        public static /* synthetic */ Params copy$default(Params params, ErrorState errorState, Exception exc, Configuration configuration, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                errorState = params.errorState;
            }
            if ((i2 & 2) != 0) {
                exc = params.exception;
            }
            if ((i2 & 4) != 0) {
                configuration = params.config;
            }
            return params.copy(errorState, exc, configuration);
        }

        public final ErrorState component1() {
            return this.errorState;
        }

        public final Exception component2() {
            return this.exception;
        }

        public final Configuration component3() {
            return this.config;
        }

        public final Params copy(ErrorState errorState, Exception exception, Configuration config) {
            k.e(errorState, "errorState");
            k.e(exception, "exception");
            k.e(config, "config");
            return new Params(errorState, exception, config);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Params)) {
                return false;
            }
            Params params = (Params) obj;
            return this.errorState == params.errorState && k.a(this.exception, params.exception) && k.a(this.config, params.config);
        }

        public final Configuration getConfig() {
            return this.config;
        }

        public final ErrorState getErrorState() {
            return this.errorState;
        }

        public final Exception getException() {
            return this.exception;
        }

        public int hashCode() {
            return this.config.hashCode() + ((this.exception.hashCode() + (this.errorState.hashCode() * 31)) * 31);
        }

        public String toString() {
            return "Params(errorState=" + this.errorState + ", exception=" + this.exception + ", config=" + this.config + ')';
        }
    }

    public InitializeStateError(ISDKDispatchers dispatchers) {
        k.e(dispatchers, "dispatchers");
        this.dispatchers = dispatchers;
    }

    @Override // com.unity3d.services.core.domain.task.BaseTask
    /* JADX INFO: renamed from: doWork-gIAlu-s */
    public /* bridge */ /* synthetic */ Object mo3221doWorkgIAlus(BaseParams baseParams, c cVar) {
        return m3233doWorkgIAlus((Params) baseParams, (c<? super q5.k>) cVar);
    }

    @Override // com.unity3d.services.core.domain.task.MetricTask
    public String getMetricName() {
        return getMetricNameForInitializeTask("error");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX INFO: renamed from: doWork-gIAlu-s, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object m3233doWorkgIAlus(com.unity3d.services.core.domain.task.InitializeStateError.Params r6, v5.c<? super q5.k> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof com.unity3d.services.core.domain.task.InitializeStateError$doWork$1
            if (r0 == 0) goto L13
            r0 = r7
            com.unity3d.services.core.domain.task.InitializeStateError$doWork$1 r0 = (com.unity3d.services.core.domain.task.InitializeStateError$doWork$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.unity3d.services.core.domain.task.InitializeStateError$doWork$1 r0 = new com.unity3d.services.core.domain.task.InitializeStateError$doWork$1
            r0.<init>(r5, r7)
        L18:
            java.lang.Object r7 = r0.result
            w5.a r1 = w5.a.f17774a
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L2f
            if (r2 != r3) goto L27
            r2.q.z0(r7)
            goto L47
        L27:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L2f:
            r2.q.z0(r7)
            com.unity3d.services.core.domain.ISDKDispatchers r7 = r5.dispatchers
            q6.w r7 = r7.getDefault()
            com.unity3d.services.core.domain.task.InitializeStateError$doWork$2 r2 = new com.unity3d.services.core.domain.task.InitializeStateError$doWork$2
            r4 = 0
            r2.<init>(r6, r4)
            r0.label = r3
            java.lang.Object r7 = q6.c0.H(r2, r7, r0)
            if (r7 != r1) goto L47
            return r1
        L47:
            q5.k r7 = (q5.k) r7
            java.lang.Object r6 = r7.f13501a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.services.core.domain.task.InitializeStateError.m3233doWorkgIAlus(com.unity3d.services.core.domain.task.InitializeStateError$Params, v5.c):java.lang.Object");
    }
}
