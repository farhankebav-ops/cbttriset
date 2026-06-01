package com.unity3d.ads.core.extensions;

import android.util.Base64;
import com.google.protobuf.ByteString;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.UUID;
import kotlin.jvm.internal.k;
import n6.a;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class ProtobufExtensionsKt {
    private static final int URL_SAFE_AND_NO_WRAP = 10;

    public static final ByteString fromBase64(String str, boolean z2) {
        k.e(str, "<this>");
        ByteString byteStringCopyFrom = ByteString.copyFrom(Base64.decode(str, z2 ? 10 : 2));
        k.d(byteStringCopyFrom, "copyFrom(android.util.Base64.decode(this, flag))");
        return byteStringCopyFrom;
    }

    public static /* synthetic */ ByteString fromBase64$default(String str, boolean z2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z2 = false;
        }
        return fromBase64(str, z2);
    }

    public static final String toBase64(ByteString byteString, boolean z2) {
        k.e(byteString, "<this>");
        String strEncodeToString = Base64.encodeToString(byteString.toByteArray(), z2 ? 10 : 2);
        k.d(strEncodeToString, "encodeToString(this.toByteArray(), flag)");
        return strEncodeToString;
    }

    public static /* synthetic */ String toBase64$default(ByteString byteString, boolean z2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z2 = false;
        }
        return toBase64(byteString, z2);
    }

    public static final ByteString toByteString(UUID uuid) {
        k.e(uuid, "<this>");
        ByteString byteStringCopyFrom = ByteString.copyFrom(ByteBuffer.wrap(new byte[16]).order(ByteOrder.BIG_ENDIAN).putLong(uuid.getMostSignificantBits()).putLong(uuid.getLeastSignificantBits()).array());
        k.d(byteStringCopyFrom, "copyFrom(bytes.array())");
        return byteStringCopyFrom;
    }

    public static final ByteString toISO8859ByteString(String str) {
        k.e(str, "<this>");
        byte[] bytes = str.getBytes(a.f13076d);
        k.d(bytes, "this as java.lang.String).getBytes(charset)");
        ByteString byteStringCopyFrom = ByteString.copyFrom(bytes);
        k.d(byteStringCopyFrom, "copyFrom(this.toByteArray(Charsets.ISO_8859_1))");
        return byteStringCopyFrom;
    }

    public static final String toISO8859String(ByteString byteString) {
        k.e(byteString, "<this>");
        String string = byteString.toString(a.f13076d);
        k.d(string, "this.toString(Charsets.ISO_8859_1)");
        return string;
    }

    public static final UUID toUUID(ByteString byteString) {
        k.e(byteString, "<this>");
        ByteBuffer byteBufferAsReadOnlyByteBuffer = byteString.asReadOnlyByteBuffer();
        k.d(byteBufferAsReadOnlyByteBuffer, "this.asReadOnlyByteBuffer()");
        if (byteBufferAsReadOnlyByteBuffer.remaining() == 36) {
            UUID uuidFromString = UUID.fromString(byteString.toStringUtf8());
            k.d(uuidFromString, "fromString(uuidString)");
            return uuidFromString;
        }
        if (byteBufferAsReadOnlyByteBuffer.remaining() == 16) {
            return new UUID(byteBufferAsReadOnlyByteBuffer.getLong(), byteBufferAsReadOnlyByteBuffer.getLong());
        }
        throw new IllegalArgumentException("Expected 16 byte ByteString or UUID string");
    }
}
