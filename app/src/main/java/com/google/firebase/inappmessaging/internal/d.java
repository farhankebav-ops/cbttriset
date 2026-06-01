package com.google.firebase.inappmessaging.internal;

import com.google.firebase.inappmessaging.FirebaseInAppMessagingDisplayCallbacks;
import com.google.firebase.inappmessaging.internal.DeveloperListenerManager;
import com.google.firebase.inappmessaging.model.Action;
import com.google.firebase.inappmessaging.model.InAppMessage;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5624a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ InAppMessage f5625b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ DeveloperListenerManager.ExecutorAndListener f5626c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f5627d;

    public /* synthetic */ d(DeveloperListenerManager.ExecutorAndListener executorAndListener, InAppMessage inAppMessage, Object obj, int i2) {
        this.f5624a = i2;
        this.f5626c = executorAndListener;
        this.f5625b = inAppMessage;
        this.f5627d = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f5624a) {
            case 0:
                DeveloperListenerManager.lambda$displayErrorEncountered$1((DeveloperListenerManager.ErrorsExecutorAndListener) this.f5626c, this.f5625b, (FirebaseInAppMessagingDisplayCallbacks.InAppMessagingErrorReason) this.f5627d);
                break;
            default:
                DeveloperListenerManager.lambda$messageClicked$2((DeveloperListenerManager.ClicksExecutorAndListener) this.f5626c, this.f5625b, (Action) this.f5627d);
                break;
        }
    }
}
