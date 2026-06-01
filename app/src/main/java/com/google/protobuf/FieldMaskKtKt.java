package com.google.protobuf;

import com.google.protobuf.FieldMask;
import com.google.protobuf.FieldMaskKt;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class FieldMaskKtKt {
    /* JADX INFO: renamed from: -initializefieldMask, reason: not valid java name */
    public static final FieldMask m232initializefieldMask(e6.l block) {
        kotlin.jvm.internal.k.e(block, "block");
        FieldMaskKt.Dsl.Companion companion = FieldMaskKt.Dsl.Companion;
        FieldMask.Builder builderNewBuilder = FieldMask.newBuilder();
        kotlin.jvm.internal.k.d(builderNewBuilder, "newBuilder()");
        FieldMaskKt.Dsl dsl_create = companion._create(builderNewBuilder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    public static final FieldMask copy(FieldMask fieldMask, e6.l block) {
        kotlin.jvm.internal.k.e(fieldMask, "<this>");
        kotlin.jvm.internal.k.e(block, "block");
        FieldMaskKt.Dsl.Companion companion = FieldMaskKt.Dsl.Companion;
        FieldMask.Builder builder = fieldMask.toBuilder();
        kotlin.jvm.internal.k.d(builder, "this.toBuilder()");
        FieldMaskKt.Dsl dsl_create = companion._create(builder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }
}
