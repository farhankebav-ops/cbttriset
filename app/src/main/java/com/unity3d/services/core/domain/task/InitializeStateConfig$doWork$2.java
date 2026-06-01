package com.unity3d.services.core.domain.task;

import com.unity3d.services.core.configuration.Configuration;
import com.unity3d.services.core.configuration.ErrorState;
import com.unity3d.services.core.domain.task.InitializeStateConfig;
import com.unity3d.services.core.domain.task.InitializeStateConfigWithLoader;
import com.unity3d.services.core.log.DeviceLog;
import com.unity3d.services.core.properties.SdkProperties;
import com.unity3d.services.core.request.NetworkIOException;
import e6.p;
import java.util.concurrent.CancellationException;
import q5.j;
import q5.k;
import q5.x;
import q6.a0;
import r2.q;
import v5.c;
import w5.a;
import x5.e;
import x5.i;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
@e(c = "com.unity3d.services.core.domain.task.InitializeStateConfig$doWork$2", f = "InitializeStateConfig.kt", l = {32}, m = "invokeSuspend")
public final class InitializeStateConfig$doWork$2 extends i implements p {
    final /* synthetic */ InitializeStateConfig.Params $params;
    Object L$0;
    int label;
    final /* synthetic */ InitializeStateConfig this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InitializeStateConfig$doWork$2(InitializeStateConfig.Params params, InitializeStateConfig initializeStateConfig, c<? super InitializeStateConfig$doWork$2> cVar) {
        super(2, cVar);
        this.$params = params;
        this.this$0 = initializeStateConfig;
    }

    @Override // x5.a
    public final c<x> create(Object obj, c<?> cVar) {
        return new InitializeStateConfig$doWork$2(this.$params, this.this$0, cVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v8 */
    @Override // x5.a
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objM;
        Throwable thA;
        Object objMo3222invokegIAlus;
        Configuration configuration = "Unity Ads init: load configuration from ";
        a aVar = a.f17774a;
        int i2 = this.label;
        try {
            try {
                if (i2 == 0) {
                    q.z0(obj);
                    InitializeStateConfig.Params params = this.$params;
                    InitializeStateConfig initializeStateConfig = this.this$0;
                    DeviceLog.info("Unity Ads init: load configuration from " + SdkProperties.getConfigUrl());
                    Configuration configuration2 = new Configuration(SdkProperties.getConfigUrl(), params.getConfig().getExperimentsReader());
                    InitializeStateConfigWithLoader initializeStateConfigWithLoader = initializeStateConfig.initializeStateConfigWithLoader;
                    InitializeStateConfigWithLoader.Params params2 = new InitializeStateConfigWithLoader.Params(configuration2);
                    this.L$0 = configuration2;
                    this.label = 1;
                    objMo3222invokegIAlus = initializeStateConfigWithLoader.mo3222invokegIAlus((BaseParams) params2, (c) this);
                    configuration = configuration2;
                    if (objMo3222invokegIAlus == aVar) {
                        return aVar;
                    }
                } else {
                    if (i2 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    Configuration configuration3 = (Configuration) this.L$0;
                    q.z0(obj);
                    objMo3222invokegIAlus = ((k) obj).f13501a;
                    configuration = configuration3;
                }
                q.z0(objMo3222invokegIAlus);
                objM = (Configuration) objMo3222invokegIAlus;
            } catch (NetworkIOException e) {
                throw new InitializationException(ErrorState.NetworkConfigRequest, e, configuration);
            }
        } catch (CancellationException e4) {
            throw e4;
        } catch (Throwable th) {
            objM = q.M(th);
        }
        if ((objM instanceof j) && (thA = k.a(objM)) != null) {
            objM = q.M(thA);
        }
        return new k(objM);
    }

    @Override // e6.p
    public final Object invoke(a0 a0Var, c<? super k> cVar) {
        return ((InitializeStateConfig$doWork$2) create(a0Var, cVar)).invokeSuspend(x.f13520a);
    }
}
