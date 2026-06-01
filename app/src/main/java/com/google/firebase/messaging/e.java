package com.google.firebase.messaging;

import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class e implements SuccessContinuation {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5681a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f5682b;

    public /* synthetic */ e(String str, int i2) {
        this.f5681a = i2;
        this.f5682b = str;
    }

    @Override // com.google.android.gms.tasks.SuccessContinuation
    public final Task then(Object obj) {
        switch (this.f5681a) {
            case 0:
                return FirebaseMessaging.lambda$subscribeToTopic$10(this.f5682b, (TopicsSubscriber) obj);
            default:
                return FirebaseMessaging.lambda$unsubscribeFromTopic$11(this.f5682b, (TopicsSubscriber) obj);
        }
    }
}
