package com.unity3d.ads.datastore;

import com.google.protobuf.ByteString;
import com.google.protobuf.kotlin.ProtoDslMarker;
import com.unity3d.ads.datastore.ByteStringStoreOuterClass;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class ByteStringStoreKt {
    public static final ByteStringStoreKt INSTANCE = new ByteStringStoreKt();

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @ProtoDslMarker
    public static final class Dsl {
        public static final Companion Companion = new Companion(null);
        private final ByteStringStoreOuterClass.ByteStringStore.Builder _builder;

        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class Companion {
            public /* synthetic */ Companion(f fVar) {
                this();
            }

            public final /* synthetic */ Dsl _create(ByteStringStoreOuterClass.ByteStringStore.Builder builder) {
                k.e(builder, "builder");
                return new Dsl(builder, null);
            }

            private Companion() {
            }
        }

        public /* synthetic */ Dsl(ByteStringStoreOuterClass.ByteStringStore.Builder builder, f fVar) {
            this(builder);
        }

        public final /* synthetic */ ByteStringStoreOuterClass.ByteStringStore _build() {
            ByteStringStoreOuterClass.ByteStringStore byteStringStoreBuild = this._builder.build();
            k.d(byteStringStoreBuild, "_builder.build()");
            return byteStringStoreBuild;
        }

        public final void clearData() {
            this._builder.clearData();
        }

        public final ByteString getData() {
            ByteString data = this._builder.getData();
            k.d(data, "_builder.getData()");
            return data;
        }

        public final void setData(ByteString value) {
            k.e(value, "value");
            this._builder.setData(value);
        }

        private Dsl(ByteStringStoreOuterClass.ByteStringStore.Builder builder) {
            this._builder = builder;
        }
    }

    private ByteStringStoreKt() {
    }
}
