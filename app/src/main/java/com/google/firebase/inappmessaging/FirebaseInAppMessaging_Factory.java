package com.google.firebase.inappmessaging;

import com.google.firebase.inappmessaging.dagger.internal.DaggerGenerated;
import com.google.firebase.inappmessaging.dagger.internal.Factory;
import com.google.firebase.inappmessaging.dagger.internal.QualifierMetadata;
import com.google.firebase.inappmessaging.dagger.internal.ScopeMetadata;
import com.google.firebase.inappmessaging.internal.DataCollectionHelper;
import com.google.firebase.inappmessaging.internal.DeveloperListenerManager;
import com.google.firebase.inappmessaging.internal.DisplayCallbacksFactory;
import com.google.firebase.inappmessaging.internal.InAppMessageStreamManager;
import com.google.firebase.inappmessaging.internal.ProgramaticContextualTriggers;
import com.google.firebase.installations.FirebaseInstallationsApi;
import java.util.concurrent.Executor;
import p5.a;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
@QualifierMetadata({"com.google.firebase.inappmessaging.internal.injection.qualifiers.ProgrammaticTrigger", "com.google.firebase.annotations.concurrent.Lightweight"})
@ScopeMetadata("com.google.firebase.inappmessaging.internal.injection.scopes.FirebaseAppScope")
@DaggerGenerated
public final class FirebaseInAppMessaging_Factory implements Factory<FirebaseInAppMessaging> {
    private final a dataCollectionHelperProvider;
    private final a developerListenerManagerProvider;
    private final a displayCallbacksFactoryProvider;
    private final a firebaseInstallationsProvider;
    private final a inAppMessageStreamManagerProvider;
    private final a lightWeightExecutorProvider;
    private final a programaticContextualTriggersProvider;

    public FirebaseInAppMessaging_Factory(a aVar, a aVar2, a aVar3, a aVar4, a aVar5, a aVar6, a aVar7) {
        this.inAppMessageStreamManagerProvider = aVar;
        this.programaticContextualTriggersProvider = aVar2;
        this.dataCollectionHelperProvider = aVar3;
        this.firebaseInstallationsProvider = aVar4;
        this.displayCallbacksFactoryProvider = aVar5;
        this.developerListenerManagerProvider = aVar6;
        this.lightWeightExecutorProvider = aVar7;
    }

    public static FirebaseInAppMessaging_Factory create(a aVar, a aVar2, a aVar3, a aVar4, a aVar5, a aVar6, a aVar7) {
        return new FirebaseInAppMessaging_Factory(aVar, aVar2, aVar3, aVar4, aVar5, aVar6, aVar7);
    }

    public static FirebaseInAppMessaging newInstance(InAppMessageStreamManager inAppMessageStreamManager, ProgramaticContextualTriggers programaticContextualTriggers, DataCollectionHelper dataCollectionHelper, FirebaseInstallationsApi firebaseInstallationsApi, DisplayCallbacksFactory displayCallbacksFactory, DeveloperListenerManager developerListenerManager, Executor executor) {
        return new FirebaseInAppMessaging(inAppMessageStreamManager, programaticContextualTriggers, dataCollectionHelper, firebaseInstallationsApi, displayCallbacksFactory, developerListenerManager, executor);
    }

    @Override // com.google.firebase.inappmessaging.dagger.internal.Factory, com.google.firebase.inappmessaging.dagger.internal.Provider, p5.a
    public FirebaseInAppMessaging get() {
        return newInstance((InAppMessageStreamManager) this.inAppMessageStreamManagerProvider.get(), (ProgramaticContextualTriggers) this.programaticContextualTriggersProvider.get(), (DataCollectionHelper) this.dataCollectionHelperProvider.get(), (FirebaseInstallationsApi) this.firebaseInstallationsProvider.get(), (DisplayCallbacksFactory) this.displayCallbacksFactoryProvider.get(), (DeveloperListenerManager) this.developerListenerManagerProvider.get(), (Executor) this.lightWeightExecutorProvider.get());
    }
}
