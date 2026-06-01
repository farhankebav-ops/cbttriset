package com.google.protobuf;

import com.google.protobuf.Field;
import com.google.protobuf.FieldKt;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class FieldKtKt {
    /* JADX INFO: renamed from: -initializefield, reason: not valid java name */
    public static final Field m231initializefield(e6.l block) {
        kotlin.jvm.internal.k.e(block, "block");
        FieldKt.Dsl.Companion companion = FieldKt.Dsl.Companion;
        Field.Builder builderNewBuilder = Field.newBuilder();
        kotlin.jvm.internal.k.d(builderNewBuilder, "newBuilder()");
        FieldKt.Dsl dsl_create = companion._create(builderNewBuilder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    public static final Field copy(Field field, e6.l block) {
        kotlin.jvm.internal.k.e(field, "<this>");
        kotlin.jvm.internal.k.e(block, "block");
        FieldKt.Dsl.Companion companion = FieldKt.Dsl.Companion;
        Field.Builder builder = field.toBuilder();
        kotlin.jvm.internal.k.d(builder, "this.toBuilder()");
        FieldKt.Dsl dsl_create = companion._create(builder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }
}
