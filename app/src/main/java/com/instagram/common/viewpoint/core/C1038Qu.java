package com.instagram.common.viewpoint.core;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Qu, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1038Qu implements InvocationHandler {
    public final /* synthetic */ ClassLoader A00;

    public C1038Qu(ClassLoader classLoader) {
        this.A00 = classLoader;
    }

    @Override // java.lang.reflect.InvocationHandler
    public final Object invoke(Object obj, Method method, Object[] objArr) {
        return C1039Qv.A00(this.A00, method);
    }
}
