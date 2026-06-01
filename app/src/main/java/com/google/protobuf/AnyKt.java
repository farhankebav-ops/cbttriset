package com.google.protobuf;

import com.google.protobuf.Any;
import com.google.protobuf.kotlin.ProtoDslMarker;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class AnyKt {
    public static final AnyKt INSTANCE = new AnyKt();

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @ProtoDslMarker
    public static final class Dsl {
        public static final Companion Companion = new Companion(null);
        private final Any.Builder _builder;

        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class Companion {
            public /* synthetic */ Companion(kotlin.jvm.internal.f fVar) {
                this();
            }

            public final /* synthetic */ Dsl _create(Any.Builder builder) {
                kotlin.jvm.internal.k.e(builder, "builder");
                return new Dsl(builder, null);
            }

            private Companion() {
            }
        }

        public /* synthetic */ Dsl(Any.Builder builder, kotlin.jvm.internal.f fVar) {
            this(builder);
        }

        public final /* synthetic */ Any _build() {
            Any anyBuild = this._builder.build();
            kotlin.jvm.internal.k.d(anyBuild, "_builder.build()");
            return anyBuild;
        }

        public final void clearTypeUrl() {
            this._builder.clearTypeUrl();
        }

        public final void clearValue() {
            this._builder.clearValue();
        }

        public final String getTypeUrl() {
            String typeUrl = this._builder.getTypeUrl();
            kotlin.jvm.internal.k.d(typeUrl, "_builder.getTypeUrl()");
            return typeUrl;
        }

        public final ByteString getValue() {
            ByteString value = this._builder.getValue();
            kotlin.jvm.internal.k.d(value, "_builder.getValue()");
            return value;
        }

        public final void setTypeUrl(String value) {
            kotlin.jvm.internal.k.e(value, "value");
            this._builder.setTypeUrl(value);
        }

        public final void setValue(ByteString value) {
            kotlin.jvm.internal.k.e(value, "value");
            this._builder.setValue(value);
        }

        private Dsl(Any.Builder builder) {
            this._builder = builder;
        }
    }

    private AnyKt() {
    }
}
