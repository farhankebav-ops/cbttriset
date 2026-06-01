package androidx.camera.core.impl.utils;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteOrder;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
class ByteOrderedDataOutputStream extends FilterOutputStream {
    private ByteOrder mByteOrder;
    final OutputStream mOutputStream;

    public ByteOrderedDataOutputStream(OutputStream outputStream, ByteOrder byteOrder) {
        super(outputStream);
        this.mOutputStream = outputStream;
        this.mByteOrder = byteOrder;
    }

    public void setByteOrder(ByteOrder byteOrder) {
        this.mByteOrder = byteOrder;
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] bArr) throws IOException {
        this.mOutputStream.write(bArr);
    }

    public void writeByte(int i2) throws IOException {
        this.mOutputStream.write(i2);
    }

    public void writeInt(int i2) throws IOException {
        ByteOrder byteOrder = this.mByteOrder;
        if (byteOrder == ByteOrder.LITTLE_ENDIAN) {
            this.mOutputStream.write(i2 & 255);
            this.mOutputStream.write((i2 >>> 8) & 255);
            this.mOutputStream.write((i2 >>> 16) & 255);
            this.mOutputStream.write((i2 >>> 24) & 255);
            return;
        }
        if (byteOrder == ByteOrder.BIG_ENDIAN) {
            this.mOutputStream.write((i2 >>> 24) & 255);
            this.mOutputStream.write((i2 >>> 16) & 255);
            this.mOutputStream.write((i2 >>> 8) & 255);
            this.mOutputStream.write(i2 & 255);
        }
    }

    public void writeShort(short s7) throws IOException {
        ByteOrder byteOrder = this.mByteOrder;
        if (byteOrder == ByteOrder.LITTLE_ENDIAN) {
            this.mOutputStream.write(s7 & 255);
            this.mOutputStream.write((s7 >>> 8) & 255);
        } else if (byteOrder == ByteOrder.BIG_ENDIAN) {
            this.mOutputStream.write((s7 >>> 8) & 255);
            this.mOutputStream.write(s7 & 255);
        }
    }

    public void writeUnsignedInt(long j) throws IOException {
        writeInt((int) j);
    }

    public void writeUnsignedShort(int i2) throws IOException {
        writeShort((short) i2);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] bArr, int i2, int i8) throws IOException {
        this.mOutputStream.write(bArr, i2, i8);
    }
}
