package com.google.firebase.crashlytics.internal.common;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class i implements Continuation, OnFailureListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CountDownLatch f5584a;

    public /* synthetic */ i(CountDownLatch countDownLatch) {
        this.f5584a = countDownLatch;
    }

    @Override // com.google.android.gms.tasks.OnFailureListener
    public void onFailure(Exception exc) {
        this.f5584a.countDown();
    }

    @Override // com.google.android.gms.tasks.Continuation
    public Object then(Task task) {
        return Utils.lambda$awaitEvenIfOnMainThread$0(this.f5584a, task);
    }
}
