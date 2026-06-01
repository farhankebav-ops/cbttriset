package androidx.camera.core.impl.utils;

import java.io.ByteArrayInputStream;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteOrder;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
final class ByteOrderedDataInputStream extends InputStream implements DataInput {
    private ByteOrder mByteOrder;
    private final DataInputStream mDataInputStream;
    final int mLength;
    int mPosition;
    private static final ByteOrder LITTLE_ENDIAN = ByteOrder.LITTLE_ENDIAN;
    private static final ByteOrder BIG_ENDIAN = ByteOrder.BIG_ENDIAN;

    public ByteOrderedDataInputStream(InputStream inputStream) throws IOException {
        this(inputStream, ByteOrder.BIG_ENDIAN);
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        return this.mDataInputStream.available();
    }

    public int getLength() {
        return this.mLength;
    }

    @Override // java.io.InputStream
    public void mark(int i2) {
        synchronized (this.mDataInputStream) {
            this.mDataInputStream.mark(i2);
        }
    }

    public int peek() {
        return this.mPosition;
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        this.mPosition++;
        return this.mDataInputStream.read();
    }

    @Override // java.io.DataInput
    public boolean readBoolean() throws IOException {
        this.mPosition++;
        return this.mDataInputStream.readBoolean();
    }

    @Override // java.io.DataInput
    public byte readByte() throws IOException {
        int i2 = this.mPosition + 1;
        this.mPosition = i2;
        if (i2 > this.mLength) {
            throw new EOFException();
        }
        int i8 = this.mDataInputStream.read();
        if (i8 >= 0) {
            return (byte) i8;
        }
        throw new EOFException();
    }

    @Override // java.io.DataInput
    public char readChar() throws IOException {
        this.mPosition += 2;
        return this.mDataInputStream.readChar();
    }

    @Override // java.io.DataInput
    public double readDouble() throws IOException {
        return Double.longBitsToDouble(readLong());
    }

    @Override // java.io.DataInput
    public float readFloat() throws IOException {
        return Float.intBitsToFloat(readInt());
    }

    @Override // java.io.DataInput
    public void readFully(byte[] bArr, int i2, int i8) throws IOException {
        int i9 = this.mPosition + i8;
        this.mPosition = i9;
        if (i9 > this.mLength) {
            throw new EOFException();
        }
        if (this.mDataInputStream.read(bArr, i2, i8) != i8) {
            throw new IOException("Couldn't read up to the length of buffer");
        }
    }

    @Override // java.io.DataInput
    public int readInt() throws IOException {
        int i2 = this.mPosition + 4;
        this.mPosition = i2;
        if (i2 > this.mLength) {
            throw new EOFException();
        }
        int i8 = this.mDataInputStream.read();
        int i9 = this.mDataInputStream.read();
        int i10 = this.mDataInputStream.read();
        int i11 = this.mDataInputStream.read();
        if ((i8 | i9 | i10 | i11) < 0) {
            throw new EOFException();
        }
        ByteOrder byteOrder = this.mByteOrder;
        if (byteOrder == LITTLE_ENDIAN) {
            return (i11 << 24) + (i10 << 16) + (i9 << 8) + i8;
        }
        if (byteOrder == BIG_ENDIAN) {
            return (i8 << 24) + (i9 << 16) + (i10 << 8) + i11;
        }
        throw new IOException("Invalid byte order: " + this.mByteOrder);
    }

    @Override // java.io.DataInput
    public String readLine() {
        throw new UnsupportedOperationException("readLine() not implemented.");
    }

    @Override // java.io.DataInput
    public long readLong() throws IOException {
        int i2 = this.mPosition + 8;
        this.mPosition = i2;
        if (i2 > this.mLength) {
            throw new EOFException();
        }
        int i8 = this.mDataInputStream.read();
        int i9 = this.mDataInputStream.read();
        int i10 = this.mDataInputStream.read();
        int i11 = this.mDataInputStream.read();
        int i12 = this.mDataInputStream.read();
        int i13 = this.mDataInputStream.read();
        int i14 = this.mDataInputStream.read();
        int i15 = this.mDataInputStream.read();
        if ((i8 | i9 | i10 | i11 | i12 | i13 | i14 | i15) < 0) {
            throw new EOFException();
        }
        ByteOrder byteOrder = this.mByteOrder;
        if (byteOrder == LITTLE_ENDIAN) {
            return (((long) i15) << 56) + (((long) i14) << 48) + (((long) i13) << 40) + (((long) i12) << 32) + (((long) i11) << 24) + (((long) i10) << 16) + (((long) i9) << 8) + ((long) i8);
        }
        if (byteOrder == BIG_ENDIAN) {
            return (((long) i8) << 56) + (((long) i9) << 48) + (((long) i10) << 40) + (((long) i11) << 32) + (((long) i12) << 24) + (((long) i13) << 16) + (((long) i14) << 8) + ((long) i15);
        }
        throw new IOException("Invalid byte order: " + this.mByteOrder);
    }

