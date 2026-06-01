package gatewayprotocol.v1;

import com.google.protobuf.ByteString;
import com.google.protobuf.Timestamp;
import com.google.protobuf.kotlin.ProtoDslMarker;
import gatewayprotocol.v1.TransactionEventRequestOuterClass;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class TransactionDataKt {
    public static final TransactionDataKt INSTANCE = new TransactionDataKt();

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @ProtoDslMarker
    public static final class Dsl {
        public static final Companion Companion = new Companion(null);
        private final TransactionEventRequestOuterClass.TransactionData.Builder _builder;

        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class Companion {
            public /* synthetic */ Companion(kotlin.jvm.internal.f fVar) {
                this();
            }

            public final /* synthetic */ Dsl _create(TransactionEventRequestOuterClass.TransactionData.Builder builder) {
                kotlin.jvm.internal.k.e(builder, "builder");
                return new Dsl(builder, null);
            }

            private Companion() {
            }
        }

        public /* synthetic */ Dsl(TransactionEventRequestOuterClass.TransactionData.Builder builder, kotlin.jvm.internal.f fVar) {
            this(builder);
        }

        public final /* synthetic */ TransactionEventRequestOuterClass.TransactionData _build() {
            TransactionEventRequestOuterClass.TransactionData transactionDataBuild = this._builder.build();
            kotlin.jvm.internal.k.d(transactionDataBuild, "_builder.build()");
            return transactionDataBuild;
        }

        public final void clearEventId() {
            this._builder.clearEventId();
        }

        public final void clearJwsRepresentation() {
            this._builder.clearJwsRepresentation();
        }

        public final void clearProduct() {
            this._builder.clearProduct();
        }

        public final void clearProductId() {
            this._builder.clearProductId();
        }

        public final void clearReceipt() {
            this._builder.clearReceipt();
        }

        public final void clearSignature() {
            this._builder.clearSignature();
        }

        public final void clearTimestamp() {
            this._builder.clearTimestamp();
        }

        public final void clearTransaction() {
            this._builder.clearTransaction();
        }

        public final void clearTransactionId() {
            this._builder.clearTransactionId();
        }

        public final void clearTransactionState() {
            this._builder.clearTransactionState();
        }

        public final ByteString getEventId() {
            ByteString eventId = this._builder.getEventId();
            kotlin.jvm.internal.k.d(eventId, "_builder.getEventId()");
            return eventId;
        }

        public final String getJwsRepresentation() {
            String jwsRepresentation = this._builder.getJwsRepresentation();
            kotlin.jvm.internal.k.d(jwsRepresentation, "_builder.getJwsRepresentation()");
            return jwsRepresentation;
        }

        public final String getProduct() {
            String product = this._builder.getProduct();
            kotlin.jvm.internal.k.d(product, "_builder.getProduct()");
            return product;
        }

        public final String getProductId() {
            String productId = this._builder.getProductId();
            kotlin.jvm.internal.k.d(productId, "_builder.getProductId()");
            return productId;
        }

        public final String getReceipt() {
            String receipt = this._builder.getReceipt();
            kotlin.jvm.internal.k.d(receipt, "_builder.getReceipt()");
            return receipt;
        }

        public final String getSignature() {
            String signature = this._builder.getSignature();
            kotlin.jvm.internal.k.d(signature, "_builder.getSignature()");
            return signature;
        }

        public final Timestamp getTimestamp() {
            Timestamp timestamp = this._builder.getTimestamp();
            kotlin.jvm.internal.k.d(timestamp, "_builder.getTimestamp()");
            return timestamp;
        }

        public final String getTransaction() {
            String transaction = this._builder.getTransaction();
            kotlin.jvm.internal.k.d(transaction, "_builder.getTransaction()");
            return transaction;
        }

        public final String getTransactionId() {
            String transactionId = this._builder.getTransactionId();
            kotlin.jvm.internal.k.d(transactionId, "_builder.getTransactionId()");
            return transactionId;
        }

        public final TransactionEventRequestOuterClass.TransactionState getTransactionState() {
            TransactionEventRequestOuterClass.TransactionState transactionState = this._builder.getTransactionState();
            kotlin.jvm.internal.k.d(transactionState, "_builder.getTransactionState()");
            return transactionState;
        }

        public final int getTransactionStateValue() {
            return this._builder.getTransactionStateValue();
        }

        public final boolean hasJwsRepresentation() {
            return this._builder.hasJwsRepresentation();
        }

        public final boolean hasReceipt() {
            return this._builder.hasReceipt();
        }

        public final boolean hasSignature() {
            return this._builder.hasSignature();
        }

        public final boolean hasTimestamp() {
            return this._builder.hasTimestamp();
        }

        public final void setEventId(ByteString value) {
            kotlin.jvm.internal.k.e(value, "value");
            this._builder.setEventId(value);
        }

        public final void setJwsRepresentation(String value) {
            kotlin.jvm.internal.k.e(value, "value");
            this._builder.setJwsRepresentation(value);
        }

        public final void setProduct(String value) {
            kotlin.jvm.internal.k.e(value, "value");
            this._builder.setProduct(value);
        }

        public final void setProductId(String value) {
            kotlin.jvm.internal.k.e(value, "value");
            this._builder.setProductId(value);
        }

        public final void setReceipt(String value) {
            kotlin.jvm.internal.k.e(value, "value");
            this._builder.setReceipt(value);
        }

        public final void setSignature(String value) {
            kotlin.jvm.internal.k.e(value, "value");
            this._builder.setSignature(value);
        }

        public final void setTimestamp(Timestamp value) {
            kotlin.jvm.internal.k.e(value, "value");
            this._builder.setTimestamp(value);
        }

        public final void setTransaction(String value) {
            kotlin.jvm.internal.k.e(value, "value");
            this._builder.setTransaction(value);
        }

        public final void setTransactionId(String value) {
            kotlin.jvm.internal.k.e(value, "value");
            this._builder.setTransactionId(value);
        }

        public final void setTransactionState(TransactionEventRequestOuterClass.TransactionState value) {
            kotlin.jvm.internal.k.e(value, "value");
            this._builder.setTransactionState(value);
        }

        public final void setTransactionStateValue(int i2) {
            this._builder.setTransactionStateValue(i2);
        }

        private Dsl(TransactionEventRequestOuterClass.TransactionData.Builder builder) {
            this._builder = builder;
        }
    }

    private TransactionDataKt() {
    }
}
