package com.pgl.ssdk;

import com.pgl.ssdk.d;
import java.io.IOException;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final char[] f10763a = "0123456789abcdef".toCharArray();

    public static i a(q qVar, t tVar, int i2) throws j, IOException {
        try {
            d.a aVarA = d.a(qVar, tVar);
            long jB = aVarA.b();
            q qVarA = aVarA.a();
            ByteBuffer byteBufferA = qVarA.a(0L, (int) qVarA.a());
            byteBufferA.order(ByteOrder.LITTLE_ENDIAN);
            return new i(a(byteBufferA, i2), jB, tVar.a(), tVar.e(), tVar.d());
        } catch (b e) {
            throw new j(e.getMessage(), e);
        }
    }

    private static ByteBuffer b(ByteBuffer byteBuffer, int i2) {
        if (i2 < 0) {
            throw new IllegalArgumentException("size: ".concat(String.valueOf(i2)));
        }
        int iLimit = byteBuffer.limit();
        int iPosition = byteBuffer.position();
        int i8 = i2 + iPosition;
        if (i8 < iPosition || i8 > iLimit) {
            throw new BufferUnderflowException();
        }
        byteBuffer.limit(i8);
        try {
            ByteBuffer byteBufferSlice = byteBuffer.slice();
            byteBufferSlice.order(byteBuffer.order());
            byteBuffer.position(i8);
            return byteBufferSlice;
        } finally {
            byteBuffer.limit(iLimit);
        }
    }

    public static byte[] c(ByteBuffer byteBuffer) throws a {
        int i2 = byteBuffer.getInt();
        if (i2 < 0) {
            throw new a("Negative length");
        }
        if (i2 <= byteBuffer.remaining()) {
            byte[] bArr = new byte[i2];
            byteBuffer.get(bArr);
            return bArr;
        }
        StringBuilder sbV = a1.a.v(i2, "Underflow while reading length-prefixed value. Length: ", ", available: ");
        sbV.append(byteBuffer.remaining());
        throw new a(sbV.toString());
    }

    public static ByteBuffer b(ByteBuffer byteBuffer) throws a {
        if (byteBuffer.remaining() >= 4) {
            int i2 = byteBuffer.getInt();
            if (i2 >= 0) {
                if (i2 <= byteBuffer.remaining()) {
                    return b(byteBuffer, i2);
                }
                StringBuilder sbV = a1.a.v(i2, "Length-prefixed field longer than remaining buffer. Field length: ", ", remaining: ");
                sbV.append(byteBuffer.remaining());
                throw new a(sbV.toString());
            }
            throw new IllegalArgumentException("Negative length");
        }
        throw new a("Remaining buffer too short to contain length of length-prefixed field. Remaining: " + byteBuffer.remaining());
    }

    public static ByteBuffer a(ByteBuffer byteBuffer, int i2) throws j {
        a(byteBuffer);
        ByteBuffer byteBufferA = a(byteBuffer, 8, byteBuffer.capacity() - 24);
        int i8 = 0;
        while (byteBufferA.hasRemaining()) {
            i8++;
            if (byteBufferA.remaining() >= 8) {
                long j = byteBufferA.getLong();
                if (j >= 4 && j <= 2147483647L) {
                    int i9 = (int) j;
                    int iPosition = byteBufferA.position() + i9;
                    if (i9 <= byteBufferA.remaining()) {
                        if (byteBufferA.getInt() == i2) {
                            return b(byteBufferA, i9 - 4);
                        }
                        byteBufferA.position(iPosition);
                    } else {
                        StringBuilder sbW = a1.a.w(i8, "APK Signing Block entry #", " size out of range: ", i9, ", available: ");
                        sbW.append(byteBufferA.remaining());
                        throw new j(sbW.toString());
                    }
                } else {
                    throw new j("APK Signing Block entry #" + i8 + " size out of range: " + j);
                }
            } else {
                throw new j("Insufficient data to read size of APK Signing Block entry #".concat(String.valueOf(i8)));
            }
        }
        throw new j("No APK Signature Scheme block in APK Signing Block with ID: ".concat(String.valueOf(i2)));
    }

    public static void a(ByteBuffer byteBuffer) {
        if (byteBuffer.order() != ByteOrder.LITTLE_ENDIAN) {
            throw new IllegalArgumentException("ByteBuffer byte order must be little endian");
        }
    }

    private static ByteBuffer a(ByteBuffer byteBuffer, int i2, int i8) {
        if (i2 < 0) {
            throw new IllegalArgumentException("start: ".concat(String.valueOf(i2)));
        }
        if (i8 >= i2) {
            int iCapacity = byteBuffer.capacity();
            if (i8 <= byteBuffer.capacity()) {
                int iLimit = byteBuffer.limit();
                int iPosition = byteBuffer.position();
                try {
                    byteBuffer.position(0);
                    byteBuffer.limit(i8);
                    byteBuffer.position(i2);
                    ByteBuffer byteBufferSlice = byteBuffer.slice();
                    byteBufferSlice.order(byteBuffer.order());
                    return byteBufferSlice;
                } finally {
                    byteBuffer.position(0);
                    byteBuffer.limit(iLimit);
                    byteBuffer.position(iPosition);
                }
            }
            throw new IllegalArgumentException(androidx.camera.core.processing.util.a.i("end > capacity: ", i8, " > ", iCapacity));
        }
        throw new IllegalArgumentException(androidx.camera.core.processing.util.a.i("end < start: ", i8, " < ", i2));
    }
}
