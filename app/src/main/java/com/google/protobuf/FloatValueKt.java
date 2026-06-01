package com.google.protobuf;

import com.google.protobuf.FloatValue;
import com.google.protobuf.kotlin.ProtoDslMarker;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class FloatValueKt {
    public static final FloatValueKt INSTANCE = new FloatValueKt();

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @ProtoDslMarker
    public static final class Dsl {
        public static final Companion Companion = new Companion(null);
        private final FloatValue.Builder _builder;

        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class Companion {
            public /* synthetic */ Companion(kotlin.jvm.internal.f fVar) {
                this();
            }

            public final /* synthetic */ Dsl _create(FloatValue.Builder builder) {
                kotlin.jvm.internal.k.e(builder, "builder");
                return new Dsl(builder, null);
            }

            private Companion() {
            }
        }

        public /* synthetic */ Dsl(FloatValue.Builder builder, kotlin.jvm.internal.f fVar) {
            this(builder);
        }

        public final /* synthetic */ FloatValue _build() {
            FloatValue floatValueBuild = this._builder.build();
            kotlin.jvm.internal.k.d(floatValueBuild, "_builder.build()");
            return floatValueBuild;
        }

        public final void clearValue() {
            this._builder.clearValue();
        }

        public final float getValue() {
            return this._builder.getValue();
        }

        public final void setValue(float f4) {
            this._builder.setValue(f4);
        }

        private Dsl(FloatValue.Builder builder) {
            this._builder = builder;
        }
    }

    private FloatValueKt() {
    }
}
