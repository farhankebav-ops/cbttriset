package com.unity3d.services.store.gpbl.bridges.billingclient.v8;

import com.unity3d.services.core.reflection.GenericBridge;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;
import q5.i;
import r5.x;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class ProductBuilderBridge extends GenericBridge {
    private static final String BUILD_METHOD = "build";
    public static final Companion Companion = new Companion(null);
    private static final String SET_PRODUCT_ID_METHOD = "setProductId";
    private static final String SET_PRODUCT_TYPE_METHOD = "setProductType";
    private Object builderInstance;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Companion {
        public /* synthetic */ Companion(f fVar) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ProductBuilderBridge(Object builderInstance) {
        super(x.f0(new i(SET_PRODUCT_ID_METHOD, new Class[]{String.class}), new i(SET_PRODUCT_TYPE_METHOD, new Class[]{String.class}), new i(BUILD_METHOD, new Class[0])));
        k.e(builderInstance, "builderInstance");
        this.builderInstance = builderInstance;
    }

    public final ProductBridge build() {
        return new ProductBridge(callNonVoidMethod(BUILD_METHOD, this.builderInstance, new Object[0]));
    }

    @Override // com.unity3d.services.core.reflection.GenericBridge
    public String getClassName() {
        return "com.android.billingclient.api.QueryProductDetailsParams$Product$Builder";
    }

    public final ProductBuilderBridge setProductId(String productId) {
        k.e(productId, "productId");
        Object objCallNonVoidMethod = callNonVoidMethod(SET_PRODUCT_ID_METHOD, this.builderInstance, productId);
        k.d(objCallNonVoidMethod, "callNonVoidMethod(SET_PR…ilderInstance, productId)");
        this.builderInstance = objCallNonVoidMethod;
        return this;
    }

    public final ProductBuilderBridge setProductType(String productType) {
        k.e(productType, "productType");
        Object objCallNonVoidMethod = callNonVoidMethod(SET_PRODUCT_TYPE_METHOD, this.builderInstance, productType);
        k.d(objCallNonVoidMethod, "callNonVoidMethod(SET_PR…derInstance, productType)");
        this.builderInstance = objCallNonVoidMethod;
        return this;
    }
}
