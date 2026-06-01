package com.unity3d.services.store.gpbl.proxies;

import com.unity3d.services.core.reflection.GenericListenerProxy;
import com.unity3d.services.store.gpbl.bridges.BillingResultBridge;
import com.unity3d.services.store.gpbl.bridges.billingclient.v8.QueryProductDetailsResultsBridge;
import com.unity3d.services.store.gpbl.listeners.ProductDetailsResponseListener;
import java.lang.reflect.Method;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class ProductDetailsResponseListenerProxy extends GenericListenerProxy {
    public static final Companion Companion = new Companion(null);
    public static final String onProductDetailsResponseMethodName = "onProductDetailsResponse";
    private final ProductDetailsResponseListener productDetailsResponseListener;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Companion {
        public /* synthetic */ Companion(f fVar) {
            this();
        }

        public final Class<?> getProxyListenerClass() throws ClassNotFoundException {
            return Class.forName("com.android.billingclient.api.ProductDetailsResponseListener");
        }

        private Companion() {
        }
    }

    public ProductDetailsResponseListenerProxy(ProductDetailsResponseListener productDetailsResponseListener) {
        this.productDetailsResponseListener = productDetailsResponseListener;
    }

    private final void onPurchasesUpdated(Object obj, Object obj2) {
        QueryProductDetailsResultsBridge queryProductDetailsResultsBridge = new QueryProductDetailsResultsBridge(obj2);
        ProductDetailsResponseListener productDetailsResponseListener = this.productDetailsResponseListener;
        if (productDetailsResponseListener != null) {
            productDetailsResponseListener.onProductDetailsResponse(new BillingResultBridge(obj), queryProductDetailsResultsBridge);
        }
    }

    public final ProductDetailsResponseListener getProductDetailsResponseListener() {
        return this.productDetailsResponseListener;
    }

    @Override // com.unity3d.services.core.reflection.GenericListenerProxy
    public Class<?> getProxyClass() {
        return Companion.getProxyListenerClass();
    }

    @Override // com.unity3d.services.core.reflection.GenericListenerProxy, java.lang.reflect.InvocationHandler
    public Object invoke(Object proxy, Method method, Object[] objArr) {
        Object obj;
        k.e(proxy, "proxy");
        k.e(method, "method");
        if (!k.a(method.getName(), onProductDetailsResponseMethodName)) {
            return super.invoke(proxy, method, objArr);
        }
        if (objArr != null && (obj = objArr[1]) != null) {
            onPurchasesUpdated(objArr[0], obj);
        }
        return null;
    }
}
