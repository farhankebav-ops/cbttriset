package com.unity3d.services.core.domain.task;

import com.unity3d.services.core.connectivity.ConnectivityMonitor;
import com.unity3d.services.core.domain.task.InitializeStateNetworkError;
import com.unity3d.services.core.log.DeviceLog;
import e6.p;
import java.util.concurrent.CancellationException;
import q5.j;
import q5.k;
import q5.x;
import q6.a0;
import q6.c0;
import r2.q;
import v5.c;
import w5.a;
import x5.e;
import x5.i;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
@e(c = "com.unity3d.services.core.domain.task.InitializeStateNetworkError$doWork$2", f = "InitializeStateNetworkError.kt", l = {39}, m = "invokeSuspend")
public final class InitializeStateNetworkError$doWork$2 extends i implements p {
    final /* synthetic */ InitializeStateNetworkError.Params $params;
    Object L$0;
    int label;
    final /* synthetic */ InitializeStateNetworkError this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InitializeStateNetworkError$doWork$2(InitializeStateNetworkError initializeStateNetworkError, InitializeStateNetworkError.Params params, c<? super InitializeStateNetworkError$doWork$2> cVar) {
        super(2, cVar);
        this.this$0 = initializeStateNetworkError;
        this.$params = params;
    }

    @Override // x5.a
    public final c<x> create(Object obj, c<?> cVar) {
        return new InitializeStateNetworkError$doWork$2(this.this$0, this.$params, cVar);
    }

    @Override // x5.a
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objM;
        Throwable thA;
        InitializeStateNetworkError initializeStateNetworkError;
        a aVar = a.f17774a;
        int i2 = this.label;
        try {
            if (i2 == 0) {
                q.z0(obj);
                InitializeStateNetworkError initializeStateNetworkError2 = this.this$0;
                InitializeStateNetworkError.Params params = this.$params;
                DeviceLog.error("Unity Ads init: network error, waiting for connection events");
                initializeStateNetworkError2.maximumConnectedEvents = params.getConfig().getMaximumConnectedEvents();
                initializeStateNetworkError2.connectedEventThreshold = params.getConfig().getConnectedEventThreshold();
                long networkErrorTimeout = params.getConfig().getNetworkErrorTimeout();
                InitializeStateNetworkError$doWork$2$1$success$1 initializeStateNetworkError$doWork$2$1$success$1 = new InitializeStateNetworkError$doWork$2$1$success$1(initializeStateNetworkError2, null);
                this.L$0 = initializeStateNetworkError2;
                this.label = 1;
                Object objJ = c0.J(networkErrorTimeout, initializeStateNetworkError$doWork$2$1$success$1, this);
                if (objJ == aVar) {
                    return aVar;
                }
                initializeStateNetworkError = initializeStateNetworkError2;
                obj = objJ;
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                initializeStateNetworkError = (InitializeStateNetworkError) this.L$0;
                q.z0(obj);
            }
        } catch (CancellationException e) {
            throw e;
        } catch (Throwable th) {
            objM = q.M(th);
        }
        if (((x) obj) == null) {
            ConnectivityMonitor.removeListener(initializeStateNetworkError);
            throw new Exception("No connected events within the timeout!");
        }
        objM = x.f13520a;
        if ((objM instanceof j) && (thA = k.a(objM)) != null) {
            objM = q.M(thA);
        }
        return new k(objM);
    }

    @Override // e6.p
    public final Object invoke(a0 a0Var, c<? super k> cVar) {
        return ((InitializeStateNetworkError$doWork$2) create(a0Var, cVar)).invokeSuspend(x.f13520a);
    }
}
