package com.onesignal.core.internal.operations.impl;

import com.onesignal.common.threading.WaiterWithValue;
import e6.p;
import kotlin.jvm.internal.a0;
import q5.x;
import r2.q;
import v5.c;
import w5.a;
import x5.e;
import x5.i;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
@e(c = "com.onesignal.core.internal.operations.impl.OperationRepo$waitForNewOperationAndExecutionInterval$waitedTheFullTime$1", f = "OperationRepo.kt", l = {227}, m = "invokeSuspend")
public final class OperationRepo$waitForNewOperationAndExecutionInterval$waitedTheFullTime$1 extends i implements p {
    final /* synthetic */ a0 $wakeMessage;
    Object L$0;
    int label;
    final /* synthetic */ OperationRepo this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OperationRepo$waitForNewOperationAndExecutionInterval$waitedTheFullTime$1(a0 a0Var, OperationRepo operationRepo, c<? super OperationRepo$waitForNewOperationAndExecutionInterval$waitedTheFullTime$1> cVar) {
        super(2, cVar);
        this.$wakeMessage = a0Var;
        this.this$0 = operationRepo;
    }

    @Override // x5.a
    public final c<x> create(Object obj, c<?> cVar) {
        return new OperationRepo$waitForNewOperationAndExecutionInterval$waitedTheFullTime$1(this.$wakeMessage, this.this$0, cVar);
    }

    @Override // x5.a
    public final Object invokeSuspend(Object obj) throws Throwable {
        a0 a0Var;
        a aVar = a.f17774a;
        int i2 = this.label;
        if (i2 == 0) {
            q.z0(obj);
            a0 a0Var2 = this.$wakeMessage;
            WaiterWithValue waiterWithValue = this.this$0.waiter;
            this.L$0 = a0Var2;
            this.label = 1;
            Object objWaitForWake = waiterWithValue.waitForWake(this);
            if (objWaitForWake == aVar) {
                return aVar;
            }
            a0Var = a0Var2;
            obj = objWaitForWake;
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            a0Var = (a0) this.L$0;
            q.z0(obj);
        }
        a0Var.f12717a = obj;
        return x.f13520a;
    }

    @Override // e6.p
    public final Object invoke(q6.a0 a0Var, c<? super x> cVar) {
        return ((OperationRepo$waitForNewOperationAndExecutionInterval$waitedTheFullTime$1) create(a0Var, cVar)).invokeSuspend(x.f13520a);
    }
}
