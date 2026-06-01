package com.google.protobuf;

import com.google.protobuf.Duration;
import com.google.protobuf.DurationKt;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class DurationKtKt {
    /* JADX INFO: renamed from: -initializeduration, reason: not valid java name */
    public static final Duration m227initializeduration(e6.l block) {
        kotlin.jvm.internal.k.e(block, "block");
        DurationKt.Dsl.Companion companion = DurationKt.Dsl.Companion;
        Duration.Builder builderNewBuilder = Duration.newBuilder();
        kotlin.jvm.internal.k.d(builderNewBuilder, "newBuilder()");
        DurationKt.Dsl dsl_create = companion._create(builderNewBuilder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    public static final Duration copy(Duration duration, e6.l block) {
        kotlin.jvm.internal.k.e(duration, "<this>");
        kotlin.jvm.internal.k.e(block, "block");
        DurationKt.Dsl.Companion companion = DurationKt.Dsl.Companion;
        Duration.Builder builder = duration.toBuilder();
        kotlin.jvm.internal.k.d(builder, "this.toBuilder()");
        DurationKt.Dsl dsl_create = companion._create(builder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }
}
