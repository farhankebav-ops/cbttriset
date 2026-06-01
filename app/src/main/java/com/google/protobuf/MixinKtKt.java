package com.google.protobuf;

import com.google.protobuf.Mixin;
import com.google.protobuf.MixinKt;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class MixinKtKt {
    /* JADX INFO: renamed from: -initializemixin, reason: not valid java name */
    public static final Mixin m239initializemixin(e6.l block) {
        kotlin.jvm.internal.k.e(block, "block");
        MixinKt.Dsl.Companion companion = MixinKt.Dsl.Companion;
        Mixin.Builder builderNewBuilder = Mixin.newBuilder();
        kotlin.jvm.internal.k.d(builderNewBuilder, "newBuilder()");
        MixinKt.Dsl dsl_create = companion._create(builderNewBuilder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    public static final Mixin copy(Mixin mixin, e6.l block) {
        kotlin.jvm.internal.k.e(mixin, "<this>");
        kotlin.jvm.internal.k.e(block, "block");
        MixinKt.Dsl.Companion companion = MixinKt.Dsl.Companion;
        Mixin.Builder builder = mixin.toBuilder();
        kotlin.jvm.internal.k.d(builder, "this.toBuilder()");
        MixinKt.Dsl dsl_create = companion._create(builder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }
}
