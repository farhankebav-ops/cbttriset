package com.google.firebase.messaging;

import android.content.Intent;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class o implements Continuation, OnCompleteListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Object f5702a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f5703b;

    public /* synthetic */ o(Object obj, Object obj2) {
        this.f5702a = obj;
        this.f5703b = obj2;
    }

    @Override // com.google.android.gms.tasks.OnCompleteListener
    public void onComplete(Task task) {
        ((EnhancedIntentService) this.f5702a).lambda$onStartCommand$1((Intent) this.f5703b, task);
    }

    @Override // com.google.android.gms.tasks.Continuation
    public Object then(Task task) {
        return ((RequestDeduplicator) this.f5702a).lambda$getOrStartGetTokenRequest$0((String) this.f5703b, task);
    }
}
