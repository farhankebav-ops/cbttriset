package com.google.firebase.inappmessaging.display.internal;

import android.app.Application;
import com.google.firebase.inappmessaging.display.internal.bindingwrappers.BindingWrapper;
import com.google.firebase.inappmessaging.display.internal.injection.components.DaggerInAppMessageComponent;
import com.google.firebase.inappmessaging.display.internal.injection.modules.InflaterModule;
import com.google.firebase.inappmessaging.model.InAppMessage;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public class BindingWrapperFactory {
    private final Application application;

    public BindingWrapperFactory(Application application) {
        this.application = application;
    }

    public BindingWrapper createBannerBindingWrapper(InAppMessageLayoutConfig inAppMessageLayoutConfig, InAppMessage inAppMessage) {
        return DaggerInAppMessageComponent.builder().inflaterModule(new InflaterModule(inAppMessage, inAppMessageLayoutConfig, this.application)).build().bannerBindingWrapper();
    }

    public BindingWrapper createCardBindingWrapper(InAppMessageLayoutConfig inAppMessageLayoutConfig, InAppMessage inAppMessage) {
        return DaggerInAppMessageComponent.builder().inflaterModule(new InflaterModule(inAppMessage, inAppMessageLayoutConfig, this.application)).build().cardBindingWrapper();
    }

    public BindingWrapper createImageBindingWrapper(InAppMessageLayoutConfig inAppMessageLayoutConfig, InAppMessage inAppMessage) {
        return DaggerInAppMessageComponent.builder().inflaterModule(new InflaterModule(inAppMessage, inAppMessageLayoutConfig, this.application)).build().imageBindingWrapper();
    }

    public BindingWrapper createModalBindingWrapper(InAppMessageLayoutConfig inAppMessageLayoutConfig, InAppMessage inAppMessage) {
        return DaggerInAppMessageComponent.builder().inflaterModule(new InflaterModule(inAppMessage, inAppMessageLayoutConfig, this.application)).build().modalBindingWrapper();
    }
}
