package com.google.firebase.datatransport;

import android.content.Context;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.Dependency;
import com.google.firebase.components.Qualified;
import com.google.firebase.platforminfo.LibraryVersionComponent;
import java.util.Arrays;
import java.util.List;
import m0.h;
import n0.a;
import p0.v;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
@Keep
public class TransportRegistrar implements ComponentRegistrar {
    private static final String LIBRARY_NAME = "fire-transport";

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ h lambda$getComponents$0(ComponentContainer componentContainer) {
        v.b((Context) componentContainer.get(Context.class));
        return v.a().c(a.f13043f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ h lambda$getComponents$1(ComponentContainer componentContainer) {
        v.b((Context) componentContainer.get(Context.class));
        return v.a().c(a.f13043f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ h lambda$getComponents$2(ComponentContainer componentContainer) {
        v.b((Context) componentContainer.get(Context.class));
        return v.a().c(a.e);
    }

    @Override // com.google.firebase.components.ComponentRegistrar
    @NonNull
    public List<Component<?>> getComponents() {
        return Arrays.asList(Component.builder(h.class).name(LIBRARY_NAME).add(Dependency.required((Class<?>) Context.class)).factory(new com.google.firebase.concurrent.h(9)).build(), Component.builder(Qualified.qualified(LegacyTransportBackend.class, h.class)).add(Dependency.required((Class<?>) Context.class)).factory(new com.google.firebase.concurrent.h(10)).build(), Component.builder(Qualified.qualified(TransportBackend.class, h.class)).add(Dependency.required((Class<?>) Context.class)).factory(new com.google.firebase.concurrent.h(11)).build(), LibraryVersionComponent.create(LIBRARY_NAME, "19.0.0"));
    }
}
