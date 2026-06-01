package gatewayprotocol.v1;

import com.google.protobuf.kotlin.DslList;
import com.google.protobuf.kotlin.DslProxy;
import com.google.protobuf.kotlin.ProtoDslMarker;
import gatewayprotocol.v1.DynamicDeviceInfoOuterClass;
import gatewayprotocol.v1.StaticDeviceInfoOuterClass;
import gatewayprotocol.v1.TransactionEventRequestOuterClass;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class TransactionEventRequestKt {
    public static final TransactionEventRequestKt INSTANCE = new TransactionEventRequestKt();

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @ProtoDslMarker
    public static final class Dsl {
        public static final Companion Companion = new Companion(null);
        private final TransactionEventRequestOuterClass.TransactionEventRequest.Builder _builder;

        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class Companion {
            public /* synthetic */ Companion(kotlin.jvm.internal.f fVar) {
                this();
            }

            public final /* synthetic */ Dsl _create(TransactionEventRequestOuterClass.TransactionEventRequest.Builder builder) {
                kotlin.jvm.internal.k.e(builder, "builder");
                return new Dsl(builder, null);
            }

            private Companion() {
            }
        }

        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class TransactionDataProxy extends DslProxy {
            private TransactionDataProxy() {
            }
        }

        public /* synthetic */ Dsl(TransactionEventRequestOuterClass.TransactionEventRequest.Builder builder, kotlin.jvm.internal.f fVar) {
            this(builder);
        }

        public final /* synthetic */ TransactionEventRequestOuterClass.TransactionEventRequest _build() {
            TransactionEventRequestOuterClass.TransactionEventRequest transactionEventRequestBuild = this._builder.build();
            kotlin.jvm.internal.k.d(transactionEventRequestBuild, "_builder.build()");
            return transactionEventRequestBuild;
        }

        public final /* synthetic */ void addAllTransactionData(DslList dslList, Iterable values) {
            kotlin.jvm.internal.k.e(dslList, "<this>");
            kotlin.jvm.internal.k.e(values, "values");
            this._builder.addAllTransactionData(values);
        }

        public final /* synthetic */ void addTransactionData(DslList dslList, TransactionEventRequestOuterClass.TransactionData value) {
            kotlin.jvm.internal.k.e(dslList, "<this>");
            kotlin.jvm.internal.k.e(value, "value");
            this._builder.addTransactionData(value);
        }

        public final void clearAppStore() {
            this._builder.clearAppStore();
        }

        public final void clearCustomStore() {
            this._builder.clearCustomStore();
        }

        public final void clearDynamicDeviceInfo() {
            this._builder.clearDynamicDeviceInfo();
        }

        public final void clearGooglePlayBillingLibraryVersion() {
            this._builder.clearGooglePlayBillingLibraryVersion();
        }

        public final void clearOrigin() {
            this._builder.clearOrigin();
        }

        public final void clearStaticDeviceInfo() {
            this._builder.clearStaticDeviceInfo();
        }

        public final void clearStoreKitVersion() {
            this._builder.clearStoreKitVersion();
        }

        public final /* synthetic */ void clearTransactionData(DslList dslList) {
            kotlin.jvm.internal.k.e(dslList, "<this>");
            this._builder.clearTransactionData();
        }

        public final TransactionEventRequestOuterClass.StoreType getAppStore() {
            TransactionEventRequestOuterClass.StoreType appStore = this._builder.getAppStore();
            kotlin.jvm.internal.k.d(appStore, "_builder.getAppStore()");
            return appStore;
        }

        public final int getAppStoreValue() {
            return this._builder.getAppStoreValue();
        }

        public final String getCustomStore() {
            String customStore = this._builder.getCustomStore();
            kotlin.jvm.internal.k.d(customStore, "_builder.getCustomStore()");
            return customStore;
        }

        public final DynamicDeviceInfoOuterClass.DynamicDeviceInfo getDynamicDeviceInfo() {
            DynamicDeviceInfoOuterClass.DynamicDeviceInfo dynamicDeviceInfo = this._builder.getDynamicDeviceInfo();
            kotlin.jvm.internal.k.d(dynamicDeviceInfo, "_builder.getDynamicDeviceInfo()");
            return dynamicDeviceInfo;
        }

        public final String getGooglePlayBillingLibraryVersion() {
            String googlePlayBillingLibraryVersion = this._builder.getGooglePlayBillingLibraryVersion();
            kotlin.jvm.internal.k.d(googlePlayBillingLibraryVersion, "_builder.getGooglePlayBillingLibraryVersion()");
            return googlePlayBillingLibraryVersion;
        }

        public final TransactionEventRequestOuterClass.TransactionOrigin getOrigin() {
            TransactionEventRequestOuterClass.TransactionOrigin origin = this._builder.getOrigin();
            kotlin.jvm.internal.k.d(origin, "_builder.getOrigin()");
            return origin;
        }

        public final int getOriginValue() {
            return this._builder.getOriginValue();
        }

        public final StaticDeviceInfoOuterClass.StaticDeviceInfo getStaticDeviceInfo() {
            StaticDeviceInfoOuterClass.StaticDeviceInfo staticDeviceInfo = this._builder.getStaticDeviceInfo();
            kotlin.jvm.internal.k.d(staticDeviceInfo, "_builder.getStaticDeviceInfo()");
            return staticDeviceInfo;
        }

        public final TransactionEventRequestOuterClass.StoreKitVersion getStoreKitVersion() {
            TransactionEventRequestOuterClass.StoreKitVersion storeKitVersion = this._builder.getStoreKitVersion();
            kotlin.jvm.internal.k.d(storeKitVersion, "_builder.getStoreKitVersion()");
            return storeKitVersion;
        }

        public final int getStoreKitVersionValue() {
            return this._builder.getStoreKitVersionValue();
        }

        public final /* synthetic */ DslList getTransactionData() {
            List<TransactionEventRequestOuterClass.TransactionData> transactionDataList = this._builder.getTransactionDataList();
            kotlin.jvm.internal.k.d(transactionDataList, "_builder.getTransactionDataList()");
            return new DslList(transactionDataList);
        }

        public final boolean hasDynamicDeviceInfo() {
            return this._builder.hasDynamicDeviceInfo();
        }

        public final boolean hasStaticDeviceInfo() {
            return this._builder.hasStaticDeviceInfo();
        }

        public final /* synthetic */ void plusAssignAllTransactionData(DslList<TransactionEventRequestOuterClass.TransactionData, TransactionDataProxy> dslList, Iterable<TransactionEventRequestOuterClass.TransactionData> values) {
            kotlin.jvm.internal.k.e(dslList, "<this>");
            kotlin.jvm.internal.k.e(values, "values");
            addAllTransactionData(dslList, values);
        }

        public final /* synthetic */ void plusAssignTransactionData(DslList<TransactionEventRequestOuterClass.TransactionData, TransactionDataProxy> dslList, TransactionEventRequestOuterClass.TransactionData value) {
            kotlin.jvm.internal.k.e(dslList, "<this>");
            kotlin.jvm.internal.k.e(value, "value");
            addTransactionData(dslList, value);
        }

        public final void setAppStore(TransactionEventRequestOuterClass.StoreType value) {
            kotlin.jvm.internal.k.e(value, "value");
            this._builder.setAppStore(value);
        }

        public final void setAppStoreValue(int i2) {
            this._builder.setAppStoreValue(i2);
        }

        public final void setCustomStore(String value) {
            kotlin.jvm.internal.k.e(value, "value");
            this._builder.setCustomStore(value);
        }

        public final void setDynamicDeviceInfo(DynamicDeviceInfoOuterClass.DynamicDeviceInfo value) {
            kotlin.jvm.internal.k.e(value, "value");
            this._builder.setDynamicDeviceInfo(value);
        }

        public final void setGooglePlayBillingLibraryVersion(String value) {
            kotlin.jvm.internal.k.e(value, "value");
            this._builder.setGooglePlayBillingLibraryVersion(value);
        }

        public final void setOrigin(TransactionEventRequestOuterClass.TransactionOrigin value) {
            kotlin.jvm.internal.k.e(value, "value");
            this._builder.setOrigin(value);
        }

        public final void setOriginValue(int i2) {
            this._builder.setOriginValue(i2);
        }

        public final void setStaticDeviceInfo(StaticDeviceInfoOuterClass.StaticDeviceInfo value) {
            kotlin.jvm.internal.k.e(value, "value");
            this._builder.setStaticDeviceInfo(value);
        }

        public final void setStoreKitVersion(TransactionEventRequestOuterClass.StoreKitVersion value) {
            kotlin.jvm.internal.k.e(value, "value");
            this._builder.setStoreKitVersion(value);
        }

        public final void setStoreKitVersionValue(int i2) {
            this._builder.setStoreKitVersionValue(i2);
        }

        public final /* synthetic */ void setTransactionData(DslList dslList, int i2, TransactionEventRequestOuterClass.TransactionData value) {
            kotlin.jvm.internal.k.e(dslList, "<this>");
            kotlin.jvm.internal.k.e(value, "value");
            this._builder.setTransactionData(i2, value);
        }

        private Dsl(TransactionEventRequestOuterClass.TransactionEventRequest.Builder builder) {
            this._builder = builder;
        }
    }

    private TransactionEventRequestKt() {
    }
}
