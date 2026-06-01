package gatewayprotocol.v1;

import com.google.protobuf.kotlin.ProtoDslMarker;
import gatewayprotocol.v1.AllowedPiiOuterClass;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class AllowedPiiKt {
    public static final AllowedPiiKt INSTANCE = new AllowedPiiKt();

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @ProtoDslMarker
    public static final class Dsl {
        public static final Companion Companion = new Companion(null);
        private final AllowedPiiOuterClass.AllowedPii.Builder _builder;

        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class Companion {
            public /* synthetic */ Companion(kotlin.jvm.internal.f fVar) {
                this();
            }

            public final /* synthetic */ Dsl _create(AllowedPiiOuterClass.AllowedPii.Builder builder) {
                kotlin.jvm.internal.k.e(builder, "builder");
                return new Dsl(builder, null);
            }

            private Companion() {
            }
        }

        public /* synthetic */ Dsl(AllowedPiiOuterClass.AllowedPii.Builder builder, kotlin.jvm.internal.f fVar) {
            this(builder);
        }

        public final /* synthetic */ AllowedPiiOuterClass.AllowedPii _build() {
            AllowedPiiOuterClass.AllowedPii allowedPiiBuild = this._builder.build();
            kotlin.jvm.internal.k.d(allowedPiiBuild, "_builder.build()");
            return allowedPiiBuild;
        }

        public final void clearAppsetId() {
            this._builder.clearAppsetId();
        }

        public final void clearFid() {
            this._builder.clearFid();
        }

        public final void clearIdfa() {
            this._builder.clearIdfa();
        }

        public final void clearIdfv() {
            this._builder.clearIdfv();
        }

        public final boolean getAppsetId() {
            return this._builder.getAppsetId();
        }

        public final boolean getFid() {
            return this._builder.getFid();
        }

        public final boolean getIdfa() {
            return this._builder.getIdfa();
        }

        public final boolean getIdfv() {
            return this._builder.getIdfv();
        }

        public final void setAppsetId(boolean z2) {
            this._builder.setAppsetId(z2);
        }

        public final void setFid(boolean z2) {
            this._builder.setFid(z2);
        }

        public final void setIdfa(boolean z2) {
            this._builder.setIdfa(z2);
        }

        public final void setIdfv(boolean z2) {
            this._builder.setIdfv(z2);
        }

        private Dsl(AllowedPiiOuterClass.AllowedPii.Builder builder) {
            this._builder = builder;
        }
    }

    private AllowedPiiKt() {
    }
}
