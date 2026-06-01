package com.google.protobuf;

import com.google.protobuf.Option;
import com.google.protobuf.OptionKt;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class OptionKtKt {
    /* JADX INFO: renamed from: -initializeoption, reason: not valid java name */
    public static final Option m240initializeoption(e6.l block) {
        kotlin.jvm.internal.k.e(block, "block");
        OptionKt.Dsl.Companion companion = OptionKt.Dsl.Companion;
        Option.Builder builderNewBuilder = Option.newBuilder();
        kotlin.jvm.internal.k.d(builderNewBuilder, "newBuilder()");
        OptionKt.Dsl dsl_create = companion._create(builderNewBuilder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    public static final Option copy(Option option, e6.l block) {
        kotlin.jvm.internal.k.e(option, "<this>");
        kotlin.jvm.internal.k.e(block, "block");
        OptionKt.Dsl.Companion companion = OptionKt.Dsl.Companion;
        Option.Builder builder = option.toBuilder();
        kotlin.jvm.internal.k.d(builder, "this.toBuilder()");
        OptionKt.Dsl dsl_create = companion._create(builder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    public static final Any getValueOrNull(OptionOrBuilder optionOrBuilder) {
        kotlin.jvm.internal.k.e(optionOrBuilder, "<this>");
        if (optionOrBuilder.hasValue()) {
            return optionOrBuilder.getValue();
        }
        return null;
    }
}
