package com.google.firebase.inappmessaging.internal;

import com.google.firebase.inappmessaging.ExperimentPayloadProto;
import com.google.firebase.inappmessaging.internal.DeveloperListenerManager;
import com.google.firebase.inappmessaging.model.InAppMessage;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5628a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f5629b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f5630c;

    public /* synthetic */ e(int i2, Object obj, Object obj2) {
        this.f5628a = i2;
        this.f5630c = obj;
        this.f5629b = obj2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f5628a) {
            case 0:
                DeveloperListenerManager.lambda$messageDismissed$3((DeveloperListenerManager.DismissExecutorAndListener) this.f5630c, (InAppMessage) this.f5629b);
                break;
            case 1:
                DeveloperListenerManager.lambda$impressionDetected$0((DeveloperListenerManager.ImpressionExecutorAndListener) this.f5630c, (InAppMessage) this.f5629b);
                break;
            case 2:
                ((AbtIntegrationHelper) this.f5630c).lambda$updateRunningExperiments$0((ArrayList) this.f5629b);
                break;
            default:
                ((AbtIntegrationHelper) this.f5630c).lambda$setExperimentActive$1((ExperimentPayloadProto.ExperimentPayload) this.f5629b);
                break;
        }
    }
}
