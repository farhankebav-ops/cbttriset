package com.google.protobuf;

import com.google.protobuf.Struct;
import com.google.protobuf.kotlin.DslMap;
import com.google.protobuf.kotlin.DslProxy;
import com.google.protobuf.kotlin.ProtoDslMarker;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class StructKt {
    public static final StructKt INSTANCE = new StructKt();

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @ProtoDslMarker
    public static final class Dsl {
        public static final Companion Companion = new Companion(null);
        private final Struct.Builder _builder;

        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class Companion {
            public /* synthetic */ Companion(kotlin.jvm.internal.f fVar) {
                this();
            }

            public final /* synthetic */ Dsl _create(Struct.Builder builder) {
                kotlin.jvm.internal.k.e(builder, "builder");
                return new Dsl(builder, null);
            }

            private Companion() {
            }
        }

        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class FieldsProxy extends DslProxy {
            private FieldsProxy() {
            }
        }

        public /* synthetic */ Dsl(Struct.Builder builder, kotlin.jvm.internal.f fVar) {
            this(builder);
        }

        public final /* synthetic */ Struct _build() {
            Struct structBuild = this._builder.build();
            kotlin.jvm.internal.k.d(structBuild, "_builder.build()");
            return structBuild;
        }

        public final /* synthetic */ void clearFields(DslMap dslMap) {
            kotlin.jvm.internal.k.e(dslMap, "<this>");
            this._builder.clearFields();
        }

        public final /* synthetic */ DslMap getFieldsMap() {
            Map<String, Value> fieldsMap = this._builder.getFieldsMap();
            kotlin.jvm.internal.k.d(fieldsMap, "_builder.getFieldsMap()");
            return new DslMap(fieldsMap);
        }

        public final /* synthetic */ void putAllFields(DslMap dslMap, Map map) {
            kotlin.jvm.internal.k.e(dslMap, "<this>");
            kotlin.jvm.internal.k.e(map, "map");
            this._builder.putAllFields(map);
        }

        public final void putFields(DslMap<String, Value, FieldsProxy> dslMap, String key, Value value) {
            kotlin.jvm.internal.k.e(dslMap, "<this>");
            kotlin.jvm.internal.k.e(key, "key");
            kotlin.jvm.internal.k.e(value, "value");
            this._builder.putFields(key, value);
        }

        public final /* synthetic */ void removeFields(DslMap dslMap, String key) {
            kotlin.jvm.internal.k.e(dslMap, "<this>");
            kotlin.jvm.internal.k.e(key, "key");
            this._builder.removeFields(key);
        }

        public final /* synthetic */ void setFields(DslMap<String, Value, FieldsProxy> dslMap, String key, Value value) {
            kotlin.jvm.internal.k.e(dslMap, "<this>");
            kotlin.jvm.internal.k.e(key, "key");
            kotlin.jvm.internal.k.e(value, "value");
            putFields(dslMap, key, value);
        }

        private Dsl(Struct.Builder builder) {
            this._builder = builder;
        }
    }

    private StructKt() {
    }
}
