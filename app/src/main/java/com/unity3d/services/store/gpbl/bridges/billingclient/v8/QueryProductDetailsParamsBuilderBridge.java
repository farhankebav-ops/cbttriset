package com.unity3d.services.store.gpbl.bridges.billingclient.v8;

import com.unity3d.services.core.reflection.GenericBridge;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;
import q5.i;
import r5.n;
import r5.x;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class QueryProductDetailsParamsBuilderBridge extends GenericBridge {
    private static final String BUILD_METHOD = "build";
    public static final Companion Companion = new Companion(null);
    private static final String SET_PRODUCT_LIST_METHOD = "setProductList";
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
    public QueryProductDetailsParamsBuilderBridge(Object builderInstance) {
        super(x.f0(new i(SET_PRODUCT_LIST_METHOD, new Class[]{List.class}), new i(BUILD_METHOD, new Class[0])));
        k.e(builderInstance, "builderInstance");
        this.builderInstance = builderInstance;
    }

    public final QueryProductDetailsParamsBridge build() {
        return new QueryProductDetailsParamsBridge(callNonVoidMethod(BUILD_METHOD, this.builderInstance, new Object[0]));
    }

    public final Object getBuilderInstance() {
        return this.builderInstance;
    }

    @Override // com.unity3d.services.core.reflection.GenericBridge
    public String getClassName() {
        return "com.android.billingclient.api.QueryProductDetailsParams$Builder";
    }

    public final void setBuilderInstance(Object obj) {
        k.e(obj, "<set-?>");
        this.builderInstance = obj;
    }

    public final QueryProductDetailsParamsBuilderBridge setProductList(List<ProductBridge> productList) {
        k.e(productList, "productList");
        ArrayList arrayList = new ArrayList(n.L0(productList, 10));
        Iterator<T> it = productList.iterator();
        while (it.hasNext()) {
            arrayList.add(((ProductBridge) it.next()).getInternalClass());
        }
        Object objCallNonVoidMethod = callNonVoidMethod(SET_PRODUCT_LIST_METHOD, this.builderInstance, arrayList);
        k.d(objCallNonVoidMethod, "callNonVoidMethod(SET_PR…nce, productListInternal)");
        this.builderInstance = objCallNonVoidMethod;
        return this;
    }
}
