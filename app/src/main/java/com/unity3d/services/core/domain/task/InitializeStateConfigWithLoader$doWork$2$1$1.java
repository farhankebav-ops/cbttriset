package com.unity3d.services.core.domain.task;

import com.unity3d.services.core.configuration.Configuration;
import com.unity3d.services.core.configuration.ErrorState;
import com.unity3d.services.core.configuration.IConfigurationLoader;
import com.unity3d.services.core.configuration.IConfigurationLoaderListener;
import com.unity3d.services.core.domain.task.InitializeStateConfigWithLoader;
import com.unity3d.services.core.request.metrics.Metric;
import com.unity3d.services.core.request.metrics.SDKMetricsSender;
import com.unity3d.services.core.request.metrics.TSIMetric;
import e6.p;
import kotlin.jvm.internal.a0;
import kotlin.jvm.internal.k;
import q5.x;
import r2.q;
import v5.c;
import w5.a;
import x5.e;
import x5.i;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
@e(c = "com.unity3d.services.core.domain.task.InitializeStateConfigWithLoader$doWork$2$1$1", f = "InitializeStateConfigWithLoader.kt", l = {}, m = "invokeSuspend")
public final class InitializeStateConfigWithLoader$doWork$2$1$1 extends i implements p {
    final /* synthetic */ a0 $config;
    final /* synthetic */ a0 $configurationLoader;
    final /* synthetic */ InitializeStateConfigWithLoader.Params $params;
    int label;
    final /* synthetic */ InitializeStateConfigWithLoader this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InitializeStateConfigWithLoader$doWork$2$1$1(a0 a0Var, a0 a0Var2, InitializeStateConfigWithLoader initializeStateConfigWithLoader, InitializeStateConfigWithLoader.Params params, c<? super InitializeStateConfigWithLoader$doWork$2$1$1> cVar) {
        super(2, cVar);
        this.$configurationLoader = a0Var;
        this.$config = a0Var2;
        this.this$0 = initializeStateConfigWithLoader;
        this.$params = params;
    }

    @Override // x5.a
    public final c<x> create(Object obj, c<?> cVar) {
        return new InitializeStateConfigWithLoader$doWork$2$1$1(this.$configurationLoader, this.$config, this.this$0, this.$params, cVar);
    }

    @Override // x5.a
    public final Object invokeSuspend(Object obj) throws Exception {
        a aVar = a.f17774a;
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        q.z0(obj);
        IConfigurationLoader iConfigurationLoader = (IConfigurationLoader) this.$configurationLoader.f12717a;
        final a0 a0Var = this.$config;
        final InitializeStateConfigWithLoader initializeStateConfigWithLoader = this.this$0;
        final InitializeStateConfigWithLoader.Params params = this.$params;
        iConfigurationLoader.loadConfiguration(new IConfigurationLoaderListener() { // from class: com.unity3d.services.core.domain.task.InitializeStateConfigWithLoader$doWork$2$1$1.1
            @Override // com.unity3d.services.core.configuration.IConfigurationLoaderListener
            public void onError(String errorMsg) throws InitializationException {
                k.e(errorMsg, "errorMsg");
                SDKMetricsSender sDKMetricsSender = initializeStateConfigWithLoader.sdkMetricsSender;
                Metric metricNewEmergencySwitchOff = TSIMetric.newEmergencySwitchOff();
                k.d(metricNewEmergencySwitchOff, "newEmergencySwitchOff()");
                sDKMetricsSender.sendMetric(metricNewEmergencySwitchOff);
                throw new InitializationException(ErrorState.NetworkConfigRequest, new Exception(errorMsg), params.getConfig());
            }

            @Override // com.unity3d.services.core.configuration.IConfigurationLoaderListener
            public void onSuccess(Configuration configuration) {
                k.e(configuration, "configuration");
                a0Var.f12717a = configuration;
                configuration.saveToDisk();
                initializeStateConfigWithLoader.tokenStorage.setInitToken(((Configuration) a0Var.f12717a).getUnifiedAuctionToken());
            }
        });
        return x.f13520a;
    }

    @Override // e6.p
    public final Object invoke(q6.a0 a0Var, c<? super x> cVar) {
        return ((InitializeStateConfigWithLoader$doWork$2$1$1) create(a0Var, cVar)).invokeSuspend(x.f13520a);
    }
}
