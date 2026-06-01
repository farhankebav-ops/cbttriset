package androidx.emoji2.text.flatbuffer;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public class ArrayReadWriteBuf implements ReadWriteBuf {
    private byte[] buffer;
    private int writePos;

    public ArrayReadWriteBuf() {
        this(10);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadBuf
    public byte[] data() {
        return this.buffer;
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadBuf
    public byte get(int i2) {
        return this.buffer[i2];
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadBuf
    public boolean getBoolean(int i2) {
        return this.buffer[i2] != 0;
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadBuf
    public double getDouble(int i2) {
        return Double.longBitsToDouble(getLong(i2));
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadBuf
    public float getFloat(int i2) {
        return Float.intBitsToFloat(getInt(i2));
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadBuf
    public int getInt(int i2) {
        byte[] bArr = this.buffer;
        return (bArr[i2] & 255) | (bArr[i2 + 3] << 24) | ((bArr[i2 + 2] & 255) << 16) | ((bArr[i2 + 1] & 255) << 8);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadBuf
    public long getLong(int i2) {
        byte[] bArr = this.buffer;
        long j = (((long) bArr[i2]) & 255) | ((((long) bArr[i2 + 1]) & 255) << 8) | ((((long) bArr[i2 + 2]) & 255) << 16) | ((((long) bArr[i2 + 3]) & 255) << 24) | ((((long) bArr[i2 + 4]) & 255) << 32) | ((((long) bArr[i2 + 5]) & 255) << 40);
        return (((long) bArr[i2 + 7]) << 56) | j | ((255 & ((long) bArr[i2 + 6])) << 48);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadBuf
    public short getShort(int i2) {
        byte[] bArr = this.buffer;
        return (short) ((bArr[i2] & 255) | (bArr[i2 + 1] << 8));
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadBuf
    public String getString(int i2, int i8) {
        return Utf8Safe.decodeUtf8Array(this.buffer, i2, i8);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf, androidx.emoji2.text.flatbuffer.ReadBuf
    public int limit() {
        return this.writePos;
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void put(byte[] bArr, int i2, int i8) {
        set(this.writePos, bArr, i2, i8);
        this.writePos += i8;
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void putBoolean(boolean z2) {
        setBoolean(this.writePos, z2);
        this.writePos++;
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void putDouble(double d8) {
        setDouble(this.writePos, d8);
        this.writePos += 8;
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void putFloat(float f4) {
        setFloat(this.writePos, f4);
        this.writePos += 4;
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void putInt(int i2) {
        setInt(this.writePos, i2);
        this.writePos += 4;
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void putLong(long j) {
        setLong(this.writePos, j);
        this.writePos += 8;
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void putShort(short s7) {
        setShort(this.writePos, s7);
        this.writePos += 2;
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public boolean requestCapacity(int i2) {
        byte[] bArr = this.buffer;
        if (bArr.length > i2) {
            return true;
        }
        int length = bArr.length;
        this.buffer = Arrays.copyOf(bArr, length + (length >> 1));
        return true;
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void set(int i2, byte b8) {
        requestCapacity(i2 + 1);
        this.buffer[i2] = b8;
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void setBoolean(int i2, boolean z2) {
        set(i2, z2 ? (byte) 1 : (byte) 0);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void setDouble(int i2, double d8) {
        requestCapacity(i2 + 8);
        long jDoubleToRawLongBits = Double.doubleToRawLongBits(d8);
        int i8 = (int) jDoubleToRawLongBits;
        byte[] bArr = this.buffer;
        bArr[i2] = (byte) (i8 & 255);
        bArr[i2 + 1] = (byte) ((i8 >> 8) & 255);
        bArr[i2 + 2] = (byte) ((i8 >> 16) & 255);
        bArr[i2 + 3] = (byte) ((i8 >> 24) & 255);
        int i9 = (int) (jDoubleToRawLongBits >> 32);
        bArr[i2 + 4] = (byte) (i9 & 255);
        bArr[i2 + 5] = (byte) ((i9 >> 8) & 255);
        bArr[i2 + 6] = (byte) ((i9 >> 16) & 255);
        bArr[i2 + 7] = (byte) ((i9 >> 24) & 255);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void setFloat(int i2, float f4) {
        requestCapacity(i2 + 4);
        int iFloatToRawIntBits = Float.floatToRawIntBits(f4);
        byte[] bArr = this.buffer;
        bArr[i2] = (byte) (iFloatToRawIntBits & 255);
        bArr[i2 + 1] = (byte) ((iFloatToRawIntBits >> 8) & 255);
        bArr[i2 + 2] = (byte) ((iFloatToRawIntBits >> 16) & 255);
        bArr[i2 + 3] = (byte) ((iFloatToRawIntBits >> 24) & 255);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void setInt(int i2, int i8) {
        requestCapacity(i2 + 4);
        byte[] bArr = this.buffer;
        bArr[i2] = (byte) (i8 & 255);
        bArr[i2 + 1] = (byte) ((i8 >> 8) & 255);
        bArr[i2 + 2] = (byte) ((i8 >> 16) & 255);
        bArr[i2 + 3] = (byte) ((i8 >> 24) & 255);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void setLong(int i2, long j) {
        requestCapacity(i2 + 8);
        int i8 = (int) j;
        byte[] bArr = this.buffer;
        bArr[i2] = (byte) (i8 & 255);
        bArr[i2 + 1] = (byte) ((i8 >> 8) & 255);
        bArr[i2 + 2] = (byte) ((i8 >> 16) & 255);
        bArr[i2 + 3] = (byte) ((i8 >> 24) & 255);
        int i9 = (int) (j >> 32);
        bArr[i2 + 4] = (byte) (i9 & 255);
        bArr[i2 + 5] = (byte) ((i9 >> 8) & 255);
        bArr[i2 + 6] = (byte) ((i9 >> 16) & 255);
        bArr[i2 + 7] = (byte) ((i9 >> 24) & 255);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void setShort(int i2, short s7) {
        requestCapacity(i2 + 2);
        byte[] bArr = this.buffer;
        bArr[i2] = (byte) (s7 & 255);
        bArr[i2 + 1] = (byte) ((s7 >> 8) & 255);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public int writePosition() {
        return this.writePos;
    }

    public ArrayReadWriteBuf(int i2) {
        this(new byte[i2]);
    }

    public ArrayReadWriteBuf(byte[] bArr) {
        this.buffer = bArr;
        this.writePos = 0;
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void put(byte b8) {
        set(this.writePos, b8);
        this.writePos++;
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void set(int i2, byte[] bArr, int i8, int i9) {
        requestCapacity((i9 - i8) + i2);
        System.arraycopy(bArr, i8, this.buffer, i2, i9);
    }

    public ArrayReadWriteBuf(byte[] bArr, int i2) {
        this.buffer = bArr;
        this.writePos = i2;
    }
}
