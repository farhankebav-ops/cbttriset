package com.google.firebase.inappmessaging.display.internal.injection.components;

import com.google.firebase.inappmessaging.display.dagger.Component;
import com.google.firebase.inappmessaging.display.internal.bindingwrappers.BannerBindingWrapper;
import com.google.firebase.inappmessaging.display.internal.bindingwrappers.CardBindingWrapper;
import com.google.firebase.inappmessaging.display.internal.bindingwrappers.ImageBindingWrapper;
import com.google.firebase.inappmessaging.display.internal.bindingwrappers.ModalBindingWrapper;
import com.google.firebase.inappmessaging.display.internal.injection.modules.InflaterModule;
import com.google.firebase.inappmessaging.display.internal.injection.scopes.InAppMessageScope;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
@InAppMessageScope
@Component(modules = {InflaterModule.class})
public interface InAppMessageComponent {
    @InAppMessageScope
    BannerBindingWrapper bannerBindingWrapper();

    @InAppMessageScope
    CardBindingWrapper cardBindingWrapper();

    @InAppMessageScope
    ImageBindingWrapper imageBindingWrapper();

    @InAppMessageScope
    ModalBindingWrapper modalBindingWrapper();
}
