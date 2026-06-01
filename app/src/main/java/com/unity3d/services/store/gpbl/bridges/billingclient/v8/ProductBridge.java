package com.unity3d.services.store.gpbl.bridges.billingclient.v8;

import a1.a;
import com.unity3d.services.core.reflection.GenericBridge;
import java.lang.reflect.InvocationTargetException;
import kotlin.jvm.internal.f;
import r5.s;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class ProductBridge extends GenericBridge {
    public static final Companion Companion = new Companion(null);
    public static final String NEW_BUILDER_METHOD = "newBuilder";
    private final Object productInternalInstance;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Companion {
        public /* synthetic */ Companion(f fVar) {
            this();
        }

        private final Object callNonVoidStaticMethod(String str) throws IllegalAccessException, InvocationTargetException {
            Object objInvoke = getClassForParams().getMethod(str, null).invoke(null, null);
            if (objInvoke != null) {
                return objInvoke;
            }
            throw new IllegalStateException(a.m("Static method ", str, " returned null"));
        }

        public final Class<?> getClassForParams() {
            return Class.forName("com.android.billingclient.api.QueryProductDetailsParams$Product");
        }

        public final ProductBuilderBridge newBuilder() {
            return new ProductBuilderBridge(callNonVoidStaticMethod("newBuilder"));
        }

        private Companion() {
        }
    }

    public ProductBridge(Object obj) {
        super(s.f13639a);
        this.productInternalInstance = obj;
    }

    @Override // com.unity3d.services.core.reflection.GenericBridge
    public String getClassName() {
        return "com.android.billingclient.api.QueryProductDetailsParams$Product";
    }

    public final Object getInternalClass() {
        return this.productInternalInstance;
    }
}
