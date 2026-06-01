package com.unity3d.ads.core.data.datasource;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import e6.l;
import e6.p;
import kotlin.jvm.internal.k;
import q5.x;
import q6.a0;
import r2.q;
import v5.c;
import v5.j;
import w5.a;
import x5.e;
import x5.i;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
@e(c = "com.unity3d.ads.core.data.datasource.AndroidFIdDataSource$invoke$1$1", f = "AndroidFIdDataSource.kt", l = {19}, m = "invokeSuspend")
public final class AndroidFIdDataSource$invoke$1$1 extends i implements p {
    final /* synthetic */ Task<String> $task;
    Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AndroidFIdDataSource$invoke$1$1(Task<String> task, c<? super AndroidFIdDataSource$invoke$1$1> cVar) {
        super(2, cVar);
        this.$task = task;
    }

    @Override // x5.a
    public final c<x> create(Object obj, c<?> cVar) {
        return new AndroidFIdDataSource$invoke$1$1(this.$task, cVar);
    }

    @Override // x5.a
    public final Object invokeSuspend(Object obj) throws Throwable {
        a aVar = a.f17774a;
        int i2 = this.label;
        if (i2 != 0) {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            q.z0(obj);
            return obj;
        }
        q.z0(obj);
        Task<String> task = this.$task;
        this.L$0 = task;
        this.label = 1;
        final j jVar = new j(a.a.I(this));
        final AndroidFIdDataSource$invoke$1$1$1$1 androidFIdDataSource$invoke$1$1$1$1 = new AndroidFIdDataSource$invoke$1$1$1$1(jVar);
        task.addOnSuccessListener(new OnSuccessListener(androidFIdDataSource$invoke$1$1$1$1) { // from class: com.unity3d.ads.core.data.datasource.AndroidFIdDataSource$sam$com_google_android_gms_tasks_OnSuccessListener$0
            private final /* synthetic */ l function;

            {
                k.e(androidFIdDataSource$invoke$1$1$1$1, "function");
                this.function = androidFIdDataSource$invoke$1$1$1$1;
            }

            @Override // com.google.android.gms.tasks.OnSuccessListener
            public final /* synthetic */ void onSuccess(Object obj2) {
                this.function.invoke(obj2);
            }
        });
        task.addOnFailureListener(new OnFailureListener() { // from class: com.unity3d.ads.core.data.datasource.AndroidFIdDataSource$invoke$1$1$1$2
            @Override // com.google.android.gms.tasks.OnFailureListener
            public final void onFailure(Exception it) {
                k.e(it, "it");
                jVar.resumeWith(q.M(it));
            }
        });
        Object objA = jVar.a();
        return objA == aVar ? aVar : objA;
    }

    @Override // e6.p
    public final Object invoke(a0 a0Var, c<? super String> cVar) {
        return ((AndroidFIdDataSource$invoke$1$1) create(a0Var, cVar)).invokeSuspend(x.f13520a);
    }
}
