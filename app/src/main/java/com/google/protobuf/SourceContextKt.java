package com.google.protobuf;

import com.google.protobuf.SourceContext;
import com.google.protobuf.kotlin.ProtoDslMarker;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class SourceContextKt {
    public static final SourceContextKt INSTANCE = new SourceContextKt();

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @ProtoDslMarker
    public static final class Dsl {
        public static final Companion Companion = new Companion(null);
        private final SourceContext.Builder _builder;

        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class Companion {
            public /* synthetic */ Companion(kotlin.jvm.internal.f fVar) {
                this();
            }

            public final /* synthetic */ Dsl _create(SourceContext.Builder builder) {
                kotlin.jvm.internal.k.e(builder, "builder");
                return new Dsl(builder, null);
            }

            private Companion() {
            }
        }

        public /* synthetic */ Dsl(SourceContext.Builder builder, kotlin.jvm.internal.f fVar) {
            this(builder);
        }

        public final /* synthetic */ SourceContext _build() {
            SourceContext sourceContextBuild = this._builder.build();
            kotlin.jvm.internal.k.d(sourceContextBuild, "_builder.build()");
            return sourceContextBuild;
        }

        public final void clearFileName() {
            this._builder.clearFileName();
        }

        public final String getFileName() {
            String fileName = this._builder.getFileName();
            kotlin.jvm.internal.k.d(fileName, "_builder.getFileName()");
            return fileName;
        }

        public final void setFileName(String value) {
            kotlin.jvm.internal.k.e(value, "value");
            this._builder.setFileName(value);
        }

        private Dsl(SourceContext.Builder builder) {
            this._builder = builder;
        }
    }

    private SourceContextKt() {
    }
}
