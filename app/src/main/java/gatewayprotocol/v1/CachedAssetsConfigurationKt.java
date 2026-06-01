package gatewayprotocol.v1;

import com.google.protobuf.kotlin.ProtoDslMarker;
import gatewayprotocol.v1.NativeConfigurationOuterClass;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class CachedAssetsConfigurationKt {
    public static final CachedAssetsConfigurationKt INSTANCE = new CachedAssetsConfigurationKt();

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @ProtoDslMarker
    public static final class Dsl {
        public static final Companion Companion = new Companion(null);
        private final NativeConfigurationOuterClass.CachedAssetsConfiguration.Builder _builder;

        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class Companion {
            public /* synthetic */ Companion(kotlin.jvm.internal.f fVar) {
                this();
            }

            public final /* synthetic */ Dsl _create(NativeConfigurationOuterClass.CachedAssetsConfiguration.Builder builder) {
                kotlin.jvm.internal.k.e(builder, "builder");
                return new Dsl(builder, null);
            }

            private Companion() {
            }
        }

        public /* synthetic */ Dsl(NativeConfigurationOuterClass.CachedAssetsConfiguration.Builder builder, kotlin.jvm.internal.f fVar) {
            this(builder);
        }

        public final /* synthetic */ NativeConfigurationOuterClass.CachedAssetsConfiguration _build() {
            NativeConfigurationOuterClass.CachedAssetsConfiguration cachedAssetsConfigurationBuild = this._builder.build();
            kotlin.jvm.internal.k.d(cachedAssetsConfigurationBuild, "_builder.build()");
            return cachedAssetsConfigurationBuild;
        }

        public final void clearMaxCachedAssetAgeMs() {
            this._builder.clearMaxCachedAssetAgeMs();
        }

        public final void clearMaxCachedAssetSizeMb() {
            this._builder.clearMaxCachedAssetSizeMb();
        }

        public final long getMaxCachedAssetAgeMs() {
            return this._builder.getMaxCachedAssetAgeMs();
        }

        public final int getMaxCachedAssetSizeMb() {
            return this._builder.getMaxCachedAssetSizeMb();
        }

        public final void setMaxCachedAssetAgeMs(long j) {
            this._builder.setMaxCachedAssetAgeMs(j);
        }

        public final void setMaxCachedAssetSizeMb(int i2) {
            this._builder.setMaxCachedAssetSizeMb(i2);
        }

        private Dsl(NativeConfigurationOuterClass.CachedAssetsConfiguration.Builder builder) {
            this._builder = builder;
        }
    }

    private CachedAssetsConfigurationKt() {
    }
}
