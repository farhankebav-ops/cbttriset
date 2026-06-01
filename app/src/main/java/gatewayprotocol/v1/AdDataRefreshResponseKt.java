package gatewayprotocol.v1;

import com.google.protobuf.ByteString;
import com.google.protobuf.kotlin.ProtoDslMarker;
import gatewayprotocol.v1.AdDataRefreshResponseOuterClass;
import gatewayprotocol.v1.ErrorOuterClass;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class AdDataRefreshResponseKt {
    public static final AdDataRefreshResponseKt INSTANCE = new AdDataRefreshResponseKt();

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @ProtoDslMarker
    public static final class Dsl {
        public static final Companion Companion = new Companion(null);
        private final AdDataRefreshResponseOuterClass.AdDataRefreshResponse.Builder _builder;

        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class Companion {
            public /* synthetic */ Companion(kotlin.jvm.internal.f fVar) {
                this();
            }

            public final /* synthetic */ Dsl _create(AdDataRefreshResponseOuterClass.AdDataRefreshResponse.Builder builder) {
                kotlin.jvm.internal.k.e(builder, "builder");
                return new Dsl(builder, null);
            }

            private Companion() {
            }
        }

        public /* synthetic */ Dsl(AdDataRefreshResponseOuterClass.AdDataRefreshResponse.Builder builder, kotlin.jvm.internal.f fVar) {
            this(builder);
        }

        public final /* synthetic */ AdDataRefreshResponseOuterClass.AdDataRefreshResponse _build() {
            AdDataRefreshResponseOuterClass.AdDataRefreshResponse adDataRefreshResponseBuild = this._builder.build();
            kotlin.jvm.internal.k.d(adDataRefreshResponseBuild, "_builder.build()");
            return adDataRefreshResponseBuild;
        }

        public final void clearAdData() {
            this._builder.clearAdData();
        }

        public final void clearAdDataRefreshToken() {
            this._builder.clearAdDataRefreshToken();
        }

        public final void clearAdDataVersion() {
            this._builder.clearAdDataVersion();
        }

        public final void clearError() {
            this._builder.clearError();
        }

        public final void clearTrackingToken() {
            this._builder.clearTrackingToken();
        }

        public final ByteString getAdData() {
            ByteString adData = this._builder.getAdData();
            kotlin.jvm.internal.k.d(adData, "_builder.getAdData()");
            return adData;
        }

        public final ByteString getAdDataRefreshToken() {
            ByteString adDataRefreshToken = this._builder.getAdDataRefreshToken();
            kotlin.jvm.internal.k.d(adDataRefreshToken, "_builder.getAdDataRefreshToken()");
            return adDataRefreshToken;
        }

        public final int getAdDataVersion() {
            return this._builder.getAdDataVersion();
        }

        public final ErrorOuterClass.Error getError() {
            ErrorOuterClass.Error error = this._builder.getError();
            kotlin.jvm.internal.k.d(error, "_builder.getError()");
            return error;
        }

        public final ErrorOuterClass.Error getErrorOrNull(Dsl dsl) {
            kotlin.jvm.internal.k.e(dsl, "<this>");
            return AdDataRefreshResponseKtKt.getErrorOrNull(dsl._builder);
        }

        public final ByteString getTrackingToken() {
            ByteString trackingToken = this._builder.getTrackingToken();
            kotlin.jvm.internal.k.d(trackingToken, "_builder.getTrackingToken()");
            return trackingToken;
        }

        public final boolean hasError() {
            return this._builder.hasError();
        }

        public final void setAdData(ByteString value) {
            kotlin.jvm.internal.k.e(value, "value");
            this._builder.setAdData(value);
        }

        public final void setAdDataRefreshToken(ByteString value) {
            kotlin.jvm.internal.k.e(value, "value");
            this._builder.setAdDataRefreshToken(value);
        }

        public final void setAdDataVersion(int i2) {
            this._builder.setAdDataVersion(i2);
        }

        public final void setError(ErrorOuterClass.Error value) {
            kotlin.jvm.internal.k.e(value, "value");
            this._builder.setError(value);
        }

        public final void setTrackingToken(ByteString value) {
            kotlin.jvm.internal.k.e(value, "value");
            this._builder.setTrackingToken(value);
        }

        private Dsl(AdDataRefreshResponseOuterClass.AdDataRefreshResponse.Builder builder) {
            this._builder = builder;
        }
    }

    private AdDataRefreshResponseKt() {
    }
}
