package com.unity3d.services.core.domain.task;

import com.unity3d.services.core.configuration.Configuration;
import com.unity3d.services.core.domain.ISDKDispatchers;
import kotlin.jvm.internal.k;
import v5.c;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class InitializeStateConfig extends MetricTask<Params, Configuration> {
    private final ISDKDispatchers dispatchers;
    private final InitializeStateConfigWithLoader initializeStateConfigWithLoader;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Params implements BaseParams {
        private final Configuration config;

        public Params(Configuration config) {
            k.e(config, "config");
            this.config = config;
        }

        public static /* synthetic */ Params copy$default(Params params, Configuration configuration, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                configuration = params.config;
            }
            return params.copy(configuration);
        }

        public final Configuration component1() {
            return this.config;
        }

        public final Params copy(Configuration config) {
            k.e(config, "config");
            return new Params(config);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Params) && k.a(this.config, ((Params) obj).config);
        }

        public final Configuration getConfig() {
            return this.config;
        }

        public int hashCode() {
            return this.config.hashCode();
        }

        public String toString() {
            return "Params(config=" + this.config + ')';
        }
    }

    public InitializeStateConfig(ISDKDispatchers dispatchers, InitializeStateConfigWithLoader initializeStateConfigWithLoader) {
        k.e(dispatchers, "dispatchers");
        k.e(initializeStateConfigWithLoader, "initializeStateConfigWithLoader");
        this.dispatchers = dispatchers;
        this.initializeStateConfigWithLoader = initializeStateConfigWithLoader;
    }

    @Override // com.unity3d.services.core.domain.task.BaseTask
    /* JADX INFO: renamed from: doWork-gIAlu-s */
    public /* bridge */ /* synthetic */ Object mo3221doWorkgIAlus(BaseParams baseParams, c cVar) {
        return m3229doWorkgIAlus((Params) baseParams, (c<? super q5.k>) cVar);
    }

    @Override // com.unity3d.services.core.domain.task.MetricTask
    public String getMetricName() {
        return getMetricNameForInitializeTask("config_fetch");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX INFO: renamed from: doWork-gIAlu-s, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object m3229doWorkgIAlus(com.unity3d.services.core.domain.task.InitializeStateConfig.Params r6, v5.c<? super q5.k> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof com.unity3d.services.core.domain.task.InitializeStateConfig$doWork$1
            if (r0 == 0) goto L13
            r0 = r7
            com.unity3d.services.core.domain.task.InitializeStateConfig$doWork$1 r0 = (com.unity3d.services.core.domain.task.InitializeStateConfig$doWork$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.unity3d.services.core.domain.task.InitializeStateConfig$doWork$1 r0 = new com.unity3d.services.core.domain.task.InitializeStateConfig$doWork$1
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
            com.unity3d.services.core.domain.task.InitializeStateConfig$doWork$2 r2 = new com.unity3d.services.core.domain.task.InitializeStateConfig$doWork$2
            r4 = 0
            r2.<init>(r6, r5, r4)
            r0.label = r3
            java.lang.Object r7 = q6.c0.H(r2, r7, r0)
            if (r7 != r1) goto L47
            return r1
        L47:
            q5.k r7 = (q5.k) r7
            java.lang.Object r6 = r7.f13501a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.services.core.domain.task.InitializeStateConfig.m3229doWorkgIAlus(com.unity3d.services.core.domain.task.InitializeStateConfig$Params, v5.c):java.lang.Object");
    }
}
