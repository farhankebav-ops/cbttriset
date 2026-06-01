package com.google.firebase.inappmessaging.display.internal.injection.modules;

import android.app.Application;
import android.util.DisplayMetrics;
import com.google.firebase.inappmessaging.display.dagger.internal.DaggerGenerated;
import com.google.firebase.inappmessaging.display.dagger.internal.Factory;
import com.google.firebase.inappmessaging.display.dagger.internal.Preconditions;
import com.google.firebase.inappmessaging.display.dagger.internal.QualifierMetadata;
import com.google.firebase.inappmessaging.display.dagger.internal.ScopeMetadata;
import p5.a;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
@QualifierMetadata
@DaggerGenerated
@ScopeMetadata
public final class InflaterConfigModule_ProvidesDisplayMetricsFactory implements Factory<DisplayMetrics> {
    private final a applicationProvider;
    private final InflaterConfigModule module;

    public InflaterConfigModule_ProvidesDisplayMetricsFactory(InflaterConfigModule inflaterConfigModule, a aVar) {
        this.module = inflaterConfigModule;
        this.applicationProvider = aVar;
    }

    public static InflaterConfigModule_ProvidesDisplayMetricsFactory create(InflaterConfigModule inflaterConfigModule, a aVar) {
        return new InflaterConfigModule_ProvidesDisplayMetricsFactory(inflaterConfigModule, aVar);
    }

    public static DisplayMetrics providesDisplayMetrics(InflaterConfigModule inflaterConfigModule, Application application) {
        return (DisplayMetrics) Preconditions.checkNotNullFromProvides(inflaterConfigModule.providesDisplayMetrics(application));
    }

    @Override // com.google.firebase.inappmessaging.display.dagger.internal.Factory, com.google.firebase.inappmessaging.display.dagger.internal.Provider, p5.a
    public DisplayMetrics get() {
        return providesDisplayMetrics(this.module, (Application) this.applicationProvider.get());
    }
}
