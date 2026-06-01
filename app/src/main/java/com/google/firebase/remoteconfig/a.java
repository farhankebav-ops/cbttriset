package com.google.firebase.remoteconfig;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class a implements Continuation, SuccessContinuation {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5713a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f5714b;

    public /* synthetic */ a(Object obj, int i2) {
        this.f5713a = i2;
        this.f5714b = obj;
    }

    @Override // com.google.android.gms.tasks.SuccessContinuation
    public Task then(Object obj) {
        return ((FirebaseRemoteConfig) this.f5714b).lambda$fetchAndActivate$1((Void) obj);
    }

    @Override // com.google.android.gms.tasks.Continuation
    public Object then(Task task) {
        switch (this.f5713a) {
            case 0:
                return Boolean.valueOf(((FirebaseRemoteConfig) this.f5714b).processActivatePutTask(task));
            default:
                return FirebaseRemoteConfig.lambda$ensureInitialized$0((Task) this.f5714b, task);
        }
    }
}
