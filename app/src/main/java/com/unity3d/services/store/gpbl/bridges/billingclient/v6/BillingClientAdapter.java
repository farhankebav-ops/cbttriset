package com.unity3d.services.store.gpbl.bridges.billingclient.v6;

import com.unity3d.services.store.gpbl.BillingResultResponseCode;
import com.unity3d.services.store.gpbl.bridges.BillingResultBridge;
import com.unity3d.services.store.gpbl.bridges.SkuDetailsBridge;
import com.unity3d.services.store.gpbl.bridges.SkuDetailsParamsBridge;
import com.unity3d.services.store.gpbl.bridges.billingclient.common.BillingClientBridgeCommon;
import com.unity3d.services.store.gpbl.listeners.BillingClientStateListener;
import com.unity3d.services.store.gpbl.listeners.BillingInitializationListener;
import com.unity3d.services.store.gpbl.listeners.ProductDetailsListener;
import com.unity3d.services.store.gpbl.listeners.PurchasesResponseListener;
import com.unity3d.services.store.gpbl.listeners.SkuDetailsResponseListener;
import com.unity3d.services.store.gpbl.proxies.BillingClientStateListenerProxy;
import com.unity3d.services.store.gpbl.proxies.PurchaseUpdatedListenerProxy;
import com.unity3d.services.store.gpbl.proxies.PurchasesResponseListenerProxy;
import com.unity3d.services.store.gpbl.proxies.SkuDetailsResponseListenerProxy;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;
import org.json.JSONObject;
import r2.q;
import t6.d1;
import t6.q0;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class BillingClientAdapter extends com.unity3d.services.store.gpbl.bridges.billingclient.BillingClientAdapter {
    private BillingClientBridge billingClient;
    private final BillingClientBuilderBridge billingClientBuilderBridge;
    private final int detectedVersion;

    public /* synthetic */ BillingClientAdapter(BillingClientBuilderBridge billingClientBuilderBridge, int i2, int i8, f fVar) {
        this(billingClientBuilderBridge, (i8 & 2) != 0 ? 6 : i2);
    }

    @Override // com.unity3d.services.store.gpbl.bridges.billingclient.BillingClientAdapter
    public String getAdapterVersion() {
        return String.valueOf(this.detectedVersion);
    }

    @Override // com.unity3d.services.store.gpbl.bridges.billingclient.BillingClientAdapter
    public void initialize(BillingInitializationListener billingInitializationListener) throws IllegalAccessException, NoSuchMethodException, ClassNotFoundException, InvocationTargetException {
        k.e(billingInitializationListener, "billingInitializationListener");
        if (isInitialized()) {
            billingInitializationListener.onIsAlreadyInitialized();
            return;
        }
        this.billingClientBuilderBridge.setListener(new PurchaseUpdatedListenerProxy(billingInitializationListener));
        this.billingClientBuilderBridge.enablePendingPurchases();
        BillingClientBridgeCommon billingClientBridgeCommonBuild = this.billingClientBuilderBridge.build();
        k.c(billingClientBridgeCommonBuild, "null cannot be cast to non-null type com.unity3d.services.store.gpbl.bridges.billingclient.v6.BillingClientBridge");
        this.billingClient = (BillingClientBridge) billingClientBridgeCommonBuild;
        startConnection(billingInitializationListener);
        q0 q0Var = get_isInitialized$unity_ads_defaultRelease();
        Boolean bool = Boolean.TRUE;
        d1 d1Var = (d1) q0Var;
        d1Var.getClass();
        d1Var.i(null, bool);
    }

    @Override // com.unity3d.services.store.gpbl.bridges.billingclient.BillingClientAdapter
    public BillingResultResponseCode isFeatureSupported(String str) {
        BillingClientBridge billingClientBridge = this.billingClient;
        if (billingClientBridge != null) {
            return billingClientBridge.isFeatureSupported(str);
        }
        k.l("billingClient");
        throw null;
    }

    @Override // com.unity3d.services.store.gpbl.bridges.billingclient.BillingClientAdapter
    public boolean isReady() {
        BillingClientBridge billingClientBridge = this.billingClient;
        if (billingClientBridge != null) {
            return billingClientBridge.isReady();
        }
        k.l("billingClient");
        throw null;
    }

    @Override // com.unity3d.services.store.gpbl.bridges.billingclient.BillingClientAdapter
    public void queryProductDetailsAsync(String productId, String productType, final ProductDetailsListener listener) throws IllegalAccessException, NoSuchMethodException, ClassNotFoundException, InvocationTargetException {
        k.e(productId, "productId");
        k.e(productType, "productType");
        k.e(listener, "listener");
        SkuDetailsParamsBridge skuDetailsParamsBridgeBuild = SkuDetailsParamsBridge.newBuilder().setSkuList(q.j0(productId)).setType(productType).build();
        BillingClientBridge billingClientBridge = this.billingClient;
        if (billingClientBridge != null) {
            billingClientBridge.querySkuDetailsAsync(skuDetailsParamsBridgeBuild, new SkuDetailsResponseListenerProxy(new SkuDetailsResponseListener() { // from class: com.unity3d.services.store.gpbl.bridges.billingclient.v6.BillingClientAdapter.queryProductDetailsAsync.1
                @Override // com.unity3d.services.store.gpbl.listeners.SkuDetailsResponseListener
                public void onSkuDetailsUpdated(BillingResultBridge billingResult, List<? extends SkuDetailsBridge> list) {
                    k.e(billingResult, "billingResult");
                    if (list == null || list.isEmpty()) {
                        listener.onProductDetailsResponse(billingResult, null);
                        return;
                    }
                    ProductDetailsListener productDetailsListener = listener;
                    JSONObject originalJson = list.get(0).getOriginalJson();
                    productDetailsListener.onProductDetailsResponse(billingResult, originalJson != null ? originalJson.toString() : null);
                }
            }));
        } else {
            k.l("billingClient");
            throw null;
        }
    }

    @Override // com.unity3d.services.store.gpbl.bridges.billingclient.BillingClientAdapter
    public void queryPurchasesAsync(String str, PurchasesResponseListener purchasesResponseListener) throws ClassNotFoundException {
        BillingClientBridge billingClientBridge = this.billingClient;
        if (billingClientBridge != null) {
            billingClientBridge.queryPurchasesAsync(str, new PurchasesResponseListenerProxy(purchasesResponseListener));
        } else {
            k.l("billingClient");
            throw null;
        }
    }

    @Override // com.unity3d.services.store.gpbl.bridges.billingclient.BillingClientAdapter
    public void startConnection(BillingClientStateListener billingClientStateListener) throws ClassNotFoundException {
        BillingClientBridge billingClientBridge = this.billingClient;
        if (billingClientBridge != null) {
            billingClientBridge.startConnection(new BillingClientStateListenerProxy(billingClientStateListener));
        } else {
            k.l("billingClient");
            throw null;
        }
    }

    public BillingClientAdapter(BillingClientBuilderBridge billingClientBuilderBridge, int i2) {
        k.e(billingClientBuilderBridge, "billingClientBuilderBridge");
        this.billingClientBuilderBridge = billingClientBuilderBridge;
        this.detectedVersion = i2;
    }
}
