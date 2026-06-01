package com.pgl.ssdk;

import java.io.IOException;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class m implements q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final FileChannel f10788a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f10789b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f10790c;

    public m(FileChannel fileChannel, long j, long j3) {
        if (j < 0) {
            throw new IndexOutOfBoundsException("offset: ".concat(String.valueOf(j3)));
        }
        if (j3 < 0) {
            throw new IndexOutOfBoundsException("size: ".concat(String.valueOf(j3)));
        }
        this.f10788a = fileChannel;
        this.f10789b = j;
        this.f10790c = j3;
    }

    @Override // com.pgl.ssdk.q
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public m a(long j, long j3) {
        long jA = a();
        a(j, j3, jA);
        return (j == 0 && j3 == jA) ? this : new m(this.f10788a, this.f10789b + j, j3);
    }

    private static void a(long j, long j3, long j8) {
        if (j < 0) {
            throw new IndexOutOfBoundsException("offset: ".concat(String.valueOf(j)));
        }
        if (j3 < 0) {
            throw new IndexOutOfBoundsException("size: ".concat(String.valueOf(j3)));
        }
        if (j > j8) {
            throw new IndexOutOfBoundsException(a1.a.p(androidx.camera.core.processing.util.a.t("offset (", j, ") > source size ("), j8, ")"));
        }
        long j9 = j + j3;
        if (j9 < j) {
            throw new IndexOutOfBoundsException(a1.a.p(androidx.camera.core.processing.util.a.t("offset (", j, ") + size ("), j3, ") overflow"));
        }
        if (j9 <= j8) {
            return;
        }
        StringBuilder sbT = androidx.camera.core.processing.util.a.t("offset (", j, ") + size (");
        sbT.append(j3);
        sbT.append(") > source size (");
        sbT.append(j8);
        sbT.append(")");
        throw new IndexOutOfBoundsException(sbT.toString());
    }

    @Override // com.pgl.ssdk.q
    public long a() {
        long j = this.f10790c;
        if (j != -1) {
            return j;
        }
        try {
            return this.f10788a.size();
        } catch (IOException unused) {
            return 0L;
        }
    }

    public void a(long j, int i2, ByteBuffer byteBuffer) throws IOException {
        int i8;
        a(j, i2, a());
        if (i2 == 0) {
            return;
        }
        if (i2 <= byteBuffer.remaining()) {
            long j3 = this.f10789b + j;
            int iLimit = byteBuffer.limit();
            try {
                byteBuffer.limit(byteBuffer.position() + i2);
                while (i2 > 0) {
                    synchronized (this.f10788a) {
                        this.f10788a.position(j3);
                        i8 = this.f10788a.read(byteBuffer);
                    }
                    j3 += (long) i8;
                    i2 -= i8;
                }
                return;
            } finally {
                byteBuffer.limit(iLimit);
            }
        }
        throw new BufferOverflowException();
    }

    @Override // com.pgl.ssdk.q
    public ByteBuffer a(long j, int i2) throws IOException {
        if (i2 >= 0) {
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(i2);
            a(j, i2, byteBufferAllocate);
            byteBufferAllocate.flip();
            return byteBufferAllocate;
        }
        throw new IndexOutOfBoundsException("size: ".concat(String.valueOf(i2)));
    }
}
