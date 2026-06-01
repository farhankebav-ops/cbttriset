package gatewayprotocol.v1;

import com.google.protobuf.kotlin.ProtoDslMarker;
import gatewayprotocol.v1.NativeConfigurationOuterClass;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class AdOperationsConfigurationKt {
    public static final AdOperationsConfigurationKt INSTANCE = new AdOperationsConfigurationKt();

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @ProtoDslMarker
    public static final class Dsl {
        public static final Companion Companion = new Companion(null);
        private final NativeConfigurationOuterClass.AdOperationsConfiguration.Builder _builder;

        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class Companion {
            public /* synthetic */ Companion(kotlin.jvm.internal.f fVar) {
                this();
            }

            public final /* synthetic */ Dsl _create(NativeConfigurationOuterClass.AdOperationsConfiguration.Builder builder) {
                kotlin.jvm.internal.k.e(builder, "builder");
                return new Dsl(builder, null);
            }

            private Companion() {
            }
        }

        public /* synthetic */ Dsl(NativeConfigurationOuterClass.AdOperationsConfiguration.Builder builder, kotlin.jvm.internal.f fVar) {
            this(builder);
        }

        public final /* synthetic */ NativeConfigurationOuterClass.AdOperationsConfiguration _build() {
            NativeConfigurationOuterClass.AdOperationsConfiguration adOperationsConfigurationBuild = this._builder.build();
            kotlin.jvm.internal.k.d(adOperationsConfigurationBuild, "_builder.build()");
            return adOperationsConfigurationBuild;
        }

        public final void clearGetTokenTimeoutMs() {
            this._builder.clearGetTokenTimeoutMs();
        }

        public final void clearLoadTimeoutMs() {
            this._builder.clearLoadTimeoutMs();
        }

        public final void clearShowTimeoutMs() {
            this._builder.clearShowTimeoutMs();
        }

        public final int getGetTokenTimeoutMs() {
            return this._builder.getGetTokenTimeoutMs();
        }

        public final int getLoadTimeoutMs() {
            return this._builder.getLoadTimeoutMs();
        }

        public final int getShowTimeoutMs() {
            return this._builder.getShowTimeoutMs();
        }

        public final void setGetTokenTimeoutMs(int i2) {
            this._builder.setGetTokenTimeoutMs(i2);
        }

        public final void setLoadTimeoutMs(int i2) {
            this._builder.setLoadTimeoutMs(i2);
        }

        public final void setShowTimeoutMs(int i2) {
            this._builder.setShowTimeoutMs(i2);
        }

        private Dsl(NativeConfigurationOuterClass.AdOperationsConfiguration.Builder builder) {
            this._builder = builder;
        }
    }

    private AdOperationsConfigurationKt() {
    }
}
