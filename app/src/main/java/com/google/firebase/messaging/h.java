package com.google.firebase.messaging;

import com.google.android.gms.cloudmessaging.CloudMessage;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.iid.internal.FirebaseInstanceIdInternal;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class h implements OnSuccessListener, FirebaseInstanceIdInternal.NewTokenListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5688a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ FirebaseMessaging f5689b;

    public /* synthetic */ h(FirebaseMessaging firebaseMessaging, int i2) {
        this.f5688a = i2;
        this.f5689b = firebaseMessaging;
    }

    @Override // com.google.firebase.iid.internal.FirebaseInstanceIdInternal.NewTokenListener
    public void onNewToken(String str) {
        this.f5689b.lambda$new$1(str);
    }

    @Override // com.google.android.gms.tasks.OnSuccessListener
    public void onSuccess(Object obj) {
        switch (this.f5688a) {
            case 0:
                this.f5689b.lambda$new$3((TopicsSubscriber) obj);
                break;
            case 1:
            default:
                this.f5689b.lambda$handleProxiedNotificationData$5((CloudMessage) obj);
                break;
            case 2:
                this.f5689b.lambda$setNotificationDelegationEnabled$6((Void) obj);
                break;
        }
    }
}
