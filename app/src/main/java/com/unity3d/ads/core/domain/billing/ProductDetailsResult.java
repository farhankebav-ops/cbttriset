package com.unity3d.ads.core.domain.billing;

import a1.a;
import com.unity3d.services.store.gpbl.bridges.BillingResultBridge;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class ProductDetailsResult {

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Failure extends ProductDetailsResult {
        private final BillingResultBridge billingResult;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Failure(BillingResultBridge billingResult) {
            super(null);
            k.e(billingResult, "billingResult");
            this.billingResult = billingResult;
        }

        public static /* synthetic */ Failure copy$default(Failure failure, BillingResultBridge billingResultBridge, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                billingResultBridge = failure.billingResult;
            }
            return failure.copy(billingResultBridge);
        }

        public final BillingResultBridge component1() {
            return this.billingResult;
        }

        public final Failure copy(BillingResultBridge billingResult) {
            k.e(billingResult, "billingResult");
            return new Failure(billingResult);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Failure) && k.a(this.billingResult, ((Failure) obj).billingResult);
        }

        public final BillingResultBridge getBillingResult() {
            return this.billingResult;
        }

        public int hashCode() {
            return this.billingResult.hashCode();
        }

        public String toString() {
            return "Failure(billingResult=" + this.billingResult + ')';
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class NotFound extends ProductDetailsResult {
        public static final NotFound INSTANCE = new NotFound();

        private NotFound() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Success extends ProductDetailsResult {
        private final String productDetailsJson;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Success(String productDetailsJson) {
            super(null);
            k.e(productDetailsJson, "productDetailsJson");
            this.productDetailsJson = productDetailsJson;
        }

        public static /* synthetic */ Success copy$default(Success success, String str, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = success.productDetailsJson;
            }
            return success.copy(str);
        }

        public final String component1() {
            return this.productDetailsJson;
        }

        public final Success copy(String productDetailsJson) {
            k.e(productDetailsJson, "productDetailsJson");
            return new Success(productDetailsJson);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Success) && k.a(this.productDetailsJson, ((Success) obj).productDetailsJson);
        }

        public final String getProductDetailsJson() {
            return this.productDetailsJson;
        }

        public int hashCode() {
            return this.productDetailsJson.hashCode();
        }

        public String toString() {
            return a.e(')', this.productDetailsJson, new StringBuilder("Success(productDetailsJson="));
        }
    }

    public /* synthetic */ ProductDetailsResult(f fVar) {
        this();
    }

    private ProductDetailsResult() {
    }
}
