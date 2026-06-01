package com.google.protobuf;

import com.google.protobuf.BoolValue;
import com.google.protobuf.kotlin.ProtoDslMarker;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class BoolValueKt {
    public static final BoolValueKt INSTANCE = new BoolValueKt();

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @ProtoDslMarker
    public static final class Dsl {
        public static final Companion Companion = new Companion(null);
        private final BoolValue.Builder _builder;

        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class Companion {
            public /* synthetic */ Companion(kotlin.jvm.internal.f fVar) {
                this();
            }

            public final /* synthetic */ Dsl _create(BoolValue.Builder builder) {
                kotlin.jvm.internal.k.e(builder, "builder");
                return new Dsl(builder, null);
            }

            private Companion() {
            }
        }

        public /* synthetic */ Dsl(BoolValue.Builder builder, kotlin.jvm.internal.f fVar) {
            this(builder);
        }

        public final /* synthetic */ BoolValue _build() {
            BoolValue boolValueBuild = this._builder.build();
            kotlin.jvm.internal.k.d(boolValueBuild, "_builder.build()");
            return boolValueBuild;
        }

        public final void clearValue() {
            this._builder.clearValue();
        }

        public final boolean getValue() {
            return this._builder.getValue();
        }

        public final void setValue(boolean z2) {
            this._builder.setValue(z2);
        }

        private Dsl(BoolValue.Builder builder) {
            this._builder = builder;
        }
    }

    private BoolValueKt() {
    }
}
