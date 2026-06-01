package com.unity3d.services.core.di;

import e6.a;
import kotlin.jvm.internal.k;
import q5.f;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class ServiceFactoryKt {
    public static final <T> f factoryOf(a initializer) {
        k.e(initializer, "initializer");
        return new Factory(initializer);
    }
}
