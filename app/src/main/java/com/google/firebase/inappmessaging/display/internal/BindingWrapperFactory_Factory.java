package com.google.firebase.inappmessaging.display.internal;

import android.app.Application;
import com.google.firebase.inappmessaging.display.dagger.internal.DaggerGenerated;
import com.google.firebase.inappmessaging.display.dagger.internal.Factory;
import com.google.firebase.inappmessaging.display.dagger.internal.QualifierMetadata;
import com.google.firebase.inappmessaging.display.dagger.internal.ScopeMetadata;
import p5.a;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
@QualifierMetadata
@DaggerGenerated
@ScopeMetadata("javax.inject.Singleton")
public final class BindingWrapperFactory_Factory implements Factory<BindingWrapperFactory> {
    private final a applicationProvider;

    public BindingWrapperFactory_Factory(a aVar) {
        this.applicationProvider = aVar;
    }

    public static BindingWrapperFactory_Factory create(a aVar) {
        return new BindingWrapperFactory_Factory(aVar);
    }

    public static BindingWrapperFactory newInstance(Application application) {
        return new BindingWrapperFactory(application);
    }

    @Override // com.google.firebase.inappmessaging.display.dagger.internal.Factory, com.google.firebase.inappmessaging.display.dagger.internal.Provider, p5.a
    public BindingWrapperFactory get() {
        return newInstance((Application) this.applicationProvider.get());
    }
}
