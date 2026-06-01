package com.google.protobuf;

import com.google.protobuf.StringValue;
import com.google.protobuf.kotlin.ProtoDslMarker;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class StringValueKt {
    public static final StringValueKt INSTANCE = new StringValueKt();

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @ProtoDslMarker
    public static final class Dsl {
        public static final Companion Companion = new Companion(null);
        private final StringValue.Builder _builder;

        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class Companion {
            public /* synthetic */ Companion(kotlin.jvm.internal.f fVar) {
                this();
            }

            public final /* synthetic */ Dsl _create(StringValue.Builder builder) {
                kotlin.jvm.internal.k.e(builder, "builder");
                return new Dsl(builder, null);
            }

            private Companion() {
            }
        }

        public /* synthetic */ Dsl(StringValue.Builder builder, kotlin.jvm.internal.f fVar) {
            this(builder);
        }

        public final /* synthetic */ StringValue _build() {
            StringValue stringValueBuild = this._builder.build();
            kotlin.jvm.internal.k.d(stringValueBuild, "_builder.build()");
            return stringValueBuild;
        }

        public final void clearValue() {
            this._builder.clearValue();
        }

        public final String getValue() {
            String value = this._builder.getValue();
            kotlin.jvm.internal.k.d(value, "_builder.getValue()");
            return value;
        }

        public final void setValue(String value) {
            kotlin.jvm.internal.k.e(value, "value");
            this._builder.setValue(value);
        }

        private Dsl(StringValue.Builder builder) {
            this._builder = builder;
        }
    }

    private StringValueKt() {
    }
}
