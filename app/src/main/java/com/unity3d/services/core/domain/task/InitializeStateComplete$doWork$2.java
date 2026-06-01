package com.unity3d.services.core.domain.task;

import androidx.datastore.core.DataStore;
import com.unity3d.services.core.configuration.IModuleConfiguration;
import com.unity3d.services.core.domain.task.InitializeStateComplete;
import e6.p;
import java.util.concurrent.CancellationException;
import kotlin.jvm.internal.k;
import q5.j;
import q5.x;
import q6.a0;
import r2.q;
import v5.c;
import w5.a;
import x5.e;
import x5.i;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
@e(c = "com.unity3d.services.core.domain.task.InitializeStateComplete$doWork$2", f = "InitializeStateComplete.kt", l = {26}, m = "invokeSuspend")
public final class InitializeStateComplete$doWork$2 extends i implements p {
    final /* synthetic */ InitializeStateComplete.Params $params;
    int label;
    final /* synthetic */ InitializeStateComplete this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InitializeStateComplete$doWork$2(InitializeStateComplete.Params params, InitializeStateComplete initializeStateComplete, c<? super InitializeStateComplete$doWork$2> cVar) {
        super(2, cVar);
        this.$params = params;
        this.this$0 = initializeStateComplete;
    }

    @Override // x5.a
    public final c<x> create(Object obj, c<?> cVar) {
        return new InitializeStateComplete$doWork$2(this.$params, this.this$0, cVar);
    }

    @Override // x5.a
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objM;
        Throwable thA;
        a aVar = a.f17774a;
        int i2 = this.label;
        try {
            if (i2 == 0) {
                q.z0(obj);
                InitializeStateComplete.Params params = this.$params;
                InitializeStateComplete initializeStateComplete = this.this$0;
                Class[] moduleConfigurationList = params.getConfig().getModuleConfigurationList();
                k.d(moduleConfigurationList, "params.config.moduleConfigurationList");
                for (Class cls : moduleConfigurationList) {
                    IModuleConfiguration moduleConfiguration = params.getConfig().getModuleConfiguration(cls);
                    if (moduleConfiguration != null) {
                        moduleConfiguration.initCompleteState(params.getConfig());
                    }
                }
                DataStore dataStore = initializeStateComplete.dataStore;
                InitializeStateComplete$doWork$2$1$1 initializeStateComplete$doWork$2$1$1 = new InitializeStateComplete$doWork$2$1$1(null);
                this.label = 1;
                if (dataStore.updateData(initializeStateComplete$doWork$2$1$1, this) == aVar) {
                    return aVar;
                }
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                q.z0(obj);
            }
            objM = x.f13520a;
        } catch (CancellationException e) {
            throw e;
        } catch (Throwable th) {
            objM = q.M(th);
        }
        if ((objM instanceof j) && (thA = q5.k.a(objM)) != null) {
            objM = q.M(thA);
        }
        return new q5.k(objM);
    }

    @Override // e6.p
    public final Object invoke(a0 a0Var, c<? super q5.k> cVar) {
        return ((InitializeStateComplete$doWork$2) create(a0Var, cVar)).invokeSuspend(x.f13520a);
    }
}
