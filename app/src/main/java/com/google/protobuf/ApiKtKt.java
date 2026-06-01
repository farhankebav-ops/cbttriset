package com.google.protobuf;

import com.google.protobuf.Api;
import com.google.protobuf.ApiKt;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class ApiKtKt {
    /* JADX INFO: renamed from: -initializeapi, reason: not valid java name */
    public static final Api m223initializeapi(e6.l block) {
        kotlin.jvm.internal.k.e(block, "block");
        ApiKt.Dsl.Companion companion = ApiKt.Dsl.Companion;
        Api.Builder builderNewBuilder = Api.newBuilder();
        kotlin.jvm.internal.k.d(builderNewBuilder, "newBuilder()");
        ApiKt.Dsl dsl_create = companion._create(builderNewBuilder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    public static final Api copy(Api api, e6.l block) {
        kotlin.jvm.internal.k.e(api, "<this>");
        kotlin.jvm.internal.k.e(block, "block");
        ApiKt.Dsl.Companion companion = ApiKt.Dsl.Companion;
        Api.Builder builder = api.toBuilder();
        kotlin.jvm.internal.k.d(builder, "this.toBuilder()");
        ApiKt.Dsl dsl_create = companion._create(builder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    public static final SourceContext getSourceContextOrNull(ApiOrBuilder apiOrBuilder) {
        kotlin.jvm.internal.k.e(apiOrBuilder, "<this>");
        if (apiOrBuilder.hasSourceContext()) {
            return apiOrBuilder.getSourceContext();
        }
        return null;
    }
}
