package com.google.protobuf.kotlin;

import com.google.protobuf.ExtensionLite;
import com.google.protobuf.GeneratedMessageLite;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class ExtendableMessageLiteExtensionsKt {
    public static final <M extends GeneratedMessageLite.ExtendableMessage<M, ?>, MorBT extends GeneratedMessageLite.ExtendableMessageOrBuilder<M, ?>> boolean contains(MorBT morbt, ExtensionLite<M, ?> extension) {
        k.e(morbt, "<this>");
        k.e(extension, "extension");
        return morbt.hasExtension(extension);
    }

    public static final <M extends GeneratedMessageLite.ExtendableMessage<M, ?>, MOrBT extends GeneratedMessageLite.ExtendableMessageOrBuilder<M, ?>, T> T get(MOrBT morbt, ExtensionLite<M, T> extension) {
        k.e(morbt, "<this>");
        k.e(extension, "extension");
        T t3 = (T) morbt.getExtension(extension);
        k.d(t3, "getExtension(extension)");
        return t3;
    }

    public static final <M extends GeneratedMessageLite.ExtendableMessage<M, B>, B extends GeneratedMessageLite.ExtendableBuilder<M, B>, T> void set(B b8, ExtensionLite<M, T> extension, T value) {
        k.e(b8, "<this>");
        k.e(extension, "extension");
        k.e(value, "value");
        b8.setExtension(extension, value);
    }
}
