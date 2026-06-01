package com.google.protobuf.kotlin;

import com.google.protobuf.ByteString;
import java.nio.ByteBuffer;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class ByteStringsKt {
    public static final byte get(ByteString byteString, int i2) {
        k.e(byteString, "<this>");
        return byteString.byteAt(i2);
    }

    public static final boolean isNotEmpty(ByteString byteString) {
        k.e(byteString, "<this>");
        return !byteString.isEmpty();
    }

    public static final ByteString plus(ByteString byteString, ByteString other) {
        k.e(byteString, "<this>");
        k.e(other, "other");
        ByteString byteStringConcat = byteString.concat(other);
        k.d(byteStringConcat, "concat(other)");
        return byteStringConcat;
    }

    public static final ByteString toByteString(byte[] bArr) {
        k.e(bArr, "<this>");
        ByteString byteStringCopyFrom = ByteString.copyFrom(bArr);
        k.d(byteStringCopyFrom, "copyFrom(this)");
        return byteStringCopyFrom;
    }

    public static final ByteString toByteStringUtf8(String str) {
        k.e(str, "<this>");
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8(str);
        k.d(byteStringCopyFromUtf8, "copyFromUtf8(this)");
        return byteStringCopyFromUtf8;
    }

    public static final ByteString toByteString(ByteBuffer byteBuffer) {
        k.e(byteBuffer, "<this>");
        ByteString byteStringCopyFrom = ByteString.copyFrom(byteBuffer);
        k.d(byteStringCopyFrom, "copyFrom(this)");
        return byteStringCopyFrom;
    }
}
