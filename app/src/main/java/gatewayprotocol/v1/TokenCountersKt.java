package gatewayprotocol.v1;

import com.google.protobuf.kotlin.ProtoDslMarker;
import gatewayprotocol.v1.HeaderBiddingTokenOuterClass;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class TokenCountersKt {
    public static final TokenCountersKt INSTANCE = new TokenCountersKt();

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @ProtoDslMarker
    public static final class Dsl {
        public static final Companion Companion = new Companion(null);
        private final HeaderBiddingTokenOuterClass.TokenCounters.Builder _builder;

        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class Companion {
            public /* synthetic */ Companion(kotlin.jvm.internal.f fVar) {
                this();
            }

            public final /* synthetic */ Dsl _create(HeaderBiddingTokenOuterClass.TokenCounters.Builder builder) {
                kotlin.jvm.internal.k.e(builder, "builder");
                return new Dsl(builder, null);
            }

            private Companion() {
            }
        }

        public /* synthetic */ Dsl(HeaderBiddingTokenOuterClass.TokenCounters.Builder builder, kotlin.jvm.internal.f fVar) {
            this(builder);
        }

        public final /* synthetic */ HeaderBiddingTokenOuterClass.TokenCounters _build() {
            HeaderBiddingTokenOuterClass.TokenCounters tokenCountersBuild = this._builder.build();
            kotlin.jvm.internal.k.d(tokenCountersBuild, "_builder.build()");
            return tokenCountersBuild;
        }

        public final void clearSeq() {
            this._builder.clearSeq();
        }

        public final void clearStarts() {
            this._builder.clearStarts();
        }

        public final void clearWins() {
            this._builder.clearWins();
        }

        public final int getSeq() {
            return this._builder.getSeq();
        }

        public final int getStarts() {
            return this._builder.getStarts();
        }

        public final int getWins() {
            return this._builder.getWins();
        }

        public final void setSeq(int i2) {
            this._builder.setSeq(i2);
        }

        public final void setStarts(int i2) {
            this._builder.setStarts(i2);
        }

        public final void setWins(int i2) {
            this._builder.setWins(i2);
        }

        private Dsl(HeaderBiddingTokenOuterClass.TokenCounters.Builder builder) {
            this._builder = builder;
        }
    }

    private TokenCountersKt() {
    }
}
