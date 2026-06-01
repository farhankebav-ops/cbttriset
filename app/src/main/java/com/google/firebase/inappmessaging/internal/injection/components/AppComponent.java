package com.google.firebase.inappmessaging.internal.injection.components;

import com.google.firebase.inappmessaging.FirebaseInAppMessaging;
import com.google.firebase.inappmessaging.dagger.BindsInstance;
import com.google.firebase.inappmessaging.dagger.Component;
import com.google.firebase.inappmessaging.internal.AbtIntegrationHelper;
import com.google.firebase.inappmessaging.internal.DisplayCallbacksFactory;
import com.google.firebase.inappmessaging.internal.injection.modules.ApiClientModule;
import com.google.firebase.inappmessaging.internal.injection.modules.GrpcClientModule;
import com.google.firebase.inappmessaging.internal.injection.modules.TransportClientModule;
import com.google.firebase.inappmessaging.internal.injection.scopes.FirebaseAppScope;
import m0.h;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
@FirebaseAppScope
@Component(dependencies = {UniversalComponent.class}, modules = {ApiClientModule.class, GrpcClientModule.class, TransportClientModule.class})
public interface AppComponent {

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @Component.Builder
    public interface Builder {
        @BindsInstance
        Builder abtIntegrationHelper(AbtIntegrationHelper abtIntegrationHelper);

        Builder apiClientModule(ApiClientModule apiClientModule);

        AppComponent build();

        Builder grpcClientModule(GrpcClientModule grpcClientModule);

        @BindsInstance
        Builder transportFactory(h hVar);

        Builder universalComponent(UniversalComponent universalComponent);
    }

    DisplayCallbacksFactory displayCallbacksFactory();

    FirebaseInAppMessaging providesFirebaseInAppMessaging();
}
