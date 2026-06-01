package com.unity3d.services.core.domain.task;

import com.unity3d.services.core.configuration.IModuleConfiguration;
import com.unity3d.services.core.domain.task.InitializeStateError;
import com.unity3d.services.core.log.DeviceLog;
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
@e(c = "com.unity3d.services.core.domain.task.InitializeStateError$doWork$2", f = "InitializeStateError.kt", l = {}, m = "invokeSuspend")
public final class InitializeStateError$doWork$2 extends i implements p {
    final /* synthetic */ InitializeStateError.Params $params;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InitializeStateError$doWork$2(InitializeStateError.Params params, c<? super InitializeStateError$doWork$2> cVar) {
        super(2, cVar);
        this.$params = params;
    }

    @Override // x5.a
    public final c<x> create(Object obj, c<?> cVar) {
        return new InitializeStateError$doWork$2(this.$params, cVar);
    }

    @Override // x5.a
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objM;
        Throwable thA;
        a aVar = a.f17774a;
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        q.z0(obj);
        InitializeStateError.Params params = this.$params;
        try {
            DeviceLog.error("Unity Ads init: halting init in " + params.getErrorState().getMetricName() + ": " + params.getException().getMessage());
            Class[] moduleConfigurationList = params.getConfig().getModuleConfigurationList();
            if (moduleConfigurationList == null) {
                moduleConfigurationList = new Class[0];
            }
            for (Class cls : moduleConfigurationList) {
                IModuleConfiguration moduleConfiguration = params.getConfig().getModuleConfiguration(cls);
                if (moduleConfiguration != null) {
                    moduleConfiguration.initErrorState(params.getConfig(), params.getErrorState(), params.getException().getMessage());
                }
            }
            objM = x.f13520a;
        } catch (CancellationException e) {
            throw e;
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
        return ((InitializeStateError$doWork$2) create(a0Var, cVar)).invokeSuspend(x.f13520a);
    }
}
