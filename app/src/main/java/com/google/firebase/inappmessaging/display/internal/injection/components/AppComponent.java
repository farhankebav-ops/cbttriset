package com.google.firebase.inappmessaging.display.internal.injection.components;

import com.google.firebase.inappmessaging.display.FirebaseInAppMessagingDisplay;
import com.google.firebase.inappmessaging.display.dagger.Component;
import com.google.firebase.inappmessaging.display.internal.FiamImageLoader;
import com.google.firebase.inappmessaging.display.internal.injection.modules.GlideModule;
import com.google.firebase.inappmessaging.display.internal.injection.modules.HeadlessInAppMessagingModule;
import com.google.firebase.inappmessaging.display.internal.injection.scopes.FirebaseAppScope;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
@Component(dependencies = {UniversalComponent.class}, modules = {HeadlessInAppMessagingModule.class, GlideModule.class})
@FirebaseAppScope
public interface AppComponent {
    FiamImageLoader fiamImageLoader();

    @FirebaseAppScope
    FirebaseInAppMessagingDisplay providesFirebaseInAppMessagingUI();
}
