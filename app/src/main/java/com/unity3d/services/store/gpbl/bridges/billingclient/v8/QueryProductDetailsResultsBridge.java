package com.unity3d.services.store.gpbl.bridges.billingclient.v8;

import com.unity3d.services.core.reflection.GenericBridge;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;
import q5.i;
import r5.n;
import r5.r;
import r5.x;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class QueryProductDetailsResultsBridge extends GenericBridge {
    public static final Companion Companion = new Companion(null);
    private static final String GET_PRODUCT_DETAILS_LIST_METHOD = "getProductDetailsList";
    private final Object productDetailsResult;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Companion {
        public /* synthetic */ Companion(f fVar) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QueryProductDetailsResultsBridge(Object productDetailsResult) {
        super(x.e0(new i(GET_PRODUCT_DETAILS_LIST_METHOD, new Class[0])));
        k.e(productDetailsResult, "productDetailsResult");
        this.productDetailsResult = productDetailsResult;
    }

    @Override // com.unity3d.services.core.reflection.GenericBridge
    public String getClassName() {
        return "com.android.billingclient.api.QueryProductDetailsResult";
    }

    public final List<ProductDetailsBridge> getProductDetailsList() {
        List list = (List) callNonVoidMethod(GET_PRODUCT_DETAILS_LIST_METHOD, this.productDetailsResult, new Object[0]);
        if (list == null) {
            return r.f13638a;
        }
        ArrayList arrayList = new ArrayList(n.L0(list, 10));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(new ProductDetailsBridge(it.next()));
        }
        return arrayList;
    }
}
