package com.google.firebase.inappmessaging.display.internal.injection.modules;

import android.util.DisplayMetrics;
import com.google.firebase.inappmessaging.display.dagger.internal.DaggerGenerated;
import com.google.firebase.inappmessaging.display.dagger.internal.Factory;
import com.google.firebase.inappmessaging.display.dagger.internal.Preconditions;
import com.google.firebase.inappmessaging.display.dagger.internal.QualifierMetadata;
import com.google.firebase.inappmessaging.display.dagger.internal.ScopeMetadata;
import com.google.firebase.inappmessaging.display.internal.InAppMessageLayoutConfig;
import p5.a;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
@QualifierMetadata
@DaggerGenerated
@ScopeMetadata
public final class InflaterConfigModule_ProvidesPortraitImageLayoutConfigFactory implements Factory<InAppMessageLayoutConfig> {
    private final a displayMetricsProvider;
    private final InflaterConfigModule module;

    public InflaterConfigModule_ProvidesPortraitImageLayoutConfigFactory(InflaterConfigModule inflaterConfigModule, a aVar) {
        this.module = inflaterConfigModule;
        this.displayMetricsProvider = aVar;
    }

    public static InflaterConfigModule_ProvidesPortraitImageLayoutConfigFactory create(InflaterConfigModule inflaterConfigModule, a aVar) {
        return new InflaterConfigModule_ProvidesPortraitImageLayoutConfigFactory(inflaterConfigModule, aVar);
    }

    public static InAppMessageLayoutConfig providesPortraitImageLayoutConfig(InflaterConfigModule inflaterConfigModule, DisplayMetrics displayMetrics) {
        return (InAppMessageLayoutConfig) Preconditions.checkNotNullFromProvides(inflaterConfigModule.providesPortraitImageLayoutConfig(displayMetrics));
    }

    @Override // com.google.firebase.inappmessaging.display.dagger.internal.Factory, com.google.firebase.inappmessaging.display.dagger.internal.Provider, p5.a
    public InAppMessageLayoutConfig get() {
        return providesPortraitImageLayoutConfig(this.module, (DisplayMetrics) this.displayMetricsProvider.get());
    }
}
