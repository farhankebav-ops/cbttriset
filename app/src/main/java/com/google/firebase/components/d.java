package com.google.firebase.components;

import com.google.firebase.components.ComponentRuntime;
import com.google.firebase.inject.Provider;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class d implements Provider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5521a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ComponentRegistrar f5522b;

    public /* synthetic */ d(ComponentRegistrar componentRegistrar, int i2) {
        this.f5521a = i2;
        this.f5522b = componentRegistrar;
    }

    @Override // com.google.firebase.inject.Provider
    public final Object get() {
        switch (this.f5521a) {
            case 0:
                return ComponentRuntime.lambda$toProviders$1(this.f5522b);
            default:
                return ComponentRuntime.Builder.lambda$addComponentRegistrar$0(this.f5522b);
        }
    }
}