    @Override // java.io.DataInput
    public short readShort() throws IOException {
        int i2 = this.mPosition + 2;
        this.mPosition = i2;
        if (i2 > this.mLength) {
            throw new EOFException();
        }
        int i8 = this.mDataInputStream.read();
        int i9 = this.mDataInputStream.read();
        if ((i8 | i9) < 0) {
            throw new EOFException();
        }
        ByteOrder byteOrder = this.mByteOrder;
        if (byteOrder == LITTLE_ENDIAN) {
            return (short) ((i9 << 8) + i8);
        }
        if (byteOrder == BIG_ENDIAN) {
            return (short) ((i8 << 8) + i9);
        }
        throw new IOException("Invalid byte order: " + this.mByteOrder);
    }

    @Override // java.io.DataInput
    public String readUTF() throws IOException {
        this.mPosition += 2;
        return this.mDataInputStream.readUTF();
    }

    @Override // java.io.DataInput
    public int readUnsignedByte() throws IOException {
        this.mPosition++;
        return this.mDataInputStream.readUnsignedByte();
    }

    public long readUnsignedInt() throws IOException {
        return ((long) readInt()) & 4294967295L;
    }

    @Override // java.io.DataInput
    public int readUnsignedShort() throws IOException {
        int i2 = this.mPosition + 2;
        this.mPosition = i2;
        if (i2 > this.mLength) {
            throw new EOFException();
        }
        int i8 = this.mDataInputStream.read();
        int i9 = this.mDataInputStream.read();
        if ((i8 | i9) < 0) {
            throw new EOFException();
        }
        ByteOrder byteOrder = this.mByteOrder;
        if (byteOrder == LITTLE_ENDIAN) {
            return (i9 << 8) + i8;
        }
        if (byteOrder == BIG_ENDIAN) {
            return (i8 << 8) + i9;
        }
        throw new IOException("Invalid byte order: " + this.mByteOrder);
    }

    public void seek(long j) throws IOException {
        int i2 = this.mPosition;
        if (i2 > j) {
            this.mPosition = 0;
            this.mDataInputStream.reset();
            this.mDataInputStream.mark(this.mLength);
        } else {
            j -= (long) i2;
        }
        int i8 = (int) j;
        if (skipBytes(i8) != i8) {
            throw new IOException("Couldn't seek up to the byteCount");
        }
    }

    public void setByteOrder(ByteOrder byteOrder) {
        this.mByteOrder = byteOrder;
    }

    @Override // java.io.DataInput
    public int skipBytes(int i2) throws IOException {
        int iMin = Math.min(i2, this.mLength - this.mPosition);
        int iSkipBytes = 0;
        while (iSkipBytes < iMin) {
            iSkipBytes += this.mDataInputStream.skipBytes(iMin - iSkipBytes);
        }
        this.mPosition += iSkipBytes;
        return iSkipBytes;
    }

    public ByteOrderedDataInputStream(InputStream inputStream, ByteOrder byteOrder) throws IOException {
        this.mByteOrder = ByteOrder.BIG_ENDIAN;
        DataInputStream dataInputStream = new DataInputStream(inputStream);
        this.mDataInputStream = dataInputStream;
        int iAvailable = dataInputStream.available();
        this.mLength = iAvailable;
        this.mPosition = 0;
        dataInputStream.mark(iAvailable);
        this.mByteOrder = byteOrder;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i2, int i8) throws IOException {
        int i9 = this.mDataInputStream.read(bArr, i2, i8);
        this.mPosition += i9;
        return i9;
    }

    @Override // java.io.DataInput
    public void readFully(byte[] bArr) throws IOException {
        int length = this.mPosition + bArr.length;
        this.mPosition = length;
        if (length <= this.mLength) {
            if (this.mDataInputStream.read(bArr, 0, bArr.length) != bArr.length) {
                throw new IOException("Couldn't read up to the length of buffer");
            }
            return;
        }
        throw new EOFException();
    }

    public ByteOrderedDataInputStream(byte[] bArr) throws IOException {
        this(new ByteArrayInputStream(bArr));
    }
}
