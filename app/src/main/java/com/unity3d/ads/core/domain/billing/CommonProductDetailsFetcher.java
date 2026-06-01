package com.unity3d.ads.core.domain.billing;

import a.a;
import com.unity3d.ads.core.domain.billing.ProductDetailsResult;
import com.unity3d.services.store.gpbl.BillingResultResponseCode;
import com.unity3d.services.store.gpbl.bridges.BillingResultBridge;
import com.unity3d.services.store.gpbl.bridges.billingclient.BillingClientAdapter;
import com.unity3d.services.store.gpbl.listeners.ProductDetailsListener;
import kotlin.jvm.internal.k;
import q6.l;
import v5.c;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class CommonProductDetailsFetcher implements ProductDetailsFetcher {
    private final BillingClientAdapter billingClientAdapter;
    private final String productType;

    public CommonProductDetailsFetcher(BillingClientAdapter billingClientAdapter, String productType) {
        k.e(productType, "productType");
        this.billingClientAdapter = billingClientAdapter;
        this.productType = productType;
    }

    @Override // com.unity3d.ads.core.domain.billing.ProductDetailsFetcher
    public Object fetchProductDetails(String str, c<? super ProductDetailsResult> cVar) {
        final l lVar = new l(1, a.I(cVar));
        lVar.r();
        ProductDetailsListener productDetailsListener = new ProductDetailsListener() { // from class: com.unity3d.ads.core.domain.billing.CommonProductDetailsFetcher$fetchProductDetails$2$listener$1
            @Override // com.unity3d.services.store.gpbl.listeners.ProductDetailsListener
            public final void onProductDetailsResponse(BillingResultBridge billingResult, String str2) {
                k.e(billingResult, "billingResult");
                if (str2 != null && billingResult.getResponseCode() == BillingResultResponseCode.OK) {
                    lVar.resumeWith(new ProductDetailsResult.Success(str2));
                } else if (billingResult.getResponseCode() == BillingResultResponseCode.OK) {
                    lVar.resumeWith(ProductDetailsResult.NotFound.INSTANCE);
                } else {
                    lVar.resumeWith(new ProductDetailsResult.Failure(billingResult));
                }
            }
        };
        BillingClientAdapter billingClientAdapter = this.billingClientAdapter;
        if (billingClientAdapter != null) {
            billingClientAdapter.queryProductDetailsAsync(str, this.productType, productDetailsListener);
        }
        Object objP = lVar.p();
        w5.a aVar = w5.a.f17774a;
        return objP;
    }
}
