package com.google.protobuf;

import com.google.protobuf.Type;
import com.google.protobuf.TypeKt;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class TypeKtKt {
    /* JADX INFO: renamed from: -initializetype, reason: not valid java name */
    public static final Type m245initializetype(e6.l block) {
        kotlin.jvm.internal.k.e(block, "block");
        TypeKt.Dsl.Companion companion = TypeKt.Dsl.Companion;
        Type.Builder builderNewBuilder = Type.newBuilder();
        kotlin.jvm.internal.k.d(builderNewBuilder, "newBuilder()");
        TypeKt.Dsl dsl_create = companion._create(builderNewBuilder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    public static final Type copy(Type type, e6.l block) {
        kotlin.jvm.internal.k.e(type, "<this>");
        kotlin.jvm.internal.k.e(block, "block");
        TypeKt.Dsl.Companion companion = TypeKt.Dsl.Companion;
        Type.Builder builder = type.toBuilder();
        kotlin.jvm.internal.k.d(builder, "this.toBuilder()");
        TypeKt.Dsl dsl_create = companion._create(builder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    public static final SourceContext getSourceContextOrNull(TypeOrBuilder typeOrBuilder) {
        kotlin.jvm.internal.k.e(typeOrBuilder, "<this>");
        if (typeOrBuilder.hasSourceContext()) {
            return typeOrBuilder.getSourceContext();
        }
        return null;
    }
}
