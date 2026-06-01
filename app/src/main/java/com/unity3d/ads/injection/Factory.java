package com.unity3d.ads.injection;

import e6.a;
import kotlin.jvm.internal.k;
import q5.f;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class Factory<T> implements f {
    private final a initializer;

    public Factory(a initializer) {
        k.e(initializer, "initializer");
        this.initializer = initializer;
    }

    @Override // q5.f
    public T getValue() {
        return (T) this.initializer.invoke();
    }

    @Override // q5.f
    public boolean isInitialized() {
        return false;
    }
}
