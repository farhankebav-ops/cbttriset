package com.google.firebase.inappmessaging.display;

import android.app.Application;
import com.google.firebase.inappmessaging.FirebaseInAppMessaging;
import com.google.firebase.inappmessaging.display.dagger.internal.DaggerGenerated;
import com.google.firebase.inappmessaging.display.dagger.internal.Factory;
import com.google.firebase.inappmessaging.display.dagger.internal.QualifierMetadata;
import com.google.firebase.inappmessaging.display.dagger.internal.ScopeMetadata;
import com.google.firebase.inappmessaging.display.internal.BindingWrapperFactory;
import com.google.firebase.inappmessaging.display.internal.FiamAnimator;
import com.google.firebase.inappmessaging.display.internal.FiamImageLoader;
import com.google.firebase.inappmessaging.display.internal.FiamWindowManager;
import com.google.firebase.inappmessaging.display.internal.RenewableTimer;
import java.util.Map;
import p5.a;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
@QualifierMetadata
@DaggerGenerated
@ScopeMetadata("com.google.firebase.inappmessaging.display.internal.injection.scopes.FirebaseAppScope")
public final class FirebaseInAppMessagingDisplay_Factory implements Factory<FirebaseInAppMessagingDisplay> {
    private final a animatorProvider;
    private final a applicationProvider;
    private final a autoDismissTimerProvider;
    private final a bindingWrapperFactoryProvider;
    private final a headlessInAppMessagingProvider;
    private final a imageLoaderProvider;
    private final a impressionTimerProvider;
    private final a layoutConfigsProvider;
    private final a windowManagerProvider;

    public FirebaseInAppMessagingDisplay_Factory(a aVar, a aVar2, a aVar3, a aVar4, a aVar5, a aVar6, a aVar7, a aVar8, a aVar9) {
        this.headlessInAppMessagingProvider = aVar;
        this.layoutConfigsProvider = aVar2;
        this.imageLoaderProvider = aVar3;
        this.impressionTimerProvider = aVar4;
        this.autoDismissTimerProvider = aVar5;
        this.windowManagerProvider = aVar6;
        this.applicationProvider = aVar7;
        this.bindingWrapperFactoryProvider = aVar8;
        this.animatorProvider = aVar9;
    }

    public static FirebaseInAppMessagingDisplay_Factory create(a aVar, a aVar2, a aVar3, a aVar4, a aVar5, a aVar6, a aVar7, a aVar8, a aVar9) {
        return new FirebaseInAppMessagingDisplay_Factory(aVar, aVar2, aVar3, aVar4, aVar5, aVar6, aVar7, aVar8, aVar9);
    }

    public static FirebaseInAppMessagingDisplay newInstance(FirebaseInAppMessaging firebaseInAppMessaging, Map<String, a> map, FiamImageLoader fiamImageLoader, RenewableTimer renewableTimer, RenewableTimer renewableTimer2, FiamWindowManager fiamWindowManager, Application application, BindingWrapperFactory bindingWrapperFactory, FiamAnimator fiamAnimator) {
        return new FirebaseInAppMessagingDisplay(firebaseInAppMessaging, map, fiamImageLoader, renewableTimer, renewableTimer2, fiamWindowManager, application, bindingWrapperFactory, fiamAnimator);
    }

    @Override // com.google.firebase.inappmessaging.display.dagger.internal.Factory, com.google.firebase.inappmessaging.display.dagger.internal.Provider, p5.a
    public FirebaseInAppMessagingDisplay get() {
        return newInstance((FirebaseInAppMessaging) this.headlessInAppMessagingProvider.get(), (Map) this.layoutConfigsProvider.get(), (FiamImageLoader) this.imageLoaderProvider.get(), (RenewableTimer) this.impressionTimerProvider.get(), (RenewableTimer) this.autoDismissTimerProvider.get(), (FiamWindowManager) this.windowManagerProvider.get(), (Application) this.applicationProvider.get(), (BindingWrapperFactory) this.bindingWrapperFactoryProvider.get(), (FiamAnimator) this.animatorProvider.get());
    }
}
