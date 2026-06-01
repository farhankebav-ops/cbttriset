package com.google.protobuf;

import com.google.protobuf.FloatValue;
import com.google.protobuf.FloatValueKt;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class FloatValueKtKt {
    /* JADX INFO: renamed from: -initializefloatValue, reason: not valid java name */
    public static final FloatValue m234initializefloatValue(e6.l block) {
        kotlin.jvm.internal.k.e(block, "block");
        FloatValueKt.Dsl.Companion companion = FloatValueKt.Dsl.Companion;
        FloatValue.Builder builderNewBuilder = FloatValue.newBuilder();
        kotlin.jvm.internal.k.d(builderNewBuilder, "newBuilder()");
        FloatValueKt.Dsl dsl_create = companion._create(builderNewBuilder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    public static final FloatValue copy(FloatValue floatValue, e6.l block) {
        kotlin.jvm.internal.k.e(floatValue, "<this>");
        kotlin.jvm.internal.k.e(block, "block");
        FloatValueKt.Dsl.Companion companion = FloatValueKt.Dsl.Companion;
        FloatValue.Builder builder = floatValue.toBuilder();
        kotlin.jvm.internal.k.d(builder, "this.toBuilder()");
        FloatValueKt.Dsl dsl_create = companion._create(builder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }
}
