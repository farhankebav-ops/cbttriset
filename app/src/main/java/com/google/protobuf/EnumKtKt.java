package com.google.protobuf;

import com.google.protobuf.Enum;
import com.google.protobuf.EnumKt;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class EnumKtKt {
    /* JADX INFO: renamed from: -initializeenum, reason: not valid java name */
    public static final Enum m229initializeenum(e6.l block) {
        kotlin.jvm.internal.k.e(block, "block");
        EnumKt.Dsl.Companion companion = EnumKt.Dsl.Companion;
        Enum.Builder builderNewBuilder = Enum.newBuilder();
        kotlin.jvm.internal.k.d(builderNewBuilder, "newBuilder()");
        EnumKt.Dsl dsl_create = companion._create(builderNewBuilder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    public static final Enum copy(Enum r22, e6.l block) {
        kotlin.jvm.internal.k.e(r22, "<this>");
        kotlin.jvm.internal.k.e(block, "block");
        EnumKt.Dsl.Companion companion = EnumKt.Dsl.Companion;
        Enum.Builder builder = r22.toBuilder();
        kotlin.jvm.internal.k.d(builder, "this.toBuilder()");
        EnumKt.Dsl dsl_create = companion._create(builder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    public static final SourceContext getSourceContextOrNull(EnumOrBuilder enumOrBuilder) {
        kotlin.jvm.internal.k.e(enumOrBuilder, "<this>");
        if (enumOrBuilder.hasSourceContext()) {
            return enumOrBuilder.getSourceContext();
        }
        return null;
    }
}
