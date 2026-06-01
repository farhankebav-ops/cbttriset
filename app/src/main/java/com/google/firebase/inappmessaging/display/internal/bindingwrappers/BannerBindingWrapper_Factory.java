package com.google.firebase.inappmessaging.display.internal.bindingwrappers;

import android.view.LayoutInflater;
import com.google.firebase.inappmessaging.display.dagger.internal.DaggerGenerated;
import com.google.firebase.inappmessaging.display.dagger.internal.Factory;
import com.google.firebase.inappmessaging.display.dagger.internal.QualifierMetadata;
import com.google.firebase.inappmessaging.display.dagger.internal.ScopeMetadata;
import com.google.firebase.inappmessaging.display.internal.InAppMessageLayoutConfig;
import com.google.firebase.inappmessaging.model.InAppMessage;
import p5.a;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
@QualifierMetadata
@DaggerGenerated
@ScopeMetadata("com.google.firebase.inappmessaging.display.internal.injection.scopes.InAppMessageScope")
public final class BannerBindingWrapper_Factory implements Factory<BannerBindingWrapper> {
    private final a configProvider;
    private final a inflaterProvider;
    private final a messageProvider;

    public BannerBindingWrapper_Factory(a aVar, a aVar2, a aVar3) {
        this.configProvider = aVar;
        this.inflaterProvider = aVar2;
        this.messageProvider = aVar3;
    }

    public static BannerBindingWrapper_Factory create(a aVar, a aVar2, a aVar3) {
        return new BannerBindingWrapper_Factory(aVar, aVar2, aVar3);
    }

    public static BannerBindingWrapper newInstance(InAppMessageLayoutConfig inAppMessageLayoutConfig, LayoutInflater layoutInflater, InAppMessage inAppMessage) {
        return new BannerBindingWrapper(inAppMessageLayoutConfig, layoutInflater, inAppMessage);
    }

    @Override // com.google.firebase.inappmessaging.display.dagger.internal.Factory, com.google.firebase.inappmessaging.display.dagger.internal.Provider, p5.a
    public BannerBindingWrapper get() {
        return newInstance((InAppMessageLayoutConfig) this.configProvider.get(), (LayoutInflater) this.inflaterProvider.get(), (InAppMessage) this.messageProvider.get());
    }
}
