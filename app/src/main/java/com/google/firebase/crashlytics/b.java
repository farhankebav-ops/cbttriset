package com.google.firebase.crashlytics;

import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.inappmessaging.FirebaseInAppMessagingRegistrar;
import com.google.firebase.inappmessaging.display.FirebaseInAppMessagingDisplayRegistrar;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class b implements ComponentFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5561a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ComponentRegistrar f5562b;

    public /* synthetic */ b(ComponentRegistrar componentRegistrar, int i2) {
        this.f5561a = i2;
        this.f5562b = componentRegistrar;
    }

    @Override // com.google.firebase.components.ComponentFactory
    public final Object create(ComponentContainer componentContainer) {
        switch (this.f5561a) {
            case 0:
                return ((CrashlyticsRegistrar) this.f5562b).buildCrashlytics(componentContainer);
            case 1:
                return ((FirebaseInAppMessagingRegistrar) this.f5562b).providesFirebaseInAppMessaging(componentContainer);
            default:
                return ((FirebaseInAppMessagingDisplayRegistrar) this.f5562b).buildFirebaseInAppMessagingUI(componentContainer);
        }
    }
}
