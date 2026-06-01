package com.google.firebase.inappmessaging.display.internal.injection.modules;

import com.google.firebase.inappmessaging.display.dagger.internal.DaggerGenerated;
import com.google.firebase.inappmessaging.display.dagger.internal.Factory;
import com.google.firebase.inappmessaging.display.dagger.internal.Preconditions;
import com.google.firebase.inappmessaging.display.dagger.internal.QualifierMetadata;
import com.google.firebase.inappmessaging.display.dagger.internal.ScopeMetadata;
import com.google.firebase.inappmessaging.display.internal.InAppMessageLayoutConfig;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
@QualifierMetadata
@DaggerGenerated
@ScopeMetadata("com.google.firebase.inappmessaging.display.internal.injection.scopes.InAppMessageScope")
public final class InflaterModule_InAppMessageLayoutConfigFactory implements Factory<InAppMessageLayoutConfig> {
    private final InflaterModule module;

    public InflaterModule_InAppMessageLayoutConfigFactory(InflaterModule inflaterModule) {
        this.module = inflaterModule;
    }

    public static InflaterModule_InAppMessageLayoutConfigFactory create(InflaterModule inflaterModule) {
        return new InflaterModule_InAppMessageLayoutConfigFactory(inflaterModule);
    }

    public static InAppMessageLayoutConfig inAppMessageLayoutConfig(InflaterModule inflaterModule) {
        return (InAppMessageLayoutConfig) Preconditions.checkNotNullFromProvides(inflaterModule.inAppMessageLayoutConfig());
    }

    @Override // com.google.firebase.inappmessaging.display.dagger.internal.Factory, com.google.firebase.inappmessaging.display.dagger.internal.Provider, p5.a
    public InAppMessageLayoutConfig get() {
        return inAppMessageLayoutConfig(this.module);
    }
}
