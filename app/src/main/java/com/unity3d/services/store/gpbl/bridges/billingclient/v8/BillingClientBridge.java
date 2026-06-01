package com.unity3d.services.store.gpbl.bridges.billingclient.v8;

import android.content.Context;
import com.unity3d.services.store.gpbl.bridges.SkuDetailsParamsBridge;
import com.unity3d.services.store.gpbl.bridges.billingclient.common.BillingClientBridgeCommon;
import com.unity3d.services.store.gpbl.proxies.ProductDetailsResponseListenerProxy;
import com.unity3d.services.store.gpbl.proxies.PurchasesResponseListenerProxy;
import com.unity3d.services.store.gpbl.proxies.SkuDetailsResponseListenerProxy;
import java.lang.reflect.InvocationTargetException;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;
import q5.i;
import r5.x;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class BillingClientBridge extends BillingClientBridgeCommon {
    public static final Companion Companion = new Companion(null);
    public static final String QUERY_PRODUCT_DETAILS_ASYNC_METHOD = "queryProductDetailsAsync";
    public static final String QUERY_PURCHASES_ASYNC_METHOD = "queryPurchasesAsync";

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Companion {
        public /* synthetic */ Companion(f fVar) {
            this();
        }

        public final BillingClientBuilderBridge newBuilder(Context context) throws IllegalAccessException, NoSuchMethodException, ClassNotFoundException, InvocationTargetException {
            k.e(context, "context");
            return new BillingClientBuilderBridge(BillingClientBridgeCommon.callNonVoidStaticMethod("newBuilder", context));
        }

        private Companion() {
        }
    }

    public BillingClientBridge(Object obj) {
        super(obj, x.f0(new i(QUERY_PURCHASES_ASYNC_METHOD, new Class[]{QueryPurchasesParamsBridge.Companion.getClassForParams(), PurchasesResponseListenerProxy.getProxyListenerClass()}), new i(QUERY_PRODUCT_DETAILS_ASYNC_METHOD, new Class[]{QueryProductDetailsParamsBridge.Companion.getClassForParams(), ProductDetailsResponseListenerProxy.Companion.getProxyListenerClass()})));
    }

    public static final BillingClientBuilderBridge newBuilder(Context context) throws IllegalAccessException, NoSuchMethodException, ClassNotFoundException, InvocationTargetException {
        return Companion.newBuilder(context);
    }

    public final void queryProductDetailsAsync(QueryProductDetailsParamsBridge queryProductDetailsParamsBridge, ProductDetailsResponseListenerProxy productDetailsResponseListenerProxy) {
        k.e(queryProductDetailsParamsBridge, "queryProductDetailsParamsBridge");
        k.e(productDetailsResponseListenerProxy, "productDetailsResponseListenerProxy");
        callVoidMethod(QUERY_PRODUCT_DETAILS_ASYNC_METHOD, this._billingClientInternalInstance, queryProductDetailsParamsBridge.getQueryProductDetailsParamsInternalInstance(), productDetailsResponseListenerProxy.getProxyInstance());
    }

    @Override // com.unity3d.services.store.gpbl.bridges.billingclient.IBillingClient
    public void queryPurchasesAsync(String str, PurchasesResponseListenerProxy purchasesResponseListenerProxy) throws ClassNotFoundException {
        if (str != null) {
            QueryProductDetailsParamsBridge queryProductDetailsParamsBridgeBuild = QueryPurchasesParamsBridge.Companion.newBuilder().setProductType(str).build();
            Object obj = this._billingClientInternalInstance;
            Object queryProductDetailsParamsInternalInstance = queryProductDetailsParamsBridgeBuild.getQueryProductDetailsParamsInternalInstance();
            k.b(purchasesResponseListenerProxy);
            callVoidMethod(QUERY_PURCHASES_ASYNC_METHOD, obj, queryProductDetailsParamsInternalInstance, purchasesResponseListenerProxy.getProxyInstance());
        }
    }

    @Override // com.unity3d.services.store.gpbl.bridges.billingclient.IBillingClient
    public void querySkuDetailsAsync(SkuDetailsParamsBridge params, SkuDetailsResponseListenerProxy skuDetailsResponseListenerProxy) throws NoSuchMethodException, ClassNotFoundException {
        k.e(params, "params");
        k.e(skuDetailsResponseListenerProxy, "skuDetailsResponseListenerProxy");
        throw new NoSuchMethodException("querySkuDetailsAsync does not exist in Billing Library v8, use queryProductDetailsAsync instead");
    }
}
