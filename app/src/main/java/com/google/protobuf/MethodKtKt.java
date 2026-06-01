package com.google.protobuf;

import com.google.protobuf.Method;
import com.google.protobuf.MethodKt;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class MethodKtKt {
    /* JADX INFO: renamed from: -initializemethod, reason: not valid java name */
    public static final Method m238initializemethod(e6.l block) {
        kotlin.jvm.internal.k.e(block, "block");
        MethodKt.Dsl.Companion companion = MethodKt.Dsl.Companion;
        Method.Builder builderNewBuilder = Method.newBuilder();
        kotlin.jvm.internal.k.d(builderNewBuilder, "newBuilder()");
        MethodKt.Dsl dsl_create = companion._create(builderNewBuilder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    public static final Method copy(Method method, e6.l block) {
        kotlin.jvm.internal.k.e(method, "<this>");
        kotlin.jvm.internal.k.e(block, "block");
        MethodKt.Dsl.Companion companion = MethodKt.Dsl.Companion;
        Method.Builder builder = method.toBuilder();
        kotlin.jvm.internal.k.d(builder, "this.toBuilder()");
        MethodKt.Dsl dsl_create = companion._create(builder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }
}
