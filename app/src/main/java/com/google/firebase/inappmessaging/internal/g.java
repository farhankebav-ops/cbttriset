package com.google.firebase.inappmessaging.internal;

import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class g implements x4.b, x4.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TaskCompletionSource f5633a;

    public /* synthetic */ g(TaskCompletionSource taskCompletionSource) {
        this.f5633a = taskCompletionSource;
    }

    @Override // x4.b
    public void accept(Object obj) {
        this.f5633a.setResult(obj);
    }

    @Override // x4.c
    public Object apply(Object obj) {
        return DisplayCallbacksImpl.lambda$maybeToTask$10(this.f5633a, (Throwable) obj);
    }
}
