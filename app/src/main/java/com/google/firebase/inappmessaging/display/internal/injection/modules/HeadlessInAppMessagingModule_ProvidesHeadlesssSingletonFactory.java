package com.google.firebase.inappmessaging.display.internal.injection.modules;

import com.google.firebase.inappmessaging.FirebaseInAppMessaging;
import com.google.firebase.inappmessaging.display.dagger.internal.DaggerGenerated;
import com.google.firebase.inappmessaging.display.dagger.internal.Factory;
import com.google.firebase.inappmessaging.display.dagger.internal.Preconditions;
import com.google.firebase.inappmessaging.display.dagger.internal.QualifierMetadata;
import com.google.firebase.inappmessaging.display.dagger.internal.ScopeMetadata;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
@QualifierMetadata
@DaggerGenerated
@ScopeMetadata("com.google.firebase.inappmessaging.display.internal.injection.scopes.FirebaseAppScope")
public final class HeadlessInAppMessagingModule_ProvidesHeadlesssSingletonFactory implements Factory<FirebaseInAppMessaging> {
    private final HeadlessInAppMessagingModule module;

    public HeadlessInAppMessagingModule_ProvidesHeadlesssSingletonFactory(HeadlessInAppMessagingModule headlessInAppMessagingModule) {
        this.module = headlessInAppMessagingModule;
    }

    public static HeadlessInAppMessagingModule_ProvidesHeadlesssSingletonFactory create(HeadlessInAppMessagingModule headlessInAppMessagingModule) {
        return new HeadlessInAppMessagingModule_ProvidesHeadlesssSingletonFactory(headlessInAppMessagingModule);
    }

    public static FirebaseInAppMessaging providesHeadlesssSingleton(HeadlessInAppMessagingModule headlessInAppMessagingModule) {
        return (FirebaseInAppMessaging) Preconditions.checkNotNullFromProvides(headlessInAppMessagingModule.providesHeadlesssSingleton());
    }

    @Override // com.google.firebase.inappmessaging.display.dagger.internal.Factory, com.google.firebase.inappmessaging.display.dagger.internal.Provider, p5.a
    public FirebaseInAppMessaging get() {
        return providesHeadlesssSingleton(this.module);
    }
}
