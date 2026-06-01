package com.unity3d.ads.core.domain.events;

import com.unity3d.ads.core.domain.GetByteStringId;
import com.unity3d.ads.core.extensions.TimestampExtensionsKt;
import com.unity3d.ads.core.extensions.TransactionStateExtensionsKt;
import com.unity3d.ads.metadata.InAppPurchaseMetaData;
import com.unity3d.services.store.gpbl.bridges.PurchaseBridge;
import gatewayprotocol.v1.TransactionDataKt;
import gatewayprotocol.v1.TransactionEventRequestOuterClass;
import kotlin.jvm.internal.k;
import org.json.JSONException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class AndroidGetTransactionData implements GetTransactionData {
    private final GetByteStringId getByteStringId;

    public AndroidGetTransactionData(GetByteStringId getByteStringId) {
        k.e(getByteStringId, "getByteStringId");
        this.getByteStringId = getByteStringId;
    }

    @Override // com.unity3d.ads.core.domain.events.GetTransactionData
    public TransactionEventRequestOuterClass.TransactionData invoke(PurchaseBridge purchaseDetail, String productDetailJson) throws JSONException {
        k.e(purchaseDetail, "purchaseDetail");
        k.e(productDetailJson, "productDetailJson");
        TransactionDataKt.Dsl.Companion companion = TransactionDataKt.Dsl.Companion;
        TransactionEventRequestOuterClass.TransactionData.Builder builderNewBuilder = TransactionEventRequestOuterClass.TransactionData.newBuilder();
        k.d(builderNewBuilder, "newBuilder()");
        TransactionDataKt.Dsl dsl_create = companion._create(builderNewBuilder);
        dsl_create.setProductId(purchaseDetail.getOriginalJson().get(InAppPurchaseMetaData.KEY_PRODUCT_ID).toString());
        dsl_create.setEventId(this.getByteStringId.invoke());
        Object obj = purchaseDetail.getOriginalJson().get("purchaseTime");
        k.c(obj, "null cannot be cast to non-null type kotlin.Long");
        dsl_create.setTimestamp(TimestampExtensionsKt.fromMillis(((Long) obj).longValue()));
        dsl_create.setTransactionId(purchaseDetail.getOriginalJson().get("orderId").toString());
        dsl_create.setProduct(productDetailJson);
        String string = purchaseDetail.getOriginalJson().toString();
        k.d(string, "purchaseDetail.originalJson.toString()");
        dsl_create.setTransaction(string);
        String signature = purchaseDetail.getSignature();
        k.d(signature, "purchaseDetail.signature");
        dsl_create.setSignature(signature);
        Object obj2 = purchaseDetail.getOriginalJson().get("purchaseState");
        k.c(obj2, "null cannot be cast to non-null type kotlin.Int");
        dsl_create.setTransactionState(TransactionStateExtensionsKt.fromPurchaseState(((Integer) obj2).intValue()));
        return dsl_create._build();
    }
}
