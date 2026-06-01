package com.google.firebase.components;

import com.google.firebase.inject.Deferred;
import com.google.firebase.inject.Provider;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public abstract /* synthetic */ class b {
    public static Object a(ComponentContainer componentContainer, Qualified qualified) {
        Provider provider = componentContainer.getProvider(qualified);
        if (provider == null) {
            return null;
        }
        return provider.get();
    }

    public static Object b(ComponentContainer componentContainer, Class cls) {
        return componentContainer.get(Qualified.unqualified(cls));
    }

    public static Deferred c(ComponentContainer componentContainer, Class cls) {
        return componentContainer.getDeferred(Qualified.unqualified(cls));
    }

    public static Provider d(ComponentContainer componentContainer, Class cls) {
        return componentContainer.getProvider(Qualified.unqualified(cls));
    }

    public static Set e(ComponentContainer componentContainer, Qualified qualified) {
        return (Set) componentContainer.setOfProvider(qualified).get();
    }

    public static Set f(ComponentContainer componentContainer, Class cls) {
        return componentContainer.setOf(Qualified.unqualified(cls));
    }

    public static Provider g(ComponentContainer componentContainer, Class cls) {
        return componentContainer.setOfProvider(Qualified.unqualified(cls));
    }
}
