package com.google.firebase.messaging;

import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.RequestDeduplicator;
import com.google.firebase.messaging.Store;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class i implements SuccessContinuation, RequestDeduplicator.GetTokenRequest {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FirebaseMessaging f5690a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f5691b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Store.Token f5692c;

    public /* synthetic */ i(FirebaseMessaging firebaseMessaging, String str, Store.Token token) {
        this.f5690a = firebaseMessaging;
        this.f5691b = str;
        this.f5692c = token;
    }

    @Override // com.google.firebase.messaging.RequestDeduplicator.GetTokenRequest
    public Task start() {
        return this.f5690a.lambda$blockingGetToken$14(this.f5691b, this.f5692c);
    }

    @Override // com.google.android.gms.tasks.SuccessContinuation
    public Task then(Object obj) {
        return this.f5690a.lambda$blockingGetToken$13(this.f5691b, this.f5692c, (String) obj);
    }
}
